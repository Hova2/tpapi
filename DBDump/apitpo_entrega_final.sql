USE [master]
GO
/****** Object:  Database [tpapi]    Script Date: 25/11/2016 19:37:23 ******/
CREATE DATABASE [tpapi]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'tpapi', FILENAME = N'F:\SQL Server express 2014\MSSQL12.SQLEXPRESS\MSSQL\DATA\tpapi.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'tpapi_log', FILENAME = N'F:\SQL Server express 2014\MSSQL12.SQLEXPRESS\MSSQL\DATA\tpapi_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [tpapi] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [tpapi].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [tpapi] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [tpapi] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [tpapi] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [tpapi] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [tpapi] SET ARITHABORT OFF 
GO
ALTER DATABASE [tpapi] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [tpapi] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [tpapi] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [tpapi] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [tpapi] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [tpapi] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [tpapi] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [tpapi] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [tpapi] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [tpapi] SET  DISABLE_BROKER 
GO
ALTER DATABASE [tpapi] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [tpapi] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [tpapi] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [tpapi] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [tpapi] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [tpapi] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [tpapi] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [tpapi] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [tpapi] SET  MULTI_USER 
GO
ALTER DATABASE [tpapi] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [tpapi] SET DB_CHAINING OFF 
GO
ALTER DATABASE [tpapi] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [tpapi] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [tpapi] SET DELAYED_DURABILITY = DISABLED 
GO
USE [tpapi]
GO
/****** Object:  Table [dbo].[Accion]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Accion](
	[fechaAlta] [datetime] NOT NULL,
	[detalle] [text] NOT NULL,
	[nroReclamo] [bigint] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[dniCliente] [bigint] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[domicilio] [varchar](50) NOT NULL,
	[telefono] [varchar](50) NOT NULL,
	[mail] [varchar](50) NOT NULL,
	[activo] [bit] NOT NULL,
 CONSTRAINT [PK_Clientes] PRIMARY KEY CLUSTERED 
(
	[dniCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Estado]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Estado](
	[nroEstado] [int] NOT NULL,
	[detalle] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Estado] PRIMARY KEY CLUSTERED 
(
	[nroEstado] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Factura]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Factura](
	[nroFactura] [bigint] NOT NULL,
	[fecha] [datetime] NOT NULL,
	[total] [float] NOT NULL,
	[dniCliente] [bigint] NOT NULL,
 CONSTRAINT [PK_Factura] PRIMARY KEY CLUSTERED 
(
	[nroFactura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FacturaReclamo]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FacturaReclamo](
	[nroReclamo] [bigint] NOT NULL,
	[nroFactura] [bigint] NOT NULL,
 CONSTRAINT [PK_FacturaReclamo] PRIMARY KEY CLUSTERED 
(
	[nroReclamo] ASC,
	[nroFactura] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ItemFactura]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ItemFactura](
	[nroFactura] [bigint] NOT NULL,
	[codigoProd] [bigint] NOT NULL,
	[cantidad] [bigint] NOT NULL,
 CONSTRAINT [PK_ItemFactura] PRIMARY KEY CLUSTERED 
(
	[nroFactura] ASC,
	[codigoProd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ItemProductoReclamo]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ItemProductoReclamo](
	[nroIteProdRec] [bigint] NOT NULL,
	[codigoProd] [bigint] NOT NULL,
	[cantidad] [int] NOT NULL,
 CONSTRAINT [PK_ItemProductoReclamo_1] PRIMARY KEY CLUSTERED 
(
	[nroIteProdRec] ASC,
	[codigoProd] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Producto]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Producto](
	[codigo] [bigint] NOT NULL,
	[titulo] [varchar](50) NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
	[precio] [float] NOT NULL,
	[activo] [bit] NOT NULL,
 CONSTRAINT [PK_Producto] PRIMARY KEY CLUSTERED 
(
	[codigo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Reclamo]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Reclamo](
	[nroReclamo] [bigint] NOT NULL,
	[fechaAlta] [datetime] NOT NULL,
	[fechaCierre] [datetime] NULL,
	[descripcion] [text] NOT NULL,
	[estado] [int] NOT NULL,
	[dniCliente] [bigint] NOT NULL,
	[tipoReclamo] [int] NOT NULL,
 CONSTRAINT [PK_Reclamo] PRIMARY KEY CLUSTERED 
(
	[nroReclamo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ReclamoProducto]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReclamoProducto](
	[nroReclamoProducto] [bigint] NOT NULL,
	[nroReclamo] [bigint] NOT NULL,
 CONSTRAINT [PK_ReclamoProducto] PRIMARY KEY CLUSTERED 
(
	[nroReclamoProducto] ASC,
	[nroReclamo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Rol]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Rol](
	[idRol] [int] NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
 CONSTRAINT [PK_Rol] PRIMARY KEY CLUSTERED 
(
	[idRol] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TipoReclamo]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoReclamo](
	[idTipoReclamo] [int] NOT NULL,
	[descripcion] [varchar](50) NOT NULL,
 CONSTRAINT [PK_TipoReclamo] PRIMARY KEY CLUSTERED 
(
	[idTipoReclamo] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Usuario]    Script Date: 25/11/2016 19:37:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Usuario](
	[dniUsuario] [bigint] NOT NULL,
	[nombre] [varchar](50) NOT NULL,
	[password] [varchar](50) NOT NULL,
	[idRol] [int] NOT NULL,
 CONSTRAINT [PK_Usuario] PRIMARY KEY CLUSTERED 
(
	[dniUsuario] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (1, N'Cliente1', N'DomCliente1', N'1', N'cliente1@clientes.com', 1)
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (2, N'Cliente2', N'DomCliente2', N'2', N'cliente2@clientes.com', 1)
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (3, N'Cliente3', N'DomCliente3', N'3', N'cliente3@clientes.com', 1)
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (4, N'Cliente4', N'DomCliente4', N'4', N'cliente4@clientes.com', 1)
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (5, N'Cliente5', N'DomCliente5', N'5', N'cliente5@clientes.com', 1)
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (6, N'Cliente6', N'DomCliente6', N'6', N'cliente6@clientes.com', 1)
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (7, N'Cliente7', N'DomCliente7', N'7', N'cliente7@clientes.com', 1)
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (8, N'Cliente8', N'DomCliente8', N'8', N'cliente8@clientes.com', 1)
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (9, N'Cliente9', N'DomCliente9', N'9', N'cliente9@clientes.com', 1)
INSERT [dbo].[Cliente] ([dniCliente], [nombre], [domicilio], [telefono], [mail], [activo]) VALUES (10, N'Cliente10', N'DomCliente10', N'10', N'cliente10@clientes.com', 1)
INSERT [dbo].[Estado] ([nroEstado], [detalle]) VALUES (1, N'Ingresado')
INSERT [dbo].[Estado] ([nroEstado], [detalle]) VALUES (2, N'En tratamiento')
INSERT [dbo].[Estado] ([nroEstado], [detalle]) VALUES (3, N'Cerrado')
INSERT [dbo].[Estado] ([nroEstado], [detalle]) VALUES (4, N'Solucionado')
INSERT [dbo].[Factura] ([nroFactura], [fecha], [total], [dniCliente]) VALUES (5, CAST(N'2016-10-08T00:00:00.000' AS DateTime), 200, 1)
INSERT [dbo].[Factura] ([nroFactura], [fecha], [total], [dniCliente]) VALUES (6, CAST(N'2016-10-08T00:00:00.000' AS DateTime), 150, 1)
INSERT [dbo].[Factura] ([nroFactura], [fecha], [total], [dniCliente]) VALUES (10, CAST(N'2016-10-08T00:00:00.000' AS DateTime), 100, 5)
INSERT [dbo].[Factura] ([nroFactura], [fecha], [total], [dniCliente]) VALUES (15, CAST(N'2016-10-08T00:00:00.000' AS DateTime), 50, 8)
INSERT [dbo].[ItemFactura] ([nroFactura], [codigoProd], [cantidad]) VALUES (5, 3, 10)
INSERT [dbo].[ItemFactura] ([nroFactura], [codigoProd], [cantidad]) VALUES (5, 5, 2)
INSERT [dbo].[ItemFactura] ([nroFactura], [codigoProd], [cantidad]) VALUES (5, 9, 1)
INSERT [dbo].[ItemFactura] ([nroFactura], [codigoProd], [cantidad]) VALUES (6, 8, 4)
INSERT [dbo].[ItemFactura] ([nroFactura], [codigoProd], [cantidad]) VALUES (10, 1, 50)
INSERT [dbo].[ItemFactura] ([nroFactura], [codigoProd], [cantidad]) VALUES (15, 4, 100)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (1, N'Producto1', N'Es el producto:1', 1, 1)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (2, N'Producto2', N'Es el producto:2', 2, 1)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (3, N'Producto3', N'Es el producto:3', 3, 1)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (4, N'Producto4', N'Es el producto:4', 4, 1)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (5, N'Producto5', N'Es el producto:5', 5, 1)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (6, N'Producto6', N'Es el producto:6', 6, 1)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (7, N'Producto7', N'Es el producto:7', 7, 1)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (8, N'Producto8', N'Es el producto:8', 8, 1)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (9, N'Producto9', N'Es el producto:9', 9, 1)
INSERT [dbo].[Producto] ([codigo], [titulo], [descripcion], [precio], [activo]) VALUES (10, N'Producto10', N'Es el producto:10', 10, 1)
INSERT [dbo].[Reclamo] ([nroReclamo], [fechaAlta], [fechaCierre], [descripcion], [estado], [dniCliente], [tipoReclamo]) VALUES (0, CAST(N'2016-11-03T00:00:00.000' AS DateTime), NULL, N'Prueba', 1, 1, 0)
INSERT [dbo].[Reclamo] ([nroReclamo], [fechaAlta], [fechaCierre], [descripcion], [estado], [dniCliente], [tipoReclamo]) VALUES (1, CAST(N'2016-11-03T00:00:00.000' AS DateTime), CAST(N'2016-11-12T00:00:00.000' AS DateTime), N'Pepe', 3, 2, 0)
INSERT [dbo].[Reclamo] ([nroReclamo], [fechaAlta], [fechaCierre], [descripcion], [estado], [dniCliente], [tipoReclamo]) VALUES (2, CAST(N'2016-11-12T00:00:00.000' AS DateTime), CAST(N'2016-11-12T00:00:00.000' AS DateTime), N'Prueba', 3, 2, 0)
INSERT [dbo].[Rol] ([idRol], [descripcion]) VALUES (0, N'Administrador')
INSERT [dbo].[Rol] ([idRol], [descripcion]) VALUES (1, N'Call center')
INSERT [dbo].[Rol] ([idRol], [descripcion]) VALUES (2, N'Consulta')
INSERT [dbo].[Rol] ([idRol], [descripcion]) VALUES (3, N'Responsable de facturacion')
INSERT [dbo].[Rol] ([idRol], [descripcion]) VALUES (4, N'Responsable de distribucion')
INSERT [dbo].[Rol] ([idRol], [descripcion]) VALUES (5, N'Responsable de zona')
INSERT [dbo].[TipoReclamo] ([idTipoReclamo], [descripcion]) VALUES (0, N'ReclamoZona')
INSERT [dbo].[TipoReclamo] ([idTipoReclamo], [descripcion]) VALUES (1, N'ReclamoCantidad')
INSERT [dbo].[TipoReclamo] ([idTipoReclamo], [descripcion]) VALUES (2, N'ReclamoFaltante')
INSERT [dbo].[TipoReclamo] ([idTipoReclamo], [descripcion]) VALUES (3, N'ReclamoFacturacion')
INSERT [dbo].[Usuario] ([dniUsuario], [nombre], [password], [idRol]) VALUES (0, N'admin', N'admin', 0)
INSERT [dbo].[Usuario] ([dniUsuario], [nombre], [password], [idRol]) VALUES (1, N'call', N'call', 1)
INSERT [dbo].[Usuario] ([dniUsuario], [nombre], [password], [idRol]) VALUES (2, N'consulta', N'consulta', 2)
INSERT [dbo].[Usuario] ([dniUsuario], [nombre], [password], [idRol]) VALUES (3, N'userfactu', N'userfactu', 3)
INSERT [dbo].[Usuario] ([dniUsuario], [nombre], [password], [idRol]) VALUES (4, N'userdist', N'userdist', 4)
INSERT [dbo].[Usuario] ([dniUsuario], [nombre], [password], [idRol]) VALUES (5, N'userzona', N'userzona', 5)
ALTER TABLE [dbo].[Accion]  WITH CHECK ADD  CONSTRAINT [FK_Accion_Reclamo] FOREIGN KEY([nroReclamo])
REFERENCES [dbo].[Reclamo] ([nroReclamo])
GO
ALTER TABLE [dbo].[Accion] CHECK CONSTRAINT [FK_Accion_Reclamo]
GO
ALTER TABLE [dbo].[Factura]  WITH CHECK ADD  CONSTRAINT [FK_Factura_Cliente] FOREIGN KEY([dniCliente])
REFERENCES [dbo].[Cliente] ([dniCliente])
GO
ALTER TABLE [dbo].[Factura] CHECK CONSTRAINT [FK_Factura_Cliente]
GO
ALTER TABLE [dbo].[FacturaReclamo]  WITH CHECK ADD  CONSTRAINT [FK_FacturaReclamo_Factura] FOREIGN KEY([nroFactura])
REFERENCES [dbo].[Factura] ([nroFactura])
GO
ALTER TABLE [dbo].[FacturaReclamo] CHECK CONSTRAINT [FK_FacturaReclamo_Factura]
GO
ALTER TABLE [dbo].[FacturaReclamo]  WITH CHECK ADD  CONSTRAINT [FK_FacturaReclamo_Reclamo] FOREIGN KEY([nroReclamo])
REFERENCES [dbo].[Reclamo] ([nroReclamo])
GO
ALTER TABLE [dbo].[FacturaReclamo] CHECK CONSTRAINT [FK_FacturaReclamo_Reclamo]
GO
ALTER TABLE [dbo].[ItemFactura]  WITH CHECK ADD  CONSTRAINT [FK_ItemFactura_Factura] FOREIGN KEY([nroFactura])
REFERENCES [dbo].[Factura] ([nroFactura])
GO
ALTER TABLE [dbo].[ItemFactura] CHECK CONSTRAINT [FK_ItemFactura_Factura]
GO
ALTER TABLE [dbo].[ItemFactura]  WITH CHECK ADD  CONSTRAINT [FK_ItemFactura_Producto] FOREIGN KEY([codigoProd])
REFERENCES [dbo].[Producto] ([codigo])
GO
ALTER TABLE [dbo].[ItemFactura] CHECK CONSTRAINT [FK_ItemFactura_Producto]
GO
ALTER TABLE [dbo].[ItemProductoReclamo]  WITH CHECK ADD  CONSTRAINT [FK_ItemProductoReclamo_Producto] FOREIGN KEY([codigoProd])
REFERENCES [dbo].[Producto] ([codigo])
GO
ALTER TABLE [dbo].[ItemProductoReclamo] CHECK CONSTRAINT [FK_ItemProductoReclamo_Producto]
GO
ALTER TABLE [dbo].[ItemProductoReclamo]  WITH CHECK ADD  CONSTRAINT [FK_ItemProductoReclamo_Reclamo] FOREIGN KEY([nroIteProdRec])
REFERENCES [dbo].[Reclamo] ([nroReclamo])
GO
ALTER TABLE [dbo].[ItemProductoReclamo] CHECK CONSTRAINT [FK_ItemProductoReclamo_Reclamo]
GO
ALTER TABLE [dbo].[Reclamo]  WITH CHECK ADD  CONSTRAINT [FK_Reclamo_Cliente] FOREIGN KEY([dniCliente])
REFERENCES [dbo].[Cliente] ([dniCliente])
GO
ALTER TABLE [dbo].[Reclamo] CHECK CONSTRAINT [FK_Reclamo_Cliente]
GO
ALTER TABLE [dbo].[Reclamo]  WITH CHECK ADD  CONSTRAINT [FK_Reclamo_Estado] FOREIGN KEY([estado])
REFERENCES [dbo].[Estado] ([nroEstado])
GO
ALTER TABLE [dbo].[Reclamo] CHECK CONSTRAINT [FK_Reclamo_Estado]
GO
ALTER TABLE [dbo].[Reclamo]  WITH CHECK ADD  CONSTRAINT [FK_Reclamo_TipoReclamo] FOREIGN KEY([tipoReclamo])
REFERENCES [dbo].[TipoReclamo] ([idTipoReclamo])
GO
ALTER TABLE [dbo].[Reclamo] CHECK CONSTRAINT [FK_Reclamo_TipoReclamo]
GO
ALTER TABLE [dbo].[ReclamoProducto]  WITH CHECK ADD  CONSTRAINT [FK_ReclamoProducto_Reclamo] FOREIGN KEY([nroReclamo])
REFERENCES [dbo].[Reclamo] ([nroReclamo])
GO
ALTER TABLE [dbo].[ReclamoProducto] CHECK CONSTRAINT [FK_ReclamoProducto_Reclamo]
GO
ALTER TABLE [dbo].[Rol]  WITH CHECK ADD  CONSTRAINT [FK_Rol_Rol] FOREIGN KEY([idRol])
REFERENCES [dbo].[Rol] ([idRol])
GO
ALTER TABLE [dbo].[Rol] CHECK CONSTRAINT [FK_Rol_Rol]
GO
ALTER TABLE [dbo].[TipoReclamo]  WITH CHECK ADD  CONSTRAINT [FK_TipoReclamo_TipoReclamo] FOREIGN KEY([idTipoReclamo])
REFERENCES [dbo].[TipoReclamo] ([idTipoReclamo])
GO
ALTER TABLE [dbo].[TipoReclamo] CHECK CONSTRAINT [FK_TipoReclamo_TipoReclamo]
GO
ALTER TABLE [dbo].[Usuario]  WITH CHECK ADD  CONSTRAINT [FK_Usuario_Rol] FOREIGN KEY([idRol])
REFERENCES [dbo].[Rol] ([idRol])
GO
ALTER TABLE [dbo].[Usuario] CHECK CONSTRAINT [FK_Usuario_Rol]
GO
USE [master]
GO
ALTER DATABASE [tpapi] SET  READ_WRITE 
GO
