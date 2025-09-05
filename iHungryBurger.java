import java.util.*;
class iHungryBurger{
    //Global arrays
    public static String[] orderId=new String[0];
    public static int[] cusId=new int[0];
    public static String[] cusName=new String[0];
    public static int[] quantity=new int[0];
    //CONSTANT
    public final static double UNIT_PRICE=500;
    public final static int PREPARING=0;
    public final static int DELIVERED=1;
    public final static int CANCEL=2;
    
	public static void main(String args[]){
		 mainMenu(); 
	}
	public static void mainMenu(){
		 Scanner input = new Scanner(System.in);
 	 System.out.println("------------------------------------------------------");
 	 System.out.println("|                 iHungry Burger                     |");
 	 System.out.println("------------------------------------------------------");
 	 System.out.println();
     System.out.println("[1] Place Order \t\t[2] Search Best Customer");
     System.out.println("[3] Search Order \t\t[4] Search Customer");
     System.out.println("[5] View Orders \t\t[6] Update Order Details");
     System.out.println("[7] Exit");
     System.out.println();
     System.out.print("Enter an option to continue >");
     int op = input.nextInt();
		 switch(op){
			 case 1:
			 clearConsole();
			 placeOrder();break;
			 case 2:
			 //searchBestCustomer();break;
			 case 3:
			 //searchOrder();break;
			 case 4:
			 //searchCustomer();break;
			 case 5:
			 //viewOrders();break;
			 case 6:
			 //exit();break;
			 default:	 
	       }
		}
		
	//////////////Place Order////////////////
	public static void placeOrder(){
	
     Scanner input = new Scanner(System.in); 
     PO:while(true){
     System.out.println("------------------------------------------------------");
 	 System.out.println("|                    PLACE ORDER                     |");
 	 System.out.println("------------------------------------------------------");
 	 String orId = generateOrderId();
 	 System.out.println();
 	 System.out.println();
 	 System.out.println("ORDER ID - "+orId);
 	 System.out.println("=================");
 	 System.out.println();
 	 System.out.println();
 	 System.out.println();
 	 L1:while(true){
 	 System.out.print("Enter Customer ID (phone no.): ");
 	 String phone = input.next();
 	 
 	 if(validatePhoneNo(phone)){                   //validate phone number
		        int phoneNo = Integer.parseInt(phone);
		     
		        if(isCustomer(phoneNo)){
				             //Search, is customer already added
				  int index =searchIndex(phoneNo);  //Get a index of customer
		          System.out.println("Customer Name :"+cusName[index]);
		          System.out.print("Enter Burger Quantity - :");
		          int qty = input.nextInt();
		          double total = qty*UNIT_PRICE;
		          System.out.println("Total value - "+total);
		          int decision = confirmOrder();
		          switch(decision){
					  case 1:   //Confirm order
					  addOrderId(orId);
					  System.out.println();
					  quantity[index]=quantity[index]+qty;
					  System.out.println("Your order is entered to the system successfully");
					   L2:while(true){
						   int serviceDeci = anotherService();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       continue PO;
					       case 2: 
					       //check data of the arrays
					        System.out.println(cusName[0]);
					        System.out.println(cusId[0]);
					        System.out.println(quantity[0]);
					        System.out.println(Arrays.toString(orderId));
					         System.out.println(Arrays.toString(cusName));                    
					       //clearConsole();
					       mainMenu();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					   }
					  case 2:  //unconfirm order
					  L2:while(true){
						   int serviceDeci = anotherService();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       continue PO;
					       case 2:
					       clearConsole();
					       mainMenu();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					   }
				    }
		          }else{
					  
					  System.out.print("Customer Name :");
					  String name=input.next();   //Name of the new customer
		              System.out.print("Enter Burger Quantity - :");
		              int qty = input.nextInt();
		              double total = qty*UNIT_PRICE;
		              System.out.println("Total value - "+total);  //Total
		              
 		              int decision = confirmOrder();
		              switch(decision){
					  case 1:
					  addOrderId(orId);
					  addNewCustomerId(phoneNo);  //Add new customer
					  addNewQuantity(qty);
					  addNewCustomerName(name);
					  System.out.println();
					  
					  System.out.println("Your order is entered to the system successfully");
					   L2:while(true){
						   int serviceDeci = anotherService();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       continue PO;
					       case 2:    
					       clearConsole();
					       mainMenu();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					   }
					  case 2:
					  L2:while(true){
						   int serviceDeci = anotherService();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       continue PO;
					       case 2:
					       clearConsole();
					       mainMenu();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					   }
				  }
		    }
				
		 
		 }else{
		     System.out.println("Invalid phone number");
		     continue L1;	 
			 }
 	     }
	 }
 }   
        
       //////////////Search Index Number////////////////	
       public static int searchIndex(int phoneNo){
		 for (int i = 0; i <cusId.length; i++){
			 if(cusId[i]==phoneNo){
				 return i;
				 }
		 }
		 return -1;
		}
      //////////////Search Customer////////////////
      public static boolean isCustomer(int phoneNo){
		for (int i = 0; i <cusId.length; i++){
			if(cusId[i]==phoneNo){
			 return true;
			 }		
		  }
		   return false;
	   }
      //////////////Another Service////////////////
      public static int anotherService(){
		Scanner input = new Scanner(System.in);
		System.out.print("Do you want to place another order (Y/N) - ");
		String decision = input.next().toUpperCase();
		switch(decision){
			case "Y":
			return 1;
			case "N":
			return 2;
			default :
			return 3;
			}
		} 
     ///////////////Add order id/////////////////
     public static void addOrderId(String id){
		  String[] tempArray = new String[orderId.length+1];
		  for (int i = 0; i < orderId.length; i++){
			  tempArray[i]=orderId[i];
		  }
		  tempArray[tempArray.length-1]=id;
		  orderId=tempArray;
		 }
	  ///////////////Add new customerid/////////////////
     public static void addNewCustomerId(int id){
		  int[] tempArray = new int[cusId.length+1];
		  for (int i = 0; i < cusId.length; i++){
			  tempArray[i]=cusId[i];
		  }
		  tempArray[tempArray.length-1]=id;
		  cusId=tempArray;
		 }
	  ///////////////Add new customer name/////////////////
     public static void addNewCustomerName(String name){
		  String[] tempArray = new String[cusName.length+1];
		  for (int i = 0; i < cusName.length; i++){
			  tempArray[i]=cusName[i];
		  }
		  tempArray[tempArray.length-1]=name;
		  cusName=tempArray;
		 }
	 ///////////////Add qty////////////////
     public static void addNewQuantity(int qty){
		  int[] tempArray = new int[quantity.length+1];
		  for (int i = 0; i < quantity.length; i++){
			  tempArray[i]=quantity[i];
		  }
		  tempArray[tempArray.length-1]=qty;
		  quantity=tempArray;
		 }
     //////////////Confirm order/////////////////
     public static int confirmOrder(){
		Scanner input = new Scanner(System.in);
		System.out.print("\tAre you confirm order - ");
		String decision = input.next().toUpperCase();
		switch(decision){
			case "Y":
			return 1;
			case "N":
			return 2;
			default :
			return 3;
			}
		}
	//////////////Generate order id////////////////		
	public static String generateOrderId(){
		if(orderId.length==0){
			return "B0001";
		}
		String ls=orderId[orderId.length-1].substring(1);
		return String.format("B%04d",Integer.parseInt(ls)+1);
	}
	
	//////////////Validate Phone Number////////////////	
    public static boolean validatePhoneNo(String phoneNo){
		 int ch = phoneNo.charAt(0); 	 
		 return ch!=48||phoneNo.length()!=10?false:true;
		}
	
	//////////////Clear Console////////////////
	public final static void clearConsole() {
     try {
      final String os =
       System.getProperty("os.name"); 
      if(os.contains("Windows")) {
      new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
      } else {
       System.out.print("\033[H\033[2J");
       System.out.flush();
      }
     } catch (final Exception e) {
       e.printStackTrace();
       // Handle any exceptions.
     }
   }
}
