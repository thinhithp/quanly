package com.example.demo.global.Utils.DatabaseUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ComponentScan
@Service
public class DatabaseUltis {
	@Autowired
	private DataSource dataSource;
	private Set<String> validTableNames = new HashSet<>();

	public List<DatabaseDto> readTable(String table) {
		List<DatabaseDto> databaseDtos = new ArrayList<>();
		try (Connection conn = dataSource.getConnection()) {
			// Lấy thông tin khóa ngoại
			Map<String, String> foreignKeys = getForeignKeys(conn, table);
			// Lấy thông tin cột
			try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM " + table)) {
				ResultSetMetaData metaData = rs.getMetaData();
				int columnCount = metaData.getColumnCount();
				for (int i = 1; i <= columnCount; i++) {
					DatabaseDto dto = new DatabaseDto();
					dto.setColunmName(metaData.getColumnName(i));
					dto.setType(metaData.getColumnTypeName(i));
					dto.setColumnSize(metaData.getColumnDisplaySize(i));
					dto.setNullable(metaData.isNullable(i) == ResultSetMetaData.columnNullable);
					// Lưu ý: Không phải tất cả cơ sở dữ liệu đều hỗ trợ lấy giá trị mặc định và mô tả qua JDBC
					// dto.setDefautValue(metaData.get);
					//	dto.setDescription(...);
					dto.setForeignKey(foreignKeys.getOrDefault(dto.getColunmName(), null));

					databaseDtos.add(dto);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return databaseDtos;
	}

	public Map<String, String> getColumnDescriptions(String tableName) {
		if (!isValidTableName(tableName)) {
			throw new IllegalArgumentException("Invalid table name");
		}

		Map<String, String> columnDescriptions = new HashMap<>();
		String query =
				"SELECT cols.column_name, pg_catalog.col_description(c.oid, cols.ordinal_position::int) AS column_description "
						+ "FROM information_schema.columns cols "
						+ "LEFT JOIN pg_catalog.pg_class c ON c.relname = cols.table_name "
						+ "WHERE cols.table_schema = 'public' AND cols.table_name = ?";

		try (Connection conn = dataSource.getConnection(); PreparedStatement stmt = conn.prepareStatement(query)) {
			stmt.setString(1, tableName);

			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					String columnName = rs.getString("column_name");
					String description = rs.getString("column_description");
					columnDescriptions.put(columnName, description);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnDescriptions;
	}

	private void loadValidTableNames(DataSource dataSource) {
		try (Connection conn = dataSource.getConnection();
				ResultSet rs = conn.getMetaData().getTables(null, null, "%", new String[] { "TABLE" })) {
			while (rs.next()) {
				validTableNames.add(rs.getString("TABLE_NAME").toLowerCase());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean isValidTableName(String tableName) {
		return validTableNames.contains(tableName.toLowerCase());
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
