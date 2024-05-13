CREATE DATABASE sys_smartrash;

USE sys_smartrash;

CREATE TABLE Community (
  community_id INT PRIMARY KEY AUTO_INCREMENT,
  community_name VARCHAR(255) NOT NULL
);

CREATE TABLE User (
  user_id INT PRIMARY KEY AUTO_INCREMENT,
  dni VARCHAR(8) UNIQUE NOT NULL,
  name VARCHAR(255)  NOT NULL,
  last_name VARCHAR(255) NULL,
  address VARCHAR(255) NULL,
  email VARCHAR(20) UNIQUE not NULL,
  phone_number VARCHAR(255) NULL,
  password VARBINARY(12) NULL,
  user_type ENUM('administrador', 'conductor', 'residente') NOT NULL,
  community_id INT NOT NULL,
  FOREIGN KEY (community_id) REFERENCES Community(community_id)
);

CREATE TABLE Truk (
  truk_id INT PRIMARY KEY AUTO_INCREMENT,
  plaque VARCHAR(20) UNIQUE NOT NULL,
  model VARCHAR(255) NULL,
  status ENUM('disponible', 'en_ruta', 'reparacion') NOT NULL
);


CREATE TABLE Assignment (
  assignment_id INT PRIMARY KEY AUTO_INCREMENT,
  user_id INT NOT NULL,
  truk_id INT NOT NULL,
  community_id INT NOT NULL,
  assignment_date DATE NOT NULL,
  assignment_hour TIME NOT NULL,
  FOREIGN KEY (user_id) REFERENCES user(user_id),
  FOREIGN KEY (truk_id) REFERENCES truk(truk_id),
  FOREIGN KEY (community_id) REFERENCES Community(community_id)
);

CREATE TABLE Notification (
  notification_id INT PRIMARY KEY AUTO_INCREMENT,
  truk_id INT NOT NULL,
  community_id INT NOT NULL,
  user_id INT NOT NULL,
  notification_date DATE NOT NULL,
  notification_hour TIME NOT NULL,
  message TEXT NULL,
  FOREIGN KEY (truk_id) REFERENCES truk(truk_id),
  FOREIGN KEY (community_id) REFERENCES community(community_id),
  FOREIGN KEY (user_id) REFERENCES user(user_id)
);

INSERT INTO Community(community_name) VALUES
("AA.HH. CESAR VALLEJO"),
("URB. LOS PINOS"),
("AA.HH. MIRAMAR BAJO"),
("AA.HH. MANUEL GONZALES PRADA");

INSERT INTO USER(dni,name,last_name, address,email, phone_number, password, user_type, community_id) VALUES
("11112222","Cesar","Valros","Paseo Los Olivos Mz J Lt 7","cvalros92@gmail.com","987654321","123","administrador",3),
("11113333","Test1","Rosval","Calle Olaya Mz Q Lt 9","Test1@gmail.com","987654111","123","conductor",1),
("11114444","Test2","Rosval","Calle Olaya Mz K Lt 2","Test2@gmail.com","987654222","123","conductor",1),
("11115555","Test3","Rosval","Jr Cahuide Mz T Lt 4","Test3@gmail.com","987654333","123","residente",2),
("11116666","Test4","Rosval","Calle Olaya Mz C Lt 3","Test4@gmail.com","98765444","123","residente",2),
("11117777","Test5","Rosval","Calle Olaya Mz S Lt 5","Test5@gmail.com","987654555","123","residente",2),
("11118888","Test6","Rosval","Calle Olaya Mz R Lt 8","Test6@gmail.com","987654666","123","residente",3),
("11119999","Test7","Rosval","Jr Cahuide Mz T Lt 1","Test7@gmail.com","987654777","123","residente",4),
("22223333","Test8","Rosval","Jr Abancay Mz L Lt 4","Test8@gmail.com","987654888","123","residente",4),
("22224444","Test9","Rosval","Av Buenos Aires Mz Z Lt 4","Test9@gmail.com","987654999","123","residente",4);


INSERT INTO Truk (plaque,model,status) VALUES
("ORG-123","8 M3 GARBAGE COMPACTOR / 2023","disponible"),
("XES-456","9 M2 GARBAGE COMPACTOR / 2021","disponible"),
("COM-987","4 M3 GARBAGE COMPACTOR / 2020","disponible");

SELECT user.user_id, user.email, user.phone_number, community.community_id, community.community_name
FROM community
INNER JOIN User ON community.community_id = User.community_id
WHERE community.community_id = '4';

INSERT INTO Assignment (user_id,truk_id,community_id,assignment_date,assignment_hour) VALUES
(2,1,1,"2024-05-15","09:00:00"),
(3,2,2,"2024-05-15","09:00:00");

SELECT * FROM COMMUNITY;
SELECT * FROM User;
SELECT * FROM truk;
SELECT * FROM Assignment;
SELECT * FROM Notification;

SELECT * FROM User WHERE community_id = '4';

SELECT * FROM user WHERE email = 'cvalros92@gmail.com' and password = '123';