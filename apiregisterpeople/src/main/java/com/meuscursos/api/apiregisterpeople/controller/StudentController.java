package com.meuscursos.api.apiregisterpeople.controller;

import com.meuscursos.api.apiregisterpeople.dto.request.StudentDTO;
import com.meuscursos.api.apiregisterpeople.dto.response.MessageResponseDTO;
import com.meuscursos.api.apiregisterpeople.exceptions.StudentNotFoundException;
import com.meuscursos.api.apiregisterpeople.service.StudentService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v01/student")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentController {
// +++
    private StudentService studentService;

    @GetMapping("/{id}")
    public StudentDTO findById(@PathVariable Long id) throws StudentNotFoundException {
        return studentService.findById(id);
    }

    @GetMapping
    public List<StudentDTO> findAll() {
        return studentService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createStudent(@RequestBody @Valid StudentDTO studentDTO){
        return studentService.createStudent(studentDTO);
    }

    @PutMapping("/{id}")
//    @ResponseStatus(HttpStatus.ACCEPTED)
    public MessageResponseDTO updateStudent(@PathVariable Long id, @RequestBody @Valid StudentDTO studentDTO) throws StudentNotFoundException {
        return studentService.updateStudent(id, studentDTO);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudent(Long id) throws StudentNotFoundException {
        studentService.deleteStudent(id);
    }

}
