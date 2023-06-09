USE [master]
GO
/****** Object:  Database [Java_Project]    Script Date: 5/31/2023 1:01:30 AM ******/
CREATE DATABASE [Java_Project]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Java_Project', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Java_Project.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'Java_Project_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\Java_Project_log.ldf' , SIZE = 73728KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [Java_Project] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Java_Project].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Java_Project] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Java_Project] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Java_Project] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Java_Project] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Java_Project] SET ARITHABORT OFF 
GO
ALTER DATABASE [Java_Project] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Java_Project] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Java_Project] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Java_Project] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Java_Project] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Java_Project] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Java_Project] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Java_Project] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Java_Project] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Java_Project] SET  ENABLE_BROKER 
GO
ALTER DATABASE [Java_Project] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Java_Project] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Java_Project] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Java_Project] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Java_Project] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Java_Project] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Java_Project] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Java_Project] SET RECOVERY FULL 
GO
ALTER DATABASE [Java_Project] SET  MULTI_USER 
GO
ALTER DATABASE [Java_Project] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Java_Project] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Java_Project] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Java_Project] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Java_Project] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [Java_Project] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'Java_Project', N'ON'
GO
ALTER DATABASE [Java_Project] SET QUERY_STORE = OFF
GO
USE [Java_Project]
GO
/****** Object:  Table [dbo].[account]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[account_id] [int] NOT NULL,
	[username] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[role] [nvarchar](50) NULL,
	[emp_id] [int] NOT NULL,
	[created_at] [datetime] NOT NULL,
	[modified_by_id_account] [int] NULL,
	[modified_at] [datetime] NOT NULL,
	[available] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[account_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[dayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[dayoff](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[emp_id] [int] NULL,
	[type_code] [int] NULL,
	[started_date] [date] NULL,
	[end_date] [date] NULL,
	[status] [int] NULL,
	[granted_by_id] [int] NULL,
	[checked_at] [datetime] NULL,
	[reason] [nvarchar](300) NULL,
	[received_at] [datetime] NOT NULL,
	[available] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[department]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[department](
	[id] [int] NOT NULL,
	[name_department] [nvarchar](200) NULL,
	[manager_dpt_id] [int] NULL,
	[number_emp_in_dpt] [int] NULL,
	[created_at] [datetime] NOT NULL,
	[modified_by_id_account] [int] NULL,
	[modified_at] [datetime] NOT NULL,
	[available] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[emp_box]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[emp_box](
	[id] [int] NOT NULL,
	[id_emp] [int] NULL,
	[type_code_dayoff] [int] NULL,
	[start_date] [date] NULL,
	[end_date] [date] NULL,
	[reason] [nvarchar](300) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[employee]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[employee](
	[emp_id] [int] NOT NULL,
	[fullname] [nvarchar](200) NULL,
	[gender] [bit] NULL,
	[position] [nvarchar](50) NULL,
	[email] [nvarchar](50) NULL,
	[phoneNumber] [nvarchar](50) NULL,
	[department_id] [int] NULL,
	[manager_id] [int] NULL,
	[start_to_work] [date] NULL,
	[picture] [nvarchar](200) NULL,
	[created_at] [datetime] NOT NULL,
	[modified_by_id_account] [int] NULL,
	[modified_at] [datetime] NOT NULL,
	[hired] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[emp_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[leave_day_permission]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[leave_day_permission](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[emp_id] [int] NULL,
	[start_work_at] [date] NULL,
	[now] [date] NULL,
	[total_years] [int] NULL,
	[total_leave_day_allowed] [int] NULL,
	[created_at] [datetime] NOT NULL,
	[modified_by_id_account] [int] NULL,
	[modified_at] [datetime] NOT NULL,
	[daysleft] [int] NULL,
	[check_reset] [int] NULL,
	[available] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[position]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[position](
	[id_position] [int] IDENTITY(1,1) NOT NULL,
	[name_of_position] [nvarchar](50) NOT NULL,
	[number_emp] [int] NULL,
	[created_at] [datetime] NOT NULL,
	[modified_by_id_account] [int] NULL,
	[modified_at] [datetime] NOT NULL,
	[available] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[name_of_position] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[role]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[role_name] [nvarchar](50) NOT NULL,
	[access_level] [int] NULL,
	[created_at] [datetime] NOT NULL,
	[modified_by_id_account] [int] NULL,
	[modified_at] [datetime] NOT NULL,
	[available] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[role_name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[status_dayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[status_dayoff](
	[id] [int] NOT NULL,
	[name_status] [nvarchar](50) NULL,
	[created_at] [datetime] NOT NULL,
	[modified_by_id_account] [int] NULL,
	[modified_at] [datetime] NOT NULL,
	[available] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[type_of_dayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[type_of_dayoff](
	[day_off_code] [int] NOT NULL,
	[name_of_dayoff] [nvarchar](50) NULL,
	[allowed_day_off] [int] NULL,
	[created_at] [datetime] NOT NULL,
	[modified_by_id_account] [int] NULL,
	[modified_at] [datetime] NOT NULL,
	[times_per_year] [int] NULL,
	[available] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[day_off_code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (100, N'kitty', N'kitty123', N'Admin Highest', 1, CAST(N'2023-04-25T22:35:20.483' AS DateTime), 100, CAST(N'2023-04-25T22:35:20.483' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (101, N'nana', N'nana123', N'Manager', 3, CAST(N'2023-04-27T17:06:50.543' AS DateTime), 100, CAST(N'2023-05-27T04:48:41.907' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (110, N'abc', N'abc123', N'Manager', 2, CAST(N'2023-04-26T01:07:51.200' AS DateTime), 100, CAST(N'2023-05-27T04:03:10.373' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (111, N'Hihi_42BB', N'Hihi_42BB', N'Employee', 4, CAST(N'2023-05-27T05:56:47.710' AS DateTime), 100, CAST(N'2023-05-27T05:56:47.710' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (112, N'Haha_F503', N'convitcon125', N'Employee', 5, CAST(N'2023-05-27T05:56:47.710' AS DateTime), 100, CAST(N'2023-05-27T05:56:47.710' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (113, N'Huhu_E7A7', N'convitcon125', N'Employee', 6, CAST(N'2023-05-27T05:56:47.710' AS DateTime), 100, CAST(N'2023-05-27T05:56:47.710' AS DateTime), 0)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (114, N'tuon_9262', N'tuon_9262', N'Employee', 7, CAST(N'2023-05-28T17:42:32.247' AS DateTime), 100, CAST(N'2023-05-28T17:42:32.247' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (115, N'dcve_0A7D', N'dcve_0A7D', N'Employee', 8, CAST(N'2023-05-28T17:42:32.247' AS DateTime), 100, CAST(N'2023-05-28T17:42:32.247' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (116, N'haha_38FD', N'haha_38FD', N'Employee', 9, CAST(N'2023-05-28T19:46:48.480' AS DateTime), 100, CAST(N'2023-05-28T19:46:48.480' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (117, N'Lola_91AC', N'Lola_91AC', N'Employee', 10, CAST(N'2023-05-28T19:50:57.577' AS DateTime), 100, CAST(N'2023-05-28T19:50:57.577' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (118, N'haha_9CE2', N'haha_9CE2', N'Employee', 11, CAST(N'2023-05-28T19:52:09.640' AS DateTime), 100, CAST(N'2023-05-28T19:52:09.640' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (119, N'kiii_2681', N'kiii_2681', N'Employee', 12, CAST(N'2023-05-28T19:53:45.357' AS DateTime), 100, CAST(N'2023-05-28T19:53:45.357' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (120, N'thao_A0AC', N'thao_A0AC', N'Employee', 13, CAST(N'2023-05-28T20:02:10.427' AS DateTime), 100, CAST(N'2023-05-28T20:02:10.427' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (121, N'kitt_713D', N'kitt_713D', N'Employee', 14, CAST(N'2023-05-28T20:06:59.360' AS DateTime), 100, CAST(N'2023-05-28T20:06:59.360' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (122, N'haha_88EA', N'haha_88EA', N'Employee', 15, CAST(N'2023-05-28T20:06:59.363' AS DateTime), 100, CAST(N'2023-05-28T20:06:59.363' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (123, N'uiui_44A4', N'uiui_44A4', N'Administration', 16, CAST(N'2023-05-30T23:08:22.380' AS DateTime), 100, CAST(N'2023-05-30T23:08:22.380' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (124, N'judh_E87D', N'judh_E87D', N'Admin Highest', 17, CAST(N'2023-05-30T23:08:55.350' AS DateTime), 100, CAST(N'2023-05-30T23:08:55.350' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (125, N'haha_CA3F', N'haha_CA3F', N'Employee', 18, CAST(N'2023-05-30T23:29:18.797' AS DateTime), 100, CAST(N'2023-05-30T23:29:18.797' AS DateTime), 1)
INSERT [dbo].[account] ([account_id], [username], [password], [role], [emp_id], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (126, N'kitt_0D16', N'kitt_0D16', N'Employee', 19, CAST(N'2023-05-31T00:53:18.720' AS DateTime), 100, CAST(N'2023-05-31T00:53:18.720' AS DateTime), 2)
GO
SET IDENTITY_INSERT [dbo].[dayoff] ON 

INSERT [dbo].[dayoff] ([id], [emp_id], [type_code], [started_date], [end_date], [status], [granted_by_id], [checked_at], [reason], [received_at], [available]) VALUES (2, 2, 213, CAST(N'2023-04-28' AS Date), CAST(N'2023-05-04' AS Date), 1, 101, CAST(N'2023-05-24T02:10:15.440' AS DateTime), N'haha', CAST(N'2023-04-28T20:34:51.750' AS DateTime), 1)
INSERT [dbo].[dayoff] ([id], [emp_id], [type_code], [started_date], [end_date], [status], [granted_by_id], [checked_at], [reason], [received_at], [available]) VALUES (3, 2, 214, CAST(N'2023-04-28' AS Date), CAST(N'2023-05-03' AS Date), 2, 101, CAST(N'2023-05-11T02:36:20.167' AS DateTime), N'huhu', CAST(N'2023-04-28T20:35:10.693' AS DateTime), 1)
INSERT [dbo].[dayoff] ([id], [emp_id], [type_code], [started_date], [end_date], [status], [granted_by_id], [checked_at], [reason], [received_at], [available]) VALUES (4, 2, 211, CAST(N'2023-04-28' AS Date), CAST(N'2023-06-21' AS Date), 1, 101, CAST(N'2023-05-09T14:06:42.713' AS DateTime), N'hello', CAST(N'2023-04-28T20:50:42.767' AS DateTime), 1)
INSERT [dbo].[dayoff] ([id], [emp_id], [type_code], [started_date], [end_date], [status], [granted_by_id], [checked_at], [reason], [received_at], [available]) VALUES (5, 3, 211, CAST(N'2023-05-09' AS Date), CAST(N'2023-05-09' AS Date), 1, 100, CAST(N'2023-05-12T20:22:58.907' AS DateTime), N'benh qua huhu', CAST(N'2023-05-09T12:47:26.203' AS DateTime), 1)
INSERT [dbo].[dayoff] ([id], [emp_id], [type_code], [started_date], [end_date], [status], [granted_by_id], [checked_at], [reason], [received_at], [available]) VALUES (11, 2, 211, CAST(N'2023-07-20' AS Date), CAST(N'2023-07-25' AS Date), 1, 100, CAST(N'2023-05-29T14:43:59.567' AS DateTime), N'bbb', CAST(N'2023-05-24T13:01:09.453' AS DateTime), 1)
INSERT [dbo].[dayoff] ([id], [emp_id], [type_code], [started_date], [end_date], [status], [granted_by_id], [checked_at], [reason], [received_at], [available]) VALUES (17, 7, 211, CAST(N'2023-05-29' AS Date), CAST(N'2023-05-29' AS Date), 3, NULL, NULL, N'benh', CAST(N'2023-05-29T13:59:44.763' AS DateTime), NULL)
INSERT [dbo].[dayoff] ([id], [emp_id], [type_code], [started_date], [end_date], [status], [granted_by_id], [checked_at], [reason], [received_at], [available]) VALUES (19, 7, 211, CAST(N'2023-05-30' AS Date), CAST(N'2023-05-30' AS Date), 3, NULL, NULL, N'', CAST(N'2023-05-29T14:01:07.540' AS DateTime), NULL)
INSERT [dbo].[dayoff] ([id], [emp_id], [type_code], [started_date], [end_date], [status], [granted_by_id], [checked_at], [reason], [received_at], [available]) VALUES (21, 7, 211, CAST(N'2023-07-12' AS Date), CAST(N'2023-07-12' AS Date), 1, 110, CAST(N'2023-05-29T14:15:01.607' AS DateTime), N'', CAST(N'2023-05-29T14:12:47.100' AS DateTime), NULL)
INSERT [dbo].[dayoff] ([id], [emp_id], [type_code], [started_date], [end_date], [status], [granted_by_id], [checked_at], [reason], [received_at], [available]) VALUES (22, 7, 211, CAST(N'2023-06-12' AS Date), CAST(N'2023-06-12' AS Date), 3, NULL, NULL, N'', CAST(N'2023-05-29T14:26:36.917' AS DateTime), NULL)
SET IDENTITY_INSERT [dbo].[dayoff] OFF
GO
INSERT [dbo].[department] ([id], [name_department], [manager_dpt_id], [number_emp_in_dpt], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (501, N'Human Resource', 101, 3, CAST(N'2023-04-25T22:15:06.030' AS DateTime), 100, CAST(N'2023-05-27T04:48:41.910' AS DateTime), 1)
INSERT [dbo].[department] ([id], [name_department], [manager_dpt_id], [number_emp_in_dpt], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (502, N'Research and Development', 110, 2, CAST(N'2023-04-25T22:15:35.967' AS DateTime), 100, CAST(N'2023-05-27T04:44:17.867' AS DateTime), 1)
INSERT [dbo].[department] ([id], [name_department], [manager_dpt_id], [number_emp_in_dpt], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (503, N'System Management', 100, 1, CAST(N'2023-04-25T22:25:24.103' AS DateTime), 100, CAST(N'2023-05-27T04:44:17.867' AS DateTime), 1)
GO
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (1, N'Tuong Vy', 0, N'Administration Highest', N'new.vytruong.1812@gmail.com', N'0784991812', 503, NULL, CAST(N'2023-04-25' AS Date), N'/image/abc.png', CAST(N'2023-04-25T22:30:02.660' AS DateTime), 100, CAST(N'2023-04-25T22:30:02.660' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (2, N'Louise', 0, N'Manager', N'abc@gmail.com', N'078749999', 502, 100, CAST(N'2023-04-26' AS Date), N'/image/abc.png', CAST(N'2023-04-26T01:06:46.457' AS DateTime), 100, CAST(N'2023-05-27T04:29:45.340' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (3, N'Nana', 0, N'Manager', N'nana@gmail.com', N'01234567', 501, 100, CAST(N'2023-04-27' AS Date), N'/image/abc.png', CAST(N'2023-04-27T16:54:06.263' AS DateTime), 100, CAST(N'2023-05-27T04:48:41.907' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (4, N'Hihi', 1, N'Employee', N'hi@gmail.com', N'01234567', 501, 101, CAST(N'2023-04-27' AS Date), N'/image/abc.png', CAST(N'2023-04-27T16:54:38.613' AS DateTime), 100, CAST(N'2023-04-27T16:54:38.613' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (5, N'Haha', 1, N'Employee', N'haha@gmail.com', N'01234567', 502, 110, CAST(N'2023-04-27' AS Date), N'/image/abc.png', CAST(N'2023-04-27T16:54:49.517' AS DateTime), 100, CAST(N'2023-05-27T04:29:39.000' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (6, N'Huhu', 1, N'Employee', N'huhu@gmail.com', N'01234567', 501, 101, CAST(N'2023-04-27' AS Date), N'/image/abc.png', CAST(N'2023-04-27T16:55:04.993' AS DateTime), 100, CAST(N'2023-04-27T16:55:04.993' AS DateTime), 2)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (7, N'tuong vy', 0, N'Employee', N'tuongvy@gmail.com', N'0784999999', 502, 110, CAST(N'2023-05-28' AS Date), N'/image/abc.png', CAST(N'2023-05-28T02:23:53.077' AS DateTime), 100, CAST(N'2023-05-28T02:23:53.077' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (8, N'dcvevvrv', 1, N'Employee', N'wdiws@gmail.com', N'249639584', 501, 101, CAST(N'2023-05-28' AS Date), N'/image/abc.png', CAST(N'2023-05-28T02:40:14.313' AS DateTime), 100, CAST(N'2023-05-28T02:40:14.313' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (9, N'hahahaha', 1, N'Employee', N'ee@gmail.com', N'0299334734', 501, 101, CAST(N'2023-05-28' AS Date), N'/image/abc.png', CAST(N'2023-05-28T19:45:53.877' AS DateTime), 100, CAST(N'2023-05-28T19:45:53.877' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (10, N'Lola', 0, N'Employee', N'employee@gmail.com', N'121324343', 501, 101, CAST(N'2023-05-28' AS Date), N'/image/abc.png', CAST(N'2023-05-28T19:50:50.767' AS DateTime), 100, CAST(N'2023-05-28T19:50:50.767' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (11, N'hahahahaha', 0, N'Employee', N'uuuu@gmail.com', N'23828468346', 501, 101, CAST(N'2023-05-28' AS Date), N'/image/abc.png', CAST(N'2023-05-28T19:52:05.670' AS DateTime), 100, CAST(N'2023-05-28T19:52:05.670' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (12, N'kiiiiiiii', 0, N'Employee', N'uuuuuuuuu@gmail.com', N'238864734', 501, 101, CAST(N'2023-05-28' AS Date), N'/image/abc.png', CAST(N'2023-05-28T19:53:41.203' AS DateTime), 100, CAST(N'2023-05-28T19:53:41.203' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (13, N'thaothao', 1, N'Employee', N'tuongvyhahah@gmail.com', N'12345567', 502, 110, CAST(N'2023-05-28' AS Date), N'/image/abc.png', CAST(N'2023-05-28T20:01:33.307' AS DateTime), 100, CAST(N'2023-05-28T20:01:33.307' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (14, N'kittycute', 0, N'Employee', N'kiii@gmail.com', N'1872637264', 501, 101, CAST(N'2023-05-28' AS Date), N'/image/abc.png', CAST(N'2023-05-28T20:06:21.987' AS DateTime), 100, CAST(N'2023-05-28T20:06:21.987' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (15, N'hahaha', 0, N'Employee', N'ooooo@gmail.com', N'11372543', 501, 101, CAST(N'2023-05-28' AS Date), N'/image/abc.png', CAST(N'2023-05-28T20:06:44.680' AS DateTime), 100, CAST(N'2023-05-28T20:06:44.680' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (16, N'uiuijo', 1, N'Administration', N'abclalala@gmail.com', N'02838254', 501, 101, CAST(N'2023-05-30' AS Date), N'/image/abc.png', CAST(N'2023-05-30T22:23:34.133' AS DateTime), 100, CAST(N'2023-05-30T22:23:34.133' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (17, N'judhehxe', 1, N'Administration Highest', N'uuuuuuuu@gmail.com', N'12345', 501, 101, CAST(N'2023-05-30' AS Date), N'/image/abc.png', CAST(N'2023-05-30T23:08:51.610' AS DateTime), 100, CAST(N'2023-05-30T23:08:51.610' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (18, N'hahahahaaaa', 1, N'Employee', N'ultr@gmail.com', N'0992737534', 501, 101, CAST(N'2023-05-30' AS Date), N'/image/abc.png', CAST(N'2023-05-30T23:25:31.690' AS DateTime), 100, CAST(N'2023-05-30T23:25:31.690' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (19, N'kittyhaha', 0, N'Employee', N'kitty@gmail.com', N'24839743545', 501, 101, CAST(N'2023-05-31' AS Date), N'/image/abc.png', CAST(N'2023-05-31T00:53:13.360' AS DateTime), 100, CAST(N'2023-05-31T00:53:13.360' AS DateTime), 0)
INSERT [dbo].[employee] ([emp_id], [fullname], [gender], [position], [email], [phoneNumber], [department_id], [manager_id], [start_to_work], [picture], [created_at], [modified_by_id_account], [modified_at], [hired]) VALUES (20, N'kiuchi', 1, N'Administration', N'employee1@gmail.com', N'19328432', 501, 100, CAST(N'2023-05-31' AS Date), N'/image/abc.png', CAST(N'2023-05-31T00:59:13.200' AS DateTime), 100, CAST(N'2023-05-31T00:59:13.200' AS DateTime), 0)
GO
SET IDENTITY_INSERT [dbo].[leave_day_permission] ON 

INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (325, 1, CAST(N'2023-04-25' AS Date), CAST(N'2023-04-26' AS Date), 0, 12, CAST(N'2023-04-26T01:44:55.780' AS DateTime), 100, CAST(N'2023-04-26T01:44:55.780' AS DateTime), 12, 1, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (326, 2, CAST(N'2023-04-25' AS Date), CAST(N'2023-04-26' AS Date), 0, 12, CAST(N'2023-04-25T00:00:00.000' AS DateTime), 100, CAST(N'2023-04-25T00:00:00.000' AS DateTime), 10, 1, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (327, 3, CAST(N'2023-05-05' AS Date), CAST(N'2023-05-05' AS Date), 0, 12, CAST(N'2023-05-05T20:37:47.013' AS DateTime), 100, CAST(N'2023-05-05T20:37:47.013' AS DateTime), 12, 1, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (328, 4, CAST(N'2023-04-27' AS Date), CAST(N'2022-03-21' AS Date), 0, 0, CAST(N'2023-05-21T01:04:41.217' AS DateTime), 100, CAST(N'2023-05-21T01:04:41.217' AS DateTime), 12, 2, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (329, 5, CAST(N'2023-04-27' AS Date), CAST(N'2023-05-21' AS Date), 0, 12, CAST(N'2023-05-21T01:04:41.217' AS DateTime), 100, CAST(N'2023-05-21T01:04:41.217' AS DateTime), 12, 1, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (330, 6, CAST(N'2023-04-27' AS Date), CAST(N'2023-05-21' AS Date), 0, 12, CAST(N'2023-05-21T01:04:41.217' AS DateTime), 100, CAST(N'2023-05-21T01:04:41.217' AS DateTime), 12, 1, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (331, 4, CAST(N'2023-04-27' AS Date), CAST(N'2022-04-21' AS Date), 0, 12, CAST(N'2023-05-21T01:19:33.280' AS DateTime), 100, CAST(N'2023-05-21T01:19:33.280' AS DateTime), 12, 1, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (382, 7, CAST(N'2023-05-28' AS Date), CAST(N'2023-05-28' AS Date), 0, 12, CAST(N'2023-05-28T02:23:53.960' AS DateTime), 100, CAST(N'2023-05-28T02:23:53.960' AS DateTime), 11, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (383, 8, CAST(N'2023-05-28' AS Date), CAST(N'2023-05-28' AS Date), 0, 12, CAST(N'2023-05-28T02:40:15.310' AS DateTime), 100, CAST(N'2023-05-28T02:40:15.310' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (384, 9, CAST(N'2023-05-28' AS Date), CAST(N'2023-05-28' AS Date), 0, 12, CAST(N'2023-05-28T19:45:54.600' AS DateTime), 100, CAST(N'2023-05-28T19:45:54.600' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (385, 10, CAST(N'2023-05-28' AS Date), CAST(N'2023-05-28' AS Date), 0, 12, CAST(N'2023-05-28T19:50:50.933' AS DateTime), 100, CAST(N'2023-05-28T19:50:50.933' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (386, 11, CAST(N'2023-05-28' AS Date), CAST(N'2023-05-28' AS Date), 0, 12, CAST(N'2023-05-28T19:52:05.937' AS DateTime), 100, CAST(N'2023-05-28T19:52:05.937' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (387, 12, CAST(N'2023-05-28' AS Date), CAST(N'2023-05-28' AS Date), 0, 12, CAST(N'2023-05-28T19:53:41.293' AS DateTime), 100, CAST(N'2023-05-28T19:53:41.293' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (388, 13, CAST(N'2023-05-28' AS Date), CAST(N'2023-05-28' AS Date), 0, 12, CAST(N'2023-05-28T20:01:34.247' AS DateTime), 100, CAST(N'2023-05-28T20:01:34.247' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (389, 14, CAST(N'2023-05-28' AS Date), CAST(N'2023-05-28' AS Date), 0, 12, CAST(N'2023-05-28T20:06:22.167' AS DateTime), 100, CAST(N'2023-05-28T20:06:22.167' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (390, 15, CAST(N'2023-05-28' AS Date), CAST(N'2023-05-28' AS Date), 0, 12, CAST(N'2023-05-28T20:06:45.373' AS DateTime), 100, CAST(N'2023-05-28T20:06:45.373' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (391, 16, CAST(N'2023-05-30' AS Date), CAST(N'2023-05-30' AS Date), 0, 12, CAST(N'2023-05-30T22:23:34.760' AS DateTime), 100, CAST(N'2023-05-30T22:23:34.760' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (1384, 17, CAST(N'2023-05-30' AS Date), CAST(N'2023-05-30' AS Date), 0, 12, CAST(N'2023-05-30T23:08:51.973' AS DateTime), 100, CAST(N'2023-05-30T23:08:51.973' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (1385, 18, CAST(N'2023-05-30' AS Date), CAST(N'2023-05-30' AS Date), 0, 12, CAST(N'2023-05-30T23:25:32.910' AS DateTime), 100, CAST(N'2023-05-30T23:25:32.910' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (1386, 19, CAST(N'2023-05-31' AS Date), CAST(N'2023-05-31' AS Date), 0, 12, CAST(N'2023-05-31T00:53:13.460' AS DateTime), 100, CAST(N'2023-05-31T00:53:13.460' AS DateTime), 12, 0, 1)
INSERT [dbo].[leave_day_permission] ([id], [emp_id], [start_work_at], [now], [total_years], [total_leave_day_allowed], [created_at], [modified_by_id_account], [modified_at], [daysleft], [check_reset], [available]) VALUES (1387, 20, CAST(N'2023-05-31' AS Date), CAST(N'2023-05-31' AS Date), 0, 12, CAST(N'2023-05-31T00:59:13.487' AS DateTime), 100, CAST(N'2023-05-31T00:59:13.487' AS DateTime), 12, 0, 1)
SET IDENTITY_INSERT [dbo].[leave_day_permission] OFF
GO
SET IDENTITY_INSERT [dbo].[position] ON 

INSERT [dbo].[position] ([id_position], [name_of_position], [number_emp], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (5, N'Administration', 4, CAST(N'2023-04-25T21:46:33.733' AS DateTime), 100, CAST(N'2023-04-25T21:46:33.733' AS DateTime), 1)
INSERT [dbo].[position] ([id_position], [name_of_position], [number_emp], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (4, N'Administration Highest', 1, CAST(N'2023-04-25T21:46:17.557' AS DateTime), 100, CAST(N'2023-04-25T21:46:17.557' AS DateTime), 1)
INSERT [dbo].[position] ([id_position], [name_of_position], [number_emp], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (6, N'Employee', 200, CAST(N'2023-04-25T21:48:33.763' AS DateTime), 100, CAST(N'2023-04-25T21:48:33.763' AS DateTime), 1)
INSERT [dbo].[position] ([id_position], [name_of_position], [number_emp], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (3, N'Manager', 15, CAST(N'2023-04-25T00:00:00.000' AS DateTime), 100, CAST(N'2023-04-25T21:45:01.993' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[position] OFF
GO
SET IDENTITY_INSERT [dbo].[role] ON 

INSERT [dbo].[role] ([id], [role_name], [access_level], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (1, N'Admin Highest', 5, CAST(N'2023-04-25T21:50:46.187' AS DateTime), 100, CAST(N'2023-04-25T21:50:46.187' AS DateTime), 1)
INSERT [dbo].[role] ([id], [role_name], [access_level], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (3, N'Administration', 5, CAST(N'2023-04-25T21:51:26.967' AS DateTime), 100, CAST(N'2023-04-25T21:51:26.967' AS DateTime), 1)
INSERT [dbo].[role] ([id], [role_name], [access_level], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (2, N'CEO', 5, CAST(N'2023-04-25T21:51:11.937' AS DateTime), 100, CAST(N'2023-04-25T21:51:11.937' AS DateTime), 1)
INSERT [dbo].[role] ([id], [role_name], [access_level], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (5, N'Employee', 1, CAST(N'2023-04-25T21:51:46.367' AS DateTime), 100, CAST(N'2023-04-25T21:51:46.367' AS DateTime), 1)
INSERT [dbo].[role] ([id], [role_name], [access_level], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (4, N'Manager', 2, CAST(N'2023-04-25T21:51:36.370' AS DateTime), 100, CAST(N'2023-04-25T21:51:36.370' AS DateTime), 1)
SET IDENTITY_INSERT [dbo].[role] OFF
GO
INSERT [dbo].[status_dayoff] ([id], [name_status], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (1, N'Accept', CAST(N'2023-04-25T21:58:09.830' AS DateTime), 100, CAST(N'2023-04-25T21:58:09.830' AS DateTime), 1)
INSERT [dbo].[status_dayoff] ([id], [name_status], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (2, N'Reject', CAST(N'2023-04-25T21:58:21.430' AS DateTime), 100, CAST(N'2023-04-25T21:58:21.430' AS DateTime), 1)
INSERT [dbo].[status_dayoff] ([id], [name_status], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (3, N'Pending', CAST(N'2023-04-25T21:58:30.480' AS DateTime), 100, CAST(N'2023-04-25T21:58:30.480' AS DateTime), 1)
INSERT [dbo].[status_dayoff] ([id], [name_status], [created_at], [modified_by_id_account], [modified_at], [available]) VALUES (4, N'Updating', CAST(N'2023-05-24T12:51:08.483' AS DateTime), 100, CAST(N'2023-05-24T12:51:08.483' AS DateTime), 1)
GO
INSERT [dbo].[type_of_dayoff] ([day_off_code], [name_of_dayoff], [allowed_day_off], [created_at], [modified_by_id_account], [modified_at], [times_per_year], [available]) VALUES (211, N'Sick leave', 2, CAST(N'2023-04-25T22:01:24.287' AS DateTime), 100, CAST(N'2023-04-25T22:01:24.287' AS DateTime), 3, 1)
INSERT [dbo].[type_of_dayoff] ([day_off_code], [name_of_dayoff], [allowed_day_off], [created_at], [modified_by_id_account], [modified_at], [times_per_year], [available]) VALUES (212, N'Casual leave', 1, CAST(N'2023-04-25T22:01:44.847' AS DateTime), 100, CAST(N'2023-04-25T22:01:44.847' AS DateTime), 1, 1)
INSERT [dbo].[type_of_dayoff] ([day_off_code], [name_of_dayoff], [allowed_day_off], [created_at], [modified_by_id_account], [modified_at], [times_per_year], [available]) VALUES (213, N'Public holiday', 5, CAST(N'2023-04-25T22:04:21.407' AS DateTime), 100, CAST(N'2023-04-25T22:04:21.407' AS DateTime), 2, 1)
INSERT [dbo].[type_of_dayoff] ([day_off_code], [name_of_dayoff], [allowed_day_off], [created_at], [modified_by_id_account], [modified_at], [times_per_year], [available]) VALUES (214, N'Religious holiday', 3, CAST(N'2023-04-25T22:05:12.840' AS DateTime), 100, CAST(N'2023-04-25T22:05:12.840' AS DateTime), 2, 1)
INSERT [dbo].[type_of_dayoff] ([day_off_code], [name_of_dayoff], [allowed_day_off], [created_at], [modified_by_id_account], [modified_at], [times_per_year], [available]) VALUES (215, N'Maternity leave', 84, CAST(N'2023-04-25T22:06:31.467' AS DateTime), 100, CAST(N'2023-04-25T22:06:31.467' AS DateTime), 1, 1)
INSERT [dbo].[type_of_dayoff] ([day_off_code], [name_of_dayoff], [allowed_day_off], [created_at], [modified_by_id_account], [modified_at], [times_per_year], [available]) VALUES (216, N'Paternity leave', 14, CAST(N'2023-04-25T22:08:51.557' AS DateTime), 100, CAST(N'2023-04-25T22:08:51.557' AS DateTime), 1, 1)
INSERT [dbo].[type_of_dayoff] ([day_off_code], [name_of_dayoff], [allowed_day_off], [created_at], [modified_by_id_account], [modified_at], [times_per_year], [available]) VALUES (217, N'Bereavement leave', 5, CAST(N'2023-04-25T22:09:17.480' AS DateTime), 100, CAST(N'2023-04-25T22:09:17.480' AS DateTime), 1, 1)
INSERT [dbo].[type_of_dayoff] ([day_off_code], [name_of_dayoff], [allowed_day_off], [created_at], [modified_by_id_account], [modified_at], [times_per_year], [available]) VALUES (218, N'Compensatory leave', 2, CAST(N'2023-04-25T22:09:51.860' AS DateTime), 100, CAST(N'2023-04-25T22:09:51.860' AS DateTime), 1, 1)
INSERT [dbo].[type_of_dayoff] ([day_off_code], [name_of_dayoff], [allowed_day_off], [created_at], [modified_by_id_account], [modified_at], [times_per_year], [available]) VALUES (219, N'Sabbatical leave', 20, CAST(N'2023-04-25T22:10:28.690' AS DateTime), 100, CAST(N'2023-04-25T22:10:28.690' AS DateTime), 1, 1)
GO
/****** Object:  Index [UQ__account__1299A860E9D05263]    Script Date: 5/31/2023 1:01:31 AM ******/
ALTER TABLE [dbo].[account] ADD UNIQUE NONCLUSTERED 
(
	[emp_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
ALTER TABLE [dbo].[account] ADD  DEFAULT (NULL) FOR [modified_by_id_account]
GO
ALTER TABLE [dbo].[dayoff] ADD  DEFAULT (NULL) FOR [granted_by_id]
GO
ALTER TABLE [dbo].[employee] ADD  DEFAULT (NULL) FOR [manager_id]
GO
ALTER TABLE [dbo].[employee] ADD  DEFAULT (NULL) FOR [modified_by_id_account]
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD FOREIGN KEY([emp_id])
REFERENCES [dbo].[employee] ([emp_id])
GO
ALTER TABLE [dbo].[account]  WITH CHECK ADD FOREIGN KEY([role])
REFERENCES [dbo].[role] ([role_name])
GO
ALTER TABLE [dbo].[dayoff]  WITH CHECK ADD FOREIGN KEY([emp_id])
REFERENCES [dbo].[employee] ([emp_id])
GO
ALTER TABLE [dbo].[dayoff]  WITH CHECK ADD FOREIGN KEY([granted_by_id])
REFERENCES [dbo].[account] ([account_id])
GO
ALTER TABLE [dbo].[dayoff]  WITH CHECK ADD FOREIGN KEY([status])
REFERENCES [dbo].[status_dayoff] ([id])
GO
ALTER TABLE [dbo].[dayoff]  WITH CHECK ADD FOREIGN KEY([type_code])
REFERENCES [dbo].[type_of_dayoff] ([day_off_code])
GO
ALTER TABLE [dbo].[emp_box]  WITH CHECK ADD FOREIGN KEY([id_emp])
REFERENCES [dbo].[employee] ([emp_id])
GO
ALTER TABLE [dbo].[emp_box]  WITH CHECK ADD FOREIGN KEY([type_code_dayoff])
REFERENCES [dbo].[type_of_dayoff] ([day_off_code])
GO
ALTER TABLE [dbo].[employee]  WITH CHECK ADD FOREIGN KEY([department_id])
REFERENCES [dbo].[department] ([id])
GO
ALTER TABLE [dbo].[employee]  WITH CHECK ADD FOREIGN KEY([position])
REFERENCES [dbo].[position] ([name_of_position])
GO
ALTER TABLE [dbo].[leave_day_permission]  WITH CHECK ADD FOREIGN KEY([emp_id])
REFERENCES [dbo].[employee] ([emp_id])
GO
/****** Object:  StoredProcedure [dbo].[ActivateAcc]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[ActivateAcc]
as
begin
update account set available=1 where available=2 
end
GO
/****** Object:  StoredProcedure [dbo].[addAccount]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[addAccount]
@id int,@username nvarchar(50),@password nvarchar(50),@role nvarchar(50),@emp_id int
as
begin
insert into account values (@id,@username,@password,@role,@emp_id,getdate(),100,getdate())
end
GO
/****** Object:  StoredProcedure [dbo].[addBack]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[addBack]
@emp_id int, @day int
as
begin
update leave_day_permission set daysleft+=@day where emp_id=@emp_id and now in( select now from 
(select now,Row_number() over( partition by emp_id order by now desc) as row_num from leave_day_permission where emp_id=@emp_id) as subq where row_num=1) 
end
GO
/****** Object:  StoredProcedure [dbo].[addDayOff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[addDayOff]
@id int, @type_code int, @start_date date, @end_date date,
@reason nvarchar(200)
as
begin
insert into dayoff(emp_id,type_code,started_date,end_date,status,granted_by_id,checked_at,reason,received_at)
values (@id,@type_code,@start_date,@end_date,3,null,null,@reason,getdate())
end
GO
/****** Object:  StoredProcedure [dbo].[addEmp]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[addEmp]
@name nvarchar(50),@gender bit,@position nvarchar(50),@email nvarchar(50),@phone nvarchar(50),@dpt_id int,
@manager_id int,@picture nvarchar(50)
as
begin
insert into employee 
values ((select count(emp_id) from employee)+1,@name,@gender,@position,@email,@phone,@dpt_id,@manager_id,convert(date,getdate()),@picture,getdate(),100,getdate())
end
GO
/****** Object:  StoredProcedure [dbo].[addLeavePermissionDay]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[addLeavePermissionDay]
as
begin
create table #tempAdd(
emp_id int primary key,
start_work_at date,
now date,
total_years int,
total_leave_day_allowed int
)
insert into #tempAdd
select subquery.emp_id,subquery.start_work_at,subquery.now,subquery.total_years,subquery.total_leave_day_allowed from
(select l.emp_id,l.now,l.total_leave_day_allowed,l.total_years,l.start_work_at,rank() over
(partition by l.emp_id order by now desc) as row_num from leave_day_permission l where total_leave_day_allowed!=0 and check_reset=0 and datediff(YEAR,now,convert(date,getdate()))>=1  and now in (select now from (select emp_id,now,rank() over(partition by emp_id order by now desc) as rank from leave_day_permission group by emp_id,now) as subq where rank =1)
group by l.emp_id,l.now,l.total_leave_day_allowed,l.total_years,l.start_work_at) as subquery 
where row_num=1
insert into leave_day_permission(emp_id,start_work_at,now,total_years,total_leave_day_allowed,created_at,modified_by_id_account,modified_at,daysleft,check_reset)
select #tempAdd.emp_id,#tempAdd.start_work_at,convert(date,getdate()),
(#tempAdd.total_years+(1*datediff(year,now,convert(date,getdate())))),
(#tempAdd.total_leave_day_allowed+(1*datediff(year,now,convert(date,getdate()))))
,getdate(),100,getdate(),(#tempAdd.total_leave_day_allowed+(1*datediff(year,now,convert(date,getdate())))),0 from #tempAdd
drop table #tempAdd
update leave_day_permission set check_reset = 1 where emp_id in (select emp_id from leave_day_permission where check_reset=0) and datediff(YEAR,now,convert(date,getdate()))>=1 and total_leave_day_allowed!=0
end
GO
/****** Object:  StoredProcedure [dbo].[calDayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[calDayoff]
@emp_id int,@type_code int
as
begin
create table #tempDay
(type_code int primary key,
times int)
insert into #tempDay
select d.type_code, isnull(count(d.type_code),0)  as times_already from dayoff d
left join leave_day_permission l on d.emp_id=l.emp_id
where status in (1,3) and d.emp_id=@emp_id and type_code=@type_code and started_date>=l.now and end_date<=DATEADD(YEAR, 1, l.now)
group by d.type_code
--select * from #tempDay
select #tempDay.type_code,#tempDay.times,t.times_per_year  from #tempDay
join type_of_dayoff t on #tempDay.type_code=t.day_off_code
drop table #tempDay
end
GO
/****** Object:  StoredProcedure [dbo].[changeDpt]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[changeDpt]
@new_dpt int,@emp_id int
as
begin
update employee
set department_id=@new_dpt,modified_at=getdate()
where emp_id=@emp_id
if exists (select position from employee where emp_id=@emp_id and position='Manager')
begin
update department
set manager_dpt_id=(select a.account_id from account a where a.emp_id=@emp_id),modified_at=GETDATE()
where id=@new_dpt
end
else
begin
update employee
set manager_id=(select d.manager_dpt_id from department d where d.id=@new_dpt),modified_at=getdate()
where emp_id=@emp_id
end
end
GO
/****** Object:  StoredProcedure [dbo].[changePassword]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[changePassword]
@emp_id int,@newpass nvarchar(200)
as
begin 
update account set password=@newpass where emp_id=@emp_id and available=1
end
GO
/****** Object:  StoredProcedure [dbo].[changingStatus]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[changingStatus]
@id int,@status_code int
as
begin
update dayoff set status=@status_code where id = @id
end
GO
/****** Object:  StoredProcedure [dbo].[checkExistAndInsert]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[checkExistAndInsert]
as
begin
create table #hiringtemp(
emp_id int primary key,
start_to_work date,
hired bit
)
insert into #hiringtemp
select e.emp_id,e.start_to_work,e.hired from employee e
left join leave_day_permission l on e.emp_id=l.emp_id
where (l.emp_id is null and e.hired=0) or e.hired = 1

insert into leave_day_permission(emp_id,start_work_at,now,total_years,total_leave_day_allowed,created_at,modified_by_id_account,modified_at,daysleft,check_reset,available)
select h.emp_id,h.start_to_work,convert(date,GETDATE()),
datediff(year,convert(date,getdate()),h.start_to_work),
12,getdate(),100,getdate(),12,0,1 from #hiringtemp as h
 drop table #hiringtemp
 update employee 
 set hired=0 where emp_id in (select emp_id from employee where hired=1)
end
GO
/****** Object:  StoredProcedure [dbo].[checkExistedPhoneAndEmail]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[checkExistedPhoneAndEmail]
@phone nvarchar(50),@email nvarchar(50)
as
begin
declare @check nvarchar(50)
if exists (select * from employee where phoneNumber=@phone or email=@email)
set @check='existed'
if exists (select * from employee where hired=2 and( phoneNumber=@phone or email=@email ))
set @check='former employee'
select @check as check_result
end
GO
/****** Object:  StoredProcedure [dbo].[chooseMgr]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[chooseMgr]
@dpt_id int,@emp_id int
as
begin
update employee
set position='Manager',manager_id=100,modified_at=getdate()
where emp_id=@emp_id 
update account
set role='Manager',modified_at=getdate()
where account_id=(select a.account_id from account a where emp_id=@emp_id)
update department 
set manager_dpt_id=(select a.account_id from account a where emp_id=@emp_id),modified_at=getdate()
where id=@dpt_id
end
GO
/****** Object:  StoredProcedure [dbo].[countEmpByDpt]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[countEmpByDpt]
as
begin
declare @dpt_to_count int = (select count(id)from department)
declare @i int = 0
create table #Counttemp
(id int,number int)
insert into #Counttemp
select d.id,count(emp_id) as number from employee e
right join department d on d.id=e.department_id 
group by d.id
while @i<@dpt_to_count
begin
update department
set number_emp_in_dpt=(select number from #Counttemp order by id offset @i rows fetch next 1 rows only),
modified_at=getdate()
where id=(select id from #Counttemp order by id offset @i rows fetch next 1 rows only)
set @i+=1
end
drop table #Counttemp
end
GO
/****** Object:  StoredProcedure [dbo].[dateCheck]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[dateCheck]
@datefrom date,@dateto date,@emp_id int
as
begin
 (select * from dayoff where emp_id=@emp_id and status in (1,3) 
and ((@datefrom<=started_date and @dateto between started_date and end_date) 
or (@datefrom>=started_date and @dateto<=end_date)
or (@datefrom between started_date and end_date and @dateto>=end_date)
or (@datefrom<=started_date and @dateto>=end_date)))

end
GO
/****** Object:  StoredProcedure [dbo].[deactivateAcc]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[deactivateAcc]
as
begin
create table #tempLeft
(emp_id int primary key)
insert into #tempLeft
select sub.emp_id from
(select * from employee where hired=2) as sub
declare @acc_to_del int = (select count(emp_id) from #tempLeft)
declare @b int = 0

while @b<@acc_to_del
begin
update account
set available=0 
where emp_id=(select emp_id from #tempLeft order by emp_id offset @b rows fetch next 1 rows only)
set @b+=1
end
drop table #tempLeft
end
GO
/****** Object:  StoredProcedure [dbo].[delAccount]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[delAccount]
@account_id int
as
begin
update account set available=0 where account_id=@account_id
end
GO
/****** Object:  StoredProcedure [dbo].[delDayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[delDayoff]
@id int
as
begin
update dayoff set available=0 where id = @id
end
GO
/****** Object:  StoredProcedure [dbo].[delDepartment]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[delDepartment]
@id int
as
begin
update department set available=0 where id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[delEmployee]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[delEmployee]
@emp_id int
as
begin
update employee set hired = 2 where emp_id=@emp_id
end
GO
/****** Object:  StoredProcedure [dbo].[deleteLetters]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[deleteLetters]
@id int
as
begin
delete from dayoff where id = @id and status=4
end
GO
/****** Object:  StoredProcedure [dbo].[delLeaveDayPermission]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[delLeaveDayPermission]
@id int
as
begin
update leave_day_permission set available =0 where id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[delPosition]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[delPosition]
@id int
as
begin
update position set available=0 where id_position=@id
end
GO
/****** Object:  StoredProcedure [dbo].[delRole]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[delRole]
@id int
as 
begin
update role set available=0 where id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[delStatus]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[delStatus]
@id int
as
begin
update status_dayoff set available=0 where id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[delTypeDayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[delTypeDayoff]
@code int
as
begin
update type_of_dayoff set available=0 where day_off_code=@code
end
GO
/****** Object:  StoredProcedure [dbo].[getAccess]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getAccess]
@role nvarchar(50)
as
begin
select access_level from role where role_name=@role
end
GO
/****** Object:  StoredProcedure [dbo].[getAdminInfo]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getAdminInfo]
@emp_id int
as
begin
select e.emp_id,e.fullname,e.gender,e.position,e.phoneNumber,e.email from
(select a.emp_id from
(select e.manager_id from employee e where emp_id=@emp_id) as subq
left join account a on subq.manager_id=a.account_id) as subq1
left join employee e on e.emp_id=subq1.emp_id
end
GO
/****** Object:  StoredProcedure [dbo].[getAllDpt]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getAllDpt]
 as
 begin
 select * from department
 end
GO
/****** Object:  StoredProcedure [dbo].[getAllEmpInDpt]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getAllEmpInDpt]
as
begin
create table #tempDayoff
(id int primary key,
emp_id int,
type_code int,
started_date date,
end_date date,
status int,
granted_by_id int,
reason nvarchar(50)
)
insert into #tempDayoff
select id,emp_id,type_code,started_date,end_date,status,granted_by_id,reason from dayoff
where status =1 

select employee.emp_id,fullname,department_id,position,
sum(DATEDIFF(DAY, dayoff.started_date, dayoff.end_date)) as dayoff--, total_leave_day_allowed 
from employee
left join dayoff on employee.emp_id=dayoff.emp_id
where dayoff.status =1 
group by employee.emp_id,fullname,department_id,position
union
select employee.emp_id,fullname,department_id,position,
sum(DATEDIFF(DAY, #tempDayoff.started_date, #tempDayoff.end_date)) as dayoff--, total_leave_day_allowed 
from employee
left join #tempDayoff on employee.emp_id=#tempDayoff.emp_id
where #tempDayoff.emp_id is null 
group by employee.emp_id,fullname,department_id,position
order by position desc
drop table #tempDayoff
end
GO
/****** Object:  StoredProcedure [dbo].[getDataById]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getDataById]
@id int
as
begin
select * from dayoff where id =@id
end
GO
/****** Object:  StoredProcedure [dbo].[getDayOffByDate]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getDayOffByDate]
@date date,@status_code int
as
begin
select dayoff.id,dayoff.emp_id,dayoff.type_code,name_department,dayoff.started_date,dayoff.end_date,dayoff.granted_by_id
from dayoff,department 
where status = @status_code and department.id in (select department_id from employee where employee.emp_id=dayoff.emp_id)
and convert(date,checked_at)<=@date 
end
GO
/****** Object:  StoredProcedure [dbo].[getDayOffEmp]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getDayOffEmp]
@emp_id int
as
begin 
select id,type_code,started_date,end_date,status,granted_by_id from dayoff where emp_id=@emp_id

end
GO
/****** Object:  StoredProcedure [dbo].[getDayOffPendingByDate]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getDayOffPendingByDate]
as
begin
select dayoff.id,dayoff.emp_id,dayoff.type_code,name_department,dayoff.started_date,dayoff.end_date,dayoff.granted_by_id
from dayoff,department 
where status =3 and department.id in (select department_id from employee where employee.emp_id=dayoff.emp_id)
end
GO
/****** Object:  StoredProcedure [dbo].[getDaysLeft]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getDaysLeft]
@emp_id int
as
begin
select * from leave_day_permission where emp_id= @emp_id and now in( select now from (select now,Row_number() over( partition by emp_id order by now desc) as row_num from leave_day_permission where emp_id=@emp_id) as subq where row_num=1)
end
GO
/****** Object:  StoredProcedure [dbo].[getDptName]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getDptName]
@id int
as
begin select name_department from department where id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[getEmpByDpt]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getEmpByDpt]
@dpt_id int
as
begin
--select employee.emp_id,fullname,department_id,position, 
--sum(DATEDIFF(DAY, dayoff.started_date, dayoff.end_date)) as dayoff--, total_leave_day_allowed 
--from employee 
--left outer join dayoff on dayoff.emp_id=employee.emp_id
--where  employee.emp_id in (select emp_id from employee where department_id=@dpt_id) --and exists (select status from dayoff where employee.emp_id=dayoff.emp_id and status not in (2,3)))
----and leave_day_permission.emp_id=employee.emp_id
--group by employee.emp_id,fullname,department_id,position--,total_leave_day_allowed
--except 
--select  employee.emp_id,fullname,department_id,position,sum(DATEDIFF(DAY, dayoff.started_date, dayoff.end_date)) as dayoff
--from employee,dayoff
--where dayoff.status in (2,3)
--group by employee.emp_id,fullname,department_id,position--,total_leave_day_allowed
--order by position desc
create table #tempDayoff
(id int primary key,
emp_id int,
type_code int,
started_date date,
end_date date,
status int,
granted_by_id int,
reason nvarchar(50)
)
insert into #tempDayoff
select id,emp_id,type_code,started_date,end_date,status,granted_by_id,reason from dayoff
where status =1 and emp_id in (select emp_id from employee where department_id=@dpt_id)

select employee.emp_id,fullname,department_id,position,
sum((DATEDIFF(DAY, dayoff.started_date, dayoff.end_date) + 1)-(DATEDIFF(WEEK,dayoff.started_date, dayoff.end_date) * 2)) as dayoff--, total_leave_day_allowed 
from employee
left join dayoff on employee.emp_id=dayoff.emp_id
where dayoff.status =1 and  employee.emp_id in (select emp_id from employee where department_id=@dpt_id)
group by employee.emp_id,fullname,department_id,position
union
select employee.emp_id,fullname,department_id,position,
sum(DATEDIFF(DAY, #tempDayoff.started_date, #tempDayoff.end_date)) as dayoff--, total_leave_day_allowed 
from employee
left join #tempDayoff on employee.emp_id=#tempDayoff.emp_id
where #tempDayoff.emp_id is null  and  employee.emp_id in (select emp_id from employee where department_id=@dpt_id)
group by employee.emp_id,fullname,department_id,position
order by position desc
drop table #tempDayoff
end
GO
/****** Object:  StoredProcedure [dbo].[getEmpInfo]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getEmpInfo]
@dpt_id int
as
begin
select e.emp_id,e.fullname,e.gender,e.start_to_work,e.email,e.phoneNumber,e.position,l.daysleft from employee e,leave_day_permission l where department_id=@dpt_id and position='Employee' and e.hired=0 and l.emp_id=e.emp_id and now in (select now from (select emp_id,now,rank() over(partition by emp_id order by now desc) as rank from leave_day_permission group by emp_id,now) as subq where rank =1)
order by e.emp_id
end
GO
/****** Object:  StoredProcedure [dbo].[getEmpLeft]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getEmpLeft]
@date date
as
begin select ROW_NUMBER() OVER (ORDER BY employee.emp_id,name_department)as id,dayoff.emp_id,employee.fullname,name_department,
dayoff.type_code,dayoff.status,dayoff.reason from dayoff,department,employee where started_date<=@date and end_date>=@date and status=1 and department.id in (select department_id from employee where employee.emp_id=dayoff.emp_id) and dayoff.emp_id=employee.emp_id
order by name_department
end
GO
/****** Object:  StoredProcedure [dbo].[getLeaveType]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getLeaveType]
as
begin
select name_of_dayoff,day_off_code ,allowed_day_off from type_of_dayoff
end
GO
/****** Object:  StoredProcedure [dbo].[getLeaveTypeByCode]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getLeaveTypeByCode]
@id int
as
begin
select * from type_of_dayoff where day_off_code=@id
end
GO
/****** Object:  StoredProcedure [dbo].[getLeaving]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getLeaving]
@emp_id int
as
begin

select sum((DATEDIFF(DAY, d.started_date, d.end_date) + 1)-(DATEDIFF(WEEK,d.started_date, d.end_date) * 2)) as count_dayoff from dayoff d
left join leave_day_permission l on l.emp_id=d.emp_id
where d.emp_id=@emp_id and status=1 and 
now in( select now from 
(select now,Row_number() over( partition by emp_id order by now desc) as row_num from leave_day_permission where emp_id=@emp_id) as subq where row_num=1) 
and d.started_date>=l.now and d.end_date<=dateadd(YEAR,1,l.now)
end
GO
/****** Object:  StoredProcedure [dbo].[getLeavingAllowed]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getLeavingAllowed]
@id int
as
begin 
select total_leave_day_allowed from leave_day_permission where emp_id=@id
order by now desc 
offset 0 rows
fetch next 1 rows only
end
GO
/****** Object:  StoredProcedure [dbo].[getMgrInfo]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getMgrInfo]
@dpt_id int
as
begin
select e.emp_id,e.fullname,e.gender,e.position,e.phoneNumber,e.email from employee e where department_id=@dpt_id and position='Manager'
end
GO
/****** Object:  StoredProcedure [dbo].[getMgrInfoAll]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getMgrInfoAll]
as
begin
create table #accTemp(emp_id int)
insert into #accTemp
select a.emp_id from
(select d.manager_dpt_id from department d) as sub
join account a on a.account_id=sub.manager_dpt_id
select e.emp_id,e.fullname,e.gender,e.position,e.phoneNumber,e.email,d.name_department,l.daysleft from employee e
left join #accTemp on #accTemp.emp_id=e.emp_id
left join department d on d.id=e.department_id
left join leave_day_permission l on l.emp_id=e.emp_id
where #accTemp.emp_id=e.emp_id and d.id = e.department_id and l.emp_id=e.emp_id and e.hired=0 and now in 
(select now from (select emp_id,now,rank() over(partition by emp_id order by now desc) as rank from leave_day_permission group by emp_id,now) as subq where rank =1)
order by emp_id
drop table #accTemp
end
GO
/****** Object:  StoredProcedure [dbo].[getNewEmp]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[getNewEmp]
as
begin
select e.emp_id,e.fullname,e.department_id,d.name_department,e.position,e.email,e.phoneNumber from employee e
left join account a on e.emp_id=a.emp_id
left join department d on d.id=e.department_id 
where a.emp_id is null and e.department_id=d.id
end
GO
/****** Object:  StoredProcedure [dbo].[getNewEmp_id]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getNewEmp_id]
as
begin
declare @new_id int = (select emp_id from employee order by emp_id desc offset 0 rows fetch next 1 rows only)+1
while 0 = 0
begin
if exists (select * from employee where emp_id=@new_id)
set @new_id+=1
else
break
end
select @new_id as new_id
end
GO
/****** Object:  StoredProcedure [dbo].[getNotice]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[getNotice]
as
begin
select * from leave_day_permission where datediff(MONTH,now,convert(date,getdate()))>=9 and now in (select now from (select emp_id,now,rank() over(partition by emp_id order by now desc) as rank from leave_day_permission group by emp_id,now) as subq where rank =1) and total_leave_day_allowed!=0 and check_reset=0 and daysleft!=0
end
GO
/****** Object:  StoredProcedure [dbo].[insertAccount]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[insertAccount]
@account_id int, @username nvarchar(50),@password nvarchar(50),@role nvarchar(50),@emp_id int
as
begin
insert into account values (@account_id,@username,@password,@role,@emp_id,GETDATE(),100,getdate(),1)
end
GO
/****** Object:  StoredProcedure [dbo].[insertDayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[insertDayoff]
@emp_id int, @type_code int, @started_date date, @end_date date, @status int, @granted_by_id int, @reason nvarchar(300)
as
begin
insert into dayoff(emp_id,type_code,started_date,end_date,status,granted_by_id,checked_at,reason,received_at,available) values
(@emp_id,@type_code,@started_date,@end_date,@status,@granted_by_id,GETDATE(),@reason,GETDATE(),1)
end
GO
/****** Object:  StoredProcedure [dbo].[insertDepartment]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[insertDepartment]
@id int, @name nvarchar(200),@manager_account_id int,@number_emp int
as
begin
insert into department values (@id,@name,@manager_account_id,@number_emp,getdate(),100,getdate(),1)
end
GO
/****** Object:  StoredProcedure [dbo].[insertEmployee]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[insertEmployee]
 @fullname nvarchar(200), @gender bit, @position nvarchar(50), @email nvarchar(50),@phone nvarchar(50),
@department_id int,@manager_id_account int, @start_work date, @picture nvarchar(200)
as
begin
declare @new_id int = (select emp_id from employee order by emp_id desc offset 0 rows fetch next 1 rows only)+1
while 0 = 0
begin
if exists (select * from employee where emp_id=@new_id)
set @new_id+=1
else
break
end

insert into employee values(@new_id,@fullname,@gender,@position,@email,@phone,@department_id,@manager_id_account,
@start_work,@picture,getdate(),100,getdate(),0)
end
GO
/****** Object:  StoredProcedure [dbo].[insertLeaveDayPermission]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[insertLeaveDayPermission]
@emp_id int,@start_work date
as
begin
insert into leave_day_permission(emp_id,start_work_at,now,total_years,total_leave_day_allowed,created_at,modified_by_id_account,
modified_at,daysleft,check_reset) values (@emp_id,@start_work,convert(date,getdate()),datediff(year,@start_work,convert(date,getdate())),12+datediff(year,@start_work,convert(date,getdate())),
getdate(),100,getdate(),12+datediff(year,@start_work,convert(date,getdate())),0)
end
GO
/****** Object:  StoredProcedure [dbo].[insertPosition]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[insertPosition]
@name nvarchar(50),@number_emp int
as
begin
insert into position(name_of_position,number_emp,created_at,modified_by_id_account,modified_at,available) values
(@name,@number_emp,getdate(),100,getdate(),1)
end
GO
/****** Object:  StoredProcedure [dbo].[insertRole]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[insertRole]
@role_name nvarchar(50),@access_level int
as
begin
insert into role(role_name,access_level,created_at,modified_by_id_account,modified_at,available) values 
(@role_name,@access_level,getdate(),100,getdate(),1)
end
GO
/****** Object:  StoredProcedure [dbo].[insertStatusDayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[insertStatusDayoff]
@id int,@name nvarchar(50)
as
begin
insert into status_dayoff values (@id,@name,getdate(),100,GETDATE(),1)
end
GO
/****** Object:  StoredProcedure [dbo].[insertTypeDayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[insertTypeDayoff]
@code int, @name nvarchar(50),@allowed_day int,@times_per_year int
as
begin
insert into type_of_dayoff values (@code,@name,@allowed_day,getdate(),100,getdate(),@times_per_year,1)
end
GO
/****** Object:  StoredProcedure [dbo].[loadPosition]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[loadPosition]
as
begin
select * from position where available=1
end
GO
/****** Object:  StoredProcedure [dbo].[login]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[login]
@username nvarchar(50),@password nvarchar(50)
as
begin
select * from account where username=@username and password=@password and available = 1
end
GO
/****** Object:  StoredProcedure [dbo].[makeAcc]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[makeAcc]
as
begin
create table #ListTemp
(emp_id int primary key,
fullname nvarchar(50),
position nvarchar(50))

insert into #ListTemp
select e.emp_id,e.fullname,e.position from employee e
left join account a on e.emp_id=a.emp_id
where a.emp_id is null

declare @num_acc_to_make int = (select count(emp_id) from #ListTemp)
declare @a int = 0;
declare @account_id int = (select account_id from account order by account_id desc offset 0 rows fetch next 1 rows only)+1
declare @username nvarchar(50)
declare @password nvarchar(50)
declare @role nvarchar(50)
declare @emp_id int
declare @role_check nvarchar(50)
while @a<@num_acc_to_make
begin
set @username = concat(left(replace((select fullname from #ListTemp order by emp_id offset @a rows fetch next 1 rows only),' ',''),4),'_',LEFT(CONVERT(VARCHAR(50), NEWID()), 4))
set @password=@username
while 0=0
begin
if not exists (select * from account where username=@username)
break
else
set @username=concat(left(replace((select fullname from #ListTemp order by emp_id offset @a rows fetch next 1 rows only),' ',''),4),'_',LEFT(CONVERT(VARCHAR(50), NEWID()), 8))
set @password=@username
end
while 0=0
begin
if not exists (select * from account where account_id=@account_id)
break
else
set @account_id+=1
end
set @role_check =  (select #ListTemp.position from #ListTemp order by emp_id offset @a rows fetch next 1 rows only)
while 0=0
begin
if exists (select @role_check where @role_check='Administration Highest')
set @role_check='Admin Highest'
else
break
end
set @role = @role_check
set @emp_id= (select #ListTemp.emp_id from #ListTemp order by emp_id offset @a rows fetch next 1 rows only)
insert into account values (@account_id,@username,@password,@role,@emp_id,GETDATE(),100,GETDATE(),2)

set @a+=1
end
drop table #ListTemp

end
GO
/****** Object:  StoredProcedure [dbo].[minusBack]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[minusBack]
@emp_id int, @day int
as
begin
update leave_day_permission set daysleft-=@day where emp_id=@emp_id and now in( select now from 
(select now,Row_number() over( partition by emp_id order by now desc) as row_num from leave_day_permission where emp_id=@emp_id) as subq where row_num=1) 
end
GO
/****** Object:  StoredProcedure [dbo].[minusdaysleft]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[minusdaysleft]
@daystominus int,@emp_id int
as
begin
update leave_day_permission
set daysleft -= @daystominus
where emp_id=@emp_id and now in( select now from (select now,Row_number() over( partition by emp_id order by now desc) as row_num from leave_day_permission where emp_id=@emp_id) as subq where row_num=1)
end
GO
/****** Object:  StoredProcedure [dbo].[modifyLetters]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[modifyLetters]
@id int, @type_code int, @start_date date,@end_date date,@reason nvarchar(50)
as
begin
update dayoff set type_code=@type_code,started_date=@start_date,end_date=@end_date,reason=@reason where id = @id
end
GO
/****** Object:  StoredProcedure [dbo].[name_dayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[name_dayoff]
@code int
as
begin
select name_of_dayoff from type_of_dayoff where day_off_code=@code
end
GO
/****** Object:  StoredProcedure [dbo].[selAllDayoffManagerPending]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selAllDayoffManagerPending]
as
begin
select dayoff.*,name_department from dayoff,department
where emp_id in (select emp_id from account where role='Manager') and status=3 and manager_dpt_id in (select account_id from account where account.emp_id=dayoff.emp_id)
end
GO
/****** Object:  StoredProcedure [dbo].[selAllDpt]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[selAllDpt]
as
begin
select * from department
end
GO
/****** Object:  StoredProcedure [dbo].[selDayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[selDayoff]
@id int
as
begin
select * from dayoff where status=3 and emp_id in (select emp_id from employee where department_id=@id and position='Employee')
order by received_at desc
end
GO
/****** Object:  StoredProcedure [dbo].[selUserInfo]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[selUserInfo]
@id int
as
begin
select * from employee where emp_id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[showNewAcc]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[showNewAcc]
as 
begin
select a.account_id,a.username,a.password,a.role,a.emp_id,e.email from account a
left join employee e on e.emp_id= a.emp_id
where available = 2 and e.emp_id=a.emp_id
end
GO
/****** Object:  StoredProcedure [dbo].[updateAccount]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateAccount]
@account_id int,@username nvarchar(50),@password nvarchar(50),@role nvarchar(50),@emp_id int
as
begin
update account set username=@username,password=@password,role=@role,emp_id=@emp_id,modified_at=getdate() where account_id=@account_id
end
GO
/****** Object:  StoredProcedure [dbo].[updateDayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateDayoff]
@id int, @type_code int, @started_date date, @end_date date, @status int, @granted_by_id int, @reason nvarchar(300)
as
begin
update dayoff set type_code=@type_code,started_date=@started_date,end_date=@end_date,status=@status,granted_by_id=@granted_by_id,
reason=@reason where id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[updateDepartment]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateDepartment]
@id int, @name nvarchar(200),@manager_account_id int,@number_emp int
as
begin
update department set name_department=@name,manager_dpt_id=@manager_account_id,number_emp_in_dpt=@number_emp,modified_at=getdate() 
where id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[updateEmployee]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateEmployee]
@emp_id int, @fullname nvarchar(200), @gender bit, @position nvarchar(50), @email nvarchar(50),@phone nvarchar(50),
@department_id int,@manager_id_account int, @start_work date, @picture nvarchar(200)
as
begin
update employee set fullname=@fullname,gender=@gender,position=@position,email=@email,phoneNumber=@phone,department_id=@department_id,
manager_id=@manager_id_account,start_to_work=@start_work,picture=@picture,modified_at=GETDATE() where emp_id=@emp_id
end
GO
/****** Object:  StoredProcedure [dbo].[updateLeaveDayPermission]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateLeaveDayPermission]
@id int,@emp_id int,@start_work date,@daysleft int,@check int
as
begin
update leave_day_permission set emp_id=@emp_id,start_work_at=@start_work,total_years=datediff(year,@start_work,now),total_leave_day_allowed=12+datediff(year,@start_work,now),
modified_at=getdate(),daysleft=@daysleft,check_reset=@check where id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[updateLetterStatus]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[updateLetterStatus]
@id int,@status int,@manager_account int,@day_change int
as
begin
update dayoff set status=@status,granted_by_id=@manager_account,checked_at=GETDATE() where id=@id 
declare @emp_id int 
set @emp_id=(select emp_id from dayoff where id = @id)
update leave_day_permission set daysleft+=@day_change where emp_id=@emp_id
end
GO
/****** Object:  StoredProcedure [dbo].[updatePosition]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updatePosition]
@id int,@name nvarchar(50),@number_emp int
as
begin
update position set name_of_position=@name,number_emp=@number_emp,modified_at=getdate() where id_position=@id
end
GO
/****** Object:  StoredProcedure [dbo].[updateRole]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateRole]
@id int,@role_name nvarchar(50),@access_level int
as
begin
update role set role_name=@role_name,access_level=@access_level,modified_at=getdate() where id = @id
end
GO
/****** Object:  StoredProcedure [dbo].[updateStatus]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateStatus]
@id int,@name nvarchar(50)
as
begin
update status_dayoff set name_status=@name,modified_at=getdate() where id=@id
end
GO
/****** Object:  StoredProcedure [dbo].[updateTypeDayoff]    Script Date: 5/31/2023 1:01:31 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[updateTypeDayoff]
@code int, @name nvarchar(50),@allowed_day int,@times_per_year int
as
begin
update type_of_dayoff set name_of_dayoff=@name,allowed_day_off=@allowed_day,modified_at=getdate(),times_per_year=@times_per_year
where day_off_code=@code
end
GO
EXEC sys.sp_addextendedproperty @name=N'Column_Description', @value=N'quyen access tren account' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'account', @level2type=N'COLUMN',@level2name=N'role'
GO
EXEC sys.sp_addextendedproperty @name=N'Column_Description', @value=N'manager_id' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'dayoff', @level2type=N'COLUMN',@level2name=N'granted_by_id'
GO
EXEC sys.sp_addextendedproperty @name=N'Table_Description', @value=N'ds ngay nghi' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'dayoff'
GO
EXEC sys.sp_addextendedproperty @name=N'Column_Description', @value=N'ma loai ngay nghi' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'emp_box', @level2type=N'COLUMN',@level2name=N'type_code_dayoff'
GO
EXEC sys.sp_addextendedproperty @name=N'Table_Description', @value=N'kho luu tru cua nhan vien' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'TABLE',@level1name=N'emp_box'
GO
USE [master]
GO
ALTER DATABASE [Java_Project] SET  READ_WRITE 
GO
