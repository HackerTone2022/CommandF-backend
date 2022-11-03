package com.midas.ios.commandFbackend.Controller;


import com.midas.ios.commandFbackend.DTO.IdPasswordDTO;
import com.midas.ios.commandFbackend.DTO.LoginDTO;
import com.midas.ios.commandFbackend.Service.loginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

@Controller
@RequestMapping(value = "/account")
public class loginController {

    private loginService loginService;

    @Autowired
    public loginController(loginService loginService){
        this.loginService=loginService;
    }

    @GetMapping("/home")
    public String Home(){
        return "";
    }

    @GetMapping("/next")
    public String Next(){
        return "";
    }

    @PostMapping(value = "/create")
    public ResponseEntity<LoginDTO> createUserAccount(@Valid @RequestBody LoginDTO loginDTO){

        Long Id = loginDTO.getId();
        String login_id = loginDTO.getLogin_id();
        String name = loginDTO.getName();
        String password = loginDTO.getPassword();
        String company_code= loginDTO.getCompany_code();
        String team_code = loginDTO.getTeam_code();

        LoginDTO response = loginService.saveUser(Id, login_id, name, password, company_code, team_code);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
    }

    @PostMapping(value = "/get")
    public String login(@Valid @RequestBody IdPasswordDTO idPasswordDTO){

        LoginDTO loginDTO = loginService.findByLoginId(idPasswordDTO.getLogin_id());
        //System.out.println("idPasswordDTO: "+idPasswordDTO.getPassword());
        //System.out.println("LoginDTO: "+loginDTO.getPassword());

        if(Objects.equals(idPasswordDTO.getPassword(), loginDTO.getPassword()))
        {return "redirect:/account/next";}

        else{return "redirect:/account/Home";}
    }


}
