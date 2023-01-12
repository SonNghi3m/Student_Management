package se.lexicon.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class ScannerInputService implements UserInputService{

    Scanner scanner;

    @Autowired
    public ScannerInputService(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public String getString() {
        System.out.println("Enter student's name:");
        return scanner.nextLine();
    }

    @Override
    public int getInt() {
        System.out.println("Enter student's ID:");
        return Integer.parseInt(scanner.nextLine());
    }
}
