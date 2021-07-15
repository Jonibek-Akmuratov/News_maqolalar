package uz.pdp.news_maqolalar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.news_maqolalar.entity.Role;
import uz.pdp.news_maqolalar.entity.enums.Permission;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role,Integer> {

    boolean existsByName(String name);



}
