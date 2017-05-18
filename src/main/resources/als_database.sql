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
-- Table structure for table `answers`
--

DROP TABLE IF EXISTS `answers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `answers` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question_id` int(11) NOT NULL,
  `content` varchar(50) NOT NULL,
  `correct` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `answers_fk0` (`question_id`),
  CONSTRAINT `answers_fk0` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=100 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `answers`
--

LOCK TABLES `answers` WRITE;
/*!40000 ALTER TABLE `answers` DISABLE KEYS */;
INSERT INTO `answers` (`id`, `question_id`, `content`, `correct`) VALUES (3,2,'Python 2.7 и 3.5',1),(4,2,'Pyhton 2.7 и 2.1',0),(5,2,'Python 2.6 и 3.5',1),(6,2,'Python 3.3 и 3.5',0),(7,3,'5.pow(3)',0),(8,3,'pow(5,3)',1),(9,3,'pow(3,5)',0),(10,3,'5**3',1),(11,3,'5.3**5',0),(12,3,'5*5*5',1),(13,4,'a.append(4)',1),(14,4,'a.extend([4])',1),(15,4,'a+=[4]',1),(16,4,'a.extend(4)',0),(17,4,'a.insert(4,4)',1),(18,5,'def f2(*args)',1),(19,5,'def f2(**args)',0),(20,5,'def f2(*kwargs)',1),(21,5,'def f2(**kwargs)',0),(22,5,'def f2(args)',0),(23,6,'def f2(*args)',0),(24,6,'def f2(**args)',1),(25,6,'def f2(*kwargs)',0),(26,6,'def f2(**kwargs)',1),(27,6,'def f2(args)',0),(28,7,'lambda использует 1 параметр',0),(29,7,'lambda записывается в 1 строку',1),(30,7,'lambda не использует сложных условий',1),(31,7,'lambda не имеет имени',1),(32,7,'lambda не может быть использовано в map()',0),(33,8,'перемещения директорий',0),(34,8,'удаления директорий',1),(35,8,'переименования директорий',0),(36,8,'копирования директорий',0),(37,9,'пустота',1),(38,9,'‘абвгдеёжзик’',0),(39,9,'‘к’',0),(40,9,'Ошибка чтения',0),(41,10,'юникодовой',0),(42,10,'байтовой',1),(43,10,'сырой (raw)',0),(44,10,'в кодировке koi-8',0),(45,10,'в кодировке win1251',0),(46,11,'class A:',1),(47,11,'class B(object):',1),(48,11,'class C(type):',1),(49,11,'class d:',1),(50,11,'class e(object):',1),(51,12,'свойство',0),(52,12,'конструктор',1),(53,12,'деструктор',0),(54,12,'метод',0),(55,13,'{}',0),(56,13,'словарь свойств и методов класса',1),(57,13,'ошибку',0),(58,13,'{\'x\': 5}',0),(59,14,'aiter=iter([1,2,3,4])',1),(60,14,'aiter=iter((1,2,3,4))',0),(61,14,'aiter=iter({‘a’:1,’b’:2})',0),(62,14,'aiter=iter({1,2,3,4})',0),(63,15,'начнет сначала',0),(64,15,'выдаст ошибку',1),(65,15,'остановится',0),(66,15,'будет выдавать пустые значения',0),(67,16,'пары списков – номер и значение',0),(68,16,'пары кортежей – номер и значение',1),(69,16,'словарь ключ -  номер, значение - значение',0),(70,17,'import sqlite3\nsqlite3.apileve',1),(71,17,'import sqlite3',0),(72,17,'sqlite3.apilevel',0),(73,17,'import sqlite3\nsqlite3.apiversion',0),(74,17,'import sqlite\nsqlite3.apilevel',0),(75,18,'да, результаты - итерируемый объект',1),(76,18,'да',0),(77,18,'нет',0),(78,19,'dumps()',0),(79,19,'loads()',1),(80,19,'write()',0),(81,20,'Байтовая строка',1),(82,20,'Юникод строка',0),(83,20,'Двоичная строка',0),(84,20,'Сырая строка',0),(85,20,'Юникод –сырая строка',0),(86,21,'urlparse',0),(87,21,'urlsplit',0),(88,21,'urlunsplit',1),(89,21,'urlunparse',1),(90,22,'\'Content-type\'',1),(91,22,'\'text/html\'',1),(92,22,'<body></body>',0),(93,22,'<head></head>',0),(94,22,'<title></title>',0),(95,23,'1.pip install Django==1.9',1),(96,23,'pip install Djago',0),(97,23,'pip install django==1.9',1),(98,23,'pip install django=1.9',0),(99,23,'pip django=1.9',0);
/*!40000 ALTER TABLE `answers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `courses` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `description` varchar(4000) DEFAULT NULL,
  `rating` float DEFAULT NULL,
  `user_count` int(11) DEFAULT NULL,
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
INSERT INTO `courses` (`id`, `name`, `description`, `rating`, `user_count`, `level`) VALUES (2,'Введение в JavaScript','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',3.1,2,1),(5,'Введение в HTML и CSS','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',4.9,1,1),(6,'HTML5','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',1.7,3,2),(7,'Python. Начало','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',3.5,5,1),(8,'Python. Продолжение','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',4.1,1,2),(9,'Основы jQuery','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',2.8,0,2);
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
  `learning_content_id` int(11) DEFAULT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `questions_fk0` (`learning_content_id`),
  KEY `questions_fk1` (`theme_id`),
  CONSTRAINT `questions_fk0` FOREIGN KEY (`learning_content_id`) REFERENCES `learning_contents` (`id`),
  CONSTRAINT `questions_fk1` FOREIGN KEY (`theme_id`) REFERENCES `themes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` (`id`, `theme_id`, `learning_content_id`, `content`) VALUES (2,1,NULL,'Какие версии Python являются несовместимыми по операциям ввода и вывода?'),(3,1,NULL,'Каким образом можно получить 3 степень числа 5?'),(4,1,NULL,'Для добавления элемента 4 в конец списка a=[1,2,3] можно использовать:'),(5,2,NULL,'Для передачи в функцию кортежей и списков используется запись:'),(6,2,NULL,'Для передачи в функцию словарей используется запись:'),(7,2,NULL,'\nКаково основное отличие функций, описываемых с помощью def и lambda?'),(8,3,NULL,'Метод rmdir используется для:'),(9,3,NULL,'При повторной операции чтения read() из файла с текстом ‘абвгдеёжзик’  будет получено:'),(10,3,NULL,'Для шифрования методом sha256 строка должна быть:'),(11,4,NULL,'Каким образом возможно описать класс:'),(12,4,NULL,'Дан класс \nclass A(object):\n	def __init__(self,x):\n	         self.x=x\n__init__ это'),(13,4,NULL,'Дан класс и его экземпляр\nclass A(object):\n	def __init__(self,x):\n	          self.x=x\na=A()\nчто выдаст\nA.__dict__'),(14,5,NULL,'Каким образом возможно создать итерируемый объект – итератор для списка:'),(15,5,NULL,'После того, как итератор дойдет до конца данных он:'),(16,5,NULL,'Итератор enumerate создает:'),(17,6,NULL,'Каким образом возможно проверить версию API по работе с БД SQLite:'),(18,6,NULL,'Можно ли использовать for к результатам запросов:'),(19,6,NULL,'Для преобразования данных JSON в данные Python используется метод:'),(20,7,NULL,'В каком формате выводится содержимое страниц, загруженных с использованием urllib.request.urlopen:'),(21,7,NULL,'Для получения url адреса из составляющих можно использовать:'),(22,7,NULL,'При создании сервера, используя модуль http.server и описании класса, унаследованного от BaseHTTPRequestHandler, в методе send_header прописываются:'),(23,8,NULL,'Для установки Django требуемой версии (1.9) с использованием pip нужно записать:');
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
  `course_id` int(11) NOT NULL,
  `learning_content_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tests_fk0` (`learning_content_id`),
  KEY `tests_fk1` (`course_id`),
  CONSTRAINT `tests_fk0` FOREIGN KEY (`learning_content_id`) REFERENCES `learning_contents` (`id`),
  CONSTRAINT `tests_fk1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests`
--

LOCK TABLES `tests` WRITE;
/*!40000 ALTER TABLE `tests` DISABLE KEYS */;
INSERT INTO `tests` (`id`, `type`, `course_id`, `learning_content_id`) VALUES (1,'START',7,NULL);
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
  PRIMARY KEY (`id`),
  KEY `tests_questions_fk0` (`question_id`),
  KEY `tests_questions_fk1` (`test_id`),
  CONSTRAINT `tests_questions_fk0` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`),
  CONSTRAINT `tests_questions_fk1` FOREIGN KEY (`test_id`) REFERENCES `tests` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tests_questions`
--

LOCK TABLES `tests_questions` WRITE;
/*!40000 ALTER TABLE `tests_questions` DISABLE KEYS */;
INSERT INTO `tests_questions` (`id`, `question_id`, `test_id`) VALUES (2,3,1),(4,5,1),(6,7,1),(8,9,1),(10,11,1),(12,13,1),(14,15,1),(16,17,1),(18,19,1),(20,21,1),(22,23,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `themes`
--

LOCK TABLES `themes` WRITE;
/*!40000 ALTER TABLE `themes` DISABLE KEYS */;
INSERT INTO `themes` (`id`, `course_id`, `name`) VALUES (1,7,'Структуры данных'),(2,7,'Функциональное программирование'),(3,7,'Основы системного программирования'),(4,7,'Объектно-ориентированное программирование 1'),(5,7,'Объектно-ориентирвоанное программирование 2'),(6,7,'Использование Python для работы с базой данных'),(7,7,'Основы взаимодействия в Интернет'),(8,7,'Использование библиотек Django для создания блога');
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
  `progress` float DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `users_courses_fk0` (`user_id`),
  KEY `users_courses_fk1` (`course_id`),
  CONSTRAINT `users_courses_fk0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `users_courses_fk1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_courses`
--

LOCK TABLES `users_courses` WRITE;
/*!40000 ALTER TABLE `users_courses` DISABLE KEYS */;
INSERT INTO `users_courses` (`id`, `user_id`, `course_id`, `start_date`, `end_date`, `start_score`, `end_score`, `rating`, `progress`) VALUES (1,1,5,'2017-05-06','2017-05-07',15,70,3,1),(2,1,6,'2017-05-07','2017-05-17',43.7,90,4,1),(3,1,7,'2017-05-01','2017-05-04',34.8,99.1,5,1),(4,1,8,'2017-05-04','2017-05-07',9.9,50,2,1),(5,2,2,'2017-05-05','2017-05-17',61.2,81,3,1),(6,2,5,'2017-05-02','2017-05-07',35.9,55.2,5,1),(7,2,6,'2017-05-05','2017-05-17',80.1,34,2,1),(8,2,7,'2017-05-02','2017-05-08',71.3,97.8,2,1),(9,2,8,'2017-05-04','2017-05-08',79,96.4,5,1),(10,3,2,'2017-05-04','2017-05-17',6.4,69,5,1),(11,3,5,'2017-05-01','2017-05-17',13.2,76,3,1),(12,3,7,'2017-05-17','2017-05-17',33,45,4,1),(13,3,8,'2017-05-17','2017-05-17',28,100,3,1),(14,4,2,'2017-05-04','2017-05-17',60,80,5,1),(15,4,5,'2017-05-05','2017-05-17',67,99,5,1),(16,4,6,'2017-05-02','2017-05-17',12,56,5,1),(17,4,8,'2017-05-19','2017-05-17',44,74,4,1),(18,5,2,'2017-05-03','2017-05-17',23,87,2,1),(19,5,5,'2017-05-06','2017-05-17',34,45,3,1),(20,5,7,'2017-05-04','2017-05-17',1,94,2,1),(21,5,8,'2017-05-07','2017-05-17',55,78,2,1),(22,2,9,'2017-05-04','2017-05-17',33,NULL,NULL,0.45),(23,4,7,'2017-05-18',NULL,NULL,NULL,NULL,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_keywords`
--

LOCK TABLES `users_keywords` WRITE;
/*!40000 ALTER TABLE `users_keywords` DISABLE KEYS */;
INSERT INTO `users_keywords` (`id`, `user_id`, `keyword_id`) VALUES (3,2,2),(4,2,3),(5,2,5),(6,2,7),(7,3,3),(8,3,5),(9,3,7),(10,4,1),(11,4,2),(12,4,5),(13,4,7);
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

-- Dump completed on 2017-05-18 22:57:11
