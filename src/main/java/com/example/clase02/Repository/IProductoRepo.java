package com.example.clase02.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clase02.Model.Producto;

@Repository
public interface IProductoRepo extends JpaRepository<Producto, Integer>{

	
}
