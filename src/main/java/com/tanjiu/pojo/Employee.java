package com.tanjiu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author 叹久
 * @create 2020-02-14 18:11
 */
@Data
@NoArgsConstructor
//@AllArgsConstructor
//员工表
public class Employee {
    private  Integer id;
    private  String lastName;
    private  String email;
    private  Integer gender;//0 女 1 男

    private Department department;
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birth = new Date();
    }
}
