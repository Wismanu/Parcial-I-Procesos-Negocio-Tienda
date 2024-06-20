package gm.inventarios.controller.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserrDTO {


    private Long usrCode;

    private Integer usrIdRol;
    private String usrName;
    private String usrDni;
    private String usrPhone;

}
