
  # Layered Architecture task

  ### Hotel management system
   
  ### group id: com.cg.apps
   
 ###  artifact id : hotelms
   
   
   
   Hotel{
   
   id: Long
   
   hotelName: String
   
   address : String   
   }
   
   IHotelDao{
   
   add(hotel: Hotel)
   
   update(hotel): Hotel
   
   findAll() : List<Hotel>
   
   findById(id: long) : Hotel 
   
  
  
   
   }
   
   
   IHotelService{
 
   findHotelByName(Strind name): List<Hotel>
    
   findById(id) : Hotel
 
   add(name, address) : Hotel
   
   changeAddress(id, newAddress) : Hotel
   
   findAll() : List<Hotel>
  
   
       
      
   }
   
  ## Features Required
  1) Add hotels in the application 
   
  2) change address
   
  3)  find hotel  by id
   
  4) find all hotels

  5) find all hotels information which have name provided by end user
    
 ### validations on id, name , address
 ### id can't be -ve, name cant be empty or null , address can't be empty or null
   
   
   
   
