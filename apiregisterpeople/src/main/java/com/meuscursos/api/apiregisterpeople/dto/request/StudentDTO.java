package com.meuscursos.api.apiregisterpeople.dto.request;

import com.meuscursos.api.apiregisterpeople.enums.StudentType;
import com.meuscursos.api.apiregisterpeople.model.Address;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {


    private Long id;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String userName;


    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;


    @NotEmpty
    @Size(min = 2, max = 100)
    private String lastName;

    @NotEmpty
    @CPF
    private String cpf;

    @DateTimeFormat
    private String registerDate;

    @DateTimeFormat
    private String birthDate;

    @Valid
    @NotEmpty
    private List<PhoneDTO> phones;

    @Valid
    @NotEmpty
    private Address address;

    @Enumerated(EnumType.STRING)
    private StudentType studentType;
}
