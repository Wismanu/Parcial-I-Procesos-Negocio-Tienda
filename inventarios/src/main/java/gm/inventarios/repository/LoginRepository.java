package gm.inventarios.repository;

import gm.inventarios.entities.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends CrudRepository<Login, Long> {


}
