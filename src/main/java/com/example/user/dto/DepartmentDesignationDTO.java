package com.example.user.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDesignationDTO {
    private String id;
    private String type;
    private String description;
    private boolean status;
    private String createdBy;
    private String modifiedBy;
}
