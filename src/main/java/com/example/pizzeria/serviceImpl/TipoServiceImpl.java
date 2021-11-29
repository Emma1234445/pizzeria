package com.example.pizzeria.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pizzeria.entity.Tipo;
import com.example.pizzeria.repository.TipoRepository;
import com.example.pizzeria.service.TipoService;


@Service
public class TipoServiceImpl implements TipoService{

	@Autowired
	private TipoRepository cursoRepository;
	@Override
	public List<Tipo> readAll() {
		// TODO Auto-generated method stub
		return cursoRepository.findAll();
	}

	@Override
	public Tipo read(int id) {
		// TODO Auto-generated method stub
		return cursoRepository.findById(id).get();
	}

	@Override
	public Tipo create(Tipo tipo) {
		// TODO Auto-generated method stub
		return cursoRepository.save(tipo);
	}

	@Override
	public Tipo update(Tipo tipo) {
		// TODO Auto-generated method stub
		return cursoRepository.save(tipo);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		cursoRepository.deleteById(id);
	}
}
