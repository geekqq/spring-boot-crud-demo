package stoni.me.studentcrud.service;

import stoni.me.studentcrud.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student);

    List<Student> fetchStudentList();

    Student updateStudentById(Student student, Long id);

    void deleteStudentById(Long id);

    Student getById(Long id);

    Student updateStudent(Student student1);

    void deleteStudent(Student student);
}
