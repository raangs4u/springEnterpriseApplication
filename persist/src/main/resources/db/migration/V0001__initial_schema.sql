CREATE TABLE IF NOT EXISTS `springbootdb`.`user` (
  `user_id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `user_name` VARCHAR(45) NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`user_id`));
