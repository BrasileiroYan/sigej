package com.example.SIGEJ.controller;

import com.example.SIGEJ.dao.RhDAO;
import com.example.SIGEJ.model.rh.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rh")
public class RhController {

    private final RhDAO dao;

    public RhController(RhDAO dao) {
        this.dao = dao;
    }

    // --- PESSOAS ---
    @GetMapping("/pessoas")
    public List<Pessoa> listarPessoas() { return dao.listarPessoas(); }

    @PostMapping("/pessoas")
    public Pessoa salvarPessoa(@RequestBody Pessoa p) { return dao.salvarPessoa(p); }

    @DeleteMapping("/pessoas/{id}")
    public String deletarPessoa(@PathVariable Long id) {
        dao.deletarPessoa(id);
        return "Pessoa removida com sucesso!";
    }

    // --- SETORES ---
    @GetMapping("/setores")
    public List<Setor> listarSetores() { return dao.listarSetores(); }

    @PostMapping("/setores")
    public String salvarSetor(@RequestBody Setor s) {
        dao.salvarSetor(s);
        return "Setor salvo!";
    }

    @DeleteMapping("/setores/{id}")
    public String deletarSetor(@PathVariable Long id) {
        dao.deletarSetor(id);
        return "Setor removido com sucesso!";
    }

    // --- TIPOS DE FUNCIONARIO ---
    @GetMapping("/tipos-funcionario")
    public List<TipoFuncionario> listarTipos() { return dao.listarTiposFuncionario(); }

    @PostMapping("/tipos-funcionario")
    public String salvarTipo(@RequestBody TipoFuncionario t) {
        dao.salvarTipoFuncionario(t);
        return "Tipo salvo!";
    }

    @DeleteMapping("/tipos-funcionario/{id}")
    public String deletarTipo(@PathVariable Long id) {
        dao.deletarTipoFuncionario(id);
        return "Tipo de funcionário removido com sucesso!";
    }

    // --- FUNCIONARIOS ---
    @GetMapping("/funcionarios")
    public List<Funcionario> listarFuncionarios() { return dao.listarFuncionarios(); }

    @PostMapping("/funcionarios")
    public String salvarFuncionario(@RequestBody Funcionario f) {
        dao.salvarFuncionario(f);
        return "Funcionário salvo!";
    }

    @DeleteMapping("/funcionarios/{id}")
    public String deletarFuncionario(@PathVariable Long id) {
        dao.deletarFuncionario(id);
        return "Funcionário removido com sucesso!";
    }

    // --- EQUIPES ---
    @GetMapping("/equipes")
    public List<EquipeManutencao> listarEquipes() { return dao.listarEquipes(); }

    @PostMapping("/equipes")
    public String salvarEquipe(@RequestBody EquipeManutencao e) {
        dao.salvarEquipe(e);
        return "Equipe salva!";
    }

    @DeleteMapping("/equipes/{id}")
    public String deletarEquipe(@PathVariable Long id) {
        dao.deletarEquipe(id);
        return "Equipe removida com sucesso!";
    }
}
