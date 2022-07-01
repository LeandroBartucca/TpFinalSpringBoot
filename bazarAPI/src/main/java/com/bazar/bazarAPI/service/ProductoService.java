package com.bazar.bazarAPI.service;

import com.bazar.bazarAPI.model.Producto;
import com.bazar.bazarAPI.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository repoProdu;

    //Create
    @Override
    public void saveProducto(Producto produ) {
        repoProdu.save(produ);
    }

    //Read
    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = repoProdu.findAll();
        List<Producto> listaProductos2 = new ArrayList<Producto>();

        for (Producto produ : listaProductos) {

            if (produ.isBorrado() == false) {

                listaProductos2.add(produ);

            }

        }

        return listaProductos2;
    }

    @Override
    public Producto findProducto(Long codigo_producto) {

        return repoProdu.findById(codigo_producto).orElse(null);
    }

    //Update
    @Override
    public void editProducto(Producto produ) {
        this.saveProducto(produ);
    }

    //Delete
    @Override
    public void deleteProducto(Long codigo_producto) {
        repoProdu.deleteById(codigo_producto);
    }

    @Override
    public void deleteProductoLogic(Long codigo_producto) {
        this.findProducto(codigo_producto).setBorrado(true);
        repoProdu.flush();
    }

    @Override
    public void activacionProductoLogic(Long codigo_producto) {
        this.findProducto(codigo_producto).setBorrado(false);
        repoProdu.flush();
    }

    //Otros requerimientos
    @Override
    public List<Producto> getFaltaStock() {
        List<Producto> listaProductos = this.getProductos();
        List<Producto> listaFaltaStock = new ArrayList<Producto>();

        for (Producto produ : listaProductos) {
            if (produ.getCantidad_disponible() < 5) {
                listaFaltaStock.add(produ);
            }
        }
        return listaFaltaStock;

    }

}
