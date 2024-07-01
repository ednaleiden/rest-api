package com.api.rest.controller;

import com.api.rest.model.Product;
import com.api.rest.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public Product agregarProducto (@RequestBody Product productos){
        return productoService.saveProduct(productos);
    }

    @GetMapping
    public List<Product> listarProductos(){
        return  productoService.getProducts();
    }

    @GetMapping("/{id}")
    public Product buscarProductos(@PathVariable int id){
        return productoService.getProductById(id);
    }

    @PutMapping
    public Product actualizarProducto (@RequestBody Product productos){
        return productoService.updateProduct(productos);
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable int id){
        return productoService.deleteProduct(id);
    }

}





