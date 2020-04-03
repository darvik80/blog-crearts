-- user roles
INSERT INTO `account_role` (`id`, `name`) VALUES (1, 'admin');
INSERT INTO `account_role` (`id`, `name`) VALUES (2, 'standard');
INSERT INTO `account_role` (`id`, `name`) VALUES (3, 'guest');

-- default user & admin
INSERT INTO `user` (`id`, `login`, `password`, `first_name`, `last_name`) VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'admin', 'admin');
INSERT INTO `account` (`id`, `user_id`, `role_id`) VALUES (1, 1, 1);

-- content
INSERT INTO `content_type` (`id`, `name`) VALUES (1, 'blog');
INSERT INTO `content_type` (`id`, `name`) VALUES (2, 'article');
-- content tags
INSERT INTO `tag` (`id`, `name`) VALUES (1, 'dev');
INSERT INTO `tag` (`id`, `name`) VALUES (2, 'java');
INSERT INTO `tag` (`id`, `name`) VALUES (3, 'c++');
INSERT INTO `tag` (`id`, `name`) VALUES (4, 'arduino');
INSERT INTO `tag` (`id`, `name`) VALUES (5, 'raspberry');
INSERT INTO `tag` (`id`, `name`) VALUES (6, 'travel');
INSERT INTO `tag` (`id`, `name`) VALUES (7, 'vietnam');
-- content status
INSERT INTO `content_status` (`id`, `name`) VALUES (1, 'Draft');
INSERT INTO `content_status` (`id`, `name`) VALUES (2, 'Pending');
INSERT INTO `content_status` (`id`, `name`) VALUES (3, 'Published');
INSERT INTO `content_status` (`id`, `name`) VALUES (4, 'Deleted');

-- mime types
INSERT INTO `mime_type` (`id`, `name`) VALUES (1, 'image/png');
INSERT INTO `mime_type` (`id`, `name`) VALUES (2, 'image/jpeg');
INSERT INTO `mime_type` (`id`, `name`) VALUES (3, 'text/plain');
INSERT INTO `mime_type` (`id`, `name`) VALUES (4, 'text/html');
INSERT INTO `mime_type` (`id`, `name`) VALUES (5, 'application/octet-stream');