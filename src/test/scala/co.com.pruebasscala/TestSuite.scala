package co.com.pruebasscala

import org.scalatest.FunSuite

class TestSuite extends  FunSuite{

  test("reduce"){
    val lista = List("s","s" ,"e","d")
    val res: String = lista.reduce((x, y) => x + y)
    assert(res == "ssed")
  }

}
