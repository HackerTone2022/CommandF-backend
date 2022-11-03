package com.midas.ios.commandFbackend.Controller;

import com.midas.ios.commandFbackend.DTO.AdminDTO;
import com.midas.ios.commandFbackend.DTO.EmpDTO;
import com.midas.ios.commandFbackend.DTO.LoginDTO;
import com.midas.ios.commandFbackend.Service.EmpService;
import com.midas.ios.commandFbackend.Service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/Admin")
public class AdminController {
    EmpService empService;
    loginService loginService;

    @Autowired
    public  AdminController(EmpService empService, loginService loginService){
        this.empService=empService;
        this.loginService=loginService;
    }
    @PostMapping("/emp/{emp_id}")
    @ResponseBody
    public AdminDTO LookupEmp(@PathVariable("emp_id") Long emp_id){

        LoginDTO loginDTO= loginService.getUser(emp_id);

        EmpDTO empDTO=empService.getUser(emp_id);

        AdminDTO adminDTO= new AdminDTO(empDTO.getEmp_id(), loginDTO.getName(), empDTO.getAttend(),empDTO.getLeave_work());
        System.out.println(adminDTO.toString());

        return adminDTO;
    }
}
