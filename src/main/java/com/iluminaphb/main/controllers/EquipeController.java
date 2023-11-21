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

import com.iluminaphb.main.models.Equipe;
import com.iluminaphb.main.services.EquipeService;

@RestController
@RequestMapping("/api/equipes")
public class EquipeController {

    @Autowired
    private EquipeService service;

    @GetMapping
    public ResponseEntity<List<Equipe>> listarEquipes() {
        return ResponseEntity.ok().body(service.listarEquipes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Equipe> listarPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(service.listarPorId(id));
    }

    @GetMapping("/{nome}")
    public ResponseEntity<Equipe> listarPorNome(@PathVariable String nome) {
        return ResponseEntity.ok().body(service.listarPorNome(nome));
    }

    @GetMapping("/{viatura}")
    public ResponseEntity<Equipe> listarPorViatura(@PathVariable String viatura) {
        return ResponseEntity.ok().body(service.listarPorViatura(viatura));
    }

    @PostMapping
    public ResponseEntity<Equipe> criarEquipe(@RequestBody Equipe obj) {
        Equipe equipe = service.criarEquipe(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(equipe.getId())
                .toUri();
        return ResponseEntity.created(uri).body(equipe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEquipe(@PathVariable String id) {
        service.deletarEquipe(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Equipe> atualizarEquipe(@PathVariable String id, @RequestBody Equipe obj) {
        Equipe equipe = service.atualizarEquipe(id, obj);
        return ResponseEntity.ok().body(equipe);
    }

}