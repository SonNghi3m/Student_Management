package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
//import se.lexicon.config.ScannerConfig;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.util.UserInputService;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws DataNotFoundException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentManagement studentManagement = context.getBean(StudentManagement.class);

        Student newStudent1 = studentManagement.create();
        System.out.println(newStudent1);
        studentManagement.save(newStudent1);
        /*System.out.println(studentManagement.findAll());
        Student newStudent2 = studentManagement.create();
        System.out.println(newStudent2);
        studentManagement.save(newStudent2);
        System.out.println(studentManagement.findAll());
        Student newStudent3 = studentManagement.create();
        System.out.println(newStudent3);
        studentManagement.save(newStudent3);
        System.out.println(studentManagement.findAll());
        System.out.println(studentManagement.find(1));
        studentManagement.remove(1);*/
        studentManagement.edit(new Student(1, "Test"));
        System.out.println(studentManagement.findAll());

    }
}
