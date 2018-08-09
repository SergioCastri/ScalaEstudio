package co.com.pruebasscala

import org.scalatest.FunSuite

class CollectionSuite extends  FunSuite{
test("listas"){
  val numbers: Array[Int] = Array(1, 2, 3, 4, 5, 1, 2, 3, 4, 5)
  assert(numbers(3) == 4)
}

  test("una tupla puede terner muchos elempentos, por buben codigo menos de 20"){
    val tupla = ("hola", 23, "que")
    assert(tupla == ("hola", 23, "que"))
  }

  test("Se debe poder acceder al valor de un Option de forma segura con getOrElse") {
    val lista = List(Some("Andres"), None, Some("Luis"), Some("Pedro"))
    val nombre = lista(0)
    val res = nombre.getOrElse("NONAME")
    assert(res == "Andres")
  }  //getOrElse para acceder de forma segura en un option
  test("Se debe poder acceder al valor de un Option de forma segura con getOrElse 2") {
    val lista = List(Some("Andres"), None, Some("Luis"), Some("Pedro"))
    val nombre = lista(1)
    val res = nombre.getOrElse("NONAME")
    assert(res == "NONAME")
  }

  test("funciones parciales"){ //una funcion depende de otra para operar
    val pf: PartialFunction[Int, String] = { //pf(1) tira error
      case i if i%2 == 0 => "par"
    }

    val tf: PartialFunction[Int, String] = pf.orElse { case _ => "odd"}
    assert(tf(1) == "odd")
    assert(tf(2) == "par")

  }


}
