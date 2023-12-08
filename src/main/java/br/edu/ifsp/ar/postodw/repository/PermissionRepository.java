package br.edu.ifsp.ar.postodw.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ifsp.ar.postodw.model.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long>{

}
