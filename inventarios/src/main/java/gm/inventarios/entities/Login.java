package gm.inventarios.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table(name = "login")
public class Login {

    @Id
    private Long usrCode;

    @OneToOne
    @MapsId
    @JoinColumn(name = "usrCode")
    @JsonIgnore
    private Userr userr;

    @Column(unique = true)
    private String loginUsername;
    private String loginPassword;


    private boolean isEnabled;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNoExpired;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "login_Roles", joinColumns = @JoinColumn(name = "login_loginIdRol"), inverseJoinColumns = @JoinColumn(name = "roles_id"))
    private Set<Roles> roles = new HashSet<>();

    // Getters and setters
}
