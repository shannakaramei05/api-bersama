use api_bersama;

SELECT * FROM users;
SELECT * FROM fields;
SELECT * FROM venues;
SELECT * FROM bookings;

delete from bookings where booking_id=2;

update bookings set user_id=1 where booking_id=1;
# UPDATE venues SET user_id =1 WHERE venue_id=1;
# insert into venues(venue_id,address, name, phone,user_id) VALUE (1,'Jln Merdeka','Brave Sport Stadion','0000000',2);
# insert into fields(field_id, name, type, venue_id) VALUE (1,'Baka Mini Soccers','MINISOCCER',1);

# INSERT INTO Venues (venue_id,name, phone, address,user_id)
# VALUES (2,'BakaSport', '123-456-7890', '123 Main Street',52);
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
VALUES (2,'2023-12-07T14:00:00', '2023-12-07T16:00:00', 1, 1);
INSERT INTO bookings (booking_id, play_date_end, play_date_start, field_id, user_id)
VALUES (3,'2023-12-03T14:00:00', '2023-12-03T16:00:00', 2, 2);

INSERT INTO users (user_id, email, password, role, created_date)
VALUES (2, 'test@email.com', 'test', 'USER', UNIX_TIMESTAMP(NOW()));