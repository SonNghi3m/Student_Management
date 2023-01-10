package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.config.ScannerConfig;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.util.UserInputService;

import java.util.Scanner;

public class App
{
    public static void main( String[] args )
    {
        AnnotationConfigApplicationContext StudentContext = new AnnotationConfigApplicationContext(ComponentScanConfig.class);
        StudentDAO studentDAO = StudentContext.getBean(StudentDAO.class);
        AnnotationConfigApplicationContext ScannerContext = new AnnotationConfigApplicationContext(ScannerConfig.class);
        UserInputService userInputService = ScannerContext.getBean(UserInputService.class);
    }
}
