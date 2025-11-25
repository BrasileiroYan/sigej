package com.example.SIGEJ.dao;

import com.example.SIGEJ.model.rh.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public class RhDAO {

    private final JdbcTemplate jdbc;

    public RhDAO(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    // ================== PESSOA ==================
    public Pessoa salvarPessoa(Pessoa p) {
        String sql = "INSERT INTO pessoa (nome, cpf, matricula_siape, email, telefone, ativo) VALUES (?, ?, ?, ?, ?, ?) RETURNING id";
        Long id = jdbc.queryForObject(sql, Long.class, p.getNome(), p.getCpf(), p.getMatriculaSiape(), p.getEmail(), p.getTelefone(), true);
        p.setId(id);
        return p;
    }

    public List<Pessoa> listarPessoas() {
        return jdbc.query("SELECT * FROM pessoa", (rs, i) -> {
            Pessoa p = new Pessoa();
            p.setId(rs.getLong("id"));
            p.setNome(rs.getString("nome"));
            p.setCpf(rs.getString("cpf"));
            p.setEmail(rs.getString("email"));
            return p;
        });
    }

    // ================== SETOR ==================
    public void salvarSetor(Setor s) {
        jdbc.update("INSERT INTO setor (nome, sigla) VALUES (?, ?)", s.getNome(), s.getSigla());
    }

    public List<Setor> listarSetores() {
        return jdbc.query("SELECT * FROM setor", (rs, i) -> {
            Setor s = new Setor();
            s.setId(rs.getLong("id"));
            s.setNome(rs.getString("nome"));
            s.setSigla(rs.getString("sigla"));
            return s;
        });
    }

    // ================== TIPO FUNCIONARIO ==================
    public void salvarTipoFuncionario(TipoFuncionario t) {
        jdbc.update("INSERT INTO tipo_funcionario (descricao) VALUES (?)", t.getDescricao());
    }

    public List<TipoFuncionario> listarTiposFuncionario() {
        return jdbc.query("SELECT * FROM tipo_funcionario", (rs, i) -> {
            TipoFuncionario t = new TipoFuncionario();
            t.setId(rs.getLong("id"));
            t.setDescricao(rs.getString("descricao"));
            return t;
        });
    }

    // ================== FUNCIONARIO ==================
    public void salvarFuncionario(Funcionario f) {
        jdbc.update("INSERT INTO funcionario (pessoa_id, setor_id, tipo_funcionario_id, data_admissao) VALUES (?, ?, ?, ?)",
                f.getPessoa().getId(), f.getSetor().getId(), f.getTipo().getId(), Date.valueOf(f.getDataAdmissao()));
    }

    public List<Funcionario> listarFuncionarios() {
        // JOIN para trazer nomes legíveis
        String sql = "SELECT f.*, p.nome as p_nome, s.nome as s_nome, t.descricao as t_desc FROM funcionario f " +
                "JOIN pessoa p ON f.pessoa_id = p.id " +
                "JOIN setor s ON f.setor_id = s.id " +
                "JOIN tipo_funcionario t ON f.tipo_funcionario_id = t.id";

        return jdbc.query(sql, (rs, i) -> {
            Funcionario f = new Funcionario();
            f.setId(rs.getLong("id"));
            f.setDataAdmissao(rs.getDate("data_admissao").toLocalDate());

            // Preenchendo objetos internos
            Pessoa p = new Pessoa(); p.setId(rs.getLong("pessoa_id")); p.setNome(rs.getString("p_nome"));
            f.setPessoa(p);

            Setor s = new Setor(); s.setId(rs.getLong("setor_id")); s.setNome(rs.getString("s_nome"));
            f.setSetor(s);

            TipoFuncionario t = new TipoFuncionario(); t.setId(rs.getLong("tipo_funcionario_id")); t.setDescricao(rs.getString("t_desc"));
            f.setTipo(t);
            return f;
        });
    }

    // ================== EQUIPE ==================
    public void salvarEquipe(EquipeManutencao e) {
        jdbc.update("INSERT INTO equipe_manutencao (nome, turno) VALUES (?, ?)", e.getNome(), e.getTurno());
    }

    public List<EquipeManutencao> listarEquipes() {
        return jdbc.query("SELECT * FROM equipe_manutencao", (rs, i) -> {
            EquipeManutencao e = new EquipeManutencao();
            e.setId(rs.getLong("id"));
            e.setNome(rs.getString("nome"));
            e.setTurno(rs.getString("turno"));
            return e;
        });
    }

    // ================== MÉTODOS DELETE ================

    public void deletarPessoa(Long id) {
        String sql = "DELETE FROM pessoa WHERE id = ?";
        jdbc.update(sql, id);
    }

    public void deletarSetor(Long id) {
        String sql = "DELETE FROM setor WHERE id = ?";
        jdbc.update(sql, id);
    }

    public void deletarTipoFuncionario(Long id) {
        String sql = "DELETE FROM tipo_funcionario WHERE id = ?";
        jdbc.update(sql, id);
    }

    public void deletarFuncionario(Long id) {
        String sql = "DELETE FROM funcionario WHERE id = ?";
        jdbc.update(sql, id);
    }

    public void deletarEquipe(Long id) {
        String sql = "DELETE FROM equipe_manutencao WHERE id = ?";
        jdbc.update(sql, id);
    }
}
