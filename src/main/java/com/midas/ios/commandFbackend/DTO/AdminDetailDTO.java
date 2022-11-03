package com.midas.ios.commandFbackend.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AdminDetailDTO {
    @NotNull
    private Long emp_id;


    private String name;
    private String Today;
    ArrayList < String > DoW_attend = new ArrayList < String > ();
    ArrayList < String > Dow_leave = new ArrayList < String > ();
    ArrayList < String > Dow_work = new ArrayList < String > ();



}
