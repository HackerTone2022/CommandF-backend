package com.midas.ios.commandFbackend.login;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdPasswordDTO {

    @NotNull
    private Long Id;
    @NotNull
    private String password;
}
