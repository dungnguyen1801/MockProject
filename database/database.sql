create database BookManagementSystem_Team4
create TABLE [User]
(
    [user_id] int PRIMARY KEY,
    [user_name] varchar(30),
    password varchar(30)
)
create TABLE Admin
(
    admin_id int PRIMARY KEY,
    admin_name varchar(30),
    password varchar(30)
)
create TABLE BookCase
(
    book_case_id int PRIMARY KEY,
    book_case_name varchar(255)
)
create TABLE Book
(
	book_id int PRIMARY KEY,
    book_title varchar(255),
    author varchar(255),
    brief varchar(max),
    publisher varchar(255),
    content varchar(max),
    category varchar(255),
)
create TABLE Contain
(
	create_date date,
    book_id int FOREIGN KEY References BookCase(book_case_id),
    book_case_id int FOREIGN KEY References Book(book_id)
)

--USER
INSERT "USER" VALUES(1, 'qq', '123456')
INSERT "USER" VALUES(3, 'quynh', '123@123a')
--ADMIN
INSERT "ADMIN" VALUES(1, 'admin', 'password')
--BookCase
INSERT "BookCase" VALUES(1, 'romantic')
INSERT "BookCase" VALUES(2, 'fiction')
INSERT "BookCase" VALUES(3, 'horror')
--Book
INSERT "Book" VALUES(1, 'Lao Hac', 'Nam Cao', 'con cho vang', 'quan doi', 'o day co dong chu rat dai', 'truyen ngan')
INSERT "Book" VALUES(2, 'Doi thua', 'Nam Cao', 'nguoi tri thuc ngheo truoc cach mang thang tam', 'quan doi', 'o day co dong chu rat dai', 'truyen ngan')
INSERT "Book" VALUES(3, 'Mot bua no', 'Nam Cao', 'nguoi nong dan ngheo bi bien chat', 'quan doi', 'o day co dong chu rat dai', 'truyen ngan')
--Contain
INSERT "Contain" VALUES('11/20/2000', 2, 1)
INSERT "Contain" VALUES('11/02/1999', 3, 1)
INSERT "Contain" VALUES('11/21/2001', 2, 1)
