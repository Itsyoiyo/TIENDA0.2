
package com.TiendaII.service;

import com.TiendaII.domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    public List <Categoria> getCategorias (boolean activos);
    
    
}
