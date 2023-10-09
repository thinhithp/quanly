# Sử dụng hình ảnh CentOS 7 làm base image
FROM centos:7

# Cài đặt các gói cần thiết
RUN yum install -y java-11-openjdk-devel wget && \
    yum clean all

# Tải và cài đặt Maven
RUN wget https://apache.mirror.digionline.de/maven/maven-3/3.8.3/binaries/apache-maven-3.8.3-bin.tar.gz && \
    tar -zxvf apache-maven-3.8.3-bin.tar.gz && \
    mv apache-maven-3.8.3 /opt/maven && \
    rm apache-maven-3.8.3-bin.tar.gz

# Thiết lập biến môi trường cho Maven
ENV M2_HOME=/opt/maven
ENV M2=$M2_HOME/bin
ENV PATH=$M2:$PATH

# Chạy lệnh kiểm tra Maven
RUN mvn --version

# Thiết lập thư mục làm việc mặc định
WORKDIR /workspace

# Khởi động bash khi container được chạy
CMD ["/bin/bash"]
