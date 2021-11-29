package com.example.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pizzeria.entity.Tipo;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Integer>{

}
