package com.example.SIGEJ.dao;

import com.example.SIGEJ.model.materiais.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class MaterialDAO {

    private final JdbcTemplate jdbc;

    public MaterialDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // --- CATEGORIA ---
    public void salvarCategoria(CategoriaMaterial c) {
        jdbc.update("INSERT INTO categoria_material (nome) VALUES (?)", c.getNome());
    }
    public List<CategoriaMaterial> listarCategorias() {
        return jdbc.query("SELECT * FROM categoria_material", (rs, i) -> {
            CategoriaMaterial c = new CategoriaMaterial();
            c.setId(rs.getLong("id")); c.setNome(rs.getString("nome")); return c;
        });
    }
    public void deletarCategoria(Long id) { jdbc.update("DELETE FROM categoria_material WHERE id = ?", id); }

    // --- MARCA ---
    public void salvarMarca(Marca m) {
        jdbc.update("INSERT INTO marca (nome) VALUES (?)", m.getNome());
    }
    public List<Marca> listarMarcas() {
        return jdbc.query("SELECT * FROM marca", (rs, i) -> {
            Marca m = new Marca(); m.setId(rs.getLong("id")); m.setNome(rs.getString("nome")); return m;
        });
    }
    public void deletarMarca(Long id) { jdbc.update("DELETE FROM marca WHERE id = ?", id); }

    // --- UNIDADE DE MEDIDA ---
    public void salvarUnidade(UnidadeMedida u) {
        jdbc.update("INSERT INTO unidade_medida (sigla, descricao) VALUES (?, ?)", u.getSigla(), u.getDescricao());
    }
    public List<UnidadeMedida> listarUnidades() {
        return jdbc.query("SELECT * FROM unidade_medida", (rs, i) -> {
            UnidadeMedida u = new UnidadeMedida();
            u.setId(rs.getLong("id")); u.setSigla(rs.getString("sigla")); u.setDescricao(rs.getString("descricao"));
            return u;
        });
    }
    public void deletarUnidade(Long id) { jdbc.update("DELETE FROM unidade_medida WHERE id = ?", id); }

    // --- COR e TAMANHO ---
    public void salvarCor(Cor c) { jdbc.update("INSERT INTO cor (nome) VALUES (?)", c.getNome()); }
    public List<Cor> listarCores() { return jdbc.query("SELECT * FROM cor", (rs, i) -> { Cor c = new Cor(); c.setId(rs.getLong("id")); c.setNome(rs.getString("nome")); return c; }); }

    public void salvarTamanho(Tamanho t) { jdbc.update("INSERT INTO tamanho (descricao) VALUES (?)", t.getDescricao()); }
    public List<Tamanho> listarTamanhos() { return jdbc.query("SELECT * FROM tamanho", (rs, i) -> { Tamanho t = new Tamanho(); t.setId(rs.getLong("id")); t.setDescricao(rs.getString("descricao")); return t; }); }

    // --- PRODUTO ---
    public void salvarProduto(Produto p) {
        jdbc.update("INSERT INTO produto (descricao, categoria_id, unidade_medida_id, marca_id) VALUES (?, ?, ?, ?)",
                p.getDescricao(), p.getCategoria().getId(), p.getUnidadeMedida().getId(), p.getMarca().getId());
    }

    public List<Produto> listarProdutos() {
        String sql = "SELECT p.*, c.nome as cat, m.nome as marca, u.sigla as un FROM produto p " +
                "JOIN categoria_material c ON p.categoria_id = c.id " +
                "JOIN marca m ON p.marca_id = m.id " +
                "JOIN unidade_medida u ON p.unidade_medida_id = u.id";
        return jdbc.query(sql, (rs, i) -> {
            Produto p = new Produto();
            p.setId(rs.getLong("id")); p.setDescricao(rs.getString("descricao"));

            CategoriaMaterial c = new CategoriaMaterial(); c.setId(rs.getLong("categoria_id")); c.setNome(rs.getString("cat"));
            p.setCategoria(c);

            Marca m = new Marca(); m.setId(rs.getLong("marca_id")); m.setNome(rs.getString("marca"));
            p.setMarca(m);

            UnidadeMedida u = new UnidadeMedida(); u.setId(rs.getLong("unidade_medida_id")); u.setSigla(rs.getString("un"));
            p.setUnidadeMedida(u);
            return p;
        });
    }
    public void deletarProduto(Long id) { jdbc.update("DELETE FROM produto WHERE id = ?", id); }

    // --- PRODUTO VARIAÇÃO ---
    public void salvarVariacao(ProdutoVariacao pv) {
        jdbc.update("INSERT INTO produto_variacao (produto_id, cor_id, tamanho_id, codigo_barras, codigo_interno) VALUES (?, ?, ?, ?, ?)",
                pv.getProduto().getId(), pv.getCor().getId(), pv.getTamanho().getId(), pv.getCodigoBarras(), pv.getCodigoInterno());
    }

    public List<ProdutoVariacao> listarVariacoes() {
        String sql = "SELECT pv.*, p.descricao as p_desc, c.nome as c_nome, t.descricao as t_desc " +
                "FROM produto_variacao pv " +
                "JOIN produto p ON pv.produto_id = p.id " +
                "JOIN cor c ON pv.cor_id = c.id " +
                "JOIN tamanho t ON pv.tamanho_id = t.id";

        return jdbc.query(sql, (rs, i) -> {
            ProdutoVariacao pv = new ProdutoVariacao();
            pv.setId(rs.getLong("id"));
            pv.setCodigoBarras(rs.getString("codigo_barras"));
            pv.setCodigoInterno(rs.getString("codigo_interno"));

            Produto p = new Produto(); p.setId(rs.getLong("produto_id")); p.setDescricao(rs.getString("p_desc"));
            pv.setProduto(p);

            Cor c = new Cor(); c.setId(rs.getLong("cor_id")); c.setNome(rs.getString("c_nome"));
            pv.setCor(c);

            Tamanho t = new Tamanho(); t.setId(rs.getLong("tamanho_id")); t.setDescricao(rs.getString("t_desc"));
            pv.setTamanho(t);

            return pv;
        });
    }

    public void deletarVariacao(Long id) {
        jdbc.update("DELETE FROM produto_variacao WHERE id = ?", id);
    }
}
