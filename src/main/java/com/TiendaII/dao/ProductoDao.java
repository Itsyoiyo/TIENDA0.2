
package com.TiendaII.dao;

import com.TiendaII.domain.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;


public interface ProductoDao extends JpaRepository <Producto, Long>{
    
    //Ejemplo de metodo utiliznado query
    public List <Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double PrecioSup);

 //Ejemplo de método utilizando Consultas con JPQL
    @Query(value="SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);
   //Ejemplo de método utilizando Consultas con SQL nativo
    @Query(nativeQuery = true,
            value = "SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

// Query Method
public List<Producto> findByExistenciasBetweenOrderByDescripcion(int existenciasMin, int existenciasMax);

// JPQL
@Query("SELECT p FROM Producto p WHERE p.existencias BETWEEN :existenciasMin AND :existenciasMax ORDER BY p.descripcion ASC")
public List<Producto> buscarPorExistenciasJPQL(@Param("existenciasMin") int existenciasMin, @Param("existenciasMax") int existenciasMax);

// SQL Nativo
@Query(nativeQuery = true, value = "SELECT * FROM producto WHERE existencias BETWEEN :existenciasMin AND :existenciasMax ORDER BY descripcion ASC")
public List<Producto> buscarPorExistenciasNativo(@Param("existenciasMin") int existenciasMin, @Param("existenciasMax") int existenciasMax);

}
