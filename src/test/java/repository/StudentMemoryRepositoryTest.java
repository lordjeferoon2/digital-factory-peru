package repository;

import org.junit.jupiter.api.Test;
import pe.dfp.codechallenge.model.Student;
import pe.dfp.codechallenge.repository.StudentMemoryRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

public class StudentMemoryRepositoryTest {

    @Test
    public void findById_ExistingStudent_ReturnsStudent() {
        StudentMemoryRepository repository = new StudentMemoryRepository();
        Student student = new Student(1L, "John", "Doe", true, LocalDateTime.now());
        repository.save(student);

        Optional<Student> result = repository.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(student, result.get());
    }

    @Test
    public void findById_NonExistingStudent_ReturnsEmpty() {
        StudentMemoryRepository repository = new StudentMemoryRepository();

        Optional<Student> result = repository.findById(1L);

        assertTrue(result.isEmpty());
    }

    @Test
    public void save_NewStudent_StudentAdded() {
        StudentMemoryRepository repository = new StudentMemoryRepository();
        Student student = new Student(1L, "John", "Doe", true, LocalDateTime.now());

        repository.save(student);

        Optional<Student> result = repository.findById(1L);

        assertTrue(result.isPresent());
        assertEquals(student, result.get());
    }

    @Test
    public void findByEstado_ActiveStudents_ReturnsCorrectList() {
        StudentMemoryRepository repository = new StudentMemoryRepository();
        Student activeStudent = new Student(1L, "John", "Doe", true, LocalDateTime.now());
        Student inactiveStudent = new Student(2L, "Jane", "Doe", false, LocalDateTime.now());

        repository.save(activeStudent);
        repository.save(inactiveStudent);

        List<Student> result = repository.findByEstado(true);

        assertEquals(1, result.size());
        assertEquals(activeStudent, result.get(0));
    }
}
