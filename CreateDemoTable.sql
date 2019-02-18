USE test;

DROP TABLE IF EXISTS Part;

CREATE TABLE Part(
  id BIGINT(20) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NULL,
  `currentQuantity` INT(11) NULL,
  `isMandatory` BIT(1) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

insert into Part(name, currentQuantity, isMandatory) values("Sound Card", 3, false);
insert into Part(name, currentQuantity, isMandatory) values("Memory", 18, true);
insert into Part(name, currentQuantity, isMandatory) values("Video card", 8, true);
insert into Part(name, currentQuantity, isMandatory) values("Motherboard", 16, true);
insert into Part(name, currentQuantity, isMandatory) values("Cooler", 10, true);
insert into Part(name, currentQuantity, isMandatory) values("Case", 21, true);

insert into Part(name, currentQuantity, isMandatory) values("Sound Card", 3, false);
insert into Part(name, currentQuantity, isMandatory) values("Memory", 18, true);
insert into Part(name, currentQuantity, isMandatory) values("Video card", 8, true);
insert into Part(name, currentQuantity, isMandatory) values("Motherboard", 16, true);
insert into Part(name, currentQuantity, isMandatory) values("Cooler", 10, true);
insert into Part(name, currentQuantity, isMandatory) values("Case", 21, true);

insert into Part(name, currentQuantity, isMandatory) values("Sound Card", 3, false);
insert into Part(name, currentQuantity, isMandatory) values("Memory", 18, true);
insert into Part(name, currentQuantity, isMandatory) values("Video card", 8, true);
insert into Part(name, currentQuantity, isMandatory) values("Motherboard", 16, true);
insert into Part(name, currentQuantity, isMandatory) values("Cooler", 10, true);
insert into Part(name, currentQuantity, isMandatory) values("Case", 21, true);

insert into Part(name, currentQuantity, isMandatory) values("Sound Card", 3, false);
insert into Part(name, currentQuantity, isMandatory) values("Memory", 18, true);
insert into Part(name, currentQuantity, isMandatory) values("Video card", 8, true);
insert into Part(name, currentQuantity, isMandatory) values("Motherboard", 16, true);
insert into Part(name, currentQuantity, isMandatory) values("Cooler", 10, true);
insert into Part(name, currentQuantity, isMandatory) values("Case", 21, true);