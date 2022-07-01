package com.bazar.bazarAPI.controller;

import com.bazar.bazarAPI.model.Producto;
import com.bazar.bazarAPI.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService produServ;

    //Create
    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto produ) {
        produServ.saveProducto(produ);

        return "El producto fue creado correctamente";
    }

    //Read
    @GetMapping("/productos")
    @ResponseBody
    public List<Producto> getProductos() {

        return produServ.getProductos();
    }

    @GetMapping("/productos/{codigo_producto}")
    @ResponseBody
    public Producto getProducto(@PathVariable Long codigo_producto) {

        return produServ.findProducto(codigo_producto);
    }

    //Update
    @PutMapping("/productos/editar")
    public Producto editProducto(@RequestBody Producto produ) {
        produServ.editProducto(produ);

        return produServ.findProducto(produ.getCodigo_producto());

    }

    //Delete
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto) {
        produServ.deleteProducto(codigo_producto);

        return "El producto fue eliminado correctamente";
    }
    
    
    @DeleteMapping("/productos/eliminado-logico/{codigo_producto}")
    public String deleteProductoLogic(@PathVariable Long codigo_producto) {
        produServ.deleteProductoLogic(codigo_producto);

        return "El producto fue eliminado logica y correctamente";
    }
    
     @PostMapping("/productos/activado-logico/{codigo_producto}")
    public String activacionProductoLogic(@PathVariable Long codigo_producto) {
        produServ.activacionProductoLogic(codigo_producto);

        return "El producto fue activado logica y correctamente";
    }

    //otros requerimientos
    @GetMapping("/productos/falta_stock")
    @ResponseBody
    public List<Producto> getFaltaStock() {

        return produServ.getFaltaStock();
    }
}
