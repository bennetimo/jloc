package com.boothj5.jloc

import java.io.File

import scala.io.Source

class SLineCounterApp extends App {

  /**
   * Retrieves the number of lines across all files (recursive) in a directory
   * @param path absolute path
   * @return the number of lines found
   */
  def getLineCount(path: String): Long = countBy(List(new File(path)), (f: File) => Source.fromFile(f).getLines().length)

  if (args.length != 1) {
    println("Usage: scala SFileCounterApp directory")
    System.exit(0)
  }

  println("Files: " + getLineCount(args(0)))

}