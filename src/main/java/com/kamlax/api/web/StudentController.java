/**
 *
 */
package com.kamlax.api.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kamlax.api.constants.Constants;
import com.kamlax.api.domain.Student;
import com.kamlax.api.service.StudentService;
import com.kamlax.api.util.CryptoUtil;
import com.kamlax.api.util.GeneralUtil;

import flexjson.JSONSerializer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Rashedul.Hasan.Khan
 *
 */
@Controller
@RequestMapping("/student")
public class StudentController {

    // ---- members
    private StudentService studentService;
    private static final Logger log = LoggerFactory
            .getLogger(StudentController.class);

    @Autowired
    public StudentController(final StudentService studentService) {
        this.studentService = studentService;
    }

    /**
     *
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    String listStudents() {
        log.info("Getting student list");
        List<Student> students = null;
        JSONSerializer jsonSerializer = null;

        try {
            students = studentService.getStudentList();
            log.info("list size=" + students.size());
            jsonSerializer = new JSONSerializer().prettyPrint(true);
            return jsonSerializer.exclude("*.class").serialize(students);
        } catch (Exception ex) {
            log.error("Error occurred while fetching Student list:"
                    + ex.getMessage());
            return Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                    + "Error occurred while fetching Student list ";
        } finally {
            students = null;
            jsonSerializer = null;

        }

    }

    /**
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    String saveStudent(@RequestBody Student student) {
        log.info("Saving Student " + student.getName() + " id=" + student.getId());
        if (GeneralUtil.isEmpty(student.getName())) {
            return Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                    + "Studentname  value is empty";
        }
        if (GeneralUtil.isEmpty(student.getAddress())) {
            return Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                    + "Address  value is empty";
        }
        try {
            int saveStudentOperation = studentService.saveStudent(student);
            if (saveStudentOperation == 1) {
                return Constants.SUCCESS_MESSAGE_PREFIX + Constants.COLON
                        + "Successfully saved Student";
            } else {
                return Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                        + "Error while saving Student";
            }

        } catch (Exception ex) {
            log.error("Error while saving Student:" + ex.getMessage());
            return Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                    + "Error while saving Student";
        } finally {
            student = null;
        }
    }

    /**
     *
     * @param student
     * @return
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    String updateStudent(@RequestBody Student student) {
        log.info("Updating Student");
        if (GeneralUtil.isEmpty(student.getName())) {
            return Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                    + "Studentname  value is empty";
        }
        if (GeneralUtil.isEmpty(student.getAddress())) {
            return Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                    + "Address  value is empty";
        }

        try {
            int updateStudentOperation = studentService.updateStudent(student);

            if (updateStudentOperation == 1) {
                return Constants.SUCCESS_MESSAGE_PREFIX + Constants.COLON
                        + "Successfully updated Student";
            } else {
                return Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                        + "Error while saving Student";
            }

        } catch (Exception ex) {
            log.error("Error while updating Student:" + ex.getMessage());
            return Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                    + "Error while updating Student";
        } finally {
            student = null;
        }
    }

    /**
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    String deleteStudent(@RequestParam(required = true) String id) {
        log.info("decrypting id =" + id);
        System.out.println("decrypting id =" + id);
        id = CryptoUtil.decrypt(id);
        log.info("Deleting Student with id =" + id);
        try {
            if (GeneralUtil.isEmpty(id)) {
                return CryptoUtil.encrypt(Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                        + "No id found");
            }
            int deleteStudentOperation = studentService.deleteStudent(id);
            if (deleteStudentOperation == 1) {
                return CryptoUtil.encrypt(Constants.SUCCESS_MESSAGE_PREFIX + Constants.COLON
                        + "Successfully deleted Student");
            } else {
                return CryptoUtil.encrypt(Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                        + "Error occured while deleting Student");
            }
        } catch (Exception ex) {
            log.error("Error occured while deleting Student:" + ex.getMessage());
            return CryptoUtil.encrypt(Constants.ERROR_MESSAGE_PREFIX + Constants.COLON
                    + "Error occured while deleting Student");
        } finally {
            id = "";
        }
    }

}
