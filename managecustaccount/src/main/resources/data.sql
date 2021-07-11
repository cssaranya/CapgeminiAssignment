create table Customer(customerId int primary key,
name varchar(60) not null,
surname varchar(60),
createdAt date,
updatedAt date);

create table Contact(contactId int primary key,
emailId varchar(100),
homePhone number(20),
workPhone number(20),
address1 varchar(100),
address2 varchar(100),
city varchar(20),
state varchar(20),
zip  varchar(20),
country varchar(20),
createdAt date,
updatedAt date,
customerId int not null,
FOREIGN KEY(customerId) REFERENCES Customer(customerId)
);

create table Account(accountNumber int primary key,
accountType varchar(60),
balance number(20,2),
status varchar(20),
createdAt date,
updatedAt date,
customerId int not null,
FOREIGN KEY(customerId) REFERENCES Customer(customerId));

create table Transaction(transactionId int primary key,
amount number(20,2),
transactionType varchar(20),
Date date,
accountNumber int not null,
FOREIGN KEY(accountNumber) REFERENCES Account(accountNumber));