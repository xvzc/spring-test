DROP TABLE IF EXISTS `user`;
DROP TABLE IF EXISTS `post`;
DROP TABLE IF EXISTS `board`;

CREATE TABLE IF NOT EXISTS `users`
(
    `id`      BIGINT       NOT NULL AUTO_INCREMENT,
    `name`    VARCHAR(191) NOT NULL,
    `email`   VARCHAR(191) NOT NULL,
    `picture` VARCHAR(191) NOT NULL,
    `role`    VARCHAR(191) NOT NULL DEFAULT 'USER',
    `last_login` TIMESTAMP  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `deleted` VARCHAR(1) NOT NULL DEFAULT 'N',
    PRIMARY KEY (`id`),
    UNIQUE (`name`),
    UNIQUE (`email`)
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