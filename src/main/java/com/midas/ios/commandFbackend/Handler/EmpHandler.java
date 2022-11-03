package com.midas.ios.commandFbackend.Handler;

import com.midas.ios.commandFbackend.DAO.EmpDAO;
import com.midas.ios.commandFbackend.Entity.EmpEntity;
import com.midas.ios.commandFbackend.Entity.loginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@Service
@Transactional
public class EmpHandler {
    EmpDAO empDAO;

    @Autowired
    public EmpHandler(EmpDAO empDAO){ this.empDAO=empDAO; }

    public EmpEntity Attend(Long id, Long fk_emp_id, String attend, String leave_work
            ,Date work_date) {
        EmpEntity empEntity = new EmpEntity(id,fk_emp_id,attend,leave_work,work_date);

        return empDAO.Attend(empEntity);
    }

    public EmpEntity leaveWork(Long fk_emp_id, String leave_work){
        EmpEntity empEntity = new EmpEntity(fk_emp_id, leave_work);
        return empDAO.LeaveWork(leave_work,fk_emp_id);
    }

    public EmpEntity applyWorkFromHome(Long fk_emp_id){
        EmpEntity empEntity = new EmpEntity(fk_emp_id);
        return empDAO.applyWorkFromHome(fk_emp_id);
    }
    public EmpEntity applyAbsent(Long fk_emp_id){
        EmpEntity empEntity = new EmpEntity(fk_emp_id);
        return empDAO.applyAbsent(fk_emp_id);
    }
    public EmpEntity applyLeave(Long fk_emp_id){
        EmpEntity empEntity = new EmpEntity(fk_emp_id);
        return empDAO.applyLeave(fk_emp_id);
    }

    public EmpEntity getEmpEntity(Long emp_id,String work_date){
        return empDAO.getEmp(emp_id,work_date);
    }


}
