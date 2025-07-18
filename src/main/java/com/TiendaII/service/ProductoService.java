
package com.TiendaII.service;

import com.TiendaII.domain.Producto;
import com.TiendaII.domain.Producto;
import java.util.List;


public interface ProductoService {
    
    public List <Producto> getProductos (boolean activos);
        
       // Se obtiene un Producto, a partir del id de un producto
    public Producto getProducto(Producto producto);
    
    // Se inserta un nuevo producto si el id del producto esta vacío
    // Se actualiza un producto si el id del producto NO esta vacío
    public void save(Producto producto);

    // Se elimina el producto que tiene el id pasado por parámetro
    public void delete(Producto producto);

    // Lista de productos con precio entre ordendados por descripción ConsultaAmpliada
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    //Lista de productos utilizando consultas con JPQL    
    public List<Producto> metodoJPQL(double precioInf, double precioSup);
    //Lista de productos utilizando consultas con SQL Nativo

    public List<Producto> metodoNativo(double precioInf, double precioSup);

public List<Producto> findByExistenciasBetweenOrderByDescripcion(int existenciasMin, int existenciasMax);

public List<Producto> buscarPorExistenciasJPQL(int existenciasMin, int existenciasMax);

public List<Producto> buscarPorExistenciasNativo(int existenciasMin, int existenciasMax);

}
