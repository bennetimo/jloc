package com.boothj5.jloc

import java.io.File

class SFileCounterApp extends App {

  def getFileCount(path: String): Int = countFilesWithCondition(0, new File(path), (f: File) => 1)

}
