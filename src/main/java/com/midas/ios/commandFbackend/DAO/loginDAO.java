package com.midas.ios.commandFbackend.DAO;

import com.midas.ios.commandFbackend.Entity.loginEntity;
import com.midas.ios.commandFbackend.Repository.loginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginDAO {
    com.midas.ios.commandFbackend.Repository.loginRepository loginRepository;

    @Autowired
    public loginDAO(loginRepository loginRepository){
        this.loginRepository=loginRepository;
    }



    public loginEntity saveUser(loginEntity loginEntity) {
        loginRepository.save(loginEntity);
        return loginEntity;
    }


    public loginEntity getUser(Long Id) {
        loginEntity loginEntity = loginRepository.getReferenceById(Id);
        return loginEntity;
    }

    public loginEntity findByLoginId(String login_id){
        loginEntity loginEntity = loginRepository.findByLoginId(login_id);
        return loginEntity;
    }
}
