DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `board`;

CREATE TABLE IF NOT EXISTS `users`
(
    `id`      BIGINT       NOT NULL AUTO_INCREMENT,
    `username`    VARCHAR(30)  NOT NULL,
    `password`      VARCHAR(512) NOT NULL,
    `nickname`    VARCHAR(30)  NOT NULL,
    `bio`     VARCHAR(512) NOT NULL,
    `email`   VARCHAR(191) NOT NULL,
    `created` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `deleted` VARCHAR(1) NOT NULL DEFAULT 'N',
    PRIMARY KEY (`id`),
    UNIQUE (`email`),
    UNIQUE (`username`),
    UNIQUE (`nickname`)
);

CREATE TABLE `boards`
(
    `id`   BIGINT       NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(191) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY (`name`)
);

CREATE TABLE `posts`
(
    `id`       BIGINT       NOT NULL AUTO_INCREMENT,
    `title`    VARCHAR(191) NOT NULL,
    `content`  TEXT         NOT NULL,
    `created`  TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `modified` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `boards_id` BIGINT       NOT NULL,
    `users_id`  BIGINT       NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`boards_id`) REFERENCES `boards` (`id`),
    FOREIGN KEY (`users_id`) REFERENCES `users` (`id`)
);