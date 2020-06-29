/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kamlax.api.service;

import com.kamlax.api.domain.Student;
import com.kamlax.api.repository.StudentDao;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

/**
 *
 * @author Rashedul.Hasan.Khan
 */
public class StudentServiceImplTest {

    //---- members
    @Mock
    private StudentDao studentDao;
    private StudentService studentService;

    private Student student = new Student("Hanif", "Jasin", 25);

    //---- methods
    @Before
    public void setUp() {
        // create the mocks
        MockitoAnnotations.initMocks(this);
        
        when(studentDao.saveStudent(student)).thenReturn(1);
        when(studentDao.updateStudent(student)).thenReturn(1);
        when(studentDao.deleteStudent(student.getId())).thenReturn(1);

        List<Student> studentList = new ArrayList<>(Arrays.asList(student));
        when(studentDao.getStudentList()).thenReturn(studentList);

        studentService = new StudentServiceImpl(studentDao);
    }

    /**
     *
     */
    @Test
    public void testGetStudentList() {
        System.out.println("getStudentList");

        // Exercise controller    
        List<Student> studentList = studentService.getStudentList();

        // Verify behavior
        verify(studentDao, times(1)).getStudentList();

        // Verify results
        assertEquals(1, studentList.size());
        Student student = studentList.get(0);
        assertEquals("Hanif", student.getName());
    }

    /**
     *
     */
    @Test
    public void testSaveStudent() {
        System.out.println("save");
        int expResult = 1;
        int result = studentService.saveStudent(student);
        // Verify behavior
        verify(studentDao, times(1)).saveStudent(student);
        // Verify results
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testUpdateStudent() {
        System.out.println("update");
        int expResult = 1;
        int result = studentService.updateStudent(student);
        // Verify behavior
        verify(studentDao, times(1)).updateStudent(student);
        // Verify results
        assertEquals(expResult, result);
    }

    /**
     *
     */
    @Test
    public void testDeleteStudent() {
        System.out.println("delete");
        int expResult = 1;
        int result = studentService.deleteStudent(student.getId());
        // Verify behavior
        verify(studentDao, times(1)).deleteStudent(student.getId());
        // Verify results
        assertEquals(expResult, result);
    }
}
