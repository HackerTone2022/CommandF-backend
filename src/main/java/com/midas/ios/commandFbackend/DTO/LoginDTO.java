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

    public LoginDTO(String name, String password, String company_code, String team_code, Long id) {
        this.name=name;
        this.password=password;
        this.company_code=company_code;
        this.team_code=team_code;
        this.Id=id;
    }
}
