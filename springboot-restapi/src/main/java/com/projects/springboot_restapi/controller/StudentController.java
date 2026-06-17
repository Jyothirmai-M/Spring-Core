package com.projects.springboot_restapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projects.springboot_restapi.beans.Student;

@RestController
@RequestMapping("/students")
public class StudentController {
	
	@GetMapping("/student")
	public Student getStudent() {
		return new Student(1,"Jyothi","M");
	}
	
	
	@GetMapping("/responseEntity")
	public ResponseEntity<Student> getStudentinResposeEntity() {
		Student student=new Student(1,"Jyothi","M");
		//return new ResponseEntity<>(student,HttpStatus.OK);
		//return ResponseEntity.ok(student);
		return ResponseEntity.ok().header("Custom-header", "Jyothi").body(student);
	}

	@GetMapping("/students")
	public ResponseEntity<List<Student>> getStudents() {
		List<Student> students=new ArrayList<Student>();
		students.add( new Student(1,"Jyothi","M"));
		students.add( new Student(2,"Jyothsna","M"));
		students.add( new Student(3,"Mery","M"));
		
		//return li;
		return ResponseEntity.ok(students);
	}
	
	
	//Spring boot rest api with Path Variable
	//{id} - URL template variable
	@GetMapping("/{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> getStudentsbyid(@PathVariable("id") int StudentId,
									@PathVariable("first-name") String firstName,
									@PathVariable("last-name") String lastName) {
			Student student= new Student(StudentId,firstName,lastName);
			//return student;
			return ResponseEntity.ok(student);
	}
	
	
	//spring boot rest api with Request Param
	//http://localhost:8080/students/query?id=1 -> query parameter
	@GetMapping("/query")
	public Student studentRequestVariable(@RequestParam int studentId) {
			return new Student(studentId,"Mery","Laddu");
	}
	
	//spring boot rest api with Request Param
	//http://localhost:8080/students/query?id=1&firstName="Mery"&lastName="M" -> query parameter
	@GetMapping("/querie")
	public Student studentRequestVariable(@RequestParam int studentId,
												@RequestParam String firstName,
												@RequestParam String lastName) {
			return new Student(studentId,firstName,lastName);
	}
	
	
	
	//Spring boot Rest api that handles HTTP post request
	//@PostMapping and @RequestBody
	@PostMapping("/create")
	//@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFristName());
		System.out.println(student.getLastName());
		//return student;
		return new ResponseEntity<>(student,HttpStatus.CREATED);
	}
	
	////Spring boot Rest api that handles HTTP PUT request - updating existing resource
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Student updateStudent(@RequestBody Student student) {
		Student s= new Student(1,"Jyothi","M");
		System.out.println(s.getId());
		System.out.println(s.getFristName());
		System.out.println(s.getLastName());
		s.setId(student.getId());
		s.setFristName(student.getFristName());
		s.setLastName(student.getLastName());
		return s;
				
	}
	
	
	////Spring boot Rest api that handles HTTP Delete request - deleting existing resource
	@DeleteMapping("/{id}/delete")
	public String deleteStudent(@PathVariable("id") int studentId) {
		System.out.println(studentId);
		return "Student Deleted Successfully!";
	}
	
}
