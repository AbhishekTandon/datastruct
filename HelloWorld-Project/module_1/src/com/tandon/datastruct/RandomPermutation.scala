package com.tandon.datastruct


object RandomNumber {

  def getRandonInt(max: Int, min: Int): Long = {
    min + (Math.random * (max - min)).round
  }

  def main(args: Array[String]) {
    1 to 50 foreach{x=> println("num > %s".format(getRandonInt(50, 1)))}
  }



}

