
INSERT INTO user (id, username, firstname, lastname, password, email, role) VALUES
(1, 'Otter', 'Jean', 'Ducellier', '$2a$10$k.gGzFaNHZWqtK1/Rlacj.e7S1xHhH0QgA5zEqg8zWx6C0qSjluE.', 'supreme.otter@gmail.com', 'SUPERADMIN'),
(2, 'Zlat', 'Abeal', 'lity', '$2a$10$Bnu9Lwwk.BMyeGF1h4VLXeRTFZ459ZctxJcP4QWXegpheuSlxTF2S', 'a@gmail.com', 'SUPERADMIN');

INSERT INTO platform (name, img) VALUES 
('Linux', "/svg/platform/ubuntu.svg"),
('Mac Osx', "/svg/platform/apple.svg"),
('Windows', "/svg/platform/windows.svg"),
('Nintendo Switch', "/svg/platform/switch.svg"),
('Nintendo 3DS', "/svg/platform/3ds.svg"),
('Playstation 4', "/svg/platform/playstation.svg"),
('Xbox One', "/svg/platform/xbox.svg"),
('Android', "/svg/platform/android.svg"),
('IOS', "/svg/platform/ios.svg");

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

INSERT INTO descriptor (name, img) VALUES 
('Violence','/svg/pegi/descriptor/PEGI_Violence.svg'),
('Bad Language', '/svg/pegi/descriptor/PEGI_Bad_language.svg'),
('Fear', '/svg/pegi/descriptor/PEGI_Fear.svg'),
('Gamebling','/svg/pegi/descriptor/PEGI_Gambling.svg'),
('Sex', '/svg/pegi/descriptor/PEGI_Sex.svg'),
('Drugs', '/svg/pegi/descriptor/PEGI_Drugs.svg'),
('In Game Purchases', '/svg/pegi/descriptor/PEGI_In-Game-Purchases.svg'),
('Discrimination', '/svg/pegi/descriptor/PEGI_Discrimination.svg');

INSERT INTO tag(key_tag, name) VALUES
('PROJECT_TITAN', 'project titan'),
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

INSERT INTO game (title, subtitle, release_date, classification, banner, video, logo, description, main_game) VALUES
('BlobFish for Breakfast', null, '2666-01-28', 18,'https://www.zelda.com/breath-of-the-wild/assets/icons/BOTW-Share_icon.jpg', 'https://www.youtube.com/embed/UjzErwYntFs', '/img/Logo.png', "descr", true),
('HitLama', null, '666-01-28', 18,'https://www.actugaming.net/wp-content/uploads/2019/06/trover-saves-the-universe-illu-test.jpg','https://www.youtube.com/embed/kopoLzvh5jY', null, "descr", true);

INSERT INTO article (title, user_id, game_id, content, banner, release_date) VALUES
('Hello Universe!', 1,null, "We are so proud to show us our new website, at this point it is totally in french. Only this article is in English. I know i am bad guy ... But ! In few weeks we gona add internationnalization for most used langages as English, French, Murloc, Squanch.",'https://miro.medium.com/max/1024/0*4ty0Adbdg4dsVBo3.png','2020-09-01'),
('Blobfish for Breakfast au sommet !', 1, 1, "Merci pour cette acceuil du tonerres ! dejà plus de 1000 récompenses ! alors que le jeux sort dans plus de 600 ans ! Un grand merci votre soutient compte énormément pour nous !!!",'https://www.mariomayhem.com/consoles/cube/mario_sunshine-2.jpg','2666-01-28'),
('[MàJ]1.14 Update Hitlama !', 1, 2, "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry ,s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.", 'https://gangsterrobotllama.weebly.com/uploads/5/2/1/9/52195401/7973050_orig.jpg','2020-10-22'),
('Nouvelle Inutile', 1, null, "Aujourd'hui j'ai bue mon verre d'eau de travers ",'https://file1.topsante.com/var/topsante/storage/images/medecine/troubles-cardiovasculaires/infarctus/prevenir/boire-3-tasses-de-the-par-jour-est-bon-pour-le-caeur-23753/166534-1-fre-FR/Boire-3-tasses-de-the-par-jour-est-bon-pour-le-caeur.jpg?alias=original','020-09-17'),
('Mocked Article on Blobfish', 1, 1, "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Lorem Ipsum is that it has a more-or-less normal distribution of letters, as opposed to using 'Content here, content here', making it look like readable English. Many desktop publishing packages and web page editors now use Lorem Ipsum as their default model text, and a search for 'lorem ipsum' will uncover many web sites still in their infancy. Various versions have evolved over the years, sometimes by accident, sometimes on purpose (injected humour and the like).",'https://i.skyrock.net/2717/95542717/pics/3284060702_1_3_9fOorSbB.jpg','2020-09-02'),
('another Mocked Article on Blobfish', 1, 1, "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old. Richard McClintock, a Latin professor at Hampden-Sydney College in Virginia, looked up one of the more obscure Latin words, consectetur, from a Lorem Ipsum passage, and going through the cites of the word in classical literature, discovered the undoubtable source. Lorem Ipsum comes from sections 1.10.32 and 1.10.33 of de Finibus Bonorum et Malorum (The Extremes of Good and Evil) by Cicero, written in 45 BC. This book is a treatise on the theory of ethics, very popular during the Renaissance. The first line of Lorem Ipsum, Lorem ipsum dolor sit amet.., comes from a line in section 1.10.32. The standard chunk of Lorem Ipsum used since the 1500s is reproduced below for those interested. Sections 1.10.32 and 1.10.33 from de Finibus Bonorum et Malorum by Cicero are also reproduced in their exact original form, accompanied by English versions from the 1914 translation by H. Rackham.",'https://cdnb.artstation.com/p/assets/images/images/017/769/915/large/daniel-stockbridge-blobfishking2-colored.jpg?1557271998','2020-10-03');

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

INSERT INTO tag_article(tag_id, article_id) VALUES
(1, 1),
(1, 4),
(2, 2),
(2, 5),
(2, 6),
(3, 3);


