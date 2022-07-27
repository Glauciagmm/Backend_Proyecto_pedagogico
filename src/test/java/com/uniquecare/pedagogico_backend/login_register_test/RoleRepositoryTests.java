package com.uniquecare.pedagogico_backend.login_register_test;

import com.uniquecare.pedagogico_backend.models.ERole;
import com.uniquecare.pedagogico_backend.models.Role;
import com.uniquecare.pedagogico_backend.models.User;
import com.uniquecare.pedagogico_backend.repositories.RoleRepository;
import com.uniquecare.pedagogico_backend.repositories.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

//import static org.hamcrest.MatcherAssert.assertThat;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
    @Autowired private RoleRepository roleRepo;

    @Autowired private UserRepository userRepo;

    @Test
    public void testCreateRoles() {
        Role user = new Role(ERole.ROLE_USER);
        Role admin = new Role(ERole.ROLE_ADMIN);
        Role facility = new Role(ERole.ROLE_FACILITY);

        roleRepo.saveAll(List.of(user, admin, facility));

        List<Role> listRoles = roleRepo.findAll();

        assertThat(listRoles.size()).isEqualTo(3);
    }

    @Test
    public void testAddRoleToNewUser() {
        Role roleAdmin = roleRepo.findByName("Admin");

        User user = new User();
        user.setName("Dolores");
        user.setSurname("Perez");
        user.setEmail("loli@gmail.com");
        user.setUsername("Loli");
        user.setPassword("loli2022");
        user.setCity("Barcelona");
        user.addRole(roleAdmin);
        User savedUser = userRepo.save(user);
        //Role roleUser = roleRepo.findByName("User");
       // user.addRole(roleUser);

        assertThat(savedUser.getRoles().size()).isEqualTo(1);
    }

    @Test
    public void testAddRoleToExistingUser() {
        /*User user = userRepo.findById(1L).get();
        Role roleUser = roleRepo.findByName("User");
        Role roleFacility = new Role(3);*/

        /*user.addRole(roleUser);
        user.addRole(roleFacility);*/

        /*Role roleAdmin = new Role("User");
        user.addRole(roleAdmin);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(2);*/

        User user = userRepo.findById(1L).get();
        Role roleUser = roleRepo.findByName("User");
        Role roleFacility = new Role(3);

        user.addRole(roleUser);
        user.addRole(roleFacility);

        User savedUser = userRepo.save(user);

        assertThat(savedUser.getRoles().size()).isEqualTo(2);

    }
}
