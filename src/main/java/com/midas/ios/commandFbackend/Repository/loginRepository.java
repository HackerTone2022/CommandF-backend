package com.midas.ios.commandFbackend.Repository;


import com.midas.ios.commandFbackend.Entity.loginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface loginRepository extends JpaRepository<loginEntity,Long> {
}
