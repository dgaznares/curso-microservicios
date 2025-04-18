package com.dgaznares.mscurso.cursos.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dgaznares.mscurso.cursos.infrastructure.entities.Curso;

@Repository
public interface CursosRepository extends JpaRepository<Curso, Integer>{

}
