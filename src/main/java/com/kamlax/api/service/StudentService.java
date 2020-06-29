/**
 *
 */
package com.kamlax.api.service;

import java.util.List;

import com.kamlax.api.domain.Student;

/**
 * @author Rashedul.Hasan.Khan
 *
 */
public interface StudentService {

    /**
     *
     * @param student
     * @return
     */
    int saveStudent(Student student);

    /**
     *
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     *
     * @param id
     * @return
     */
    int deleteStudent(String id);

    /**
     *
     * @return
     */
    List<Student> getStudentList();

    /**
     *
     * @return
     */
    int createStudentTable();

}
