package com.example.pizzeria.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizzeria.entity.Venta;
import com.example.pizzeria.repository.VentaRepository;
import com.example.pizzeria.service.VentaService;


@Service
public class VentaServiceImpl implements VentaService{

	@Autowired
	private VentaRepository cursoRepository;
	@Override
	public List<Venta> readAll() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

	@Override
	public Venta read(int id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id).get();
	}

	@Override
	public Venta create(Venta venta) {
		// TODO Auto-generated method stub
		return cursoRepository.save(venta);
	}

	@Override
	public Venta update(Venta venta) {
		// TODO Auto-generated method stub
		return cursoRepository.save(venta);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cursoRepository.deleteById(id);
	}
}
