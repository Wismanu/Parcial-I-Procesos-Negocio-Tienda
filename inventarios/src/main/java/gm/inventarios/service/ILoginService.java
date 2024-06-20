package gm.inventarios.service;

import gm.inventarios.entities.Login;

import java.util.List;
import java.util.Optional;

public interface ILoginService {
    List<Login> findAll();

    Optional<Login> findById(Long usrCode);

    void save(Login login);

    void deleteById(Long usrCode);
}
