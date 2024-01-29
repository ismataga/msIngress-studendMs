package com.ingress.msingressstudent.mappper;

import com.ingress.msingressstudent.entity.StudentEntity;
import com.ingress.msingressstudent.model.request.StudentRequest;
import com.ingress.msingressstudent.model.response.StudentResponse;
import java.util.List;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentEntity requestToEntity(StudentRequest studentRequest);

    StudentResponse entityToResponse(StudentEntity studentEntity);

    List<StudentResponse> responseToEntityList(List<StudentEntity> studentEntity);
}
