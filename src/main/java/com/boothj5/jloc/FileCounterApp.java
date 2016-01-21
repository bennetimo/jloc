package com.boothj5.jloc;

import java.io.File;

public class FileCounterApp {

    public int getFileCount(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();

        int count = 0;
        for (File file : files) {
            if(file.isDirectory()){
                count += getFileCount(file.getPath());
            } else {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println("Files: 0");
    }
}
