package com.dao;

import com.bean.Employee;
import com.bean.EmployeeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmployeeMapper {
    long countByExample(EmployeeExample example);

    int deleteByExample(EmployeeExample example);

    int deleteByPrimaryKey(Integer empId);

    int insert(Employee record);

    int insertSelective(Employee record);

    List<Employee> selectByExample(EmployeeExample example);

    Employee selectByPrimaryKey(Integer empId);
/*<select id="selectByExampleWithDept" resultMap="WithDeptResultMap">

  <select id="selectByPrimaryKeyWithDept" resultMap="WithDeptResultMap">

  </select>*/
     List<Employee> selectByExampleWithDept(EmployeeExample example);

    Employee selectByPrimaryKeyWithDept(Integer empId);
    int updateByExampleSelective(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByExample(@Param("record") Employee record, @Param("example") EmployeeExample example);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);
}