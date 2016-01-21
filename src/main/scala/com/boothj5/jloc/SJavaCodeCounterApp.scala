package com.boothj5.jloc

import java.io.File

import scala.io.Source

class SJavaCodeCounterApp extends App {

  def getFileCount(path: String): Long = countFilesWithCondition(0, new File(path), (f: File) => if(f.getName.takeRight(5) == ".java") 1 else 0)

  def getBlankLinesCount(path: String): Long = countFilesWithCondition(0, new File(path), (f: File) => {
    if(f.getName.takeRight(5) == ".java") Source.fromFile(f).getLines().filter(_.isEmpty).length else 0
  })

}