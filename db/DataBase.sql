USE AutoShow;

CREATE TABLE Colour
	(	id int AUTO_INCREMENT,
		colour varchar(20) NOT NULL,

		CONSTRAINT `PK_Colour` PRIMARY KEY (id ASC)
	);

CREATE TABLE Material
	(	material_id int AUTO_INCREMENT,
		name varchar(20) NOT NULL,

		CONSTRAINT `PK_Material` PRIMARY KEY (material_id ASC)
	);

CREATE TABLE `Status`
	(	status_id int AUTO_INCREMENT,
		`status` varchar(50) NOT NULL,

		CONSTRAINT `PK_Status` PRIMARY KEY (status_id ASC)
	);

CREATE TABLE Country
	(	country_id int AUTO_INCREMENT,
		country varchar(50) NOT NULL,

		CONSTRAINT `PK_Country` PRIMARY KEY (country_id ASC)
	);

CREATE TABLE City
	(	city_id int AUTO_INCREMENT,
		city varchar(20) NOT NULL,
		country_id int NOT NULL,

		CONSTRAINT `PK_City` PRIMARY KEY (city_id ASC),
		CONSTRAINT FOREIGN KEY `FK_City_Country` (country_id) REFERENCES Country (country_id)
	);

CREATE TABLE Manufacturer
	(	facture_id int AUTO_INCREMENT,
		`name` varchar(50) NOT NULL,
		country_id int NOT NULL,

		CONSTRAINT `PK_Manufacturer` PRIMARY KEY (facture_id ASC),
		CONSTRAINT FOREIGN KEY `FK_Manufacturer_Country` (country_id) REFERENCES Country (country_id)
	);

CREATE TABLE Label
	(	label_id int AUTO_INCREMENT,
		`name` varchar(50) NOT NULL,
		facture_id int NOT NULL,

		CONSTRAINT `PK_Label` PRIMARY KEY (label_id ASC),
		CONSTRAINT FOREIGN KEY `FK_Label_Manufacturer` (facture_id) REFERENCES Manufacturer (facture_id)
	);

CREATE TABLE Client
	(	client_id int AUTO_INCREMENT,
		first_name varchar(30) NOT NULL,
		last_name varchar(30) NOT NULL,
		location int NOT NULL,
		`address` varchar(50) NOT NULL,
		email varchar(30),
		phone_number varchar(11),

		CONSTRAINT `PK_Client` PRIMARY KEY (client_id ASC),
		CONSTRAINT FOREIGN KEY `FK_Client_City` (location) REFERENCES City (city_id)
	);

CREATE TABLE Cars
	(	registration_number int AUTO_INCREMENT,
		label_id int NOT NULL,
		model varchar(20) NOT NULL,
		cost DECIMAL(15,4),
		colour_id int NOT NULL,
		upholstery_id int NOT NULL,	
	
		CONSTRAINT `PK_Cars` PRIMARY KEY (registration_number ASC),
		CONSTRAINT FOREIGN KEY `FK_Cars_Label` (label_id) REFERENCES Label (label_id),
		CONSTRAINT FOREIGN KEY `FK_Cars_Colour` (colour_id) REFERENCES Colour (id),
		CONSTRAINT FOREIGN KEY `FK_Cars_Material` (upholstery_id) REFERENCES Material (material_id)
	);

CREATE TABLE Specifications
	(	car_id int NOT NULL,
		engine_power int,
		fuel_consumption real,
		automatic_transmission TINYINT,

		CONSTRAINT `PK_Specifications` PRIMARY KEY (car_id),
		CONSTRAINT FOREIGN KEY `FK_Specifications_Cars` (car_id) REFERENCES Cars (registration_number)
	);

CREATE TABLE TestDrive
	(	number int AUTO_INCREMENT,
		car_id int NOT NULL,
		client_id int NOT NULL,
		`date` DATETIME(3) NOT NULL,
		feedback varchar(100),
		
		CONSTRAINT `PK_TestDrive` PRIMARY KEY (number),
		CONSTRAINT FOREIGN KEY `FK_TestDrive_Cars` (car_id) REFERENCES Cars (registration_number),
		CONSTRAINT FOREIGN KEY `FK_TestDrive_Client` (client_id) REFERENCES Client (client_id)
	);

CREATE TABLE Orders
	(	number int AUTO_INCREMENT,
		client_id int NOT NULL,
		car_id int NOT NULL,
		`date` DATETIME(3) NOT NULL,
		test_drive TINYINT,
		status_id int NOT NULL,

		CONSTRAINT `PK_Orders` PRIMARY KEY (number),
		CONSTRAINT FOREIGN KEY `FK_Orders_Cars` (car_id) REFERENCES Cars (registration_number),
		CONSTRAINT FOREIGN KEY `FK_Orders_Client` (client_id) REFERENCES Client (client_id),
		CONSTRAINT FOREIGN KEY `FK_Orders_Status` (client_id) REFERENCES `Status` (status_id)
	);