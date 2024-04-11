package com.tienda.app.service;

import com.tienda.app.model.Producto;

import java.util.List;

public interface IProductoService {

    public  List<Producto> listarProducto();

    public Producto buscarProductoPorId(Integer id);

    public Producto guardarProducto(Producto producto);

    public void eliminarProductoPorId(Integer id);


}
