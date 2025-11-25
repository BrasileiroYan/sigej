package com.example.SIGEJ.controller;
import com.example.SIGEJ.dao.MaterialDAO;
import com.example.SIGEJ.model.materiais.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/materiais")
public class MaterialController {

    private final MaterialDAO dao;

    public MaterialController(MaterialDAO dao) {
        this.dao = dao;
    }

    // CATEGORIAS
    @GetMapping("/categorias") public List<CategoriaMaterial> listarCat() { return dao.listarCategorias(); }
    @PostMapping("/categorias") public String salvarCat(@RequestBody CategoriaMaterial c) { dao.salvarCategoria(c); return "Ok"; }
    @DeleteMapping("/categorias/{id}") public String delCat(@PathVariable Long id) { dao.deletarCategoria(id); return "Ok"; }

    // MARCAS
    @GetMapping("/marcas") public List<Marca> listarMar() { return dao.listarMarcas(); }
    @PostMapping("/marcas") public String salvarMar(@RequestBody Marca m) { dao.salvarMarca(m); return "Ok"; }
    @DeleteMapping("/marcas/{id}") public String delMar(@PathVariable Long id) { dao.deletarMarca(id); return "Ok"; }

    // UNIDADES
    @GetMapping("/unidades") public List<UnidadeMedida> listarUni() { return dao.listarUnidades(); }
    @PostMapping("/unidades") public String salvarUni(@RequestBody UnidadeMedida u) { dao.salvarUnidade(u); return "Ok"; }

    // CORES
    @GetMapping("/cores") public List<Cor> listarCor() { return dao.listarCores(); }
    @PostMapping("/cores") public String salvarCor(@RequestBody Cor c) { dao.salvarCor(c); return "Ok"; }

    // TAMANHOS
    @GetMapping("/tamanhos") public List<Tamanho> listarTam() { return dao.listarTamanhos(); }
    @PostMapping("/tamanhos") public String salvarTam(@RequestBody Tamanho t) { dao.salvarTamanho(t); return "Ok"; }

    // PRODUTOS
    @GetMapping("/produtos") public List<Produto> listarProd() { return dao.listarProdutos(); }
    @PostMapping("/produtos") public String salvarProd(@RequestBody Produto p) { dao.salvarProduto(p); return "Ok"; }
    @DeleteMapping("/produtos/{id}") public String delProd(@PathVariable Long id) { dao.deletarProduto(id); return "Ok"; }

    // VARIAÇÕES
    @GetMapping("/variacoes") public List<ProdutoVariacao> listarVar() {  return dao.listarVariacoes(); }
    @PostMapping("/variacoes") public String salvarVar(@RequestBody ProdutoVariacao pv) { dao.salvarVariacao(pv); return "Ok"; }
    @DeleteMapping("/variacoes/{id}") public String delVar(@PathVariable Long id) {dao.deletarVariacao(id);return "Variação removida com sucesso!"; }
}
