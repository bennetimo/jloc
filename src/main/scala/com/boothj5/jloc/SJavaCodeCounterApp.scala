package com.boothj5.jloc

import java.io.File

import scala.io.Source

class SJavaCodeCounterApp extends App {

  def getJavaFileCount(path: String): Long = countFilesWithCondition(0, new File(path), (f: File) => if(f.getName.takeRight(5) == ".java") 1 else 0)

}