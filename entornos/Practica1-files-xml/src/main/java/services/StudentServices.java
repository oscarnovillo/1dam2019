/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.StudentsDAO;
import model.Student;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class StudentServices {

    public List<Student> getAllStudents() {
        StudentsDAO dao = new StudentsDAO();
        return dao.getAllStudents();
    }

    public boolean addStudent(String nif, String name, String phone, LocalDate fecha) {
        boolean ok = true;
        List<Student> students = this.getAllStudents();
        if (!students.contains(new Student(nif, name, phone, fecha))) {
            StudentsDAO dao = new StudentsDAO();
            ok = dao.addStudent(new Student(nif, name, phone, fecha));

        } else {
            ok = false;
        }
        return ok;
    }

}
