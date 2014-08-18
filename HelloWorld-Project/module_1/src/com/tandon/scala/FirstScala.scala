package com.tandon.scala

object FirstScala {

  def main(args: Array[String]) {
    println("testing the first scala class...")
    val foo = new Foo
    foo.x = 1
    foo.y = 3
    println("print foo - %s ".format(foo))
    changeFoo(foo)
    println("again print foo - %s ".format(foo))

  }

  def changeFoo(foo: Foo) {
    foo.x =  2
  }
}


class Foo {
  var x: Int = 0
  var y: Int = 0

  override def toString = "x: (%s); y: (%s)".format(x,y)

}

