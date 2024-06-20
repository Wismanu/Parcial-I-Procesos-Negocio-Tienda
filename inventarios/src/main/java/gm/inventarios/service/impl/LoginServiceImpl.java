package gm.inventarios.service.impl;

import gm.inventarios.entities.Login;
import gm.inventarios.persistence.ILoginDAO;
import gm.inventarios.service.ILoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImpl implements ILoginService {

    @Autowired
    private ILoginDAO loginDAO;

    @Override
    public List<Login> findAll() {
        return loginDAO.findAll();
    }

    @Override
    public Optional<Login> findById(Long usrCode) {
        return loginDAO.findById(usrCode);
    }

    @Override
    public void save(Login login) {
        loginDAO.save(login);
    }

    @Override
    public void deleteById(Long usrCode) {
        loginDAO.deleteById(usrCode);
    }
}
