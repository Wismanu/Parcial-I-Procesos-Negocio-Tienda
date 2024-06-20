package gm.inventarios.persistence.impl;

import gm.inventarios.entities.Userr;
import gm.inventarios.persistence.IUserrDAO;
import gm.inventarios.repository.UserrRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserrDAOImpl implements IUserrDAO {
    @Autowired
    private UserrRepository userrRepository;

    @Override
    public List<Userr> findAll() {
        return (List<Userr>) userrRepository.findAll();
    }

    @Override
    public Optional<Userr> findById(Long usrCode) {
        return userrRepository.findById(usrCode);
    }

    @Override
    public void save(Userr usrCode) {
        userrRepository.save(usrCode);

    }

    @Override
    public void deleteById(Long usrCode) {
        userrRepository.deleteById(usrCode);
    }
}
