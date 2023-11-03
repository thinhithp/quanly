package com.example.demo.tag.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TagCreateDto implements Serializable {
    private static final Long serializable = 1L;

    @Size(max = 255)
    @NotNull
    private String tagName;
    @Size(max = 100)
    @NotNull
    private String itemCode;
    @Size(max = 100)
    @NotNull
    private String groupCode;
    @Size(max = 100)
    @NotNull
    private String parentCode;
}
