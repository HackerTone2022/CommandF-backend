package com.midas.ios.commandFbackend.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class loginHandler {
    loginDAO loginDAO;

    @Autowired
    public loginHandler(loginDAO loginDAO){
        this.loginDAO=loginDAO;
    }


    public loginEntity saveloginEntity(Long Id, String name, String password, String company_code, String team_code){
        loginEntity loginEntity = new loginEntity(Id,name,password,company_code,team_code);

        return loginDAO.saveUser(loginEntity);
    }


    public loginEntity getloginEntity(Long Id){
        return loginDAO.getUser(Id);
    }

}
