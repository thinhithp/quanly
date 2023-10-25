package com.example.demo.global.Enum;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class EnumTag {

    private EnumTag() {
        throw new UnsupportedOperationException();
    }

    @Getter
    @AllArgsConstructor
    public enum tag {

    }
}
