package org.jmoreno.springcloud.msvc.usuarios.repositories;

import org.jmoreno.springcloud.msvc.usuarios.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {
}
