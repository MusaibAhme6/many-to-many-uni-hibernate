package many_to_many_uni_controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import many_to_many_uni_hibernate_entities.Subject;
import many_to_many_uni_hibernate_entities.Teacher;

public class SaveTeachersSubjects {

	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vikas");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();

		Teacher teacher = new Teacher();
		teacher.setName("Bharathi");
		teacher.setAge(25);

		List<Subject> sub = new ArrayList<Subject>();

		Subject subject = entityManager.find(Subject.class, 1);
		sub.add(subject);
//	Subject subject1=new Subject();
//	subject1.setDays(45);
//	subject1.setName("Science");
//	sub.add(subject1);

		Subject subject2 = new Subject();
		subject2.setDays(90);
		subject2.setName("computer science");
		sub.add(subject2);

		Subject subject3 = new Subject();
		subject3.setDays(50);
		subject3.setName("english");
		sub.add(subject3);

		teacher.setSubjects(sub);

		entityTransaction.begin();
		entityManager.persist(teacher);
		entityManager.persist(subject);
		entityManager.persist(subject2);
		entityManager.persist(subject3);
		entityTransaction.commit();
		System.out.println("saved");

	}
}
