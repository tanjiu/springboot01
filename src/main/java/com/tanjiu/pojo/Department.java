package com.tanjiu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 叹久
 * @create 2020-02-14 17:29
 */
//部门表
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;

}
