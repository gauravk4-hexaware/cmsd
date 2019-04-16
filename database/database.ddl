-- creating Database
create database if not exists FTP112;

-- using the Database
use FTP112;

-- Creating Menu table 
CREATE TABLE `menu` (
  `MEN_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `MEN_ITEM` varchar(50) DEFAULT NULL,
  `MEN_CALORIES` double NOT NULL,
  `MEN_SPECIALITY` varchar(50) NOT NULL,
  PRIMARY KEY (`MEN_ID`)
);


-- Creating Customer table
 CREATE TABLE `customer` (
  `CUS_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `CUS_NAME` varchar(50) NOT NULL,
  `CUS_PHN_NO` varchar(50) NOT NULL,
  `CUS_USERNAME` varchar(50) NOT NULL,
  `CUS_PASSWORD` varchar(50) NOT NULL,
  `CUS_EMAIL` varchar(50) NOT NULL,
  PRIMARY KEY (`CUS_ID`),
  UNIQUE KEY `CUS_PHN_NO` (`CUS_PHN_NO`),
  UNIQUE KEY `CUS_USERNAME` (`CUS_USERNAME`)
);


-- Creating Wallet table
 CREATE TABLE `wallet` (
  `CUS_ID` int(10) unsigned DEFAULT NULL,
  `WAL_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `WAL_AMOUNT` double unsigned NOT NULL,
  `WAL_SOURCE` enum('PAYTM','CREDIT_CARD','DEBIT_CARD') DEFAULT 'DEBIT_CARD',
  UNIQUE KEY `WAL_ID` (`WAL_ID`),
  UNIQUE KEY `WAL_SRC_CK` (`CUS_ID`,`WAL_SOURCE`),
  CONSTRAINT `WALLET_FK` FOREIGN KEY (`CUS_ID`) REFERENCES `customer` (`CUS_ID`)
);


-- creating vendor table
 CREATE TABLE `vendor` (
  `VEN_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `VEN_NAME` varchar(50) NOT NULL,
  `VEN_PHN_NO` varchar(40) NOT NULL,
  `VEN_USERNAME` varchar(40) NOT NULL,
  `VEN_PASSWORD` varchar(30) NOT NULL,
  `VEN_EMAIL` varchar(50) NOT NULL,
  `VEN_BALANCE` double DEFAULT NULL,
  PRIMARY KEY (`VEN_ID`)
) ;


-- Creating orders table
CREATE TABLE `orders` (
  `ORD_ID` int(10) NOT NULL AUTO_INCREMENT,
  `CUS_ID` int(10) unsigned NOT NULL,
  `VEN_ID` int(10) unsigned NOT NULL,
  `ORD_DATE` datetime DEFAULT CURRENT_TIMESTAMP,
  `TOTAL_ORD_PRICE` double unsigned DEFAULT NULL,
  `ORD_STATUS` enum('ACCEPTED','DENIED','PENDING','PARTIAL ACCEPTANCE') DEFAULT 'PENDING',
  `ORD_COMMENTS` varchar(50) DEFAULT NULL,
  `WAL_ID` int(10) unsigned NOT NULL,
  PRIMARY KEY (`ORD_ID`),
  KEY `cus_fk` (`CUS_ID`),
  KEY `ven_id_fk` (`VEN_ID`),
  KEY `wal_id_fk` (`WAL_ID`),
  CONSTRAINT `cus_fk` FOREIGN KEY (`CUS_ID`) REFERENCES `customer` (`CUS_ID`),
  CONSTRAINT `ven_id_fk` FOREIGN KEY (`VEN_ID`) REFERENCES `vendor` (`VEN_ID`),
  CONSTRAINT `wal_id_fk` FOREIGN KEY (`WAL_ID`) REFERENCES `wallet` (`WAL_ID`)
);


-- Creating junction table for menu_vendor
CREATE TABLE `junc_menu_vendor` (
`MEN_ID` int(10) unsigned NOT NULL,
`VEN_ID` int(10) unsigned NOT NULL,
`JUN_PRICE` double unsigned NOT NULL,
`JUN_RATING` int(11) DEFAULT '0',
`JUN_REVIEWS` varchar(50) DEFAULT NULL,
KEY `MENS_ID_FK` (`MEN_ID`),
KEY `VENS_ID_FK` (`VEN_ID`),
CONSTRAINT `MENS_ID_FK` FOREIGN KEY (`MEN_ID`) REFERENCES `menu` (`MEN_ID`),
CONSTRAINT `VENS_ID_FK` FOREIGN KEY (`VEN_ID`) REFERENCES `vendor` (`VEN_ID`)
);

-- Creating junction table for order_menu
 CREATE TABLE `order_items` (
  `ORD_ITEM_ID` int(10) NOT NULL AUTO_INCREMENT,
  `MEN_ID` int(10) unsigned NOT NULL,
  `MEN_PRICE` double unsigned NOT NULL,
  `ORD_STATUS` enum('ACCEPTED','DENIED','PENDING') DEFAULT 'PENDING',
  `ORD_QUANTITY` int(10) unsigned DEFAULT '1',
  `ORD_ID` int(10) NOT NULL,
  PRIMARY KEY (`ORD_ITEM_ID`),
  KEY `ven_fk` (`MEN_ID`),
  KEY `ord_id_fk` (`ORD_ID`),
  CONSTRAINT `ord_id_fk` FOREIGN KEY (`ORD_ID`) REFERENCES `orders` (`ORD_ID`),
  CONSTRAINT `ven_fk` FOREIGN KEY (`MEN_ID`) REFERENCES `menu` (`MEN_ID`)
);


