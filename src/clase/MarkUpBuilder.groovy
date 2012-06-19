import groovy.xml.MarkupBuilder

def myXMLDoc = new MarkupBuilder()
myXMLDoc.workbook {
	worksheet(caption:"Employees") {
		row(fname:"John", lname:"McDoe")
		row(fname:"Nancy", lname:"Davolio")
	}
	worksheet(caption:"Products") {
		row(name:"Veeblefeetzer", id:"sku34510")
		row(name:"Prune Unit Zappa", id:"sku3a550")
	}
}
println myXMLDoc

/*
<workbook>
  <worksheet caption='Employees'>
    <row fname='John' lname='McDoe' />
    <row fname='Nancy' lname='Davolio' />
  </worksheet>
  <worksheet caption='Products'>
    <row name='Veeblefeetzer' id='sku34510' />
    <row name='Prune Unit Zappa' id='sku3a550' />
  </worksheet>
</workbook>
 */

