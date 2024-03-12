package com.meuscursos.api.apiregisterpeople.service;

import com.meuscursos.api.apiregisterpeople.model.Address;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "viacep", url = "https://viacep.com.br/ws")
public interface ViaCepService {

        @GetMapping("/{cep}/json/")
        Address searchCep(@PathVariable("cep") String cep);
}