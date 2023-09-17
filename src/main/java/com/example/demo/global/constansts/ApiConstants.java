package com.example.demo.global.constansts;

public class ApiConstants {

    private ApiConstants() {
    }

    public static class Nha {
        /**
         * @UnsupportedOperationException là một
         * loại ngoại lệ (exception) không kiểm tra
         * (unchecked) trong Java, thường được sử dụng để chỉ ra rằng
         * một phương thức cụ thể chưa được hỗ trợ hoặc không được thực hiện.
         */
        private Nha() {
            throw new UnsupportedOperationException();
        }

        public static final String BASE = "nha";

        public static final String NHA_CREATE = "create";
        public static final String NHA_UPDATE = "update/{id}";

        public static final String DETAIL = "{id}";


        // depcreption

        public static final String CREATE_NHA = "Tạo mới nhà";


    }
}
