package com.revanth.jsonSerializationDeserialization.controller;

import com.revanth.jsonSerializationDeserialization.model.Student;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SDcontroller {

    @PostMapping(value ="/serialize")
    public String serialize(@RequestBody Student student) {
        return Student.serialize(student);
    }

    @PostMapping(value ="/deserialize")
    public Student deserialize(@RequestBody String jsonStudent){
        return Student.deserialize(jsonStudent);
    }

    @PostMapping(value ="/serializelist")
    public List<String> serialize(@RequestBody List<Student> students) {
        return students.stream().map(Student::serialize).collect(Collectors.toList());
    }

    @PostMapping(value ="/deserializelist")
    public List<Student> deserialize(@RequestBody List<String> jsonStudents){
        List<Student> students = new ArrayList<>();
        for(String jsonStudent : jsonStudents){
            students.add(Student.deserialize((String)jsonStudent));
        }
        return students;
    }
}
