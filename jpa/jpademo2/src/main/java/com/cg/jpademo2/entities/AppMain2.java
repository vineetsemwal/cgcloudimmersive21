package com.cg.jpademo2.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

public class AppMain2 {

    private EntityManager entityManager;

    public static void main(String args[]) {
        AppMain2 app = new AppMain2();
        app.start();
    }

    public void start() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("school-ms");
        entityManager = emf.createEntityManager();
        Student krishna1 = new Student("krishna", 21);
        Student venkat = new Student("venkat", 22);
        Student tanvi1 = new Student("tanvi", 21);
        Student tanvi2 = new Student("tanvi", 23);

        Student krishna2 = new Student("krishna", 21);
        add(krishna1);
        add(krishna2);
        add(venkat);
        add(tanvi1);
        add(tanvi2);
        System.out.println("krishna inserted with id=" + krishna2.getId());
        System.out.println("venkat inserted with id=" + venkat.getId());
        int krishnaId = krishna1.getId();
        Student found = findById(krishnaId);
        display(found);
        krishna1.setName("sivakrishna");
        krishna1 = update(krishna1);
        System.out.println("krishna changes updated");
        display(krishna1);

        System.out.println("***fetch and splay all students");
        List<Student> all = fetchAll();
        displayCollection(all);

        System.out.println("***fetch and display all students with age greater than age");
        List<Student> allGreaterThan21 = fetchAllGreaterthanAge(22);
        displayCollection(allGreaterThan21);

        System.out.println("***fetch all student with the mentioned name");
        List<Student> allWithNameKrishna = fetchAllWithName("tanvi");
        displayCollection(allWithNameKrishna) ;
        entityManager.close();
        emf.close();

    }

    public void add(Student student) {
        EntityTransaction transaction1 = entityManager.getTransaction();
        transaction1.begin();
        entityManager.persist(student);
        transaction1.commit();
    }

    public Student update(Student student) {
        EntityTransaction transaction1 = entityManager.getTransaction();
        transaction1.begin();
        Student saved = entityManager.merge(student);
        transaction1.commit();
        return saved;
    }


    public void remove(Student student) {
        EntityTransaction transaction1 = entityManager.getTransaction();
        transaction1.begin();
        entityManager.remove(student);
        transaction1.commit();
    }

    public Student findById(int id) {
        Student student = entityManager.find(Student.class, id);
        return student;
    }


    public List<Student> fetchAll() {
        String queryText = "from Student";
        TypedQuery<Student> query = entityManager.createQuery(queryText, Student.class);
        List<Student> list = query.getResultList();
        return list;
    }

    public List<Student> fetchAllWithName(String name) {
        String queryText = "from Student where name = :nameParam ";
        TypedQuery<Student> query = entityManager.createQuery(queryText, Student.class);
        query.setParameter("nameParam", name);
        List<Student> list = query.getResultList();
        return list;
    }

    public List<Student> fetchAllGreaterthanAge(int age) {
        String queryText = "from Student where age > :ageParam ";
        TypedQuery<Student> query = entityManager.createQuery(queryText, Student.class);
        query.setParameter("ageParam", age);
        List<Student> list = query.getResultList();
        return list;
    }

    public void display(Student student) {
        System.out.println(student.getId() + "-" + student.getName() + "-" + student.getAge());

    }

    public void displayCollection(Collection<Student> students) {
        for (Student student : students) {
            display(student);
        }
    }


}
