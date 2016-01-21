package com.boothj5.jloc

import java.io.File

class SFileCounterApp extends App {

  def getFileCount(path: String): Int = {

    def getFileCountAcc(acc: Int, file: File): Int = {
      if(file.isFile) acc + 1
      else {
        Option(file.listFiles().map(getFileCountAcc(acc, _))).map(_.sum).getOrElse(0)
      }
    }

    getFileCountAcc(0, new File(path))
  }

}
