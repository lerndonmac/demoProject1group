-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: autoservice
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `attachedproduct`
--

DROP TABLE IF EXISTS `attachedproduct`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attachedproduct` (
  `MainProductID` int NOT NULL,
  `AttachedProductID` int NOT NULL,
  PRIMARY KEY (`MainProductID`,`AttachedProductID`),
  KEY `FK_AttachedProduct_Product1` (`AttachedProductID`),
  CONSTRAINT `FK_AttachedProduct_Product` FOREIGN KEY (`MainProductID`) REFERENCES `product` (`ID`),
  CONSTRAINT `FK_AttachedProduct_Product1` FOREIGN KEY (`AttachedProductID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attachedproduct`
--

LOCK TABLES `attachedproduct` WRITE;
/*!40000 ALTER TABLE `attachedproduct` DISABLE KEYS */;
/*!40000 ALTER TABLE `attachedproduct` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `FirstName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LastName` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Patronymic` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `RegistrationDate` datetime(6) NOT NULL,
  `Email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `Phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `GenderCode` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `PhotoPath` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `countOfEntering` int NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Client_Gender` (`GenderCode`),
  CONSTRAINT `FK_Client_Gender` FOREIGN KEY (`GenderCode`) REFERENCES `gender` (`Code`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (3,'Глеб','Селиверстов','Максимович','1999-06-20','2016-01-07 00:00:00.000000','jigsaw@sbcglobal.net','7(20)554-28-68 ','м','Клиенты\\m37.jpg',0),(4,'Юстиниан','Агафонов','Олегович','1997-02-02','2016-06-08 00:00:00.000000','staffelb@sbcglobal.net','7(303)810-28-78 ','м','Клиенты\\m1.jpg',0),(5,'Злата','Колобова','Романовна','1994-08-25','2016-12-03 00:00:00.000000','sinkou@aol.com','7(50)884-07-35 ','ж','Клиенты\\18.jpg',0),(6,'Дарина','Сысоева','Ярославовна','1982-02-03','2016-05-13 00:00:00.000000','treit@verizon.net','7(0698)387-96-04 ','ж','Клиенты\\32.jpg',0),(8,'Наум','Крюков','Ильяович','1993-11-17','2017-02-01 00:00:00.000000','floxy@hotmail.com','7(81)657-88-92 ','м','Клиенты\\m30.jpg',0),(9,'Татьяна','Сидорова','Михайловна','1974-04-24','2018-10-03 00:00:00.000000','tbeck@mac.com','7(51)732-91-79 ','ж','Клиенты\\42.jpg',0),(10,'Альжбета','Трофимова','Якововна','1988-10-22','2017-09-21 00:00:00.000000','gbacon@mac.com','7(1084)658-92-95 ','ж','Клиенты\\25.jpg',0),(11,'Адриан','Новиков','Аркадьевич','1974-01-15','2018-11-23 00:00:00.000000','multiplx@verizon.net','7(70)572-33-62 ','м','Клиенты\\m40.jpg',0),(12,'Иветта','Мишина','Андреевна','2002-10-05','2016-01-24 00:00:00.000000','aukjan@yahoo.com','7(3926)244-81-96 ','ж','Клиенты\\30.jpg',0),(13,'Геннадий','Шестаков','Рубенович','2001-07-01','2018-12-08 00:00:00.000000','tokuhirom@live.com','7(2066)037-11-60 ','м','Клиенты\\m41.jpg',0),(14,'Матвей','Зуев','Иванович','1981-03-28','2018-12-18 00:00:00.000000','brickbat@verizon.net','7(5383)893-04-66 ','м','Клиенты\\m38.jpg',0),(15,'Георгина','Турова','Семёновна','1974-05-28','2018-02-22 00:00:00.000000','yruan@optonline.net','7(555)321-42-99 ','ж','Клиенты\\27.jpg',0),(16,'Валентин','Анисимов','Пантелеймонович','2000-12-10','2018-01-20 00:00:00.000000','aaribaud@hotmail.com','7(700)326-70-24 ','м','Клиенты\\m99.jpg',0),(17,'Тамара','Анисимова','Витальевна','1988-06-16','2016-02-25 00:00:00.000000','schwaang@mac.com','7(66)128-04-10 ','ж','Клиенты\\2.jpg',0),(18,'Орест','Колобов','Юлианович','2001-07-14','2017-01-01 00:00:00.000000','parkes@verizon.net','7(1680)508-58-26 ','м','Клиенты\\m27.jpg',0),(19,'Аристарх','Филатов','Дмитриевич','1989-05-29','2017-01-11 00:00:00.000000','hampton@att.net','7(696)235-29-24 ','м','Клиенты\\m43.jpg',0),(20,'Влада','Орлова','Мартыновна','1990-06-26','2016-03-21 00:00:00.000000','rnelson@yahoo.ca','7(2506)433-38-35 ','ж','Клиенты\\22.jpg',0),(21,'Элина','Алексеева','Матвеевна','2002-05-07','2018-03-28 00:00:00.000000','pthomsen@verizon.net','7(8086)245-64-81 ','ж','Клиенты\\1.jpg',0),(23,'Инара','Бирюкова','Улебовна','1978-07-21','2017-10-01 00:00:00.000000','smpeters@hotmail.com','7(098)346-50-58 ','ж','Клиенты\\5.jpg',0),(24,'Марк','Панфилов','Рудольфович','1991-04-13','2016-02-23 00:00:00.000000','cremonini@optonline.net','7(764)282-55-22 ','м','Клиенты\\m45.jpg',0),(26,'Наум','Морозов','Валерьянович','1985-07-04','2016-05-02 00:00:00.000000','salesgeek@mac.com','7(636)050-96-13 ','м','Клиенты\\m49.jpg',0),(27,'Давид','Горбачёв','Тимурович','1983-05-22','2018-12-17 00:00:00.000000','hedwig@att.net','7(53)602-85-41 ','м','Клиенты\\m36.jpg',0),(28,'Оскар','Васильев','Богданович','1971-01-30','2017-05-28 00:00:00.000000','miturria@verizon.net','7(585)801-94-29 ','м','Клиенты\\m15.jpg',0),(29,'Номи','Ершова','Андреевна','2001-09-13','2016-06-30 00:00:00.000000','miltchev@mac.com','7(7757)315-90-99 ','ж','Клиенты\\14.jpg',0),(30,'Святослав','Медведев','Юлианович','1972-10-04','2018-10-13 00:00:00.000000','hllam@comcast.net','7(3520)435-21-20 ','м','Клиенты\\m13.jpg',0),(31,'Эльмира','Баранова','Дмитриевна','1977-01-15','2016-07-08 00:00:00.000000','jgmyers@comcast.net','7(9240)643-15-50 ','ж','Клиенты\\4.jpg',0),(32,'Харита','Попова','Якуновна','1997-12-16','2016-07-05 00:00:00.000000','firstpr@verizon.net','7(335)386-81-06 ','ж','Клиенты\\36.jpg',0),(33,'Аверкий','Кудряшов','Константинович','1991-07-26','2018-03-08 00:00:00.000000','nanop@msn.com','7(88)732-96-30 ','м','Клиенты\\m33.jpg',0),(34,'Марта','Горшкова','Иосифовна','2001-02-13','2016-08-04 00:00:00.000000','gbacon@mac.com','7(544)650-59-03','ж','Клиенты\\9.jpg',0),(35,'Богдан','Кудрявцев','Христофорович','1988-02-27','2016-10-07 00:00:00.000000','lukka@hotmail.com','7(20)131-84-09 ','м','Клиенты\\m31.jpg',0),(36,'Яков','Гусев','Авксентьевич','1995-12-10','2017-11-20 00:00:00.000000','jdhedden@icloud.com','7(0972)781-11-37 ','м','Клиенты\\m20.jpg',0),(37,'Авигея','Крюкова','Святославовна','2000-08-10','2018-01-03 00:00:00.000000','simone@gmail.com','7(499)318-88-53 ','ж','Клиенты\\19.jpg',0),(38,'Амелия','Степанова','Робертовна','1970-06-06','2017-09-27 00:00:00.000000','rasca@hotmail.com','7(1217)441-28-42 ','ж','Клиенты\\15.jpg',0),(39,'Божена','Суворова','Анатольевна','1981-03-09','2016-01-28 00:00:00.000000','attwood@aol.com','7(347)895-86-57 ','ж','Клиенты\\34.jpg',0),(40,'Аввакум','Борисов','Артемович','1974-04-25','2017-03-11 00:00:00.000000','chlim@live.com','7(2296)930-08-88 ','м','Клиенты\\m12.jpg',0),(41,'Георгий','Бобылёв','Витальевич','1983-12-19','2018-04-06 00:00:00.000000','csilvers@mac.com','7(88)685-13-51 ','м','Клиенты\\m11.jpg',0),(42,'Вольдемар','Дроздов','Артемович','1976-02-07','2017-07-18 00:00:00.000000','smpeters@me.com','7(307)456-99-05 ','м','Клиенты\\m21.jpg',0),(43,'Сабрина','Беляева','Федосеевна','1972-07-26','2017-06-14 00:00:00.000000','agapow@gmail.com','7(6580)534-32-58 ','ж','Клиенты\\47.jpg',0),(44,'Пантелеймон','Блохин','Феликсович','1978-03-06','2018-02-14 00:00:00.000000','balchen@comcast.net','7(9524)556-48-98 ','м','Клиенты\\m8.jpg',0),(45,'Гелла','Шашкова','Эдуардовна','1979-02-24','2016-11-16 00:00:00.000000','jadavis@mac.com','7(57)446-21-04 ','ж','Клиенты\\43.jpg',0),(46,'Артур','Калашников','Юрьевич','1972-12-13','2017-08-20 00:00:00.000000','oevans@aol.com','7(147)947-47-21 ','м','Клиенты\\m10.jpg',0),(47,'Анэля','Корнилова','Михайловна','1973-04-02','2016-05-22 00:00:00.000000','jonathan@aol.com','7(20)980-01-60 ','ж','Клиенты\\26.jpg',0),(48,'Янита','Гущина','Федоровна','1999-03-02','2018-02-01 00:00:00.000000','lishoy@att.net','7(4544)716-68-96 ','ж','Клиенты\\11.jpg',0),(49,'Людвиг','Волков','Витальевич','1977-12-27','2016-04-27 00:00:00.000000','jrkorson@msn.com','7(8459)592-05-58 ','м','Клиенты\\m50.jpg',0),(50,'Терентий','Князев','Валерьевич','1991-06-19','2018-06-25 00:00:00.000000','rjones@aol.com','7(98)397-23-23 ','м','Клиенты\\m26.jpg',0),(51,'Гаянэ','Силин','Анатольевич','1976-05-27','2017-05-05 00:00:00.000000','multiplx@comcast.net','7(4547)615-22-69 ','м','Клиенты\\m46.jpg',0),(52,'Дмитрий','Казаков','Русланович','1978-12-15','2016-05-21 00:00:00.000000','ozawa@verizon.net','7(51)682-19-40 ','м','Клиенты\\m44.jpg',0),(53,'Роза','Гусева','Дмитриевна','1999-02-13','2017-12-12 00:00:00.000000','martyloo@live.com','7(23)064-51-84 ','ж','Клиенты\\10.jpg',0),(54,'Марфа','Мамонтова','Мироновна','1984-10-19','2018-02-27 00:00:00.000000','rfoley@verizon.net','7(38)095-64-18 ','ж','Клиенты\\29.jpg',0),(55,'Эрик','Галкин','Онисимович','1975-01-18','2016-07-19 00:00:00.000000','snunez@verizon.net','7(759)873-77-39 ','м','Клиенты\\m16.jpg',0),(56,'Прасковья','Архипова','Валерьевна','1979-01-09','2018-07-23 00:00:00.000000','cgcra@live.com','7(86)540-10-21 ','ж','Клиенты\\33.jpg',0),(57,'Лаура','Овчинникова','Еремеевна','1992-04-03','2018-11-24 00:00:00.000000','carcus@yahoo.ca','7(85)829-33-79 ','ж','Клиенты\\35.jpg',0),(58,'Патрисия','Андреева','Валерьевна','1993-11-18','2016-07-17 00:00:00.000000','jigsaw@aol.com','7(9648)953-81-26 ','ж','Клиенты\\37.jpg',0),(59,'Самуил','Авдеев','Улебович','1996-07-04','2016-02-11 00:00:00.000000','cliffordj@mac.com','7(3168)043-63-31 ','м','Клиенты\\m96.jpg',0),(60,'Светлана','Бурова','Лукьевна','1979-01-04','2016-10-13 00:00:00.000000','wsnyder@aol.com','7(358)173-82-21 ','ж','Клиенты\\39.jpg',0),(61,'Глеб','Ершов','Федорович','1970-06-14','2016-09-14 00:00:00.000000','sjava@aol.com','7(2608)298-40-82 ','м','Клиенты\\m23.jpg',0),(62,'Захар','Игнатов','Павлович','1998-10-07','2017-11-10 00:00:00.000000','dieman@icloud.com','7(578)574-73-36 ','м','Клиенты\\m98.jpg',0),(63,'Амалия','Комиссарова','Робертовна','1971-08-18','2017-08-04 00:00:00.000000','jorgb@msn.com','7(22)647-46-32 ','ж','Клиенты\\17.jpg',0),(64,'Трофим','Быков','Константинович','1994-12-20','2016-04-17 00:00:00.000000','jguyer@aol.com','7(3414)460-12-05 ','м','Клиенты\\m14.jpg',0),(65,'Леонтий','Кузьмин','Валерьянович','2000-05-05','2017-10-12 00:00:00.000000','msloan@hotmail.com','7(1340)148-90-68 ','м','Клиенты\\m17.jpg',0),(66,'Диана','Белозёрова','Антоновна','1989-02-27','2017-01-30 00:00:00.000000','dialworld@aol.com','7(9900)174-59-87 ','ж','Клиенты\\7.jpg',0),(67,'Евгений','Блинов','Мэлсович','1994-01-05','2017-05-07 00:00:00.000000','moxfulder@outlook.com','7(0852)321-82-64 ','м','Клиенты\\m7.jpg',0),(68,'Алексей','Лазарев','Богданович','1977-03-10','2017-01-02 00:00:00.000000','claesjac@me.com','7(0055)737-37-48 ','м','Клиенты\\m48.jpg',0),(69,'Розалия','Афанасьева','Макаровна','1977-05-01','2017-09-06 00:00:00.000000','malattia@hotmail.com','7(0661)413-23-32 ','ж','Клиенты\\31.jpg',0),(70,'Эдита','Дементьева','Онисимовна','1975-09-17','2018-11-24 00:00:00.000000','frosal@hotmail.com','7(198)922-28-76 ','ж','Клиенты\\38.jpg',0),(71,'Петр','Калинин','Иванович','1993-09-08','2016-05-26 00:00:00.000000','aschmitz@hotmail.com','7(90)316-07-17 ','м','Клиенты\\m47.jpg',0),(72,'Станислав','Андреев','Максович','1975-10-10','2017-12-26 00:00:00.000000','budinger@mac.com','7(02)993-91-28 ','м','Клиенты\\m3.jpg',0),(73,'Устин','Киселёв','Яковлевич','1985-01-08','2018-06-21 00:00:00.000000','dalamb@verizon.net','7(83)334-52-76 ','м','Клиенты\\m25.jpg',0),(74,'Павел','Гордеев','Семенович','1984-09-06','2016-07-19 00:00:00.000000','dawnsong@verizon.net','7(5243)599-66-72 ','м','Клиенты\\m19.jpg',0),(75,'Никки','Горбачёва','Еремеевна','1987-04-21','2018-08-16 00:00:00.000000','chinthaka@att.net','7(94)789-69-20 ','ж','Клиенты\\8.jpg',0),(76,'Касьян','Копылов','Робертович','1983-08-04','2018-03-18 00:00:00.000000','crobles@sbcglobal.net','7(5774)679-82-06 ','м','Клиенты\\m29.jpg',0),(77,'Витольд','Ефремов','Авксентьевич','1975-12-02','2018-04-09 00:00:00.000000','kwilliams@yahoo.ca','7(93)922-14-03 ','м','Клиенты\\m28.jpg',0),(78,'Михаил','Баранов','Романович','1997-07-12','2018-10-07 00:00:00.000000','bigmauler@outlook.com','7(750)985-94-13 ','м','Клиенты\\m5.jpg',0),(79,'Элина','Дмитриева','Даниловна','1988-12-10','2017-02-11 00:00:00.000000','vmalik@live.com','7(787)140-48-84 ','ж','Клиенты\\12.jpg',0),(80,'Осип','Федотов','Анатольевич','1971-04-13','2018-07-23 00:00:00.000000','breegster@hotmail.com','7(590)702-33-06 ','м','Клиенты\\m9.jpg',0),(81,'Тала','Быкова','Георгьевна','2000-02-22','2016-08-13 00:00:00.000000','ganter@optonline.net','7(13)915-53-53 ','ж','Клиенты\\6.jpg',0),(82,'Вадим','Дементьев','Ростиславович','1993-07-10','2018-03-05 00:00:00.000000','jacks@aol.com','7(79)330-46-15 ','м','Клиенты\\m39.jpg',0),(83,'Макар','Евсеев','Васильевич','1977-09-13','2018-12-05 00:00:00.000000','parsimony@sbcglobal.net','7(2141)077-85-70 ','м','Клиенты\\m22.jpg',0),(84,'Станислав','Абрамов','Филатович','1989-05-18','2016-12-08 00:00:00.000000','solomon@att.net','7(6545)478-87-79 ','м','Клиенты\\m32.jpg',0),(85,'Лиза','Артемьева','Максимовна','1996-05-17','2018-10-07 00:00:00.000000','snunez@yahoo.ca','7(696)972-70-21 ','ж','Клиенты\\3.jpg',0),(86,'Дэнна','Кузьмина','Витальевна','1993-08-24','2016-03-27 00:00:00.000000','nichoj@mac.com','7(9940)977-45-73 ','ж','Клиенты\\20.jpg',0),(87,'Магда','Ефимова','Платоновна','1995-08-16','2017-08-01 00:00:00.000000','rbarreira@me.com','7(9261)386-15-92 ','ж','Клиенты\\16.jpg',0),(88,'Альберт','Ефимов','Проклович','1997-10-29','2018-06-21 00:00:00.000000','houle@live.com','7(416)375-97-19 ','м','Клиенты\\m6.jpg',0),(89,'Эльвина','Лазарева','Робертовна','1996-02-16','2018-04-11 00:00:00.000000','ahuillet@comcast.net','7(5564)609-81-37 ','ж','Клиенты\\28.jpg',0),(90,'Изабелла','Воронова','Вячеславовна','1999-09-24','2017-12-21 00:00:00.000000','kildjean@sbcglobal.net','7(17)433-44-98 ','ж','Клиенты\\21.jpg',0),(91,'Эвелина','Куликова','Вячеславовна','1997-11-14','2018-02-01 00:00:00.000000','ilikered@hotmail.com','7(0236)682-42-78 ','ж','Клиенты\\23.jpg',0),(92,'Амалия','Егорова','Дамировна','1999-09-28','2016-06-30 00:00:00.000000','drezet@yahoo.com','7(7486)408-12-26 ','ж','Клиенты\\13.jpg',0),(93,'Станислав','Александров','Эдуардович','1981-07-04','2018-11-08 00:00:00.000000','bigmauler@aol.com','7(18)164-05-12 ','м','Клиенты\\m2.jpg',0),(94,'Демьян','Цветков','Львович','1996-03-29','2016-02-12 00:00:00.000000','hauma@icloud.com','7(93)546-43-73 ','м','Клиенты\\m4.jpg',0),(95,'Юнона','Устинова','Валентиновна','1982-08-08','2017-05-28 00:00:00.000000','kempsonc@live.com','7(33)367-13-07','ж','Клиенты\\44.jpg',0),(96,'Любава','Костина','Авксентьевна','1972-07-13','2016-02-26 00:00:00.000000','gordonjcp@hotmail.com','7(6419)959-21-87 ','ж','Клиенты\\41.jpg',0),(97,'Мартын','Смирнов','Арсеньевич','1996-06-25','2017-02-07 00:00:00.000000','haddawy@live.com','7(6251)589-02-43 ','м','Клиенты\\m34.jpg',0),(98,'Сандра','Федотова','Владленовна','1985-03-29','2016-11-08 00:00:00.000000','penna@verizon.net','7(126)195-25-86 ','ж','Клиенты\\24.jpg',0),(99,'Леонтий','Журавлёв','Яковлевич','2000-03-02','2018-01-15 00:00:00.000000','cmdrgravy@me.com','7(4403)308-56-96 ','м','Клиенты\\m24.jpg',0),(100,'Вадим','Большаков','Данилович','1970-05-15','2018-08-04 00:00:00.000000','uncle@gmail.com','7(386)641-13-37 ','м','Клиенты\\m97.jpg',0);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientservice`
--

DROP TABLE IF EXISTS `clientservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientservice` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ClientID` int NOT NULL,
  `ServiceID` int NOT NULL,
  `StartTime` datetime(6) NOT NULL,
  `Comment` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  PRIMARY KEY (`ID`),
  KEY `FK_ClientService_Client` (`ClientID`),
  KEY `FK_ClientService_Service` (`ServiceID`),
  CONSTRAINT `FK_ClientService_Client` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_ClientService_Service` FOREIGN KEY (`ServiceID`) REFERENCES `service` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientservice`
--

LOCK TABLES `clientservice` WRITE;
/*!40000 ALTER TABLE `clientservice` DISABLE KEYS */;
INSERT INTO `clientservice` VALUES (1,57,44,'2019-06-10 16:40:00.000000',NULL),(2,17,14,'2019-02-16 09:40:00.000000',NULL),(3,75,49,'2019-06-21 14:50:00.000000',NULL),(4,62,8,'2019-10-14 12:00:00.000000',NULL),(5,46,17,'2019-04-22 11:30:00.000000',NULL),(6,87,22,'2019-06-22 13:00:00.000000',NULL),(7,20,48,'2019-04-21 12:40:00.000000',NULL),(8,43,27,'2019-10-05 18:30:00.000000',NULL),(9,49,45,'2019-12-05 18:10:00.000000',NULL),(10,32,45,'2019-09-17 11:30:00.000000',NULL),(11,30,2,'2019-07-07 09:30:00.000000',NULL),(12,32,48,'2019-05-28 11:10:00.000000',NULL),(13,65,21,'2019-05-01 10:20:00.000000',NULL),(14,65,13,'2019-04-15 13:30:00.000000',NULL),(15,11,43,'2019-10-16 18:20:00.000000',NULL),(16,34,8,'2019-07-09 18:50:00.000000',NULL),(17,23,27,'2019-03-23 16:40:00.000000',NULL),(18,33,4,'2019-05-23 11:40:00.000000',NULL),(19,39,23,'2019-07-30 12:10:00.000000',NULL),(20,86,3,'2019-08-24 11:20:00.000000',NULL),(21,76,18,'2019-12-23 15:30:00.000000',NULL),(22,30,18,'2019-08-02 18:50:00.000000',NULL),(23,56,39,'2019-02-15 17:30:00.000000',NULL),(24,75,32,'2019-12-28 17:10:00.000000',NULL),(25,18,11,'2019-04-14 15:00:00.000000',NULL),(26,20,9,'2019-12-18 10:30:00.000000',NULL),(27,61,12,'2019-07-30 10:10:00.000000',NULL),(28,19,32,'2019-06-15 09:30:00.000000',NULL),(29,100,14,'2019-07-28 12:50:00.000000',NULL),(30,56,28,'2019-07-12 19:30:00.000000',NULL),(31,44,4,'2019-07-02 15:30:00.000000',NULL),(32,53,48,'2019-09-09 17:40:00.000000',NULL),(33,55,13,'2019-01-29 16:10:00.000000',NULL),(34,11,33,'2019-01-19 11:50:00.000000',NULL),(35,72,35,'2019-07-05 13:40:00.000000',NULL),(36,100,26,'2019-10-10 13:40:00.000000',NULL),(37,67,40,'2019-12-07 17:00:00.000000',NULL),(38,19,31,'2019-06-05 10:50:00.000000',NULL),(39,84,44,'2019-04-05 10:10:00.000000',NULL),(40,73,13,'2019-06-24 14:10:00.000000',NULL),(41,18,32,'2019-09-05 19:30:00.000000',NULL),(42,33,7,'2019-11-27 09:00:00.000000',NULL),(43,17,30,'2019-02-21 08:20:00.000000',NULL),(44,75,46,'2019-11-26 10:30:00.000000',NULL),(45,86,47,'2019-04-26 10:20:00.000000',NULL),(47,17,33,'2019-08-25 08:50:00.000000',NULL),(48,46,37,'2019-05-09 10:00:00.000000',NULL),(49,18,29,'2019-08-08 17:20:00.000000',NULL),(50,68,17,'2019-12-30 08:10:00.000000',NULL),(51,76,47,'2019-09-05 14:10:00.000000',NULL),(52,62,26,'2019-12-24 09:30:00.000000',NULL),(53,68,24,'2019-04-06 11:50:00.000000',NULL),(54,12,35,'2019-08-12 11:50:00.000000',NULL),(55,23,21,'2019-08-12 15:40:00.000000',NULL),(56,55,26,'2019-07-29 10:30:00.000000',NULL),(57,26,38,'2019-04-14 14:20:00.000000',NULL),(58,53,34,'2019-03-19 09:40:00.000000',NULL),(59,62,23,'2019-12-15 19:50:00.000000',NULL),(60,75,41,'2019-11-30 18:00:00.000000',NULL),(61,46,1,'2019-11-14 15:00:00.000000',NULL),(62,61,5,'2019-06-14 18:30:00.000000',NULL),(63,30,32,'2019-03-22 15:20:00.000000',NULL),(64,42,40,'2019-10-09 18:30:00.000000',NULL),(65,33,14,'2019-03-16 10:20:00.000000',NULL),(66,72,28,'2019-12-16 19:40:00.000000',NULL),(67,56,12,'2019-08-15 18:30:00.000000',NULL),(68,12,42,'2019-09-20 08:20:00.000000',NULL),(69,17,27,'2019-04-15 11:50:00.000000',NULL),(70,8,17,'2019-08-12 08:50:00.000000',NULL),(71,8,13,'2019-03-04 11:30:00.000000',NULL),(72,17,30,'2019-02-24 13:50:00.000000',NULL),(73,87,41,'2019-12-06 09:40:00.000000',NULL),(74,20,47,'2019-08-05 10:10:00.000000',NULL),(75,8,25,'2019-05-19 16:50:00.000000',NULL),(76,34,5,'2019-12-30 14:30:00.000000',NULL),(77,73,17,'2019-06-28 10:10:00.000000',NULL),(78,26,29,'2019-11-05 12:10:00.000000',NULL),(79,56,24,'2019-09-19 16:10:00.000000',NULL),(80,30,11,'2019-02-26 17:40:00.000000',NULL),(81,34,49,'2019-09-13 10:10:00.000000',NULL),(82,11,48,'2019-10-14 19:40:00.000000',NULL),(83,72,35,'2019-04-11 16:20:00.000000',NULL),(84,58,49,'2019-03-06 12:10:00.000000',NULL),(85,42,12,'2019-08-21 17:20:00.000000',NULL),(86,49,48,'2019-06-29 17:20:00.000000',NULL),(87,97,46,'2019-02-04 19:50:00.000000',NULL),(88,34,12,'2019-07-09 16:50:00.000000',NULL),(89,61,48,'2019-06-16 12:00:00.000000',NULL),(90,84,5,'2019-11-27 13:30:00.000000',NULL),(92,84,48,'2019-12-15 14:30:00.000000',NULL),(93,11,1,'2019-10-17 19:00:00.000000',NULL),(94,33,43,'2019-11-15 15:40:00.000000',NULL),(95,100,2,'2019-08-24 17:00:00.000000',NULL),(96,72,31,'2019-05-27 14:20:00.000000',NULL),(97,55,11,'2019-08-19 17:50:00.000000',NULL),(98,87,50,'2019-08-08 19:00:00.000000',NULL),(99,67,4,'2019-02-24 13:00:00.000000',NULL),(100,18,39,'2019-12-19 15:00:00.000000',NULL);
/*!40000 ALTER TABLE `clientservice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documentbyservice`
--

DROP TABLE IF EXISTS `documentbyservice`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `documentbyservice` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ClientServiceID` int NOT NULL,
  `DocumentPath` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_DocumentByService_ClientService` (`ClientServiceID`),
  CONSTRAINT `FK_DocumentByService_ClientService` FOREIGN KEY (`ClientServiceID`) REFERENCES `clientservice` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documentbyservice`
--

LOCK TABLES `documentbyservice` WRITE;
/*!40000 ALTER TABLE `documentbyservice` DISABLE KEYS */;
/*!40000 ALTER TABLE `documentbyservice` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gender`
--

DROP TABLE IF EXISTS `gender`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gender` (
  `Code` char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`Code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gender`
--

LOCK TABLES `gender` WRITE;
/*!40000 ALTER TABLE `gender` DISABLE KEYS */;
INSERT INTO `gender` VALUES ('ж','Женский'),('м','Мужской');
/*!40000 ALTER TABLE `gender` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `manufacturer`
--

DROP TABLE IF EXISTS `manufacturer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `manufacturer` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `StartDate` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `manufacturer`
--

LOCK TABLES `manufacturer` WRITE;
/*!40000 ALTER TABLE `manufacturer` DISABLE KEYS */;
/*!40000 ALTER TABLE `manufacturer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Cost` decimal(19,4) NOT NULL,
  `Description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `MainImagePath` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `IsActive` tinyint(1) NOT NULL,
  `ManufacturerID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_Product_Manufacturer` (`ManufacturerID`),
  CONSTRAINT `FK_Product_Manufacturer` FOREIGN KEY (`ManufacturerID`) REFERENCES `manufacturer` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productphoto`
--

DROP TABLE IF EXISTS `productphoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productphoto` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ProductID` int NOT NULL,
  `PhotoPath` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ProductPhoto_Product` (`ProductID`),
  CONSTRAINT `FK_ProductPhoto_Product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productphoto`
--

LOCK TABLES `productphoto` WRITE;
/*!40000 ALTER TABLE `productphoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `productphoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `productsale`
--

DROP TABLE IF EXISTS `productsale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `productsale` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `SaleDate` datetime(6) NOT NULL,
  `ProductID` int NOT NULL,
  `Quantity` int NOT NULL,
  `ClientServiceID` int DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ProductSale_Product` (`ProductID`),
  KEY `FK_ProductSale_ClientService` (`ClientServiceID`),
  CONSTRAINT `FK_ProductSale_ClientService` FOREIGN KEY (`ClientServiceID`) REFERENCES `clientservice` (`ID`),
  CONSTRAINT `FK_ProductSale_Product` FOREIGN KEY (`ProductID`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `productsale`
--

LOCK TABLES `productsale` WRITE;
/*!40000 ALTER TABLE `productsale` DISABLE KEYS */;
/*!40000 ALTER TABLE `productsale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service`
--

DROP TABLE IF EXISTS `service`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `service` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Cost` decimal(19,4) NOT NULL,
  `DurationInSeconds` int NOT NULL,
  `Description` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci,
  `Discount` double DEFAULT NULL,
  `MainImagePath` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service`
--

LOCK TABLES `service` WRITE;
/*!40000 ALTER TABLE `service` DISABLE KEYS */;
INSERT INTO `service` VALUES (1,'Замена сальника привода',3820.0000,34200,NULL,0.15,NULL),(2,'Замена кулисы АКПП',3250.0000,21600,NULL,0.1,NULL),(3,'Замена тормозной жидкости',2200.0000,21600,NULL,0.1,NULL),(4,'Ремонт компрессора кондиционера',4760.0000,9000,NULL,0.25,NULL),(5,'Ремонт автоэлектрики',4230.0000,27000,NULL,0.1,NULL),(6,'Наращивание ресниц',1430.0000,2400,NULL,0.05,NULL),(7,'Замена лямбда зонда',770.0000,16200,NULL,0.05,NULL),(8,'Кузовной ремонт',2750.0000,9000,NULL,0.05,NULL),(9,'Замена подшипника задней ступицы',1860.0000,16200,NULL,0.25,NULL),(10,'Замена масла в МКПП',4490.0000,32400,NULL,0.2,NULL),(11,'Замена заднего сальника АКПП',1510.0000,23400,NULL,0.25,NULL),(12,'Замена охлаждающей жидкости',1590.0000,12600,NULL,0,NULL),(13,'Замена масла АКПП',2430.0000,27000,NULL,0.25,NULL),(14,'Замена жидкости ГУР',2380.0000,32400,NULL,0.2,NULL),(15,'Испанский массаж',2190.0000,2400,NULL,0.25,NULL),(16,'Балансировка колес',4690.0000,23400,NULL,0.25,NULL),(17,'Замена подшипника передней ступицы',4020.0000,19800,NULL,0.15,NULL),(18,'Ремонт двигателя',2470.0000,14400,NULL,0.25,NULL),(19,'Замена сцепления',4320.0000,19800,NULL,0,NULL),(20,'Интенсивный курс с преподавателем-носителем португальского языка для компаний',1580.0000,1800,NULL,0,NULL),(21,'Замена подшипника компрессора кондиционера',1110.0000,19800,NULL,0.2,NULL),(22,'Диагностика рулевого редуктора',2930.0000,10800,NULL,0.1,NULL),(23,'Замена фильтров',530.0000,12600,NULL,0.15,NULL),(24,'Ремонт глушителя',2100.0000,9000,NULL,0.25,NULL),(25,'Чистка форсунок ультразвуком',3920.0000,14400,NULL,0.05,NULL),(26,'Замена масла заднего редуктора (моста)',840.0000,25200,NULL,0.25,NULL),(27,'Ремонт бензонасоса',500.0000,12600,NULL,0.15,NULL),(28,'Антибактериальная обработка кондиционера',4580.0000,27000,NULL,0.2,NULL),(29,'Замена ремня кондиционера',4650.0000,28800,NULL,0,NULL),(30,'Ремонт и замена катализатора',500.0000,16200,NULL,0.25,NULL),(31,'Ремонт карданного вала',780.0000,12600,NULL,0.05,NULL),(32,'Установка сигнализации',1760.0000,14400,NULL,0,NULL),(33,'Ремонт кронштейна глушителя',1410.0000,34200,NULL,0,NULL),(34,'Замена трубки кондиционера',2810.0000,10800,NULL,0.15,NULL),(35,'Диагностика подвески',1460.0000,19800,NULL,0,NULL),(36,'Замена масла в вариаторе',4720.0000,7200,NULL,0.05,NULL),(37,'Замена тормозных колодок',4260.0000,28800,NULL,0.05,NULL),(38,'Покраска',2370.0000,7200,NULL,0.15,NULL),(39,'Ремонт сцепления',3290.0000,36000,NULL,0.25,NULL),(40,'Диагностика трансмиссии',2790.0000,7200,NULL,0.2,NULL),(41,'Диагностика выхлопной системы автомобиля',2550.0000,10800,NULL,0.25,NULL),(42,'Диагностика инжектора',3390.0000,19800,NULL,0.05,NULL),(43,'Замена троса сцепления',4460.0000,28800,NULL,0.05,NULL),(44,'Замена маховика',2400.0000,36000,NULL,0.25,NULL),(45,'Ремонт стартера',2680.0000,28800,NULL,0,NULL),(46,'Снятие/установка форсунок',1470.0000,18000,NULL,0.25,NULL),(47,'Замена ремня привода ГУР',3350.0000,36000,NULL,0,NULL),(48,'Замена свечей',2240.0000,7200,NULL,0.1,NULL),(49,'Развал-схождение',3890.0000,10800,NULL,0,NULL),(50,'Замена рулевой тяги',570.0000,10800,NULL,0,NULL);
/*!40000 ALTER TABLE `service` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicephoto`
--

DROP TABLE IF EXISTS `servicephoto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicephoto` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `ServiceID` int NOT NULL,
  `PhotoPath` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`),
  KEY `FK_ServicePhoto_Service` (`ServiceID`),
  CONSTRAINT `FK_ServicePhoto_Service` FOREIGN KEY (`ServiceID`) REFERENCES `service` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicephoto`
--

LOCK TABLES `servicephoto` WRITE;
/*!40000 ALTER TABLE `servicephoto` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicephoto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tag` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Title` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Color` char(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tag`
--

LOCK TABLES `tag` WRITE;
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` VALUES (1,'завершено','GREEN'),(2,'неоплаченно','RED'),(3,'заказано','GRAY');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tagofclient`
--

DROP TABLE IF EXISTS `tagofclient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tagofclient` (
  `ClientID` int NOT NULL,
  `TagID` int NOT NULL,
  PRIMARY KEY (`ClientID`,`TagID`),
  KEY `FK_TagOfClient_Tag` (`TagID`),
  CONSTRAINT `FK_TagOfClient_Client` FOREIGN KEY (`ClientID`) REFERENCES `client` (`ID`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `FK_TagOfClient_Tag` FOREIGN KEY (`TagID`) REFERENCES `tag` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tagofclient`
--

LOCK TABLES `tagofclient` WRITE;
/*!40000 ALTER TABLE `tagofclient` DISABLE KEYS */;
INSERT INTO `tagofclient` VALUES (5,1),(9,1),(13,1),(16,1),(18,1),(21,1),(23,1),(24,1),(28,1),(30,1),(35,1),(39,1),(41,1),(42,1),(43,1),(44,1),(45,1),(49,1),(54,1),(55,1),(56,1),(58,1),(62,1),(66,1),(67,1),(72,1),(75,1),(78,1),(80,1),(84,1),(93,1),(6,2),(8,2),(10,2),(11,2),(12,2),(15,2),(17,2),(19,2),(26,2),(29,2),(33,2),(36,2),(37,2),(38,2),(40,2),(48,2),(51,2),(52,2),(53,2),(59,2),(61,2),(65,2),(68,2),(73,2),(77,2),(81,2),(82,2),(88,2),(89,2),(91,2),(92,2),(95,2),(96,2),(97,2),(99,2),(100,2),(3,3),(4,3),(14,3),(20,3),(27,3),(31,3),(32,3),(34,3),(46,3),(47,3),(50,3),(57,3),(60,3),(63,3),(64,3),(69,3),(70,3),(71,3),(74,3),(76,3),(79,3),(83,3),(85,3),(86,3),(87,3),(90,3),(94,3),(98,3);
/*!40000 ALTER TABLE `tagofclient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(70) DEFAULT NULL,
  `login` varchar(70) NOT NULL,
  `password` varchar(45) NOT NULL,
  `rule` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'su','root','1234','1'),(2,'user','user','123','0');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-01 11:49:11
