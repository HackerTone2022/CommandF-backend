package com.midas.ios.commandFbackend.Controller;


import com.midas.ios.commandFbackend.DTO.EmpDTO;
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
    public ResponseEntity<EmpDTO> attend(@Valid @RequestBody EmpDTO empDTO) {

        Long id = empDTO.getId();
        Long fk_emp_id = empDTO.getEmp_id();
        LocalTime attend = LocalTime.now();
        LocalTime leave_work = null;
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());

        System.out.printf(empDTO.toString());

        EmpDTO response = empService.Attend(id,fk_emp_id,attend,leave_work,date);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PostMapping("/leave")
    public EmpDTO leaveWork(@Valid @RequestBody EmpDTO empDTO) {
        return empService.leaveWork(empDTO.getEmp_id(), empDTO.getLeave_work());
    }

}