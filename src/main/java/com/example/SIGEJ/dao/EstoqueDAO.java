package com.example.SIGEJ.dao;

import com.example.SIGEJ.model.estoque.Estoque;
import com.example.SIGEJ.model.estoque.LocalEstoque;
import com.example.SIGEJ.model.estoque.MovimentoEstoque;
import com.example.SIGEJ.model.estoque.TipoMovimentoEstoque;
import com.example.SIGEJ.model.materiais.ProdutoVariacao;
import com.example.SIGEJ.model.rh.Funcionario;
import com.example.SIGEJ.model.rh.Pessoa;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class EstoqueDAO {

    private final JdbcTemplate jdbc;

    public EstoqueDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // ---LOCAL DE ESTOQUE ---
    public void salvarLocal(LocalEstoque l) {
        jdbc.update("INSERT INTO local_estoque (descricao, responsavel_id) VALUES (?, ?)",
                l.getDescricao(), l.getResponsavel().getId());
    }
    public List<LocalEstoque> listarLocais() {
        String sql = "SELECT l.*, f.id as f_id, p.nome as p_nome FROM local_estoque l " +
                "JOIN funcionario f ON l.responsavel_id = f.id " +
                "JOIN pessoa p ON f.pessoa_id = p.id";
        return jdbc.query(sql, (rs, i) -> {
            LocalEstoque l = new LocalEstoque();
            l.setId(rs.getLong("id")); l.setDescricao(rs.getString("descricao"));

            Funcionario f = new Funcionario(); f.setId(rs.getLong("f_id"));
            Pessoa p = new Pessoa(); p.setNome(rs.getString("p_nome")); f.setPessoa(p);

            l.setResponsavel(f);
            return l;
        });
    }
    public void deletarLocal(Long id) { jdbc.update("DELETE FROM local_estoque WHERE id = ?", id); }


    // --- TIPO DE MOVIMENTO --
    public void salvarTipoMovimento(TipoMovimentoEstoque t) {
        jdbc.update("INSERT INTO tipo_movimento_estoque (descricao, sinal) VALUES (?, ?)", t.getDescricao(), t.getSinal());
    }
    public List<TipoMovimentoEstoque> listarTiposMovimento() {
        return jdbc.query("SELECT * FROM tipo_movimento_estoque", (rs, i) -> {
            TipoMovimentoEstoque t = new TipoMovimentoEstoque();
            t.setId(rs.getLong("id")); t.setDescricao(rs.getString("descricao")); t.setSinal(rs.getString("sinal"));
            return t;
        });
    }
    public void deletarTipoMovimento(Long id) { jdbc.update("DELETE FROM tipo_movimento_estoque WHERE id = ?", id); }


    // --- ESTOQUE (SALDO)---
    public void inicializarEstoque(Estoque e) {
        String sql = "INSERT INTO estoque (produto_variacao_id, local_estoque_id, quantidade, ponto_reposicao) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, e.getProdutoVariacao().getId(), e.getLocalEstoque().getId(), e.getQuantidade(), e.getPontoReposicao());
    }

    public List<Estoque> listarSaldos() {
        String sql = "SELECT e.*, pv.codigo_interno, le.descricao as loc_desc FROM estoque e " +
                "JOIN produto_variacao pv ON e.produto_variacao_id = pv.id " +
                "JOIN local_estoque le ON e.local_estoque_id = le.id";
        return jdbc.query(sql, (rs, i) -> {
            Estoque e = new Estoque();
            e.setQuantidade(rs.getDouble("quantidade"));
            e.setPontoReposicao(rs.getDouble("ponto_reposicao"));

            ProdutoVariacao pv = new ProdutoVariacao(); pv.setId(rs.getLong("produto_variacao_id")); pv.setCodigoInterno(rs.getString("codigo_interno"));
            e.setProdutoVariacao(pv);

            LocalEstoque le = new LocalEstoque(); le.setId(rs.getLong("local_estoque_id")); le.setDescricao(rs.getString("loc_desc"));
            e.setLocalEstoque(le);
            return e;
        });
    }

    public void deletarSaldo(Long produtoVariacaoId, Long localEstoqueId) {
        String sql = "DELETE FROM estoque WHERE produto_variacao_id = ? AND local_estoque_id = ?";
        jdbc.update(sql, produtoVariacaoId, localEstoqueId);
    }

    // --- MOVIMENTO (HISTÓRICO) ---
    public void registrarMovimento(MovimentoEstoque m) {
        String sql = "INSERT INTO movimento_estoque (produto_variacao_id, local_estoque_id, tipo_movimento_id, quantidade, funcionario_id, ordem_servico_id, observacao, data_hora) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        Long osId = (m.getOrdemServico() != null) ? m.getOrdemServico().getId() : null;

        jdbc.update(sql,
                m.getProdutoVariacao().getId(),
                m.getLocalEstoque().getId(),
                m.getTipoMovimento().getId(),
                m.getQuantidade(),
                m.getFuncionario().getId(),
                osId,
                m.getObservacao(),
                Timestamp.valueOf(LocalDateTime.now())
        );
        String sinal = m.getTipoMovimento().getSinal();
    }

    public List<MovimentoEstoque> listarMovimentos() {
        String sql = "SELECT * FROM movimento_estoque";
        return jdbc.query(sql, (rs, i) -> {
            MovimentoEstoque m = new MovimentoEstoque();
            m.setId(rs.getLong("id"));
            m.setQuantidade(rs.getDouble("quantidade"));
            m.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
            m.setObservacao(rs.getString("observacao"));
            ProdutoVariacao pv = new ProdutoVariacao(); pv.setId(rs.getLong("produto_variacao_id")); m.setProdutoVariacao(pv);
            return m;
        });
    }

    public void deletarMovimento(Long id) {
        String sql = "DELETE FROM movimento_estoque WHERE id = ?";
        jdbc.update(sql, id);
    }
}
