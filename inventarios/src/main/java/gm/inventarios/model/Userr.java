package gm.inventarios.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Userr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long usrCode;
    Integer usrIdRol;
    String usrName;
    String usrDni;
    String usrPhone;

}
