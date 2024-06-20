package gm.inventarios.service.impl;

import gm.inventarios.entities.Userr;
import gm.inventarios.persistence.IUserrDAO;
import gm.inventarios.service.IUserrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserrServiceImpl implements IUserrService {

    @Autowired
    private IUserrDAO userrDAO;

    @Override
    public List<Userr> findAll() {
        return userrDAO.findAll();
    }

    @Override
    public Optional<Userr> findById(Long usrCode) {
        return userrDAO.findById(usrCode);
    }

    @Override
    public void save(Userr userr) {
        userrDAO.save(userr);
    }

    @Override
    public void deleteById(Long usrCode) {
        userrDAO.deleteById(usrCode);
    }
}
