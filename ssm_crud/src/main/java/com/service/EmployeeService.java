package com.service;

import com.bean.Employee;
import com.bean.EmployeeExample;
import com.dao.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jingpengtao
 * @create 2021-11-13 17:51
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;
    public List<Employee> getAll(){
       return  employeeMapper.selectByExampleWithDept(null);
//        return employeeMapper.selectByExampleWit
    }

    public void saveEmp(Employee employee){
        employeeMapper.insertSelective(employee);
    }
    //检验用户名是否可用
    public boolean checkUser(String empName){
        EmployeeExample exmple = new EmployeeExample();
        //创建查询条件
        EmployeeExample.Criteria criteria = exmple.createCriteria();
        criteria.andEmpNameEqualTo(empName);
        long l = employeeMapper.countByExample(exmple);
        return l == 0;
    }
//按照员工id查询员工
    public Employee getEmp(Integer id) {
        Employee employee = employeeMapper.selectByPrimaryKey(id);
        return employee;
    }
//员工更新
    public void updateEmp(Employee employee) {
        int i = employeeMapper.updateByPrimaryKeySelective(employee);


    }



    public void deleteEmp(Integer id) {
        int i = employeeMapper.deleteByPrimaryKey(id);

    }

public void deleteBatch(List<Integer> ids){
    EmployeeExample example = new EmployeeExample();
    EmployeeExample.Criteria criteria = example.createCriteria();
    criteria.andEmpIdIn(ids);
    employeeMapper.deleteByExample(example);
}
}
