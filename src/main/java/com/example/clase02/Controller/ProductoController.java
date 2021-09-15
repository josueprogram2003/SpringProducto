package com.example.clase02.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clase02.Model.Producto;
import com.example.clase02.Service.ProductoService;

@RestController
@RequestMapping("api")
public class ProductoController {
	
	@Autowired
	private ProductoService productoService;
	
	@PostMapping("/producto")
	public ResponseEntity<Producto> save(@RequestBody Producto p){
		try {
			Producto produ = productoService.create(new Producto(p.getNombre(),p.getCosto(),p.getStock()));
			return new ResponseEntity<>(produ,HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/productos")
	public ResponseEntity<List<Producto>> getProducto(){
		try {
			List<Producto> list = new ArrayList<>();
			list=productoService.readAll();
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list,HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/productos/{id}")
	public ResponseEntity<Producto> getProductoID(@PathVariable("id") int id){
		Producto producto = productoService.read(id);
		if (producto.getIdprodu()>0) {
			return new ResponseEntity<>(producto,HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}
	
	@DeleteMapping("/delete/{id}")
		public ResponseEntity<Producto> delete(@PathVariable("id")int id){
			try {
				productoService.delete(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				// TODO: handle exception
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
	
	@PutMapping("/alumno/update/{id}")
	public ResponseEntity<Producto> update(@RequestBody Producto p, @PathVariable("id") int id){
		try {
			Producto ul = productoService.read(id);
			if(ul.getIdprodu()>0) {
				ul.setNombre(p.getNombre());
				return new ResponseEntity<>(productoService.create(ul),HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}			

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	}
	
	
	
	
	
	
	
	
	

