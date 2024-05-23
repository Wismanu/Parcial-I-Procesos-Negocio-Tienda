package com.tienda.app.controller;

import com.tienda.app.dto.RequestDTO;
import com.tienda.app.dto.ResponseDTO;
import com.tienda.app.model.Producto;
import com.tienda.app.service.ProductoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/tienda-app")
public class ProductoController {

    private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping("/productos")
    public ResponseEntity<ResponseDTO<List<Producto>>> obtenerProductos() {
        try {
            List<Producto> productos = this.productoService.listarProducto();
            logger.info("Productos cargados correctamente: {}", productos);

            ResponseDTO<List<Producto>> response = new ResponseDTO<>();
            response.setDate(LocalDateTime.now().toString());
            response.setMessage("Productos obtenidos correctamente");
            response.setStatusCode(String.valueOf(HttpStatus.OK.value()));
            response.setData(productos);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error al obtener productos", e);

            ResponseDTO<List<Producto>> response = new ResponseDTO<>();
            response.setDate(LocalDateTime.now().toString());
            response.setMessage("Error interno del servidor");
            response.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
            response.setData(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Obtener un producto por su ID
    @GetMapping("/productos/{id}")
    public ResponseEntity<ResponseDTO<Producto>> obtenerProductoPorId(@PathVariable Integer id) {
        try {
            Producto producto = this.productoService.buscarProductoPorId(id);
            ResponseDTO<Producto> response = new ResponseDTO<>();
            response.setDate(LocalDateTime.now().toString());

            if (producto != null) {
                logger.info("Producto encontrado: {}", producto);
                response.setMessage("Producto encontrado");
                response.setStatusCode(String.valueOf(HttpStatus.OK.value()));
                response.setData(producto);
                return ResponseEntity.ok(response);
            } else {
                logger.info("Producto con ID {} no encontrado", id);
                response.setMessage("Producto no encontrado");
                response.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
                response.setData(null);
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            logger.error("Error al obtener el producto con ID {}", id, e);

            ResponseDTO<Producto> response = new ResponseDTO<>();
            response.setDate(LocalDateTime.now().toString());
            response.setMessage("Error interno del servidor");
            response.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
            response.setData(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Agregar un nuevo producto
    @PostMapping("/productos")
    public ResponseEntity<ResponseDTO<Producto>> agregarProducto(@RequestBody RequestDTO<Producto> request) {
        try {
            Producto nuevoProducto = this.productoService.guardarProducto(request.getData());
            logger.info("Producto agregado correctamente: {}", nuevoProducto.toString());

            ResponseDTO<Producto> response = new ResponseDTO<>();
            response.setDate(LocalDateTime.now().toString());
            response.setMessage("Producto agregado correctamente");
            response.setStatusCode(String.valueOf(HttpStatus.OK.value()));
            response.setData(nuevoProducto);

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error al agregar un nuevo producto", e);

            ResponseDTO<Producto> response = new ResponseDTO<>();
            response.setDate(LocalDateTime.now().toString());
            response.setMessage("Error interno del servidor al agregar un nuevo producto");
            response.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
            response.setData(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Actualizar un producto existente
    @PutMapping("/productos/{id}")
    public ResponseEntity<ResponseDTO<Producto>> actualizarProducto(@PathVariable Integer id, @RequestBody RequestDTO<Producto> request) {
        try {
            Producto productoExistente = this.productoService.buscarProductoPorId(id);
            if (productoExistente != null) {
                Producto producto = request.getData();
                producto.setId(id);
                Producto productoActualizado = this.productoService.guardarProducto(producto);
                logger.info("Producto actualizado correctamente: " + productoActualizado.toString());

                ResponseDTO<Producto> response = new ResponseDTO<>();
                response.setDate(LocalDateTime.now().toString());
                response.setMessage("Producto actualizado correctamente");
                response.setStatusCode(String.valueOf(HttpStatus.OK.value()));
                response.setData(productoActualizado);

                return ResponseEntity.ok(response);
            } else {
                logger.info("Producto con ID {} no encontrado, no se puede actualizar", id);

                ResponseDTO<Producto> response = new ResponseDTO<>();
                response.setDate(LocalDateTime.now().toString());
                response.setMessage("Error: Producto con ID " + id + " no encontrado");
                response.setStatusCode(String.valueOf(HttpStatus.NOT_FOUND.value()));
                response.setData(null);

                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            logger.error("Error al actualizar el producto con ID {}", id, e);

            ResponseDTO<Producto> response = new ResponseDTO<>();
            response.setDate(LocalDateTime.now().toString());
            response.setMessage("Error interno del servidor al actualizar el producto");
            response.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
            response.setData(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    // Eliminar un producto por su ID
    @DeleteMapping("/productos/{id}")
    public ResponseEntity<ResponseDTO<String>> eliminarProducto(@PathVariable Integer id) {
        try {
            this.productoService.eliminarProductoPorId(id);
            logger.info("Producto con ID {} eliminado correctamente", id);

            ResponseDTO<String> response = new ResponseDTO<>();
            response.setDate(LocalDateTime.now().toString());
            response.setMessage("Producto eliminado correctamente");
            response.setStatusCode(String.valueOf(HttpStatus.OK.value()));
            response.setData("Producto con ID " + id + " eliminado correctamente");

            return ResponseEntity.ok(response);
        } catch (Exception e) {
            logger.error("Error al eliminar el producto con ID {}", id, e);

            ResponseDTO<String> response = new ResponseDTO<>();
            response.setDate(LocalDateTime.now().toString());
            response.setMessage("Error interno del servidor al eliminar el producto");
            response.setStatusCode(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));
            response.setData(null);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
