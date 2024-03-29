package com.example.demo.global.Utils.DatabaseUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatabaseDto {
	private String colunmName;
	private String type;
	private String foreignKey;
	private Integer columnSize;
	private boolean isNullable;
	private String defautValue;
	private String description;
}
