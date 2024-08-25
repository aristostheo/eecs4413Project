-- MySQL dump 10.13  Distrib 8.0.39, for macos14 (x86_64)
--
-- Host: localhost    Database: eStore
-- ------------------------------------------------------
-- Server version	8.0.39

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Addresses`
--

DROP TABLE IF EXISTS `Addresses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Addresses` (
  `AddressID` int NOT NULL AUTO_INCREMENT,
  `CustomerID` int DEFAULT NULL,
  `AddressLine1` varchar(255) NOT NULL,
  `AddressLine2` varchar(255) DEFAULT NULL,
  `City` varchar(100) NOT NULL,
  `State` varchar(100) DEFAULT NULL,
  `ZipCode` varchar(10) NOT NULL,
  `Country` varchar(100) NOT NULL,
  PRIMARY KEY (`AddressID`),
  KEY `CustomerID` (`CustomerID`),
  CONSTRAINT `addresses_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `Customers` (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Addresses`
--

LOCK TABLES `Addresses` WRITE;
/*!40000 ALTER TABLE `Addresses` DISABLE KEYS */;
INSERT INTO `Addresses` VALUES (1,1,'123 Main St',NULL,'New York','NY','10001','USA'),(2,2,'456 Oak St','Apt 5B','Los Angeles','CA','90001','USA'),(3,4,'43 Yonge St',NULL,'Toronto','Ontario','M4J 7H8','Canada');
/*!40000 ALTER TABLE `Addresses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Categories`
--

DROP TABLE IF EXISTS `Categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Categories` (
  `CategoryID` int NOT NULL AUTO_INCREMENT,
  `CategoryName` varchar(255) NOT NULL,
  `Description` text,
  PRIMARY KEY (`CategoryID`),
  UNIQUE KEY `CategoryName` (`CategoryName`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Categories`
--

LOCK TABLES `Categories` WRITE;
/*!40000 ALTER TABLE `Categories` DISABLE KEYS */;
INSERT INTO `Categories` VALUES (1,'Smartphones','Mobile devices with advanced features'),(2,'Laptops','Portable computers for work, gaming, and entertainment'),(3,'Tablets','Touchscreen devices that are larger than smartphones but smaller than laptops'),(4,'Smartwatches','Wearable devices that offer a variety of smart features, including fitness tracking and notifications'),(5,'Accessories','Various electronic accessories like chargers, cases, and cables');
/*!40000 ALTER TABLE `Categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Customers`
--

DROP TABLE IF EXISTS `Customers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Customers` (
  `CustomerID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) DEFAULT NULL,
  `Phone` varchar(20) DEFAULT NULL,
  `AddressID` int DEFAULT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `Email` (`Email`),
  KEY `fk_address` (`AddressID`),
  CONSTRAINT `fk_address` FOREIGN KEY (`AddressID`) REFERENCES `Addresses` (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Customers`
--

LOCK TABLES `Customers` WRITE;
/*!40000 ALTER TABLE `Customers` DISABLE KEYS */;
INSERT INTO `Customers` VALUES (1,'John','Doe','john.doe@example.com','password123','1234567890',1),(2,'Jane','Smith','jane.smith@example.com',NULL,'0987654321',2),(3,'Aristos','Theo','aristos@my.yorku.ca','ef797c8118f02dfb649607dd5d3f8c7623048c9c063d532cc95c5ed7a898a64f','6789012345',2),(4,'Tom','Testing','tom@gmail.com','27cc6994fc1c01ce6659c6bddca9b69c4c6a9418065e612c69d110b3f7b11f8a','4167678888',3);
/*!40000 ALTER TABLE `Customers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PaymentMethods`
--

DROP TABLE IF EXISTS `PaymentMethods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PaymentMethods` (
  `PaymentMethodID` int NOT NULL AUTO_INCREMENT,
  `PaymentMethodName` varchar(255) NOT NULL,
  PRIMARY KEY (`PaymentMethodID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PaymentMethods`
--

LOCK TABLES `PaymentMethods` WRITE;
/*!40000 ALTER TABLE `PaymentMethods` DISABLE KEYS */;
INSERT INTO `PaymentMethods` VALUES (1,'Credit Card'),(2,'PayPal'),(3,'Bank Transfer'),(4,'Apple Pay'),(5,'Installment Payments'),(6,'Google Pay');
/*!40000 ALTER TABLE `PaymentMethods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payments`
--

DROP TABLE IF EXISTS `Payments`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Payments` (
  `PaymentID` int NOT NULL AUTO_INCREMENT,
  `POID` int DEFAULT NULL,
  `PaymentMethodID` int DEFAULT NULL,
  `PaymentDate` date NOT NULL,
  `AmountPaid` decimal(10,2) NOT NULL,
  `PaymentStatus` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`PaymentID`),
  KEY `POID` (`POID`),
  KEY `PaymentMethodID` (`PaymentMethodID`),
  CONSTRAINT `payments_ibfk_1` FOREIGN KEY (`POID`) REFERENCES `PurchaseOrders` (`POID`),
  CONSTRAINT `payments_ibfk_2` FOREIGN KEY (`PaymentMethodID`) REFERENCES `PaymentMethods` (`PaymentMethodID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payments`
--

LOCK TABLES `Payments` WRITE;
/*!40000 ALTER TABLE `Payments` DISABLE KEYS */;
INSERT INTO `Payments` VALUES (1,1,1,'2024-08-12',2150.00,'Completed'),(2,2,2,'2024-08-13',849.99,'Completed');
/*!40000 ALTER TABLE `Payments` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ProductReviews`
--

DROP TABLE IF EXISTS `ProductReviews`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ProductReviews` (
  `ReviewID` int NOT NULL AUTO_INCREMENT,
  `ProductID` int DEFAULT NULL,
  `CustomerID` int DEFAULT NULL,
  `Rating` int DEFAULT NULL,
  `ReviewText` text,
  `ReviewDate` date NOT NULL,
  PRIMARY KEY (`ReviewID`),
  KEY `ProductID` (`ProductID`),
  KEY `CustomerID` (`CustomerID`),
  CONSTRAINT `productreviews_ibfk_1` FOREIGN KEY (`ProductID`) REFERENCES `Products` (`ProductID`),
  CONSTRAINT `productreviews_ibfk_2` FOREIGN KEY (`CustomerID`) REFERENCES `Customers` (`CustomerID`),
  CONSTRAINT `productreviews_chk_1` CHECK ((`Rating` between 1 and 5))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ProductReviews`
--

LOCK TABLES `ProductReviews` WRITE;
/*!40000 ALTER TABLE `ProductReviews` DISABLE KEYS */;
/*!40000 ALTER TABLE `ProductReviews` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `ProductID` int NOT NULL AUTO_INCREMENT,
  `BrandName` varchar(255) NOT NULL,
  `ProductName` varchar(255) NOT NULL,
  `CategoryID` int DEFAULT NULL,
  `Price` decimal(10,2) NOT NULL,
  `StockQuantity` int NOT NULL,
  `Description` text,
  `ImageURL` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ProductID`),
  UNIQUE KEY `UC_BrandProduct` (`BrandName`,`ProductName`),
  KEY `CategoryID` (`CategoryID`),
  CONSTRAINT `products_ibfk_1` FOREIGN KEY (`CategoryID`) REFERENCES `Categories` (`CategoryID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;
--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,'Apple','iPhone 14',1,999.99,50,'Latest iPhone model','https://t.ly/TZrcE'),(2,'Apple','MacBook Air M2',2,1199.99,30,'Apple MacBook Air with M2 chip, 13-inch','https://t.ly/zQQ9r'),(3,'Samsung','Galaxy Tab S8',3,849.99,35,'Samsung Galaxy Tab S8 with 11-inch display, 128GB storage','http://example.com/galaxytabs8.jpg'),(4,'Google','Pixel 7',1,699.99,40,'Google Pixel 7 with advanced AI features','http://example.com/pixel7.jpg'),(5,'Dell','XPS 13',2,999.99,25,'Dell XPS 13 with Intel i7, 16GB RAM, 512GB SSD','http://example.com/dellxps13.jpg'),(6,'Apple','iPad Air',3,599.99,50,'Apple iPad Air with A14 chip, 10.9-inch','http://example.com/ipadair.jpg'),(7,'Sony','WH-1000XM4',5,349.99,100,'Sony WH-1000XM4 noise-canceling headphones','http://example.com/sonywh1000xm4.jpg'),(8,'Microsoft','Surface Pro 8',3,1099.99,30,'Microsoft Surface Pro 8 with 13-inch display and detachable keyboard','http://example.com/surfacepro8.jpg'),(9,'Samsung','Galaxy Watch 5',4,299.99,40,'Samsung Galaxy Watch 5 with GPS, 44mm case','http://example.com/galaxywatch5.jpg'),(10,'Anker','PowerCore 10000',5,29.99,200,'Anker PowerCore 10000mAh Portable Charger','http://example.com/ankerpowercore.jpg'),(11,'Logitech','MX Master 3',5,99.99,150,'Logitech MX Master 3 Wireless Mouse','http://example.com/logitechmxmaster3.jpg'),(12,'Apple','Watch Series 8',4,399.99,50,'Apple Watch Series 8 with GPS, 45mm case','http://example.com/applewatch8.jpg'),(13,'Samsung','Galaxy Buds Pro',5,199.99,80,'Samsung Galaxy Buds Pro with active noise cancellation','http://example.com/galaxybudspro.jpg');
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PurchaseOrderDetails`
--

DROP TABLE IF EXISTS `PurchaseOrderDetails`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PurchaseOrderDetails` (
  `PODetailID` int NOT NULL AUTO_INCREMENT,
  `POID` int DEFAULT NULL,
  `ProductID` int DEFAULT NULL,
  `Quantity` int NOT NULL,
  `UnitPrice` decimal(10,2) NOT NULL,
  PRIMARY KEY (`PODetailID`),
  KEY `POID` (`POID`),
  KEY `ProductID` (`ProductID`),
  CONSTRAINT `purchaseorderdetails_ibfk_1` FOREIGN KEY (`POID`) REFERENCES `PurchaseOrders` (`POID`),
  CONSTRAINT `purchaseorderdetails_ibfk_2` FOREIGN KEY (`ProductID`) REFERENCES `Products` (`ProductID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PurchaseOrderDetails`
--

LOCK TABLES `PurchaseOrderDetails` WRITE;
/*!40000 ALTER TABLE `PurchaseOrderDetails` DISABLE KEYS */;
INSERT INTO `PurchaseOrderDetails` VALUES (1, 1, 2, 1, 1199.99), (2, 2, 5, 1, 999.99), (3, 3, 4, 1, 699.99);

/*!40000 ALTER TABLE `PurchaseOrderDetails` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PurchaseOrders`
--

DROP TABLE IF EXISTS `PurchaseOrders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `PurchaseOrders` (
  `POID` int NOT NULL AUTO_INCREMENT,
  `CustomerID` int DEFAULT NULL,
  `ShippingAddressID` int DEFAULT NULL,
  `OrderDate` date NOT NULL,
  `TotalAmount` decimal(10,2) NOT NULL,
  `Status` varchar(50) DEFAULT 'Pending',
  `ExpectedDeliveryDate` date DEFAULT NULL,
  PRIMARY KEY (`POID`),
  KEY `CustomerID` (`CustomerID`),
  KEY `ShippingAddressID` (`ShippingAddressID`),
  CONSTRAINT `purchaseorders_ibfk_1` FOREIGN KEY (`CustomerID`) REFERENCES `Customers` (`CustomerID`),
  CONSTRAINT `purchaseorders_ibfk_2` FOREIGN KEY (`ShippingAddressID`) REFERENCES `Addresses` (`AddressID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PurchaseOrders`
--

LOCK TABLES `PurchaseOrders` WRITE;
/*!40000 ALTER TABLE `PurchaseOrders` DISABLE KEYS */;
INSERT INTO `PurchaseOrders` VALUES (1,1,1,'2024-08-12',1199.99,'Pending','2024-08-19'),(2,2,2,'2024-08-13',999.99,'Pending','2024-08-20'), (3, 1, 1, '2024-08-15', 699.99, 'Pending', '2024-09-01');
/*!40000 ALTER TABLE `PurchaseOrders` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

--
-- Table structure for table `Cart`
--

DROP TABLE IF EXISTS `Cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Cart` (
  `CartID` int NOT NULL AUTO_INCREMENT,
  `CustomerID` int NOT NULL,
  PRIMARY KEY (`CartID`),
  KEY `CustomerID` (`CustomerID`),
  CONSTRAINT `cart_fk_customer` FOREIGN KEY (`CustomerID`) REFERENCES `Customers` (`CustomerID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Cart`
--

LOCK TABLES `Cart` WRITE;
/*!40000 ALTER TABLE `Cart` DISABLE KEYS */;
INSERT INTO `Cart` (`CustomerID`) VALUES (1), (2), (3), (4);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `CartItem`
--

DROP TABLE IF EXISTS `CartItem`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `CartItem` (
  `CartItemID` int NOT NULL AUTO_INCREMENT,
  `CartID` int NOT NULL,
  `ProductID` int NOT NULL,
  `Quantity` int NOT NULL,
  PRIMARY KEY (`CartItemID`),
  KEY `CartID` (`CartID`),
  KEY `ProductID` (`ProductID`),
  CONSTRAINT `cartitem_fk_cart` FOREIGN KEY (`CartID`) REFERENCES `Cart` (`CartID`),
  CONSTRAINT `cartitem_fk_product` FOREIGN KEY (`ProductID`) REFERENCES `Products` (`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `CartItem`
--

LOCK TABLES `CartItem` WRITE;
/*!40000 ALTER TABLE `CartItem` DISABLE KEYS */;
INSERT INTO `CartItem` (`CartID`, `ProductID`, `Quantity`) VALUES
(1, 1, 2),
(1, 2, 1),
(2, 3, 5);
/*!40000 ALTER TABLE `CartItem` ENABLE KEYS */;
UNLOCK TABLES;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

--
-- ADMIN TABLE --
--

DROP TABLE IF EXISTS `Admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `Admin` (
  `AdminID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(255) NOT NULL,
  `LastName` varchar(255) NOT NULL,
  `Email` varchar(255) NOT NULL,
  `Password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`CustomerID`),
  UNIQUE KEY `Email` (`Email`)
  ) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admin`
--

LOCK TABLES `Admin` WRITE;
/*!40000 ALTER TABLE `Admin` DISABLE KEYS */;
INSERT INTO `Admin` VALUES 
(1,'Benjamin','Pierce','p.benji@gmail.com','40bluebird77'),
(2,'Becky','Gardens','Becky.Gardens@icloud.com', 'daisy222'),
(3,'Chadwick','Greeley','baseplayer11@gmail.com', 'password999'),
(4,'Simon','Bowmen','b.simon@google.com', 'ratOfSin');
/*!40000 ALTER TABLE `Admin` ENABLE KEYS */;
UNLOCK TABLES;

-- Dump completed on 2024-08-23 19:55:03
