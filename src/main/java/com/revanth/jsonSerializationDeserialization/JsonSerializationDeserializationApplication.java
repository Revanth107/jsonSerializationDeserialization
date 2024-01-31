package com.revanth.jsonSerializationDeserialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revanth.jsonSerializationDeserialization.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JsonSerializationDeserializationApplication {

	public static void main(String[] args) {

		SpringApplication.run(JsonSerializationDeserializationApplication.class, args);


		System.out.println("--------Serialization-----------");
		Student student = new Student(123, "Revanth", 24);
		String jsonStudent = student.serialize(student);
		System.out.println("Serialized result : " +jsonStudent);


		System.out.println("--------Deserialization-----------");
		String jsonStudent1 = "{\"studentId\":321,\"name\":\"Ram\",\"age\":25}";
		Student student1 = new Student().deserialize(jsonStudent1);
		System.out.println("Deserialized result : " +student1);

	}

}
