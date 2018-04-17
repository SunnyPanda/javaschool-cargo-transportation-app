insert into orders (id, unique_number, status) values (1, 1, 1);
insert into orders (id, unique_number, status) values (2, 2, 1);
insert into orders (id, unique_number, status) values (3, 3, 1);
insert into orders (id, unique_number, status) values (4, 4, 1);
insert into orders (id, unique_number, status) values (5, 5, 1);
insert into orders (id, unique_number, status) values (6, 6, 1);
insert into orders (id, unique_number, status) values (7, 7, 1);
insert into orders (id, unique_number, status) values (8, 8, 1);
insert into orders (id, unique_number, status) values (9, 9, 1);
insert into orders (id, unique_number, status) values (10, 10, 1);

insert into cities (id, city_name) values (1, 'Астрахань');
insert into cities (id, city_name) values (2, 'Москва');
insert into cities (id, city_name) values (3, 'Санкт-Петрбург');
insert into cities (id, city_name) values (4, 'Воронеж');
insert into cities (id, city_name) values (5, 'Казань');
insert into cities (id, city_name) values (6, 'Иркутск');
insert into cities (id, city_name) values (7, 'Калининград');
insert into cities (id, city_name) values (8, 'Владивосток');
insert into cities (id, city_name) values (9, 'Пермь');
insert into cities (id, city_name) values (10, 'Краснодар');

insert into cargo (id, cargo_number, cargo_name, weight, status) values (1, 0001, 'Коробочка', 34, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (2, 0002, 'Бутылки', 13, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (3, 0003, 'Машинка', 3, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (4, 0004, 'Стол', 30, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (5, 0005, 'Пакет акций Apple', 1, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (6, 0006, 'Кухня', 5, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (7, 0007, 'Шкаф', 3, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (8, 0008, 'Пачка чипсов', 5, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (9, 0009, 'Слоник', 10, 0);
insert into cargo (id, cargo_number, cargo_name, weight, status) values (10, 0010, 'Черепашка', 50, 0);

insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (1, 1, 1, 1, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (2, 2, 1, 1, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (3, 2, 2, 2, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (4, 3, 2, 2, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (5, 3, 3, 3, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (6, 4, 3, 3, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (7, 4, 4, 4, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (8, 5, 4, 4, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (9, 5, 5, 5, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (10, 6, 5, 5, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (11, 6, 6, 6, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (12, 7, 6, 6, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (13, 7, 7, 7, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (14, 8, 7, 7, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (15, 8, 8, 8, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (16, 9, 8, 8, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (17, 9, 9, 9, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (18, 10, 9, 9, 1);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (19, 10, 10, 10, 0);
insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (20, 1, 10, 10, 1);

insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (1, 'AA11111', 2, 35, 0, 1, 1);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (2, 'BB22222', 2, 100, 0, 2, 2);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (3, 'CC33333', 2, 3, 0, 3, 3);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (4, 'DD44444', 2, 76, 0, 4, 4);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (5, 'EE55555', 2, 200, 0, 5, 5);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (6, 'FF66666', 3, 40, 0, 6);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (7, 'GG77777', 3, 400, 0, 7);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (8, 'HH88888', 3, 23, 0, 8);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (9, 'II99999', 3, 34, 0, 9);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (10, 'JJ00000', 3, 11, 0, 10);


insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (1, 1, 'Аркадий', 'Исааков', 23, 1, 1, 1, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (2, 2, 'Вениамин', 'Пунктуальный', 46, 1, 1, 1, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (3, 3, 'Варвара', 'Полякова', 123, 1, 2, 2, 2);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (4, 4, 'Клюква', 'Песочная', 45, 1, 2, 2, 2);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (5, 5, 'Елена', 'Парная', 15, 1, 3, 3, 3);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (6, 6, 'Александр', 'Иванов', 23, 1, 3, 3, 3);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (7, 7, 'Кристина', 'Петрова', 46, 1, 4, 4, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (8, 8, 'Олег', 'Сидоров', 123, 1, 4, 4, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (9, 9, 'Виталий', 'Ольховский', 45, 1, 5, 5, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (10, 10, 'Андрэ', 'Фуэго', 15, 1, 5, 5, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (11, 11, 'Павел', 'Ильинский', 23, 0, 6);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (12, 12, 'Армен', 'Джигарханян', 46, 0, 7);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (13, 13, 'Тигран', 'Волков', 123, 0, 8);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (14, 14, 'Леонид', 'Андреев', 45, 0, 9);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (15, 15, 'Анатолий', 'Вассерман', 15, 0, 10);

insert into users (id, username, password, role) values (1, 'user', '$2a$11$Aax9HOQhqLshWpLZPeoiYe.EMjj4/RaSf5PCO2zcfdxtnarufc28K', 'ROLE_USER');
insert into users (id, username, password, role, driver_id) values (2, 'driver', '$2a$11$nmd5TT5fEkCiHaktsr5Gqe4L9bEiUa1Ektu7/dmp32FnRz.nZ/0Py', 'ROLE_DRIVER', 2);