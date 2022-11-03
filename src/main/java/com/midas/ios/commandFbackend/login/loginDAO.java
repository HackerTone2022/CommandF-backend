package com.midas.ios.commandFbackend.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class loginDAO {
    loginRepository loginRepository;

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
}
