import gm.inventarios.entities.Login;
import gm.inventarios.entities.PermissionEntity;
import gm.inventarios.entities.Roles;
import gm.inventarios.entities.RoleEnum;
import gm.inventarios.entities.Userr;
import gm.inventarios.repository.LoginRepository;
import gm.inventarios.repository.PermissionRepository;
import gm.inventarios.repository.RoleRepository;
import gm.inventarios.repository.UserrRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class InventariosAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventariosAppApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserrRepository userrRepository, PermissionRepository permissionRepository, RoleRepository roleRepository, LoginRepository loginRepository) {
		return args -> {
			// Create PERMISSIONS
			PermissionEntity createPermission = PermissionEntity.builder()
					.name("CREATE")
					.build();

			PermissionEntity readPermission = PermissionEntity.builder()
					.name("READ")
					.build();

			PermissionEntity updatePermission = PermissionEntity.builder()
					.name("UPDATE")
					.build();

			PermissionEntity deletePermission = PermissionEntity.builder()
					.name("DELETE")
					.build();

			PermissionEntity refactorPermission = PermissionEntity.builder()
					.name("REFACTOR")
					.build();

			// Save PERMISSIONS
//			permissionRepository.saveAll(List.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission));

			// Create ROLES
			Roles roleAdmin = Roles.builder()
					.roleEnum(RoleEnum.ADMIN)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission))
					.build();

			Roles roleUser = Roles.builder()
					.roleEnum(RoleEnum.USER)
					.permissionList(Set.of(readPermission))
					.build();

			Roles roleDeveloper = Roles.builder()
					.roleEnum(RoleEnum.DEVELOPER)
					.permissionList(Set.of(createPermission, readPermission, updatePermission, deletePermission, refactorPermission))
					.build();

//			// Save ROLES
//			roleRepository.saveAll(List.of(roleAdmin, roleUser, roleDeveloper));

			// Create USERS
			Userr userJuan = Userr.builder()
					.usrName("Juan Pérez")
					.usrDni("12345678A")
					.usrPhone("123456789")
					.build();

			Userr userAna = Userr.builder()
					.usrName("Ana García")
					.usrDni("23456789B")
					.usrPhone("234567890")
					.build();

			Userr userLuis = Userr.builder()
					.usrName("Luis Fernández")
					.usrDni("34567890C")
					.usrPhone("345678901")
					.build();

			Userr userMaria = Userr.builder()
					.usrName("María López")
					.usrDni("45678901D")
					.usrPhone("456789012")
					.build();

			Userr userCarlos = Userr.builder()
					.usrName("Carlos Sánchez")
					.usrDni("56789012E")
					.usrPhone("567890123")
					.build();

			// Save USERS
			userrRepository.saveAll(List.of(userJuan, userAna, userLuis, userMaria, userCarlos));

			// Create LOGIN for each user with assigned roles
			Login loginJuan = Login.builder()
					.userr(userJuan)
					.loginUsername("juan.perez")
					.loginPassword("$2a$10$examplehashedpassword1")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleAdmin))  // Assign Admin role to Juan
					.build();

			Login loginAna = Login.builder()
					.userr(userAna)
					.loginUsername("ana.garcia")
					.loginPassword("$2a$10$examplehashedpassword2")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleUser))  // Assign User role to Ana
					.build();

			Login loginLuis = Login.builder()
					.userr(userLuis)
					.loginUsername("luis.fernandez")
					.loginPassword("$2a$10$examplehashedpassword3")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleDeveloper))  // Assign Developer role to Luis
					.build();

			Login loginMaria = Login.builder()
					.userr(userMaria)
					.loginUsername("maria.lopez")
					.loginPassword("$2a$10$examplehashedpassword4")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleUser))  // Assign User role to Maria
					.build();

			Login loginCarlos = Login.builder()
					.userr(userCarlos)
					.loginUsername("carlos.sanchez")
					.loginPassword("$2a$10$examplehashedpassword5")
					.isEnabled(true)
					.accountNonExpired(true)
					.accountNonLocked(true)
					.credentialsNoExpired(true)
					.roles(Set.of(roleAdmin))  // Assign Admin role to Carlos
					.build();

			// Save LOGIN
			loginRepository.saveAll(List.of(loginJuan, loginAna, loginLuis, loginMaria, loginCarlos));
		};
	}
}
