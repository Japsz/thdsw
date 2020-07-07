-- MySQL Script generated by MySQL Workbench
-- Tue Jul  7 14:05:39 2020
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema thdsw
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema thdsw
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `thdsw` DEFAULT CHARACTER SET utf8 ;
USE `thdsw` ;

-- -----------------------------------------------------
-- Table `thdsw`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thdsw`.`user` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(15) NOT NULL,
  `password` MEDIUMTEXT NOT NULL,
  `type` INT(1) NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `thdsw`.`empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thdsw`.`empleado` (
  `iduser` INT NOT NULL,
  `nombre` VARCHAR(20) NULL,
  `rut` VARCHAR(45) NULL,
  `afp` VARCHAR(45) NULL,
  `isapre` VARCHAR(45) NULL,
  `profesion` VARCHAR(45) NULL,
  `mailInstitucional` VARCHAR(45) NULL,
  `mailPersonal` VARCHAR(45) NULL,
  `telefono` VARCHAR(45) NULL,
  `celular` VARCHAR(45) NULL,
  `direccion` VARCHAR(45) NULL,
  `nacimiento` DATETIME NULL,
  `diasrestantes` INT NOT NULL DEFAULT 10,
  PRIMARY KEY (`iduser`),
  CONSTRAINT `fk_empleado_user`
    FOREIGN KEY (`iduser`)
    REFERENCES `thdsw`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `thdsw`.`asistencia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thdsw`.`asistencia` (
  `idasistencia` INT NOT NULL AUTO_INCREMENT,
  `iduser` INT NOT NULL,
  `type` INT NOT NULL,
  `justificacion` VARCHAR(100) NOT NULL,
  `fecha` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`idasistencia`),
  INDEX `fk_asistencia_user1_idx` (`iduser` ASC) VISIBLE,
  CONSTRAINT `fk_asistencia_user1`
    FOREIGN KEY (`iduser`)
    REFERENCES `thdsw`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `thdsw`.`solicitud`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thdsw`.`solicitud` (
  `idsolicitud` INT NOT NULL AUTO_INCREMENT,
  `iduser` INT NOT NULL,
  `solicitudcol` VARCHAR(45) NULL,
  `type` INT NOT NULL,
  `status` INT NOT NULL,
  `fechaResolucion` DATETIME NULL,
  `fechaCreacion` DATETIME NULL,
  PRIMARY KEY (`idsolicitud`),
  INDEX `fk_solicitud_user1_idx` (`iduser` ASC) VISIBLE,
  CONSTRAINT `fk_solicitud_user1`
    FOREIGN KEY (`iduser`)
    REFERENCES `thdsw`.`user` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `thdsw`.`permiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thdsw`.`permiso` (
  `idpermiso` INT NOT NULL AUTO_INCREMENT,
  `tiempoRespuesta` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idpermiso`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `thdsw`.`certificado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thdsw`.`certificado` (
  `idcertificado` INT NOT NULL AUTO_INCREMENT,
  `tiempoRespuesta` INT NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idcertificado`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `thdsw`.`solicitudCertificado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thdsw`.`solicitudCertificado` (
  `idsolicitud` INT NOT NULL,
  `fileLink` MEDIUMTEXT NULL,
  `certificado_idcertificado` INT NOT NULL,
  PRIMARY KEY (`idsolicitud`, `certificado_idcertificado`),
  INDEX `fk_solicitudCertificado_certificado1_idx` (`certificado_idcertificado` ASC) VISIBLE,
  CONSTRAINT `fk_table1_solicitud1`
    FOREIGN KEY (`idsolicitud`)
    REFERENCES `thdsw`.`solicitud` (`idsolicitud`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitudCertificado_certificado1`
    FOREIGN KEY (`certificado_idcertificado`)
    REFERENCES `thdsw`.`certificado` (`idcertificado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `thdsw`.`solicitudPermiso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `thdsw`.`solicitudPermiso` (
  `idsolicitud` INT NOT NULL,
  `to` DATETIME NOT NULL,
  `from` DATETIME NOT NULL,
  `permiso_idpermiso` INT NOT NULL,
  PRIMARY KEY (`idsolicitud`, `permiso_idpermiso`),
  INDEX `fk_solicitudPermiso_permiso1_idx` (`permiso_idpermiso` ASC) VISIBLE,
  CONSTRAINT `fk_table1_solicitud2`
    FOREIGN KEY (`idsolicitud`)
    REFERENCES `thdsw`.`solicitud` (`idsolicitud`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_solicitudPermiso_permiso1`
    FOREIGN KEY (`permiso_idpermiso`)
    REFERENCES `thdsw`.`permiso` (`idpermiso`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE USER 'admin' IDENTIFIED BY 'thdsw2020';

GRANT ALL ON `thdsw`.* TO 'admin';
GRANT EXECUTE ON ROUTINE `thdsw`.* TO 'admin';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
