
package com.TiendaII.dao;

import com.TiendaII.domain.Categoria;
import org.springframework.data.jpa.repository.*;


public interface CategoriaDao extends JpaRepository <Categoria, Long>{
    
}
