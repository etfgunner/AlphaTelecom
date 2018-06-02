package com.onlineCompetitionSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.onlineCompetitionSystem.model.Role;
import org.springframework.stereotype.Repository;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer> {
	Role findByRole(String role);
}