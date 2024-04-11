package com.tienda.app.controller;

import com.tienda.app.service.ProductoService;
import com.tienda.app.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
// http://localhost:8081/tienda-app
@RequestMapping("tienda-app")
@CrossOrigin(value = "http://localhost:4200")
public class ProductoController {

    private static final Logger logger =
            LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping("/productos")
    public List<Producto> obtenerProductos() {
        List<Producto> productos = this.productoService.listarProducto();
        logger.info("Productos cargados correctamente");
        productos.forEach((producto -> logger.info(producto.toString())));
        return productos;
    }

    // Obtener un producto por su ID
    @GetMapping("/productos/{id}")
    public Producto obtenerProductoPorId(@PathVariable Integer id) {
        Producto producto = this.productoService.buscarProductoPorId(id);
        if (producto != null) {
            logger.info("Producto encontrado: " + producto.toString());
        } else {
            logger.info("Producto con ID " + id + " no encontrado");
        }
        return producto;
    }

    // Agregar un nuevo producto
    @PostMapping("/productos")
    public Producto agregarProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = this.productoService.guardarProducto(producto);
        logger.info("Producto agregado correctamente: " + nuevoProducto.toString());
        return nuevoProducto;
    }

    // Actualizar un producto existente
    @PutMapping("/productos/{id}")
    public String actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        Producto productoExistente = this.productoService.buscarProductoPorId(id);
        if (productoExistente != null) {
            producto.setId(id);
            Producto productoActualizado = this.productoService.guardarProducto(producto);
            logger.info("Producto actualizado correctamente: " + productoActualizado.toString());
            return "Producto actualizado correctamente";
        } else {
            logger.info("Producto con ID " + id + " no encontrado, no se puede actualizar");
            return "Error: Producto con ID " + id + " no encontrado";
        }
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/productos/{id}")
    public String eliminarProducto(@PathVariable Integer id) {
        this.productoService.eliminarProductoPorId(id);
        logger.info("Producto con ID " + id + " eliminado correctamente");
        return "Producto con ID " + id + " eliminado correctamente";
    }


}
