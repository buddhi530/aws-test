package com.example.user.repository;


import com.example.user.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {

    Department findByDescription(String description);

    @Query(value = "SELECT u FROM Department u WHERE u.status = 1",nativeQuery = true)
    List<Department> findAllActiveDepartmentNative();
}
