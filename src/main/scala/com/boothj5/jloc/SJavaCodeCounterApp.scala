package com.boothj5.jloc

import java.io.File

import scala.io.Source

class SJavaCodeCounterApp extends App {

  def getJavaFileCount(path: String): Long = {

    def getJavaFileCount(acc: Long, file: File): Long = {
      if(file.isFile) acc + (if (file.getName.takeRight(5) == ".java") 1 else 0)
      else {
        Option(file.listFiles().map(getJavaFileCount(acc, _))).map(_.sum).getOrElse(0)
      }
    }

    getJavaFileCount(0, new File(path))
  }

}