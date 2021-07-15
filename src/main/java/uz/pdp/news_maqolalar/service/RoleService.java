package uz.pdp.news_maqolalar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.news_maqolalar.entity.Role;
import uz.pdp.news_maqolalar.entity.enums.RoleType;
import uz.pdp.news_maqolalar.payload.Responce;
import uz.pdp.news_maqolalar.payload.RoleDto;
import uz.pdp.news_maqolalar.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public Responce addRole(RoleDto roleDto) {

        if (roleRepository.existsByName(roleDto.getName()))
            return new Responce("Bunday nameli Role avvvaldan mavjud", false);

        Role role = new Role(
                roleDto.getName(),
                roleDto.getDescription(),
                RoleType.ROLE_OTHER,
                roleDto.getPermissionList()
        );
        Role save = roleRepository.save(role);
        return new Responce("Role saqlandi ", true, save);

    }
}
