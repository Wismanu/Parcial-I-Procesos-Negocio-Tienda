package gm.inventarios.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
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
