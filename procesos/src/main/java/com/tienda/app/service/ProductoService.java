package com.tienda.app.service;

import com.tienda.app.model.Producto;
import com.tienda.app.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductoService  implements IProductoService{

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> listarProducto() {
        return this.productoRepository.findAll();
    }

    @Override
    public Producto buscarProductoPorId(Integer id) {
        Producto producto =
                this.productoRepository.findById(id).orElse(null);
        return producto;
    }

    @Override
    public void guardarProducto(Producto producto) {
        this.productoRepository.save(producto);
    }

    @Override
    public void eliminarProductoPorId(Integer id) {

        this.productoRepository.deleteById(id);

    }

}
