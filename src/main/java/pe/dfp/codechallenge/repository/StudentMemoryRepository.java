package pe.dfp.codechallenge.repository;

import org.springframework.stereotype.Repository;
import pe.dfp.codechallenge.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class StudentMemoryRepository {
    private static final List<Student> students = new ArrayList<>();

    public Optional<Student> findById(Long id) {
        return students.stream()
                .filter(alumno -> alumno.getId().equals(id))
                .findFirst();
    }

    public void save(Student alumno) {
        students.add(alumno);
    }

    public List<Student> findByEstado(boolean estado) {
        return students.stream()
                .filter(alumno -> alumno.isActive() == estado)
                .collect(Collectors.toList());
    }
}
