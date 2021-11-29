package com.example.pizzeria.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="tipo")
public class Tipo  implements Serializable{/**
	 * 
	 */
	private static final long serialVersionUID = 8296895617324729337L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtipo")	
    private int id;
    private String nombre;

  	@OneToMany(cascade = CascadeType.MERGE, mappedBy = "tipo", fetch = FetchType.LAZY)
  	@JsonIgnore
    private List<Venta> notas = new ArrayList<>();
}
