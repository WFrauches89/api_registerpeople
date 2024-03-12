package com.meuscursos.api.apiregisterpeople.model;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Generated("jsonschema2pojo")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    private String cep;
    private String logradouro;
    private String bairro;
    private String uf;

}
