package com.jash.jpaCrudDemo.dao;

import com.jash.jpaCrudDemo.entity.Course;
import com.jash.jpaCrudDemo.entity.Instructor;
import com.jash.jpaCrudDemo.entity.InstructorDetail;
import com.jash.jpaCrudDemo.entity.Student;

import java.util.List;

public interface AppDAO {
    public void save(Instructor theInstructor);
    public Instructor findById(int theId);

    public void deleteById(int theId);

    public InstructorDetail findInstructorDetailById(int theId);

    public void deleteInstructorDetail(int theId);

    public List<Course> findCoursesByInstructorId(int theId);

    public Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor tempInstructor);

    void update(Course tempCourse);

    Course findCourseById(int theId);

    void deleteCourse(int theId);

    void save(Course theCourse);

    Course findCourseAndReview(int theId);

    Course findCourseAndStudent(int theId);

    Student findStudentAndCourse(int theId);

    void update(Student student);

    void deleteStudent(int theId);
}
