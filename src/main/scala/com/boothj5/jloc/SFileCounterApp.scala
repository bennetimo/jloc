package com.boothj5.jloc

import java.io.File

class SFileCounterApp extends App {

  /**
   * Retrieves the number of files (recursive) in a directory
   * @param path absolute path
   * @return the number of files in the directory, 1 if the path given represents a single file, 0 otherwise
   */
  def getFileCount(path: String): Int = countBy(List(new File(path)), (f: File) => 1).toInt

  if (args.length != 1) {
    println("Usage: scala SFileCounterApp directory")
    System.exit(0)
  }

  println("Files: " + getFileCount(args(0)))

}
