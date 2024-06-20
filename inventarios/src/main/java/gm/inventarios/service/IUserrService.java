package gm.inventarios.service;

import gm.inventarios.entities.Userr;

import java.util.List;
import java.util.Optional;

public interface IUserrService {

    List<Userr> findAll();

    Optional<Userr> findById(Long usrCode);

    void save(Userr userr);

    void deleteById(Long usrCode);

}
