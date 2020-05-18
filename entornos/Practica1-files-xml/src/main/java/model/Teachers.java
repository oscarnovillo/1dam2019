/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)

public class Teachers {

    private List<Teacher> teacher;


    public Teachers() {
    }

    public Teachers(List<Teacher> teachers) {
        this.teacher = teachers;
    }

    public List<Teacher> getTeachers() {
        return teacher;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teacher = teachers;
    }

    @Override
    public String toString() {
        return "Teachers{" + "teachers=" + teacher + '}';
    }


}
