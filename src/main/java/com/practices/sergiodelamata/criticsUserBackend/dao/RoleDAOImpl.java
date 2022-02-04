package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleDAOImpl implements IRoleDAO{
    @Autowired
    IRoleJPA roleJPA;

    @Override
    public List<Role> searchAll() {
        return roleJPA.findAll();
    }

    @Override
    public Role searchRoleById(Integer idRole) {
        Optional<Role> optional = roleJPA.findById(idRole);
        if (optional.isPresent()) {
            return optional.get();
        }
        return null;
    }

    @Override
    public void saveRole(Role Role) {
        roleJPA.save(Role);
    }

    @Override
    public void deleteRole(Integer idRole) {
        roleJPA.deleteById(idRole);
    }
}
