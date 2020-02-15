package com.tanjiu.dao;

import com.tanjiu.pojo.Department;
import com.tanjiu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 叹久
 * @create 2020-02-14 18:23
 */
@Repository
public class EmployeeDao {
    //模拟数据库
    private static Map<Integer, Employee> employeeMap=null;
    //员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employeeMap=new HashMap<Integer, Employee>();//创建一个员工表

        employeeMap.put(1001,new Employee(1001,"aa","a123456@qq.com",1,new Department(101,"教学部")));
        employeeMap.put(1002,new Employee(1002,"bb","b123456@qq.com",0,new Department(102,"市场部")));
        employeeMap.put(1003,new Employee(1003,"cc","c123456@qq.com",1,new Department(103,"教研部")));
        employeeMap.put(1004,new Employee(1004,"dd","d123456@qq.com",0,new Department(104,"运营部")));
        employeeMap.put(1005,new Employee(1005,"ee","e123456@qq.com",1,new Department(105,"后勤部")));
    }

    //增加一个员工，主键自增
    private   static  Integer initId=1006;
    public void  save(Employee employee){
        if(employee.getId()==null){
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
    //获得所有员工信息
    public Collection<Employee> getEmployee(){
        return employeeMap.values();
    }
    //通过id获得员工信息
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    //删除员工
    public void deleteEmployee(Integer id){
        employeeMap.remove(id);
    }
}
