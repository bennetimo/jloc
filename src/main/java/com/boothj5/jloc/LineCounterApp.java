package com.boothj5.jloc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class LineCounterApp {

    /**
     * Retrieves the number of lines across all files (recursive) in a directory
     * @param path absolute path
     * @return the number of lines found
     */
    public long getLineCount(String path) {
        File f = new File(path);

        long count = 0l;
        if(f.isDirectory()){
            for (File file : f.listFiles()) {
                count += getLineCount(file.getPath());
            }
        } else if (f.isFile()) {
            try {
                return Files.newBufferedReader(Paths.get(f.getPath())).lines().count();
            } catch (IOException e) {
                //TODO: Add logging library
                System.out.println("Could not include count of file: " + f.getAbsolutePath() + ", reason: " + e.getMessage());
                return 0;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Usage: java LineCounterApp directory");
            System.exit(0);
        }
        int fileCount = new FileCounterApp().getFileCount(args[0]);
        long lineCount = new LineCounterApp().getLineCount(args[0]);


        System.out.println("Files: " + fileCount);
        System.out.println("Lines: " + lineCount);
    }
}
