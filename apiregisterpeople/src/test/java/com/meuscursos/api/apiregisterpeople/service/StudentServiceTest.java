package com.meuscursos.api.apiregisterpeople.service;


import com.meuscursos.api.apiregisterpeople.dto.request.StudentDTO;
import com.meuscursos.api.apiregisterpeople.dto.response.MessageResponseDTO;
import com.meuscursos.api.apiregisterpeople.model.Student;
import com.meuscursos.api.apiregisterpeople.repository.StudentRepository;
import com.meuscursos.api.apiregisterpeople.service.implement.StudentServiceImplement;
import com.meuscursos.api.apiregisterpeople.utils.StudentUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static com.meuscursos.api.apiregisterpeople.utils.StudentUtils.createFakeDTO;
import static com.meuscursos.api.apiregisterpeople.utils.StudentUtils.createFakeEntity;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
//
//    @InjectMocks
//    private StudentServiceImplement studentService;
//
//    @Mock
//    private StudentRepository studentRepository;
//
//    @Test
//    void testGivenStudentDTOThenReturnSaveMessage() {
//        StudentDTO studentDTO = createFakeDTO();
//        Student expectedSavedStudent = createFakeEntity();
//
//        when(studentRepository.save(any(Student.class))).thenReturn(expectedSavedStudent);
//
//        MessageResponseDTO expectedSuccessMessage = getStudentCreatedWithId(expectedSavedStudent.getId());
//
//        MessageResponseDTO successMessage = studentService.createStudent(studentDTO);
//
//        assertEquals(expectedSavedStudent,successMessage);
//
//    }
//
//    private static MessageResponseDTO getStudentCreatedWithId(Long id) {
//        return MessageResponseDTO
//                .builder()
//                .message("Student created with ID"+ id)
//                .build();
//    }
}
