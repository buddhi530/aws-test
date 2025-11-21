package com.example.user.service;


import com.example.user.dto.DepartmentDesignationDTO;
import com.example.user.utils.CommonResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface DepartmentDesignationService {

    ResponseEntity<CommonResponse> saveDepartmentAndDesignation(DepartmentDesignationDTO dto);
    ResponseEntity<CommonResponse> getAllDepartment();
    ResponseEntity<CommonResponse> getAllDesignation();

}
