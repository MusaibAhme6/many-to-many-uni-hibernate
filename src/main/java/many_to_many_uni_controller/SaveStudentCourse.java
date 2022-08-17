package many_to_many_uni_controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;



import many_to_many_uni_hibernate_entities.Course;
import many_to_many_uni_hibernate_entities.Student;

public class SaveStudentCourse {
	
	public static void main(String[] args) {
		
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("vikas");
	EntityManager entityManager=entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction=entityManager.getTransaction();
	
	Course course=new Course();
	course.setName("MERN stack");
	course.setCost(30000);
	
	
	List<Student> student=new ArrayList<Student>();
	
	
	Student stu=new Student();
	stu.setName("ubaid");
	stu.setAge(26);
	
	Student stu1=entityManager.find(Student.class, 1);
	Student stu2=entityManager.find(Student.class, 2);
//	
//	Student stu1=new Student();
//	stu1.setName("musaib");
//	stu1.setAge(23);
//	
//	Student stu2=new Student();
//	stu2.setName("Asif");
//	stu2.setAge(24);
//	
	student.add(stu);
	student.add(stu1);
	student.add(stu2);
	
	course.setStudent(student);
	
	entityTransaction.begin();
	entityManager.persist(course);
	entityManager.persist(stu);
	entityManager.persist(stu1);
	entityManager.persist(stu2);
	entityTransaction.commit();
	
	System.out.println("+++++++++++++++++++++++++++++saved++++++++++++++++++++++++++++++");
	
		
	}

}
