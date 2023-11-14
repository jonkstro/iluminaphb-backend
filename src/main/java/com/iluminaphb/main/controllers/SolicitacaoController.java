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

import com.iluminaphb.main.models.Solicitacao;
import com.iluminaphb.main.services.SolicitacaoService;

@RestController
@RequestMapping("/api/solicitacoes")
public class SolicitacaoController {

    @Autowired
    private SolicitacaoService service;

    @GetMapping
    public ResponseEntity<List<Solicitacao>> listarSolicitacoes() {
        return ResponseEntity.ok().body(service.listarSolicitacoes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Solicitacao> listarPorId(@PathVariable String id) {
        return ResponseEntity.ok().body(service.listarPorId(id));
    }

    @PostMapping
    public ResponseEntity<Solicitacao> criarSolicitacao(@RequestBody Solicitacao obj) {
        Solicitacao solicitacao = service.criarSolicitacao(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(solicitacao.getId())
                .toUri();
        return ResponseEntity.created(uri).body(solicitacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarSolicitacao(@PathVariable String id) {
        service.deletarSolicitacao(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Solicitacao> atualizarSolicitacao(@PathVariable String id, @RequestBody Solicitacao obj) {
        Solicitacao solicitacao = service.atualizarSolicitacao(id, obj);
        return ResponseEntity.ok().body(solicitacao);
    }

}