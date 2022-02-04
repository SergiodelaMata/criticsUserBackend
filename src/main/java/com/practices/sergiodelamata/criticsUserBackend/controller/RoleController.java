package com.practices.sergiodelamata.criticsUserBackend.controller;

import com.practices.sergiodelamata.criticsUserBackend.model.Role;
import com.practices.sergiodelamata.criticsUserBackend.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    IRoleService roleService;

    @GetMapping("/roles")
    public List<Role> searchAll() {
        return roleService.searchAll();
    }

    @GetMapping("/roles/{idRole}")
    public Role searchRoleById(@PathVariable("idRole") Integer idRole) {
        return roleService.searchRoleById(idRole);
    }

    @PostMapping("/roles")
    public void saveRole(@RequestBody Role Role) {
        roleService.saveRole(Role);
    }

    @DeleteMapping("/roles/{idRole}")
    public void deleteRole(@PathVariable("idRole") Integer idRole) {
        roleService.deleteRole(idRole);
    }
}
