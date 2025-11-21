package com.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "designation")
public class Designation {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    private UUID id;

    private String type;

    private String description;
    private boolean status;

    private String createdBy;

    private Date createdDate;

    private String modifiedBy;


    private Date updatedDate;

    public Designation(String type, String description, boolean status, String createdBy, Date createdDateTime,
                       String modifiedBy, Date modifiedDateTime) {
        this.type = type;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.createdDate = createdDateTime;
        this.modifiedBy = modifiedBy;
        this.updatedDate = modifiedDateTime;
    }
}
