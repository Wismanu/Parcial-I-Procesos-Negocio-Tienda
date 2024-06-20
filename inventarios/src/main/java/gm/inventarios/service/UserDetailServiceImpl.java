package gm.inventarios.service;

import gm.inventarios.entities.Userr;
import gm.inventarios.repository.UserrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserrRepository userrRepository;


    @Override
    public UserDetails loadUserByUsername(String usrName) throws UsernameNotFoundException {

        Userr userr = userrRepository.findUserrByUsername(usrName)
        .orElseThrow(() -> new UsernameNotFoundException("El usuario "+usrName+ " No existe") );

        return null;
    }


}
