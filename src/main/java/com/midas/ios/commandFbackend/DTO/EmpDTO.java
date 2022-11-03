package com.midas.ios.commandFbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmpDTO {
    @Id
    @Column(name = "pk_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "fk_emp_id")
    private Long emp_id;

    private String attend;
    private String leave_work;

    private Date work_date;



    private boolean is_home;


    private  boolean is_absent;


    private  boolean is_leave;



    private boolean home_apply;


    private  boolean absent_apply;


    private  boolean leave_apply;

    public EmpDTO(Long id, Long fk_emp_id, String attend, Date work_date) {
        this.id=id;
        this.emp_id=fk_emp_id;
        this.attend=attend;
        this.work_date=work_date;
    }

    public EmpDTO(Long emp_id, String leave_work) {
        this.emp_id=emp_id;
        this.leave_work=leave_work;
    }
    public EmpDTO(Long fk_emp_id){
        this.emp_id=fk_emp_id;
    }

    public EmpDTO(Long id, Long emp_id, String attend, String leave_work) {
        this.id=id;
        this.emp_id=emp_id;
        this.attend=attend;
        this.leave_work=leave_work;

    }
}
