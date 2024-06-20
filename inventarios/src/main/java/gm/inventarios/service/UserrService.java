package gm.inventarios.service;

import gm.inventarios.model.Userr;
import gm.inventarios.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserrService implements IUserrService {

    @Autowired
    private UserrRepository userrRepository;

    @Override
    public List<Userr> listarUsers() {
        return this.userrRepository.findAll();
    }

    @Override
    public Userr buscarUserPorId(Integer usrCode) {
       Userr userr =
               this.userrRepository.findById(usrCode).orElse(null);
       return userr;
    }

    @Override
    public void guardarUser(Userr userr) {
    this.userrRepository.save(userr);
    }

    @Override
    public void eliminarUserPorId(Integer usrCode) {

        this.userrRepository.deleteById(usrCode);

    }
}
