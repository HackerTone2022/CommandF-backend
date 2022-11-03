package com.midas.ios.commandFbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AdminDTO {
    @NotNull
    private Long emp_id;

    @NotNull
    private String emp_name;

    private String attend_time;
    private String leave_time;


}
