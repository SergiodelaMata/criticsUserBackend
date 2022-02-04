package com.practices.sergiodelamata.criticsUserBackend.dao;

import com.practices.sergiodelamata.criticsUserBackend.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleJPA extends JpaRepository<Role, Integer> {
}
