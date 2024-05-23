package com.jash.jpaCrudDemo.dao;

import com.jash.jpaCrudDemo.entity.Course;
import com.jash.jpaCrudDemo.entity.Instructor;
import com.jash.jpaCrudDemo.entity.InstructorDetail;
import com.jash.jpaCrudDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{
    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager theEntityManager){
        entityManager=theEntityManager;
    }
    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findById(int theId) {
        return entityManager.find(Instructor.class,theId);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Instructor instructor=entityManager.find(Instructor.class,theId);
        List<Course> courses=instructor.getCourses();
        for(Course course:courses){
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class,theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetail(int theId) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,theId);
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query=entityManager.createQuery("from Course where instructor.id=:data", Course.class);
        query.setParameter("data",theId);
        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query= entityManager.createQuery(
                "select i from Instructor i "
                +"JOIN FETCH i.courses "+"JOIN FETCH i.instructorDetail "+"where i.id= :data ",Instructor.class);
        query.setParameter("data",theId);
        Instructor instructor=query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }

    @Override
    @Transactional
    public void update(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int theId) {
        Course tempCourse=entityManager.find(Course.class,theId);
        return tempCourse;
    }

    @Override
    @Transactional
    public void deleteCourse(int theId) {
        Course course=entityManager.find(Course.class,theId);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReview(int theId) {
        TypedQuery<Course> query= entityManager.createQuery(
                "select c from Course c "
        +"JOIN FETCH c.reviews "
        +"where c.id=:data", Course.class);
        query.setParameter("data",theId);
        Course course=query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudent(int theId) {
        TypedQuery<Course> query= entityManager.createQuery(
                "select c from Course c "
                        +"JOIN FETCH c.students "
                        +"where c.id=:data", Course.class);
        query.setParameter("data",theId);
        Course course=query.getSingleResult();
        return course;
    }

    @Override
    public Student findStudentAndCourse(int theId) {
        TypedQuery<Student> query= entityManager.createQuery(
                "select c from Student c "
                        +"JOIN FETCH c.courses "
                        +"where c.id=:data", Student.class);
        query.setParameter("data",theId);
        Student student=query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int theId) {
        Student student=entityManager.find(Student.class,theId);
        entityManager.remove(student);
    }
}
