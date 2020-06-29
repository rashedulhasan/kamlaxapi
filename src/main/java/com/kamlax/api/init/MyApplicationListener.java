/**
 *
 */
package com.kamlax.api.init;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;

/**
 * @author Rashedul.Hasan.Khan
 *
 */
public class MyApplicationListener implements WebApplicationInitializer {

    private static final Logger log = LoggerFactory
            .getLogger(MyApplicationListener.class);

    /**
     *
     * @param container
     */
    public void onStartup(ServletContext container) {
        Connection con;
        log.info("Listening now...");
        System.out.println("Listening now.....");

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace(System.out);
        }
        try {
            System.out.println("Connecting to DB");
            con = DriverManager
                    .getConnection("jdbc:hsqldb:kamlaxapi;hsqldb.lock_file=false", "SA", "");
            System.out.println("Creating table");
            con.createStatement()
                    .executeUpdate(
                            "CREATE TABLE IF NOT EXISTS student (id varchar(60), name\n"
                            + "        varchar(45),address varchar(100),age\n"
                            + "        integer)");

//            con.createStatement()
//                    .executeUpdate(
//                            "drop table student");
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            con = null;
        }
        System.out.println("Finished on startup tasks");
    }

}
