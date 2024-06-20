package gm.inventarios.controller;

import gm.inventarios.controller.dto.LoginDTO;
import gm.inventarios.controller.dto.UserrDTO;
import gm.inventarios.entities.Login;
import gm.inventarios.entities.Userr;
import gm.inventarios.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    private ILoginService loginService;



    @GetMapping("/find/{usrCode}")
    public ResponseEntity<?> findById(@PathVariable Long usrCode) {
        Optional<Login> loginOptional = loginService.findById(usrCode);

        if (loginOptional.isPresent()) {
            Login login = loginOptional.get();

            LoginDTO loginDTO = LoginDTO.builder()
                    .usrCode(login.getUsrCode())
                    .loginUsername(login.getLoginUsername())
                    .loginPassword(login.getLoginPassword())
                    .build();
            return ResponseEntity.ok(loginDTO);
        }
        return ResponseEntity.notFound().build();
    }



    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<LoginDTO> loginDTOList = loginService.findAll()
                .stream()
                .map(login -> LoginDTO.builder()
                        .usrCode(login.getUsrCode())
                        .loginUsername(login.getLoginUsername())
                        .loginPassword(login.getLoginPassword())
                        .build())
                .toList();

        return ResponseEntity.ok(loginDTOList);

    }



    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody LoginDTO loginDTO) throws URISyntaxException {

        if (loginDTO.getLoginUsername().isBlank() || loginDTO.getLoginPassword() == null || loginDTO.getUsrCode() == null ) {
            return ResponseEntity.badRequest().build();
        }
        loginService.save(Login.builder()
                .usrCode(loginDTO.getUsrCode())
                .loginUsername(loginDTO.getLoginUsername())
                .loginPassword(loginDTO.getLoginPassword())
                .build());
        return ResponseEntity.created(new URI("/api/login/save")).build();
    }



    @PutMapping("/update/{usrCode}")
    public ResponseEntity<?> update(@PathVariable Long usrCode,@RequestBody LoginDTO loginDTO) {

        Optional<Login> loginOptional = loginService.findById(usrCode);

        if (loginOptional.isPresent()) {
            Login login = loginOptional.get();
            login.setLoginUsername(loginDTO.getLoginUsername());
            loginService.save(login);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }



    @DeleteMapping("/delete/{usrCode}")
    public ResponseEntity<?> deleteById(@PathVariable Long usrCode) {

        if (usrCode != null) {
            loginService.deleteById(usrCode);
            return ResponseEntity.ok("Registro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }



}