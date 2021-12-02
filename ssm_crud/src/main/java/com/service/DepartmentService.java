package com.service;

import com.bean.Department;
import com.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingpengtao
 * @create 2021-11-17 16:46
 */
@Service
public class DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;
     public List<Department> getDepts(){
         List<Department> departments = departmentMapper.selectByExample(null);

         return departments;
}
}
