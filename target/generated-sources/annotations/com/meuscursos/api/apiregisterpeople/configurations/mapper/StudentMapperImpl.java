package com.meuscursos.api.apiregisterpeople.configurations.mapper;

import com.meuscursos.api.apiregisterpeople.dto.request.PhoneDTO;
import com.meuscursos.api.apiregisterpeople.dto.request.StudentDTO;
import com.meuscursos.api.apiregisterpeople.model.Phone;
import com.meuscursos.api.apiregisterpeople.model.Student;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-03-12T10:59:07-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
public class StudentMapperImpl implements StudentMapper {

    private final DateTimeFormatter dateTimeFormatter_dd_MM_yyyy_1156787200 = DateTimeFormatter.ofPattern( "dd-MM-yyyy" );

    @Override
    public Student toModel(StudentDTO studentDTO) {
        if ( studentDTO == null ) {
            return null;
        }

        Student.StudentBuilder student = Student.builder();

        if ( studentDTO.getBirthDate() != null ) {
            student.birthDate( LocalDate.parse( studentDTO.getBirthDate(), dateTimeFormatter_dd_MM_yyyy_1156787200 ) );
        }
        if ( studentDTO.getRegisterDate() != null ) {
            student.registerDate( LocalDate.parse( studentDTO.getRegisterDate(), dateTimeFormatter_dd_MM_yyyy_1156787200 ) );
        }
        student.id( studentDTO.getId() );
        student.userName( studentDTO.getUserName() );
        student.email( studentDTO.getEmail() );
        student.cpf( studentDTO.getCpf() );
        student.name( studentDTO.getName() );
        student.lastName( studentDTO.getLastName() );
        student.address( studentDTO.getAddress() );
        student.phones( phoneDTOListToPhoneList( studentDTO.getPhones() ) );
        student.studentType( studentDTO.getStudentType() );

        return student.build();
    }

    @Override
    public StudentDTO toDTO(Student student) {
        if ( student == null ) {
            return null;
        }

        StudentDTO.StudentDTOBuilder studentDTO = StudentDTO.builder();

        studentDTO.id( student.getId() );
        studentDTO.userName( student.getUserName() );
        studentDTO.email( student.getEmail() );
        studentDTO.name( student.getName() );
        studentDTO.lastName( student.getLastName() );
        studentDTO.cpf( student.getCpf() );
        if ( student.getRegisterDate() != null ) {
            studentDTO.registerDate( DateTimeFormatter.ISO_LOCAL_DATE.format( student.getRegisterDate() ) );
        }
        if ( student.getBirthDate() != null ) {
            studentDTO.birthDate( DateTimeFormatter.ISO_LOCAL_DATE.format( student.getBirthDate() ) );
        }
        studentDTO.phones( phoneListToPhoneDTOList( student.getPhones() ) );
        studentDTO.address( student.getAddress() );
        studentDTO.studentType( student.getStudentType() );

        return studentDTO.build();
    }

    protected Phone phoneDTOToPhone(PhoneDTO phoneDTO) {
        if ( phoneDTO == null ) {
            return null;
        }

        Phone.PhoneBuilder phone = Phone.builder();

        phone.id( phoneDTO.getId() );
        phone.type( phoneDTO.getType() );
        phone.number( phoneDTO.getNumber() );

        return phone.build();
    }

    protected List<Phone> phoneDTOListToPhoneList(List<PhoneDTO> list) {
        if ( list == null ) {
            return null;
        }

        List<Phone> list1 = new ArrayList<Phone>( list.size() );
        for ( PhoneDTO phoneDTO : list ) {
            list1.add( phoneDTOToPhone( phoneDTO ) );
        }

        return list1;
    }

    protected PhoneDTO phoneToPhoneDTO(Phone phone) {
        if ( phone == null ) {
            return null;
        }

        PhoneDTO.PhoneDTOBuilder phoneDTO = PhoneDTO.builder();

        phoneDTO.id( phone.getId() );
        phoneDTO.type( phone.getType() );
        phoneDTO.number( phone.getNumber() );

        return phoneDTO.build();
    }

    protected List<PhoneDTO> phoneListToPhoneDTOList(List<Phone> list) {
        if ( list == null ) {
            return null;
        }

        List<PhoneDTO> list1 = new ArrayList<PhoneDTO>( list.size() );
        for ( Phone phone : list ) {
            list1.add( phoneToPhoneDTO( phone ) );
        }

        return list1;
    }
}
