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
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (1, N'H??ng th???c ph???m')
GO
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (2, N'M??? ph???m')
GO
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (3, N'????? d??ng v??n ph??ng ph???m')
GO
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (4, N'????? sinh ho???t c?? nh??n')
GO
INSERT [dbo].[Categories] ([ID], [Name]) VALUES (5, N'M????t ha??ng kha??c')
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
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (1, N'Ba r???i heo C.P khay 500g', 100000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (2, N'Ba r???i heo r??t s?????n C.P khay 500g (1-2 mi???ng)', 100000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (3, N'X????ng ??u??i heo Meat Master khay 400g (2-4 mi???ng)', 50000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (4, N'G?? dai nguy??n con nh???p kh???u ????ng l???nh (1,2kg - 1,5kg/con)', 100000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (5, N'H???p 15 tr???ng g?? t????i 4KFarm', 50000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (6, N'S???a r???a m???t tinh ch???t serum Dove d?????ng ???m s??u gi??p da m???m m?????t su???t 24 gi??? 130g', 100000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (7, N'S???a r???a m???t tinh ch???t serum Dove se kh??t l??? ch??n l??ng ki???m d???u 130g', 100000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (8, N'D???u g???i b??? k???t Macaland m???m m?????t m???c ca 280ml', 150000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (9, N'D???u x??? Pantene 3 ph??t di???u k?? ng??n r???ng t??c 150ml', 50000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (10, N'Kem d?????ng Ponds White Beauty Instabright Tone Up Milk Cream d?????ng tr???ng n??ng t??ng 50g', 200000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (11, N'B??? 3 c??y b??t d??? quang UBL 3 m??u', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (12, N'B??t l??ng m??u c??? l???n UBL SE0002 b??? 10 c??y', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (13, N'Vi???t 3 m??u UBL t??i 10 c??y', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (14, N'B??t l??ng m??u UBL SE0004 b??? 12 c??y', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (15, N'Kh??n ?????t Yuniku h????ng tr?? xanh g??i 20 mi???ng - giao m??u ng???u nhi??n', 50000, 3, 3)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (16, N'V??? 2 c??i l?????i dao Gillette Skinguard b???o v??? da v??? 2', 100000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (17, N'L??n ng??n m??i Perspi-guard Maximum Strength Antiperspirant kh??? m??? h??i v?????t tr???i 30ml', 200000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (18, N'X???t ng??n m??i Perspi-guard Maximum Strength Antiperspirant kh??? m??? h??i v?????t tr???i 30ml', 300000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (19, N'Kh??n ?????t ng?????i l???n QUICK NURSE kh??ng m??i g??i 50 mi???ng', 50000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (20, N'N???i qu???y b???t nh??m anod Sunhouse SH99-14M3 14cm', 200000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (21, N'N???i nh??m Kim H???ng Long-Life 26cm', 200000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (22, N'B??? 3 n???i nh??m quai tr??n xi b??ng t3 nh??? Kim H???ng B???ch ?????ng', 200000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (23, N'K??o c???t v???i Hi???p Ph??t NK95 24.5cm', 50000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (24, N'Dao b??o r??ng c??a th??p kh??ng g??? Hi???p Ph??t 12.5cm', 50000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (25, N'B??? 3 dao b??o b???p tr?????ng Kim H???ng Cook Chef (giao m??u ng???u nhi??n)', 300000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (26, N'T??o Diva mini New Zealand h???p 1kg (8 - 10 tr??i)', 52000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (27, N'B?????i n??m roi tr??i t??? 1.3kg - 1.4kg', 45000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (28, N'M???n An Ph?????c h???p 1kg (10 - 14 tr??i)', 45000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (29, N'L?? ???????ng t??i 1kg (4-6 tr??i)', 39000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (30, N'Cam s??nh t??i 1kg (3 - 4 tr??i)', 30000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (31, N'Chu???i cau n???i t??? 1kg tr??? l??n (giao ng???u nhi??n s???ng ho???c ch??n)', 29000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (32, N'Xo??i keo t??i 1kg (2 - 3 tr??i)', 28000, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (33, N'D??a h???u ????? tr??i t??? 1.8kg tr??? l??n', 28600, 1, 1)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (34, N'D???u g???i d?????ng t??c su??n m?????t Medel Natural Herbal Refresh Aroma 400ml', 193000, 2, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (35, N'Kem x??? Dove ph???c h???i h?? t???n gi??p t??i c???u tr??c t??c hi???u qu??? 633ml', 143000, 3, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (36, N'D???u x??? m???m m?????t & d?????ng ???m Megumi Smooth and Moist Conditioner 400ml', 159000, 3, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (37, N'D???u x??? s???ch s??u & th??m m??t Megumi Fresh and Clean Conditioner 400ml', 159000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (38, N'R?????u soju Good Day v??? ????o 13.5% chai 360ml', 159000, 4, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (39, N'R?????u vang Berri Estates Chardonnay 13% chai 750ml', 259000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (40, N'R?????u vang Ramirana Cabernet Sauvignon 12.5% chai 750ml', 359000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (41, N'6 h???p c?? ph?? s???a ???? NesCaf?? 200ml', 59000, 5, 5)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (42, N'Kem trang ??i???m Pond''s Flawless Radiance Even Tone s??ng da ?????u m??u 25g', 147000, 3, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (43, N'Kem d?????ng da ban ????m Pond''s White Beauty Super Night Cream d?????ng ???m tr???ng da 50g', 159000, 5, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (44, N'N?????c s??c mi???ng Oral Clean Charcoal Detox 300ml', 59000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (45, N'L?????c nhu???m th??ng minh Lavox n??u ??en 100ml', 149000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (46, N'Kem nhu???m t???o b???t Beautylabo h???ng ????o sakura', 139000, 2, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (47, N'N?????c r???a tay Lifebuoy b???c b???o v??? chai 444ml', 39000, 3, 2)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (48, N'Dung d???ch r???a tay kh??ng khu???n Lifebuoy b???o v??? v?????t tr???i 10 330ml', 129000, 5, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (49, N'B???m mi cao c???p Trim', 29000, 4, 4)
GO
INSERT [dbo].[Product] ([ID], [Name], [Price], [SuppliersID], [CategoriesID]) VALUES (50, N'S??p th??m ??u???i mu???i Oasis Relaxing Purple 180g', 59000, 4, 5)
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (1, N'EXP Vi???t Nam', N'expvietnam02@gmail.com', N'0966484808', N'T??a Nh?? Th??ng T???n, S??? 124 ???????ng Tr???n H???u D???c, P. Xu??n Ph????ng, Q. Nam T??? Li??m, H?? N???i')
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (2, N'Tami Natural Home', N'taminaturalhome@gmail.com', N'0982302430', N'L?? 48, ???????ng S??? 11, Khu C??ng Nghi???p T??n ?????c, X?? H???u Th???nh, Huy???n ?????c Ho??,Long An')
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (3, N'Vinacom', N'duyanh01@gmail.com', N'0835368668', N'275/39/3 B???ch ?????ng, Ph?????ng 15, Qu???n B??nh Th???nh, TPHCM')
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (4, N'Son Nees', N'sonnees@gmail.com', N'0395906022', N'12 Nguy???n v??n b???o p4 g?? v???p TP.H??? Ch?? Minh')
GO
INSERT [dbo].[Suppliers] ([ID], [Name], [Gmail], [Phone], [Address]) VALUES (5, N'Bao Kun', N'baokun@gmail.com', N'0695906222', N'12 Nguy???n v??n b???o p4 g?? v???p TP.H??? Ch?? Minh')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (1, N'Nguy???n Th??? Th???o', 1, N'nguyenphuongthao01@gmail.com', N'0902121940', N'727/942 Tr???n H??ng ?????o P.1 Qu???n 5 TP.H??? Ch?? Minh', CAST(N'1997-02-23' AS Date), CAST(N'2021-06-10' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (2, N'Nguy???n V??n Minh', 0, N'trantronghaiminh02@gmail.com', N'0918335697', N'1333/9 Hu???nh T???n Ph??t Qu???n 7 TP.H??? Ch?? Minh', CAST(N'1994-08-20' AS Date), CAST(N'2021-04-12' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (3, N'Nguy???n Th??? Nh??n', 1, N'phamnhan03@gmail.com', N'0302121900', N'??n Phong C???u Gi???y TP.H?? N???i', CAST(N'1999-03-20' AS Date), CAST(N'2021-02-22' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (4, N'Nguy???n Th??? H????ng', 1, N'buithithuhuong04@gmail.com', N'0802121907', N'Kp3 P. T??n Th???i Hi???p Q12 TP.H??? Ch?? Minh', CAST(N'1998-03-20' AS Date), CAST(N'2021-12-23' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (5, N'Nguy???n V??n Sang', 0, N'nguyenminhsang05@gmail.com', N'0982121915', N'109/5 Th???ng Nh???t P.16 Q.G?? V???p TP.H??? Ch?? Minh', CAST(N'1998-05-11' AS Date), CAST(N'2021-11-12' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (6, N'Nguy???n Th??? Trang', 1, N'phamthiminhtrang06@gmail.com', N'0302111901', N'293/150D1 Tr?????ng Chinh F14 Qu???n T??n B??nh TP.H??? Ch?? Minh', CAST(N'1999-02-22' AS Date), CAST(N'2021-04-23' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (7, N'Nguy???n V??n D??ng', 0, N'nguyenkhanhdung07@gmail.com', N'0332121900', N'133/38A Van Than P.8 Q.6 TP.H??? Ch?? Minh', CAST(N'1995-09-20' AS Date), CAST(N'2021-10-10' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (8, N'Nguy???n Th??? M???', 1, N'luonglemy08@gmail.com', N'0802121909', N'N4/2T50 T?? Hi???n Th??nh Q.10 TP.H??? Ch?? Minh', CAST(N'1997-02-27' AS Date), CAST(N'2021-02-26' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (9, N'Nguy???n Th??? Quy??n', 1, N'nguyenlequyen09@gmail.com', N'0882121960', N'Ng?? 165 C???u Gi???y TP.H?? N???i', CAST(N'1997-06-12' AS Date), CAST(N'2021-12-14' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (10, N'Nguy???n V??n Thi???p', 0, N'doanmanhthiet10@gmail.com', N'0302121911', N'507C C???u Gi???y TP.H?? N???i', CAST(N'1996-03-22' AS Date), CAST(N'2021-09-18' AS Date), N'ROLE_EMPLOYEE', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (11, N'Hu???nh Qu???c B???o', 0, N'bao11@gmail.com', N'0333399988', N'12 Nguy???n v??n b???o p4 g?? v???p TP.H??? Ch?? Minh', CAST(N'2002-02-22' AS Date), CAST(N'2021-01-27' AS Date), N'ROLE_ADMIN', N'pass123')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (12, N'Nguy???n V??n S??n', 0, N'son12@gmail.com', N'0395906032', N'12 Nguy???n v??n b???o p4 g?? v???p TP.H??? Ch?? Minh', CAST(N'2002-02-22' AS Date), CAST(N'2021-01-27' AS Date), N'ROLE_EMPLOYEE', N'pass12345')
GO
INSERT [dbo].[Users] ([ID], [Name], [Gender], [Gmail], [Phone], [Address], [BirthDate], [HireDate], [Role], [Password]) VALUES (13, N'Nguy???n V??n Qu??', 1, N'quy13@gmail.com', N'0395906045', N'12 Nguy???n v??n b???o p4 g?? v???p TP.H??? Ch?? Minh', CAST(N'2002-02-01' AS Date), CAST(N'2021-01-13' AS Date), N'ROLE_EMPLOYEE', N'pass123')
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
