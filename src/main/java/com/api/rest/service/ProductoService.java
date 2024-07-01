package com.api.rest.service;

import com.api.rest.model.Product;
import com.api.rest.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {


    @Autowired
    private ProductoRepository productoRepository;

    public Product saveProduct(Product product) {

        return productoRepository.save(product);
    }

    public List<Product> getProducts() {
        return productoRepository.getAllProductos();
    }


    public Product getProductById(int id){
        return productoRepository.findById(id);
    }

    public String deleteProduct(int id){
         productoRepository.delete(id);
        return "Producto eliminado"+ id;
    }

    public Product updateProduct(Product product){
       return productoRepository.update(product);
    }

}
