package com.midas.ios.commandFbackend.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Table(name = "emp")
public class EmpEntity {

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


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private boolean is_home;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  boolean is_absent;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  boolean is_leave;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private boolean home_apply;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  boolean absent_apply;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  boolean leave_apply;


    public EmpEntity(Long id, Long fk_emp_id, String attend, Date work_date) {
        this.id=id;
        this.emp_id=fk_emp_id;
        this.attend=attend;
        this.work_date=work_date;
    }

    public EmpEntity(Long fk_emp_id, String leave_work) {
        this.emp_id=fk_emp_id;
        this.leave_work=leave_work;
    }
    public EmpEntity(Long fk_emp_id){
        this.emp_id=fk_emp_id;
    }

    public EmpEntity(Long id, Long fk_emp_id, String attend, String leave_work, Date work_date) {
        this.id=id;
        this.emp_id=fk_emp_id;
        this.attend=attend;
        this.leave_work = leave_work;
        this.work_date=work_date;
    }
}
