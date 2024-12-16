CREATE DATABASE sellphone;
USE sellphone;


CREATE TABLE role (
rID INT  PRIMARY KEY,
roleName VARCHAR(255) NOT NULL
);

CREATE TABLE account(
uID INT AUTO_INCREMENT PRIMARY KEY,
`user` VARCHAR(255) not NULL,
pass VARCHAR(255) not NULL,
name varchar(50) DEFAULT NULL,
phone varchar(15) DEFAULT NULL,
address varchar(200) DEFAULT NULL,
gmail varchar(50) DEFAULT NULL,
rID INT NOT NULL ,
FOREIGN KEY (rID) REFERENCES role(rID) ON DELETE CASCADE ON UPDATE CASCADE
);



CREATE TABLE category(
cID INT  AUTO_INCREMENT NOT NULL PRIMARY KEY,
cname VARCHAR(50) NOT NULL,
cImage nvarchar(255) NULL
);

CREATE TABLE product(
pID INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(300) NULL,
image VARCHAR(300) NULL,
price DECIMAL(10,2) NULL,
title VARCHAR(300) NULL,
description VARCHAR(1000) NULL,
cID INT NULL,
FOREIGN KEY (cID) REFERENCES category(cID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cart(
    CartID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    uID INT NOT NULL,
    totalPrice decimal(10,2) DEFAULT NULL,
    FOREIGN KEY (uID) REFERENCES account(uID) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE cartitem(
    CartItemID INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    pID INT NOT NULL,
    CartID INT NOT NULL,
    Amount INT NULL,
    FOREIGN KEY (pID) REFERENCES product(pID) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY (CartID) REFERENCES cart(CartID) ON DELETE CASCADE ON UPDATE CASCADE
);


INSERT INTO role (rID, roleName) VALUES 
(1,'admin'),
(2,'guest');

INSERT INTO account (user, pass, name, phone, address, gmail,rID) VALUES
('Nam', MD5('1'), 'Nguyễn Văn A', '0901234567', '123 Đường số 1, Quận 1, TP.HCM', 'vana@gmail.com', 1),
('Minh', MD5('0'),'Trần Thị B', '0912345678', '456 Đường số 2, Quận 2, TP.HCM', 'thib@gmail.com', 2),
('Vy', MD5('0'), 'Phạm Thị D', '0934567890', '1011 Đường số 4, Quận 4, TP.HCM', 'thid@gmail.com',2 ),
('Khach1', MD5('0'), 'Lê Văn C', '0923456789', '789 Đường số 3, Quận 3, TP.HCM', 'lec@gmail.com',2),
('Khach2', MD5('0'),'Hoàng Văn E', '0945678901', '1213 Đường số 5, Quận 5, TP.HCM', 'vane@gmail.com', 2),
('Khach3', MD5('0'),'Nguyễn Thị F', '0956789012', '1415 Đường số 6, Quận 6, TP.HCM', 'thif@gmail.com', 2),
('Khach4', MD5('0'),'Trần Văn G', '0967890123', '1617 Đường số 7, Quận 7, TP.HCM', 'vang@gmail.com', 2),
('Khach5', MD5('0'),'Vũ Văn F', '0967890123', '1617 Đường số 7, Quận 7, TP.HCM', 'vanF@gmail.com',2),
('Khach6', MD5('0'),'Trần Thị Trùn', '0967890123', '1617 Đường số 7, Quận 7, TP.HCM', 'trun@gmail.com', 2);





INSERT INTO category (cID, cname,cImage) VALUES 
(1, 'IPHONE','//cdn.tgdd.vn/Brand/1/logo-iphone-220x48.png'), 
(2, 'SAMSUNG','//cdn.tgdd.vn/Brand/1/samsungnew-220x48-1.png'), 
(3, 'OPPO','//cdn.tgdd.vn/Brand/1/OPPO42-b_5.jpg'), 
(4, 'XIAOMI','//cdn.tgdd.vn/Brand/1/logo-xiaomi-220x48-5.png'),
(5, 'VIVO','//cdn.tgdd.vn/Brand/1/vivo-logo-220-220x48-3.png'),
(6, 'REALME','//cdn.tgdd.vn/Brand/1/Realme42-b_37.png'),
(7, 'NOKIA','//cdn.tgdd.vn/Brand/1/Nokia42-b_21.jpg'),
(8, 'MASSTEL','//cdn.tgdd.vn/Brand/1/Masstel42-b_0.png'),
(9, 'ITEL','//cdn.tgdd.vn/Brand/1/Itel42-b_54.jpg');

SET FOREIGN_KEY_CHECKS=0;


INSERT INTO product (name, image, price, title, description, cID) VALUES
('Iphone 13', 'https://cdn.tgdd.vn/Products/Images/42/223602/iphone-13-starlight-1-600x600.jpg', 100.0000, 'Đỉnh cao thời thượng', 'Hiệu năng vượt trội - Chip Apple A15 Bionic mạnh mẽ. Hỗ trợ mạng 5G tốc độ cao. Không gian hiển thị sống động - Màn hình 6.7" Super Retina XDR độ sáng cao, sắc nét. Trải nghiệm điện ảnh đỉnh cao - Cụm 3 camera kép 12MP, hỗ trợ ổn định hình ảnh quang học. ', 1),
('Samsung Galaxy Z Flip4', 'https://cdn.tgdd.vn/Products/Images/42/258047/samsung-galaxy-z-flip4-5g-128gb-thumb-tim-600x600.jpg', 120.000, 'Con cưng của nhà SamSung', 'Ngoại hình thời trang - cầm nắm cực sang với thiết kế gập vỏ sò độc đáo. Hiệu năng mạnh mẽ đến từ dòng chip cao cấp của Qualcomm - Snapdragon 8+ Gen 1. Công nghệ màn hình hàng đầu đến từ Samsung - 6.7 inch, tấm nền Dynamic AMOLED 2X.', 2),
('Iphone 13 Pro', 'https://cdn.tgdd.vn/Products/Images/42/230529/iphone-13-pro-max-xanh-la-thumb-600x600.jpg', 70.000, 'Siêu tiết kiệm pin', 'Hiệu năng vượt trội - Chip Apple A15 Bionic mạnh mẽ, hỗ trợ mạng 5G tốc độ cao. Không gian hiển thị sống động - Màn hình 6.1" Super Retina XDR độ sáng cao, sắc nét. Tối ưu điện năng - Sạc nhanh 20 W, đầy 50% pin trong khoảng 30 phút.', 1),
('OPPO A55', 'https://cdn.tgdd.vn/Products/Images/42/249944/oppo-a55-4g-thumb-new-600x600.jpg', 140.000, 'Sinh ra để chụp ảnh', 'Màn hình giải trí thoải mái - Màn hình 6.51", HD+. Lưu giữ mọi khoảng khắc - Camera quay chụp thông minh lên tới 50MP. Thời gian sử dụng lâu hơn - Pin 5000 mAh, sạc nhanh 18 W.', 2),
('Xiaomi Redmi Note 11', 'https://cdn.tgdd.vn/Products/Images/42/279066/xiaomi-12t-pro-thumb-bac-1-600x600.jpg', 150.000, 'Sinh ra để chơi game', 'Nâng cao trải nghiệm thị giác - Màn hình AMOLED 6.43"" Full HD+, công nghệ DotDisplay. Thoải mái sử dụng không lắng lo - Viên pin 5000 mAh, sạc nhanh 33 W. Hiệu năng ấn tượng - Snapdragon 680 8 nhân cùng RAM 4GB, bộ nhớ 64GB.', 1),
( 'Xiaomi 12 Pro', 'https://cdn.tgdd.vn/Products/Images/42/234621/Xiaomi-12-xam-thumb-mau-600x600.jpg', 160.0000, 'Sạc siêu nhanh chưa đầy 15p',' Kiến tạo siêu khoảnh khắc - Hệ thống camera 200MP, chống rung quang học OIS và ống kính 8P.  Thiết kế siêu việt - Trọn vẻ đẹp sang trọng, đẳng cấp, vỏ nhám chống bám vân tay, khung kim loại cứng cáp, độc đáo.  Năng lượng bất tận, khám phá cả ngày - Dung lượng pin 5000mAh, sạc siêu nhanh HyperCharge 120W. ', 2),
( 'Iphone 12 Mini', 'https://cdn.tgdd.vn/Products/Images/42/228742/iphone-12-mini-do-600x600.jpeg', 170.0000, 'Hiệu năng cực đỉnh ',' Mạnh mẽ, siêu nhanh với chip A14, RAM 6GB, mạng 5G tốc độ cao.  Bền bỉ vượt trội - Kháng nước, kháng bụi IP68, mặt lưng Ceramic Shield.  Chụp ảnh siêu đỉnh - Night Mode , thuật toán Deep Fusion, Smart HDR 3, camera LiDar. ', 1),
 ( 'OPPO Reno 8 Pro', 'https://cdn.tgdd.vn/Products/Images/42/260546/oppo-reno8-pro-thumb-xanh-1-600x600.jpg', 150.0000,'Gấp đôi hiệu suất ', ' Chuyên gia chân dung, bừng sáng khoảnh khắc đêm - Cụm camera 64MP + 2MP + 2MP hiện đại.  Sạc nhanh siêu tốc, tràn đầy năng lượng cho cả ngày - Viên pin 4500mAh, Sạc nhanh siêu tốc 33W.  Gấp đôi hiệu suất, xử lí mọi tác vụ - Con chip Qualcomm Snapdragon 680 mạnh mẽ trong phân khúc. ', 4),
 ( 'SamSung Galaxy A23 (99%) ', 'https://cdn.tgdd.vn/Products/Images/42/262650/samsung-galaxy-a23-cam-thumb-600x600.jpg', 180.0000,'Trả góp 0%', ' Nâng cao trải nghiệm với màn hình chất lượng - Màn hình LCD 6.6 inch Full HD+.  Hiệu năng ấn tượng mạnh mẽ - Snapdragon 680 (SM6225), RAM dung lượng 4GB.  Pin dung lượng 5000mAh, sạc nhanh ấn tượng - 5.000 mAh, sạc nhanh 25W. ', 3),
 ( 'SamSumGalaxyZ (99%) ', 'https://cdn.tgdd.vn/Products/Images/42/250625/samsung-galaxy-z-fold4-kem-256gb-600x600.jpg', 100.0000,'Trả góp 0%', ' Camera mắt thần bóng đêm cho trải nghiệm chụp ảnh ấn tượng - Camera chính: 50MP.  Khai mở trải nghiệm di động linh hoạt biến hóa - Màn hình ngoài 6.2"" cùng màn hình chính 7.6"" độc đáo.  Viên pin ấn tượng, sạc nhanh tức tốc - Pin 4,400 mAh, sạc nhanh 25 W. ', 4),
 ( 'Dây Cáp 30-Pin Cho iP/iPd 2 3 4', 'https://cf.shopee.vn/file/c727ae93a663ad79d309254fcafba4b0', 90.0000, 'Sạc đến 5000mah', 'Sử dụng sạc và truyền dữ liệu. Tương thích cho các dòng dùng chuẩn 30-pin. Chiều dài: 1m',5),
( 'Cáp Type C - Type C 2m Xmobile TCS2000', 'https://cdn.tgdd.vn/Products/Images/58/258245/cap-type-c-type-c-2m-xmobile-tcs2000-thumb-600x600.jpeg',180.0000,'Tận 2 cổng sạc', 'Dây có độ dài 2 m dễ quấn lại và mang theo đến bất kỳ nơi nào. Dòng sạc tối đa 100 W giúp nạp pin cho thiết bị nhanh chóng. Trang bị 2 jack cắm Type-C sử dụng được với các thiết bị có cổng Type-C phù hợp. ',5),
 ( 'BỘ CỦ CÁP SẠC SIÊU NHANH 45W DÀNH CHO SAMSUNG', 'https://salt.tikicdn.com/cache/600x600/ts/product/1a/ad/d7/b76808ef97432f364440508ca58cd98e.jpg',180.0000,'Giá rẻ tiện lợi ', 'Thiết kế gọn nhẹ, phù hợp khi di chuyển. Kèm theo cáp USB-C cho khả năng sạc nhanh với nguồn điện ra. ',5);




