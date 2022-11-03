package com.midas.ios.commandFbackend.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/account")
public class loginController {

    private loginService loginService;

    public loginController(loginService loginService){
        this.loginService=loginService;
    }
    @GetMapping
    @ResponseBody
    public String Home(){
        return "Home";
    }

    @GetMapping("/next")
    @ResponseBody
    public String Next(){
        return "Next";
    }

    @PostMapping(value = "/create")
    public ResponseEntity<loginDTO> createUserAccount(@Valid @RequestBody loginDTO loginDTO){

        Long Id = loginDTO.getId();
        String name = loginDTO.getName();
        String password = loginDTO.getPassword();
        String company_code= loginDTO.getCompany_code();
        String team_code = loginDTO.getTeam_code();

        loginDTO response = loginService.saveUser(Id, name, password, company_code, team_code);


        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PostMapping(value = "/get")
    public String login(@Valid @RequestBody IdPasswordDTO idPasswordDTO){

        loginDTO loginDTO = loginService.getUser(idPasswordDTO.getId());
        if(idPasswordDTO.getPassword()== loginDTO.getPassword()){return "redirect:/next";}
        else{return "redirect:/account";}
    }


}
