package uz.pdp.news_maqolalar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.pdp.news_maqolalar.payload.Responce;
import uz.pdp.news_maqolalar.payload.RoleDto;
import uz.pdp.news_maqolalar.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {

    @Autowired
    RoleService roleService;


    @PostMapping("/add")
    public HttpEntity<?> addRole(@RequestBody RoleDto roleDto) {

        Responce responce = roleService.addRole(roleDto);

        return ResponseEntity.status(responce.isSucces()?200:409).body(responce);
    }


}
