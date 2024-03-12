package com.meuscursos.api.apiregisterpeople.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StudentType {

    NERD("Nerd"),
    CLOWN("Joãozinho"),
    CLUELESS("Sem noção"),
    BULLY("Bulinador"),
    STAR("Estrelinha"),
    SLACKER("Preguiçoso"),
    LEADER("Mandão"),
    LATECOMER("Retardatário");

    private final String description;

}
