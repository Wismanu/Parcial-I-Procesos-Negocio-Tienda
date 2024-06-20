package gm.inventarios.controller.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LoginDTO {

    private Long usrCode;

    private String loginUsername;
    private String loginPassword;

    private Long loginIdRol;

}
