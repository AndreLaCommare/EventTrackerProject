-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gymdb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `gymdb` ;

-- -----------------------------------------------------
-- Schema gymdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gymdb` DEFAULT CHARACTER SET utf8 ;
USE `gymdb` ;

-- -----------------------------------------------------
-- Table `gym`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `gym` ;

CREATE TABLE IF NOT EXISTS `gym` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `address` VARCHAR(45) NULL,
  `phone_number` VARCHAR(45) NULL,
  `state` VARCHAR(45) NULL,
  `city` VARCHAR(45) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `member`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `member` ;

CREATE TABLE IF NOT EXISTS `member` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `phone_number` VARCHAR(45) NULL,
  `gym_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_member_gym_idx` (`gym_id` ASC),
  CONSTRAINT `fk_member_gym`
    FOREIGN KEY (`gym_id`)
    REFERENCES `gym` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE = '';
DROP USER IF EXISTS gymrat@localhost;
SET SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';
CREATE USER 'gymrat'@'localhost' IDENTIFIED BY 'gymrat';

GRANT SELECT, INSERT, TRIGGER, UPDATE, DELETE ON TABLE * TO 'gymrat'@'localhost';

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `gym`
-- -----------------------------------------------------
START TRANSACTION;
USE `gymdb`;
INSERT INTO `gym` (`id`, `name`, `address`, `phone_number`, `state`, `city`) VALUES (1, 'AC4 Fitness', '52 N. Fairveiw Avenue', '8051234567', 'CA', 'Santa Barbara');
INSERT INTO `gym` (`id`, `name`, `address`, `phone_number`, `state`, `city`) VALUES (2, 'Transition Jiu Jitsu', '1058 Hollister Avenue', '8056895791', 'CA', 'Santa Barbara');

COMMIT;


-- -----------------------------------------------------
-- Data for table `member`
-- -----------------------------------------------------
START TRANSACTION;
USE `gymdb`;
INSERT INTO `member` (`id`, `name`, `phone_number`, `gym_id`) VALUES (1, 'Andre La Commare', '8054569466', 1);
INSERT INTO `member` (`id`, `name`, `phone_number`, `gym_id`) VALUES (2, 'Joe Castillo', '8057654321', 1);
INSERT INTO `member` (`id`, `name`, `phone_number`, `gym_id`) VALUES (3, 'Ian Calhoun', '8057193645', 2);
INSERT INTO `member` (`id`, `name`, `phone_number`, `gym_id`) VALUES (4, 'Kyle Schweke', '8054791037', 2);

COMMIT;

