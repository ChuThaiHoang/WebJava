-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tmdt
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `uID` int NOT NULL AUTO_INCREMENT,
  `user` varchar(100) NOT NULL,
  `pass` varchar(100) NOT NULL,
  `isSell` int NOT NULL,
  `isAdmin` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `sdt` varchar(20) NOT NULL,
  `diaChi` varchar(500) DEFAULT NULL,
  `lock` int NOT NULL,
  PRIMARY KEY (`uID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'admin','123',1,1,'abcds','09586734','Newzealand',0),(2,'aa','aa',0,1,'nhfjenc','958673','dgdffff',0),(3,'johan','123',0,1,'Johan luca','9875938','sjdfjskfjs',0),(4,'aniie','123',1,0,'aniie Deluna','6785983','ádfasfasfasf',0),(5,'adida','123',0,0,'adida điaa','78693832','Mông cổ',0),(6,'trungtruc','123',0,0,'Nguyễn Trung  Trực','974253','Việt Nam',0),(7,'aaaa','123',0,0,'abcs','12345','azz',0),(8,'123','123',0,0,'cô bé quàng khăn đỏ','0987654321','Việt Nam',0),(9,'abc','123',0,0,'Anh bán cá','0987654321','Việt Nam',1),(10,'abcv','123',0,0,'cô bé quàng khăn đỏ','0987654321','Việt Nam',0);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cart`
--

DROP TABLE IF EXISTS `cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cart` (
  `id` int NOT NULL AUTO_INCREMENT,
  `AccountID` int NOT NULL,
  `ProductID` int NOT NULL,
  `Amount` int NOT NULL,
  `lock` int NOT NULL,
  PRIMARY KEY (`id`,`AccountID`,`ProductID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cart`
--

LOCK TABLES `cart` WRITE;
/*!40000 ALTER TABLE `cart` DISABLE KEYS */;
INSERT INTO `cart` VALUES (3,1,1,1,1),(4,1,5,1,1),(5,1,2,4,1),(6,4,2,1,0),(7,4,6,1,0),(8,4,27,1,0);
/*!40000 ALTER TABLE `cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `category` (
  `cid` int NOT NULL AUTO_INCREMENT,
  `cname` varchar(100) NOT NULL,
  `lock` int NOT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Iphone',0),(2,'Xiaomi',0),(3,'Realme',0),(4,'nokia',0),(5,'Samsung',0),(6,'Oppo',0),(7,'Asus',0);
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `deal`
--

DROP TABLE IF EXISTS `deal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `deal` (
  `dealID` int NOT NULL AUTO_INCREMENT,
  `AccountID` int NOT NULL,
  `ProductID` int NOT NULL,
  `Amount` int NOT NULL,
  `checkPay` int NOT NULL,
  PRIMARY KEY (`dealID`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `deal`
--

LOCK TABLES `deal` WRITE;
/*!40000 ALTER TABLE `deal` DISABLE KEYS */;
INSERT INTO `deal` VALUES (1,0,0,0,1),(2,2,1,30,3),(3,2,1,30,0),(4,1,45,1,4),(5,1,45,99,3),(6,1,1,0,3),(7,1,1,10,3),(8,1,1,3,3),(9,1,1,3,3),(10,1,42,1,3),(11,1,40,1,3),(12,1,37,1,3),(13,1,37,1,2),(14,1,45,1,3),(15,1,7,1,3),(16,1,42,1,3),(17,1,45,1,3),(18,1,41,1,3),(19,1,40,5,3),(20,1,39,2,3),(21,1,33,1,3),(22,1,31,6,3),(23,1,45,5,0),(24,10,38,1,0);
/*!40000 ALTER TABLE `deal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `image` varchar(500) NOT NULL,
  `price` int NOT NULL,
  `title` varchar(500) NOT NULL,
  `description` varchar(5000) NOT NULL,
  `cateID` int NOT NULL,
  `sell_ID` int NOT NULL,
  `amount` int NOT NULL,
  `lock` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (1,'Xiaomi Redmi Note 12','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/g/t/gtt_7766_3__1.jpg',300,'Trải nghiệm thị giác siêu đã với màn hình 6.67 inch cùng tấm nền AMOLED thời thượng','Xiaomi Redmi Note 12 sở hữu màn hình Super AMOLED với tần số quét 120Hz giúp trải nghiệm chạm vuốt diễn ra mượt mà, camera AI 50MP chất lượng. Bên cạnh đó, điện thoại sẽ được chạy trên con chip Qualcomm Snapdragon 685 kết hợp với card đồ họa GPU Qualcomm Adreno 610 mang lại trải nghiệm dùng ổn định. Điện thoại Xiaomi Redmi Note 12 mang lại thời gian sử dụng vượt trội với viên pin 5000mAh cùng sạc nhanh công suất 33W',2,1,2,0),(2,'Samsung Galaxy S23 Ultra 256GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/g/a/galaxys23ultra_front_green_221122_2.jpg',450,'Sau sự đổ bộ thành công của Samsung Galaxy S22 những chiếc điện thoại dòng Flagship tiếp theo - Điện thoại Samsung Galaxy S23 Ultra là đối tượng được Samfans hết mực săn đón. Kiểu dáng thanh lịch sang chảnh kết hợp với những bước đột phá trong công nghệ đã kiến tạo nên siêu phẩm Flagship nhà Samsung.','Thoả sức chụp ảnh, quay video chuyên nghiệp - Camera đến 200MP, chế độ chụp đêm cải tiến, bộ xử lí ảnh thông minh',5,4,45,0),(3,'Samsung Galaxy S22 Ultra (8GB - 128GB)','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/s/m/sm-s908_galaxys22ultra_front_burgundy_211119.jpg',560,'Vi xử lý mạnh mẽ nhất Galaxy - Snapdragon 8 Gen 1 (4 nm)','Đúng như các thông tin được đồn đoán trước đó, mẫu flagship mới của gả khổng lồ Hàn Quốc được ra mắt với tên gọi là Samsung Galaxy S22 Ultra với nhiều cải tiến đáng giá. Mẫu điện thoại cao cấp đến từ Samsung này có nhiều thay đổi từ thiết kế, cấu hình cho đến camera. Vậy siêu phẩm này có gì mới, giá bao nhiêu và có nên mua không? Hãy cùng tìm hiểu chi tiết ngay bên dưới nhé!',5,4,50,0),(4,'Samsung Galaxy Z Flip4 128GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/s/a/samsung_galaxy_z_flip_m_i_2022-1_1.jpg',425,'Ngoại hình thời trang - cầm nắm cực sang với thiết kế gập vỏ sò độc đáo','Tiếp tục là một mẫu smartphone màn hình gập độc đáo, đầy lôi cuốn và mới mẻ từ hãng công nghệ Hàn Quốc, dự kiến sẽ có tên là Samsung Galaxy Z Flip 4 với nhiều nâng cấp. Đây hứa hẹn sẽ là một siêu phẩm bùng nổ trong thời gian tới và thu hút được sự quan tâm của đông đảo người dùng với nhiều cải tiến từ ngoại hình, camera, bộ vi xử lý và viên pin được nâng cấp.',5,4,2,0),(5,'iPhone 13 Pro Max 128GB | Chính hãng VN/A','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/3/_/3_51_1_7.jpg',560,'Hiệu năng vượt trội - Chip Apple A15 Bionic mạnh mẽ, hỗ trợ mạng 5G tốc độ cao','Máy mới 100% , chính hãng Apple Việt Nam.',1,4,75,0),(6,'iPhone 14 Pro 256GB | Chính hãng VN/A','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/t/_/t_m_13.png',456,'Trải nghiệm thị giác ấn tượng - Màn hình Dynamic Island, sắc nét với công nghệ Super Retina XDR, mượt mà 120 Hz','Máy mới 100% , chính hãng Apple Việt Nam.',1,4,100,0),(7,'Xiaomi 12T 8GB 128GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/x/i/xiaomi-12t-den_1.jpg',576,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Kiến tạo khoảnh khắc hoàn hảo - Camera chuyên nghiệp 108MP + 8MP + 2MP, chống rung quang học OIS',2,4,230,0),(8,'OPPO Reno8 T 5G (8GB - 128GB)','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/o/p/oppo-reno8t-vang1-thumb-600x600.jpg',523,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Thiết kế thời thượng - Tràn viền, mỏng nhẹ đặc biệt phù hợp với các bạn trẻ, yêu khám phá xu hướng mới',6,4,120,0),(27,'ASUS ROG Phone 7 16GB 512GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/_/1_366.jpg',567,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Hiệu năng khủng với chip Snapdragon 8 Gen2 cùng RAM 16 GB, giúp xử lý tốt mọi tác vụ hàng ngày',7,4,200,0),(28,'Xiaomi 13 Lite','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/3/13_liteee.jpg',487,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Hệ thống camera hàng đầu - Camera kép selfie cùng khung hình động đem lại những bức ảnh kiệt tác',2,4,100,0),(29,'Samsung Galaxy Z Fold4 512GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/s/a/samsung_galaxy_z_fold_4-7_3.jpg',467,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Camera mắt thần bóng đêm cho trải nghiệm chụp ảnh ấn tượng - Camera chính: 50MP',5,4,100,0),(30,'Xiaomi 13 8GB 256GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/p/m/pms_1670745783.80967984.png',478,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Ống kính Leica chuyên nghiệp - 2 phong cách nhiếp ảnh vintage cùng hiện đại sống động giúp bạn tha hồ lựa chọn',2,4,100,0),(31,'POCO X5 5G 6GB 128GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/d/7/d78000_2__1.jpg',436,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Không gian gaming đúng chuẩn - Màn hình lớn 6.67\" AMOLED DotDisplay và 120Hz cho khung hình sắc nét và chuyển động mượt mà',2,4,105,0),(32,'Xiaomi POCO X5 Pro 5G 6GB 128GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/d/7/d78000_6_.jpg',521,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Chiến game mạnh mẽ - Vi xử lý Snapdragon® 778G, lõi 5G 6nm mạnh mẽ cho trải nghiệm trọn vẹn trong mọi tác vụ',2,4,100,0),(33,'Xiaomi Mi 11 Lite 5G','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/x/i/xiaomi-mi-11-lite-5g-2_10.png',564,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Không gian hiển thị thoải mái, chuyển động mượt - Màn hình tràn viền 6,55 inch, tần số quét 90Hz, HDR10+',2,4,100,0),(34,'OPPO A77s','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/c/o/combo_a77s-_en_2.jpg',520,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Nâng tầm trải nghiệm thị giác - Tấm nền IPS LCD với kích thước 6.56 inch, tần số quét 90Hz',6,4,100,0),(35,'OPPO A16K','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/c/o/combo_a16k_-_black.jpg',534,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Bắt trọn mọi khoảnh khắc - Camera sau 13M chụp chân dung, chụp ban đêm rõ nét',6,4,100,0),(36,'Nokia G22 4GB 128GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/d/g/dgtyi8899_.jpg',324,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Tấm nền AMOLED mang đến chất lượng hiển thị rõ nét và chân thực',4,4,100,0),(37,'Nokia 5710 XpressAudio','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/n/o/nokia-5701.jpg',200,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Loa ngoài to rõ cho âm thanh sống động, nghe radio tiện lợi không cần kết nối tai nghe',4,4,99,0),(38,'Nokia 110 4G','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/1/110-1.jpg',190,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Thiết kế nhỏ gọn với nhiều màu sắc trẻ trung, hiện đại',4,4,99,0),(39,'realme C55 6GB 128GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/r/g/rgrgrtyt6.jpg',450,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Kiểu dáng hiện đại với các cạnh viền vuông vức và camera được bố trí độc đáo',3,4,101,0),(40,'realme 9 Pro','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/r/e/real_me_pro_002.jpg',359,'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất','Chìm đắm trong từng khung hình - Màn hình IPS LCD 6.6\", 1080 x 2412 pixel',3,4,104,0),(41,'realme 9 Pro Plus','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/9/_/9_ro_plus.png',358,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Thiết kế sang trọng, thu hút mọi ánh nhìn - Mặt lưng hiệu ứng gradiant bắt mắt, thay đổi theo từng góc nhìn',3,4,100,0),(42,'realme 10 8GB 256GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/w/h/white-7e6a0f537b.png',346,'Mới, đầy đủ phụ kiện từ nhà sản xuất','RAM mở rộng lên đến 16GB - Xử lí đa tác vụ mượt mà',3,4,99,0),(43,'realme GT Neo 5','https://cdn2.cellphones.com.vn/x358,webp,q100/media/catalog/product/p/u/purple-be8e0ce5d0.png',678,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Điện thoại Realme GT Neo 5 được trang bị con chip cao cấp Qualcomm Snapdragon 8+ Gen 1 được sản xuất trên tiến trình 6 nm cùng GPU Adreno 730, máy cũng sở hữu bộ nhớ RAM 16GB ấn tượng cùng bộ nhớ lưu trữ 256GB. Điện thoại sở hữu màn hình kích thước 6.74 inches cùng tấm nền AMOLED, tần số quét 144Hz, cùng với đó là bộ ba camera sau chất lượng (Camera chính 50MP, camera siêu rộng 8MP và camera microscope 2MP), phía trước là camera selfie 16MP.',3,4,100,1),(44,'ASUS ROG Phone 7 Ultimate 16GB 512GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/1/_/1_365.jpg',899,'Mới, đầy đủ phụ kiện từ nhà sản xuất','Chiến game không giới hạn với vi xử lý Snapdragon 8 Gen2 giúp cải thiện hiệu suất và mức tiêu thụ pin',7,4,100,0),(45,'ASUS ROG Phone 6 16GB 512GB','https://cdn2.cellphones.com.vn/358x358,webp,q100/media/catalog/product/a/s/asus-rog-phone-6-12gb-256gb_2.png',821,'Nguyên hộp, đầy đủ phụ kiện từ nhà sản xuất','Hiệu năng dẫn đầu mọi trận đấu - Chip Snapdragon® 8+ Gen 1 mạnh mẽ cùng RAM 16GB',7,4,98,0);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-14 13:32:12
