USER
CREATE TABLE `suptea`.`blog` (
    `id` int NOT NULL AUTO_INCREMENT,
    `user_id` int NOT NULL,
    `title` varchar(70) NOT NULL,
    `description` varchar(200) NOT NULL,
    `content` longtext NOT NULL,
    `created` datetime DEFAULT NULL,
    `state` int DEFAULT '0',
    `banner` varchar(200) DEFAULT 'https://unsplash.it/503/503/',
    `ctype` int DEFAULT '1',
    PRIMARY KEY (`id`,`title`),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `suptea`.`picture` (
    `id` int NOT NULL AUTO_INCREMENT,
    `url` varchar(200) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `suptea`.`users` (
    `id` int NOT NULL AUTO_INCREMENT,
    `account` varchar(45) NOT NULL,
    `name` varchar(45) NOT NULL,
    `gender` varchar(45) NOT NULL,
    `password` varchar(70) NOT NULL,
    `login_count` int DEFAULT '0',
    `last_login` datetime DEFAULT NULL,
    `avatar` varchar(200) DEFAULT NULL,
    `desck` varchar(200) DEFAULT NULL,
    `university` varchar(20) DEFAULT '山东大学',
    `major` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `account_UNIQUE` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



INSERT INTO `users` (`id`, `account`, `name`, `gender`, `password`, `login_count`) VALUES ('1', 'passwordis123456', 'MyName', '男', 'e10adc3949ba59abbe56e057f20f883e', '0');

