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

    /* Serialize
       1. URL: http://localhost:8080/serialize
       2. Input:
            {
                "studentId": 123,
                "name": "Revanth",
                "age": 20
            }
       3. Output: {"studentId":123,"name":"Revanth","age":20}
    */

    @PostMapping(value ="/serialize")
    public String serialize(@RequestBody Student student) {
        return Student.serialize(student);
    }


    /* Serialize
       1. URL: http://localhost:8080/serializelist
       2. Input:
            [
                {
                    "studentId": 123,
                    "name": "Revanth",
                    "age": 20
                },
                {
                    "studentId": 321,
                    "name": "Ram",
                    "age": 28
                }
            ]
       3. Output:
            [
                "{\"studentId\":123,\"name\":\"Revanth\",\"age\":20}",
                "{\"studentId\":321,\"name\":\"Ram\",\"age\":28}"
            ]
    */

    @PostMapping(value ="/serializelist")
    public List<String> serialize(@RequestBody List<Student> students) {
        return students.stream().map(Student::serialize).collect(Collectors.toList());
    }

    /* Deserialize
       1. URL: http://localhost:8080/deserialize
       2. Input: {"studentId":321,"name":"Ram","age":28}
       3. Output:
           {
                "studentId": 321,
                "name": "Ram",
                "age": 28
            }
    */
    @PostMapping(value ="/deserialize")
    public Student deserialize(@RequestBody String jsonStudent){
        return Student.deserialize(jsonStudent);
    }


    /* DeserializeList
       1. URL: http://localhost:8080/deserializelist
       2. Input:
            [
                "{\"studentId\":123,\"name\":\"Revanth\",\"age\":20}",
                "{\"studentId\":321,\"name\":\"Ram\",\"age\":28}"
            ]
       3. Output:
           [
                {
                    "studentId": 123,
                    "name": "Revanth",
                    "age": 20
                },
                {
                    "studentId": 321,
                    "name": "Ram",
                    "age": 28
                }
            ]
    */

    @PostMapping(value ="/deserializelist")
    public List<Student> deserialize(@RequestBody List<String> jsonStudents){
        List<Student> students = new ArrayList<>();
        for(String jsonStudent : jsonStudents){
            students.add(Student.deserialize((String)jsonStudent));
        }
        return students;
    }
}
