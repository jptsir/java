package com.controller;

import com.bean.Employee;
import com.bean.Msg;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jingpengtao
 * @create 2021-11-13 17:46
 */
@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;









    @ResponseBody
    @RequestMapping(value = "/emp/{ids}",method = RequestMethod.DELETE)
    public Msg deleteEmpById(@PathVariable("ids") String ids){

        if(ids.contains("-")){
            List<Integer> del_ids = new ArrayList<>();
            String[] str_ids = ids.split("-");
          for(String string : str_ids){
              del_ids.add(Integer.parseInt(string));
          }
         employeeService.deleteBatch(del_ids);
        }else{
            int id = Integer.parseInt(ids);
            employeeService.deleteEmp(id);
        }

        return Msg.success();
    }





    @ResponseBody
    @RequestMapping(value = "/emp/{empId}",method = RequestMethod.PUT)
    public Msg saveEmp(Employee employee){
        System.out.println(employee);
        employeeService.updateEmp(employee);
        return Msg.success();
    }








@ResponseBody
@RequestMapping(value = "/emp/{id}",method = RequestMethod.GET)
public Msg getEmp(@PathVariable("id") Integer id){
    Employee employee = employeeService.getEmp(id);

    return Msg.success().add("emp",employee);
}





     @ResponseBody
     @RequestMapping(value = "/checkuser",method = {RequestMethod.POST})
      public Msg checkuser(@RequestParam("empName") String empName) {
         String regx = "(^[a-z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,6}$)";
         if(!empName.matches(regx)){
             return Msg.fail().add("va_msg","用户名必须为6-12位数字和字母的组合或者2-5位中文");
         }
        boolean b = employeeService.checkUser(empName);
        if(b){
            return Msg.success();
        }else{
            return Msg.fail().add("va_msg","用户名不可用");
        }


     }





    @RequestMapping(value = "/emp",method = RequestMethod.POST)
    @ResponseBody
    public Msg saveEmp(@Valid Employee employee, BindingResult result){
         if(result.hasErrors()){
             Map<String,Object> map = new HashMap<>();
             List<FieldError> errors = result.getFieldErrors();
             for(FieldError filedError:errors){
                 System.out.println("错误的字段名"+filedError.getField());
                 System.out.println("错误信息"+filedError.getDefaultMessage());
                 map.put(filedError.getField(),filedError.getDefaultMessage());
             }
             return Msg.fail().add("errorFields",map);
         }else{
             employeeService.saveEmp(employee);
             return Msg.success();
         }

    }



      @RequestMapping("/emps")
      @ResponseBody
      public Msg getemps(@RequestParam(value = "pn",defaultValue = "1")Integer pn) {
//        第一页每一页有五条数据
          PageHelper.startPage(pn, 5);
//把查询到的数据封装到pageinfo中  5代表的是分页条
          List<Employee> all = employeeService.getAll();
          PageInfo pageInfo = new PageInfo(all, 5);

//        model.addAttribute("pageInfo",pageInfo);
//         Msg msg = new Msg();
//         Msg success = msg.success(pageInfo);

         return Msg.success().add("pageinfo",pageInfo);

      }






////    @RequestMapping("/emps")
//    public String getemps(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){
////        第一页每一页有五条数据
//        PageHelper.startPage(pn,5);
////把查询到的数据封装到pageinfo中  5代表的是分页条
//        List<Employee> all = employeeService.getAll();
//        PageInfo pageInfo = new PageInfo(all,5);
//
//        model.addAttribute("pageInfo",pageInfo);
//        return "emplist";
//
//    }
}
