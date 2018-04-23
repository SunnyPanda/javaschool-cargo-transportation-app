insert into orders (id, unique_number, status) values (1, 1234, 0);
insert into orders (id, unique_number, status) values (2, 2, 1);
insert into orders (id, unique_number, status) values (3, 3, 1);
insert into orders (id, unique_number, status) values (4, 4, 1);
insert into orders (id, unique_number, status) values (5, 5, 1);
-- insert into orders (id, unique_number, status) values (6, 6, 1);
-- insert into orders (id, unique_number, status) values (7, 7, 1);
-- insert into orders (id, unique_number, status) values (8, 8, 1);
-- insert into orders (id, unique_number, status) values (9, 9, 1);
-- insert into orders (id, unique_number, status) values (10, 10, 1);

insert into cities (id, city_name) values (1, 'Санкт-Петрбург');
insert into cities (id, city_name) values (2, 'Москва');
insert into cities (id, city_name) values (3, 'Владивосток');
insert into cities (id, city_name) values (4, 'Екатеринбург');
insert into cities (id, city_name) values (5, 'Уфа');
-- insert into cities (id, city_name) values (6, 'Пермь');
-- insert into cities (id, city_name) values (7, 'Калининград');
-- insert into cities (id, city_name) values (8, 'Владивосток');
-- insert into cities (id, city_name) values (9, 'Пермь');
-- insert into cities (id, city_name) values (10, 'Краснодар');

insert into map_distance (id, city_from_id, city_to_id, distance) values (1, 1, 2, 709);
insert into map_distance (id, city_from_id, city_to_id, distance) values (2, 1, 3, 9511);
insert into map_distance (id, city_from_id, city_to_id, distance) values (3, 1, 4, 2223);
insert into map_distance (id, city_from_id, city_to_id, distance) values (4, 1, 5, 2057);
insert into map_distance (id, city_from_id, city_to_id, distance) values (5, 2, 3, 9048);
insert into map_distance (id, city_from_id, city_to_id, distance) values (6, 2, 4, 1767);
insert into map_distance (id, city_from_id, city_to_id, distance) values (7, 2, 5, 1352);
insert into map_distance (id, city_from_id, city_to_id, distance) values (8, 3, 4, 7292);
insert into map_distance (id, city_from_id, city_to_id, distance) values (9, 3, 5, 7688);
insert into map_distance (id, city_from_id, city_to_id, distance) values (10, 4, 5, 511);

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
-- insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (9, 5, 5, 5, 0);
-- insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (10, 6, 5, 5, 1);
-- insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (11, 6, 6, 6, 0);
-- insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (12, 7, 6, 6, 1);
-- insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (13, 7, 7, 7, 0);
-- insert into waypoints (id, city_id, cargo_id, order_id, waypoint_type) values (14, 8, 7, 7, 1);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (9, 1, 8, 0);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (10, 4, 8, 1);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (11, 3, 9, 0);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (12, 2, 9, 1);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (13, 5, 10, 0);
insert into waypoints (id, city_id, cargo_id, waypoint_type) values (14, 1, 10, 1);

insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (1, 'AA11111', 2, 35, 0, 1, 1);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (2, 'BB22222', 1, 100, 0, 2, 2);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (3, 'CC33333', 1, 3, 0, 3, 3);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id, order_id) values (4, 'DD44444', 2, 76, 0, 4, 4);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (5, 'EE55555', 2, 200, 0, 5);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (6, 'FF66666', 3, 40, 0, 1);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (7, 'GG77777', 1, 400, 0, 2);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (8, 'HH88888', 1, 23, 0, 3);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (9, 'II99999', 3, 34, 0, 4);
insert into trucks (id, reg_number, shift_size, capacity, state, current_city_id) values (10, 'JJ00000', 3, 11, 0, 5);


insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (1, 1, 'Аркадий', 'Исааков', 23, 1, 1, 1, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (2, 2, 'Вениамин', 'Пунктуальный', 46, 1, 1, 1, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (3, 3, 'Варвара', 'Полякова', 123, 1, 2, 2, 2);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_truck_id, current_city_id, order_id) values (4, 4, 'Клюква', 'Песочная', 45, 1, 3, 3, 3);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (5, 5, 'Елена', 'Парная', 15, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (6, 6, 'Александр', 'Иванов', 23, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (7, 7, 'Кристина', 'Петрова', 46, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (8, 8, 'Олег', 'Сидоров', 123, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (9, 9, 'Виталий', 'Ольховский', 45, 0, 4);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (10, 10, 'Андрэ', 'Фуэго', 170, 0, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (11, 11, 'Павел', 'Ильинский', 23, 0, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (12, 12, 'Армен', 'Джигарханян', 46, 0, 5);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (13, 13, 'Тигран', 'Волков', 123, 0, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (14, 14, 'Леонид', 'Андреев', 45, 0, 1);
insert into drivers (id, personal_number, first_name, last_name, hours_per_month, status, current_city_id) values (15, 15, 'Анатолий', 'Вассерман', 15, 0, 2);

insert into users (id, username, password, role) values (1, 'user', '$2a$11$Aax9HOQhqLshWpLZPeoiYe.EMjj4/RaSf5PCO2zcfdxtnarufc28K', 'ROLE_USER');
insert into users (id, username, password, role, driver_id) values (2, 'driver1', '$2a$11$nmd5TT5fEkCiHaktsr5Gqe4L9bEiUa1Ektu7/dmp32FnRz.nZ/0Py', 'ROLE_DRIVER', 1);
insert into users (id, username, password, role, driver_id) values (3, 'driver2', '$2a$11$nmd5TT5fEkCiHaktsr5Gqe4L9bEiUa1Ektu7/dmp32FnRz.nZ/0Py', 'ROLE_DRIVER', 2);
insert into users (id, username, password, role, driver_id) values (4, 'driver3', '$2a$11$nmd5TT5fEkCiHaktsr5Gqe4L9bEiUa1Ektu7/dmp32FnRz.nZ/0Py', 'ROLE_DRIVER', 3);
insert into users (id, username, password, role, driver_id) values (5, 'driver4', '$2a$11$nmd5TT5fEkCiHaktsr5Gqe4L9bEiUa1Ektu7/dmp32FnRz.nZ/0Py', 'ROLE_DRIVER', 11);