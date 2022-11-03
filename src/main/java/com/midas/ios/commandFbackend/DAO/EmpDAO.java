package com.midas.ios.commandFbackend.DAO;


import com.midas.ios.commandFbackend.Entity.EmpEntity;
import com.midas.ios.commandFbackend.Repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalTime;

@Service
public class EmpDAO {
    EmpRepository empRepository;

    @Autowired
    public EmpDAO(EmpRepository empRepository){
        this.empRepository=empRepository;
    }

    public EmpEntity Attend(EmpEntity empEntity){
        empRepository.save(empEntity);
        return empEntity;
    }
    public EmpEntity LeaveWork(String leave_work, Long emp_id){
         EmpEntity empEntity= empRepository.setLeaveTime(leave_work,emp_id);
        return empEntity;
    }

    public EmpEntity applyWorkFromHome(Long emp_id){
        EmpEntity empEntity=empRepository.applyWorkFromHome(emp_id);
        return empEntity;
    }
    public EmpEntity applyAbsent(Long emp_id){
        EmpEntity empEntity=empRepository.applyAbsent(emp_id);
        return empEntity;
    }
    public EmpEntity applyLeave(Long emp_id){
        EmpEntity empEntity=empRepository.applyLeave(emp_id);
        return empEntity;
    }
}
