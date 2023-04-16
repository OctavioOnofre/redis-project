package com.datascience.redisproject.models;


public class Student {
    public String id;
    public String name;
    public Integer age;
    public Integer areaCode;
    public String phoneNumber;
    public String email;

    public String graduationTitle;

    public Integer graduationSemester;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGraduationTitle() {
        return graduationTitle;
    }

    public void setGraduationTitle(String graduationTitle) {
        this.graduationTitle = graduationTitle;
    }

    public Integer getGraduationSemester() {
        return graduationSemester;
    }

    public void setGraduationSemester(Integer graduationSemester) {
        this.graduationSemester = graduationSemester;
    }
}
