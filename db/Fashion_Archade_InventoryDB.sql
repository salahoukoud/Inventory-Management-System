drop database Fashion_Archade_Inventory;
create database Fashion_Archade_Inventory;
use Fashion_Archade_Inventory;

create table Tax_Scheme(
	TID varchar (30) not null,
	Tax_Category varchar(100) not null,
	Tax_Rate decimal (5,2),
	constraint primary key(TID)
);

insert into Tax_Scheme(TID,Tax_Category,Tax_Rate)
	values('T001','NBT',2),
		  ('T002','VAT',15),
		  ('T003','GST',4);
		  
		  
create table Payment_Term(
	Term_ID varchar (30) not null,
	Term_Category varchar(100) not null,
	Duration decimal (5,2),
	constraint primary key(Term_ID)
);

insert into Payment_Term(Term_ID,Term_Category,Duration)
	values('TM001','Net 1',1),
		  ('TM002','Net 3',3),
		  ('TM003','Net 6',6),
		  ('TM004','Net 12',12);
		  
		  

create table Vendor(
	VID char(10) not null,
	Term_ID varchar(30) not null,
	Name varchar(100)not null,
	TID varchar(30),
	Address varchar (200)not null,
	Telephone_number int(20)not null,
	Mobile_Number int (10),
	Credit_limit decimal(30,2),
	Email_Address varchar(100),
	Fax int (12),
	Web varchar(100),
	Tax_Status boolean not null,
	Company varchar(200),
	constraint primary key(VID),
	constraint foreign key (Term_ID) references Payment_Term(Term_ID)on update cascade on delete cascade,
	constraint foreign key (TID) references Tax_Scheme(TID)on update cascade on delete cascade
);

insert into Vendor(VID,Term_ID,TID,Name,Address,Telephone_number,Mobile_Number,Credit_limit,Email_Address,Fax,Web,Tax_Status,Company)
	values('V001','TM002','T003','Danapala Perera','No.30, Nalluruwa',712345679,712345679,45000,'qasa.qwea@gmail.com',0381292022,'www.abcd.com',true,'Mahesh Fashion'),
		  ('V002','TM002','T003','Gunapala Gunapala','No.40, Panadura',413345679,712345679,82000,'qasa.qwea@gmail.com',0381292022,'www.abcd.com',true,'Mahesh Fashion'),
		  ('V003','TM003','T002','Hasitha Somapala','No.86, Galle Rd',383345679,712345679,100000,'qasa.qwea@gmail.com',0381292022,'www.abcd.com',true,'Mahesh Fashion');
	

create table Purchase_Invoice(
	Invoice_No char (10) not null,
	VID char(10) not null,
	Received_Date date not null,
	Credit_Period int ,	
	constraint primary key(Invoice_No),
	constraint foreign key(VID) references Vendor(VID) on update cascade on delete cascade
);
	
insert into Purchase_Invoice(Invoice_No,VID,Received_Date,Credit_Period)
	values('In001','V001','2016-08-02',12),
		  ('In002','V002','2016-08-03',6),
		  ('In003','V001','2016-08-01',8),
		  ('In004','V003','2016-08-10',12),
		  ('In005','V001','2016-08-20',12);

create table Payment(
	PID char (10) not null,
	Invoice_No char(10) not null,
	Due_Date date not null,
	Discount decimal(20,2) not null,
	Total_Amount decimal (20,2) not null,
	Status boolean not null,
	Sub_Total decimal (20,2) not null,
	constraint primary key(PID),
	constraint foreign key(Invoice_No) references Purchase_Invoice(Invoice_No) on delete cascade on update cascade
);

insert into Payment(PID,Invoice_No,Due_Date,Discount,Total_Amount,Status,Sub_Total)
	values('P001','In001','2012-12-01',1200,12000,true,12002),
		  ('P002','In002','2012-12-01',1200,12000,true,12002),
		  ('P003','In003','2012-12-01',1200,12000,true,12002),
		  ('P004','In004','2012-12-01',1200,12000,true,12002),
		  ('P005','In005','2012-12-01',1200,12000,true,12002);
		  

create table Item_Type(
	Type_Id char (10) not null,
	Type_Name varchar(30) not null,
	constraint primary key(Type_Id)
);

insert into Item_Type(Type_Id,Type_Name)
	values('Ty001','Fashion'),
		  ('Ty002','Jewellary'),
		  ('Ty003','Fancy'),
		  ('Ty004','Home & Living'),
		  ('Ty005','Cosmetic');
		  
		  
create table Item_Major(
	Product_Code varchar (14) not null,
	Type_Id varchar(30) not null,
	Product_Name varchar (30) not null,
	Description varchar (1000) not null,
	constraint primary key(Product_Code),
	constraint foreign key (Type_Id) references Item_Type(Type_Id) on delete cascade on update cascade
);
 insert into Item_Major(Product_Code,Type_Id,Product_Name,Description)
	values	('P10001','Ty001','Shirt L/S','Mens Long Sleeve Shirt'),
			('P10002','Ty001','Shirt S/S','Mens Short Sleeve Shirt'),
			('P10003','Ty001','Underware','Mens Underware'),
			('P10004','Ty001','Vest','Mens Vest');

create table Size_Of_Item(
	Size_ID char (10) not null,
	Item_Size varchar(30) not null,
	constraint primary key(Size_ID)
);

insert into Size_Of_Item(Size_ID,Item_Size)
	values('SI1001','S'),
		  ('SI1002','M'),
		  ('SI1003','L'),
		  ('SI1004','XL'),
		  ('SI1005','XXL'),
		  ('SI1006','XXXL'),
		  ('SI1007','14'),
		  ('SI1008','14/2'),
		  ('SI1009','15'),
		  ('SI1010','15/2'),
		  ('SI1011','16');
		  
		  
create table Item_Size_Detail(
	Size_ID char (30) not null,
	Product_Code varchar(30) not null,
	constraint foreign key(Size_ID) references Size_Of_Item(Size_ID),
	constraint foreign key(Product_Code) references Item_Major(Product_Code)
);

insert into Item_Size_Detail(Size_ID,Product_Code)
	values('SI1007','P10001'),
		  ('SI1008','P10001'),
		  ('SI1009','P10001'),
		  ('SI1010','P10001'),
		  ('SI1011','P10001'),
		  ('SI1007','P10002'),
		  ('SI1008','P10002'),
		  ('SI1009','P10002'),
		  ('SI1010','P10002'),
		  ('SI1011','P10002'),
		  ('SI1001','P10003'),
		  ('SI1002','P10003'),
		  ('SI1003','P10003'),
		  ('SI1004','P10003'),
		  ('SI1005','P10003'),
		  ('SI1006','P10003');
			
create table Item_Sub_Type(
	SID char (10) not null,
	Name varchar(30) not null,
	constraint primary key(SID)
);

insert into Item_Sub_Type(SID,Name)
	values('S001','Gents'),
		  ('S002','Women'),
		  ('S003','Kids General'),
		  ('S004','Kids Boys'),
		  ('S005','Kids Girls'),
		  ('S006','General');


create table Item_Sub_Type_Detail(
	SID char (30) not null,
	Product_Code char(30) not null,
	constraint foreign key (SID) references Item_Sub_Type(SID) on delete cascade on update cascade,
	constraint foreign key (Product_Code) references Item_Major(Product_Code) on delete cascade on update cascade
);

insert into Item_Sub_Type_Detail(SID,Product_Code)
	values('S001','P10001'),
		  ('S001','P10002'),
		  ('S001','P10003'),
		  ('S001','P10004');




create table Brand(
	BID char (10) not null,
	Name varchar(30) not null,
	constraint primary key(BID)
);

insert into Brand(BID,Name)
	values('B001','Emerald'),
		  ('B002','Signature'),
		  ('B003','Wills'),
		  ('B004','Van Heusen'),
		  ('B005','Un Branded'),
		  ('B006','Top Gear'),
		  ('B007','Jobbs');

		  
create table Brand_Detail(
	BID char (10) not null,
	Product_Code varchar(30) not null,
	constraint foreign key (BID) references Brand(BID) on update cascade on delete cascade,
	constraint foreign key (Product_Code) references Item_Major(Product_Code) on update cascade on delete cascade
);

insert into Brand_Detail(BID,Product_Code)
	values('B001','P10001'),
		  ('B002','P10001'),
		  ('B006','P10003'),
		  ('B007','P10004');

		  
create table Inventory_Item(
	Item_Code char (30) not null,
	Product_Code varchar(30) not null,
	Supply_Price decimal (30,2) not null,
	Markup decimal(30,3) not null,
	Retail_Price decimal(30,2) not null,
	Qty_On_Hand int (20) not null,
	Minimum_Qty int (20),
	Discount_Of_Item decimal(20,2),
	Return_Status boolean,
	Size_Of_Item varchar(100),
	Added_Date date not null,
	Brand varchar (30),
	Gender varchar (30),
	constraint primary key(Item_Code),
	constraint foreign key (Product_Code) references Item_Major (Product_Code) on delete cascade on update cascade
);

insert into Inventory_Item(Item_Code,Brand,Product_Code,Supply_Price,Markup,Retail_Price,Qty_On_Hand,Minimum_Qty,Discount_Of_Item,Return_Status,Size_Of_Item,Added_Date,Gender)
	values('I1001','Emerald','P10001',850,10.0,950,300,20,50,true,'15/2','2012-02-03','Gents'),
		  ('I1002','Emerald','P10002',750,10.0,850,200,null,50,true,'15/2','2011-02-03','Gents'),
		  ('I1003','Signature','P10001',950,10.0,1200,400,20,50,true,'16','2013-02-03','Gents'),
	      ('I1004','Top Gear','P10003',150,10.0,180,400,20,50,false,'M','2011-02-03','Gents');

create table Item_Detail(
	Detail_Code varchar (30) not null,
	Invoice_No varchar(30)not null,
	Item_Code varchar (30)not null,
	Supply_Price decimal (50,2)not null,
	Received_Qty int(30) not null,
	Total_Price decimal (50,2) not null,
	Vendor_Code varchar(30) not null,
	constraint primary key(Detail_Code),
	constraint foreign key(Invoice_No) references Purchase_Invoice(Invoice_No)on delete cascade on update cascade ,
	constraint foreign key(Item_Code) references Inventory_Item(Item_Code)on update cascade 
);

insert into Item_Detail(Detail_Code,Invoice_No,Item_Code,Supply_Price,Received_Qty,Total_Price,Vendor_Code)
	values('D001','In001','I1001',850,80,10912,'IX1201'),
		  ('D002','In002','I1001',850,120,10912,'LT1201'),
		  ('D003','In003','I1001',850,100,10912,'IX1201'),
		  ('D004','In003','I1002',750,200,10912,'IX1201'),
	      ('D005','In002','I1003',950,400,10912,'PW1254'),
		  ('D006','In002','I1004',150,400,10912,'UW1231');
		  
create table Purchase_Return_Item(
	Detail_Code varchar(30) not null,
	Date_Of_Return date not null,
	Description varchar(300),
	Return_Qty int(30) not null,
	constraint foreign key(Detail_Code) references Item_Detail(Detail_Code)on delete cascade on update cascade
);

insert into Purchase_Return_Item(Detail_Code,Date_Of_Return,Description,Return_Qty)
	values('D001','2012-03-14','Damaged',12),
		  ('D002','2012-03-20','Damaged',3),
		  ('D002','2012-03-31','Damaged',2);

create table Sales_Person(
	NIC varchar(12)not null,
	Name varchar(50)not null,
	Address varchar(100)not null,
	DOB date not null,
	constraint primary key(NIC)
);
insert into Sales_Person(NIC,Name,Address,DOB)
	values('920601375V','Sumana','N0 20 Galle','1992-02-12'),
		  ('922301375V','Leela','N0 40 Galle','1992-10-13'),
		  ('960631375V','Lalitha','N0 23 Panadura','1996-02-12'),
		  ('922321375V','Wasana','N0 23 Matara','1992-02-12');
		  
create table Sale(
	Bill_No varchar(12)not null,
	NIC varchar(12) not null,
	Bill_Date date not null,
	Total_Discount decimal(50,2),
	Total_Amount decimal(50,2)not null,
	Received_Cash decimal(20,2)not null,
	Balance_Amount decimal(20,2),
	Tax decimal(20,2),
	constraint primary key(Bill_No),
	constraint foreign key(NIC) references Sales_Person(NIC)on delete cascade on update cascade 
);

insert into Sale(Bill_No,NIC,Bill_Date,Total_Discount,Total_Amount,Received_Cash,Balance_Amount,Tax)
	values('BN001','920601375V','2014-12-14',450,1200,2000,800,0),
		  ('BN002','920601375V','2014-12-14',120,700,1000,300,0),
		  ('BN003','920601375V','2014-12-14',null,350,350,null,0),
		  ('BN004','922321375V','2014-12-15',750,8300,8500,200,0);

create table Sale_Item(
	SID char (200) not null,
	Item_Code char(50) not null,
	Bill_No varchar(30) not null,
	Total_Amount decimal (20,2) not null,
	Labeled_Price decimal (20,2) not null,
	Sold_Price decimal (20,2) not null,
	Sold_QTY int not null,
	Discount_Of_Item decimal(30,2),
	constraint primary key(SID),
	constraint foreign key(Item_Code) references Inventory_Item(Item_Code)on update cascade ,
	constraint foreign key(Bill_No) references Sale(Bill_No)on delete cascade on update cascade
);

insert into Sale_Item(SID,Item_Code,Bill_No,Total_Amount,Labeled_Price,Sold_Price,Sold_QTY,Discount_Of_Item)
	values('S0001','I1001','BN001',1600,850,800,2,100),
		  ('S0002','I1001','BN002',1600,850,800,2,null),
		  ('S0003','I1002','BN002',800,850,800,1,null),
		  ('S0004','I1003','BN003',1800,950,900,2,100);

create table Sale_Return_Item(
	SID char(10) not null,
	Qty int not null,
	Return_Date date not null,
	constraint foreign key(SID) references Sale_Item(SID)on delete cascade on update cascade 
);

insert into Sale_Return_Item(SID,Qty,Return_Date)
	values('S0001',1,'2014-01-04'),
		  ('S0003',2,'2015-01-04'),
		  ('S0004',1,'2014-01-10'),
		  ('S0001',2,'2014-01-05');
		  
create table User_Acount(
	username varchar (30) not null,
	password varchar (300) not null,
	constraint primary key (username)
);

insert into User_Acount(username,password)
	values('Pahansith',password('pahan'));
	