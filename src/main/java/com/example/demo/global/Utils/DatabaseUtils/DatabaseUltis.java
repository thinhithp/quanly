package com.example.demo.global.Utils.DatabaseUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ComponentScan
@Service
public class DatabaseUltis {
	@Autowired
	private DataSource dataSource;

//	public List<DatabaseDto> readTable(String table) {
//		List<DatabaseDto> databaseDtos = new ArrayList<>();
//		String querry = "SELECT * FROM " + table;
//		try (Connection conn = dataSource.getConnection();
//				Statement stmt = conn.createStatement();
//				ResultSet rs = stmt.executeQuery(querry)) {
//			ResultSetMetaData metaData = rs.getMetaData();
//			int colunmCoount = metaData.getColumnCount();
//			for (int i = 1; i <= colunmCoount; i++) {
//				databaseDtos.add(new DatabaseDto(metaData.getColumnName(i), metaData.getColumnTypeName(i), metaData.));
//			}
//			System.out.println("\nData:");
//			// Hiển thị dữ liệu từng dòng
//			while (rs.next()) {
//				for (int i = 1; i <= colunmCoount; i++) {
//					System.out.print(rs.getString(i) + " ");
//				}
//				System.out.println();
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		return databaseDtos;
//	}
public List<DatabaseDto> readTable(String table) {
	String querry = "SELECT * FROM " + table;
	List<DatabaseDto> databaseDtos = new ArrayList<>();
	try (Connection conn = dataSource.getConnection()) {
		// Lấy thông tin khóa ngoại
		Map<String, String> foreignKeys = getForeignKeys(conn, table);

		// Lấy thông tin cột
		try (Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(querry)) {
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 1; i <= columnCount; i++) {
				String columnName = metaData.getColumnName(i);
				String columnType = metaData.getColumnTypeName(i);
				String foreignKeyReference = foreignKeys.getOrDefault(columnName, null);
				databaseDtos.add(new DatabaseDto(columnName, columnType, foreignKeyReference));
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return databaseDtos;
}
	private Map<String, String> getForeignKeys(Connection conn, String table) throws SQLException {
		Map<String, String> foreignKeys = new HashMap<>();
		DatabaseMetaData metaData = conn.getMetaData();
		try (ResultSet fkResultSet = metaData.getImportedKeys(conn.getCatalog(), null, table)) {
			while (fkResultSet.next()) {
				String fkColumnName = fkResultSet.getString("FKCOLUMN_NAME");
				String pkTableName = fkResultSet.getString("PKTABLE_NAME");
				String pkColumnName = fkResultSet.getString("PKCOLUMN_NAME");
				foreignKeys.put(fkColumnName, pkTableName + "(" + pkColumnName + ")");
			}
		}
		return foreignKeys;
	}
}
