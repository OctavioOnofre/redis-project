package com.datascience.redisproject.services;

import com.datascience.redisproject.models.Student;

import java.util.List;

public interface StudentService {

    Student addStudent(Student student);

    List<Student> findAll();

    Student findById(String id);

    void deleteById(String id);

    void deleteAll();

    List<Student> findByName(String name);

    List<Student> findByAge(Integer age);

    Student updateName(String id, String name);

    Student updateAge(String id, Integer age);

    List<Student> findByAreaCode(Integer areaCode);

    List<Student> findAllByAttribute(String attribute, String value);

    List<Student> addStudents(List<Student> students);

    List<Student> findByGraduationTitle(String graduationTitle);


}
