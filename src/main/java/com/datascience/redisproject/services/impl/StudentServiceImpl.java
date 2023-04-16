package com.datascience.redisproject.services.impl;

import com.datascience.redisproject.models.Student;
import com.datascience.redisproject.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    public RedisTemplate<String, Object> redisTemplate;

    private final String HASH_KEY = "students";

    @Autowired
    public StudentServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public Student addStudent(Student student) {
        redisTemplate.opsForHash().put(HASH_KEY, student.id, student);
        return student;
    }
    @Override
    public List<Student> findAll() {
        return redisTemplate.opsForHash().values(HASH_KEY).stream().map(obj -> (Student) obj).collect(Collectors.toList());
    }
    @Override
    public Student findById(String id) {
        return (Student) redisTemplate.opsForHash().get(HASH_KEY, id);
    }
    @Override
    public List<Student> findByName(String name) {
        List<Student> students = new ArrayList<>();
        for (Object student : redisTemplate.opsForHash().values(HASH_KEY)) {
            if (((Student) student).name.equals(name)) {
                students.add((Student) student);
            }
        }
        return students;
    }
    @Override
    public List<Student> findByAge(Integer age) {
        List<Student> students = new ArrayList<>();
        for (Object student : redisTemplate.opsForHash().values(HASH_KEY)) {
            if (((Student) student).age.equals(age)) {
                students.add((Student) student);
            }
        }
        return students;
    }
    @Override
    public Student updateName(String id, String name) {
        Student student = findById(id);
        if (student != null) {
            student.name = name;
            redisTemplate.opsForHash().put(HASH_KEY, id, student);
        }
        return student;
    }
    @Override
    public Student updateAge(String id, Integer age) {
        Student student = findById(id);
        if (student != null) {
            student.age = age;
            redisTemplate.opsForHash().put(HASH_KEY, id, student);
        }
        return student;
    }
    @Override
    public void deleteById(String id) {
        redisTemplate.opsForHash().delete(HASH_KEY, id);
    }
    @Override
    public List<Student> findByAreaCode(Integer areaCode) {
        List<Student> students = new ArrayList<>();
        for (Object student : redisTemplate.opsForHash().values(HASH_KEY)) {
            if (((Student) student).areaCode.equals(areaCode)) {
                students.add((Student) student);
            }
        }
        return students;
    }
    @Override
    public List<Student> findAllByAttribute(String attribute, String value) {
        List<Student> students = new ArrayList<>();
        for (Object student : redisTemplate.opsForHash().values(HASH_KEY)) {
            try {
                Field field = Student.class.getField(attribute);
                Object fieldValue = field.get(student);
                if (fieldValue != null && fieldValue.toString().equals(value)) {
                    students.add((Student) student);
                }
            } catch (Exception e) {
                // Attribute not found, do nothing
            }
        }
        return students;
    }
    @Override
    public List<Student> addStudents(List<Student> students) {
        List<Student> addedStudents = new ArrayList<>();
        for (Student student : students) {
            redisTemplate.opsForHash().put(HASH_KEY, student.id, student);
            addedStudents.add(student);
        }
        return addedStudents;
    }

    @Override
    public List<Student> findByGraduationTitle(String graduationTitle) {
        List<Student> result = new ArrayList<>();
        for (Student student : findAll()) {
            if (student.graduationTitle.equals(graduationTitle)) {
                result.add(student);
            }
        }
        return result;
    }



    @Override
    public void deleteAll() {
        redisTemplate.delete(HASH_KEY);
    }


}
