/**
 *
 */
package com.kamlax.api.repository;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.kamlax.api.domain.Student;

/**
 * @author Rashedul.Hasan.Khan
 *
 */
@Repository
public interface StudentDao {

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
    int deleteStudent(@Param("id") String id);

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
