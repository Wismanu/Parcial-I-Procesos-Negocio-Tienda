package gm.inventarios.persistence.impl;

import gm.inventarios.entities.Login;
import gm.inventarios.persistence.ILoginDAO;
import gm.inventarios.repository.LoginRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class LoginDAOImlp implements ILoginDAO {

    @Autowired
    private LoginRepository loginRepository;


    @Override
    public List<Login> findAll() {
        return (List<Login>) loginRepository.findAll();
    }

    @Override
    public Optional<Login> findById(Long usrCode) {
        return loginRepository.findById(usrCode) ;
    }

    @Override
    public void save(Login usrCode) {
        loginRepository.save(usrCode);
    }

    @Override
    public void deleteById(Long usrCode) { loginRepository.deleteById(usrCode); }
}
