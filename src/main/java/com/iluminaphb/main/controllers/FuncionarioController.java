package com.iluminaphb.main.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iluminaphb.main.models.Funcionario;
import com.iluminaphb.main.services.FuncionarioService;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @GetMapping
    public ResponseEntity<List<Funcionario>> listarFuncionarios() {
        return ResponseEntity.ok().body(service.listarFuncionarios());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Funcionario> listarPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(service.listarPorId(id));
    }

    @GetMapping("/{matricula}")
    public ResponseEntity<Funcionario> listarPorMatricula(@PathVariable String matricula) {
        return ResponseEntity.ok().body(service.listarPorMatricula(matricula));
    }

    @PostMapping
    public ResponseEntity<Funcionario> criarFuncionario(@RequestBody Funcionario obj) {
        Funcionario Funcionario = service.criarFuncionario(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(Funcionario.getId())
                .toUri();
        return ResponseEntity.created(uri).body(Funcionario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarFuncionario(@PathVariable String id) {
        service.deletarFuncionario(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarFuncionario(@PathVariable String id, @RequestBody Funcionario obj) {
        Funcionario funcionario = service.atualFuncionario(id, obj);
        return ResponseEntity.ok().body(funcionario);
    }

}
