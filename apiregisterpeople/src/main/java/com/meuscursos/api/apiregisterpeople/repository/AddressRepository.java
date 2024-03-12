package com.meuscursos.api.apiregisterpeople.repository;

import com.meuscursos.api.apiregisterpeople.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {
}
