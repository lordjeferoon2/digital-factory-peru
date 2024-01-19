package pe.dfp.codechallenge.service;

import org.springframework.stereotype.Service;

import pe.dfp.codechallenge.model.Student;
import pe.dfp.codechallenge.repository.StudentMemoryRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class StudentService {

    private final StudentMemoryRepository studentRepository;

    public StudentService(StudentMemoryRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    
    public Mono<Void> saveStudent(Student student) {
        if (studentRepository.findById(student.getId()).isPresent()) {
            return Mono.error(new RuntimeException("El Id del alumno ya existe"));
        }
        studentRepository.save(student);
        return Mono.empty();
    }

    public Flux<Student> getAllStudentsByStatusActive() {
        List<Student> alumnosActivos = studentRepository.findByEstado(true);
        return Flux.fromIterable(alumnosActivos);
    }
}