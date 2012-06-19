class Pato {
	def cuak(){
		println "cuak"
	}
}

class Persona {
	def cuak(){
		println "Soy una persona que intenta imitar un pato"
	}
}

def method(def pato){
	pato.cuak()
}

method(new Pato())
method(new Persona())
