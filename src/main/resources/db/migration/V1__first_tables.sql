DROP SCHEMA IF EXISTS FTS_DB;
CREATE SCHEMA IF NOT EXISTS FTS_DB;
USE FTS_DB;

-- -----------------------------------------------------
-- Table `FTS_DB`.`survey`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FTS_DB`.`survey` (
  `s_id`        INT NOT NULL AUTO_INCREMENT,
  `date`        date NOT NULL,
  `surveyor`    VARCHAR(45) NOT NULL,
  PRIMARY KEY (`s_id`),
  UNIQUE INDEX `survey_UNIQUE` (`s_id` ASC));


-- -- -----------------------------------------------------
-- -- Table `FTS_DB`.`category`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `FTS_DB`.`category` (
--   `cat_id`        INT NOT NULL AUTO_INCREMENT,
--   `answer_types`  VARCHAR(100) NOT NULL,
--   PRIMARY KEY (`cat_id`),
--   UNIQUE INDEX `category_UNIQUE` (`cat_id` ASC));


-- -----------------------------------------------------
-- Table `FTS_DB`.`question`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FTS_DB`.`question` (
  `q_id`            INT NOT NULL AUTO_INCREMENT,
  `test_question`   VARCHAR(100) NOT NULL,
  PRIMARY KEY (`q_id`),
  UNIQUE INDEX `question_UNIQUE` (`q_id` ASC));


-- -- -----------------------------------------------------
-- -- Table `FTS_DB`.`question`
-- -- -----------------------------------------------------
-- CREATE TABLE IF NOT EXISTS `FTS_DB`.`question` (
--   `q_id`            INT NOT NULL AUTO_INCREMENT,
--   `test_question`   VARCHAR(100) NOT NULL,
--   `cat_id`          INT NOT NULL,
--   PRIMARY KEY (`q_id`),
--   UNIQUE INDEX `question_UNIQUE` (`q_id` ASC),
--   CONSTRAINT `cat_id`
--     FOREIGN KEY (`cat_id`)
--     REFERENCES `FTS_DB`.`category` (`cat_id`)
--     ON DELETE NO ACTION
--     ON UPDATE NO ACTION);



-- -----------------------------------------------------
-- Table `FTS_DB`.`survey_question_answer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `FTS_DB`.`survey_question_answer` (
  `s_id`    INT NOT NULL,
  `q_id`    INT NOT NULL,
  `test`    VARCHAR(100) NOT NULL,
  CONSTRAINT `s_id`
    FOREIGN KEY (`s_id`)
    REFERENCES `FTS_DB`.`survey` (`s_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `q_id`
    FOREIGN KEY (`q_id`)
    REFERENCES `FTS_DB`.`question` (`q_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);
