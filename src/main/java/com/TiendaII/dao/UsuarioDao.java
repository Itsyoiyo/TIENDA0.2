package com.TiendaII.dao;

import com.TiendaII.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository<Usuario, Long> {    
    Usuario findByUsername(String username); //asociaciones a traves de un prefijo
}
