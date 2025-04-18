package com.dgaznares.mscurso.usuarios.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgaznares.mscurso.usuarios.infrastructure.entities.Usuario;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuario, Integer>{

}
