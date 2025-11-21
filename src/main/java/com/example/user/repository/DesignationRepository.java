package com.example.user.repository;


import com.example.user.entity.Designation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DesignationRepository extends JpaRepository<Designation, UUID> {
    Designation findByDescription(String description);

    @Query(value = "SELECT u FROM Designation u WHERE u.status = 1",nativeQuery = true)
    List<Designation> findAllActiveDesignationNative();
}
