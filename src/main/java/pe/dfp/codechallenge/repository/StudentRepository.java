package pe.dfp.codechallenge.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import pe.dfp.codechallenge.model.Student;
import reactor.core.publisher.Mono;

public interface StudentRepository extends ReactiveMongoRepository<Student, String> {

    Mono<Student> findByFirstName(String firstName);

}