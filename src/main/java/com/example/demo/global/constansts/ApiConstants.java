package com.example.demo.global.constansts;

public class ApiConstants {

    public static final String CREATE = "/create";

    public static final String UDPATE = "/update/{id}";

    public static final String DETAIL = "/{id}";

    public static final String DELETE = "/delete/{id}";

    public static final String CHANGE_PASS = "/change-pass/{id}";

    public static final String LOGIN = "/login";

    private ApiConstants() {
    }


    public static class Users {
        /**
         * @UnsupportedOperationException là một
         * loại ngoại lệ (exception) không kiểm tra
         * (unchecked) trong Java, thường được sử dụng để chỉ ra rằng
         * một phương thức cụ thể chưa được hỗ trợ hoặc không được thực hiện.
         */
        private Users() {
            throw new UnsupportedOperationException();
        }

        public static final String BASE = "user";
        public static final String CREATE_NHA = "Tạo mới nhà";
    }
}
