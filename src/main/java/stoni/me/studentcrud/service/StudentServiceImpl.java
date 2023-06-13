package stoni.me.studentcrud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stoni.me.studentcrud.entity.Student;
import stoni.me.studentcrud.repository.StudentRepository;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> fetchStudentList() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudentById(Student student, Long id) {
        return null;
    }

    @Override
    public void deleteStudentById(Long id) {

    }

    @Override
    public Student getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public Student updateStudent(Student student1) {
        return studentRepository.save(student1);
    }

    @Override
    public void deleteStudent(Student student) {
        studentRepository.delete(student);
    }
}
