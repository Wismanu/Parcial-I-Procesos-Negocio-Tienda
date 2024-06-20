package gm.inventarios.controller;

import gm.inventarios.model.Userr;
import gm.inventarios.service.UserrService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;

@RestController
// http://localhost:8081/inventario-app
@RequestMapping("inventario-app")
@CrossOrigin(value = "http://localhost:4200")
public class UserrController {

    private static final Logger logger =
            LoggerFactory.getLogger(UserrController.class);

    @Autowired
    private UserrService userrService;

    // http://localhost:8081/inventario-app/users
    @GetMapping("/users")
    public List<Userr> obtenerUserr(){

        List<Userr> userrs = this.userrService.listarUsers();
    logger.info("Usuarios Cargados Correctamente");
    userrs.forEach((userr ->  logger.info(userr.toString())));
        return userrs;

    }

}
