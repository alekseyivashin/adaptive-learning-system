-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: als_database
-- ------------------------------------------------------
-- Server version	5.7.18-log

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
  `rating` float DEFAULT '0',
  `user_count` int(11) DEFAULT '0',
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
INSERT INTO `courses` (`id`, `name`, `description`, `rating`, `user_count`, `level`) VALUES (2,'Введение в JavaScript','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',3.1,2,1),(5,'Введение в HTML и CSS','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',4.9,1,1),(6,'HTML5','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',1.7,3,2),(7,'Python. Начало','В этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',3.5,21,1),(8,'Python. Продолжение','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',4.1,1,2),(9,'Основы jQuery','Приветствую Вас на курсе!\nВ этом курсе мы разберем множество классных технологий, станем гуру программирования (нет), а также будем пробовать светоч среди технологий в образовании - адаптивное обучение!\nУдачи, и да прибудет с вами Python! И адаптивное обучение конечно.',3.1,4,2);
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
-- Table structure for table `lectures`
--

DROP TABLE IF EXISTS `lectures`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lectures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `theme_id` int(11) NOT NULL,
  `content` varchar(4000) NOT NULL,
  `level` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `learning_contents_fk0` (`theme_id`),
  CONSTRAINT `theme_fk0` FOREIGN KEY (`theme_id`) REFERENCES `themes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lectures`
--

LOCK TABLES `lectures` WRITE;
/*!40000 ALTER TABLE `lectures` DISABLE KEYS */;
INSERT INTO `lectures` (`id`, `theme_id`, `content`, `level`) VALUES (1,1,'Лекция 1-1',1100),(2,1,'Лекция 1-2',1460),(3,1,'Лекция 1-3',1910),(4,2,'Лекция 2-1',1220),(5,2,'Лекция 2-2',1390),(6,2,'Лекция 2-3',2000),(7,3,'Лекция 3-1',1180),(8,3,'Лекция 3-2',1560),(9,3,'Лекция 3-3',1840),(10,4,'Лекция 4-1',1430),(11,4,'Лекция 4-2',2010),(12,4,'Лекция 4-3',2250),(13,5,'Лекция 5-1',1370),(14,5,'Лекция 5-2',1540),(15,5,'Лекция 5-3',2390),(16,6,'Лекция 6-1',1650),(17,6,'Лекция 6-2',1780),(18,6,'Лекция 6-3',1930),(19,7,'Лекция 7-1',1740),(20,7,'Лекция 7-2',2030),(21,7,'Лекция 7-3',2500),(22,8,'Лекция 8-1',2000),(23,8,'Лекция 8-2',2370),(24,8,'Лекция 8-3',2620);
/*!40000 ALTER TABLE `lectures` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `questions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `lecture_id` int(11) DEFAULT NULL,
  `level` int(11) DEFAULT NULL,
  `content` varchar(200) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `questions_fk0` (`lecture_id`),
  CONSTRAINT `questions_fk0` FOREIGN KEY (`lecture_id`) REFERENCES `lectures` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` (`id`, `lecture_id`, `level`, `content`) VALUES (2,1,1100,'Какие версии Python являются несовместимыми по операциям ввода и вывода?'),(3,2,1460,'Каким образом можно получить 3 степень числа 5?'),(4,3,1910,'Для добавления элемента 4 в конец списка a=[1,2,3] можно использовать:'),(5,4,1220,'Для передачи в функцию кортежей и списков используется запись:'),(6,5,1390,'Для передачи в функцию словарей используется запись:'),(7,6,2000,'\nКаково основное отличие функций, описываемых с помощью def и lambda?'),(8,7,1180,'Метод rmdir используется для:'),(9,8,1560,'При повторной операции чтения read() из файла с текстом ‘абвгдеёжзик’  будет получено:'),(10,9,1840,'Для шифрования методом sha256 строка должна быть:'),(11,10,1430,'Каким образом возможно описать класс:'),(12,11,2010,'Дан класс \nclass A(object):\n	def __init__(self,x):\n	         self.x=x\n__init__ это'),(13,12,2250,'Дан класс и его экземпляр\nclass A(object):\n	def __init__(self,x):\n	          self.x=x\na=A()\nчто выдаст\nA.__dict__'),(14,13,1370,'Каким образом возможно создать итерируемый объект – итератор для списка:'),(15,14,1540,'После того, как итератор дойдет до конца данных он:'),(16,15,2390,'Итератор enumerate создает:'),(17,16,1650,'Каким образом возможно проверить версию API по работе с БД SQLite:'),(18,17,1780,'Можно ли использовать for к результатам запросов:'),(19,18,1930,'Для преобразования данных JSON в данные Python используется метод:'),(20,19,1740,'В каком формате выводится содержимое страниц, загруженных с использованием urllib.request.urlopen:'),(21,20,2030,'Для получения url адреса из составляющих можно использовать:'),(22,21,2500,'При создании сервера, используя модуль http.server и описании класса, унаследованного от BaseHTTPRequestHandler, в методе send_header прописываются:'),(23,22,2000,'Для установки Django требуемой версии (1.9) с использованием pip нужно записать:');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rating`
--

DROP TABLE IF EXISTS `rating`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rating` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_course` int(11) DEFAULT NULL,
  `common` int(11) DEFAULT NULL,
  `accuracy` int(11) DEFAULT NULL,
  `complexity` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rating_fk0` (`user_course`),
  CONSTRAINT `rating_fk0` FOREIGN KEY (`user_course`) REFERENCES `users_courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rating`
--

LOCK TABLES `rating` WRITE;
/*!40000 ALTER TABLE `rating` DISABLE KEYS */;
/*!40000 ALTER TABLE `rating` ENABLE KEYS */;
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
  `user_course_id` int(11) DEFAULT NULL,
  `lecture_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `tests_fk0` (`lecture_id`),
  KEY `tests_fk1` (`user_course_id`),
  CONSTRAINT `tests_fk0` FOREIGN KEY (`lecture_id`) REFERENCES `lectures` (`id`),
  CONSTRAINT `tests_fk1` FOREIGN KEY (`user_course_id`) REFERENCES `users_courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
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
  PRIMARY KEY (`id`),
  KEY `tests_questions_fk0` (`question_id`),
  KEY `tests_questions_fk1` (`test_id`),
  CONSTRAINT `tests_questions_fk0` FOREIGN KEY (`question_id`) REFERENCES `questions` (`id`),
  CONSTRAINT `tests_questions_fk1` FOREIGN KEY (`test_id`) REFERENCES `tests` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
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
-- Table structure for table `user_themes`
--

DROP TABLE IF EXISTS `user_themes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_themes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_course_id` int(11) DEFAULT NULL,
  `theme_id` int(11) DEFAULT NULL,
  `user_level` double DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_themes_id_uindex` (`id`),
  KEY `user_themes_fk0` (`user_course_id`),
  KEY `user_themes_fk1` (`theme_id`),
  CONSTRAINT `user_themes_fk0` FOREIGN KEY (`user_course_id`) REFERENCES `users_courses` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_themes_fk1` FOREIGN KEY (`theme_id`) REFERENCES `themes` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_themes`
--

LOCK TABLES `user_themes` WRITE;
/*!40000 ALTER TABLE `user_themes` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_themes` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
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
  `start_score` double DEFAULT NULL,
  `end_score` double DEFAULT NULL,
  `rating` int(11) DEFAULT NULL,
  `progress` double DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `users_courses_fk0` (`user_id`),
  KEY `users_courses_fk1` (`course_id`),
  CONSTRAINT `users_courses_fk0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
  CONSTRAINT `users_courses_fk1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users_courses`
--

LOCK TABLES `users_courses` WRITE;
/*!40000 ALTER TABLE `users_courses` DISABLE KEYS */;
INSERT INTO `users_courses` (`id`, `user_id`, `course_id`, `start_date`, `end_date`, `start_score`, `end_score`, `rating`, `progress`) VALUES (1,1,5,'2017-05-06','2017-05-07',15,70,3,1),(2,1,6,'2017-05-07','2017-05-17',43.70000076293945,90,4,1),(3,1,7,'2017-05-01','2017-05-04',34.79999923706055,99.0999984741211,5,1),(4,1,8,'2017-05-04','2017-05-07',9.899999618530273,50,2,1),(5,2,2,'2017-05-05','2017-05-17',61.20000076293945,81,3,1),(6,2,5,'2017-05-02','2017-05-07',35.900001525878906,55.20000076293945,5,1),(7,2,6,'2017-05-05','2017-05-17',80.0999984741211,34,2,1),(8,2,7,'2017-05-02','2017-05-08',71.30000305175781,97.80000305175781,2,1),(9,2,8,'2017-05-04','2017-05-08',79,96.4000015258789,5,1),(10,3,2,'2017-05-04','2017-05-17',6.400000095367432,69,5,1),(11,3,5,'2017-05-01','2017-05-17',13.199999809265137,76,3,1),(12,3,7,'2017-05-17','2017-05-17',33,45,4,1),(13,3,8,'2017-05-17','2017-05-17',28,100,3,1),(14,4,2,'2017-05-04','2017-05-17',60,80,5,1),(15,4,5,'2017-05-05','2017-05-17',67,99,5,1),(16,4,6,'2017-05-02','2017-05-17',12,56,5,1),(17,4,8,'2017-05-19','2017-05-17',44,74,4,1),(18,5,2,'2017-05-03','2017-05-17',23,87,2,1),(19,5,5,'2017-05-06','2017-05-17',34,45,3,1),(20,5,7,'2017-05-04','2017-05-17',1,94,2,1),(21,5,8,'2017-05-07','2017-05-17',55,78,2,1);
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
  CONSTRAINT `users_keywords_fk0` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `users_keywords_fk1` FOREIGN KEY (`keyword_id`) REFERENCES `keywords` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
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

-- Dump completed on 2017-06-01 17:43:21
