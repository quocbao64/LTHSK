GO
CREATE DATABASE QLST

GO
USE QLST

GO
CREATE TABLE EMPLOYEE(
	EmployeeID int PRIMARY KEY NOT NULL,
	ManagerID int NOT NULL,
	EmployeeName NVARCHAR(30) NOT NULL,
	Gender BIT,
	BirthDate DATE,
	HireDate DATE,
	Address NVARCHAR(100),
	Phone VARCHAR(10) NOT NULL,
	Gmail VARCHAR(50) NOT NULL
)


GO
CREATE TABLE ACCOUNT(
	EmployeeID int NOT NULL FOREIGN KEY REFERENCES EMPLOYEE(EmployeeID),
	AccountName VARCHAR(30) PRIMARY KEY NOT NULL,
	AccountPassword VARCHAR(30) NOT NULL
)

GO
INSERT INTO [dbo].[EMPLOYEE]
           ([EmployeeID],[ManagerID],[EmployeeName],[Gender],[BirthDate],[HireDate],[Address],[Phone],[Gmail])
     VALUES
	 (1000,10,N'Nguyễn Văn Sơn',0,'2001-12-20','2020-12-20',N'4, Nguyễn Thông, Tân Bình, Lagi, Bình Thuận','0395906032','sson12131415@gmail.com'),
     (10,10,N'Nguyễn Văn Sơn',0,'2001-12-20','2020-12-20',N'4, Nguyễn Thông, Tân Bình, Lagi, Bình Thuận','0395906032','sson12131415@gmail.com')   

GO


GO
INSERT INTO [dbo].[ACCOUNT]
           ([EmployeeID],[AccountName],[AccountPassword])
     VALUES
	 (1000,'son1245', '12345'),
	 (10,'son12', '12345')
       
GO



SELECT * FROM ACCOUNT

USE [QLST]
GO

UPDATE [dbo].[ACCOUNT]
   SET [EmployeeID] = <EmployeeID, int,>
      ,[AccountName] = <AccountName, varchar(30),>
      ,[AccountPassword] = <AccountPassword, varchar(30),>
 WHERE <Search Conditions,,>
GO




