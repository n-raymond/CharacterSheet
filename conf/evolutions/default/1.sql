# --- !Ups


CREATE TABLE pokemons_stats(
    id SERIAL PRIMARY KEY,
    pv_base INT NOT NULL,
    pv_add INT NOT NULL,
    attack_base INT NOT NULL,
    attack_add INT NOT NULL,
    defense_base INT NOT NULL,
    defense_add INT NOT NULL,
    special_attack_base INT NOT NULL,
    special_attack_add INT NOT NULL,
    special_defense_base INT NOT NULL,
    special_defense_add INT NOT NULL,
    vitesse_base INT NOT NULL,
    vitesse_add INT NOT NULL
);


CREATE TABLE pokemons (
    id SERIAL PRIMARY KEY,
    pokemon VARCHAR NOT NULL,
    name VARCHAR NOT NULL,
    type VARCHAR NOT NULL,
    lvl INT NOT NULL,
    nature VARCHAR NOT NULL,
    sprite VARCHAR NOT NULL,
    stats_id INT NOT NULL REFERENCES pokemons_stats(id)
);


CREATE TABLE pokemons_attacks(
    id SERIAL PRIMARY KEY,
    pokemon_id INT NOT NULL REFERENCES pokemons(id),
    name VARCHAR NOT NULL
);




----- # Stats # -----

-- Tarsal
INSERT INTO pokemons_stats VALUES (0, 28, 2, 25, 0, 25, 1, 45, 2, 35, 1, 40, 2);

-- Prismillon
INSERT INTO pokemons_stats VALUES (1, 28, 2, 25, 0, 25, 1, 45, 2, 35, 1, 40, 2);





----- # Pokemons # -----

-- Tarsal
INSERT INTO pokemons VALUES (0, 'Tarsal', 'Gordon', 'Psy Fée', 6, 'Obstiné', 'Tarsal.png', 0);

-- Prismillon
INSERT INTO pokemons VALUES (1, 'Prismillon', 'Tartenpion', 'Insecte Vol', 15, 'Festif', 'Prismillon.png', 1);



----- # Attacks # -----

-- Tarsal
INSERT INTO pokemons_attacks VALUES (0, 0, 'Rugissement');
INSERT INTO pokemons_attacks VALUES (1, 0, 'Choc Mental');

-- Prismillon
INSERT INTO pokemons_attacks VALUES (2, 1, 'Mur Lumière');
INSERT INTO pokemons_attacks VALUES (3, 1, 'Nuée de Poudre');
INSERT INTO pokemons_attacks VALUES (4, 1, 'Para-Spore');
INSERT INTO pokemons_attacks VALUES (5, 1, 'Poudre Dodo');
INSERT INTO pokemons_attacks VALUES (6, 1, 'Poudre Toxik');
INSERT INTO pokemons_attacks VALUES (7, 1, 'Tornade');
INSERT INTO pokemons_attacks VALUES (8, 1, 'Survinsecte');




# --- !Downs

DROP TABLE pokemons_attacks;
DROP TABLE pokemons;
DROP TABLE pokemons_stats;
