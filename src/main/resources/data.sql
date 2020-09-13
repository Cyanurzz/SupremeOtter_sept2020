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

INSERT INTO tag(key_tag, name) VALUES
('GAME', 'blobfish for breakfast'),
('GAME', 'hitlama'),
('DESCRIPTOR','violence'),
('DESCRIPTOR','bad language'),
('DESCRIPTOR','fear'),
('DESCRIPTOR','gamebling'),
('DESCRIPTOR','sex'),
('DESCRIPTOR','drugs'),
('DESCRIPTOR','discrimination'),
('GENDER','action'),
('GENDER','combat'),
('GENDER','beat them all'),
('GENDER','tir'),
('GENDER','shoot them up'),
('GENDER','fps'),
('GENDER','tps'),
('GENDER','rail shooter'),
('GENDER','Adventure'),
('PLATFORM','linux'),
('PLATFORM','mac osx'),
('PLATFORM','windows'),
('PLATFORM','nintendo switch'),
('PLATFORM','nintendo 3ds'),
('PLATFORM','playstation 4'),
('PLATFORM','xbox One'),
('PLATFORM','android'),
('PLATFORM','ios');

INSERT INTO user (id, username, firstname, lastname, password, email, role) VALUES
(1, 'Otter', 'Jean', 'Ducellier', '$2a$10$k.gGzFaNHZWqtK1/Rlacj.e7S1xHhH0QgA5zEqg8zWx6C0qSjluE.', 'supreme.otter@gmail.com', 'SUPERADMIN'),
(2, 'Zlat', 'Abeal', 'lity', '$2a$10$Bnu9Lwwk.BMyeGF1h4VLXeRTFZ459ZctxJcP4QWXegpheuSlxTF2S', 'a@gmail.com', 'SUPERADMIN');