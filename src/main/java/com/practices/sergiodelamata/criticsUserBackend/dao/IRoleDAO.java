package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.Role;

import java.util.List;

public interface IRoleDAO {
    List<Role> searchAll();

    Role searchRoleById(Integer idRole);

    void saveRole(Role Role);

    void deleteRole(Integer idRole);
}
