
  # Layered Architecture task

  ### Product management system
   
  ### group id: com.cg.apps
   
 ###  artifact id : productms
   
   
   
   Product{
   
   id: int
   
   name: String
   
   price: double
   
   }
   
       
   
   IProductService{
   
   findById(id) : Product
   
   createProduct(name, price) : Product
   
   updatePrice(id, newPrice) : Product
   
   findAll() : List<Product>
   
   findByPrice(price:double):List<Product> // products with price provided in argument
   
   
      
   }
   
  ## Features Required
  1) Add Product in store
   
  2) Update Price
   
  3)  find product by id
   
  4) find all products 

  5) Find products by price
    
 ### validations on id, name , price
 ### id can't be -ve, name cant be empty or null , price can't be smaller than Zero
   
   
   
   
