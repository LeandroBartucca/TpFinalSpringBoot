package com.bazar.bazarAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@JsonIgnoreProperties("listaVentas") //utilizo esta anotacion para que no me muestre la lista de ventas dentro de cada producto en las solicitudes Get
//considere que es mas sencillo que crear un dto 
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo_producto;

    private String nombre;
    private String marca;
    private Double costo;
    private Double cantidad_disponible;

    @JsonProperty("listaVentas") //va de la mano a la anotacion anterior
    @ManyToMany(mappedBy = "listaProductos")
    private List<Venta> listaVentas;

    private boolean borrado;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, Double costo, Double cantidad_disponible, List<Venta> listaVentas) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        this.listaVentas = listaVentas;
        this.borrado = false;
    }

}
