INSERT INTO platform (name) VALUES 
('Linux'),
('Mac Osx'),
('Windows'),
('Nintendo Switch'),
('Nintendo 3DS'),
('Playstation 4'),
('Xbox One'),
('Android'),
('IOS');

INSERT INTO gender (name) VALUES 
('Action'),
('Combat'),
('Beat them All'),
('Tir'),
('Shoot them up'),
('FPS'),
('TPS'),
('Rail Shooter'),
('Adventure');

INSERT INTO descriptor (name) VALUES 
('Violence'),
('Bad Language'),
('Fear'),
('Gamebling'),
('Sex'),
('Drugs'),
('Discrimination');

INSERT INTO game (title, release_date, classification) VALUES
('BlobFish for Breakfast', '2666-01-28', 18);

INSERT INTO platform_game(game_id, platform_id) VALUES
(1, 3),
(1, 6),
(1, 7);

INSERT INTO descriptors_game(game_id, descriptor_id) VALUES
(1, 1),
(1, 2),
(1, 3),
(1, 5),
(1, 6);

INSERT INTO gender_game(game_id, gender_id) VALUES
(1, 1),
(1, 4),
(1, 6),
(1, 2);

INSERT INTO languages (id, locale, messagekey,messagecontent) VALUES
(1, 'en', 'home.welcome','Welcome'),
(2, 'en', 'home.info','This page is displayed in English.'),
(3, 'en', 'home.changelanguage','English'),
(4, 'en', 'home.lang.en','English'),
(5, 'en', 'home.lang.mrl','Murloc'),
(26, 'en', 'home.lang.sq','Squanch'),
(7, 'en', 'home.lang.fr','French'),

(8, 'mrl', 'home.welcome','mrglmrlgmglgllrmg'),
(9, 'mrl', 'home.info','Mrlg mlrgglrlrlgl mrlgmrlgmmrlgmggl  rlgmrgl .'),
(10, 'mrl', 'home.changelanguage','Mgrlgrl'),
(11, 'mrl', 'home.lang.en','mlrglglgr'),
(12, 'mrl', 'home.lang.mrl','Mrlglrmlgr'),
(28, 'mrl', 'home.lang.sq','Mrgrlgrlgrr'),
(13, 'mrl', 'home.lang.fr','Mglrlrl'),

(14, 'fr', 'home.welcome','Bienvenue'),
(15, 'fr', 'home.info','Cette page est écrite en français.'),
(16, 'fr', 'home.changelanguage','Français'),
(17, 'fr', 'home.lang.en','Anglais'),
(18, 'fr', 'home.lang.mrl','Murloc'),
(27, 'fr', 'home.lang.sq','Squanch'),
(19, 'fr', 'home.lang.fr','Français'),

(20, 'sq', 'home.welcome','Weclome'),
(21, 'sq', 'home.info','This page is squanched in Squanch.'),
(22, 'sq', 'home.changelanguage','Squanch'),
(23, 'sq', 'home.lang.en','English'),
(24, 'sq', 'home.lang.mrl','Murloc'),
(25, 'sq', 'home.lang.sq','Squanch'),
(29, 'sq', 'home.lang.fr','French');