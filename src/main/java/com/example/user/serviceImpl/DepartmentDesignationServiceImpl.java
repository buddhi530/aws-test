package com.example.user.serviceImpl;

import com.example.user.dto.DepartmentDesignationDTO;
import com.example.user.entity.Department;
import com.example.user.entity.Designation;
import com.example.user.repository.DepartmentRepository;
import com.example.user.repository.DesignationRepository;
import com.example.user.service.DepartmentDesignationService;
import com.example.user.utils.CommonResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DepartmentDesignationServiceImpl implements DepartmentDesignationService {

    private DepartmentRepository departmentRepository;

    private DesignationRepository designationRepository;



    @Autowired
    public DepartmentDesignationServiceImpl(DepartmentRepository departmentRepository, DesignationRepository designationRepository) {
        this.departmentRepository = departmentRepository;
        this.designationRepository = designationRepository;
    }


    @Override
    public ResponseEntity<CommonResponse> saveDepartmentAndDesignation(DepartmentDesignationDTO dto) {
        log.info("Start saveDepartmentAndDesignation method with DepartmentDesignationDTO: " + dto);
        CommonResponse commonResponse = new CommonResponse();
        if ((dto.getType().equals("Department") && isDepartmentByDesc(dto.getDescription()))
                || (dto.getType().equals("Designation") && isDesignationByDesc(dto.getDescription()))){
            commonResponse.setStatus(-1);
            commonResponse.setErrorMessages(Collections.singletonList("Department / Designation already exist"));
            return new ResponseEntity<>(commonResponse,HttpStatus.CREATED);
        }
        if (dto.getType().equals("Department")){
            Department department = departmentRepository.save(new Department(
                    dto.getType(),
                    dto.getDescription(),
                    dto.isStatus(),
                    dto.getCreatedBy(),
                    new Date(),
                    dto.getCreatedBy(),
                    new Date()
            ));
           // this.maintainDepartmentLogHistory(department,"save");
            commonResponse.setPayload(Collections.singletonList(department));
            commonResponse.setStatus(1);

        }
        if (dto.getType().equals("Designation")){
            Designation designation = designationRepository.save(new Designation(
                    dto.getType(),
                    dto.getDescription(),
                    dto.isStatus(),
                    dto.getCreatedBy(),
                    new Date(),
                    dto.getCreatedBy(),
                    new Date()
            ));
            //this.maintainDesignationLogHistory(designation,"save");
            commonResponse.setPayload(Collections.singletonList(designation));
            commonResponse.setStatus(1);
        }

        log.info("End saveDepartmentAndDesignation method");
        return new ResponseEntity<>(commonResponse,HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity<CommonResponse> getAllDepartment() {
        log.info("Start getAllDepartment method");
        CommonResponse commonResponse = new CommonResponse();
        List<Department> departmentList = departmentRepository.findAllActiveDepartmentNative();
        if (departmentList.isEmpty()){
            commonResponse.setStatus(-1);
            commonResponse.setErrorMessages(Collections.singletonList("Not found department"));
            return new ResponseEntity<>(commonResponse,HttpStatus.NOT_FOUND);
        }
        commonResponse.setStatus(1);
        commonResponse.setPayload(Collections.singletonList(departmentList));
        log.info("End getAllDepartment method");
        return new ResponseEntity<>(commonResponse,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<CommonResponse> getAllDesignation() {
        log.info("Start getAllDesignation method");
        CommonResponse commonResponse = new CommonResponse();
        List<Designation> designationList = designationRepository.findAllActiveDesignationNative();
        if (designationList.isEmpty()){
            commonResponse.setStatus(-1);
            commonResponse.setErrorMessages(Collections.singletonList("Not found designation"));
            return new ResponseEntity<>(commonResponse,HttpStatus.NOT_FOUND);
        }
        commonResponse.setStatus(1);
        commonResponse.setPayload(Collections.singletonList(designationList));
        log.info("End getAllDesignation method");
        return new ResponseEntity<>(commonResponse,HttpStatus.OK);
    }

    public boolean isDepartmentByDesc(String description) {
        Boolean isExist = false;
        Department department = departmentRepository.findByDescription(description);
        if (department != null) {
            isExist = true;
        }
        return isExist;
    }
    public boolean isDesignationByDesc(String description) {
        Boolean isExist = false;
        Designation designation = designationRepository.findByDescription(description);
        if (designation != null) {
            isExist = true;
        }
        return isExist;
    }

}
