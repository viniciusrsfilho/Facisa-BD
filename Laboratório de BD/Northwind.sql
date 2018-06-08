create database Northwind;

create table Employees (
	employeeID serial,
   	lastName varchar(20),
    firstName varchar (20),
    title varchar(30),
    titleOfCourtesy varchar(25),
    birthDate date,
    hireDate date,
    adress varchar(60),
    city varchar(15),
    region varchar(15),
    postalCode varchar(10),
    country varchar(15),
    homePhone varchar(24),
    extensions varchar(4),
    notes text,
    reportsTo int,
    constraint pkEmployeeID primary key(employeeID)
);

insert into Employees (lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, adress, city,
region, postalCode, country, homePhone, extensions, notes, reportsTo) values ('Filho', 'Vinicius', '', '', '1998-11-09', '2016-01-01',
'Rua Epaminondas Macaxeira, 105', 'Campina Grande', 'Nordeste', '58402-053', 'Brasil', '83 33421839', '', '', 0);

insert into Employees (lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, adress, city,
region, postalCode, country, homePhone, extensions, notes, reportsTo) values ('Santos', 'Adriano', '', '', '1985-01-01', '2012-02-01',
'Rua Maciel Pinheiro, 300', 'Campina Grande', 'Nordeste', '58400-153', 'Brasil', '83 33222233', '', '', 0);
update Employees set title='Doutor' where employeeID = 2;

insert into Employees (lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, adress, city,
region, postalCode, country, homePhone, extensions, notes, reportsTo) values ('Vieira', 'Sezinando', '', '', '1995-03-25', '2016-01-01',
'Rua Piroca Larga, 225', 'Campina Grande', 'Nordeste', '58404-085', 'Brasil', '83 33223321', '', '', 0);

insert into Employees (lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, adress, city,
region, postalCode, country, homePhone, extensions, notes, reportsTo) values ('Alves', 'Wesley', '', '', '1998-07-22', '2016-01-01',
'Rua Santo Antonio, 315', 'Campina Grande', 'Nordeste', '58401-125', 'Brasil', '83 33222222', '', '', 0);

insert into Employees (lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, adress, city,
region, postalCode, country, homePhone, extensions, notes, reportsTo) values ('Trindade', 'Rodrigo', '', '', '1998-05-05', '2016-01-01',
'Rua Venancio Neiva, 25', 'Campina Grande', 'Nordeste', '58400-015', 'Brasil', '83 33223333', '', '', 0);

insert into Employees (lastName, firstName, title, titleOfCourtesy, birthDate, hireDate, adress, city,
region, postalCode, country, homePhone, extensions, notes, reportsTo) values ('Kazadi', 'Diego', '', '', '1990-02-25', '2016-01-01',
'Rua Rodrigues Alves, 255', 'Campina Grande', 'Nordeste', '58420-285', 'Brasil', '83 33213231', '', '', 0);

create table Products (
	productID serial,
    supplierID int,
    categoryID int,
    productName varchar(40),
    quantityPerUnit varchar(20),
    unitPrice money,
    unitsInStock smallint,
    unitsOnOrder smallint,
    reorderLevel smallint,
    discontinued bit,
    constraint pkProductID primary key (productID),
    constraint fkSupplierID foreign key (supplierID) references Suppliers (supplierID),
    constraint fkcategoryID foreign key (categoryID) references Categories (categoryID)
);

insert into Products (supplierID, categoryID, productName, quantityPerUnit, 
unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued) values (1, 1, 'Pneu - CarroPopular', '100', '350.0', 
100, 20, 5, '1');

insert into Products (supplierID, categoryID, productName, quantityPerUnit, 
unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued) values (1, 1, 'Pneu - CarroLuxo', '100', '500.0', 
100, 12, 5, '1');

insert into Products (supplierID, categoryID, productName, quantityPerUnit, 
unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued) values (2, 5, 'Sony Xperia  Z2', '100', '800.0', 
150, 30, 5, '1');

insert into Products (supplierID, categoryID, productName, quantityPerUnit, 
unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued) values (4, 2, 'Camisa polo básica', '250', '200.0', 
200, 50, 5, '1');

insert into Products (supplierID, categoryID, productName, quantityPerUnit, 
unitPrice, unitsInStock, unitsOnOrder, reorderLevel, discontinued) values (4, 6, 'Camisa polo básica', '250', '190.0', 
200, 40, 5, '1');

create table Suppliers (
	supplierID serial,
    companyName varchar(40),
    contactName varchar(30),
    contactTitle varchar(30),
    adress varchar(60),
    city varchar(15),
    region varchar(15),
    postalCode varchar(10),
    country varchar(15),
    phone varchar(24),
    fax varchar(24),
    homePage text,
    constraint pkSupplierID primary key (supplierID)
);

insert into Suppliers (companyName, contactName, contactTitle, adress,
city, region, postalCode, country, phone, fax, homePage) values ('Pirelli', 'José', 'Fornecedor', 'Av. Boa Viagem',
'Recife', 'Nordeste', '50300-21', 'Brasil', '81 99999-8888', '', '');

insert into Suppliers (companyName, contactName, contactTitle, adress,
city, region, postalCode, country, phone, fax, homePage) values ('Sony', 'João', 'Fornecedor', 'Av. Conselheiro Aguiar',
'Recife', 'Nordeste', '50350-34', 'Brasil', '81 99999-9911', '', '');

insert into Suppliers (companyName, contactName, contactTitle, adress,
city, region, postalCode, country, phone, fax, homePage) values ('Apple', 'Mário', 'Fornecedor', 'Av. Brasil',
'Rio de Janeiro', 'Sudeste', '31350-64', 'Brasil', '21 98811-2911', '', '');

insert into Suppliers (companyName, contactName, contactTitle, adress,
city, region, postalCode, country, phone, fax, homePage) values ('Náutica', 'João', 'Fornecedor', 'Av. Recife',
'Recife', 'Nordeste', '50250-14', 'Brasil', '81 98722-9911', '', '');

create table Categories (
	categoryID serial,
    categoryName varchar(15),
    description text,
    constraint pkCategoryID primary key (categoryID)
);

insert into Categories (categoryName, description) values ('Peças de carro', 'Diversos acessórios para automóveis');
insert into Categories (categoryName, description) values ('Roupa masculina', 'Diversas roupas para homens');
insert into Categories (categoryName, description) values ('Brinquedos H', 'Diversos brinquedos para meninos');
insert into Categories (categoryName, description) values ('Brinquedos M', 'Diversos brinquedos para meninas');
insert into Categories (categoryName, description) values ('Eletronicos', 'Diversos eletronicos');
insert into Categories (categoryName, description) values ('Roupa feminina', 'Diversas roupas para mulheres');

create table Territories (
	territoryID serial,
    territoryDescription varchar(50),
    regionID int,
    constraint pkTerritoryID primary key (territoryID),
    constraint fkRegionID foreign key (regionID) references Region (RegionID)
);

create table Region (
	regionID serial,
    regionDescription varchar(50),
    constraint pkRegionID primary key (regionID)
);

create table Orders (
	orderID serial,
    customerID int,
    employeeID int,
    orderDate date,
    requiredDate date,
    shippedDate date,
    shipVia int,
    freight money,
    shipName varchar(40),
    shipAdress varchar(60),
    shipCity varchar(15),
    shipRegion varchar(15),
    shipPostalCode varchar(10),
    shipCountry varchar(15),
    constraint pkOrderID primary key (orderID),
    constraint fkCustomerID foreign key (customerID) references Customers (customerID),
    constraint fkEmployeeID foreign key (employeeID) references Employees (employeeID)
);

INSERT INTO Orders (customerID,employeeID,orderDate,requiredDate) VALUES (1,1,'05/06/2018','25/06/2018'),
(2,3,'29/12/2018','21/01/2018'),(3,1,'28/05/2017','25/08/2018'),(4,2,'14/02/2018','17/09/2017'),
(2,1,'27/10/2017','13/02/2019'),(1,2,'25/03/2019','04/06/2018"'),(1,3,'30/09/2017','14/04/2017'),
(3,3,'11/04/2017','08/02/2018'),(1,2,'05/08/2018','21/06/2018'),(2,3,'01/09/2017','05/11/2018');

create table Shippers (
	shipperID serial,
    companyName varchar(40),
    phone varchar(24),
    constraint pkShipperID primary key (shipperID)
);

INSERT INTO Shippers (companyName,phone) VALUES ('Dignissim Pharetra Nam Ltd','95-21484-7059'),
('Sapien Limited','14-20407-6264'),('Lacinia LLC','69-57085-3954'),('Mattis Velit LLP','11-22241-8223'),
('Tortor Ltd','86-38127-5509'),('Sit Limited','17-56661-3072'),('Nunc Mauris Sapien Industries','98-15959-3001'),
('Penatibus Et Magnis Incorporated','12-97634-9364'),('Lacinia Industries','99-23690-1294'),
('Lobortis Risus In Corporation','37-73451-2264');

create table Customers (
	customerID serial,
    companyName varchar(40),
    contactName varchar(30),
    contactTitle varchar(30),
    adress varchar(60),
    city varchar(15),
    region varchar(15),
    postalCode varchar(10),
    country varchar(15),
    phone varchar(24),
    fax varchar(24),
    constraint pkCustomerID primary key (customerID)
);

INSERT INTO Customers (companyName,contactName,contactTitle,adress,city,region,postalCode,country,phone) VALUES 
('Donec LLC','Abbot','ipsum@urna.co.uk','Ap #908-7292 Quis Av.','Fort Worth','Texas','305384','Suriname','77-2889-0421'),
('Luctus Et Corp.','Jackson','augue@Nulla.org','P.O. Box 773, 5776 Fringilla Street','Vienna','Vienna','87631','Greenland','88-9940-8870'),
('Magna A Corp.','Hilel','magna.Ut@duinec.ca','P.O. Box 157, 8055 Dui. Ave','Casciana Ter','Toscana','30091','Iraq','63-3831-0927'),
('Libero Est Congue Institute','Justin','arcu@feugiatmetussit.ca','7162 Lorem Rd.','Jackson','MS','T8E 7B3','Italy','68-6810-0621'),
('Augue Foundation','Macaulay','ullamcorper@Phasellu.edu','9188 Pharetra, St.','North Dum','West Bengal','61504','Belgium','18-1021-5416'),
('Iaculis Odio LLC','Elton','risus.Nunc@facilisis.co','Ap #745-9080 Cursus Rd.','Vienna','Wie','7468 XL','Mozambique','84-4811-3375'),
('Mi Fringilla Mi Limited','Gary','Etia@nuncsitamet.co','427-3705 In, Street','Knoxville','TN','2259','Cocos Islands','60-6221-6661'),
('Nisl Maecenas Ltd','Connor','tincidunt@utnisi.net','Ap #396-1551 Aliquam, Rd.','Morrinsville','North Island','527137','Luxembourg','94-4621-9302'),
('Leo Morbi Neque Incorporated','Ivan','a.enim@tortor.org','Ap #577-6244 Ac Rd.','Vile de Mani','Quebec','G9T 2Z2','Guernsey','66-1471-6020'),
('Urna PC','Kadeem','scelerisque.@aconvall.co','P.O. Box 966, 2692 Sem Street','Chapecó','SC','88984-370','Denmark','37-3187-8399');

create table CustomerCustomerDemo (
	customerCustomerDemoID serial,
    customerID int,
    constraint pkCustomerCustomerDemoID primary key (customerCustomerDemoID),
    constraint fkCustomerID foreign key (customerID) references Customers (customerID)
);

create table CustomerDemographics (
	customerTypeID serial,
    customerDesc text,
    constraint pkCustomerTypeID primary key (customerTypeID)
);

create table EmployeeTerritories (
	employeeID int,
    territoryID int,
    constraint fkEmployeeID foreign key (employeeID) references Employees (employeeID),
    constraint fkTerritoryID foreign key (TerritoryID) references Territories (TerritoryID)
);

create table OrderDetails (
	orderID int,
    productID int,
    unitPrice money,
    quantity smallint,
    discount real,
    constraint fkOrderID foreign key (OrderID) references Orders (OrderID),
    constraint fkProductID foreign key (ProductID) references Products (productID)
);