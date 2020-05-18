/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.ConfigurationProperties;
import model.Teacher;
import model.Teachers;
import services.StudentServices;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Lucia
 */
public class TeacherDAO {

    public List<Teacher> getAllTeachers() {
        Teachers t = new Teachers();
        try {
            Path teacherFile = Paths.get(ConfigurationProperties.
                    getInstance().getTeacherFile());

            // Read XML file
            try (InputStream istream = Files.newInputStream(teacherFile)) {
                JAXBContext jaxbContext = JAXBContext.newInstance(Teachers.class);
                Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
                t = (Teachers) jaxbUnmarshaller.unmarshal(istream);
            }

        } catch (Exception ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t.getTeachers();
    }

    public boolean addTeacher(Teacher teacher) {
        boolean ok = false;
        List<Teacher> teachers = getAllTeachers();
        if (!teachers.contains(teacher)) {
            teachers.add(teacher);
            ok = saveListTeachers(teachers);
        }
        return ok;
    }

    public boolean updateTeacher(Teacher teacher) {
        List<Teacher> teachers = getAllTeachers();
        teachers.remove(teacher);
        teachers.add(teacher);
        return saveListTeachers(teachers);
    }

    private boolean saveListTeachers(List<Teacher> teachers) {
        //Save into XML files.get(ConfigurationProperties.
        boolean ok = false;
        Teachers t = new Teachers();
        t.setTeachers(teachers);
        try {
            Path teacherFile = Paths.get(ConfigurationProperties.
                    getInstance().getTeacherFile());

            try (OutputStream ostream = Files.newOutputStream(teacherFile)) {

                //Create JAXB Context
                JAXBContext jaxbContext = JAXBContext.newInstance(Teachers.class);

                //Create Marshaller
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

                //Required formatting??
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

                //Writes XML file to file-system
                jaxbMarshaller.marshal(t, ostream);
            }

            ok = true;
        } catch (Exception ex) {
            Logger.getLogger(StudentServices.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ok;
    }
}
