package com.bazar.bazarAPI.service;

import com.bazar.bazarAPI.model.Cliente;
import java.util.List;

public interface IClienteService {

    //CRUD
        //Create
    public void saveCliente(Cliente clien);

        //Read
             //método para traer a todas las personas
    public List<Cliente> getClientes();

             //lectura de un solo objeto
    public Cliente findCliente(Long id_cliente);

        //Update
    public void editCliente(Cliente clien);

    public void editClienteId(Long id_cliente, Long idNueva, String nombreNuevo, String apellidoNuevo, String dniNuevo);

        //Delete
    public void deleteCliente(Long id_cliente);
    
    public void deleteClienteLogic(Long id_cliente);
    
    public void activacionClienteLogic(Long id_cliente);
}
