package com.example.demo.global.Utils.DatabaseUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColumnDescription {
	private String columnName;
	private String description;
}
