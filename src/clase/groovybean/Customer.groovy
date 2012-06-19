package groovybean

class Customer {
    // properties
    Integer id
    String name
    Date dob
	
	String message

    // sample code
    static void main(args) {
        def customer = new Customer(id:1, name:"Gromit", dob:new Date())
        println("Hello ${customer.name}")
    }
	
	def getMessage(){
		message + ",dijo " + name
	}
}
