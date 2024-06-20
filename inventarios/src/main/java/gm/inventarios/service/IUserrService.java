package gm.inventarios.service;

import gm.inventarios.model.Userr;

import java.util.List;

public interface IUserrService {

    public  List<Userr> listarUsers();

    public Userr buscarUserPorId(Integer usrCode);

    public void guardarUser(Userr userr);

    public void eliminarUserPorId(Integer usrCode);

}
