# Sử dụng image cơ bản có hỗ trợ Java
FROM openjdk:11-jre-slim

# Thiết lập thư mục làm việc
WORKDIR /app

COPY target/quanly.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
