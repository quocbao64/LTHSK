USE [QLST]
GO
/****** Object:  Table [dbo].[CartItem]    Script Date: 21/11/2022 10:33:11 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CartItem](
	[ID] [int] NOT NULL,
	[Quantity] [int] NULL,
	[OrdersID] [int] NULL,
	[ProductID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 21/11/2022 10:33:11 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[ID] [int] NOT NULL,
	[Name] [nvarchar](150) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Orders]    Script Date: 21/11/2022 10:33:11 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Orders](
	[ID] [int] NOT NULL,
	[OrderDate] [date] NULL,
	[TotalPrice] [float] NOT NULL,
	[DisCount] [float] NULL,
	[UsersID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 21/11/2022 10:33:11 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ID] [int] NOT NULL,
	[Name] [nvarchar](200) NOT NULL,
	[Price] [float] NOT NULL,
	[SuppliersID] [int] NULL,
	[CategoriesID] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Suppliers]    Script Date: 21/11/2022 10:33:11 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Suppliers](
	[ID] [int] NOT NULL,
	[Name] [nvarchar](150) NOT NULL,
	[Gmail] [varchar](50) NULL,
	[Phone] [varchar](10) NOT NULL,
	[Address] [nvarchar](200) NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 21/11/2022 10:33:11 SA ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[ID] [int] NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Gender] [bit] NULL,
	[Gmail] [varchar](50) NOT NULL,
	[Phone] [varchar](10) NOT NULL,
	[Address] [nvarchar](100) NULL,
	[BirthDate] [date] NULL,
	[HireDate] [date] NULL,
	[Role] [varchar](20) NOT NULL,
	[Password] [varchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10001, 1, 1001, 9)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10002, 1, 1001, 12)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10003, 1, 1002, 10)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10004, 3, 1003, 13)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10005, 1, 1003, 7)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10006, 2, 1004, 1)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10007, 2, 1004, 2)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10008, 4, 1005, 3)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10009, 1, 1005, 4)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10010, 2, 1006, 5)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10011, 1, 1006, 5)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10012, 1, 1007, 6)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10013, 1, 1008, 7)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10014, 2, 1009, 8)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10015, 2, 1009, 9)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10016, 1, 1009, 4)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10017, 1, 1010, 10)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10018, 1, 1010, 11)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10019, 1, 1010, 12)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10020, 1, 1011, 13)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10021, 2, 1011, 14)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10022, 1, 1011, 15)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10023, 1, 1012, 16)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10024, 1, 1012, 17)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10025, 1, 1013, 18)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10026, 4, 1013, 19)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10027, 1, 1013, 20)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10028, 1, 1014, 20)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10029, 1, 1015, 21)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10030, 1, 1015, 22)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10031, 2, 1015, 23)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10032, 2, 1015, 24)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10034, 2, 1016, 1)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10035, 1, 1016, 2)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10036, 1, 1016, 3)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10037, 1, 1016, 12)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10038, 1, 1017, 1)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10039, 1, 1017, 2)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10040, 1, 1017, 3)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10041, 1, 1017, 4)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10042, 1, 1018, 1)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10043, 1, 1018, 2)
GO
INSERT [dbo].[CartItem] ([ID], [Quantity], [OrdersID], [ProductID]) VALUES (10045, 1, 1018, 4)
GO
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (1, N'Hàng thực phẩm')
GO
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (2, N'Mỹ phẩm')
GO
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (3, N'Đồ dùng văn phòng phẩm')
GO
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (4, N'Đồ sinh hoạt cá nhân')
GO
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (5, N'Mặt hàng khác')
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1001, CAST(N'2022-11-10' AS Date), 100000, 0, 12)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1002, CAST(N'2022-11-10' AS Date), 200000, 0, 2)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1003, CAST(N'2022-11-10' AS Date), 300000, 0, 2)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1004, CAST(N'2022-11-10' AS Date), 400000, 0, 2)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1005, CAST(N'2022-11-11' AS Date), 300000, 0, 12)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1006, CAST(N'2022-11-11' AS Date), 200000, 0, 5)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1007, CAST(N'2022-11-11' AS Date), 100000, 0, 8)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1008, CAST(N'2022-11-11' AS Date), 100000, 0, 8)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1009, CAST(N'2022-11-12' AS Date), 500000, 0, 8)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1010, CAST(N'2022-11-12' AS Date), 400000, 0, 12)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1011, CAST(N'2022-11-12' AS Date), 200000, 0, 11)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1012, CAST(N'2022-11-13' AS Date), 300000, 0, 4)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1013, CAST(N'2022-11-13' AS Date), 700000, 0, 9)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1014, CAST(N'2022-11-13' AS Date), 200000, 0, 3)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1015, CAST(N'2022-11-14' AS Date), 600000, 0, 5)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1016, CAST(N'2022-11-20' AS Date), 400000, 0, 11)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1017, CAST(N'2022-11-20' AS Date), 350000, 0, 11)
GO
INSERT [dbo].[Orders] ([ID], [OrderDate], [TotalPrice], [DisCount], [UsersID]) VALUES (1018, CAST(N'2022-11-20' AS Date), 300000, 0, 12)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (1, N'Ba rọi heo C.P khay 500g', 100000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (2, N'Ba rọi heo rút sườn C.P khay 500g (1-2 miếng)', 100000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (3, N'Xương đuôi heo Meat Master khay 400g (2-4 miếng)', 50000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (4, N'Gà dai nguyên con nhập khẩu đông lạnh (1,2kg - 1,5kg/con)', 100000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (5, N'Hộp 15 trứng gà tươi 4KFarm', 50000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (6, N'Sữa rửa mặt tinh chất serum Dove dưỡng ẩm sâu giúp da mềm mượt suốt 24 giờ 130g', 100000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (7, N'Sữa rửa mặt tinh chất serum Dove se khít lỗ chân lông kiềm dầu 130g', 100000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (8, N'Dầu gội bồ kết Macaland mềm mượt mắc ca 280ml', 150000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (9, N'Dầu xả Pantene 3 phút diệu kì ngăn rụng tóc 150ml', 50000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (10, N'Kem dưỡng Ponds White Beauty Instabright Tone Up Milk Cream dưỡng trắng nâng tông 50g', 200000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (11, N'Bộ 3 cây bút dạ quang UBL 3 màu', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (12, N'Bút lông màu cỡ lớn UBL SE0002 bộ 10 cây', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (13, N'Viết 3 màu UBL túi 10 cây', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (14, N'Bút lông màu UBL SE0004 bộ 12 cây', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (15, N'Khăn ướt Yuniku hương trà xanh gói 20 miếng - giao màu ngẫu nhiên', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (16, N'Vỉ 2 cái lưỡi dao Gillette Skinguard bảo vệ da vỉ 2', 100000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (17, N'Lăn ngăn mùi Perspi-guard Maximum Strength Antiperspirant khử mồ hôi vượt trội 30ml', 200000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (18, N'Xịt ngăn mùi Perspi-guard Maximum Strength Antiperspirant khử mồ hôi vượt trội 30ml', 300000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (19, N'Khăn ướt người lớn QUICK NURSE không mùi gói 50 miếng', 50000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (20, N'Nồi quấy bột nhôm anod Sunhouse SH99-14M3 14cm', 200000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (21, N'Nồi nhôm Kim Hằng Long-Life 26cm', 200000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (22, N'Bộ 3 nồi nhôm quai tròn xi bóng t3 nhỏ Kim Hằng Bạch Đằng', 200000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (23, N'Kéo cắt vải Hiệp Phát NK95 24.5cm', 50000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (24, N'Dao bào răng cưa thép không gỉ Hiệp Phát 12.5cm', 50000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (25, N'Bộ 3 dao bào bếp trưởng Kim Hằng Cook Chef (giao màu ngẫu nhiên)', 300000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (26, N'Táo Diva mini New Zealand hộp 1kg (8 - 10 trái)', 52000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (27, N'Bưởi năm roi trái từ 1.3kg - 1.4kg', 45000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (28, N'Mận An Phước hộp 1kg (10 - 14 trái)', 45000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (29, N'Lê đường túi 1kg (4-6 trái)', 39000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (30, N'Cam sành túi 1kg (3 - 4 trái)', 30000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (31, N'Chuối cau nải từ 1kg trở lên (giao ngẫu nhiên sống hoặc chín)', 29000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (32, N'Xoài keo túi 1kg (2 - 3 trái)', 28000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (33, N'Dưa hấu đỏ trái từ 1.8kg trở lên', 28600, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (34, N'Dầu gội dưỡng tóc suôn mượt Medel Natural Herbal Refresh Aroma 400ml', 193000, 2, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (35, N'Kem xả Dove phục hồi hư tổn giúp tái cấu trúc tóc hiệu quả 633ml', 143000, 3, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (36, N'Dầu xả mềm mượt & dưỡng ẩm Megumi Smooth and Moist Conditioner 400ml', 159000, 3, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (37, N'Dầu xả sạch sâu & thơm mát Megumi Fresh and Clean Conditioner 400ml', 159000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (38, N'Rượu soju Good Day vị đào 13.5% chai 360ml', 159000, 4, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (39, N'Rượu vang Berri Estates Chardonnay 13% chai 750ml', 259000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (40, N'Rượu vang Ramirana Cabernet Sauvignon 12.5% chai 750ml', 359000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (41, N'6 hộp cà phê sữa đá NesCafé 200ml', 59000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (42, N'Kem trang điểm Pond''s Flawless Radiance Even Tone sáng da đều màu 25g', 147000, 3, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (43, N'Kem dưỡng da ban đêm Pond''s White Beauty Super Night Cream dưỡng ẩm trắng da 50g', 159000, 5, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (44, N'Nước súc miệng Oral Clean Charcoal Detox 300ml', 59000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (45, N'Lược nhuộm thông minh Lavox nâu đen 100ml', 149000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (46, N'Kem nhuộm tạo bọt Beautylabo hồng đào sakura', 139000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (47, N'Nước rửa tay Lifebuoy bạc bảo vệ chai 444ml', 39000, 3, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (48, N'Dung dịch rửa tay kháng khuẩn Lifebuoy bảo vệ vượt trội 10 330ml', 129000, 5, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (49, N'Bấm mi cao cấp Trim', 29000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (50, N'Sáp thơm đuổi muỗi Oasis Relaxing Purple 180g', 59000, 4, 5)
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (1, N'EXP Việt Nam', N'expvietnam02@gmail.com', N'0966484808', N'Tòa Nhà Thông Tấn, Số 124 Đường Trần Hữu Dực, P. Xuân Phương, Q. Nam Từ Liêm, Hà Nội')
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (2, N'Tami Natural Home', N'taminaturalhome@gmail.com', N'0982302430', N'Lô 48, Đường Số 11, Khu Công Nghiệp Tân Đức, Xã Hữu Thạnh, Huyện Đức Hoà,Long An')
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (3, N'Vinacom', N'duyanh01@gmail.com', N'0835368668', N'275/39/3 Bạch Đằng, Phường 15, Quận Bình Thạnh, TPHCM')
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (4, N'Son Nees', N'sonnees@gmail.com', N'0395906022', N'12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh')
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (5, N'Bao Kun', N'baokun@gmail.com', N'0695906222', N'12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (1, N'Nguyễn Thị Thảo', 1, N'nguyenphuongthao01@gmail.com', N'0902121940', N'727/942 Trần Hưng Đạo P.1 Quận 5 TP.Hồ Chí Minh', CAST(N'1997-02-23' AS Date), CAST(N'2021-06-10' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (2, N'Nguyễn Văn Minh', 0, N'trantronghaiminh02@gmail.com', N'0918335697', N'1333/9 Huỳnh Tấn Phát Quận 7 TP.Hồ Chí Minh', CAST(N'1994-08-20' AS Date), CAST(N'2021-04-12' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (3, N'Nguyễn Thị Nhàn', 1, N'phamnhan03@gmail.com', N'0302121900', N'Ân Phong Cầu Giấy TP.Hà Nội', CAST(N'1999-03-20' AS Date), CAST(N'2021-02-22' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (4, N'Nguyễn Thị Hương', 1, N'buithithuhuong04@gmail.com', N'0802121907', N'Kp3 P. Tân Thới Hiệp Q12 TP.Hồ Chí Minh', CAST(N'1998-03-20' AS Date), CAST(N'2021-12-23' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (5, N'Nguyễn Văn Sang', 0, N'nguyenminhsang05@gmail.com', N'0982121915', N'109/5 Thống Nhất P.16 Q.Gò Vấp TP.Hồ Chí Minh', CAST(N'1998-05-11' AS Date), CAST(N'2021-11-12' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (6, N'Nguyễn Thị Trang', 1, N'phamthiminhtrang06@gmail.com', N'0302111901', N'293/150D1 Trường Chinh F14 Quận Tân Bình TP.Hồ Chí Minh', CAST(N'1999-02-22' AS Date), CAST(N'2021-04-23' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (7, N'Nguyễn Văn Dũng', 0, N'nguyenkhanhdung07@gmail.com', N'0332121900', N'133/38A Van Than P.8 Q.6 TP.Hồ Chí Minh', CAST(N'1995-09-20' AS Date), CAST(N'2021-10-10' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (8, N'Nguyễn Thị Mỹ', 1, N'luonglemy08@gmail.com', N'0802121909', N'N4/2T50 Tô Hiến Thành Q.10 TP.Hồ Chí Minh', CAST(N'1997-02-27' AS Date), CAST(N'2021-02-26' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (9, N'Nguyễn Thị Quyên', 1, N'nguyenlequyen09@gmail.com', N'0882121960', N'Ngõ 165 Cầu Giấy TP.Hà Nội', CAST(N'1997-06-12' AS Date), CAST(N'2021-12-14' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (10, N'Nguyễn Văn Thiệp', 0, N'doanmanhthiet10@gmail.com', N'0302121911', N'507C Cầu Giấy TP.Hà Nội', CAST(N'1996-03-22' AS Date), CAST(N'2021-09-18' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (11, N'Huỳnh Quốc Bảo', 0, N'bao11@gmail.com', N'0333399988', N'12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh', CAST(N'2002-02-22' AS Date), CAST(N'2021-01-27' AS Date), N'ROLE_ADMIN', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (12, N'Nguyễn Văn Sơn', 0, N'son12@gmail.com', N'0395906032', N'12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh', CAST(N'2002-02-22' AS Date), CAST(N'2021-01-27' AS Date), N'ROLE_EMPLOYEE', N'pass12345')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (13, N'Nguyễn Văn Quý', 1, N'quy13@gmail.com', N'0395906045', N'12 Nguyễn văn bảo p4 gò vấp TP.Hồ Chí Minh', CAST(N'2002-02-01' AS Date), CAST(N'2021-01-13' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
ALTER TABLE [dbo].[CartItem]  WITH CHECK ADD FOREIGN KEY([OrdersID])
REFERENCES [dbo].[Orders] ([ID])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[CartItem]  WITH CHECK ADD FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ID])
GO
ALTER TABLE [dbo].[Orders]  WITH CHECK ADD FOREIGN KEY([UsersID])
REFERENCES [dbo].[Users] ([ID])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([CategoriesID])
REFERENCES [dbo].[Categories] ([ID])
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD FOREIGN KEY([SuppliersID])
REFERENCES [dbo].[Suppliers] ([ID])
GO
