package pe.dfp.codechallenge.repository;

import pe.dfp.codechallenge.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    Optional<Student> findById(Long id);
    void save(Student alumno);
    List<Student> findAllByEstado(boolean estado);
}