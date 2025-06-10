
package com.TiendaII.service.impl;

import com.TiendaII.dao.CategoriaDao;
import com.TiendaII.domain.Categoria;
import com.TiendaII.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoriaServiceImpl implements CategoriaService {
   
    @Autowired //busca automaticamente el tipo de catagoa Dao para poder utilizarlo
    private CategoriaDao categoriaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Categoria> getCategorias (boolean activos){
        var lista = categoriaDao.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }
    
}
