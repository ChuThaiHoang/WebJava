# WebJava
Project: Xây dựng trang web thương mại điện tử(Website E -commerce)
Tool: Netbean , Tomcat 10.1.11,  MySQL
Code language: Java
discription: Website bán điện thoại thông minh. Giao diện đơn giản, thực hiện được các chức năng cơ bản như đăng nhập, đăng kí, đăng xuất và một số chức năng khác.
p/s: Vì File có vấn đề nên chỉ có thể pull .rar lên git. Nếu muốn xem code xin vui lòng làm theo các bước sau:
b1: Tải File từ github về rồi giải nén
b2: Mở MySQL, vào server của bạn, Ở mục Navigation(Adminnistraton) chọn DataImport/Restore, chọn Import from Self-Contained File, Tìm đường link của File data.sql ở tệp vừa giải nén rồi paste vào, sau đó phía trên cửa sổ nhấn Import và nhấn start Import
b3: Mở Netbean, mở file TMDT(sau khi bạn mở sẽ có thông báo lỗi bạn chỉ cần bấm vào và thêm file tương ứng trong tệp Libraries là hết), ở Source Packages , mở tệp context, chọn File DbContext.java
b4: Thay đổi lại các thông tin như url(Xem địa chỉ localhost có khớp với địa chỉ ở máy bạn không), tên database(tên database mới vừa tạo), username(user server My SQL), password(pass user My SQL) sau đó lưu lại và chạy như bình thường 
