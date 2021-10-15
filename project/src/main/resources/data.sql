INSERT INTO `users` (`username`, `password`, `nickname`, `bio`, `email`)
VALUES ('user01', 'PaSsWoRd01', 'nick01', 'Hello Wolrd!', 'user01@email.com'),
       ('user02', 'PaSsWoRd02', 'nick02', 'In the end, we all felt like we ate too much.', 'user02@email.com'),
       ('user03', 'PaSsWoRd03', 'nick03', 'The quick brown fox jumps over the lazy dog', 'user03@email.com'),
       ('user04', 'PaSsWoRd04', 'nick04', 'This is an example bio', 'user04@email.com');

INSERT INTO `boards` (`name`)
VALUES ('IT/Tech'),
       ('Life'),
       ('Music'),
       ('Game');

INSERT INTO `posts` (`boards_id`, `users_id`, `title`, `content`)
VALUES (1, 1, 'What do i put on the title?', 'ABCDEFG'),
       (2, 2, 'Example title', 'Sample post content'),
       (4, 3, 'This is an example post title', 'The only question is how new technologies will allow people to more easily communicate and network with eachother on a global scale.'),
       (3, 4, 'I want to eat banana.', 'Seriously, I really want to eat banana right now.'),
       (2, 3, 'Do you remember me?', 'No?'),
       (1, 2, 'Hello world!', 'Hello hello hello hello world world world.'),
       (1, 1, 'Sample post title3', 'This is a sample post'),
       (2, 2, 'let it go', 'let it go~'),
       (3, 3, 'Can someone please help me', 'please'),
       (2, 4, 'I want to tell you about a cat story', 'The cat stretched.'),
       (4, 3, 'She opened the door and ..', 'Closed the door.');
