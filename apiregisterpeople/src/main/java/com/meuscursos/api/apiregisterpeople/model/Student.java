package com.meuscursos.api.apiregisterpeople.model;

import com.meuscursos.api.apiregisterpeople.enums.StudentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userName;

    @Column(unique = true)
    private String email;

    @Column
    private String pass;

    @Column(unique = true, nullable = false)
    private String cpf;

    @Column(nullable = false)
    private String name;

    @Column
    private String lastName;

    @Column
    private LocalDate birthDate;


    @Column(nullable = false)
    @CreationTimestamp
    private LocalDate registerDate;


    @JoinColumn
    @ManyToOne
    private Address address;

    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn
    private List<Phone> phones;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StudentType studentType;

}
