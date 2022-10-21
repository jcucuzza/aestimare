CREATE TABLE drawings (
    id SERIAL primary key,
    draw_date Date,
    draw_date_epoch BIGINT,
    winning_numbers TEXT,
    multiplier NUMBER 
);