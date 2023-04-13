package com.example.cse4636_assignment4.controller;

import com.example.cse4636_assignment4.Repository.StudentRepository;
import com.example.cse4636_assignment4.Service.AddStudent;
import com.example.cse4636_assignment4.model.Student;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;
import java.net.URL;

@Stateless
@Path("/Stateless/student")
public class StudentBeanStateless {

    private StudentRepository studentRepository = new StudentRepository(); // Inject the service to handle database operations
    private AddStudent addStudent = new AddStudent();
    @POST
    @Path("/add")
    @Produces(MediaType.TEXT_HTML)
    public Response addStudent(@FormParam("name") String name, @FormParam("semester") int semester, @FormParam("cgpa") double cgpa) {
        Student student = new Student(name, semester, cgpa);

        boolean check = addStudent.AddToStudentList(student); // Call the service to add student to the database

        // Redirect to index.jsp after adding student
        if(check) {
            URI uri = UriBuilder.fromUri("/index").build();
            return Response.seeOther(uri).build();
        }
        URI uri = UriBuilder.fromUri("add-student.jsp").build();
        return Response.seeOther(uri).build();
    }

    @GET
    @Path("/{studentId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentName(@PathParam("studentId") Long StId) {
        Student student = studentRepository.find(StId); // Call the service to get student name from the database
        return Response.ok(student).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getStudentWithHigherCgpa(
            @QueryParam("studentId1") long studentId1,
            @QueryParam("studentId2") long studentId2
    ) {
        Student student1 = studentRepository.find(studentId1); // Call the service to get student1 from the database
        Student student2 = studentRepository.find(studentId2); // Call the service to get student2 from the database

        // Compare CGPAs and return the student with higher CGPA
        if (student1.getCgpa() > student2.getCgpa()) {
            return Response.ok(student1).build();
        } else {
            return Response.ok(student2).build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Response updateStudentName(
            @QueryParam("studentId") Long studentId,
            @QueryParam("name") String name
    ) {
        Student student = studentRepository.findById(studentId);
        student.setName(name);
        studentRepository.update(student); // Call the service to update student name in the database
        return Response.ok().build();
    }
}

