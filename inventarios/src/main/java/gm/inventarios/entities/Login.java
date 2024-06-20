package gm.inventarios.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Login {

    @Id
    private Long usrCode;

    @OneToOne
    @MapsId
    @JoinColumn(name = "usrCode")
    @JsonIgnore
    private Userr userr;

    private String loginUsername;
    private String loginPassword;

    // Getters and setters
}
