package com.aurionpro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurionpro.dao.StudentDao;
import com.aurionpro.entity.Student;

@SpringBootApplication
public class Application implements CommandLineRunner{

	@Autowired
	StudentDao studentDao;
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		//1.add student
		//addNewStudent();
		
		//2.find student by ID
//		Student student=getStudentByID(3);
//		System.out.println(student);
		
		//3.find all Student
//		List<Student> students = findallstudents();
//		System.out.println(students);
		
		//4.find Student by firstName
//		List<Student> students = findStudentByFirstName("Sankalp");
//		System.out.println(students);
		
		//5.find by email
//		List<Student> students = findByEmail("sankalpgaonkar@example.com");
//		System.out.println(students);
		
		//6.Update query
		
//		updateStudent();
//	
		//7.delete query
//		 deletestudentById(25);
		
		//8.deleteAll query
		
		deleteAll();
		
		
		
	}
	private void deleteAll() {
		 studentDao.deleteAll();
	}
	private void deletestudentById(int id) {
		 studentDao.deleteStudentById(id);
	}
	private void updateStudent() {
		Student student = new Student(1,"Rinku","Singh","rinku@gmail.com");
		studentDao.update(student);
	}
	private List<Student> findByEmail(String email) {
		return studentDao.findByEmail(email);
	}
	private List<Student> findStudentByFirstName(String firstName) {
		return studentDao.findStudentByFirstName(firstName);
	}
	private List<Student> findallstudents() {

		return studentDao.findAll();
	}
	private  Student getStudentByID(int id ) {
		return studentDao.findById(id);
	}
	private void addNewStudent() {
		Student student = new Student("Dhruv","Joshi","dhruv@gmail.com");
		Student resultStudent = studentDao.save(student);
		System.out.println(resultStudent);
	
	}

	
}
