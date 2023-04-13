package com.example.cse4636_assignment4.Service;

import com.example.cse4636_assignment4.model.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class AddStudent {
    public boolean AddToStudentList(Student student)
    {
        try {
            DBConnection connection = new DBConnection();
            Connection con = connection.getCon();
            String query = "insert into Student( name, semester, cgpa) values('"+student.getName()+"',"+student.getSemester()+","+student.getCgpa()+")";
            Statement statement = con.createStatement();
            int status = statement.executeUpdate(query);
            if(status>0)
            {
                return true;
            }
        }catch (SQLException e)
        {
            System.out.println(e);
        }


        return false;
    }
}
