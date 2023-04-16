//package com.datascience.redisproject.repositories.impl;
//
//import com.datascience.redisproject.models.Student;
//import com.datascience.redisproject.repositories.StudentRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.connection.DataType;
//import org.springframework.data.redis.core.*;
//import org.springframework.data.redis.core.query.SortQuery;
//import org.springframework.data.redis.core.script.RedisScript;
//import org.springframework.data.redis.core.types.RedisClientInfo;
//import org.springframework.data.redis.hash.HashMapper;
//import org.springframework.data.redis.serializer.RedisSerializer;
//import org.springframework.stereotype.Repository;
//
//import java.io.Closeable;
//import java.util.*;
//import java.util.concurrent.TimeUnit;
//import java.util.function.Function;
//import java.util.stream.Collectors;
//
//
//
//public class StudentRepositoryImpl implements StudentRepository {
//
//
//
//    private RedisOperations<String, Student> redisOperations;
//
//
//    @Autowired
//    public StudentRepositoryImpl(RedisOperations<String, Student> redisOperations) {
//        this.redisOperations = redisOperations;
//    }
//
//    @Override
//    public Student save(Student student) {
//        redisOperations.opsForValue().set(student.getId(), student);
//        return student;
//    }
//
//    @Override
//    public List<Student> findAll() {
//        return null;
//    }
//
//    @Override
//    public Student findById(String id) {
//        return null;
//    }
//
//    @Override
//    public void deleteById(String id) {
//
//    }
//
//
//    @Override
//    public void deleteAll() {
//        for (String key : redisOperations.keys("*")) {
//            redisOperations.delete(key);
//        }
//    }
//
//    @Override
//    public List<Student> findByName(String name) {
//        List<Student> students = new ArrayList<>();
//        for (String key : redisOperations.keys("*")) {
//            Student student = redisOperations.opsForValue().get(key);
//            if (student.getName().equals(name)) {
//                students.add(student);
//            }
//        }
//        return students;
//    }
//
//    @Override
//    public List<Student> findByAge(Integer age) {
//        List<Student> students = new ArrayList<>();
//        for (String key : redisOperations.keys("*")) {
//            Student student = redisOperations.opsForValue().get(key);
//            if (student.getAge().equals(age)) {
//                students.add(student);
//            }
//        }
//        return students;
//    }
//
//    @Override
//    public Student updateName(String id, String name) {
//        Student student = redisOperations.opsForValue().get(id);
//        student.setName(name);
//        redisOperations.opsForValue().set(id, student);
//        return student;
//    }
//
//    @Override
//    public Student updateAge(String id, Integer age) {
//        Student student = redisOperations.opsForValue().get(id);
//        student.setAge(age);
//        redisOperations.opsForValue().set(id, student);
//        return student;
//    }
//
//    @Override
//    public List<Student> findByAreaCode(Integer areaCode) {
//        List<Student> students = new ArrayList<>();
//        for (String key : redisOperations.keys("*")) {
//            Student student = redisOperations.opsForValue().get(key);
//            if (student.getAreaCode().equals(areaCode)) {
//                students.add(student);
//            }
//        }
//        return students;
//    }
//
//    @Override
//    public List<Student> findAllByAttribute(String attribute, String value) {
//        List<Student> students = new ArrayList<>();
//        for (String key : redisOperations.keys("*")) {
//            Student student = redisOperations.opsForValue().get(key);
//            switch (attribute) {
//                case "name":
//                    if (student.getName().equals(value)) {
//                        students.add(student);
//                    }
//                    break;
//                case "age":
//                    if (student.getAge().equals(Integer.parseInt(value))) {
//                        students.add(student);
//                    }
//                    break;
//                case "areaCode":
//                    if (student.getAreaCode().equals(Integer.parseInt(value))) {
//                        students.add(student);
//                    }
//                    break;
//                case "graduationTitle":
//                    if (student.getGraduationTitle().equals(value)) {
//                        students.add(student);
//                    }
//                    break;
//                case "graduationSemester":
//                    if (student.getGraduationSemester().equals(value)) {
//                        students.add(student);
//                    }
//                    break;
//                default:
//                    return null;
//            }
//        }
//        return students;
//    }
//
//    @Override
//    public List<Student> addStudents(List<Student> students) {
//        List<Student> addedStudents = new ArrayList<>();
//        for (Student student : students) {
//            redisOperations.opsForValue().set(student.getId(), student);
//            addedStudents.add(student);
//        }
//        return addedStudents;
//    }
//
//    @Override
//    public List<Student> findByGraduationTitle(String graduationTitle) {
//        List<Student> students = new ArrayList<>();
//        for (Object key : redisOperations.keys("*")) {
//            Student student = (Student) redisOperations.opsForValue().get(key);
//            if (student.getGraduationTitle().equals(graduationTitle)) {
//                students.add(student);
//            }
//        }
//        return students;
//    }
//
//
//}
