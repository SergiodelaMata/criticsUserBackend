package com.practices.sergiodelamata.criticsUserBackend.service;

import com.practices.sergiodelamata.criticsUserBackend.model.Role;

import java.util.List;

public interface IRoleService {
    List<Role> searchAll();

    Role searchRoleById(Integer idRole);

    void saveRole(Role Role);

    void deleteRole(Integer idRole);
}
