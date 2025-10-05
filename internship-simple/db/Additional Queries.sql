CREATE TABLE `student_management`.`sports` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE);

ALTER TABLE `student_management`.`sports` 
CHANGE COLUMN `id` `id` INT NOT NULL AUTO_INCREMENT ;

INSERT INTO `student_management`.`sports` (`name`) VALUES ('Cricket');
INSERT INTO `student_management`.`sports` (`name`) VALUES ('Football');
INSERT INTO `student_management`.`sports` (`name`) VALUES ('Chess');
INSERT INTO `student_management`.`sports` (`name`) VALUES ('Carrom');


CREATE TABLE `student_management`.`students_sports` (
  `student_id` INT NOT NULL,
  `sport_id` INT NOT NULL,
  PRIMARY KEY (`student_id`, `sport_id`));
