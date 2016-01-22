package com.boothj5.jloc

import java.io.File

import scala.io.Source

class SJavaCodeCounterApp  {

  // Regex's to match Java comment patterns
  val multiLineComments = """/\*(.|[\r\n])*?\*/[\r\n]""".r
  val inlineComments = """[ \t]+?//.*?[\r\n]""".r

  /**
   * Retrieves the number of .java files (recursive) in a directory
   * @param path absolute path
   * @return the number of java files found
   */
  def getFileCount(path: String): Long = countBy(List(new File(path)), (f: File) => if(f.isJava) 1 else 0)

  /**
   * Retrieves the number of blank lines across all .java files (recursive) in a directory
   * @param path absolute path
   * @return the number of blank lines found
   */
  def getBlankLinesCount(path: String): Long = countBy(List(new File(path)), (f: File) => {
    if(f.isJava) Source.fromFile(f).getLines().filter(_.isEmpty).length else 0
  })

  /**
   * Retrieves the number of comment lines across all .java files (recursive) in a directory
   * @param path absolute path
   * @return the number of comment lines found
   */
  def getCommentLinesCount(path: String): Long = {
    countBy(List(new File(path)), (f: File) => {
      if(f.isJava) {
        val data = Source.fromFile(f).mkString
        val rawLineCount = data.countLines

        rawLineCount - stripComments(data).countLines
      } else 0
    })
  }

  /**
   * Retrieves the number of code lines across all .java files (recursive) in a directory
   * @param path absolute path
   * @return the number of code lines found
   */
  def getCodeLinesCount(path: String): Long = {
    countBy(List(new File(path)), (f: File) => {
      if(f.isJava) {
        val data = Source.fromFile(f).getLines().filterNot(_.isEmpty).mkString("\n")
        stripComments(data).countLines
      } else 0
    })
  }

  private[this] def stripComments(line: String) = {
    val noMultiline = multiLineComments.replaceAllIn(line, "")
    val noInline = inlineComments.replaceAllIn(noMultiline, "")
    noInline
  }

  implicit class PimpedString(s: String) {
    def countLines = s.count(_.equals('\n'))
  }

  implicit class PimpedFile(f: File) {
    def isJava = f.getName.takeRight(5) == ".java"
  }

}