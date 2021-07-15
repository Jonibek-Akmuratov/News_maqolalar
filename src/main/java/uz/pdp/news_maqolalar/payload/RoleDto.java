package uz.pdp.news_maqolalar.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.news_maqolalar.entity.enums.Permission;
import uz.pdp.news_maqolalar.entity.enums.RoleType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    @NotNull(message = "Name bo'sh bolmasin" )
    private String name;

    private String description;

    @NotNull(message = "Permissionlar bo'sh bolmasin" )
    private List<Permission> permissionList;

}
