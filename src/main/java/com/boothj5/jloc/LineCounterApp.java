package com.boothj5.jloc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineCounterApp {

    private long getFileLineCount(String filePath){
        try {
            return Files.newBufferedReader(Paths.get(filePath)).lines().count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0l;
    }

    public long getLineCount(String path) {

        File dir = new File(path);
        File[] files = dir.listFiles();

        long count = 0;
        if(files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    count += getLineCount(file.getPath());
                } else {
                    count += getFileLineCount(file.getPath());
                }
            }
        } else {
            //Single file
            return getFileLineCount(path);
        }

        return count;
    }


    public static void main(String[] args) {
        System.out.println("Files: 0");
        System.out.println("Lines: 0");
    }
}
