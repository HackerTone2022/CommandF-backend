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
public class ApplyDTO {

    @NotNull
    private Long emp_id;

    private boolean home_apply;
    private boolean absent_apply;
    private boolean leave_apply;
}
