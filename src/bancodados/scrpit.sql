CREATE DATABASE `Atv2` /*!40100 DEFAULT CHARACTER SET utf8 */;
use  atv2;


CREATE TABLE IF NOT EXISTS `Aluno` (
  `matricula` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(11) NULL,
  `dataNascimento` DATETIME NULL,
  `email` VARCHAR(45) NULL,
  `Pessoa_nome` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`matricula`));
  

