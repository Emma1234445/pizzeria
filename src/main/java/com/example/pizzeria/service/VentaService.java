package com.example.pizzeria.service;

import java.util.List;

import com.example.pizzeria.entity.Venta;


public interface VentaService {

	List<Venta> readAll();
	Venta read(int id);
	Venta create(Venta venta);
	Venta update(Venta venta);
	void delete(int id);
}
