package com.bazar.bazarAPI.service;

import com.bazar.bazarAPI.model.Cliente;
import com.bazar.bazarAPI.repository.IClienteRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository repoClien;

    //Create
    @Override
    public void saveCliente(Cliente clien) {
        repoClien.save(clien);
    }

    //Read
    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = repoClien.findAll();
        List<Cliente> listaClientes2 = new ArrayList<Cliente>();

        for (Cliente clie : listaClientes) {

            if (clie.isBorrado() == false) {

                listaClientes2.add(clie);

            }

        }

        return listaClientes2;

    }

    @Override
    public Cliente findCliente(Long id_cliente) {

        return repoClien.findById(id_cliente).orElse(null);
    }

    //Update
    @Override
    public void editCliente(Cliente clien) {
        this.saveCliente(clien);
    }

    //la otra variante por si hay que modificar el id
    @Override
    public void editClienteId(Long idOriginal, Long idNueva, String nombreNuevo, String apellidoNuevo, String dniNuevo) {
        Cliente clie = this.findCliente(idOriginal);

        clie.setId_cliente(idNueva);
        clie.setNombre(nombreNuevo);
        clie.setApellido(apellidoNuevo);
        clie.setDni(dniNuevo);

        this.saveCliente(clie);
    }

    //Delete
    @Override
    public void deleteCliente(Long id_cliente) {
        repoClien.deleteById(id_cliente);
    }

    @Override
    public void deleteClienteLogic(Long id_cliente) {
        this.findCliente(id_cliente).setBorrado(true);
        repoClien.flush();
    }

    @Override
    public void activacionClienteLogic(Long id_cliente) {
        this.findCliente(id_cliente).setBorrado(false);
        repoClien.flush();
    }

}
