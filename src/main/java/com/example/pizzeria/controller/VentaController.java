package com.example.pizzeria.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pizzeria.entity.Venta;
import com.example.pizzeria.service.VentaService;

@RestController
@RequestMapping("/api/venta")
public class VentaController {

	@Autowired
	private VentaService ventaService;

	@GetMapping("/all")
	public ResponseEntity<List<Venta>> getVentas(){
		try {
			List<Venta> lista = new ArrayList<>();
			lista = ventaService.readAll();
			if(lista.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				return new ResponseEntity<>(lista, HttpStatus.OK);
			}
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Venta> getVentas(@PathVariable("id") int id){
		Venta c = ventaService.read(id);
		if(c.getId()>0) {
			return new ResponseEntity<>(c, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable("id") int id){
		try {
			ventaService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/create")
	public ResponseEntity<Venta> save(@RequestBody Venta venta){
		try {
			Venta cl = ventaService.create(venta);
			return new ResponseEntity<>(cl, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Venta> update(@RequestBody Venta venta, @PathVariable("id") int id){
		try {
			Venta v = ventaService.read(id);
			if(v.getId()>0) {
				v.setCliente(venta.getCliente());
				v.setCantidad(venta.getCantidad());
				v.setPrecio(venta.getPrecio());
				v.setTipo(venta.getTipo());
				return new ResponseEntity<>(ventaService.create(v),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
