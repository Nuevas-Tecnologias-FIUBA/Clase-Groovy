package groovybean

def customer = new Customer()

customer.setName("Name")
customer.setDob(new Date())
customer.setId(0)

println customer.getName()
println customer.name

customer.setMessage("Hola")
println customer.getMessage()
println customer.message