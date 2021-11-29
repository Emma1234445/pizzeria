package com.example.pizzeria.service;

import java.util.List;

import com.example.pizzeria.entity.Tipo;

public interface TipoService {

	List<Tipo> readAll();
	Tipo read(int id);
	Tipo create(Tipo tipo);
	Tipo update(Tipo tipo);
	void delete(int id);
}
