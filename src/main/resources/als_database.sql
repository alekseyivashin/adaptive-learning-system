-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: als_database
-- ------------------------------------------------------
-- Server version	5.7.18-0ubuntu0.16.04.1

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
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` (`id`, `name`, `level`) VALUES (2,'Введение в JavaScript',1),(5,'Введение в HTML и CSS',1),(6,'HTML5',2),(7,'Python.Начало',1),(8,'Python.Продолжение',2),(9,'Основы jQuery',2);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses_keywords`
--

DROP TABLE IF EXISTS `courses_keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses_keywords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `keyword_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `courses_keywords_fk0` (`course_id`),
  KEY `courses_keywords_fk1` (`keyword_id`),
  CONSTRAINT `courses_keywords_fk0` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  CONSTRAINT `courses_keywords_fk1` FOREIGN KEY (`keyword_id`) REFERENCES `keywords` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses_keywords`
--

LOCK TABLES `courses_keywords` WRITE;
/*!40000 ALTER TABLE `courses_keywords` DISABLE KEYS */;
INSERT INTO `courses_keywords` (`id`, `course_id`, `keyword_id`) VALUES (1,2,1),(2,2,5),(3,2,7),(4,5,2),(5,5,3),(6,5,5),(7,5,7),(8,6,2),(9,6,4),(10,6,3),(11,6,5),(12,6,7),(13,7,8),(14,7,6),(15,7,7),(16,8,8),(17,8,6),(18,8,7),(19,9,1),(20,9,9),(21,9,5),(22,9,7);
/*!40000 ALTER TABLE `courses_keywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keywords`
--

DROP TABLE IF EXISTS `keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keywords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keywords`
--

LOCK TABLES `keywords` WRITE;
/*!40000 ALTER TABLE `keywords` DISABLE KEYS */;
INSERT INTO `keywords` (`id`, `name`) VALUES (6,'back-end'),(3,'css'),(5,'front-end'),(2,'html'),(4,'html5'),(1,'javascript'),(9,'jquery'),(8,'python'),(7,'web');
/*!40000 ALTER TABLE `keywords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `learning_contents`
--

DROP TABLE IF EXISTS `learning_contents`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `learning_contents` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme_id` int(11) NOT NULL,
  `content` varchar(4000) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `learning_contents_fk0` (`theme_id`),
  CONSTRAINT `learning_contents_fk0` FOREIGN KEY (`theme_id`) REFERENCES `themes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `learning_contents`
--

LOCK TABLES `learning_contents` WRITE;
/*!40000 ALTER TABLE `learning_contents` DISABLE KEYS */;
/*!40000 ALTER TABLE `learning_contents` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme_id` int(11) NOT NULL,
  `content` varchar(200) NOT NULL,
  `level` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `questions_fk0` (`theme_id`),
  CONSTRAINT `questions_fk0` FOREIGN KEY (`theme_id`) REFERENCES `themes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tests`
--

DROP TABLE IF EXISTS `tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tests` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(255) DEFAULT NULL,
  `learning_content_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tests_fk0` (`learning_content_id`),
  CONSTRAINT `tests_fk0` FOREIGN KEY (`learning_content_id`) REFERENCES `learning_contents` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests`
--

LOCK TABLES `tests` WRITE;
/*!40000 ALTER TABLE `tests` DISABLE KEYS */;
/*!40000 ALTER TABLE `tests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tests_questions`
--

DROP TABLE IF EXISTS `tests_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tests_questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `test_id` int(11) NOT NULL,
  `correct` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `tests_questions_fk0` (`question_id`),
  KEY `tests_questions_fk1` (`test_id`),
  CONSTRAINT `tests_questions_fk0` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`),
  CONSTRAINT `tests_questions_fk1` FOREIGN KEY (`test_id`) REFERENCES `tests` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests_questions`
--

LOCK TABLES `tests_questions` WRITE;
/*!40000 ALTER TABLE `tests_questions` DISABLE KEYS */;
/*!40000 ALTER TABLE `tests_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `themes`
--

DROP TABLE IF EXISTS `themes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `themes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  KEY `themes_fk0` (`course_id`),
  CONSTRAINT `themes_fk0` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `themes`
--

LOCK TABLES `themes` WRITE;
/*!40000 ALTER TABLE `themes` DISABLE KEYS */;
/*!40000 ALTER TABLE `themes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `password` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `name`, `password`) VALUES (1,'aleks','aEiLP1r7VjU='),(2,'Maria','MRjVZjTLY2Y='),(3,'Tom','ZcUjGxW+Res='),(4,'Pamela','fRawB5Cy2qo='),(5,'Hulk','dYFPC2Ij6jox7dFQwZpCiA==');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_courses`
--

DROP TABLE IF EXISTS `users_courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date DEFAULT NULL,
  `start_score` float DEFAULT NULL,
  `end_score` float DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `pass_value` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `users_courses_fk0` (`user_id`),
  KEY `users_courses_fk1` (`course_id`),
  CONSTRAINT `users_courses_fk0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `users_courses_fk1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_courses`
--

LOCK TABLES `users_courses` WRITE;
/*!40000 ALTER TABLE `users_courses` DISABLE KEYS */;
INSERT INTO `users_courses` (`id`, `user_id`, `course_id`, `start_date`, `end_date`, `start_score`, `end_score`, `rating`, `pass_value`) VALUES (1,1,9,'2017-05-06','2017-05-07',0.15,0.54,7,1),(2,1,6,'2017-05-07',NULL,0.43,NULL,NULL,0.38),(3,2,2,'2017-05-01','2017-05-04',0.67,0.99,10,1),(4,2,7,'2017-05-04','2017-05-07',0.09,0.86,8,1),(5,2,5,'2017-05-05',NULL,0.61,NULL,NULL,0.75),(6,3,8,'2017-05-02','2017-05-07',0.35,0.55,2,1),(7,3,2,'2017-05-05',NULL,0.8,NULL,NULL,0.22),(8,4,7,'2017-05-02','2017-05-08',0.71,0.97,1,1),(9,4,5,'2017-05-04','2017-05-08',0.79,0.96,5,1),(10,5,6,'2017-05-04',NULL,0.06,NULL,NULL,0.39),(11,5,8,'2017-05-01',NULL,0.13,NULL,NULL,0.96);
/*!40000 ALTER TABLE `users_courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users_keywords`
--

DROP TABLE IF EXISTS `users_keywords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users_keywords` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `keyword_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `users_keywords_fk0` (`user_id`),
  KEY `users_keywords_fk1` (`keyword_id`),
  CONSTRAINT `users_keywords_fk0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `users_keywords_fk1` FOREIGN KEY (`keyword_id`) REFERENCES `keywords` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_keywords`
--

LOCK TABLES `users_keywords` WRITE;
/*!40000 ALTER TABLE `users_keywords` DISABLE KEYS */;
INSERT INTO `users_keywords` (`id`, `user_id`, `keyword_id`) VALUES (1,1,8),(2,1,6),(3,2,2),(4,2,3),(5,2,5),(6,2,7),(7,3,3),(8,3,5),(9,3,7),(10,4,1),(11,4,2),(12,4,5),(13,4,7),(14,5,6);
/*!40000 ALTER TABLE `users_keywords` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-10  0:20:00
