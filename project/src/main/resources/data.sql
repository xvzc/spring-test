INSERT INTO `users` (`name`, `email`, `picture`)
VALUES ('angel134', 'angel@email.com', ''),
       ('bubbles', 'bubbles@email.com', ''),
       ('shimmer', 'shimmer@email.com', ''),
       ('pretty372','pretty@email.com', ''),
       ('tank-boy', 'tank-boy@email.com', ''),
       ('cooandcoo', 'coo@email.com', ''),
       ('dollydolly', 'dolly@email.com', ''),
       ('polymoly', 'pmpm@email.com', ''),
       ('honeyman', 'hon090@email.com', '')
       ;

INSERT INTO `boards` (`name`)
VALUES ('IT/Tech'),
       ('Life'),
       ('Music'),
       ('Games'),
       ('Movies'),
       ('Sports'),
       ('Books'),
       ('Food')
       ;

INSERT INTO `posts` (`boards_id`, `users_id`, `title`, `content`)
VALUES (1, 1, 'What do i put on the title?', 'ABCDEFG'),
       (2, 2, 'Example title', 'Sample post content'),
       (3, 3, 'This is an example post title', 'The only question is how new technologies will allow people to more easily communicate and network with eachother on a global scale.'),
       (4, 4, 'I want to eat banana.', 'Seriously, I really want to eat banana right now.'),
       (5, 3, 'Do you remember me?', 'No?'),
       (5, 2, 'Hello world!', 'Hello hello hello hello world world world.'),
       (5, 1, 'Sample post title3', 'This is a sample post'),
       (1, 2, 'let it go', 'let it go~'),
       (2, 3, 'Can someone please help me', 'please'),
       (2, 4, 'I want to tell you about a cat story', 'The cat stretched.'),
       (8, 3, '26 Seriously Useful Baking Tips You’ll Wish You Knew About Sooner', 'no content'),
       (6, 3, '4 Habits of Exceptionally Likable People', 'Trending on Medium (when I wrote this), it speaks to all of us. Because we all think we’re likable. Again you see an adverb, a number, and a relationship you.'),
       (7, 3, 'The Harmless Habits That May Cause Cancer', 'nothing'),
       (8, 3, 'Read At Your Level', 'If you want to learn a language by reading, you’ve got to read at your level.'),
       (7, 3, 'Focus On The Plot', 'As Steven Krashen says: “We acquire language when we understand messages, when we understand what people tell us and when we understand what we read.”'),
       (1, 3, 'Door Closed, Phone Off', 'The deeper you focus, the more you learn, and that makes it critical that when you do sit down to study, you should do everything you can to focus on reading the story and understanding as much as you can'),
       (2, 3, 'Learn The Script', 'As human beings who crave certainty, it can be a really stressful experience when there are words we don’t understand.'),
       (3, 3, 'Listen While Reading', 'Listen okay?'),
       (4, 3, 'Read It, Then Read It Again!', 'Till u die'),
       (5, 3, 'Wear shoes.', 'Ever drop a knife? Imagine that going into your foot. Ouch! Wearing shoes while you cook is always recommended. '),
       (6, 3, 'Learn how to extinguish a fire.', 'There are roughly 164,500 residential cooking fires in the United States each year. Cooking is the leading cause of fires and injuries that occur in our homes.'),
       (7, 3, 'Learn how to use knives.', 'A dull knife is more likely to slip and cut you than a sharp knife. Keeping your knives sharpened is one of the easiest ways to keep them safe. '),
       (8, 3, 'Wear safe clothing.', 'Do not wear long, baggy sleeves in the kitchen. Can you imagine your sleeve catching fire on a gas stove? The outcome could be scary. '),
       (4, 3, 'Prevent burns.', 'Make sure when cooking that the handles of your pots and pans are turned inward.'),
       (4, 3, 'Always wash your hands.', 'You would think this is a given, but people forget. Don’t forget. It’s important to wash your hands in hot soapy water before and after cooking. '),
       (8, 3, 'Always stir and lift away from you.', 'When lifting a lid on a pot there is condensation on the top. When lifting it off toward you, the scalding condensation can drip onto your skin, causing burns'),
       (1, 3, 'Don’t set a hot glass dish on a wet or cold surface.', 'There’s actually a lot of science behind this tip. Glass expands when it gets warm and shrinks when it cools down, which causes stress, resulting in a combustion of glass.'),
       (2, 3, 'Don’t use metal utensils on nonstick, Teflon pans.', 'Cooking with metal utensils on Teflon or non-stick pans can cause flaking or chipping of the Teflon. '),
       (3, 3, '10. Don’t use the same cutting board for raw meat, fruits and vegetables.', 'We all want to avoid washing extra dishes, but this is one area in which you shouldn’t take shortcuts.')
       ;
