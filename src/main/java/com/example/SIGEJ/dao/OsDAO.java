package com.example.SIGEJ.dao;

import com.example.SIGEJ.model.materiais.ProdutoVariacao;
import com.example.SIGEJ.model.rh.*;
import com.example.SIGEJ.model.os.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class OsDAO {

    private final JdbcTemplate jdbc;

    public OsDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // --- Tipo Ordem Serviço ---
    public void salvarTipoOS(TipoOrdemServico t) {
        jdbc.update("INSERT INTO tipo_ordem_servico (descricao) VALUES (?)", t.getDescricao());
    }
    public List<TipoOrdemServico> listarTiposOS() {
        return jdbc.query("SELECT * FROM tipo_ordem_servico", (rs, i) -> {
            TipoOrdemServico t = new TipoOrdemServico();
            t.setId(rs.getLong("id"));
            t.setDescricao(rs.getString("descricao"));
            return t;
        });
    }
    public void deletarTipoOS(Long id) {
        jdbc.update("DELETE FROM tipo_ordem_servico WHERE id = ?", id);
    }

    // --- Status Ordem Serviço ---
    public void salvarStatusOS(StatusOrdemServico s) {
        jdbc.update("INSERT INTO status_ordem_servico (descricao) VALUES (?)", s.getDescricao());
    }
    public List<StatusOrdemServico> listarStatusOS() {
        return jdbc.query("SELECT * FROM status_ordem_servico", (rs, i) -> {
            StatusOrdemServico s = new StatusOrdemServico();
            s.setId(rs.getLong("id"));
            s.setDescricao(rs.getString("descricao"));
            return s;
        });
    }
    public void deletarStatusOS(Long id) {
        jdbc.update("DELETE FROM status_ordem_servico WHERE id = ?", id);
    }

    // --- Tipo Área Campus ---
    public void salvarTipoArea(TipoAreaCampus t) {
        jdbc.update("INSERT INTO tipo_area_campus (descricao) VALUES (?)", t.getDescricao());
    }
    public List<TipoAreaCampus> listarTiposArea() {
        return jdbc.query("SELECT * FROM tipo_area_campus", (rs, i) -> {
            TipoAreaCampus t = new TipoAreaCampus();
            t.setId(rs.getLong("id"));
            t.setDescricao(rs.getString("descricao"));
            return t;
        });
    }
    public void deletarTipoArea(Long id) {
        jdbc.update("DELETE FROM tipo_area_campus WHERE id = ?", id);
    }

    // --- Área Campus ---
    public void salvarArea(AreaCampus a) {
        jdbc.update("INSERT INTO area_campus (tipo_area_id, descricao, bloco) VALUES (?, ?, ?)",
                a.getTipoArea().getId(), a.getDescricao(), a.getBloco());
    }
    public List<AreaCampus> listarAreas() {
        String sql = "SELECT a.*, t.descricao as t_desc FROM area_campus a JOIN tipo_area_campus t ON a.tipo_area_id = t.id";
        return jdbc.query(sql, (rs, i) -> {
            AreaCampus a = new AreaCampus();
            a.setId(rs.getLong("id"));
            a.setDescricao(rs.getString("descricao"));
            a.setBloco(rs.getString("bloco"));

            TipoAreaCampus t = new TipoAreaCampus();
            t.setId(rs.getLong("tipo_area_id"));
            t.setDescricao(rs.getString("t_desc"));
            a.setTipoArea(t);
            return a;
        });
    }
    public void deletarArea(Long id) {
        jdbc.update("DELETE FROM area_campus WHERE id = ?", id);
    }

    public void abrirOS(OrdemServico os) {
        String sql = "INSERT INTO ordem_servico (numero_sequencial, solicitante_id, area_campus_id, tipo_os_id, prioridade, descricao_problema, status_id, data_abertura) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, NOW())";

        // Assume Status 1 (Aberta) por padrão
        long statusId = (os.getStatus() != null && os.getStatus().getId() != null) ? os.getStatus().getId() : 1L;

        jdbc.update(sql,
                os.getNumeroSequencial(),
                os.getSolicitante().getId(),
                os.getAreaCampus().getId(),
                os.getTipoOs().getId(),
                os.getPrioridade(),
                os.getDescricaoProblema(),
                statusId
        );
    }
    public List<OrdemServico> listarOS() {
        // JOIN para trazer nomes legíveis de Solicitante (Pessoa), Área, Tipo e Status
        String sql = "SELECT os.*, p.nome as p_nome, ac.descricao as ac_desc, tos.descricao as tos_desc, st.descricao as st_desc " +
                "FROM ordem_servico os " +
                "JOIN pessoa p ON os.solicitante_id = p.id " +
                "JOIN area_campus ac ON os.area_campus_id = ac.id " +
                "JOIN tipo_ordem_servico tos ON os.tipo_os_id = tos.id " +
                "JOIN status_ordem_servico st ON os.status_id = st.id";

        return jdbc.query(sql, (rs, i) -> {
            OrdemServico os = new OrdemServico();
            os.setId(rs.getLong("id"));
            os.setNumeroSequencial(rs.getString("numero_sequencial"));
            os.setPrioridade(rs.getInt("prioridade"));
            os.setDescricaoProblema(rs.getString("descricao_problema"));
            os.setDataAbertura(rs.getTimestamp("data_abertura").toLocalDateTime());

            // Preenchendo objetos aninhados
            Pessoa p = new Pessoa();
            p.setId(rs.getLong("solicitante_id"));
            p.setNome(rs.getString("p_nome"));
            os.setSolicitante(p);

            AreaCampus ac = new AreaCampus();
            ac.setId(rs.getLong("area_campus_id"));
            ac.setDescricao(rs.getString("ac_desc"));
            os.setAreaCampus(ac);

            TipoOrdemServico tos = new TipoOrdemServico();
            tos.setId(rs.getLong("tipo_os_id"));
            tos.setDescricao(rs.getString("tos_desc"));
            os.setTipoOs(tos);

            StatusOrdemServico st = new StatusOrdemServico();
            st.setId(rs.getLong("status_id"));
            st.setDescricao(rs.getString("st_desc"));
            os.setStatus(st);

            return os;
        });
    }
    public void deletarOS(Long id) {
        jdbc.update("DELETE FROM ordem_servico WHERE id = ?", id);
    }

    // --- Itens ---
    public void adicionarItem(ItemOrdemServico item) {
        String sql = "INSERT INTO item_ordem_servico (os_id, produto_variacao_id, quantidade_prevista, quantidade_usada) VALUES (?, ?, ?, ?)";
        jdbc.update(sql, item.getOs().getId(), item.getProdutoVariacao().getId(), item.getQuantidadePrevista(), 0.0);
    }
    public List<ItemOrdemServico> listarItensPorOS(Long osId) {
        String sql = "SELECT i.*, p.descricao as p_desc FROM item_ordem_servico i " +
                "JOIN produto_variacao pv ON i.produto_variacao_id = pv.id " +
                "JOIN produto p ON pv.produto_id = p.id " +
                "WHERE i.os_id = ?";
        return jdbc.query(sql, (rs, rowNum) -> {
            ItemOrdemServico i = new ItemOrdemServico();
            i.setId(rs.getLong("id"));
            i.setQuantidadePrevista(rs.getDouble("quantidade_prevista"));
            i.setQuantidadeUsada(rs.getDouble("quantidade_usada"));

            ProdutoVariacao pv = new ProdutoVariacao();
            pv.setId(rs.getLong("produto_variacao_id"));
             i.setProdutoVariacao(pv);

            return i;
        }, osId);
    }
    public void deletarItem(Long id) {
        jdbc.update("DELETE FROM item_ordem_servico WHERE id = ?", id);
    }

    // --- Andamento ---
    public void registrarAndamento(AndamentoOrdemServico a) {
        String sql = "INSERT INTO andamento_ordem_servico (os_id, data_hora, status_anterior_id, status_novo_id, funcionario_id, descricao) " +
                "VALUES (?, NOW(), ?, ?, ?, ?)";
        jdbc.update(sql, a.getOs().getId(), a.getStatusAnterior().getId(), a.getStatusNovo().getId(), a.getFuncionario().getId(), a.getDescricao());

        // Atualiza o status na tabela principal da OS também
        jdbc.update("UPDATE ordem_servico SET status_id = ? WHERE id = ?", a.getStatusNovo().getId(), a.getOs().getId());
    }
    public List<AndamentoOrdemServico> listarAndamentosPorOS(Long osId) {
        String sql = "SELECT a.*, f_pes.nome as func_nome, s1.descricao as st_ant, s2.descricao as st_nov " +
                "FROM andamento_ordem_servico a " +
                "JOIN funcionario f ON a.funcionario_id = f.id " +
                "JOIN pessoa f_pes ON f.pessoa_id = f_pes.id " +
                "JOIN status_ordem_servico s1 ON a.status_anterior_id = s1.id " +
                "JOIN status_ordem_servico s2 ON a.status_novo_id = s2.id " +
                "WHERE a.os_id = ? ORDER BY a.data_hora";

        return jdbc.query(sql, (rs, rowNum) -> {
            AndamentoOrdemServico a = new AndamentoOrdemServico();
            a.setId(rs.getLong("id"));
            a.setDataHora(rs.getTimestamp("data_hora").toLocalDateTime());
            a.setDescricao(rs.getString("descricao"));

            Funcionario f = new Funcionario();
            f.setId(rs.getLong("funcionario_id")); // Idealmente setaria o nome também
            a.setFuncionario(f);

            StatusOrdemServico s1 = new StatusOrdemServico(); s1.setId(rs.getLong("status_anterior_id")); s1.setDescricao(rs.getString("st_ant"));
            a.setStatusAnterior(s1);

            StatusOrdemServico s2 = new StatusOrdemServico(); s2.setId(rs.getLong("status_novo_id")); s2.setDescricao(rs.getString("st_nov"));
            a.setStatusNovo(s2);

            return a;
        }, osId);
    }
    public void deletarAndamento(Long id) {
        jdbc.update("DELETE FROM andamento_ordem_servico WHERE id = ?", id);
    }
}