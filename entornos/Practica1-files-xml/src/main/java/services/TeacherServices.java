/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.TeacherDAO;
import model.Teacher;

import java.util.List;


public class TeacherServices {


    public List<Teacher> getAllTeachers() {
        TeacherDAO dao = new TeacherDAO();
        return dao.getAllTeachers();
    }

    public boolean addTeacher(String nif, String name) {
        Teacher t = new Teacher(nif, name);
        TeacherDAO dao = new TeacherDAO();
        return dao.addTeacher(t);
    }

    public boolean updateTeacher(Teacher t) {
        TeacherDAO dao = new TeacherDAO();
        return dao.updateTeacher(t);
    }

}
