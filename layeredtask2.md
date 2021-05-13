
  # Layered Architecture task

  ### Product management system
   
  ### group id: com.cg.apps
   
 ###  artifact id : productms
   
   
   
   Product{
   
   id: int
   
   name: String
   
   price: double
   
   }
   
   IProductDao{
   
   add(product: Product)
   
   update(product): Product
   
   findAll() : List<Product>
   
   findById(id: int) : Product   
   
   }
   
   
   IProductService{
   
   createProduct(name, price) : Product
   
   updatePrice(id, newPrice) : Product
   
   findAll() : List<Product>
   
      findById(id: int) : Product   
      
   }
   
  ## Features Required
  1) Add Product in store
   
  2) Update Price
   
  3)  find product by id
   
  4) find all products 
    
 ### validations on id, name , price
 ### id can't be -ve, name cant be empty or null , price can't be smaller than Zero
   
   
   
   
