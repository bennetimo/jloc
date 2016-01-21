package com.boothj5.jloc

import java.io.File

import scala.io.Source

class SLineCounterApp extends App {

  def getLineCount(path: String): Long = countFilesWithCondition(0, new File(path), (f: File) => Source.fromFile(f).getLines().length)

}