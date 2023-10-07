# Sử dụng hình ảnh cơ sở mà bạn cần, ví dụ: hình ảnh OpenJDK cho Java 11
FROM openjdk:11

# Đặt thư mục làm việc mặc định trong container
WORKDIR /app

# Sao chép tất cả các tệp và thư mục từ thư mục dự án của bạn vào container
COPY . .

# Biên dịch ứng dụng Java của bạn (ví dụ: Maven)
RUN ./mvnw package -DskipTests

# Điểm khởi đầu của ứng dụng Java khi container được chạy
CMD ["java", "-jar", "target/your-java-application.jar"]
