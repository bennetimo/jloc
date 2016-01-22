package com.boothj5

import java.io.File

import scala.annotation.tailrec

package object jloc {

  /**
   * Given a list of files, accumulates a count by calling the countFn for every valid
   * file found, recursively
   * @param files to scan and count
   * @param countFn function to perform appropriate count for each found file
   * @return the total accumulated count
   */
  def countBy(files: List[File], countFn: File => Long): Long = {

    @tailrec
    def impl(acc: Long, files: List[File]): Long = {
      files match {
        case Nil => acc
        case f :: tail => {
          if (f.isFile) impl(acc + countFn(f), tail)
          else if (f.isDirectory) {
            val explodedFiles = f.listFiles().toList ++ tail
            impl(acc, explodedFiles)
          } else {
            //TODO: Add actual logging
            println("Warning: File invalid " + f.getAbsolutePath)
            acc
          }
        }
      }
    }
    
    impl(0, files)
  }

}
