package com.enterprise.ems.repositories;


/*import com.alvora.auth.entity.Role;*/
import com.enterprise.ems.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role>  findByName(String name);
}

