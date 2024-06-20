package gm.inventarios.repository;

import gm.inventarios.entities.Userr;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserrRepository extends CrudRepository<Userr, Long> {


    Optional<User> findUserrByUsername(String usrName);


}
