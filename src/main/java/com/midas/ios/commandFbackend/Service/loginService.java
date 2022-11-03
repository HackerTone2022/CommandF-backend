package com.midas.ios.commandFbackend.Service;

import com.midas.ios.commandFbackend.DTO.loginDTO;
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


    public loginDTO saveUser(Long Id, String name, String password, String company_code, String team_code){
        loginEntity loginEntity = loginHandler.saveloginEntity(Id,name,password,company_code,team_code);

        loginDTO loginDTO = new loginDTO(loginEntity.getId(),
                loginEntity.getName(), loginEntity.getPassword(), loginEntity.getCompany_code(), loginEntity.getTeam_code());

        return loginDTO;
    }


    public loginDTO getUser(Long Id){
        loginEntity loginEntity = loginHandler.getloginEntity(Id);

        loginDTO loginDTO = new loginDTO(loginEntity.getId(),
                loginEntity.getName(), loginEntity.getPassword(), loginEntity.getCompany_code(), loginEntity.getTeam_code());

        return loginDTO;
    }
}
