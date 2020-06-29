/**
 *
 */
package com.kamlax.api.domain;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Rashedul.Hasan.Khan
 *
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    private String id = UUID.randomUUID().toString();
    private String name;
    private String address;
    private int age;

    public Student() {

    }

    public Student(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
