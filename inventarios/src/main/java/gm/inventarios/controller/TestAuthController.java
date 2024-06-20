package gm.inventarios.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@PreAuthorize("denyAll()")
public class TestAuthController {

    @GetMapping("/hello")
    @PreAuthorize("permitAll()")
    public String hello (){
        return "Hello World";
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/hello-secured")
    public String helloSecured (){
        return "Hello World";
    }

}
