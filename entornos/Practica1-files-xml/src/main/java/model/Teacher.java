/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Teacher {

    private String nif;
    private String name;
    private List<Student> students;


    public Teacher() {
        students = new ArrayList<>();
    }

    public Teacher(String nif, String name) {
        this();
        this.nif = nif;
        this.name = name;
    }

    public Teacher(String nif, String name, List<Student> students) {
        this();
        this.nif = nif;
        this.name = name;
        this.students = students;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students.stream().collect(Collectors.toList());
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public String toString() {
        return "Teacher{" + "nif=" + nif + ", name=" + name + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(getNif(), teacher.getNif());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNif());
    }
}
