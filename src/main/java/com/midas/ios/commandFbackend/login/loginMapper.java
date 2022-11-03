package com.midas.ios.commandFbackend.login;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "useraccount")
public class loginMapper {

    @Id
    @Column(name = "emp_Id")
    private Long Id;

    private String name;
    private String Password;
    private String company_code;
    private String team_code;

}
