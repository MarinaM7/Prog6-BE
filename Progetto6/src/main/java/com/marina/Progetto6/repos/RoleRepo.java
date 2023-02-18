package com.marina.Progetto6.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marina.Progetto6.entities.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, Integer> {

}
