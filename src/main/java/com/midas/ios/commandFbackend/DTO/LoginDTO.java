package com.midas.ios.commandFbackend.DTO;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    @Id
    @Column(name = "emp_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String login_id;

    @NotNull
    private String name;
    @NotNull
    private String password;
    @NotNull
    private String company_code;
    @NotNull
    private String team_code;

}
