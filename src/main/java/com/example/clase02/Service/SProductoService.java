package com.example.clase02.Service;

import java.util.List;

import com.example.clase02.Model.Producto;

public interface SProductoService {
	Producto create(Producto p);
	List<Producto> readAll();
	Producto read(int id);
	void delete(int id);
	Producto update(Producto p);
}
