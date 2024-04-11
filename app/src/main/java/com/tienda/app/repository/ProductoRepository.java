package com.tienda.app.repository;

import com.tienda.app.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;



public interface  ProductoRepository extends JpaRepository<Producto, Integer> {



}
