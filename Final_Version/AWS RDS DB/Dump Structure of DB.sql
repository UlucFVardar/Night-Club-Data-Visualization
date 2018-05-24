-- MySQL dump 10.13  Distrib 5.7.17, for macos10.12 (x86_64)
--
-- Host: nightclubproject.cdukbpxo4e76.us-east-2.rds.amazonaws.com    Database: innodb
-- ------------------------------------------------------
-- Server version	5.6.39-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Artist`
--

DROP TABLE IF EXISTS `Artist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Artist` (
  `artist_id` int(11) NOT NULL AUTO_INCREMENT,
  `artist_Name` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`artist_id`),
  UNIQUE KEY `artist_id_UNIQUE` (`artist_id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `DaysOfArtist`
--

DROP TABLE IF EXISTS `DaysOfArtist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `DaysOfArtist` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `artistType` varchar(40) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  `artist_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `EventNight_DaysOfArtist_idx` (`event_id`),
  KEY `a_DA_idx` (`artist_id`),
  CONSTRAINT `EventNight_DaysOfArtist` FOREIGN KEY (`event_id`) REFERENCES `EventNight` (`event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `a_DA` FOREIGN KEY (`artist_id`) REFERENCES `Artist` (`artist_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Discount`
--

DROP TABLE IF EXISTS `Discount`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Discount` (
  `discount_id` int(11) NOT NULL AUTO_INCREMENT,
  `bottleNumber` int(11) DEFAULT NULL,
  `discount` double DEFAULT NULL,
  `moneyFlow_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`discount_id`),
  UNIQUE KEY `discount_id_UNIQUE` (`discount_id`),
  KEY `D_MF_idx` (`moneyFlow_id`),
  CONSTRAINT `D_MF` FOREIGN KEY (`moneyFlow_id`) REFERENCES `MoneyFlow` (`moneyFlow_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `EventNight`
--

DROP TABLE IF EXISTS `EventNight`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `EventNight` (
  `event_id` int(11) NOT NULL AUTO_INCREMENT,
  `eventNightDate` varchar(30) DEFAULT NULL,
  `eventType` varchar(40) DEFAULT NULL,
  `eventNightComment` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`event_id`),
  UNIQUE KEY `event_id_UNIQUE` (`event_id`)
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `IndexesOfEvent`
--

DROP TABLE IF EXISTS `IndexesOfEvent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `IndexesOfEvent` (
  `index_id` int(11) NOT NULL AUTO_INCREMENT,
  `alcoholIndex` double DEFAULT NULL,
  `generalIndex` double DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`index_id`),
  UNIQUE KEY `index_id_UNIQUE` (`index_id`),
  KEY `Index_EventNight_idx` (`event_id`),
  CONSTRAINT `Index_EventNight` FOREIGN KEY (`event_id`) REFERENCES `EventNight` (`event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `MoneyFlow`
--

DROP TABLE IF EXISTS `MoneyFlow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `MoneyFlow` (
  `moneyFlow_id` int(11) NOT NULL AUTO_INCREMENT,
  `totalProfit` double DEFAULT NULL,
  `totalEndersement` double DEFAULT NULL,
  `tip` double DEFAULT NULL,
  `dontPay` double DEFAULT NULL,
  `totalCost` double DEFAULT NULL,
  `event_id` int(11) DEFAULT NULL,
  `grupEnterenceFree` double DEFAULT NULL,
  PRIMARY KEY (`moneyFlow_id`),
  UNIQUE KEY `moneyFlow_id_UNIQUE` (`moneyFlow_id`),
  KEY `EventNight_MoneyFlow_idx` (`event_id`),
  CONSTRAINT `EventNight_MoneyFlow` FOREIGN KEY (`event_id`) REFERENCES `EventNight` (`event_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Sales`
--

DROP TABLE IF EXISTS `Sales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Sales` (
  `sales_id` int(11) NOT NULL AUTO_INCREMENT,
  `nameOfSales` varchar(200) DEFAULT NULL,
  `sumOfProfit` varchar(200) DEFAULT NULL,
  `sumOfGiro` varchar(200) DEFAULT NULL,
  `numberOfSales` varchar(200) DEFAULT NULL,
  `moneyFlow_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`sales_id`),
  UNIQUE KEY `sales_id_UNIQUE` (`sales_id`),
  KEY `S_MF_idx` (`moneyFlow_id`),
  CONSTRAINT `S_MF` FOREIGN KEY (`moneyFlow_id`) REFERENCES `MoneyFlow` (`moneyFlow_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `Treat`
--

DROP TABLE IF EXISTS `Treat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Treat` (
  `tread_id` int(11) NOT NULL AUTO_INCREMENT,
  `cl70Number` int(11) DEFAULT NULL,
  `cl35Number` int(11) DEFAULT NULL,
  `confetyNumber` int(11) DEFAULT NULL,
  `moneyFlow_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`tread_id`),
  UNIQUE KEY `tread_id_UNIQUE` (`tread_id`),
  KEY `T_MF_idx` (`moneyFlow_id`),
  CONSTRAINT `T_MF` FOREIGN KEY (`moneyFlow_id`) REFERENCES `MoneyFlow` (`moneyFlow_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'innodb'
--
/*!50003 DROP PROCEDURE IF EXISTS `addEventNight` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`master`@`%` PROCEDURE `addEventNight`( artistNamee varchar(60)  , artistPrice DOUBLE , eventType varchar(40),
																	eventDate varchar(30) , eventComment varchar(1000), totalProfit double, 
																	totalEndersement double, tip double, dontpay double, totalCost double, 
                                                                    nameOfSales varchar(200), sumOfProfit varchar(200), sumOfGiro varchar(200),
                                                                    salesNumber varchar(200), cl70Number int ,cl35Number int, confetyNumber int ,
                                                                    bottleNumber int ,totalDiscount double, alcoholIndex double, generalIndex double, grupEnterenceFree double)
BEGIN

#eventNight insert edildi
INSERT INTO EventNight(  eventNightDate, eventType, eventNightComment )
Values(  eventDate, eventType, eventComment  ) ;

(SELECT @eventID:=event_id FROM EventNight AS e WHERE e.eventNightDate = eventDate limit 1 );

#Index ler insert edildi
INSERT INTO IndexesOfEvent (alcoholIndex,generalIndex,event_id    )
VALUES ( alcoholIndex,generalIndex, @eventID );

#Artist eklendi
IF (  (SELECT @artistID := artist_id from Artist as a where a.artist_Name= artistNamee)!= 0 ) then 
	SELECT @artistID := artist_id from Artist as a where a.artist_Name=artistNamee limit 1 ;
ELSE 
	INSERT INTO Artist (artist_Name) Values(  artistNamee );
END IF;


(SELECT @artistID := artist_id from Artist as a where a.artist_Name=artistNamee limit 1 );

#DaysOfArtist
INSERT INTO  DaysOfArtist( artistType, price, event_id, artist_id  )
VALUES ( eventType, artistPrice,@eventID, @artistID);

#moneyFlow
INSERT INTO MoneyFlow ( totalProfit, totalEndersement, tip, dontPay, totalCost, grupEnterenceFree , event_id)
VALUES ( totalProfit , totalEndersement , tip ,dontpay ,totalCost ,grupEnterenceFree , @eventID);

(SELECT @MF_id:=moneyFlow_id FROM MoneyFlow AS m WHERE m.event_id = @eventID);

#Sales
INSERT INTO  Sales( nameOfSales,sumOfProfit , sumOfGiro, numberOfSales, moneyFlow_id )
VALUES ( nameOfSales, sumOfProfit, sumOfGiro, salesNumber, @MF_id) ; 

# Treat
Insert into Treat (	cl70Number, cl35Number, confetyNumber, moneyFlow_id )
values ( 	cl70Number, cl35Number, confetyNumber, @MF_id) ; 

#Discount 
insert into Discount ( bottleNumber,discount ,moneyFlow_id )
values ( bottleNumber, totalDiscount,  @MF_id) ; 

END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `giveDate` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`master`@`%` PROCEDURE `giveDate`(nigthDate nvarchar(60) )
BEGIN
select en.eventNightDate,en.eventType,en.eventNightComment,totalProfit,totalEndersement,tip,dontPay,grupEnterenceFree,nameOfSales,sumOfProfit,sumOfGiro,numberOfSales,cl70Number,cl35Number,confetyNumber,discount,bottleNumber,alcoholIndex,generalIndex,artist_Name,price as artist_Cost
from EventNight en inner join MoneyFlow mf on en.event_id=mf.event_id
inner join Sales s on s.moneyFlow_id=mf.moneyFlow_id 
inner join Treat t on t.moneyFlow_id=mf.moneyFlow_id 
inner join Discount d on d.moneyFlow_id=mf.moneyFlow_id 
inner join IndexesOfEvent  i on en.event_id=i.event_id
inner join DaysOfArtist doa on en.event_id=doa.event_id
inner join Artist a on a.artist_id=doa.artist_id
where en.eventNightDate=nigthDate;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `giveLast10day` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`master`@`%` PROCEDURE `giveLast10day`()
BEGIN

select en.eventNightDate,en.eventType,en.eventNightComment,totalProfit,totalEndersement,tip,dontPay,grupEnterenceFree,nameOfSales,sumOfProfit,sumOfGiro,numberOfSales,cl70Number,cl35Number,confetyNumber,discount,bottleNumber,alcoholIndex,generalIndex,artist_Name,price as artist_Cost
from EventNight en inner join MoneyFlow mf on en.event_id=mf.event_id
inner join Sales s on s.moneyFlow_id=mf.moneyFlow_id 
inner join Treat t on t.moneyFlow_id=mf.moneyFlow_id 
inner join Discount d on d.moneyFlow_id=mf.moneyFlow_id 
inner join IndexesOfEvent  i on en.event_id=i.event_id
inner join DaysOfArtist doa on en.event_id=doa.event_id
inner join Artist a on a.artist_id=doa.artist_id
order by eventNightDate  DESC
limit 10;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `listAll` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`master`@`%` PROCEDURE `listAll`()
BEGIN

select en.eventNightDate,en.eventType,en.eventNightComment,totalProfit,totalEndersement,tip,dontPay,grupEnterenceFree,nameOfSales,sumOfProfit,sumOfGiro,numberOfSales,cl70Number,cl35Number,confetyNumber,discount,bottleNumber,alcoholIndex,generalIndex,artist_Name,price as artist_Cost
from EventNight en inner join MoneyFlow mf on en.event_id=mf.event_id
inner join Sales s on s.moneyFlow_id=mf.moneyFlow_id 
inner join Treat t on t.moneyFlow_id=mf.moneyFlow_id 
inner join Discount d on d.moneyFlow_id=mf.moneyFlow_id 
inner join IndexesOfEvent  i on en.event_id=i.event_id
inner join DaysOfArtist doa on en.event_id=doa.event_id
inner join Artist a on a.artist_id=doa.artist_id;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `updateComment` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`master`@`%` PROCEDURE `updateComment`(eventDate varchar(60),commentOfNight varchar(1000))
BEGIN
#Artist eklendi
IF (  (SELECT @eventID:=event_id FROM EventNight as e WHERE e.eventNightDate = eventDate limit 1 )!= 0 ) then 
	(SELECT @eventID:=event_id FROM EventNight as e WHERE e.eventNightDate = eventDate limit 1 );
	UPDATE EventNight
	SET eventNightComment = commentOfNight   
	WHERE event_id= @eventID;
    
ELSE 	
 (SELECT @eventID:=event_id FROM EventNight as e WHERE e.eventNightDate = eventDate limit 1 );	
END IF;


END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-05-24  2:32:15
