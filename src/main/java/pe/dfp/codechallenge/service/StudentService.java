package pe.dfp.codechallenge.service;

import org.springframework.stereotype.Service;

import pe.dfp.codechallenge.model.Student;
import pe.dfp.codechallenge.repository.StudentRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Flux<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Mono<Student> getStudentById(String id) {
        return studentRepository.findById(id);
    }

    public Mono<Student> createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Mono<Student> updateStudent(String id, Student student) {
        return studentRepository.findById(id)
                .flatMap(existingStudent -> {
                    existingStudent.setFirstName(student.getFirstName());
                    existingStudent.setLastName(student.getLastName());
                    existingStudent.setActive(student.isActive());
                    existingStudent.setDateOfBirth(student.getDateOfBirth());
                    return studentRepository.save(existingStudent);
                });
    }

    public Mono<Void> deleteStudent(String id) {
        return studentRepository.deleteById(id);
    }
}