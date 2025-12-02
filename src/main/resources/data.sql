-- 1. RH
INSERT INTO pessoa (nome, cpf, email, telefone, ativo) VALUES ('Ivan da Silva', '11122233344', 'ivan@ifce.edu.br', '85999990000', true);
INSERT INTO setor (nome, sigla) VALUES ('Jardinagem e Paisagismo', 'JARD');
INSERT INTO tipo_funcionario (descricao) VALUES ('Tecnico Especializado');
INSERT INTO funcionario (pessoa_id, setor_id, tipo_funcionario_id, data_admissao) VALUES (1, 1, 1, '2025-01-10');
INSERT INTO equipe_manutencao (nome, turno) VALUES ('Equipe Alfa', 'Matutino');

-- 2. MATERIAIS
INSERT INTO categoria_material (nome) VALUES ('Ferramentas Manuais');
INSERT INTO marca (nome) VALUES ('Tramontina');
INSERT INTO unidade_medida (sigla, descricao) VALUES ('UN', 'Unidade');
INSERT INTO cor (nome) VALUES ('Verde Escuro');
INSERT INTO tamanho (descricao) VALUES ('Grande');
INSERT INTO produto (descricao, categoria_id, marca_id, unidade_medida_id) VALUES ('Pá de Bico', 1, 1, 1);
INSERT INTO produto_variacao (produto_id, cor_id, tamanho_id, codigo_barras, codigo_interno) VALUES (1, 1, 1, '7891234560001', 'PA-BICO-G-VD');

-- 3. ESTOQUE
INSERT INTO local_estoque (descricao, responsavel_id) VALUES ('Almoxarifado Central', 1);
INSERT INTO tipo_movimento_estoque (descricao, sinal) VALUES ('Entrada por Compra', '+');
INSERT INTO estoque (produto_variacao_id, local_estoque_id, quantidade, ponto_reposicao) VALUES (1, 1, 50.0, 10.0);
INSERT INTO movimento_estoque (produto_variacao_id, local_estoque_id, tipo_movimento_id, quantidade, data_hora, funcionario_id, observacao) VALUES (1, 1, 1, 50.0, CURRENT_TIMESTAMP, 1, 'Estoque Inicial Automático');

-- 4. OS (Configuração)
INSERT INTO tipo_ordem_servico (descricao) VALUES ('Manutenção de Jardim');
INSERT INTO status_ordem_servico (descricao) VALUES ('Aberta');
INSERT INTO status_ordem_servico (descricao) VALUES ('Em Andamento');
INSERT INTO status_ordem_servico (descricao) VALUES ('Concluída');
INSERT INTO tipo_area_campus (descricao) VALUES ('Área Externa');
INSERT INTO area_campus (tipo_area_id, descricao, bloco) VALUES (1, 'Jardim do Bloco A', 'A');

-- 5. OS (Abertura e Detalhes)
INSERT INTO ordem_servico (numero_sequencial, solicitante_id, area_campus_id, tipo_os_id, equipe_id, lider_id, status_id, prioridade, descricao_problema, data_abertura)
VALUES ('OS-2025-001', 1, 1, 1, 1, 1, 1, 5, 'Torneira vazando', CURRENT_TIMESTAMP);
INSERT INTO item_ordem_servico (os_id, produto_variacao_id, quantidade_prevista, quantidade_usada) VALUES (1, 1, 1.0, 0.0);
INSERT INTO andamento_ordem_servico (os_id, status_anterior_id, status_novo_id, funcionario_id, descricao, data_hora)
VALUES (1, 1, 2, 1, 'Equipe iniciou o deslocamento', CURRENT_TIMESTAMP);
UPDATE ordem_servico SET status_id = 2 WHERE id = 1;