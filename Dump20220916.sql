CREATE DATABASE  IF NOT EXISTS `rent_car2` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `rent_car2`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: rent_car2
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `결제`
--

DROP TABLE IF EXISTS `결제`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `결제` (
  `결제번호` varchar(45) NOT NULL,
  `청구요금` int NOT NULL,
  `기타청구내역` varchar(45) DEFAULT NULL,
  `기타청구요금` varchar(45) DEFAULT NULL,
  `연장비용` int DEFAULT NULL,
  PRIMARY KEY (`결제번호`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `결제`
--

LOCK TABLES `결제` WRITE;
/*!40000 ALTER TABLE `결제` DISABLE KEYS */;
INSERT INTO `결제` VALUES ('00001',130000,'','',10000),('00002',150000,NULL,NULL,NULL),('00003',210000,'',NULL,NULL),('00004',215000,NULL,NULL,NULL),('00005',149800,NULL,NULL,NULL),('00006',70000,NULL,NULL,NULL),('00007',149850,NULL,NULL,NULL),('00008',100000,NULL,NULL,NULL),('00009',174800,NULL,NULL,NULL),('00010',63500,NULL,NULL,NULL),('00011',78532,NULL,NULL,NULL),('00012',25000,NULL,NULL,NULL),('00013',78900,NULL,NULL,NULL),('00014',12359,NULL,NULL,NULL),('00015',135900,NULL,NULL,NULL),('00016',190000,NULL,NULL,NULL),('00017',25400,NULL,NULL,NULL),('00018',36400,NULL,NULL,NULL),('00019',23100,NULL,NULL,NULL),('00020',100000,NULL,NULL,NULL);
/*!40000 ALTER TABLE `결제` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `고객`
--

DROP TABLE IF EXISTS `고객`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `고객` (
  `운전면허증번호` varchar(45) NOT NULL,
  `취득날짜` varchar(45) NOT NULL,
  `생년월일` varchar(45) NOT NULL,
  `고객명` varchar(45) NOT NULL,
  `나이` int NOT NULL,
  `주소` varchar(45) NOT NULL,
  `전화번호` varchar(45) NOT NULL,
  `이메일` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`운전면허증번호`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `고객`
--

LOCK TABLES `고객` WRITE;
/*!40000 ALTER TABLE `고객` DISABLE KEYS */;
INSERT INTO `고객` VALUES ('12-12-123455-12','2022-01-01','2022-01-01','hong',20,'inc','010-1234-1234','abc@ab.com'),('12-12-456789-44','2022-01-01','2000-01-01','gil',24,'inc','010-4578-1155','ab@ac.com'),('12-34-567890-12','2018-01-20','1995-01-20','이채은',25,'인천','010-1234-1234','chae2224@gmail.com'),('12-34-567890-13','2019-11-20','1994-03-21','이성은',26,'대구','010-2345-2345','eun4447@gmail.com'),('12-34-567890-14','2018-11-21','1995-05-10','최조양',25,'부산','010-3456-3536','yang4449@gmail.com'),('12-34-567890-15','2018-11-25','1995-07-17','서정현',25,'대전','010-4567-4657','hyeon5552@gmail.com'),('12-34-567890-16','2019-03-20','1997-04-02','이성대',23,'서울','010-5678-5678','dae9997@gmail.com'),('12-34-567890-17','2015-07-20','1997-04-09','김돋음',23,'인천','010-6789-6789','doteum6662@gmail.com'),('12-34-567890-18','2015-08-25','1998-09-30','김별',22,'경기','010-7890-7890','byeol5553@gmail.com'),('12-34-567890-19','2015-02-25','1998-01-11','윤아인',22,'울산','010-1234-2345','ain3333@gmail.com'),('12-34-567890-20','2014-06-27','1998-02-15','백시아',22,'광주','010-7098-2345','sia9992@gmail.com'),('12-34-567890-21','2014-02-27','1997-08-15','이아리',23,'서울','010-1152-2345','ari6664@gmail.com'),('12-34-567890-22','2014-08-29','1997-04-06','신형만',23,'광주','010-1111-2345','gmlsend02@gmail.com'),('12-34-567890-23','2018-08-21','1995-04-04','김동민',25,'인천','010-2222-2345','dnflrn987@gmail.com'),('12-34-567890-24','2018-01-20','1995-07-28','이채림',25,'대구','010-2345-4569','qwert123@gmail.com'),('12-34-567890-25','2017-03-20','1996-07-25','박정권',24,'인천','010-2345-3546','ejdnj657@gmail.com'),('12-34-567890-26','2017-04-21','1996-07-24','이여름',24,'부산','010-2790-2345','dufmadl1@gmail.com'),('12-34-567890-27','2018-04-21','1993-09-26','조호연',27,'인천','010-4567-2345','ghdus23@gmail.com'),('12-34-567890-28','2019-01-24','1993-09-21','김동훈',27,'대구','010-7890-5678','ehdgns144@gmail.com'),('12-34-567890-29','2015-04-24','1992-10-20','함현주',28,'대구','010-2345-7980','gg590@gmail.com'),('12-34-567890-30','2010-04-20','1992-11-14','이동현',28,'대구','010-6789-2345','ehdgus901@gmail.com'),('12-34-567890-31','2012-01-27','1992-11-18','고두심',28,'대구','010-2345-4531','entla10239@gmail.com');
/*!40000 ALTER TABLE `고객` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `기사`
--

DROP TABLE IF EXISTS `기사`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `기사` (
  `기사번호` varchar(45) NOT NULL,
  `기사명` varchar(45) DEFAULT NULL,
  `기사운전면허증번호` varchar(45) DEFAULT NULL,
  `면허종류번호` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`기사번호`),
  KEY `면허종류번호_idx` (`면허종류번호`),
  CONSTRAINT `면허종류번호` FOREIGN KEY (`면허종류번호`) REFERENCES `면허종류` (`면허종류번호`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `기사`
--

LOCK TABLES `기사` WRITE;
/*!40000 ALTER TABLE `기사` DISABLE KEYS */;
/*!40000 ALTER TABLE `기사` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `기사용역`
--

DROP TABLE IF EXISTS `기사용역`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `기사용역` (
  `기사용역고유번호` int NOT NULL AUTO_INCREMENT,
  `회사번호` varchar(50) DEFAULT NULL,
  `회사명` varchar(45) DEFAULT NULL,
  `용역인원` int DEFAULT NULL,
  `기사번호` varchar(45) DEFAULT NULL,
  `기사명` varchar(45) DEFAULT NULL,
  `기사운전면허증번호` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`기사용역고유번호`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `기사용역`
--

LOCK TABLES `기사용역` WRITE;
/*!40000 ALTER TABLE `기사용역` DISABLE KEYS */;
/*!40000 ALTER TABLE `기사용역` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `대여`
--

DROP TABLE IF EXISTS `대여`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `대여` (
  `고유대여번호` int NOT NULL AUTO_INCREMENT,
  `대여시작일` varchar(45) NOT NULL,
  `대여기간` varchar(45) NOT NULL,
  `운전면허증번호` varchar(45) NOT NULL,
  `차량번호` varchar(45) NOT NULL,
  `결제번호` varchar(45) NOT NULL,
  `보험등록번호` varchar(45) NOT NULL,
  `대여상태` varchar(45) NOT NULL,
  PRIMARY KEY (`고유대여번호`),
  KEY `운전면허증번호_idx` (`운전면허증번호`),
  KEY `차량번호_idx` (`차량번호`),
  KEY `결제번호_idx` (`결제번호`),
  KEY `보험등록번호_idx` (`보험등록번호`),
  KEY `고유대여번호인덱스` (`고유대여번호`),
  CONSTRAINT `결제번호` FOREIGN KEY (`결제번호`) REFERENCES `결제` (`결제번호`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `보험등록번호` FOREIGN KEY (`보험등록번호`) REFERENCES `보험` (`보험등록번호`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `운전면허증번호` FOREIGN KEY (`운전면허증번호`) REFERENCES `고객` (`운전면허증번호`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `차량번호` FOREIGN KEY (`차량번호`) REFERENCES `차량` (`차량번호`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `대여`
--

LOCK TABLES `대여` WRITE;
/*!40000 ALTER TABLE `대여` DISABLE KEYS */;
INSERT INTO `대여` VALUES (1,'2019-01-04','7','12-34-567890-13','01거 5000','00002','00000002','반납완료'),(2,'2019-01-05','3','12-34-567890-14','02허 9853','00003','00000003','반납완료'),(3,'2019-01-06','5','12-34-567890-15','05하 4727','00004','00000004','반납완료'),(4,'2019-01-07','8','12-34-567890-16','15무 8888','00005','00000005','반납완료'),(5,'2019-11-08','10','12-34-567890-17','21우 8176','00006','00000004','대여중'),(6,'2018-10-05','3','12-34-567890-18','22가 1252','00007','00000003','반납완료'),(7,'2014-05-05','6','12-34-567890-19','23머 6241','00008','00000001','반납완료'),(8,'2019-04-23','4','12-34-567890-20','39나 3764','00009','00000002','대여중'),(9,'2017-03-01','25','12-34-567890-21','49우 2596','00010','00000003','반납완료'),(10,'2019-02-26','2','12-34-567890-22','50더 7979','00011','00000002','대여중'),(11,'2019-03-07','3','12-34-567890-23','52가 3108','00012','00000003','대여중'),(12,'2019-04-14','4','12-34-567890-24','52단 3108','00013','00000001','대여중'),(13,'2019-01-08','1','12-34-567890-25','54가 0639','00014','00000005','반납완료'),(14,'2019-11-21','1','12-34-567890-26','55가 3838','00015','00000004','대여중'),(15,'2019-09-12','10','12-34-567890-27','55더 1818','00016','00000005','대여중'),(16,'2019-09-12','8','12-34-567890-28','56누 0184','00017','00000001','대여중'),(17,'2019-09-12','8','12-34-567890-29','65호 4516','00018','00000004','대여중'),(18,'2018-04-13','2','12-34-567890-30','66보 8432','00019','00000001','반납완료'),(19,'2018-12-13','3','12-34-567890-31','67나 7662','00020','00000002','반납완료'),(20,'2022-01-01','5','12-34-567890-12','01아 2222','00001','00000004','대여중'),(22,'2022-01-01','7','12-12-456789-44','01거 5000','00001','00000004','대여중');
/*!40000 ALTER TABLE `대여` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `면허종류`
--

DROP TABLE IF EXISTS `면허종류`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `면허종류` (
  `면허종류번호` varchar(45) NOT NULL,
  `면허분류` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`면허종류번호`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `면허종류`
--

LOCK TABLES `면허종류` WRITE;
/*!40000 ALTER TABLE `면허종류` DISABLE KEYS */;
/*!40000 ALTER TABLE `면허종류` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `보험`
--

DROP TABLE IF EXISTS `보험`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `보험` (
  `보험등록번호` varchar(45) NOT NULL,
  `보험종류` varchar(45) NOT NULL,
  `보험가입비용` varchar(45) NOT NULL,
  `기타정보` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`보험등록번호`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `보험`
--

LOCK TABLES `보험` WRITE;
/*!40000 ALTER TABLE `보험` DISABLE KEYS */;
INSERT INTO `보험` VALUES ('00000001','국산일반자차1','10000원','면책금 30만원'),('00000002','국산일반자차2','10000원','면책금 15만원'),('00000003','국산일반자차3','20000원','면책금 25만원'),('00000004','수입일반자차1','20000원','면책금 75만원'),('00000005','수입일반자차2','30000원','면책금 95만원'),('00000006','국산슈퍼자차1','20000원','면책금 35만원'),('00000007','국산슈퍼자차2','20000원','면책금 55만원');
/*!40000 ALTER TABLE `보험` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `소속`
--

DROP TABLE IF EXISTS `소속`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `소속` (
  `회사번호` varchar(45) NOT NULL,
  `기사번호` varchar(45) NOT NULL,
  PRIMARY KEY (`기사번호`,`회사번호`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `소속`
--

LOCK TABLES `소속` WRITE;
/*!40000 ALTER TABLE `소속` DISABLE KEYS */;
/*!40000 ALTER TABLE `소속` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `인천고객`
--

DROP TABLE IF EXISTS `인천고객`;
/*!50001 DROP VIEW IF EXISTS `인천고객`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `인천고객` AS SELECT 
 1 AS `고객명`,
 1 AS `운전면허증번호`*/;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `차량`
--

DROP TABLE IF EXISTS `차량`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `차량` (
  `차량번호` varchar(45) NOT NULL,
  `렌트카이름` varchar(45) NOT NULL,
  `차종류` varchar(45) NOT NULL,
  `색상` varchar(45) NOT NULL,
  `연료` varchar(45) NOT NULL,
  `차량옵션` varchar(45) NOT NULL,
  `승차인원수` int NOT NULL,
  `지역` varchar(45) NOT NULL,
  `상세정보` varchar(45) NOT NULL,
  `일일대여비용` int NOT NULL,
  `차량반납여부` varchar(45) NOT NULL,
  PRIMARY KEY (`차량번호`)
) ENGINE=InnoDB DEFAULT CHARSET=euckr;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `차량`
--

LOCK TABLES `차량` WRITE;
/*!40000 ALTER TABLE `차량` DISABLE KEYS */;
INSERT INTO `차량` VALUES ('00누 2222','k7','준대형','그레이','LPG','에어백',5,'부산','-',80000,'대여가능'),('00누 5555','k7','준대형','그레이','LPG','에어백',5,'부산','-',80000,'대여가능'),('01거 5000','모닝','경형','화이트','LPG','에어백',5,'포항','-',60000,'대여중'),('01아 2222','k7','대형','화이트','LPG','에어백',5,'경기','상세',70000,'대여중'),('02허 9853','소나타','중형','화이트','가솔린','썬루프',5,'성남','-',70000,'대여가능'),('05하 1212','sm6','준준형','화이트','가솔린','썬루프',5,'인천','-',60000,'대여가능'),('05하 4727','렉스턴','준대형','화이트','디젤','썬루프',5,'서울','-',80000,'대여가능'),('07허 2287','소나타','중형','화이트','엘피지','에어백',5,'경기','.',40000,'대여가능'),('15무 8888','k5','중형','블랙','LPG','가죽시트',5,'여수','-',70000,'대여가능'),('21우 8176','임팔라','준대형','블랙','가솔린','가죽시트',5,'부산','-',70000,'대여중'),('22가 1252','아반떼','준중형','레드','디젤','에어백',5,'수원','-',65000,'대여가능'),('23머 6241','SM3','준중형','블루','가솔린','-',5,'성남','-',60000,'대여가능'),('39나 3764','k3','준중형','블랙','LPG','에어백',5,'경주','-',60000,'대여중'),('49우 2596','스파크','경형','블랙','가솔린','썬루프',5,'성남','-',60000,'대여가능'),('50더 7979','SM5','중형','그레이','가솔린','-',5,'인천','-',70000,'대여중'),('52가 3108','카니발','대형','블랙','디젤','썬루프',11,'대구','-',100000,'대여중'),('52단 3108','셀토스','소형','화이트','LPG','썬루프',5,'광주','-',70000,'대여중'),('54가 0639','모하비','준대형','블랙','디젤','가죽시트',7,'울산','-',80000,'대여가능'),('55가 3838','그랜저','준대형','블랙','가솔린','가죽시트',5,'서울','-',80000,'대여중'),('55더 1818','말리부','중형','블랙','디젤','-',5,'인천','-',70000,'대여중'),('56누 0184','티볼리','소형','레드','디젤','가죽시트',5,'서울','-',70000,'대여중'),('65호 4516','쏘렌토','중형','화이트','디젤','가죽시트',7,'대전','-',80000,'대여중'),('66보 8432','싼타페','중형','그레이','디젤','-',7,'인천','-',100000,'대여가능'),('67나 7662','투싼','준중형','블랙','가솔린','에어백',5,'용인','-',90000,'대여가능');
/*!40000 ALTER TABLE `차량` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `인천고객`
--

/*!50001 DROP VIEW IF EXISTS `인천고객`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_general_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `인천고객` AS select `고객`.`고객명` AS `고객명`,`고객`.`운전면허증번호` AS `운전면허증번호` from `고객` where (`고객`.`주소` = '인천') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-16 18:31:03
CREATE DATABASE  IF NOT EXISTS `shop_db` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shop_db`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: shop_db
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `member_id` char(8) COLLATE utf8mb3_unicode_ci NOT NULL,
  `member_name` char(5) COLLATE utf8mb3_unicode_ci NOT NULL,
  `member_addr` char(20) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('carry','머라이어','미국 텍사스 사막'),('hero','임영웅','서울 은평구 증산동'),('jyp','박진영','경기 고양시 장항동'),('tess','나훈아','경기 안산시 상록구');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-16 18:31:03
CREATE DATABASE  IF NOT EXISTS `shop_db2` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `shop_db2`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: shop_db2
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `member`
--

DROP TABLE IF EXISTS `member`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `member` (
  `member_id` char(8) COLLATE utf8mb3_unicode_ci NOT NULL,
  `member_name` char(5) COLLATE utf8mb3_unicode_ci NOT NULL,
  `member_addr` char(20) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `member`
--

LOCK TABLES `member` WRITE;
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` VALUES ('hero','임영웅','서울 은평구 증산동'),('jyp','박진영','경기도 안산시 상록구'),('tess','나훈아','경기 부천시 중동');
/*!40000 ALTER TABLE `member` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `product_name` char(4) COLLATE utf8mb3_unicode_ci NOT NULL,
  `cost` int NOT NULL,
  `make_date` date DEFAULT NULL,
  `company` char(5) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `amount` int NOT NULL,
  PRIMARY KEY (`product_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES ('바나나',1500,'2021-07-01','델몬트',17),('카스',2500,'2022-03-01','OB',10);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-16 18:31:03
CREATE DATABASE  IF NOT EXISTS `boardtest` /*!40100 DEFAULT CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `boardtest`;
-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: boardtest
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board`
--

DROP TABLE IF EXISTS `board`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board` (
  `b_no` int NOT NULL AUTO_INCREMENT,
  `b_title` varchar(100) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `b_content` varchar(500) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `b_writer` varchar(10) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `b_password` varchar(4) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `b_view` int DEFAULT NULL,
  PRIMARY KEY (`b_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board`
--

LOCK TABLES `board` WRITE;
/*!40000 ALTER TABLE `board` DISABLE KEYS */;
INSERT INTO `board` VALUES (1,'밥','배고프다','강호동','1234',1),(2,'진짜','이건 진짜야','유재석','1234',2),(4,'hey','it\'smylaptop','ho','11',0),(5,'흠','모르겠다 모르겠어','후','11',0);
/*!40000 ALTER TABLE `board` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-09-16 18:31:03
