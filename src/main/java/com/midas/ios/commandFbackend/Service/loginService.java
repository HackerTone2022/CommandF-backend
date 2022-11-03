package com.midas.ios.commandFbackend.Service;

import com.midas.ios.commandFbackend.DTO.LoginDTO;
import com.midas.ios.commandFbackend.Entity.loginEntity;
import com.midas.ios.commandFbackend.Handler.loginHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginService {
    com.midas.ios.commandFbackend.Handler.loginHandler loginHandler;

    @Autowired
    public loginService(loginHandler loginHandler){
        this.loginHandler=loginHandler;
    }


    public LoginDTO saveUser(Long Id, String name, String password, String company_code, String team_code){
        loginEntity loginEntity = loginHandler.saveloginEntity(Id,name,password,company_code,team_code);

        LoginDTO loginDTO = new LoginDTO(loginEntity.getId(),
                loginEntity.getName(), loginEntity.getPassword(), loginEntity.getCompany_code(), loginEntity.getTeam_code());

        return loginDTO;
    }


    public LoginDTO getUser(Long Id){
        loginEntity loginEntity = loginHandler.getloginEntity(Id);

        LoginDTO loginDTO = new LoginDTO(loginEntity.getId(),
                loginEntity.getName(), loginEntity.getPassword(), loginEntity.getCompany_code(), loginEntity.getTeam_code());

        return loginDTO;
    }
}
