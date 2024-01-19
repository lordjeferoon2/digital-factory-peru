package pe.dfp.codechallenge.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import pe.dfp.codechallenge.model.Student;
import pe.dfp.codechallenge.service.StudentService;
import reactor.core.publisher.Flux;

import javax.validation.Valid;

@RestController
@RequestMapping("/alumnos")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/grabar")
    public ResponseEntity<Void> saveAlumno(@Valid @RequestBody Student student) {
        studentService.saveStudent(student);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/activos")
    public Flux<Student> getAllStudentsByStatusActive() {
        return studentService.getAllStudentsByStatusActive();
    }
}