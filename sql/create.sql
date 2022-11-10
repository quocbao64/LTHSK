GO
CREATE DATABASE QLST

GO
USE QLST

GO
CREATE TABLE Person(
	ID int PRIMARY KEY NOT NULL,
	Name NVARCHAR(30) NOT NULL,
	Gender BIT,
	Gmail VARCHAR(50) NOT NULL,
	Phone VARCHAR(10) NOT NULL,
	Address NVARCHAR(100),
	BirthDate DATE,
	HireDate DATE,
	Role VARCHAR(20) NOT NULL,
	Password VARCHAR(20) NOT NULL
)

GO
CREATE TABLE Orders(
	ID int PRIMARY KEY NOT NULL,
	OrderDate DATE,
	TotalPrice double PRECISION NOT NULL,
	DisCount double PRECISION,
	PersonID int FOREIGN KEY REFERENCES Person(ID) NOT NULL
)

GO
CREATE TABLE Categories(
	ID int PRIMARY KEY NOT NULL,
	Name NVARCHAR(30) NOT NULL,
)

GO
CREATE TABLE Suppliers(
	ID int PRIMARY KEY NOT NULL,
	Name NVARCHAR(30) NOT NULL,
	Gmail VARCHAR(50),
	Phone VARCHAR(10) NOT NULL,
	Address NVARCHAR(100)
)

GO
CREATE TABLE Product(
	ID int PRIMARY KEY NOT NULL,
	Name NVARCHAR(200) NOT NULL,
	Price double PRECISION NOT NULL,
	SuppliersID int FOREIGN KEY REFERENCES Suppliers(ID),
	CategoriesID int FOREIGN KEY REFERENCES Categories(ID)
)

GO
CREATE TABLE CartItem(
	ID int PRIMARY KEY NOT NULL,
	Quantity int,
	OrdersID int FOREIGN KEY REFERENCES Orders(ID) on delete cascade,
	ProductID int FOREIGN KEY REFERENCES Product(ID) 
)



-- Nam: 0, Nu:1
GO
INSERT INTO [dbo].[Person]([ID],[Name],[Gender],[Gmail],[Phone],[Address],[BirthDate],[HireDate],[Role],[Password]) VALUES
			(1,N'Nguyễn Phương Thảo',1,'nguyenphuongthao01@gmail.com','0902121940',N'727/942 Trần Hưng Đạo P.1 Quận 5 TP.Hồ Chí Minh','1997-2-23','2021-6-10','ROLE_EMPLOYEE','pass123'),
			(2,N'Trần Trọng Hải Minh',0,'trantronghaiminh02@gmail.com','0918335697',N'1333/9 Huỳnh Tấn Phát Quận 7 TP.Hồ Chí Minh','1994-8-20','2021-4-12','ROLE_EMPLOYEE','pass123'),
			(3,N'Phạm Nhàn',1,'phamnhan03@gmail.com','0302121900',N'Ân Phong Cầu Giấy TP.Hà Nội','1999-3-20','2021-2-22','ROLE_EMPLOYEE','pass123'),
			(4,N'Bùi Thị Hương Thu',1,'buithithuhuong04@gmail.com','0802121907',N'Kp3 P. Tân Thới Hiệp Q12 TP.Hồ Chí Minh','1998-3-20','2021-12-23','ROLE_EMPLOYEE','pass123'),
			(5,N'Nguyễn Minh Sang',0,'nguyenminhsang05@gmail.com','0982121915',N'109/5 Thống Nhất P.16 Q.Gò Vấp TP.Hồ Chí Minh','1998-5-11','2021-11-12','ROLE_EMPLOYEE','pass123'),
			(6,N'Phạm Thị Minh Trang',1,'phamthiminhtrang06@gmail.com','0302111901',N'293/150D1 Trường Chinh F14 Quận Tân Bình TP.Hồ Chí Minh','1999-2-22','2021-4-23','ROLE_EMPLOYEE','pass123'),
			(7,N'Nguyễn Khánh Dũng',0,'nguyenkhanhdung07@gmail.com','0332121900',N'133/38A Van Than P.8 Q.6 TP.Hồ Chí Minh','1995-9-20','2021-10-10','ROLE_EMPLOYEE','pass123'),
			(8,N'Lương Lệ Mỹ',1,'luonglemy08@gmail.com','0802121909',N'N4/2T50 Tô Hiến Thành Q.10 TP.Hồ Chí Minh','1997-2-27','2021-2-26','ROLE_EMPLOYEE','pass123'),
			(9,N'Nguyễn Lệ Quyên',1,'nguyenlequyen09@gmail.com','0882121960',N'Ngõ 165 Cầu Giấy TP.Hà Nội','1997-6-12','2021-12-14','ROLE_EMPLOYEE','pass123'),
			(10,N'Đoàn Mạnh Thiệp',0,'doanmanhthiet10@gmail.com','0302121911',N'507C Cầu Giấy TP.Hà Nội','1996-3-22','2021-9-18','ROLE_EMPLOYEE','pass123'),
			(11,N'Nguyễn Quốc Bảo',0,'bao11@gmail.com','0333399988',N'12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh','2002-2-22','2021-1-27','ROLE_ADMIN','pass123'),
			(12,N'Nguyễn Văn Sơn',0,'son12@gmail.com', '0395906032',N'12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh','2002-2-22','2021-1-27','ROLE_EMPLOYEE','pass123')


-- discount = 0, cô hỏi thì bảo là ko có chương trình giảm giá 
GO
INSERT INTO [dbo].[Orders]([ID],[OrderDate],[TotalPrice],[DisCount],[PersonID]) VALUES
           (1001,'2022-11-10',100000,0,12),
		   (1002,'2022-11-10',200000,0,12),
		   (1003,'2022-11-10',300000,0,12),
		   (1004,'2022-11-10',400000,0,12),
		   (1005,'2022-11-11',300000,0,12),
		   (1006,'2022-11-11',200000,0,12),
		   (1007,'2022-11-11',100000,0,12),
		   (1008,'2022-11-11',100000,0,12),
		   (1009,'2022-11-12',500000,0,12),
		   (1010,'2022-11-12',400000,0,12),
		   (1011,'2022-11-12',200000,0,12),
		   (1012,'2022-11-13',300000,0,12),
		   (1013,'2022-11-13',700000,0,12),
		   (1014,'2022-11-13',200000,0,12),
		   (1015,'2022-11-14',900000,0,12)


GO
INSERT INTO [dbo].[Categories]([ID],[Name])VALUES
           (1,N'Hàng thực phẩm'),
		   (2,N'Mỹ phẩm'),
		   (3,N'Đồ dùng văn phòng phẩm'),
		   (4,N'Đồ sinh hoạt cá nhân'),
		   (5,N'Mặt hàng khác')



-- nhà cung cấp 
--[mã:nhà cung cấp về]
--[1:thực phẩm] 
--[2:mỹ phẩm] 
--[3:Đồ dùng văn phòng phẩm]
--[4:Đồ sinh hoạt cá nhân]
--[5:Mặt hàng khác]
GO
INSERT INTO [dbo].[Suppliers]([ID],[Name],[Gmail],[Phone],[Address]) VALUES
		   (1,N'EXP Việt Nam','expvietnam02@gmail.com','0966484808',N'Tòa Nhà Thông Tấn, Số 124 Đường Trần Hữu Dực, P. Xuân Phương, Q. Nam Từ Liêm, Hà Nội'),
		   (2,N'Tami Natural Home','taminaturalhome@gmail.com','0982302430',N'Lô 48, Đường Số 11, Khu Công Nghiệp Tân Đức, Xã Hữu Thạnh, Huyện Đức Hoà,Long An'),
		   (3,N'Vinacom','duyanh01@gmail.com','0835368668',N'275/39/3 Bạch Đằng, Phường 15, Quận Bình Thạnh, TPHCM'),
		   (4,N'Son Nees','sonnees@gmail.com','0395906022',N'12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh'),
		   (5,N'Bao Kun','baokun@gmail.com','0695906222',N'12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh')



GO
INSERT INTO [dbo].[Product]([ID],[Name],[Price],[SuppliersID],[CategoriesID])VALUES
           (1,N'Ba rọi heo C.P khay 500g',100000,1,1),
		   (2,N'Ba rọi heo rút sườn C.P khay 500g (1-2 miếng)',100000,1,1),
		   (3,N'Xương đuôi heo Meat Master khay 400g (2-4 miếng)',50000,1,1),
		   (4,N'Gà dai nguyên con nhập khẩu đông lạnh (1,2kg - 1,5kg/con)',100000,1,1),
		   (5,N'Hộp 15 trứng gà tươi 4KFarm',50000,1,1),
		   (6,N'Sữa rửa mặt tinh chất serum Dove dưỡng ẩm sâu giúp da mềm mượt suốt 24 giờ 130g',100000,2,2),
		   (7,N'Sữa rửa mặt tinh chất serum Dove se khít lỗ chân lông kiềm dầu 130g',100000,2,2),
		   (8,N'Dầu gội bồ kết Macaland mềm mượt mắc ca 280ml',150000,2,2),
		   (9,N'Dầu xả Pantene 3 phút diệu kì ngăn rụng tóc 150ml',50000,2,2),
		   (10,N'Kem dưỡng Ponds White Beauty Instabright Tone Up Milk Cream dưỡng trắng nâng tông 50g',200000,2,2),
		   (11,N'Bộ 3 cây bút dạ quang UBL 3 màu',50000,3,3),
		   (12,N'Bút lông màu cỡ lớn UBL SE0002 bộ 10 cây',50000,3,3),
		   (13,N'Viết 3 màu UBL túi 10 cây',50000,3,3),
		   (14,N'Bút lông màu UBL SE0004 bộ 12 cây',50000,3,3),
		   (15,N'Khăn ướt Yuniku hương trà xanh gói 20 miếng - giao màu ngẫu nhiên',50000,3,3),
		   (16,N'Vỉ 2 cái lưỡi dao Gillette Skinguard bảo vệ da vỉ 2',100000,4,4),
		   (17,N'Lăn ngăn mùi Perspi-guard Maximum Strength Antiperspirant khử mồ hôi vượt trội 30ml',200000,4,4),
		   (18,N'Xịt ngăn mùi Perspi-guard Maximum Strength Antiperspirant khử mồ hôi vượt trội 30ml',300000,4,4),
		   (19,N'Khăn ướt người lớn QUICK NURSE không mùi gói 50 miếng',50000,4,4),
		   (20,N'Nồi quấy bột nhôm anod Sunhouse SH99-14M3 14cm',200000,4,4),
		   (21,N'Nồi nhôm Kim Hằng Long-Life 26cm',200000,5,5),
		   (22,N'Bộ 3 nồi nhôm quai tròn xi bóng t3 nhỏ Kim Hằng Bạch Đằng',200000,5,5),
		   (23,N'Kéo cắt vải Hiệp Phát NK95 24.5cm',50000,5,5),
		   (24,N'Dao bào răng cưa thép không gỉ Hiệp Phát 12.5cm',50000,5,5),
		   (25,N'Bộ 3 dao bào bếp trưởng Kim Hằng Cook Chef (giao màu ngẫu nhiên)',300000,5,5)


GO
INSERT INTO [dbo].[CartItem]([ID],[Quantity],[OrdersID],[ProductID]) VALUES
           (10001,1,1001,9),
		   (10002,1,1001,12),
		   (10003,1,1002,10),
		   (10004,3,1003,13),
		   (10005,1,1003,7),
		   (10006,2,1004,1),
		   (10007,2,1004,2),
		   (10008,4,1005,3),
		   (10009,1,1005,4),
		   (10010,2,1006,5),
		   (10011,1,1006,5),
		   (10012,1,1007,6),
		   (10013,1,1008,7),
		   (10014,2,1009,8),
		   (10015,2,1009,9),
		   (10016,1,1009,4),
		   (10017,1,1010,10),
		   (10018,1,1010,11),
		   (10019,1,1010,12),
		   (10020,1,1011,13),
		   (10021,2,1011,14),
		   (10022,1,1011,15),
		   (10023,1,1012,16),
		   (10024,1,1012,17),
		   (10025,1,1013,18),
		   (10026,4,1013,19),
		   (10027,1,1013,20),
		   (10028,1,1014,20),
		   (10029,1,1015,21),
		   (10030,1,1015,22),
		   (10031,2,1015,23),
		   (10032,2,1015,24),
		   (10033,1,1015,25)


go
select * from Person
select * from Orders
select * from Categories
select * from Suppliers
select * from Product
select * from CartItem






