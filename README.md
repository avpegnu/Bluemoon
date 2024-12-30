# Xây dựng phần mềm Quản lý chung cư Bluemoon

## Giới thiệu

Dự án này là một ứng dụng được thiết kế để hỗ trợ quản lý thu phí chung cư Bluemoon. Các chức năng chính bao gồm:
- **Quản lý hộ gia đình**
- **Quản lý nhân khẩu**
- **Quản lý các dịch vụ của chung cư**
- **Thu phí các dịch vụ của chung cư**

## Công nghệ sử dụng
- **Java Development Kit 23(JDK 23)**
- **JavaSwing**
- **Apache Netbeans IDE 23**
- **MySQL Connector**
- **HeidiSQL**

## Đối tượng và phạm vi sử dụng
- Đối tượng sử dụng phần mềm: Ban quản trị chung cư
- Phạm vi sử dụng phần mềm: Quản lý thu phí trong chung cư

## Hướng dẫn cài đặt

Để sử dụng phần mềm, bạn cần có môi trường chạy Java. Dưới đây là các yêu cầu và hướng dẫn cài đặt:

### Yêu cầu phần mềm
- **Apache Netbeans IDE 23**
- **JDK 21 trở lên**
- **CSDL: XAMPP, HeidiSQL**

### Yêu cầu phần cứng
- Không yêu cầu cấu hình phần cứng cao, chỉ cần máy tính có khả năng chạy phần mềm.

### Hướng dẫn chi tiết các bước cài đặt
1. **Cài đặt môi trường:**
    - Cài đặt IDE lập trình và JDK để thiết lập môi trường
    - Cài đặt hệ quản trị CSDL
    - Cài đặt các thư viện cần thiết: MySQL Connector, Jcalender, JFreeChart, JCommon
3. **Import project IDE và thêm các thư viện cần thiết**
4. **Nhập cơ sở dữ liệu:**
   - Khởi động XAMPP, HeidiSQL
   - Import file `bluemoon.sql` để sử dụng
   - Chỉnh sửa URL, USER, PASSWORD trong class DBConnect.java để kết nối CSDL
5. **Chạy chương trình**

**Lưu ý:** Để cấu hình hiển thị đạt chất lượng tốt nhất, khuyến khích dùng Display resolution 1920x1080, scale 100% hoặc các layout tương tự

## Hướng dẫn sử dụng phần mềm

Phần mềm dùng cho bản quản trị để quản lý thu phí trong chung cư. Phần mềm có các chức năng chính là quản lý hộ gia đình, quản lý nhân khẩu, quản lý dịch vụ, quản lý phí thu, quản lý tài khoản cá nhân và thống kê dữ liệu phí thu. Một số chức năng có đầy đủ các chức năng con như thêm, sửa, xóa, tìm kiếm thông tin.

