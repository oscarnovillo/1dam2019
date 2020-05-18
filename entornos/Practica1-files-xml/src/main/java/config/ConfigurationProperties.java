/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author roble
 */
public class ConfigurationProperties {

    private static ConfigurationProperties config;

    private String studentFile;
    private String teacherFile;

    private ConfigurationProperties() {

    }

    public String getStudentFile() {
        return studentFile;
    }

    public String getTeacherFile() {
        return teacherFile;
    }

    public void setStudentFile(String studentFile) {
        this.studentFile = studentFile;
    }

    public void setTeacherFile(String teacherFile) {
        this.teacherFile = teacherFile;
    }

    public static ConfigurationProperties getInstance() {
        if (config == null) {
            try {
                config = new ConfigurationProperties();
                Properties p = new Properties();
                p.load(new FileInputStream("config/paths.properties"));
                config.studentFile = p.getProperty("studentFile");
                config.teacherFile = p.getProperty("teacherFile");
            } catch (Exception ex) {
                Logger.getLogger(ConfigurationProperties.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return config;
    }

}
