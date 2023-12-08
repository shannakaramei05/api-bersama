use test_api_bersama;

SELECT * FROM users;
SELECT * FROM fields;
SELECT * FROM venues;
SELECT * FROM bookings;
SELECT * FROM users_has_bookings;

# delete from bookings where booking_id=2;


insert into venues (venue_id, address, name, phone, user_id) VALUE (3,'Jln Pahlawan','Brave Sport Stadion','0000000',2);

# update fields set venue_id=1 where field_id=1;
# UPDATE venues SET user_id =1 WHERE venue_id=1;
# insert into venues(venue_id,address, name, phone,user_id) VALUE (1,'Jln Merdeka','Brave Sport Stadion','0000000',2);
insert into fields(id, name, type, venue_id) VALUE (1,'Baka Mini Soccers','MINISOCCER',1);

INSERT INTO Venues (venue_id, address, name, phone, user_id)
VALUES (1,'BakaSport', '123 Main Street', '123-456-7890',1);
#
# INSERT INTO Venues (venue_id,name, phone, address)
# VALUES (3,'Venue 2', '987-654-3210', '456 Oak Avenue');

INSERT INTO Fields (field_id,name, type, venue_id)
VALUES (2,'Field 1', 'FOOTBALL', 1);

INSERT INTO Fields (field_id,name, type, venue_id)
VALUES (3,'Field 2', 'BADMINTON', 1);

INSERT INTO Fields (field_id,name, type, venue_id)
VALUES (4,'Field 3', 'FOOTBALL', 2);

INSERT INTO bookings (booking_id, play_date_end, play_date_start, field_id, user_id)
VALUES (1,'2023-12-03T14:00:00', '2023-12-03T16:00:00', 1, 2);

INSERT INTO bookings (booking_id, play_date_end, play_date_start, field_id, user_id)
VALUES (3,'2023-12-10T23:00:00', '2023-12-10T23:00:00', 1, 1);
INSERT INTO bookings (booking_id, play_date_end, play_date_start, field_id, user_id)
VALUES (3,'2023-12-03T13:00:00', '2023-12-03T16:00:00', 2, 2);

INSERT INTO users (email, name, password, role)
VALUES ('USERMANIAC@email.com', 'SportBoy', 'password@', 'USER');