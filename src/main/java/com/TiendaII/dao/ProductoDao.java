
package com.TiendaII.dao;

import com.TiendaII.domain.Producto;
import org.springframework.data.jpa.repository.*;


public interface ProductoDao extends JpaRepository <Producto, Long>{
    
}
