/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import config.ConfigurationProperties;
import model.Student;
import services.StudentServices;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 * @author oscar
 */
public class StudentsDAO {

    public List<Student> getAllStudents() {
        List<String> lines = null;
        try {
            Path studentsFile = Paths.get(ConfigurationProperties.
                    getInstance().getStudentFile());
            lines = Files.readAllLines(studentsFile);
        } catch (IOException ex) {
            Logger.getLogger(StudentsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loadStudentsList(lines);
    }

    private List<Student> loadStudentsList(List<String> students) {
        return students.stream().map(linea -> {
            String[] lineDivided = linea.split(";");
            return new Student(lineDivided[0],
                    lineDivided[1], lineDivided[2],
                    LocalDate.parse(lineDivided[3])); //To change body of generated lambdas, choose Tools | Templates.
        }).collect(Collectors.toList());

    }

    public boolean addStudent(Student nuevo) {
        boolean ok = false;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

            String newLine = nuevo.getId() + ";" + nuevo.getName() + ";" + nuevo.getPhone() + ";"
                    + nuevo.getDateOfBirth().format(formatter) + "\n";

            Path studentFile = Paths.get(ConfigurationProperties.
                    getInstance().getStudentFile());

            Files.write(studentFile, newLine.getBytes(), StandardOpenOption.APPEND);
            ok = true;

        } catch (IOException ex) {
            Logger.getLogger(StudentServices.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ok;
    }

}
