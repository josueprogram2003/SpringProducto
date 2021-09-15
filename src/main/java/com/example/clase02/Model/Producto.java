package com.example.clase02.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idprodu;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="costo")
	private double costo;
	
	@Column(name="stock")
	private int stock;

	public Producto(String nombre, double costo, int stock) {
		this.nombre = nombre;
		this.costo = costo;
		this.stock = stock;
	}

	public Producto() {
		super();
	}

	public int getIdprodu() {
		return idprodu;
	}

	public void setIdprodu(int idprodu) {
		this.idprodu = idprodu;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCosto() {
		return costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	

	
}
