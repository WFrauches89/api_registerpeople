package com.meuscursos.api.apiregisterpeople.repository;

import com.meuscursos.api.apiregisterpeople.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
