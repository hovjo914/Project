Create table PRODUCTS (
PRODUCTID VARCHAR NOT NULL,
PRODUCTNAME VARCHAR NOT NULL,
DESCRIPTION VARCHAR NOT NULL,
CATEGORY VARCHAR NOT NULL,
PRICE DOUBLE NOT NULL,
QUANTITY INTEGER NOT NULL,
CONSTRAINT PK_PRODUCTID  Primary key (PRODUCTID)
);

Create table Customers (
CUSTOMERNAME VARCHAR NOT NULL,
ADDRESS VARCHAR NOT NULL,
CREDITCARD VARCHAR NOT NULL,
PASSWORD VARCHAR NOT NULL,
CONSTRAINT PK_CUSTOMERNAME PRIMARY KEY (CUSTOMERNAME)
);

CREATE TABLE ORDERS (
ORDERID VARCHAR NOT NULL,
ORDERDATE DATE NOT NULL,
CONSTRAINT PK_ORDERID PRIMARY KEY (ORDERID)
);

CREATE TABLE ORDERITEM (
QUANTITYPURCHASED INTEGER NOT NULL
);