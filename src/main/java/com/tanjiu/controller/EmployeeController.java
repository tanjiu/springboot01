package com.tanjiu.controller;

import com.tanjiu.dao.DepartmentDao;
import com.tanjiu.dao.EmployeeDao;
import com.tanjiu.pojo.Department;
import com.tanjiu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.EnumMap;

/**
 * @author 叹久
 * @create 2020-02-15 15:43
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees=employeeDao.getEmployee();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //显示所有员工的信息
    @GetMapping("/emp")
    public String toAddpage(Model model){
        //查出所有部门的信息
        Collection<Department> departments=departmentDao.getDepartment();
        System.out.println(departments.toString());
        model.addAttribute("departments",departments);
        return "emp/add";
    }

    //添加员工信息
    @PostMapping("/emp")
    public String toAddpage(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //修改员工信息
    @GetMapping("/emp/{id}")
    public String toUpdateEmployee(@PathVariable("id") Integer id,Model model){
        System.out.println("执行了修改员工的mvc");
        //查出员工原来的信息
        Employee employee= employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        return "emp/update";
    }

}
