package se.lexicon.data_access;

import org.springframework.beans.factory.annotation.Autowired;
import se.lexicon.data_access.IdGenerator.StudentIdGenerator;
import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;
import se.lexicon.util.UserInputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDAOListImpl implements StudentDAO{
    private List<Student> studentList = new ArrayList<>();
    @Override
    public Student save(Student student){
        if (student == null) throw new IllegalArgumentException("input student data was null");
        if(studentList.isEmpty()) {studentList.add(student);}
            for (Student element : studentList) {
                if (element.getId().equals(student.getId())) {
                    element.setName(student.getName());
                } else {
                    studentList.add(student);
                    break;
                }
            }
        System.out.println("Student's data with id: " + student.getId() + " was updated");
        return student;
    }
    @Override
    public Student find(Integer id) {
        if (id == null) throw new IllegalArgumentException("id was null");
        return studentList.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst().get();
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentList);
    }
    @Override
    public void delete(Integer id) throws DataNotFoundException {
        if (id == null) throw new IllegalArgumentException("id was null");
        Optional<Student> optionalStudent = Optional.ofNullable(find(id));
        if (!optionalStudent.isPresent()) throw new DataNotFoundException("data not found exception");
        else studentList.remove(optionalStudent.get());
    }
}
