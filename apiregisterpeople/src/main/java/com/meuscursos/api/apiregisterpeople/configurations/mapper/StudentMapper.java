package com.meuscursos.api.apiregisterpeople.configurations.mapper;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.meuscursos.api.apiregisterpeople.dto.request.StudentDTO;
import com.meuscursos.api.apiregisterpeople.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.time.format.DateTimeFormatter;
import java.util.logging.SimpleFormatter;

@Mapper
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    @Mapping(target = "registerDate", source = "registerDate", dateFormat = "dd-MM-yyyy")
    Student toModel(StudentDTO studentDTO);

    StudentDTO toDTO(Student student);
}