
## Follow Layered Architecture

 Customer{
 id: int 
 
 name: string,
 
  age :int
 
 
 }

 ICustomerDao{
 
  add(customer:Customer)
  
  update(customer: Customer)
 
  findById(int id) : Customer 
  
 }


 ICustomerService{
 
 add(name, age)
 
 changeAge(int cid, int age)
 
 findById(int cid); 
 
 }

 ## To Do
 1) Add customer in store
 2) Change customer age
 3) find customer by id
 4) fetch all customers 
 
  validations on id, name ,age
  id can't be -ve, name cant be empty or null , age can't be smaller than 18
  
