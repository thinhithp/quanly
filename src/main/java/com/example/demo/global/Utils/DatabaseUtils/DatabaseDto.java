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
}
