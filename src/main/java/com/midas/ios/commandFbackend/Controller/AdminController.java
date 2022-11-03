package com.midas.ios.commandFbackend.Controller;

import com.midas.ios.commandFbackend.DTO.AdminDTO;
import com.midas.ios.commandFbackend.DTO.AdminDetailDTO;
import com.midas.ios.commandFbackend.DTO.EmpDTO;
import com.midas.ios.commandFbackend.DTO.LoginDTO;
import com.midas.ios.commandFbackend.Service.EmpService;
import com.midas.ios.commandFbackend.Service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

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

    @PostMapping("/emp/{work_date}/{emp_id}")
    @ResponseBody
    public AdminDTO LookupEmp(@PathVariable("emp_id") Long emp_id,@PathVariable("work_date")String work_date){

        LoginDTO loginDTO= loginService.getUser(emp_id);

        EmpDTO empDTO=empService.getUser(emp_id,work_date);

        AdminDTO adminDTO= new AdminDTO(empDTO.getEmp_id(), loginDTO.getName(), empDTO.getAttend(),empDTO.getLeave_work());
        System.out.println(adminDTO.toString());

        return adminDTO;
    }

    @PostMapping("/emp/edit")
    public ResponseEntity<LoginDTO> editUser(@RequestBody LoginDTO loginDTO){
         String name=loginDTO.getName();
         String password=loginDTO.getPassword();
         String company_code=loginDTO.getCompany_code();
         String team_code=loginDTO.getTeam_code();
         Long Id = loginDTO.getId();

        LoginDTO response = loginService.editUser(name,password,company_code,team_code,Id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }
}
