-- user roles
INSERT INTO `account_role` (`id`, `name`) VALUES (1, 'admin');
INSERT INTO `account_role` (`id`, `name`) VALUES (2, 'standard');
INSERT INTO `account_role` (`id`, `name`) VALUES (3, 'guest');

-- default user & admin
INSERT INTO `user` (`id`, `login`, `password`, `first_name`, `last_name`) VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'admin');
INSERT INTO `account` (`id`, `user_id`, `role_id`) VALUES (1, 1, 1);

-- content tags
INSERT INTO `tag` (`id`, `name`, `color`) VALUES (1, 'dev', 0x81d8d0);
INSERT INTO `tag` (`id`, `name`, `color`) VALUES (2, 'java', 0x96c0eb);
INSERT INTO `tag` (`id`, `name`, `color`) VALUES (3, 'c++', 0x0a6ebd);
INSERT INTO `tag` (`id`, `name`, `color`) VALUES (4, 'arduino', 0x19adbd);
INSERT INTO `tag` (`id`, `name`, `color`) VALUES (5, 'raspberry', 0xc00a56);
INSERT INTO `tag` (`id`, `name`, `color`) VALUES (6, 'travel', 0xffd47f);
INSERT INTO `tag` (`id`, `name`, `color`) VALUES (7, 'vietnam', 0xff0000);

-- mime types
INSERT INTO `mime_type` (`id`, `name`) VALUES (1, 'image/png');
INSERT INTO `mime_type` (`id`, `name`) VALUES (2, 'image/jpeg');
INSERT INTO `mime_type` (`id`, `name`) VALUES (3, 'text/plain');
INSERT INTO `mime_type` (`id`, `name`) VALUES (4, 'text/html');
INSERT INTO `mime_type` (`id`, `name`) VALUES (5, 'application/octet-stream');

INSERT INTO `content` (`id`, `type`, `title`, `content`, `status`) VALUES (1, 1, "Hello World", "Hello every body fom my first article", 1);
INSERT INTO `content` (`id`, `type`, `title`, `content`, `status`) VALUES (2, 1, "Сказ о том, как Digital Ocean настраивал", "Hello every body fom my first article", 2);

INSERT INTO link_content_tag (`content_id`, `tag_id`) VALUES (1, 1);
INSERT INTO link_content_tag (`content_id`, `tag_id`) VALUES (1, 2);
INSERT INTO link_content_tag (`content_id`, `tag_id`) VALUES (1, 7);