package org.jmoreno.springcloud.msvc.usuarios.controllers;

import org.jmoreno.springcloud.msvc.usuarios.entity.Usuario;
import org.jmoreno.springcloud.msvc.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

//@RequestMapping(name = "/api")
@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public List<Usuario> listar(){
        return service.listar();
    }

    @GetMapping("/{id}")
    //public Usuario detalle(@PathVariable Long id){
    public ResponseEntity<?> detalle(@PathVariable(name = "id") Long id){
        Optional<Usuario> usuarioOptional = service.porId(id);
        if(usuarioOptional.isPresent()){
            return ResponseEntity.ok(usuarioOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario crear(@RequestBody Usuario usuario){
        //return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuario));
        return service.guardar(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@RequestBody Usuario usuario, @PathVariable Long id){
        Optional<Usuario> usuarioDB = service.porId(id);

        if(usuarioDB.isPresent()){
            Usuario usuarioActualiza = usuarioDB.get();
            usuarioActualiza.setNombre(usuario.getNombre());
            usuarioActualiza.setEmail(usuario.getEmail());
            usuarioActualiza.setPassword(usuario.getPassword());

            return ResponseEntity.status(HttpStatus.CREATED).body(service.guardar(usuarioActualiza));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> elimiar(@PathVariable Long id){
        Optional<Usuario> usuario = service.porId(id);

        if(usuario.isPresent()){
            service.eliminar(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }

        return ResponseEntity.notFound().build();
    }
}
