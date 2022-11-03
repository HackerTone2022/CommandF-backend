package com.midas.ios.commandFbackend.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginService {
    loginHandler loginHandler;

    @Autowired
    public loginService(loginHandler loginHandler){
        this.loginHandler=loginHandler;
    }


    public loginDTO saveUser(Long Id,String name,String password,String company_code, String team_code){
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
