package com.boothj5.jloc;

import java.io.File;

public class FileCounterApp {

    public int getFileCount(String path) {
        File dir = new File(path);
        File[] files = dir.listFiles();

        int count = 0;
        if(files != null) {
            for (File file : files) {
                if(file.isDirectory()){
                    count += getFileCount(file.getPath());
                } else {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Usage: java FileCounterApp directory");
            System.exit(0);
        }
        int fileCount = new FileCounterApp().getFileCount(args[0]);
        System.out.println("Files: " + fileCount);
    }
}
