package com.example.clase02.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clase02.Model.Producto;
import com.example.clase02.Repository.IProductoRepo;

@Service
public class ProductoService implements SProductoService {
	
	@Autowired
	private IProductoRepo productorepo;
	
	@Override
	public Producto create(Producto p) {
		// TODO Auto-generated method stub
		return productorepo.save(p);
	}

	@Override
	public List<Producto> readAll() {
		// TODO Auto-generated method stub
		return productorepo.findAll();
	}

	@Override
	public Producto read(int id) {
		// TODO Auto-generated method stub
		return productorepo.findById(id).get();
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		productorepo.deleteById(id);
	}

	@Override
	public Producto update(Producto p) {
		// TODO Auto-generated method stub
		return productorepo.save(p);
	}

}
