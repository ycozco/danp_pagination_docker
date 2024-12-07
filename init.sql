CREATE TABLE pinturas (
    id SERIAL PRIMARY KEY,
    painting VARCHAR(255),
    artist VARCHAR(255),
    year_of_painting TEXT,
    adjusted_price TEXT,
    original_price TEXT,
    date_of_sale TEXT,
    year_of_sale INT,
    seller TEXT,
    buyer TEXT,
    auction_house TEXT,
    image TEXT,
    painting_wikipedia_profile TEXT,
    artist_wikipedia_profile TEXT,
    description TEXT,
    room INT
);

COPY pinturas (painting, artist, year_of_painting, adjusted_price, original_price, date_of_sale, year_of_sale, seller, buyer, auction_house, image, painting_wikipedia_profile, artist_wikipedia_profile, description)
FROM '/docker-entrypoint-initdb.d/paintings.csv'
CSV HEADER QUOTE '"' ESCAPE '"' NULL '';

-- Asignar valores aleatorios a "room" entre 1 y 6
UPDATE pinturas
SET room = (floor(random()*6)+1)::int;
