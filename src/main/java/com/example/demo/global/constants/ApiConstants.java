package com.example.demo.global.constants;

public class ApiConstants {
    public static final String BASE = "/v1";

    private ApiConstants() {
    }


    public static class Tag {
        private Tag() {
        }

        public static final String BASE = "/tag";
    }

    public static class SanPham {
        private SanPham() {
        }

        public static final String BASE = "/san-pham";
    }

    public static class Action {
        private Action() {
        }
        public static final String SEARCH = "/search";

        public static final String DETAIL = "/detail";

        public static final String INSERT = "/insert";

        public static final String UPDATE = "/update";

        public static final String DELETE = "/delete";

    }
}
