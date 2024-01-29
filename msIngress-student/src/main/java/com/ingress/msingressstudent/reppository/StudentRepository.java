package com.ingress.msingressstudent.reppository;

import com.ingress.msingressstudent.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, Integer> {
}
