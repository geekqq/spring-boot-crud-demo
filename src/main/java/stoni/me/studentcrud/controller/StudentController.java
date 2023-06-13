package stoni.me.studentcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stoni.me.studentcrud.entity.Student;
import stoni.me.studentcrud.service.StudentService;

import java.util.List;

@RestController

public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String Home() {
        return "Hello Student!";
    }


    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @GetMapping("/students")
    public List<Student> fetchAllStudents() {
        return studentService.fetchStudentList();
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getById(id);
        if (student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(student);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudentById(@RequestBody Student student, @PathVariable Long id) {
        Student student1 = studentService.getById(id);
        if (student1 == null) {
            return ResponseEntity.notFound().build();
        }
        student1.setName(student.getName());
        student1.setEmail(student.getEmail());
        student1.setDateOfBirth(student.getDateOfBirth());
        student1.setGender(student.getGender());
        Student updatedStudent = studentService.updateStudent(student1);
        return ResponseEntity.ok(updatedStudent);
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable Long id) {
        Student student = studentService.getById(id);
        if (student == null) {
            String errorMessage = "Student with ID " + id + " not found";
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .header("Content-Type", "text/plain")
                    .body(errorMessage);
        }
        studentService.deleteStudent(student);
        String message = "Student with ID " + id + " has been deleted successfully";
        return ResponseEntity.status(HttpStatus.OK)
                .header("Content-Type", "text/plain")
                .body(message);
    }
}
