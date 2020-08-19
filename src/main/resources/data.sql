INSERT INTO platform (name, img) VALUES 
('Linux', "svg/platform/ubuntu.svg"),
('Mac Osx', "svg/platform/apple.svg"),
('Windows', "svg/platform/windows.svg"),
('Nintendo Switch', "svg/platform/switch.svg"),
('Nintendo 3DS', "svg/platform/3ds.svg"),
('Playstation 4', "svg/platform/playstation.svg"),
('Xbox One', "svg/platform/xbox.svg"),
('Android', "svg/platform/android.svg"),
('IOS', "svg/platform/ios.svg");

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
('BlobFish for Breakfast', '2666-01-28', 18),
('HitLama', '666-01-28', 18);

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

INSERT INTO tag(name) VALUES
('blobfish for breakfast'),
('hitlama'),
('violence'),
('bad language'),
('fear'),
('gamebling'),
('sex'),
('drugs'),
('discrimination'),
('action'),
('combat'),
('beat them all'),
('tir'),
('shoot them up'),
('fps'),
('tps'),
('rail shooter'),
('Adventure'),
('linux'),
('mac osx'),
('windows'),
('nintendo switch'),
('nintendo 3ds'),
('playstation 4'),
('xbox One'),
('android'),
('ios');