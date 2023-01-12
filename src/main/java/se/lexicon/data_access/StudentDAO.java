package se.lexicon.data_access;

import se.lexicon.exceptions.DataNotFoundException;
import se.lexicon.models.Student;

import java.util.List;

public interface StudentDAO {
    Student save (Student student);
    Student find (Integer id);
    List<Student> findAll();
    void delete (Integer id) throws DataNotFoundException;
}
