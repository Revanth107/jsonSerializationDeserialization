package com.revanth.jsonSerializationDeserialization.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

@Data
public class Student {
    public int studentId;
    public String name;
    public int age;

    public Student() {
    }

    public Student(int studentId, String name, int age) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
    }

    public static String serialize(Student student) {
        String jsonStudent = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonStudent = objectMapper.writeValueAsString(student);
        } catch (JsonProcessingException e) {
            System.out.println("Error while serializing student"+ e);
            throw new RuntimeException(e);
        }
        return jsonStudent;
    }

    public static Student deserialize(String jsonStudent) {
        Student student = null;
        try {
            student = new ObjectMapper().readValue(jsonStudent, Student.class);
        } catch (JsonMappingException e) {
            System.out.println("Error while mapping jsonStudent"+ e);
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            System.out.println("Error while processing jsonStudent"+ e);
            throw new RuntimeException(e);
        }
        return student;
    }

}
