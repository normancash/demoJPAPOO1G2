package service;

import model.Sucursal;

import java.util.List;

public interface IDAOSucursal {

    //Consultar todos
    List<Sucursal> getAll();
    //insertar
    void insert(Sucursal sucursal);
    //Update
    void update(Sucursal sucursal);
    //Remove
    void delete(Sucursal sucursal);
    //find by id
    Sucursal findById(Integer id);
}
