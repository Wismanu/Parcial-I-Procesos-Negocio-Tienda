

package gm.inventarios.controller;


import gm.inventarios.controller.dto.UserrDTO;
import gm.inventarios.entities.Userr;
import gm.inventarios.service.IUserrService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/userr")
public class UserrController {

    @Autowired
    private IUserrService userrService;

    @GetMapping("/find/{usrCode}")
    public ResponseEntity<?> findById(@PathVariable Long usrCode) {
        Optional<Userr> userrOptional = userrService.findById(usrCode);

        if (userrOptional.isPresent()) {
            Userr userr = userrOptional.get() ;

            UserrDTO userrDTO = UserrDTO.builder()
                    .usrCode(userr.getUsrCode())
                    .usrName(userr.getUsrName())
                    .usrPhone(userr.getUsrPhone())
                    .usrDni(userr.getUsrDni())
                    .usrIdRol(userr.getUsrIdRol())
                    .build();
            return ResponseEntity.ok(userrDTO);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<UserrDTO> userrDTOList = userrService.findAll()
                .stream()
                .map(userr -> UserrDTO.builder()
                        .usrCode(userr.getUsrCode())
                        .usrName(userr.getUsrName())
                        .usrPhone(userr.getUsrPhone())
                        .usrDni(userr.getUsrDni())
                        .usrIdRol(userr.getUsrIdRol())
                        .build())
                .toList();

        return ResponseEntity.ok(userrDTOList);

    }


    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserrDTO userrDTO) throws URISyntaxException {

        if (userrDTO.getUsrName().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        userrService.save(Userr.builder()
                .usrIdRol(userrDTO.getUsrIdRol())
                .usrName(userrDTO.getUsrName())
                .usrDni(userrDTO.getUsrDni())
                .usrPhone(userrDTO.getUsrPhone())
                .build());
        return ResponseEntity.created(new URI("/api/userr/save")).build();
    }

    @PutMapping("/update/{usrCode}")
    public ResponseEntity<?> update(@PathVariable Long usrCode,@RequestBody UserrDTO userrDTO) {

        Optional<Userr> userrOptional = userrService.findById(usrCode);

        if (userrOptional.isPresent()) {
            Userr userr = userrOptional.get();
            userr.setUsrName(userrDTO.getUsrName());
            userrService.save(userr);
            return ResponseEntity.ok("Registro Actualizado");
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{usrCode}")
    public ResponseEntity<?> deleteById(@PathVariable Long usrCode) {

        if (usrCode != null) {
            userrService.deleteById(usrCode);
            return ResponseEntity.ok("Registro Eliminado");
        }
        return ResponseEntity.badRequest().build();
    }
}
