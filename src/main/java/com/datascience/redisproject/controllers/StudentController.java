package com.datascience.redisproject.controllers;

import com.datascience.redisproject.models.Student;
import com.datascience.redisproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    public StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        Student addedStudent = studentService.addStudent(student);
        return new ResponseEntity<>(addedStudent, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> findAll() {
        List<Student> students = studentService.findAll();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable String id) {
        Student student = studentService.findById(id);
        if (student != null) {
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        studentService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteAll() {
        studentService.deleteAll();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<List<Student>> findByName(@PathVariable String name) {
        List<Student> students = studentService.findByName(name);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/age/{age}")
    public ResponseEntity<List<Student>> findByAge(@PathVariable Integer age) {
        List<Student> students = studentService.findByAge(age);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PutMapping("/{id}/name")
    public ResponseEntity<Student> updateName(@PathVariable String id, @RequestBody String name) {
        Student updatedStudent = studentService.updateName(id, name);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}/age")
    public ResponseEntity<Student> updateAge(@PathVariable String id, @RequestBody Integer age) {
        Student updatedStudent = studentService.updateAge(id, age);
        if (updatedStudent != null) {
            return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/areaCode/{areaCode}")
    public ResponseEntity<List<Student>> findByAreaCode(@PathVariable Integer areaCode) {
        List<Student> students = studentService.findByAreaCode(areaCode);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{attribute}/{value}")
    public ResponseEntity<List<Student>> findAllByAttribute(@PathVariable String attribute, @PathVariable String value) {
        List<Student> students = studentService.findAllByAttribute(attribute, value);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @PostMapping("/batch")
    public ResponseEntity<List<Student>> addStudents(@RequestBody List<Student> students) {
        List<Student> addedStudents = studentService.addStudents(students);
        return new ResponseEntity<>(addedStudents, HttpStatus.CREATED);
    }

    @GetMapping("/graduationTitle/{graduationTitle}")
    public ResponseEntity<List<Student>> findByGraduationTitle(@PathVariable String graduationTitle) {
        List<Student> students = studentService.findByGraduationTitle(graduationTitle);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}