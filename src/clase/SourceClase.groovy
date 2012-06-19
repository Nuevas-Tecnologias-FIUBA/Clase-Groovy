// Variables
// Tipado estatico
String texto
int contador

// Tipado dinamico
def variable = "Texto"
variable = new Customer()
def method(def param){}

// Auxiliar
class Customer{}


/*********************************************************/
// Colecciones – Listas
def lista = ['casa', 21, 1.69]	//lista con cosas diferentes
def numbers = [11, 12, 13, 14] 	// lista de cuatro elementos
numbers [0]		// 11
numbers [-1] 	// 14
numbers [0..2] 	// [11, 12, 13]
numbers.get(2)	//13
def emptyList = [] 	//emptyList.size() == 0
emptyList.add(5) 	//emptyList.size() == 1


/*********************************************************/
// Colecciones - Maps
def map = [name:"Gromit", likes:"cheese", id:1234]
map.get("name")		// "Gromit"
map["name"]		// "Gromit"
map.name			// "Gromit“
def emptyMap = [:]	// emptyMap.size() == 0
emptyMap.put("foo", 5) 	// emptyMap.size() == 1
emptyMap.other = [23,52] // emptyMap.size() == 2


/*********************************************************/
// Colecciones - Rangos
1900..1999		// siglo XX (rango inclusivo)
2000..<2100		// siglo XXI(rango exclusivo)
'A'..'D'	 	//  A, B, C, y D
10..1			//  10, 9, ..., 1
'Z'..'X'		 //  Z, Y, y X
def range = 1..10
assert range.from == 1
assert range.to == 10


/*********************************************************/
// Strings y GStrings
def age = 25
'My age is ${age}'     // My age is ${age}
"My age is ${age}"     // My age is 25
"""My age
	is ${age}"""		/* My age
							is 25*/

							
/*********************************************************/
// Expresiones Regulares					
//Creación de una expresión regular
def cheese = ~/cheese/

def nicecheese =("cheesecheese" =~ /cheese/).replaceFirst("nice")
// nicecheese

if("cheese" ==~ /cheese/){
	//entra
}else{
	//no entra
}


/*********************************************************/
// Condicionales - if, else if, else
def score = 10
if(score >= 70)
	grade = 'A'
else if(score >= 60)
	grade = 'B'
else if(score >= 50)
	grade = 'C'
else if(score >= 40)
	grade = 'D'
else
	grade = 'E'

// Condicionales - if, else if, else
def n = 2
switch(n) {
case 1:
	println 'One'
case [2, 3, 4, 5]:
	println 'Between Two and Five'
	break
case 6..10:
	println 'Between 6 and 10'
	break
default:
	println 'Default'
	break
}
println 'End of switch'


/*********************************************************/
// Ciclos - While
def LIMIT = 10
def count = 1
println 'Start'
while(count <= LIMIT) {
	println "count: ${count}"
	count++
}
println 'Done'

// Ciclos - for con rango
def LIMITFOR = 10
println 'Start'
for(countFor in 1..LIMITFOR)
	println "count: ${countFor}"
println 'Done'

// Ciclos - for sobre coleccion
staff = ['Ken' : 21, 'John' : 25, 'Sally' : 22]
def totalAge = 0
for(staffEntry in staff)
	totalAge += staffEntry.value
println "Total staff age: ${totalAge}"



/*********************************************************/
// Métodos
def greetings(def salutation, def name = 'Ken') {
	println "${salutation} ${name}"
	return "ok"
}

greetings('Hello', 'John')		// Hello John
println greetings('Welcome') 	/* Welcome Ken
								   ok*/
String estatica(String name){
	"hello" + name		// Hello ${name}
}

/*********************************************************/
// Closures (1)
def clos = { p -> println "Hello ${p}" }    //con parámetros
def clos2 = { println "Hello ${it}" }	    //parámetro actual


clos.call('world') 	// el argumento actual es 'world'
clos('shortcut')	// forma abreviada



/*********************************************************/
// Closures (2)
def greeting = 'Hello'
def closLikeLambda = {param -> println "${greeting} ${param}"}
closLikeLambda.call('world') 		//Hello world

greeting = 'Welcome'
closLikeLambda.call('world') 		// Welcome world



/*********************************************************/
// Ciclos con closures (1)
def stringList = ["string1", "string2"]
def stringMap = [key1:"value1", key2:"value2", key3:"value3" ]

// Each
stringList.each() { print " ${it}" }; println "";
stringMap.each() { key, value -> println "${key} => ${value}" };

// EachWithIndex
stringList.eachWithIndex() { obj, i -> println " ${i}: ${obj}" };

// Times
def len = 10
len.times { println it;}



/*********************************************************/
// Ciclos con closures (2)
// Collect

def words = ['ant', 'buffalo', 'cat', 'dinosaur'] 

assert words.collect{ it[0] } == ['a', 'b', 'c', 'd']

// FindAll

assert words.findAll{ w -> w.size() > 4 } == ['buffalo', 'dinosaur']



/*********************************************************/
// Operadores
// Aux
class Operadores{
	def operation(){ "Not null"}
}
def objeto = new Operadores()

// apply all

assert [1, 3, 5] == ['a', 'few', 'words']*.size()

// Elvis operator
assert objeto?.operation() == "Not null"
assert (objeto != null) ? objeto.operation() : null == "Not null"

objeto = null
assert objeto?.operation() == null
assert (objeto != null) ? objeto.operation() : null == null



/*********************************************************/
// Orientación a Objetos(1)
class Cuenta {
	def numero	// numero de cuenta
	def balance 	// balance actual
	
	def Cuenta(monto,numero) {
		balance = monto
		this.numero = numero
	}
	def debitar(monto) {	// Solo si hay suficiente monto
		if(balance >= monto)  balance -= monto
	}
}
def cuenta = new Cuenta(30, 'ABC255')



/*********************************************************/
// Orientación a Objetos(2)
// Herencia
class ClasePadre{}

class ClaseDerivada extends ClasePadre{
	//código nuevo y reimplementado
}

// Clases y métodos abstractos
abstract class A{
	def a() { println 1 }
	abstract b()
}

// Implementación de clases y métodos abstractos
class B extends A{
	def b(){ println 4 }
}



/*********************************************************/
// Orientación a Objetos(3) - Interfaces
interface Y{
	def y()
}

class C implements Y{
	static x(){ println 2 }
	def y(){ println 3 }
}



/*********************************************************/
// GroovyBeans (1)
class Person {
	// properties
	Integer id
	String name
	Date dob
}
def person = new Person(id:1, name:"Gromit", dob:new Date())
println("Hello ${person.name}")



/*********************************************************/
// Expando
def player = new Expando()
player.name = "Dierk"
player.greeting = { "Hello, my name is $name" }

println player.greeting()

player.name = "Jochen"
println player.greeting()



/*********************************************************/
// Implementando Interfaces con Map
impl = [
	i: 10,
	hasNext: { impl.i > 0 },
	next: { impl.i-- },
]
iter = impl as Iterator
while ( iter.hasNext() )
	println iter.next()
	
	
	
/*********************************************************/
// Excepciones
	
def z
try{
	def i= 7, j= 0
	try {
		def k= i / j
		assert false 	//nunca llega
	} finally {
			z= 'llego acá'	//se ejecuta siempre
		}
} catch(e) {
	assert e in ArithmeticException
	assert z == 'llego acá'
}

class MyException extends Exception{ }



/*********************************************************/
// Concurrencia
new Thread(
	{println "running"} as Runnable
	).start()
	
class Hilo extends Thread{
	def Run() { println "running"}
}

def unHilo = new Hilo()
unHilo.start()



/*********************************************************/
// Soporte para Lenguajes de Marcado
def builder = new groovy.xml.MarkupBuilder()

builder.stocks {
	stock(symbol: 'JAVA')
	stock(symbol: 'MSFT')
	stock(symbol: 'IBM' )
}

/*==== result output =====>
<stocks>
  <stock symbol='JAVA' />
  <stock symbol='MSFT' />
  <stock symbol='IBM' />
</stocks>
*/



/*********************************************************/
// Ejemplos
/* En java:
String[] list = new String[] {"Rod", "Carlos", "Chris"};
for (String item : list) {
	if (item.length() <= 4) System.out.println(item);
}
*/

// En groovy:
["Rod", "Carlos", "Chris"].findAll{it.size() <= 4}.each{println it}



/*********************************************************/
// Programación de GUI

count = 0
new groovy.swing.SwingBuilder().edt {
  frame(title:'Frame', size:[300,300], show: true) {
    borderLayout()
    textlabel = label(text:"Click the button!", 
		constraints: java.awt.BorderLayout.NORTH)
    button(text:'Click Me',
         actionPerformed: {
			 count++
			 textlabel.text = "Clicked ${count} time(s)."
			 println "clicked"},
         constraints:java.awt.BorderLayout.SOUTH)
  }
}
