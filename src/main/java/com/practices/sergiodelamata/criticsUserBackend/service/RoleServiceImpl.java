package com.practices.sergiodelamata.criticsUserBackend.service;

import com.practices.sergiodelamata.criticsUserBackend.dao.IRoleDAO;
import com.practices.sergiodelamata.criticsUserBackend.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements IRoleService{
    @Autowired
    IRoleDAO roleDAO;

    @Override
    public List<Role> searchAll() {
        return roleDAO.searchAll();
    }

    @Override
    public Role searchRoleById(Integer idRole) {
        return roleDAO.searchRoleById(idRole);
    }

    @Override
    public void saveRole(Role Role) {
        roleDAO.saveRole(Role);
    }

    @Override
    public void deleteRole(Integer idRole) {
        roleDAO.deleteRole(idRole);
    }
}
