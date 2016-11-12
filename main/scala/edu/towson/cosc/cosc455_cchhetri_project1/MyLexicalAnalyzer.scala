package edu.towson.cosc.cosc455_cchhetri_project1

/**
  * Created by camychhetri on 10/11/16.
  */
class MyLexicalAnalyzer extends LexicalAnalyzer {

  val lexems: List[String] = List("\\BEGIN","\\END", "\\TITLE[", "]", "#", "\\PARAB", "PARAE", "**", "*", "+", "\\\\", "[", "(", ")", "![", "\\DEF[", "=", "\\USE[")
  var index = 0
  var pos = 0
  var nextChar = ' '
  var entireFileText = " "
  var tempChar = ' '
  var textList = List()
  var possibleToken = " "
  var nextToken = " "



  def start(fileContents:String): Unit = {
    entireFileText = fileContents

  }




  override def addChar(nextChar:Char): String = {
     var str = " "
    if(!nextChar.equals("\n")) {
      possibleToken += nextChar
      str = possibleToken.toString()
    }
    else {
      getChar()
    }
    return str
  }


  override def getChar(): Char = {
    while(!entireFileText.isEmpty()) {

      tempChar = entireFileText.charAt(pos)


      nextChar = tempChar

      //addChar(nextChar)

      // trim the char
      //entireFileText.charAt(pos).toString.trim()

      pos = pos + 1
    }

return nextChar


    }


  override def getNextToken(): Unit = {

// it calls everything

    nextChar = getChar()
   //nextToken = addChar(nextChar)
    if(lookup(nextToken)){
      Compiler.currentToken = nextToken
    }

  }

  override def lookup(nextToken : String): Boolean = {

    /// checks if the lexemes is legal..

    var flag = false
    for (x <- lexems) {


      if (nextToken.equals(x)) {
        flag = true
      }
      }
    if(flag == false){
      print("Lexical Error, illegal token")
      System.exit(1)

    }
return flag
  }

}