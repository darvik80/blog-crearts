DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`          int(11)                                 NOT NULL AUTO_INCREMENT,
    `created_at`  datetime                                NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at`  datetime                                         DEFAULT NULL,
    `login`       varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
    `password`    varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
    `first_name`  varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
    `middle_name` varchar(128) COLLATE utf8mb4_unicode_ci          DEFAULT NULL,
    `last_name`   varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_created_at` (`created_at`),
    KEY `idx_login` (`login`),
    KEY `idx_first_last_middle_name` (`first_name`(64), `last_name`(64), `middle_name`(64))
);

DROP TABLE IF EXISTS `account`;
CREATE TABLE `account`
(
    `id`      int(11) NOT NULL AUTO_INCREMENT,
    `user_id` int(11) NOT NULL,
    `role_id`    int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_user_id` (`user_id`),
    KEY `idx_role` (`role_id`)
);

DROP TABLE IF EXISTS `account_role`;
CREATE TABLE `account_role`
(
    `id`   int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_role` (`name`)
);

DROP TABLE IF EXISTS `content`;
CREATE TABLE `content`
(
    `id`         int(11)                                 NOT NULL,
    `created_at` datetime                                NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` datetime                                         DEFAULT NULL,
    `type`       int(11)                                 NOT NULL DEFAULT '1',
    `title`      varchar(256) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'Title',
    `content`    longtext COLLATE utf8mb4_unicode_ci,
    `status`     int(11)                                 NOT NULL DEFAULT '1',
    PRIMARY KEY (`id`),
    KEY `idx_title` (`content`(64)),
    KEY `idx_type_status` (`type`, `status`),
    KEY `idx_created_at` (`created_at`)
);

DROP TABLE IF EXISTS `content_status`;
CREATE TABLE `content_status`
(
    `id`   int(11)                                NOT NULL AUTO_INCREMENT,
    `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_name` (`name`)
);

DROP TABLE IF EXISTS `content_type`;
CREATE TABLE `content_type`
(
    `id`   int(11)                                NOT NULL AUTO_INCREMENT,
    `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_name` (`name`)
);

DROP TABLE IF EXISTS `tag`;
CREATE TABLE `tag`
(
    `id`    int(11)                                NOT NULL AUTO_INCREMENT,
    `name`  varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
    `color` int(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_name_unique` (`name`)
);

DROP TABLE IF EXISTS `file`;
CREATE TABLE `file`
(
    `id`         int(11)  NOT NULL AUTO_INCREMENT,
    `created_at` datetime NOT NULL                       DEFAULT CURRENT_TIMESTAMP,
    `updated_at` datetime                                DEFAULT NULL,
    `file_name`  varchar(512) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `file_path`  tinytext COLLATE utf8mb4_unicode_ci,
    `mime_type`  int(11)                                 DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_created_at` (`created_at`),
    KEY `idx_file_name` (`file_name`),
    KEY `idx_mime_type` (`mime_type`)
);

DROP TABLE IF EXISTS `mime_type`;
CREATE TABLE `mime_type`
(
    `id`   int(11)                                NOT NULL AUTO_INCREMENT,
    `name` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idx_name_unique` (`name`)
);

DROP TABLE IF EXISTS `link_content_user`;
CREATE TABLE `link_content_user`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `content_id` int(11) NOT NULL,
    `user_id`    int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_content_id` (`content_id`),
    KEY `idx_user_id` (`user_id`)
);

DROP TABLE IF EXISTS `link_content_tag`;
CREATE TABLE `link_content_tag`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `content_id` int(11) NOT NULL,
    `tag_id`     int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_content_id` (`content_id`),
    KEY `idx_tag_id` (`tag_id`)
);

DROP TABLE IF EXISTS `link_content_file`;
CREATE TABLE `link_content_file`
(
    `id`         int(11) NOT NULL AUTO_INCREMENT,
    `content_id` int(11) NOT NULL,
    `file_id`    int(11) NOT NULL,
    PRIMARY KEY (`id`),
    KEY `idx_content_id` (`content_id`),
    KEY `idx_file_id` (`file_id`)
);
