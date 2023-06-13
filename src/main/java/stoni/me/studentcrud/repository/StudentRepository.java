package stoni.me.studentcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stoni.me.studentcrud.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
