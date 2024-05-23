package com.tienda.app.controller;

import com.tienda.app.service.ProductoService;
import com.tienda.app.model.Producto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
// http://localhost:8081/tienda-app
@RequestMapping("tienda-app")
//@CrossOrigin(value = "http://localhost:4200")
public class ProductoController {

    private static final Logger logger =
            LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping("/productos")
    public ResponseEntity<List<Producto>>  obtenerProductos() {
        try {
            List<Producto> productos = this.productoService.listarProducto();
            logger.info("Productos cargados correctamente: {}", productos);
            return ResponseEntity.ok(productos);
        } catch (Exception e) {
            logger.error("Error al obtener los productos", e.getMessage());
            return null;
        }
    }


    // Obtener un producto por su ID
    @GetMapping("/productos/{id}")
    public ResponseEntity<?> obtenerProductoPorId(@PathVariable Integer id) {
        try {
            Producto producto = this.productoService.buscarProductoPorId(id);
            if (producto != null) {
                logger.info("Producto encontrado: {}", producto);
                return ResponseEntity.ok(producto);
            } else {
                logger.info("Producto con ID {} no encontrado", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Producto no encontrado");
            }
        } catch (Exception e) {
            logger.error("Error al obtener el producto con ID {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor");
        }
    }



    @PostMapping("/productos")
    public ResponseEntity<?> agregarProducto(@RequestBody Producto producto) {
        try {
            Producto nuevoProducto = this.productoService.guardarProducto(producto);
            logger.info("Producto agregado correctamente: {}", nuevoProducto.toString());
            return ResponseEntity.ok(nuevoProducto);
        } catch (Exception e) {
            logger.error("Error al agregar un nuevo producto", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor al agregar un nuevo producto");
        }
    }


    // Actualizar un producto existente
    @PutMapping("/productos/{id}")
    public ResponseEntity<?> actualizarProducto(@PathVariable Integer id, @RequestBody Producto producto) {
        try {
            Producto productoExistente = this.productoService.buscarProductoPorId(id);
            if (productoExistente != null) {
                producto.setId(id);
                Producto productoActualizado = this.productoService.guardarProducto(producto);
                logger.info("Producto actualizado correctamente: " + productoActualizado.toString());
                return ResponseEntity.ok("Producto actualizado correctamente");
            } else {
                logger.info("Producto con ID {} no encontrado, no se puede actualizar", id);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error: Producto con ID " + id + " no encontrado");
            }
        } catch (Exception e) {
            logger.error("Error al actualizar el producto con ID {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor al actualizar el producto");
        }
    }


    // Eliminar un producto por su ID
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<?> eliminarProducto(@PathVariable Integer id) {
        try {
            this.productoService.eliminarProductoPorId(id);
            logger.info("Producto con ID {} eliminado correctamente", id);
            return ResponseEntity.ok("Producto con ID " + id + " eliminado correctamente");
        } catch (Exception e) {
            logger.error("Error al eliminar el producto con ID {}", id, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error interno del servidor al eliminar el producto");
        }
    }



}
