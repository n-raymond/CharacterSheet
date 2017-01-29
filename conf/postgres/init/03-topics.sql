

------ # Tables # ------

CREATE TABLE characters(
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    link VARCHAR NOT NULL,
    color VARCHAR NOT NULL
);

CREATE TABLE chapters(
    id SERIAL PRIMARY KEY,
    name VARCHAR NOT NULL,
    title VARCHAR NOT NULL,
    subject VARCHAR NOT NULL,
    summary VARCHAR(500) NOT NULL,
    image VARCHAR NOT NULL
);


CREATE TABLE topics(
    id SERIAL PRIMARY KEY,
    chapter_id INT NOT NULL REFERENCES chapters(id),
    name VARCHAR NOT NULL,
    link VARCHAR NOT NULL,
    status VARCHAR NOT NULL,
    -- featuring can be NULL for solo topic --
    featuring INT REFERENCES characters(id)
);



------ # characters # -------

-- Astrid
INSERT INTO characters VALUES (0, 'Astrid de Valnor', 'http://master-poke.forumactif.fr/t8288-astrid-de-valnor', '#ffffff');

-- Maelys
INSERT INTO characters VALUES (1, 'Maelys Sena', 'http://master-poke.forumactif.fr/t4130-maelys-sena#44028', '#ffffff');




------ # chapters # -------

-- planA
INSERT INTO chapters VALUES (
    0,
    'A',
    'Home Sweet Home',
    'Où l''on meurt puis l''on vit.',
    'Incomprehensions. Pertes de contrôle et joies mesquines. Prises de risques. Conséquences. Bras de fers et poigne d''acier. Le petit orteil, celui qui fait bien mal. Des outils bien gardés. De l''eau oui, du thé non.',
    'HomeSweetHome.png'
);

-- planB
INSERT INTO chapters VALUES (
    1,
    'B',
    'Stayin'' Alive',
    'Où l''on tente de rattrapper les pôts cassés.',
    'Apparition d''une bestiole peu sympatique. La gravité, cette traitresse. Des ennuis. Encore des ennuis. Drôle de manière de dormir. Dormir ? Pourquoi faire ? De l''art d''arriver en retard.',
    'StayinAlive.png'
);




------ # topics # ------

-- Jails and Queen
INSERT INTO topics VALUES (
    0,
    0,
    'Jails and Queen',
    'http://master-poke.forumactif.fr/t9395-jails-and-queen',
    'done',
    NULL
);

-- Prise la main dans le sac
INSERT INTO topics VALUES (
    1,
    0,
    'Prise la main dans le sac !',
    'http://master-poke.forumactif.fr/t10658-prise-la-main-dans-le-sac',
    'done',
    0
);

-- The neighboor below
INSERT INTO topics VALUES (
    2,
    0,
    'The neighboor below',
    'http://master-poke.forumactif.fr/t10755-the-neighboor-below',
    'doing',
    1
);

INSERT INTO topics VALUES (
    3,
    1,
    'De festives retrouvailles',
    'http://master-poke.forumactif.fr/t13758-de-festives-retrouvailles#241832',
    'doing',
    0
);
