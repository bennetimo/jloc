package com.boothj5.jloc

import java.io.File

import scala.io.Source

class SLineCounterApp extends App {

  def getLineCount(path: String): Long = {

    def getLineCountAcc(acc: Long, file: File): Long = {
      if(file.isFile) acc + Source.fromFile(file).getLines().length
      else {
        Option(file.listFiles().map(getLineCountAcc(acc, _))).map(_.sum).getOrElse(0)
      }
    }

    getLineCountAcc(0, new File(path))
  }

}