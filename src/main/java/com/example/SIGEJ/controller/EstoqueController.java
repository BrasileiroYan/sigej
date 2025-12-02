package com.example.SIGEJ.controller;

import com.example.SIGEJ.dao.EstoqueDAO;
import com.example.SIGEJ.model.estoque.Estoque;
import com.example.SIGEJ.model.estoque.LocalEstoque;
import com.example.SIGEJ.model.estoque.MovimentoEstoque;
import com.example.SIGEJ.model.estoque.TipoMovimentoEstoque;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueDAO dao;

    public EstoqueController(EstoqueDAO dao) {
        this.dao = dao;
    }

    // --- LOCAIS ---
    @GetMapping("/locais") public List<LocalEstoque> listarLocais() { return dao.listarLocais(); }
    @PostMapping("/locais") public String salvarLocal(@RequestBody LocalEstoque l) { dao.salvarLocal(l); return "Ok"; }
    @DeleteMapping("/locais/{id}") public String delLocal(@PathVariable Long id) { dao.deletarLocal(id); return "Ok"; }

    // --- TIPOS MOVIMENTO ---
    @GetMapping("/tipos-movimento") public List<TipoMovimentoEstoque> listarTipos() { return dao.listarTiposMovimento(); }
    @PostMapping("/tipos-movimento") public String salvarTipo(@RequestBody TipoMovimentoEstoque t) { dao.salvarTipoMovimento(t); return "Ok"; }
    @DeleteMapping("/tipos-movimento/{id}") public String delTipo(@PathVariable Long id) { dao.deletarTipoMovimento(id); return "Ok"; }

    // --- SALDO (ESTOQUE) ---
    @GetMapping("/saldos") public List<Estoque> listarSaldos() { return dao.listarSaldos(); }
    @PostMapping("/saldos") public String iniciarSaldo(@RequestBody Estoque e) { dao.inicializarEstoque(e); return "Saldo Inicializado!"; }
    @DeleteMapping("/saldos") public String delSaldo(@RequestParam Long prod, @RequestParam Long loc) { dao.deletarSaldo(prod, loc); return "Saldo removido!"; }

    // --- MOVIMENTAÇÕES ---
    @GetMapping("/movimentos") public List<MovimentoEstoque> listarMov() { return dao.listarMovimentos(); }
    @PostMapping("/movimentos") public String registrarMov(@RequestBody MovimentoEstoque m) { dao.registrarMovimento(m); return "Movimento Registrado!"; }
    @DeleteMapping("/movimentos/{id}") public String delMov(@PathVariable Long id) { dao.deletarMovimento(id); return "Movimento removido (Atenção: isso quebra o histórico!)"; }
}
