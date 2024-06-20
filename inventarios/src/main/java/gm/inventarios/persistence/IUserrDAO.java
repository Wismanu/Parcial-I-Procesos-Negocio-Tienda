package gm.inventarios.persistence;

import gm.inventarios.entities.Userr;

import java.util.List;
import java.util.Optional;

public interface IUserrDAO {

    List<Userr> findAll();

    Optional<Userr> findById(Long usrCode);

    void save(Userr userr);

    void deleteById(Long usrCode);

}
