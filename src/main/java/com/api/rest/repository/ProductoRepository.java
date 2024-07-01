package com.api.rest.repository;

import com.api.rest.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ProductoRepository {
    private List<Product> productos = new ArrayList<>();

    public void crearProductos(){

        productos = List.of(
               new Product( 1,"producto 01",5,1000),
                new Product( 2,"producto 02",5,1000),
                new Product( 3,"producto 03",5,1000),
                new Product( 4,"producto 04",5,1000),
                new Product( 5,"producto 05",5,1000),
                new Product( 6,"producto 06",5,1000),
                new Product( 7,"producto 07",5,1000),
                new Product( 8,"producto 08",5,1000),
                new Product( 9,"producto 09",5,1000)

        );
    }

    public List<Product> getAllProductos() {
        return productos;
    }


    public Product findById(int id) {
        for (int i = 0; i < productos.size(); i++) {
            if(productos.get(i).getId() == id){

                return productos.get(i);
            }
        }
        return null;
    }

   public List<Product> search(String nombre){
        return productos.stream()
                .filter(x -> x.getNombre().equals(nombre))
                .collect(Collectors.toList());
   }

   public  Product save(Product p){
       Product products = new Product();
       products.setId(p.getId());
       products.setNombre(p.getNombre());
       products.setCantidad(p.getCantidad());
       products.setPrecio(p.getPrecio());

       productos.add(products);
       return products;
   }

   public String delete(Integer id){
        productos.removeIf(x -> x.getId() == id);
        return null;
   }
 //comprobar el producto y tener posicion
   public Product update(Product product){
        int idX=0;//1
        int id = 0;

        for(int i = 0; i < productos.size(); i++){
            if (productos.get(i).getId() == product.getId()){
                id = product.getId();
                idX = i;//posision id producto
                break;
            }
        }
        Product product1 = new Product();
        product1.setId(id);
        product1.setNombre(product.getNombre());
        product1.setCantidad(product.getCantidad());
        product1.setPrecio(product.getPrecio());
        productos.set(idX, product1);
        return product1;
   }


}
