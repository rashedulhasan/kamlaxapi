/**
 *
 */
package com.kamlax.api.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kamlax.api.domain.Student;
import com.kamlax.api.repository.StudentDao;

/**
 * @author Rashedul.Hasan.Khan
 *
 */
@Service
public class StudentServiceImpl implements StudentService {

    // ---- members
    private StudentDao studentDao;

    // ---- methods
    /**
     *
     * @param studentDao
     */
    @Autowired
    public StudentServiceImpl(final StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    /**
     * {@inheritDoc}
     */
    public int saveStudent(Student student) {
        return studentDao.saveStudent(student);
    }

    /**
     * {@inheritDoc}
     */
    public int updateStudent(Student student) {
        return studentDao.updateStudent(student);
    }

    /**
     * {@inheritDoc}
     */
    public int deleteStudent(String id) {
        return studentDao.deleteStudent(id);
    }

    /**
     * {@inheritDoc}
     */
    public List<Student> getStudentList() {
        return studentDao.getStudentList();
    }

    public int createStudentTable() {
        return studentDao.createStudentTable();
    }

}
