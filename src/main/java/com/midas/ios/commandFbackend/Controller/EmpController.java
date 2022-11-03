package com.midas.ios.commandFbackend.Controller;


import com.midas.ios.commandFbackend.DTO.ApplyDTO;
import com.midas.ios.commandFbackend.DTO.EmpDTO;
import com.midas.ios.commandFbackend.DTO.LeaveDTO;
import com.midas.ios.commandFbackend.Service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

@Controller
@RequestMapping(value = "/Emp")
public class EmpController {
    EmpService empService;

    @Autowired
    public EmpController(EmpService empService) {
        this.empService = empService;
    }

    @PostMapping("/attend")
    public String attend(@Valid @RequestBody EmpDTO empDTO) {

        Long id = empDTO.getId();
        Long fk_emp_id = empDTO.getEmp_id();
        String attend = empDTO.getAttend();
        String leave_work = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date work_date = new Date(System.currentTimeMillis());

        EmpDTO response = empService.Attend(id,fk_emp_id,attend,leave_work,work_date);
        System.out.println(response.toString());

        return "redirect:/";
    }

    @PostMapping("/leave")
    public String leaveWork(@Valid @RequestBody LeaveDTO leaveDTO) {

        EmpDTO response = empService.leaveWork(leaveDTO.getEmp_id(), leaveDTO.getLeave_work());
        System.out.println(response.toString());
        return "redirect:/";
    }

    @PostMapping("/apply")
    public String Apply(@Valid @RequestBody ApplyDTO applyDTO){
        try {
            if (applyDTO.isHome_apply()) empService.applyWorkFromHome(applyDTO.getEmp_id());
            if (applyDTO.isAbsent_apply()) empService.applyAbsent(applyDTO.getEmp_id());
            if (applyDTO.isLeave_apply()) empService.applyLeave(applyDTO.getEmp_id());
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }finally {
            return "redirect:/";
        }
    }


}