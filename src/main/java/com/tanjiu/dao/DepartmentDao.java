package com.tanjiu.dao;

import com.tanjiu.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 叹久
 * @create 2020-02-14 18:15
 */
//部门dao
    @Repository
public class DepartmentDao {
    //模拟数据库
    private static Map<Integer, Department> departmentMap=null;

    static {
        departmentMap=new HashMap<Integer, Department>();//创建一个部门表

        departmentMap.put(101,new Department(101,"教学部"));
        departmentMap.put(102,new Department(102,"市场部"));
        departmentMap.put(103,new Department(103,"教研部"));
        departmentMap.put(104,new Department(104,"运营部"));
        departmentMap.put(105,new Department(105,"后勤部"));
    }


    //获得所有部门信息
    public Collection<Department> getDepartment(){
        return departmentMap.values();
    }
    //通过id获得部门信息
    public Department getDepartmentById(Integer id){
        return departmentMap.get(id);
    }
}
