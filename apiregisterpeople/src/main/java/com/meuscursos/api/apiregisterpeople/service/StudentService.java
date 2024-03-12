package com.meuscursos.api.apiregisterpeople.service;

import com.meuscursos.api.apiregisterpeople.dto.request.StudentDTO;
import com.meuscursos.api.apiregisterpeople.dto.response.MessageResponseDTO;
import com.meuscursos.api.apiregisterpeople.exceptions.StudentNotFoundException;


import java.util.List;

public interface StudentService {

    StudentDTO findById(Long id) throws StudentNotFoundException;
    List<StudentDTO> findAll();
    MessageResponseDTO createStudent(StudentDTO studentDTO);
    void deleteStudent(Long id) throws StudentNotFoundException;
    MessageResponseDTO updateStudent(Long id, StudentDTO studentDTO) throws StudentNotFoundException;

}
