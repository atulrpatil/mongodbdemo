package mongodbdemo.controller;

import mongodbdemo.models.Student;
import mongodbdemo.models.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class MyController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/")
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        Student student1 = studentRepository.save(student);
        return ResponseEntity.ok(student1);

    }

    @GetMapping("/")
    public ResponseEntity<?> getStudents() {
        List<Student> students = studentRepository.findAll();
        return ResponseEntity.ok(students);

    }
}
