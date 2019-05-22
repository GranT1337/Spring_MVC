-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: restaurant
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `additional_ingredients`
--

DROP TABLE IF EXISTS `additional_ingredients`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `additional_ingredients` (
  `idadditional_ingredients` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  PRIMARY KEY (`idadditional_ingredients`),
  UNIQUE KEY `name_UNIQUE` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `additional_ingredients`
--

LOCK TABLES `additional_ingredients` WRITE;
/*!40000 ALTER TABLE `additional_ingredients` DISABLE KEYS */;
INSERT INTO `additional_ingredients` VALUES (1,'Взбитые сливки',25,0),(2,'Маршмеллоу',35,1),(3,'Мороженое',25,15),(4,'Клубничный сироп',25,100),(5,'Корица',25,19),(6,'Банановый сироп',25,12),(7,'Малиновый сироп',25,10),(8,'Ванильный сироп',25,21);
/*!40000 ALTER TABLE `additional_ingredients` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `category` (
  `idcategory` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`idcategory`),
  UNIQUE KEY `categoryID_UNIQUE` (`idcategory`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Кофе'),(2,'Чай');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `composition`
--

DROP TABLE IF EXISTS `composition`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `composition` (
  `idDrink` int(11) NOT NULL,
  `idingredient` int(11) NOT NULL,
  `quantity` varchar(45) NOT NULL,
  KEY `d_idx` (`idDrink`),
  KEY `idIngr_idx` (`idingredient`),
  CONSTRAINT `idDrink` FOREIGN KEY (`idDrink`) REFERENCES `menu` (`idmenu`),
  CONSTRAINT `idIngr` FOREIGN KEY (`idingredient`) REFERENCES `warehouse` (`idIngredient`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `composition`
--

LOCK TABLES `composition` WRITE;
/*!40000 ALTER TABLE `composition` DISABLE KEYS */;
INSERT INTO `composition` VALUES (1,1,'7'),(1,2,'28'),(2,1,'7'),(2,2,'180'),(3,1,'7'),(3,2,'30'),(3,3,'100'),(4,1,'7'),(4,2,'30'),(4,3,'150'),(5,1,'7'),(5,2,'30'),(5,3,'100'),(5,4,'25'),(5,5,'20'),(6,1,'7'),(6,2,'28'),(6,3,'160'),(7,7,'10'),(7,2,'300'),(8,6,'10'),(8,2,'300'),(9,9,'10'),(9,2,'300');
/*!40000 ALTER TABLE `composition` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `menu` (
  `idmenu` int(11) NOT NULL,
  `title` varchar(45) NOT NULL,
  `price` int(11) NOT NULL,
  `weight` varchar(45) NOT NULL,
  `photo_link` varchar(45) NOT NULL,
  `idcategory` int(11) NOT NULL,
  PRIMARY KEY (`idmenu`),
  UNIQUE KEY `idmenu_UNIQUE` (`idmenu`),
  KEY `idCategory_menu_idx` (`idcategory`),
  CONSTRAINT `idCategory_menu` FOREIGN KEY (`idcategory`) REFERENCES `category` (`idcategory`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Эспрессо',80,'30','../images/espresso.jpg',1),(2,'Американо',80,'200','../images/americano.jpg',1),(3,'Капучино',109,'200','../images/capuchino.jpg',1),(4,'Латте',109,'200','../images/latte.jpg',1),(5,'Мокко',149,'200','../images/mok.jpg',1),(6,'Флет Уайт',109,'200','../images/fletwhite.jpg',1),(7,'Чай с вишней',100,'300','../images/tea-cherry.jpg',2),(8,'Чай черный',80,'300','../images/classicBlackTea.jpg',2),(9,'Чай зеленый',80,'300','../images/greenTea.png',2);
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `iduser` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `role` enum('ADMIN','CLIENT') NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `balance` int(11) NOT NULL,
  PRIMARY KEY (`iduser`),
  UNIQUE KEY `iduser_UNIQUE` (`iduser`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Кирилл','Останин','ADMIN','grant1425@rambler.ru','12345678',3882),(2,'Богатый','Человек','CLIENT','money@money.ru','12345',1000),(3,'Бедный','Человек','CLIENT','notmoney@notbitcoin.com','qwerty',85);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `warehouse` (
  `idIngredient` int(11) NOT NULL AUTO_INCREMENT,
  `ingredient` varchar(45) NOT NULL,
  `unit` varchar(45) NOT NULL,
  `quantityOstatok` int(11) NOT NULL,
  PRIMARY KEY (`idIngredient`),
  UNIQUE KEY `ingredient_UNIQUE` (`ingredient`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (1,'Молотый кофе','грамм',86),(2,'Вода','миллилитров',3944),(3,'Молоко','миллилитров',3000),(4,'Шоколад','грамм',275),(5,'Сливки','миллилитров',380),(6,'Чай черный','грамм',180),(7,'Чай вишневый','грамм',100),(8,'Сахар','штук',98),(9,'Чай зеленый','грамм',190);
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-03-09 13:42:14
