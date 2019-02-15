CREATE TABLE `votacao_app`.`pauta` (
  `id_pauta` INT NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id_pauta`)) DEFAULT CHARSET=utf8;
  
  CREATE TABLE `votacao_app`.`associado` (
  `id_associado` INT NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(15) NOT NULL,
  `senha` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id_associado`)) DEFAULT CHARSET=utf8;
  
  CREATE TABLE `votacao_app`.`voto` (
  `id_voto` INT NOT NULL AUTO_INCREMENT,
  `valor` VARCHAR(3) NOT NULL,
  `id_associado` INT NOT NULL,
  `id_sessao_votacao` INT NOT NULL,
  PRIMARY KEY (`id_voto`)) DEFAULT CHARSET=utf8;
  
  CREATE TABLE `votacao_app`.`sessao_votacao` (
  `id_sessao_votacao` INT NOT NULL AUTO_INCREMENT,
  `inicio` DATETIME NOT NULL,
  `fim` DATETIME NOT NULL,
  `id_pauta` INT NOT NULL,
  PRIMARY KEY (`id_sessao_votacao`)) DEFAULT CHARSET=utf8;