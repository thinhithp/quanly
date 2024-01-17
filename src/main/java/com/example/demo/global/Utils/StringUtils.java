package com.example.demo.global.Utils;

public class StringUtils {

	private StringUtils() {
		throw new UnsupportedOperationException();
	}

	public static String extractFolderIdFromLink(String folderLink) {
		return folderLink.substring(folderLink.lastIndexOf('/') + 1);
	}

	// Kiểm tra chuỗi truyền vào có null hay không
	public static boolean isNullOrBlank(String text) {
		return text == null || text.trim().isBlank();
	}
	// Kiem tra chuoi rong hoac null
	public static boolean isEmpty(String text){
		return text == null || text.isEmpty();
	}
	// Chuyen doi chuoi sang chu hoa hoac chu thuong
	public static String toUpperCase(String text){
		return text == null ? null : text.toUpperCase();
	}

}
