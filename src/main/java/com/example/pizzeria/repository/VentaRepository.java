package com.example.pizzeria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.pizzeria.entity.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

}
