-- Inserting dummy data into cliente
INSERT INTO cliente (nome, documento) VALUES
                                          ('José Silva', '12345678901'),
                                          ('Maria Oliveira', '09876543211'),
                                          ('Carlos Souza', '11223344556');

-- Inserting dummy data into funcionario
INSERT INTO funcionario (nome, cpf, cargo) VALUES
                                               ('Antonio Alves', '12345678901', 'GERENTE'),
                                               ('Beatriz Rocha', '98765432101', 'ATENDENTE'),
                                               ('Claudio Ramos', '45678912301', 'CAIXA');

-- Inserting dummy data into fornecedor
INSERT INTO fornecedor (nome, cnpj) VALUES
                                        ('Fornecedor A', '12345678000123'),
                                        ('Fornecedor B', '98765432000198'),
                                        ('Fornecedor C', '45678912000145');

-- Inserting dummy data into ordem_compra
INSERT INTO ordem_compra (data_compra, valor_total, fornecedor_id, produto, descricao, tipo) VALUES
                                                                                                 ('2023-09-28', 1500.00, 1, 'Produto X', 'Descrição do Produto X', 'CONVENIENCIA'),
                                                                                                 ('2023-09-29', 2300.00, 2, 'Produto Y', 'Descrição do Produto Y', 'COMBUSTIVEL');

-- Inserting dummy data into venda_conveniencia
INSERT INTO venda_conveniencia (data_venda, valor_total, cliente_id, produto, descricao) VALUES
                                                                                             ('2023-09-28', 300.00, 1, 'Produto A', 'Descrição do Produto A'),
                                                                                             ('2023-09-29', 500.00, 2, 'Produto B', 'Descrição do Produto B');

-- Inserting dummy data into bomba
INSERT INTO bomba (combustivel, preco, quantidade_atual, capacidade) VALUES
                                                                         ('GASOLINA_COMUM', 5.29, 300.00, 1000.00),
                                                                         ('DIESEL', 4.89, 500.00, 1500.00);

-- Inserting dummy data into abastecimento
INSERT INTO abastecimento (preco, data_venda, quantidade, bomba_id, cliente_id) VALUES
                                                                                    (100.00, '2023-09-28', 20.00, 1, 1),
                                                                                    (150.00, '2023-09-29', 30.00, 2, 2);
