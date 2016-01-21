package com.boothj5

import java.io.File

package object jloc {

  def countFilesWithCondition(acc: Int, file: File, cond: File => Int): Int = {
    if(file.isFile) acc + cond(file)
    else {
      Option(file.listFiles().map(countFilesWithCondition(acc, _, cond))).map(_.sum).getOrElse(0)
    }
  }

}
