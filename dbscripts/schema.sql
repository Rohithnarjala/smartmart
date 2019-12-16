SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `smartmart` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `smartmart` ;

CREATE TABLE IF NOT EXISTS `smartmart`.`user` (
  `us_id` INT NOT NULL AUTO_INCREMENT,
  `us_first_name` VARCHAR(50) NULL,
  `us_last_name` VARCHAR(50) NULL,
  `us_age` INT(2) NULL,
  `us_gender` VARCHAR(6) NULL,
  `us_contact_number` BIGINT(10) NULL,
  `us_user_id` VARCHAR(15) NULL,
  `us_password` VARCHAR(200) NULL,
  `us_user_type` VARCHAR(1) NULL,
  `us_reward_points` DECIMAL(8,2) NOT NULL DEFAULT 0,
  `us_status` VARCHAR(1) NULL,
  `us_question_1` VARCHAR(50) NULL,
  `us_answer_1` VARCHAR(50) NULL,
  `us_question_2` VARCHAR(50) NULL,
  `us_answer_2` VARCHAR(50) NULL,
  `us_question_3` VARCHAR(50) NULL,
  `us_answer_3` VARCHAR(50) NULL,
  PRIMARY KEY (`us_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `smartmart`.`product` (
  `pt_id` INT NOT NULL AUTO_INCREMENT,
  `pt_name` VARCHAR(50) NULL,
  `pt_type` INT(2) NULL,
  `pt_brand` VARCHAR(50) NULL,
  `pt_quantity_type` VARCHAR(15) NULL,
  `pt_rate_per_quantity` INT(15) NULL,
  `pt_stock_count` INT(15) NULL,
  `pt_add_date` DATE NULL,
  `pt_aisle` VARCHAR(15) NULL,
  `pt_shelf` VARCHAR(15) NULL,
  `pt_date_of_manufacture` DATE NULL,
  `pt_date_of_expiry` DATE NULL,
  `pt_image` VARCHAR(500) NULL,
  
  PRIMARY KEY (`pt_id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `smartmart`.`bill` (
  `bi_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bi_purchase_date` DATE NOT NULL,
  `bi_discounted_amount` DECIMAL(8,2) NOT NULL,
  `bi_total_amount` DECIMAL(8,2) NOT NULL,
  `bi_reward_points` INT(10) NOT NULL,
  `bi_user_reward_points` DECIMAL(8,2) NOT NULL,
  `bi_us_id` INT(11) NOT NULL,
  PRIMARY KEY (`bi_id`),
  INDEX `bi_us_fk_idx` (`bi_us_id` ASC),
  CONSTRAINT `bi_us_fk`
    FOREIGN KEY (`bi_us_id`)
    REFERENCES `smartmart`.`user` (`us_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `smartmart`.`bill_details` (
  `bd_id` INT(11) NOT NULL AUTO_INCREMENT,
  `bd_pt_id` INT(11) NOT NULL,
  `bd_bi_id` INT(11) NOT NULL,
  `quantity` INT NULL,
  INDEX `bd_bi_fk_idx` (`bd_bi_id` ASC),
  INDEX `bd_pt_fk_idx` (`bd_pt_id` ASC),
  PRIMARY KEY (`bd_id`),
  CONSTRAINT `bd_pt_fk`
    FOREIGN KEY (`bd_pt_id`)
    REFERENCES `smartmart`.`product` (`pt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `bd_bi_fk`
    FOREIGN KEY (`bd_bi_id`)
    REFERENCES `smartmart`.`bill` (`bi_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `smartmart`.`offer` (
  `of_id` INT(11) NOT NULL AUTO_INCREMENT,
  `of_date` DATE NOT NULL,
  `of_discount_percentage` INT(11) NOT NULL,
  `of_offer` VARCHAR(100) NOT NULL,
  `of_pt_id` INT(11) NOT NULL,
  PRIMARY KEY (`of_id`),
  INDEX `fk_offer_product1_idx` (`of_pt_id` ASC),
  CONSTRAINT `fk_offer_product1`
    FOREIGN KEY (`of_pt_id`)
    REFERENCES `smartmart`.`product` (`pt_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;



select*from smartmart.user;
Insert into `smartmart`.`user` values(1,'admin','admin',21,'Male',7356490987,'admin','$2a$10$IoqonpxYeSWir9ir16Pb6.8sCa444mtsH6R6oH.ioWnHkpODsBsPS','O',0,'A','what is your Nick name','aa','what is your favorite food','aa','what is your favorite holiday spot','aa');

select * from smartmart.product;
INSERT into `smartmart`.`product` values (1,'Spoon',1,'Milton','1','15','50','2019-03-15','1','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1549975637-48924cb29f9a?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (2,'Plate',1,'Milton','1','150','50','2019-03-15','1','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1529060256154-8dca470c3325?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (3,'Bottle',1,'Milton','1','50','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1567960148693-2868d9a9b4ed?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (4,'Tumbler',1,'Milton','1','70','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1547383529-2b2374860dc8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (5,'Cooker',1,'Milton','1','999','50','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1544233726-9f1d2b27be8b?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (6,'GarlicBread',2,'Bakers Fresh','1','70','20','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1545339975-a9cbe0af3392?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (7,'FruitJam',2,'Bakers Fresh','1','50','30','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1500912239908-4ee48acb3a7f?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (8,'Cupcakes',2,'Bakers Fresh','1','25','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1486427944299-d1955d23e34d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (9,'Cookies',2,'Bakers Fresh','1','30','50','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1558961363-fa8fdf82db35?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (10,'chocolates',2,'Bakers Fresh','1','70','10','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1566565286951-f81c7ba5619d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (11,'Orange',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1549888834-3ec93abae044?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (12,'Apple',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1560806887-1e4cd0b6cbd6?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (13,'Banana',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1571771894821-ce9b6c11b08e?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (14,'DragonFruit',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1552320188-8b13c30d055d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (15,'Papaya',3,'Farm Fresh','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1570044803045-d790fc159af3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (16,'Popcorn',4,'Aci2','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1505686994434-e3cc5abf1330?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (17,'Nutella',4,'Aci2','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1519420573924-65fcd45245f8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (18,'candies',4,'Aci2','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1542800262-8b3c1a6007ad?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (19,'Biscuits',4,'Aci2','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1575262833822-18728f29c980?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');
INSERT into `smartmart`.`product` values (20,'Doritos',4,'Aci2','1','150','100','2019-03-15','2','1','2017-05-24','2020-04-09','https://images.unsplash.com/photo-1567838080002-b388fbd228ae?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=500&q=60');

