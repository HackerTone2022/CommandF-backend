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

    private LocalTime attend;
    private LocalTime leave_work;

    private Date date;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private boolean home;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  boolean absent;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  boolean leave;


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private boolean home_apply;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  boolean absent_apply;

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  boolean leave_apply;


    public EmpEntity(Long id, Long fk_emp_id, LocalTime attend, Date date) {
        this.id=id;
        this.emp_id=fk_emp_id;
        this.attend=attend;
        this.date=date;
    }

    public EmpEntity(Long fk_emp_id, LocalTime leave_work) {
        this.emp_id=fk_emp_id;
        this.leave_work=leave_work;
    }
    public EmpEntity(Long fk_emp_id){
        this.emp_id=fk_emp_id;
    }

    public EmpEntity(Long id, Long fk_emp_id, LocalTime attend, LocalTime leave_work, Date date) {
        this.id=id;
        this.emp_id=fk_emp_id;
        this.attend=attend;
        this.leave_work = leave_work;
        this.date=date;
    }
}
