package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.data_access.IdGenerator.StudentIdGenerator;
import se.lexicon.data_access.StudentDAO;
import se.lexicon.data_access.StudentDAOListImpl;
import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.List;
import java.util.Optional;

@Component
public class StudentManagementConsoleImpl implements StudentManagement{

    UserInputService scannerService;
    StudentDAO studentDAO;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService scannerService, StudentDAO studentDAO) {
        this.scannerService = scannerService;
        this.studentDAO = studentDAO;
    }
    @Override
    public Student create() {
        Student newStudent = new Student(scannerService.getString());
        //Integer studentId = StudentIdGenerator.generateStudentIdNumber();
        Integer studentId = 1;
        newStudent.setId(studentId);
        System.out.println("Student data was created.");
        return newStudent;
    }
    @Override
    public Student save(Student student) {
        if(student == null) throw new IllegalArgumentException("student was null");
        studentDAO.save(student);
        return student;
    }
    @Override
    public Student find(int id) {
        id = studentDAO.find(scannerService.getInt()).getId();
        return studentDAO.find(id);
    }

    @Override
    public Student remove(Integer id) throws DataNotFoundException {
        if (id == null) throw new IllegalArgumentException("id was null");
        Optional<Student> optionalStudent = Optional.ofNullable(find(id));
        if (!optionalStudent.isPresent()) throw new DataNotFoundException("data not found exception");
        else {
            studentDAO.delete(id);
        }
        System.out.println("Student with id " + id + " was removed!");
        return optionalStudent.get();
    }

    @Override
    public List<Student> findAll() {
        return studentDAO.findAll();
    }

    @Override
    public Student edit(Student student) throws DataNotFoundException{
        if (student == null) throw new IllegalArgumentException("student was null");
        Optional<Student> optionalStudent = Optional.ofNullable(find(student.getId()));
        if (!optionalStudent.isPresent()) {
            throw new DataNotFoundException("data not found exception");
        }
         studentDAO.save(student);
        System.out.println("Student information updated!");
        return student;
    }
}
