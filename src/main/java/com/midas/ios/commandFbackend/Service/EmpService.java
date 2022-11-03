package com.midas.ios.commandFbackend.Service;

import com.midas.ios.commandFbackend.DAO.EmpDAO;
import com.midas.ios.commandFbackend.DTO.EmpDTO;
import com.midas.ios.commandFbackend.DTO.LoginDTO;
import com.midas.ios.commandFbackend.Entity.EmpEntity;
import com.midas.ios.commandFbackend.Entity.loginEntity;
import com.midas.ios.commandFbackend.Handler.EmpHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@Service
public class EmpService {
    EmpHandler empHandler;

    @Autowired
    public EmpService(EmpHandler empHandler){this.empHandler=empHandler;}

    public EmpDTO Attend(Long id, Long fk_emp_id, String attend, String leave_work
            ,Date work_date) {
        EmpEntity empEntity = empHandler.Attend(id,fk_emp_id,attend,leave_work,work_date);

        EmpDTO empDTO = new EmpDTO(id,fk_emp_id,attend,work_date);
        return empDTO;
    }

    public EmpDTO leaveWork(Long emp_id, String leave_work){
        EmpEntity empEntity = empHandler.leaveWork(emp_id,leave_work);
        EmpDTO empDTO = new EmpDTO(emp_id, leave_work);
        return empDTO;
    }

    public EmpDTO applyWorkFromHome(Long fk_emp_id){
        EmpEntity empEntity = empHandler.applyWorkFromHome(fk_emp_id);
        EmpDTO empDTO = new EmpDTO(fk_emp_id);
        return empDTO;
    }
    public EmpDTO applyAbsent(Long fk_emp_id){
        EmpEntity empEntity = empHandler.applyAbsent(fk_emp_id);
        EmpDTO empDTO = new EmpDTO(fk_emp_id);
        return empDTO;
    }
    public EmpDTO applyLeave(Long fk_emp_id){
        EmpEntity empEntity = empHandler.applyLeave(fk_emp_id);
        EmpDTO empDTO = new EmpDTO(fk_emp_id);
        return empDTO;
    }

    public EmpDTO getUser(Long emp_id){
        EmpEntity empEntity = empHandler.getEmpEntity(emp_id);

        EmpDTO empDTO = new EmpDTO(empEntity.getId(),empEntity.getEmp_id(), empEntity.getAttend(),empEntity.getLeave_work());

        return empDTO;
    }
}
