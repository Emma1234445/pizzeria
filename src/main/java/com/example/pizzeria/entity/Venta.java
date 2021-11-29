package com.example.pizzeria.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="venta")
public class Venta implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = -2615454317497070557L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idventa")
	private int id;
	private String cliente;
	private int cantidad;
	private double precio;

	@ManyToOne(fetch = FetchType.LAZY , cascade = CascadeType.MERGE)
	@JoinColumn(name = "tipo_id", referencedColumnName = "idtipo")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Tipo tipo;

}
