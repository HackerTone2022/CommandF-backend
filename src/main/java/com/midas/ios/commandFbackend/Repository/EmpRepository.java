package com.midas.ios.commandFbackend.Repository;

import com.midas.ios.commandFbackend.Entity.EmpEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Time;
import java.time.LocalTime;
import java.util.Collection;

//UPDATE table_1 SET column_1 = 'x' WHERE column_2 = 'aa';
//table_1의 column_2가 aa인 튜플의 colum_1값을 x로 변경하라
public interface EmpRepository extends JpaRepository<EmpEntity,Long> {





    //재택근무, 결근, 휴가 수락
    @Query(value = "UPDATE emp SET home=1 WHERE fk_emp_id = :emp_id ", nativeQuery = true)
    EmpEntity acceptWorkFromHome(@Param("emp_id")Long emp_id);

    @Query(value = "UPDATE emp SET absent=1 WHERE fk_emp_id = :emp_id ", nativeQuery = true)
    EmpEntity acceptAbsent(@Param("emp_id")Long emp_id);

    @Query(value = "UPDATE emp SET leave=1 WHERE fk_emp_id = :emp_id ", nativeQuery = true)
    EmpEntity acceptLeave(@Param("emp_id")Long emp_id);

    //재택근무, 결근, 휴가 신청
    @Query(value = "UPDATE emp SET home_apply=1 WHERE fk_emp_id = :emp_id ", nativeQuery = true)
    EmpEntity applyWorkFromHome(@Param("emp_id")Long emp_id);

    @Query(value = "UPDATE emp SET absent_apply=1 WHERE fk_emp_id = :emp_id ", nativeQuery = true)
    EmpEntity applyAbsent(@Param("emp_id")Long emp_id);

    @Query(value = "UPDATE emp SET leave_apply=1 WHERE fk_emp_id = :emp_id ", nativeQuery = true)
    EmpEntity applyLeave(@Param("emp_id")Long emp_id);


    //퇴근 시간 찍기
    @Query(value = "UPDATE emp SET leave_work= :leaveTime WHERE fk_emp_id = :emp_id  ", nativeQuery = true)
    EmpEntity setLeaveTime(@Param("leaveTime") String leaveTime, @Param("emp_id")Long emp_id);


}