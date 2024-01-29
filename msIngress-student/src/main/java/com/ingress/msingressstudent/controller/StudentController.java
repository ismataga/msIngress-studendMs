package com.ingress.msingressstudent.controller;

import com.ingress.msingressstudent.model.request.StudentRequest;
import com.ingress.msingressstudent.model.response.StudentResponse;
import com.ingress.msingressstudent.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest) {
        return studentService.addStudent(studentRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getAllStudent() {
        return studentService.getAllStudent();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse getStudent(@PathVariable int id) {
        return studentService.getStudent(id);
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse updateStudent(@PathVariable int id, @RequestBody StudentRequest studentRequest) {
        return studentService.updateStudent(id,studentRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse deleteStudent(@PathVariable int id){
       return studentService.deleteStudent(id);
    }
}
