-- ===============================================
-- POPULAÇÃO DE DADOS REALISTAS - BANCO aluguel_carros
-- ===============================================

-- ===============================================
-- TABELA: CLIENTE
-- ===============================================
INSERT INTO CLIENTE (ID_CLIENTE, NOME, CPF, TELEFONE, EMAIL, ENDERECO) VALUES
(1, 'Mariana Alves Rocha', '38729465081', '(11) 98822-3746', 'mariana.rocha@gmail.com', 'Av. Paulista, 1578 - Bela Vista, São Paulo - SP'),
(2, 'João Pedro Ferreira', '24983715602', '(21) 97122-4032', 'joao.ferreira@outlook.com', 'Rua das Laranjeiras, 45 - Laranjeiras, Rio de Janeiro - RJ'),
(3, 'Camila Santos Nogueira', '04852967314', '(31) 98711-5290', 'camila.nogueira@yahoo.com', 'Rua Padre Eustáquio, 220 - Padre Eustáquio, Belo Horizonte - MG'),
(4, 'Lucas Almeida Costa', '17592043850', '(41) 99215-4400', 'lucas.costa@gmail.com', 'Rua XV de Novembro, 990 - Centro, Curitiba - PR'),
(5, 'Fernanda Dias Lima', '09385742611', '(81) 98125-6378', 'fernanda.lima@hotmail.com', 'Av. Boa Viagem, 4000 - Boa Viagem, Recife - PE'),
(6, 'Rafael Oliveira Pinto', '32650987420', '(51) 99711-8854', 'rafael.pinto@gmail.com', 'Rua dos Andradas, 1300 - Centro, Porto Alegre - RS'),
(7, 'Beatriz Gomes Tavares', '40852719693', '(62) 98441-7283', 'beatriz.tavares@uol.com.br', 'Rua 24 de Outubro, 201 - Setor Oeste, Goiânia - GO'),
(8, 'Thiago Mendes Souza', '05734198270', '(85) 98930-5511', 'thiago.souza@gmail.com', 'Av. Beira Mar, 900 - Meireles, Fortaleza - CE'),
(9, 'Larissa Carvalho Pires', '31985720480', '(19) 99740-2258', 'larissa.pires@icloud.com', 'Rua Barreto Leme, 712 - Cambuí, Campinas - SP'),
(10, 'Gustavo Ribeiro Azevedo', '23498765091', '(71) 98244-9001', 'gustavo.azevedo@bol.com.br', 'Av. Sete de Setembro, 2140 - Vitória, Salvador - BA');

-- ===============================================
-- TABELA: CARRO
-- ===============================================
INSERT INTO CARRO (ID_CARRO, MODELO, MARCA, ANO, PLACA, STATUS, VALOR_DIARIA) VALUES
(1, 'Onix LT 1.0', 'Chevrolet', 2022, 'FRA9C32', 'DISPONIVEL', 145.00),
(2, 'HB20S Comfort', 'Hyundai', 2021, 'GHD5E21', 'ALUGADO', 160.00),
(3, 'Corolla XEi 2.0', 'Toyota', 2023, 'JKT7B99', 'DISPONIVEL', 250.00),
(4, 'Compass Limited', 'Jeep', 2022, 'PQZ3A55', 'MANUTENCAO', 300.00),
(5, 'Civic Touring 1.5', 'Honda', 2023, 'KSL9J44', 'DISPONIVEL', 280.00),
(6, 'Argo Drive 1.0', 'Fiat', 2021, 'RGA1H27', 'ALUGADO', 130.00),
(7, 'Kwid Zen 1.0', 'Renault', 2022, 'TTD2I88', 'DISPONIVEL', 110.00),
(8, 'T-Cross Highline', 'Volkswagen', 2023, 'VPL6E91', 'DISPONIVEL', 265.00),
(9, 'Tracker Premier', 'Chevrolet', 2022, 'HGM8C50', 'ALUGADO', 240.00),
(10, 'Sandero Expression', 'Renault', 2020, 'JKR7G31', 'MANUTENCAO', 120.00);

-- ===============================================
-- TABELA: FUNCIONARIO (SENHAS HASHED - SHA256)
-- ===============================================
INSERT INTO FUNCIONARIO (ID_FUNCIONARIO, NOME, EMAIL, SENHA, CARGO) VALUES
(1, 'Carolina Martins', 'carolina.martins@smartdrive.com.br', '240be518fabd2724ddb6f04eeb1da5967448d7e831c08c8fa822809f74c720a9', 'ADMIN'),   -- admin123
(2, 'Eduardo Farias', 'eduardo.farias@smartdrive.com.br', '91dfd9ddb4198affc5c194cd8ce6d338fde470e2', 'USER'),                               -- maca
(3, 'Priscila Andrade', 'priscila.andrade@smartdrive.com.br', 'b7a875fc1ea228b9061041b7cec4bd3c52ab3ce3', 'USER'),                            -- banana
(4, 'Felipe Moura', 'felipe.moura@smartdrive.com.br', 'e5fe49f04c24b0a84d6c05d8e6f6a8dc2bfae9b1d52a3a7c0a6b3e1d7e8a6a1c', 'USER'),            -- laranja
(5, 'Juliana Teixeira', 'juliana.teixeira@smartdrive.com.br', 'a51ecf4b9d92f8b5d55b5bbd285d010c7a9c379d45b6ecbc3d65cf6f5d77f6b5', 'USER');     -- uva

-- ===============================================
-- TABELA: ALUGUEL
-- ===============================================
INSERT INTO ALUGUEL (ID_ALUGUEL, FK_CLIENTE_ID, FK_CARRO_ID, FK_FUNCIONARIO_ID, DATA_INICIO, DATA_FIM, VALOR_TOTAL, STATUS) VALUES
(1, 1, 2, 2, '2024-09-10', '2024-09-15', 800.00, 'FINALIZADO'),
(2, 2, 6, 3, '2025-02-03', '2025-02-06', 390.00, 'FINALIZADO'),
(3, 3, 9, 4, '2025-09-25', '2025-09-28', 720.00, 'ATIVO'),
(4, 4, 1, 5, '2025-10-01', '2025-10-05', 580.00, 'ATIVO'),
(5, 5, 8, 2, '2025-07-15', '2025-07-20', 1325.00, 'FINALIZADO'),
(6, 6, 7, 3, '2025-04-05', '2025-04-10', 550.00, 'CANCELADO'),
(7, 7, 5, 1, '2024-12-10', '2024-12-15', 1400.00, 'FINALIZADO'),
(8, 8, 3, 4, '2025-09-29', '2025-10-04', 1250.00, 'ATIVO'),
(9, 9, 9, 2, '2025-09-01', '2025-09-05', 960.00, 'FINALIZADO'),
(10, 10, 2, 3, '2025-08-10', '2025-08-15', 800.00, 'FINALIZADO');

-- ===============================================
-- TABELA: PAGAMENTO
-- ===============================================
INSERT INTO PAGAMENTO (ID_PAGAMENTO, FK_ALUGUEL_ID, DATA_PAGAMENTO, VALOR_PAGO, METODO) VALUES
(1, 1, '2024-09-15', 800.00, 'PIX'),
(2, 2, '2025-02-06', 390.00, 'CARTAO'),
(3, 5, '2025-07-20', 1325.00, 'CARTAO'),
(4, 7, '2024-12-15', 1400.00, 'PIX'),
(5, 9, '2025-09-05', 960.00, 'DINHEIRO'),
(6, 10, '2025-08-15', 800.00, 'CARTAO'),
(7, 3, '2025-09-28', 720.00, 'PIX'),
(8, 4, '2025-10-05', 580.00, 'CARTAO');

-- ===============================================
-- TABELA: MANUTENCAO
-- ===============================================
INSERT INTO MANUTENCAO (ID_MANUTENCAO, FK_CARRO_ID, DATA_MANUTENCAO, DESCRICAO, VALOR) VALUES
(1, 4, '2025-09-20', 'Troca de pastilhas de freio e alinhamento', 650.00),
(2, 10, '2025-08-05', 'Revisão geral e troca de óleo', 480.00),
(3, 4, '2025-06-18', 'Substituição de amortecedores dianteiros', 850.00),
(4, 10, '2024-11-30', 'Reparo no sistema elétrico', 400.00),
(5, 4, '2024-04-22', 'Troca de pneus e balanceamento', 1200.00);


