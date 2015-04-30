USE AutoShow;

/*Country*/
INSERT INTO Country VALUES ('1', 'Russia');
INSERT INTO Country VALUES ('2', 'USA');
INSERT INTO Country VALUES ('3', 'UK');
INSERT INTO Country VALUES ('4', 'Germany');
INSERT INTO Country VALUES ('5', 'France');
INSERT INTO Country VALUES ('6', 'Japan');

/*City*/
INSERT INTO City VALUES ('1', 'Moscow', 1);
INSERT INTO City VALUES ('2', 'Saint Petersburg', 1);
INSERT INTO City VALUES ('3', 'New York', 2);
INSERT INTO City VALUES ('4', 'London', 3);
INSERT INTO City VALUES ('5', 'Tokio', 6);
INSERT INTO City VALUES ('6', 'Berlin', 4);
INSERT INTO City VALUES ('7', 'Paris', 5);

/*Colour*/
INSERT INTO Colour VALUES ('1', 'blue');
INSERT INTO Colour VALUES ('2', 'green');
INSERT INTO Colour VALUES ('3', 'red');
INSERT INTO Colour VALUES ('4', 'black');
INSERT INTO Colour VALUES ('5', 'white');

/*Material*/
INSERT INTO Material VALUES ('1', 'leather');
INSERT INTO Material VALUES ('2', 'velours');
INSERT INTO Material VALUES ('3', 'jacquard');
INSERT INTO Material VALUES ('4', 'faux leather');

/*Status*/
INSERT INTO `Status` VALUES ('1', 'in processing');
INSERT INTO `Status` VALUES ('2', 'waiting for delivery');
INSERT INTO `Status` VALUES ('3', 'test drive');
INSERT INTO `Status` VALUES ('4', 'made');

/*Manufacturer*/
INSERT INTO Manufacturer VALUES ('1', 'Mercedes Benz', '3');
INSERT INTO Manufacturer VALUES ('2', 'BMW', '4');
INSERT INTO Manufacturer VALUES ('3', 'Porsche', '4');
INSERT INTO Manufacturer VALUES ('4', 'Volkswagen', '4');
INSERT INTO Manufacturer VALUES ('5', 'Lada', '1');

/*Label*/
INSERT INTO Label VALUES ('1', 'BMW', '2');
INSERT INTO Label VALUES ('2', 'Zhiguly', '5');
INSERT INTO Label VALUES ('3', 'Mercedes Benz', '1');
INSERT INTO Label VALUES ('4', 'Porsche', '3');
INSERT INTO Label VALUES ('5', 'Audi', '4');
INSERT INTO Label VALUES ('6', 'Volkswagen', '4');

/*Client*/
INSERT INTO Client VALUES ('1', 'Harry', 'Potter', '4', 'Grass St 34', 'harry.esfrs@gmail.com', '');
INSERT INTO Client VALUES ('2', 'Ronald', 'Weasley', '3', 'Avenue rge', '', '+923764929');
INSERT INTO Client VALUES ('3', 'Eva', 'Green', '6', '3243fg d', 'jsdhfk@me.com', '+639238479');

/*Cars*/
INSERT INTO Cars VALUES ('1', '3', 'GL-class', '325783', '1', '1');
INSERT INTO Cars VALUES ('2', '5', 'A8', '354334', '2', '2');
INSERT INTO Cars VALUES ('3', '1', 'x564', '233255', '3', '1');
INSERT INTO Cars VALUES ('4', '6', '242', '149309', '4', '3');

/*TestDrive*/
INSERT INTO TestDrive VALUES ('1', '1', '1', '2014-12-21 12:30:00.350', 'cool');
INSERT INTO TestDrive VALUES ('2', '2', '2', '2014-12-21 12:30:00.350', 'boo');
INSERT INTO TestDrive VALUES ('3', '1', '3', '2015-02-21 12:30:00.350', '');
INSERT INTO TestDrive VALUES ('4', '3', '1', '2014-11-21 12:30:00.350', '');
INSERT INTO TestDrive VALUES ('5', '4', '2', '2015-01-21 12:30:00.350', '');

/*Orders*/
INSERT INTO Orders VALUES ('1', '1', '1', '2014-12-29 12:30:00.350', '0', '1');
INSERT INTO Orders VALUES ('2', '2', '2', '2014-11-21 12:30:00.350', '0', '2');
INSERT INTO Orders VALUES ('3', '3', '2', '2014-12-21 12:30:00.350', '0', '3');
INSERT INTO Orders VALUES ('4', '1', '3', '2015-02-21 12:30:00.350', '0', '4');
