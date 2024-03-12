package com.meuscursos.api.apiregisterpeople.service.implement;

import com.meuscursos.api.apiregisterpeople.dto.request.StudentDTO;
import com.meuscursos.api.apiregisterpeople.dto.response.MessageResponseDTO;
import com.meuscursos.api.apiregisterpeople.exceptions.StudentNotFoundException;
import com.meuscursos.api.apiregisterpeople.configurations.mapper.StudentMapper;
import com.meuscursos.api.apiregisterpeople.model.Address;
import com.meuscursos.api.apiregisterpeople.model.Student;
import com.meuscursos.api.apiregisterpeople.repository.AddressRepository;
import com.meuscursos.api.apiregisterpeople.repository.StudentRepository;
import com.meuscursos.api.apiregisterpeople.service.StudentService;
import com.meuscursos.api.apiregisterpeople.service.ViaCepService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class StudentServiceImplement implements StudentService {

    private StudentRepository studentRepository;

    private final StudentMapper studentMapper = StudentMapper.INSTANCE;

    private ViaCepService viaCepService;

    private AddressRepository addressRepository;


    @Override
    public List<StudentDTO> findAll() {
        List<Student> allStudent = studentRepository.findAll();
        return allStudent.stream()
                .map(studentMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StudentDTO findById(Long id) throws StudentNotFoundException {
        Student studentByID = getStudentByIDifExists(id);
        return studentMapper.toDTO(studentByID);
    }

    @Override
    public MessageResponseDTO createStudent(StudentDTO studentDTO) {
        getSaveZipCode(studentDTO);
        Student studentToSave = studentMapper.toModel(studentDTO);
        Student studentSaved = studentRepository.save(studentToSave);
        return createMessageResponse(studentSaved.getId(), "Student created with ID");
    }



    @Override
    public void deleteStudent(Long id) throws StudentNotFoundException {
        getStudentByIDifExists(id);
        studentRepository.deleteById(id);
    }

    @Override
    public MessageResponseDTO updateStudent(Long id, StudentDTO studentDTO) throws StudentNotFoundException {
        getStudentByIDifExists(id);
        getSaveZipCode(studentDTO);

        Student studentToUpdate = studentMapper.toModel(studentDTO);
        Student studentUpdated = studentRepository.save(studentToUpdate);
        return createMessageResponse(studentUpdated.getId(),"Student updated by ID");
    }

    private Student getStudentByIDifExists(Long id) throws StudentNotFoundException {
        return studentRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }
    private MessageResponseDTO createMessageResponse(Long id, String message) {
        return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
    }

    private void getSaveZipCode(StudentDTO studentDTO) {
        String cep = studentDTO.getAddress().getCep();
        Address address = addressRepository.findById(cep).orElseGet(() -> {
            Address newAddress = viaCepService.searchCep(cep);
            addressRepository.save(newAddress);
            return newAddress;
        });
        studentDTO.setAddress(address);
    }
}
