package com.midas.ios.commandFbackend.Repository;


import com.midas.ios.commandFbackend.Entity.loginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface loginRepository extends JpaRepository<loginEntity,Long> {
    @Query(value = "SELECT * FROM useraccount WHERE login_id= :login_id", nativeQuery = true)
    loginEntity findByLoginId(@Param("login_id") String login_id);

    @Query(value = "UPDATE useraccount SET name=:name,password=:password, company_code=:company_code, team_code=:team_code WHERE emp_id=:emp_id", nativeQuery = true)
    loginEntity editUser(@Param("name") String name,@Param("password")String password,@Param("company_code")String company_code,@Param("team_code")String team_code,@Param("emp_id")Long emp_id);
}

