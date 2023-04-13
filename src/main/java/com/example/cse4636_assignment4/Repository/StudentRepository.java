package com.example.cse4636_assignment4.Repository;

import com.example.cse4636_assignment4.model.Student;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.util.List;

public class StudentRepository {

    private EntityManager entityManager;
    private EntityManagerFactory emf;

    public StudentRepository() {
        this.emf = Persistence.createEntityManagerFactory("student-pu");
        this.entityManager = this.emf.createEntityManager();
    }

    public StudentRepository(String pu) {
        this.emf = Persistence.createEntityManagerFactory(pu);
        this.entityManager = this.emf.createEntityManager();
    }

    public Student add(Student student) {
        entityManager.getTransaction().begin();
        entityManager.persist(student);
        entityManager.getTransaction().commit();
        return student;
    }


    public Student find(Long id) {
        return entityManager.find(Student.class, id);
    }

    public Student findById(Long id) {
        Query query = entityManager.createNamedQuery("find student by id");
        query.setParameter("id", id);
        return (Student) query.getSingleResult();
    }

    public Student updateFirstNameById(String name, Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Update Student set name = '"+ name + "' where id = " + id );
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.clear();
        return findById(id);
    }


    public void deleteById(Long id) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("Delete from Student where id =" + id);
        query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public List<Student> findByNameStartWith(String keyword) {
        Query query = entityManager.createQuery("Select s from Student s where s.name like '" + keyword + "%'");
        return query.getResultList();
    }


    public List<Student> findSortingById() {
        Query query = entityManager.createQuery("Select s from Student s order by s.id desc");
        return query.getResultList();
    }

    public Long count() {
        Query query = entityManager.createQuery("Select count(s) from Student s");
        return (Long) query.getSingleResult();
    }

    public Student update(Student student) {
        Student studentToUpdate = find(student.getStudentId());
        entityManager.getTransaction().begin();
        studentToUpdate.setName(student.getName());
        studentToUpdate.setSemester(student.getSemester());
        studentToUpdate.setCgpa(student.getCgpa());
        entityManager.getTransaction().commit();
        return studentToUpdate;
    }

    public void delete(Student student) {
        entityManager.getTransaction().begin();
        entityManager.remove(student);
        entityManager.getTransaction().commit();
    }


    public List<Student> getStudentWithCriteriaBuilder() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);

        Root<Student> studentRoot = criteriaQuery.from(Student.class);

        criteriaQuery.select(studentRoot.get("name"));
        criteriaQuery.distinct(true);
        criteriaQuery.orderBy(criteriaBuilder.desc(studentRoot.get("name")));

        CriteriaQuery<Student> select = criteriaQuery.select(studentRoot);
        TypedQuery<Student> query = entityManager.createQuery(select);

        return query.getResultList();
    }




    public void close() {
        this.entityManager.close();
        this.emf.close();
    }
}

