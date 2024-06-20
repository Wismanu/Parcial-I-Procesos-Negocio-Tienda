ALTER SEQUENCE domipension.userr_usr_code_seq RESTART WITH 20241;

INSERT INTO userr (usr_id_rol, usr_name, usr_dni, usr_phone) VALUES (1, 'Alice', '12345678A', '123-456-7890');
INSERT INTO userr (usr_id_rol, usr_name, usr_dni, usr_phone) VALUES (2, 'Bob', '23456789B', '234-567-8901');
INSERT INTO userr (usr_id_rol, usr_name, usr_dni, usr_phone) VALUES (1, 'Charlie', '34567890C', '345-678-9012');
INSERT INTO userr (usr_id_rol, usr_name, usr_dni, usr_phone) VALUES (3, 'David', '45678901D', '456-789-0123');
INSERT INTO userr (usr_id_rol, usr_name, usr_dni, usr_phone) VALUES (2, 'Eve', '56789012E', '567-890-1234');
INSERT INTO userr (usr_id_rol, usr_name, usr_dni, usr_phone) VALUES (3, 'Frank', '67890123F', '678-901-2345');
INSERT INTO userr (usr_id_rol, usr_name, usr_dni, usr_phone) VALUES (1, 'Grace', '78901234G', '789-012-3456');


INSERT INTO login (usr_code, login_username, login_password) VALUES (20241, 'alice123', 'password1');
INSERT INTO login (usr_code, login_username, login_password) VALUES (20242, 'bob234', 'password2');
INSERT INTO login (usr_code, login_username, login_password) VALUES (20243, 'charlie345', 'password3');
INSERT INTO login (usr_code, login_username, login_password) VALUES (20244, 'david456', 'password4');
INSERT INTO login (usr_code, login_username, login_password) VALUES (20245, 'eve567', 'password5');
INSERT INTO login (usr_code, login_username, login_password) VALUES (20246, 'frank678', 'password6');
INSERT INTO login (usr_code, login_username, login_password) VALUES (20247, 'grace789', 'password7');


