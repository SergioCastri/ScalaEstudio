package co.com.pruebasscala

import java.sql.Time

import org.scalatest.FunSuite

import scala.collection.mutable.ArrayBuffer


class testSuite extends FunSuite{


  test ("una funcion debe soportar curry"){
    def multiplicar (m: Int) (n: Int): Int = m * n
    val res = multiplicar(2)(4)
    assert(res == 8)
  }

  test("una funcion debe soportar curry 2"){
    def multiplicar (m: Int) (n: Int): Int = m * n
    val res = multiplicar(2)_
    val res2 = res(8)
    assert(res2 == 16)
  }

  test("Argumentos de longitud variable "){
    def a(args: String *) = {
      args.map {arg =>
        arg.capitalize
      }
    }
    val res: Seq[String] = a("rareza","applejack")
    assert(res == ArrayBuffer("Rareza", "Applejack"))
  }

  test ("herencia"){  //la firma de los metodos se puede ser diferente y para incocarlo el de la clase "padre" se pone super
    class Calculadora(x :Int, y :Int) {
      def sumar(x : Int, y : Int): Int = x + y
    }
    class CalculadoraOperaciones(x : Int, y : Int) extends Calculadora(x,y){
      val z = 5
      override def sumar(x: Int, y: Int): Int = x+y+z
      val calcu = new Calculadora(3,4)
      val res2 = super.sumar(3,4)
      assert(res2 == 7)
    }
    val cal = new CalculadoraOperaciones(5,4)
    val res = cal.sumar(5,4)
    assert(res == 14)
  }

  test("apply - constructor"){
    class Foo{}

    object FooMaker {
        def apply() = 2
    }
    val res = FooMaker()
    assert(res == 2)
  }

  test("  companion"){
    class Bar (foo: String)

    object Bar {
      def apply (foo: String) = new Bar(foo)
    }
  }

  test("Debería no ensuciar la clase que hereda de un rasgo") {  //manera adecuada de implementar una herencia y no sobreescribir metodos dependiendo de la clase hija
    sealed trait Animal
    case class Perro(nombre: String, sonido: String) extends Animal
    case class Gato(nombre: String, sonido: String) extends Animal

    sealed trait GenericComportamiento[T] {
      def emitirSonido(animal: T): T
    }

    object PerroComportamiento extends GenericComportamiento[Perro]{
      override def emitirSonido(animal: Perro) = {
        Perro(animal.nombre, "wow")
      }
    }


    object GatoComportamiento extends GenericComportamiento[Gato]{
      override def emitirSonido(animal: Gato) = {
        Gato(animal.nombre, "mia")
      }
    }
    assert(PerroComportamiento.emitirSonido(Perro("Kaiser", "")) == Perro("Kaiser", "wow"))

  }




}
