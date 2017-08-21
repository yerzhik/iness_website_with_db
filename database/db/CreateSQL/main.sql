CREATE TABLE bb_abstracts (
    id SERIAL NOT NULL,
    numeration VARCHAR DEFAULT '0',
    author VARCHAR,
    topic VARCHAR,
    is_oral BOOL,
    start_day VARCHAR,
    start_time VARCHAR,
    room_number VARCHAR,
    abstract_text VARCHAR,
    img VARCHAR DEFAULT 'img/default.png',
PRIMARY KEY(id));