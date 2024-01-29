package com.ingress.msingressstudent.service;

import com.ingress.msingressstudent.entity.StudentEntity;
import com.ingress.msingressstudent.mappper.StudentMapper;
import com.ingress.msingressstudent.model.request.StudentRequest;
import com.ingress.msingressstudent.model.response.StudentResponse;
import com.ingress.msingressstudent.reppository.StudentRepository;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentResponse addStudent(StudentRequest studentRequest) {
        StudentEntity studentEntity = studentMapper.requestToEntity(studentRequest);
        studentRepository.save(studentEntity);
        return studentMapper.entityToResponse(studentEntity);
    }

    public List<StudentResponse> getAllStudent() {
        List<StudentEntity> studentEntity = studentRepository.findAll();
        return studentMapper.responseToEntityList(studentEntity);
    }

    public StudentResponse getStudent(int id) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not find"));
        return studentMapper.entityToResponse(studentEntity);
    }

    public StudentResponse updateStudent(int id, StudentRequest studentRequest) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not find"));

        if (Objects.nonNull(studentRequest.getAge())) {
            studentEntity.setAge(studentRequest.getAge());
        }

        if (Objects.nonNull(studentRequest.getName())) {
            studentEntity.setName(studentRequest.getName());
        }

        if (Objects.nonNull(studentRequest.getEmail())) {
            studentEntity.setEmail(studentRequest.getEmail());
        }
        studentRepository.save(studentEntity);
        return studentMapper.entityToResponse(studentEntity);
    }

    public StudentResponse deleteStudent(int id) {
        StudentEntity studentEntity = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not find"));
        studentRepository.delete(studentEntity);
        return studentMapper.entityToResponse(studentEntity);
    }
}
