package se.lexicon.data_access;

import org.springframework.stereotype.Component;
import se.lexicon.data_access.IdGenerator.StudentIdGenerator;
import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class StudentDAOListImpl implements StudentDAO{

    private List<Student> studentList = new ArrayList<>();
    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("input student data was null");
        Integer studentId = StudentIdGenerator.generateStudentIdNumber();
        student.setId(studentId);
        studentList.add(student);
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
    public void delete(int id) throws DataNotFoundException {
        Optional<Student> optionalStudent = Optional.ofNullable(find(id));
        if (!optionalStudent.isPresent()) throw new DataNotFoundException("data not found exception");
        else studentList.remove(optionalStudent.get());
    }
}
