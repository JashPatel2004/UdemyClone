package com.jash.jpaCrudDemo;

import com.jash.jpaCrudDemo.dao.AppDAO;
import com.jash.jpaCrudDemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class JpaCrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaCrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner->{
			//createInstructor(appDAO);
			//findInstructor(appDAO);
			//deleteInstructor(appDAO);
			//findInstructorDetail(appDAO);
			//deleteInstructorDetail(appDAO);
			//createInstructorWithCourses(appDAO);
			//findInstructorWithCourses(appDAO);
			//findCoursesForInstructor(appDAO);
			//findInstructorWithCoursesJoinFetch(appDAO);
			//updateInstructor(appDAO);
			//updateCourse(appDAO);
			//deleteInstructor(appDAO);
			//deleteCourseById(appDAO);
			//createCoursesAndReviews(appDAO);
			//retriveCourseAndReviews(appDAO);
			//deleteCourseAndReviews(appDAO);
			//createCourseAndStudents(appDAO);
			//findCourseAndStudent(appDAO);
			//findStudentAndCourse(appDAO);
			//addMoreCoursesForStudent(appDAO);
			//deleteCourseById(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id=2;
		appDAO.deleteStudent(id);
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int theId=2;
		Student student=appDAO.findStudentAndCourse(theId);

		Course c1=new Course("Database and Management System");
		Course c2=new Course("Operating System");

		student.addCourse(c1);
		student.addCourse(c2);

		appDAO.update(student);
	}

	private void findStudentAndCourse(AppDAO appDAO) {
		int theId=1;
		Student student=appDAO.findStudentAndCourse(theId);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudent(AppDAO appDAO) {
		int theId=10;
		Course course=appDAO.findCourseAndStudent(theId);
		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course=new Course("Data Structures And Algorithms");
		Student s1=new Student("Jash","Patel","jash@123");
		Student s2=new Student("Krish","Patel","krish@123");
		course.addStudent(s1);
		course.addStudent(s2);
		appDAO.save(course);
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		appDAO.deleteCourse(theId);
	}

	private void retriveCourseAndReviews(AppDAO appDAO) {
		int theId=10;
		Course tempCourse=appDAO.findCourseAndReview(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}

	private void createCoursesAndReviews(AppDAO appDAO) {
		Course tempCourse=new Course("DSA with Java");

		tempCourse.addReview(new Review("Great course!"));
		tempCourse.addReview(new Review("Cool course...loved it!"));
		tempCourse.addReview(new Review("Not a good course...hate it!"));
		appDAO.save(tempCourse);
	}

	private void deleteCourseById(AppDAO appDAO) {
		int theId=12;
		appDAO.deleteCourse(theId);
	}

	private void updateCourse(AppDAO appDAO) {
		int theId=11;
		Course course=appDAO.findCourseById(theId);
		course.setTitle("OS");
		appDAO.update(course);
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId=1;
		Instructor instructor=appDAO.findById(theId);
		instructor.setLastName("Kumar");
		appDAO.update(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId=1;
		Instructor instructor=appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(AppDAO appDAO) {
		int theId=1;
		Instructor instructor=appDAO.findById(theId);
		List<Course> courses=appDAO.findCoursesByInstructorId(theId);
		instructor.setCourses(courses);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId=1;
		Instructor instructor=appDAO.findById(theId);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor=
				new Instructor("Krish","Patel","krish@gmail.com");

		InstructorDetail tempInstructorDetail=
				new InstructorDetail("krish.youtube.com","reading books");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1=new Course("DSA");
		Course tempCourse2=new Course("DBMS");

		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);

		appDAO.save(tempInstructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId=3;
		appDAO.deleteInstructorDetail(theId);
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId=1;
		InstructorDetail instructorDetail=appDAO.findInstructorDetailById(theId);
		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int theId=1;
		appDAO.deleteById(theId);
		System.out.println(theId);
	}

	private void findInstructor(AppDAO appDAO) {
		int theId=1;
		Instructor instructor=appDAO.findById(theId);
		System.out.println(instructor);
		System.out.println(instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor=
//				new Instructor("Jash","Patel","jash@gmail.com");
//
//		InstructorDetail tempInstructorDetail=
//				new InstructorDetail("jash.youtube.com","Playing Cricket");
//
//		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Instructor tempInstructor=
				new Instructor("Krish","Patel","krish@gmail.com");

		InstructorDetail tempInstructorDetail=
				new InstructorDetail("krish.youtube.com","reading books");

		tempInstructor.setInstructorDetail(tempInstructorDetail);

		appDAO.save(tempInstructor);
	}
}
