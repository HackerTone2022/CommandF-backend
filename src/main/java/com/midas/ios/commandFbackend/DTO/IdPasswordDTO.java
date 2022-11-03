package com.midas.ios.commandFbackend.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IdPasswordDTO {

    @NotNull
    private String login_id;
    @NotNull
    private String password;
}
