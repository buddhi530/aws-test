package com.example.user.controller;



import com.example.user.dto.DepartmentDesignationDTO;
import com.example.user.service.DepartmentDesignationService;
import com.example.user.utils.CommonResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin("*")
@RequestMapping("/api/v1/department")
public class DepartmentDesignationController {

    private DepartmentDesignationService service;

    public DepartmentDesignationController(DepartmentDesignationService service) {
        this.service = service;
    }

    @PostMapping("/departmentAndDesignation")
    public ResponseEntity<CommonResponse> saveDepartmentAndDesignation(@RequestBody DepartmentDesignationDTO dto){
        log.info("Start saveDepartmentAndDesignation method with DepartmentDesignationDTO: " + dto);
        ResponseEntity<CommonResponse> responseEntity = null;
        CommonResponse commonResponse = new CommonResponse();
        try {
            responseEntity = service.saveDepartmentAndDesignation(dto);
        } catch (Exception ex) {
            commonResponse.setStatus(HttpStatus.EXPECTATION_FAILED.value());
            commonResponse.setErrorMessages(Collections.singletonList(ex.getMessage()));
            log.error(ex.getMessage());
            return new ResponseEntity<>(commonResponse, HttpStatus.EXPECTATION_FAILED);
        }
        log.info("End saveDepartmentAndDesignation method");
        return responseEntity;
    }


    @GetMapping("/departments")
    public ResponseEntity<CommonResponse> getAllDepartment(){
        log.info("Start getAllDepartment method");
        ResponseEntity<CommonResponse> responseEntity = null;
        CommonResponse commonResponse = new CommonResponse();
        try {
            responseEntity = service.getAllDepartment();
        } catch (Exception ex) {
            commonResponse.setStatus(HttpStatus.EXPECTATION_FAILED.value());
            commonResponse.setErrorMessages(Collections.singletonList(ex.getMessage()));
            log.error(ex.getMessage());
            return new ResponseEntity<>(commonResponse, HttpStatus.EXPECTATION_FAILED);
        }
        log.info("End getAllDepartment method");
        return responseEntity;
    }

    @GetMapping("/designations")
    public ResponseEntity<CommonResponse> getAllDesignation(){
        log.info("Start getAllDesignation method");
        ResponseEntity<CommonResponse> responseEntity = null;
        CommonResponse commonResponse = new CommonResponse();
        try {
            responseEntity = service.getAllDesignation();
        } catch (Exception ex) {
            commonResponse.setStatus(HttpStatus.EXPECTATION_FAILED.value());
            commonResponse.setErrorMessages(Collections.singletonList(ex.getMessage()));
            log.error(ex.getMessage());
            return new ResponseEntity<>(commonResponse, HttpStatus.EXPECTATION_FAILED);
        }
        log.info("End getAllDesignation method");
        return responseEntity;
    }

    @GetMapping("/checkapi")
    public String checkApi(){
        log.info("Start checkApi method");

        return "docker check";
    }

}

