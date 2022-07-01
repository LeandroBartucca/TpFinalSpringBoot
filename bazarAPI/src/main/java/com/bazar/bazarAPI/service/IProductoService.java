package com.bazar.bazarAPI.service;

import com.bazar.bazarAPI.model.Producto;
import java.util.List;

public interface IProductoService {

    //CRUD
        //Create
    public void saveProducto(Producto produ);

        //Read
            //método para traer a todas las personas
    public List<Producto> getProductos();

            //lectura de un solo objeto
    public Producto findProducto(Long codigo_producto);

        //Update
    public void editProducto(Producto produ);

        //Delete
    public void deleteProducto(Long codigo_producto);
    
    public void deleteProductoLogic(Long codigo_producto);
    
    public void activacionProductoLogic(Long codigo_producto);

    //otros requerimientos
    public List<Producto> getFaltaStock();
}
