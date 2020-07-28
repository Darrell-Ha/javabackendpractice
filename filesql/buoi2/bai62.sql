-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `mydb2` ;

-- -----------------------------------------------------
-- Table `mydb2`.`TEAM_INFOR`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`TEAM_INFOR` (
  `Name` VARCHAR(20) NOT NULL,
  `Count_mem` INT NOT NULL CHECK (Count_mem>=1 AND Count_mem<=5),
  PRIMARY KEY (`Name`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb2`.`RS_STUDENTS`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`RS_STUDENTS` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(15) NOT NULL,
  `Class` VARCHAR(15) NOT NULL,
  `TEAM_INFOR_Name` VARCHAR(20) NOT NULL,
  `Role` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ID`, `TEAM_INFOR_Name`),
  INDEX `fk_RS_STUDENTS_TEAM_INFOR_idx` (`TEAM_INFOR_Name` ASC) VISIBLE,
  CONSTRAINT `fk_RS_STUDENTS_TEAM_INFOR`
    FOREIGN KEY (`TEAM_INFOR_Name`)
    REFERENCES `mydb2`.`TEAM_INFOR` (`Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb2`.`RS_GUIDE`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`RS_GUIDE` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(15) NOT NULL,
  `Degree` VARCHAR(10) NOT NULL,
  `Rank_Study` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `mydb2`.`RS_TOPIC`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb2`.`RS_TOPIC` (
  `ID` INT NOT NULL,
  `Name` VARCHAR(45) NOT NULL,
  `Type_Field` VARCHAR(30) NOT NULL,
  `TEAM_INFOR_Name` VARCHAR(20) NOT NULL,
  `RS_GUIDE_ID` INT NOT NULL,
  PRIMARY KEY (`ID`, `TEAM_INFOR_Name`, `RS_GUIDE_ID`),
  INDEX `fk_RS_TOPIC_TEAM_INFOR1_idx` (`TEAM_INFOR_Name` ASC) VISIBLE,
  INDEX `fk_RS_TOPIC_RS_GUIDE1_idx` (`RS_GUIDE_ID` ASC) VISIBLE,
  CONSTRAINT `fk_RS_TOPIC_TEAM_INFOR1`
    FOREIGN KEY (`TEAM_INFOR_Name`)
    REFERENCES `mydb2`.`TEAM_INFOR` (`Name`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_RS_TOPIC_RS_GUIDE1`
    FOREIGN KEY (`RS_GUIDE_ID`)
    REFERENCES `mydb2`.`RS_GUIDE` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
