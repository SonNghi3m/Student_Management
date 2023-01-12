package se.lexicon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.data_access.StudentDAOListImpl;
import se.lexicon.models.Student;
import se.lexicon.service.StudentManagement;
import se.lexicon.service.StudentManagementConsoleImpl;

import java.util.Scanner;

@Configuration
@ComponentScan(basePackages = "se.lexicon")
public class ComponentScanConfig {
    @Bean
    public StudentDAO studentDAO() {return new StudentDAOListImpl();}
    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

}
