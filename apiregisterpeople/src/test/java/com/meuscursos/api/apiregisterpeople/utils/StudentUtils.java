package com.meuscursos.api.apiregisterpeople.utils;

import com.meuscursos.api.apiregisterpeople.dto.request.StudentDTO;
import com.meuscursos.api.apiregisterpeople.model.Student;

import java.time.LocalDate;
import java.util.Collections;

public class StudentUtils {

    private static final String FIRST_NAME = "Rodrigo";
    private static final String USER_NAME = "Rodrigo";
    private static final String EMAIL_STD = "rodrigop@email.com";
    private static final String LAST_NAME = "Peleias";

    private static final String CPF_NUMBER = "369.333.878-79";
    private static final long PERSON_ID = 1L;
    public static final LocalDate BIRTH_DATE = LocalDate.of(2010, 10, 1);
    public static final LocalDate REGISTER_DATE = LocalDate.of(2024, 3, 12);


    public static StudentDTO createFakeDTO() {
        return StudentDTO.builder()
                .userName(USER_NAME)
                .name(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .email(EMAIL_STD)
                .registerDate("12-03-2024")
                .birthDate("04-04-2010")
                .phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
                .build();
    }

    public static Student createFakeEntity() {
        return Student.builder()
                .id(PERSON_ID)
                .name(FIRST_NAME)
                .lastName(LAST_NAME)
                .cpf(CPF_NUMBER)
                .birthDate(BIRTH_DATE)
                .registerDate(REGISTER_DATE)
                .email(EMAIL_STD)
                .phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
                .build();
    }
}
