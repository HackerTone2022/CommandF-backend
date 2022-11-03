package com.midas.ios.commandFbackend.Handler;

import com.midas.ios.commandFbackend.DAO.loginDAO;
import com.midas.ios.commandFbackend.Entity.loginEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class loginHandler {
    com.midas.ios.commandFbackend.DAO.loginDAO loginDAO;

    @Autowired
    public loginHandler(loginDAO loginDAO){
        this.loginDAO=loginDAO;
    }


    public loginEntity saveloginEntity(Long Id, String login_id,String name, String password, String company_code, String team_code){
        loginEntity loginEntity = new loginEntity(Id,login_id,name,password,company_code,team_code);

        return loginDAO.saveUser(loginEntity);
    }

    public loginEntity getloginEntity(Long Id){
        return loginDAO.getUser(Id);
    }

    public loginEntity findByLoginId(String login_id){
        return loginDAO.findByLoginId(login_id);
    }

    public loginEntity editUser(String name,String password,String company_code,String team_code,Long emp_id){
        return loginDAO.editUSer(name,password,company_code,team_code,emp_id);
    }

}
