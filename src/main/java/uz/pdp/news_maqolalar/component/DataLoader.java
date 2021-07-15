package uz.pdp.news_maqolalar.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.pdp.news_maqolalar.entity.Role;
import uz.pdp.news_maqolalar.entity.User;
import uz.pdp.news_maqolalar.entity.enums.Permission;
import uz.pdp.news_maqolalar.entity.enums.RoleType;
import uz.pdp.news_maqolalar.repository.RoleRepository;
import uz.pdp.news_maqolalar.repository.UserRepository;

import java.util.Arrays;

import static uz.pdp.news_maqolalar.entity.enums.Permission.*;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Value("${spring.datasource.initialization-mode}")
    private String mode;


    @Override
    public void run(String... args) throws Exception {

        if (mode.equals("always")) {

            Permission[] permission = Permission.values();

            Role role = new Role();
            role.setName("Admin");
            role.setDescription("Barcha xuquqi bolgan odam");
            role.setRoleType(RoleType.ROLE_ADMIN);
            role.setPermissionList(Arrays.asList(permission));
            Role adminrole = roleRepository.save(role);

            Role role2 = new Role();
            role2.setName("User");
            role2.setDescription("Registerdan otgan odamlarga berilardigan Role");
            role2.setRoleType(RoleType.ROLE_USER);
            role2.setPermissionList(Arrays.asList(
                    Permission.VIEW_POST,
                    Permission.DELETE_MY_COMMET,
                    Permission.ADD_COMMET,
                    Permission.VIEW_COMMET));
            Role userrole = roleRepository.save(role2);

            User admin=new User(
                    "Admin",
                    "ADMIN",
                    "+998935714209",
                    passwordEncoder.encode("root123"),
                    adminrole,
                    true
            );
            userRepository.save(admin);

   User other=new User(
                    "User",
                    "USER",
                    "+998935714208",
                    passwordEncoder.encode("root123"),
                    userrole,
                    true
            );
            userRepository.save(other);

        }
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}