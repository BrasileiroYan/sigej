package com.example.SIGEJ.controller;

import com.example.SIGEJ.dao.OsDAO;
import com.example.SIGEJ.model.os.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/os")
public class OsController {

    private final OsDAO dao;

    public OsController(OsDAO dao) {
        this.dao = dao;
    }

    // --- TIPOS DE OS ---
    @PostMapping("/tipos-os")
    public String salvarTipoOS(@RequestBody TipoOrdemServico t) {
        dao.salvarTipoOS(t);
        return "Tipo de OS salvo!";
    }
    @GetMapping("/tipos-os")
    public List<TipoOrdemServico> listarTiposOS() {
        return dao.listarTiposOS();
    }
    @DeleteMapping("/tipos-os/{id}")
    public String deletarTipoOS(@PathVariable Long id) {
        dao.deletarTipoOS(id);
        return "Tipo de OS removido!";
    }

    // --- STATUS ---
    @PostMapping("/status")
    public String salvarStatus(@RequestBody StatusOrdemServico s) {
        dao.salvarStatusOS(s);
        return "Status salvo!";
    }
    @GetMapping("/status")
    public List<StatusOrdemServico> listarStatus() {
        return dao.listarStatusOS();
    }
    @DeleteMapping("/status/{id}")
    public String deletarStatus(@PathVariable Long id) {
        dao.deletarStatusOS(id);
        return "Status removido!";
    }

    // --- TIPOS DE ÁREA ---
    @PostMapping("/tipos-area")
    public String salvarTipoArea(@RequestBody TipoAreaCampus t) {
        dao.salvarTipoArea(t);
        return "Tipo de Área salvo!";
    }
    @GetMapping("/tipos-area")
    public List<TipoAreaCampus> listarTiposArea() {
        return dao.listarTiposArea();
    }
    @DeleteMapping("/tipos-area/{id}")
    public String deletarTipoArea(@PathVariable Long id) {
        dao.deletarTipoArea(id);
        return "Tipo de Área removido!";
    }

    // --- ÁREAS ---
    @PostMapping("/areas")
    public String salvarArea(@RequestBody AreaCampus a) {
        dao.salvarArea(a);
        return "Área salva!";
    }
    @GetMapping("/areas")
    public List<AreaCampus> listarAreas() {
        return dao.listarAreas();
    }
    @DeleteMapping("/areas/{id}")
    public String deletarArea(@PathVariable Long id) {
        dao.deletarArea(id);
        return "Área removida!";
    }

    // --- ABRIR OS (PRINCIPAL) ---
    @PostMapping("/abrir")
    public String abrirOS(@RequestBody OrdemServico os) {
        dao.abrirOS(os);
        return "Ordem de Serviço aberta com sucesso!";
    }
    @GetMapping
    public List<OrdemServico> listarOS() {
        return dao.listarOS();
    }
    @DeleteMapping("/{id}")
    public String deletarOS(@PathVariable Long id) {
        dao.deletarOS(id);
        return "Ordem de Serviço removida com sucesso!";
    }

    // --- ITENS DA OS ---
    @PostMapping("/{id}/itens")
    public String adicionarItem(@PathVariable Long id, @RequestBody ItemOrdemServico item) {
        OrdemServico os = new OrdemServico(); os.setId(id);
        item.setOs(os);
        dao.adicionarItem(item);
        return "Item adicionado à OS!";
    }
    @GetMapping("/{id}/itens")
    public List<ItemOrdemServico> listarItens(@PathVariable Long id) {
        return dao.listarItensPorOS(id);
    }
    @DeleteMapping("/itens/{id}")
    public String deletarItem(@PathVariable Long id) {
        dao.deletarItem(id);
        return "Item removido da OS com sucesso!";
    }

    // --- ANDAMENTOS (MUDANÇA DE STATUS) ---
    @PostMapping("/{id}/andamentos")
    public String registrarAndamento(@PathVariable Long id, @RequestBody AndamentoOrdemServico andamento) {
        OrdemServico os = new OrdemServico(); os.setId(id);
        andamento.setOs(os);
        dao.registrarAndamento(andamento);
        return "Andamento registrado e Status atualizado!";
    }
    @GetMapping("/{id}/andamentos")
    public List<AndamentoOrdemServico> listarAndamentos(@PathVariable Long id) {
        return dao.listarAndamentosPorOS(id);
    }
    @DeleteMapping("/andamentos/{id}")
    public String deletarAndamento(@PathVariable Long id) {
        dao.deletarAndamento(id);
        return "Registro de andamento removido com sucesso!";
    }
}
