package com.example.demo.global.Utils;

public class StringUtils {

    private StringUtils() {
        throw new UnsupportedOperationException();
    }
    public static String extractFolderIdFromLink(String folderLink) {
        return folderLink.substring(folderLink.lastIndexOf('/') + 1);
    }

    public static boolean isNullOrBlank(String text) {
        return text == null || text.trim().isBlank();
    }
}
