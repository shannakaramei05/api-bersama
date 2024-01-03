use api_bersama;

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

update venues set user_id =3 where venue_id=1;
#
# INSERT INTO Venues (venue_id,name, phone, address)
# VALUES (3,'Venue 2', '987-654-3210', '456 Oak Avenue');

INSERT INTO users (email, name, password, role)
VALUES ('USERMANIAC@email.com', 'SportBoy', 'password@', 'USER');

INSERT INTO users (email, name, password, role)
VALUES ('OWNER@email.com', 'RIch Guy', 'password@', 'OWNER');

INSERT INTO users (email, name, password, role)
VALUES ('OWNER2@email.com', 'Cool Guy ', 'password@', 'OWNER');