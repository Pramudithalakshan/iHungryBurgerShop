import java.util.*;
class iHungryBurger{
    //Global arrays
    public static String[] orderId=new String[0];
    public static int[] cusId=new int[0];
    public static String[] cusName=new String[0];
    public static int[] quantity=new int[0];
    public static int[] status=new int[0];
    public static int[] orderQty= new int[0];
    
    public static int[] orIdOfCus=new int[0];
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
			 clearConsole();
			 searchBestCustomer();break;
			 case 3:
			 clearConsole();
			 searchOrder();break;
			 case 4:
			 clearConsole();
			 searchCustomerDetails();break;
			 case 5:
			 clearConsole();
			 viewOrders();break;
			 case 6:
			 clearConsole();
			 updateOrderDetails();break;
			 case 7:
			 exit();break;
			 default:	 
	       }
		}
    ////////////Search index of customer number
    public static int findIndexCusId(int phone){
		 for (int i = 0; i < orIdOfCus.length; i++){
				if(orIdOfCus[i]==phone){
					return i;
					}
			}
			return -1;
		}
    public static void exit(){
        clearConsole();
        System.out.println("\n\t\tYou left the program...\n");
        System.exit(0);
      }
     /////////////Search customer/////////////
    public static void searchCustomerDetails(){
	 Scanner input = new Scanner(System.in);
	 System.out.println("------------------------------------------------------");
 	 System.out.println("|             SEARCH CUSTOMER DETAILS                 |");
 	 System.out.println("------------------------------------------------------");
 	 System.out.println();
 	 System.out.println();
 	 System.out.print("Enter customer Id - ");
 	 String p = input.next();
 	 if(validatePhoneNo(p)){
	  if(cusId.length==0){
		  System.out.println("Empty Records");
			    L2:while(true){
						   int serviceDeci = anotherService5();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       searchCustomerDetails();
					       case 2:    
					       exit();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
			        }
		     }else{
			   int phone = Integer.parseInt(p); 
	           System.out.println("CustomerID - "+"0"+phone);
 	           int phoneNumIndex = findIndexCusId(phone);
               System.out.println("CustomerID - "+cusName[phoneNumIndex]);
               System.out.println();
               System.out.println("Customer Order Details");
               System.out.println("======================");
               System.out.println();
               System.out.println();
               System.out.println("---------------------------------------------");
               System.out.printf("%-12s %-15s %-12s%n", "Order_ID", "Order_Quantity", "Total_Value");
               System.out.println("---------------------------------------------");
               for (int i = 0; i < orIdOfCus.length; i++) {
                System.out.printf("%-12s %-15d %-12.2f%n",orderId[i],orderQty[i],orderQty[i] * UNIT_PRICE);
		       }  
	           System.out.println("---------------------------------------------"); 
	            L2:while(true){
						   int serviceDeci = anotherService5();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       searchCustomerDetails();
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
		System.out.println("Invalid phone number");
		L2:while(true){
						   int serviceDeci = anotherService5();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       searchCustomerDetails();
					       case 2:    
					       exit();
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
				 }   
	  }  
	}
    //////////////Search best customer////////
    public static void searchBestCustomer(){
     System.out.println("------------------------------------------------------");
 	 System.out.println("|                   BEST CUSTOMER                     |");
 	 System.out.println("------------------------------------------------------");
 	 System.out.println();
 	 System.out.println();
 	 if(cusId.length>0){
	 	   for (int i = 0; i < quantity.length - 1; i++) {
            for (int j = 0; j < quantity.length - i - 1; j++) {
                if (quantity[j] < quantity[j + 1]) {
                    int tempQ = quantity[j];
                    quantity[j] = quantity[j + 1];
                    quantity[j + 1] = tempQ;
                  
                    int tempId = cusId[j];
                    cusId[j] = cusId[j + 1];
                    cusId[j + 1] = tempId;

                    String tempName = cusName[j];
                    cusName[j] = cusName[j + 1];
                    cusName[j + 1] = tempName;
                }
            }
        }

        // Print after sorting
        System.out.printf("%-12s %-15s %-10s%n", "CustomerID", "Name", "Total");
        System.out.println("------------------------------------------------------");
        for (int k = 0; k < cusId.length; k++) {
            System.out.printf("%-12s %-15s %-10.2f%n", "0" + cusId[k], cusName[k], quantity[k] * UNIT_PRICE);
            System.out.println("------------------------------------------------------");
        }
		     L2:while(true){
						   int serviceDeci = anotherService4();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       mainMenu();
					       case 2:    
					       exit();
					       break; 
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					   }
		      }else{
			    System.out.println("Empty Records");
			    L2:while(true){
						   int serviceDeci = anotherService4();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       mainMenu();
					       case 2:    
					       exit();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
				 }
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
 	 
 	 if(validatePhoneNo(phone)){                         //validate phone number
		        int phoneNo = Integer.parseInt(phone); 
		        if(isCustomer(phoneNo)){		             //Search, is customer already added
				  int index =searchIndex(phoneNo);      //Get a index of customer
		          System.out.println("Customer Name :"+cusName[index]);
		          System.out.print("Enter Burger Quantity - :");
		          int qty = input.nextInt();
		          double total = qty*UNIT_PRICE;
		          System.out.println("Total value - "+total);
		          int decision = confirmOrder();
		          switch(decision){
					  case 1:   //Confirm order
					  addOrderId(orId);
					  addOrIdAndCusIdRelation(phoneNo);
					  addOrderQty(qty);
					  System.out.println();
					  quantity[index]=quantity[index]+qty;
					  addNewStatus();
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
					  addOrIdAndCusIdRelation(phoneNo);
					  addOrderQty(qty); 
					  addNewCustomerId(phoneNo);  //Add new customer
					  addNewQuantity(qty);
					  addNewCustomerName(name);
					  addNewStatus();
	
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
 
      public static void searchOrder(){
	   Scanner input = new Scanner(System.in); 
	   SO:while(true){
	   System.out.println("------------------------------------------------------");
 	   System.out.println("|                    SEARCH ORDER                    |");
 	   System.out.println("------------------------------------------------------");
 	   System.out.println();
	   System.out.print("Enter order id :");
	   String orderid = input.next();
	  if(isValidateOrId(orderid)){
		   int orIndex = findIndexOfOrId(orderid);
		   int customerId = findOrIdOfCus(orIndex);
	   
		   for (int i = 0; i < cusId.length; i++){
				if(cusId[i]==customerId){
				  System.out.println("--------------------------------------------------------------------------------");
                  System.out.printf("%s %-10s %-12s %-15s %-10s %-12s %-12s %s%n",
                  "|","OrderID", "CustomerId", "Name", "Quantity", "OrderValue", "OrderStatus","|");
                  System.out.println("--------------------------------------------------------------------------------");

                  System.out.printf("%s %-10s %-12s %-15s %-10s %-12s %-12s %s%n",
                  "|",
                  orderid,
                  "0" + cusId[i],
                  cusName[i],
                  orderQty[orIndex],
                  UNIT_PRICE,
                  status[orIndex] == 0 ? "Preparing" : status[orIndex] == 1 ? "Delivered" : "Canceled",
                  "|"
                  );
                  System.out.println("--------------------------------------------------------------------------------");

			    }
			}
			L2:while(true){
						   int serviceDeci = anotherService1();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       continue SO;
					       case 2:    
					       clearConsole();
					       mainMenu();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					   }
		   }else{
			   System.out.println("Invlaid Order Order");
			   continue SO;
		   } 
		   } 
	  }
	  
	   public static void updateOrderDetails(){
	       Scanner input = new Scanner(System.in);
	       UO:while(true){
	       System.out.println("------------------------------------------------------");
 	       System.out.println("|              UPDATE ORDER DETAILS                   |");
 	       System.out.println("------------------------------------------------------");
 	       System.out.println();
 	       System.out.print("Enter order id :");
	       String orderid = input.next();
	       System.out.println();
		     if(isValidateOrId(orderid)){
				 int orIndex = findIndexOfOrId(orderid);
		         int customerId = findOrIdOfCus(orIndex);
		         if(status[orIndex]==0){
					 for (int i = 0; i < cusId.length; i++){
						 if(cusId[i]==customerId){
							   System.out.println("OrderId    -"+orderid);
					           System.out.println("CustomerId -"+"0"+cusId[i]);
					           System.out.println("Name       -"+cusName[i]);
					           System.out.println("Quantity   -"+orderQty[orIndex]);
					           System.out.println("OrderValue -"+orderQty[orIndex]*UNIT_PRICE);
					           System.out.println(status[orIndex]==0?"OrderStatus - Preparing"
					           :status[orIndex]==1?"OrderStatus - Delivered":"OrderStatus - Canceled");
					           System.out.println();
					           System.out.println("What do you want to update?\n");
					           System.out.println("\t(01) Quantity");
					           System.out.println("\t(02) Status");
					           System.out.println();
					           L2:while(true){
					           System.out.print("Enter your option -");
					           int op = input.nextInt();
					           switch(op){
								   case 1:
								   clearConsole();
								   updateQuantity(customerId,orderid,orIndex);
								   return;
								   case 2:
								   clearConsole();
								   updateStatus(customerId,orderid,orIndex);
								   return;
								   default:
								   System.out.println("Invalid input, try again");
								   continue L2;
								   }
								 }
							 }
						 }
					 }else if(status[orIndex]==1){
						 System.out.print("This order is already delivered..You can not update this order...");
						 L2:while(true){
						   int serviceDeci = anotherService2();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       updateOrderDetails();
					       case 2:    
					       clearConsole();
					       mainMenu();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					      }
						 }else{
							 System.out.print("his order is already cancelled..You can not update this order...");
							  L2:while(true){
						       int serviceDeci = anotherService2();
					            switch(serviceDeci){
					            case 1:
					            clearConsole();
					            updateOrderDetails();
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
					  System.out.println("Invlaid Order Id");
			          L2:while(true){
						       int serviceDeci = anotherService2();
					            switch(serviceDeci){
					            case 1:
					            clearConsole();
					            updateOrderDetails();
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
		   }
		  
		  
		 //////////////View Orders////////////////
		 public static void viewOrders(){
			 Scanner input = new Scanner(System.in);
			 System.out.println("------------------------------------------------------");
 	         System.out.println("|                 VIEW ORDER LIST                    |");
 	         System.out.println("------------------------------------------------------");
 	         System.out.println();
 	         System.out.println("\t(01) Delivered Order");
		     System.out.println("\t(02) Preparing Order");
		     System.out.println("\t(02) Cancel Order");
		     System.out.print("Enter your option -");
			  int op = input.nextInt();
			  switch(op){
				  case 1:
				    clearConsole();
				          System.out.println("------------------------------------------------------");
 	                System.out.println("|                 DELIVERED ORDER                    |");
 	                System.out.println("------------------------------------------------------");
 	                System.out.println();
 	                for (int i = 0; i < orderId.length; i++){
 	                if(status[i]==1){			
 	                 System.out.println("-------------------------------------------------------------------");
                     System.out.printf("%s %-10s %-12s %-15s %-10s %-12s %s%n",
                     "|","OrderID", "CustomerId", "Name", "Quantity", "OrderValue","|");
                     System.out.println("-------------------------------------------------------------------");

                     System.out.printf("%s %-10s %-12s %-15s %-10s %-12s %s%n",
                     "|",
                     orderId[i],
                     "0" + cusId[i],
                     cusName[i],
                     orderQty[i],
                     orderQty[i]*UNIT_PRICE,
                     "|"
                     );
                     System.out.println("-------------------------------------------------------------------");
                    }
                   }
                   L2:while(true){
						   int serviceDeci = anotherService3();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       mainMenu();
					       return;
					       case 2:    
					       exit();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					   }
				  case 2:
				     clearConsole();
				          System.out.println("------------------------------------------------------");
 	                System.out.println("|                PREPARING ORDER                     |");
 	                System.out.println("------------------------------------------------------");
 	                System.out.println();
 	                  for (int i = 0; i < orderId.length; i++){
 	                if(status[i]==0){			
 	                 System.out.println("-------------------------------------------------------------------");
                     System.out.printf("%s %-10s %-12s %-15s %-10s %-12s %s%n",
                     "|","OrderID", "CustomerId", "Name", "Quantity", "OrderValue","|");
                     System.out.println("-------------------------------------------------------------------");

                     System.out.printf("%s %-10s %-12s %-15s %-10s %-12s %s%n",
                     "|",
                     orderId[i],
                     "0" + cusId[i],
                     cusName[i],
                     orderQty[i],
                     orderQty[i]*UNIT_PRICE,
                     "|"
                     );
                     System.out.println("-------------------------------------------------------------------");
                    }
                   }
                   L2:while(true){
						   int serviceDeci = anotherService3();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       mainMenu();
					       return;
					       case 2:    
					       exit();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					   }
				  case 3:
				     clearConsole();
			      	    System.out.println("------------------------------------------------------");
 	                System.out.println("|                     CANCEL ORDER                    |");
 	                System.out.println("------------------------------------------------------");
 	                System.out.println();
 	                  for (int i = 0; i < orderId.length; i++){
 	                if(status[i]==2){			
 	                 System.out.println("-------------------------------------------------------------------");
                     System.out.printf("%s %-10s %-12s %-15s %-10s %-12s %s%n",
                     "|","OrderID", "CustomerId", "Name", "Quantity", "OrderValue","|");
                     System.out.println("-------------------------------------------------------------------");

                     System.out.printf("%s %-10s %-12s %-15s %-10s %-12s %s%n",
                     "|",
                     orderId[i],
                     "0" + cusId[i],
                     cusName[i],
                     orderQty[i],
                     orderQty[i]*UNIT_PRICE,
                     "|"
                     );
                     System.out.println("-------------------------------------------------------------------");
                    }
                   }
                   L2:while(true){
						   int serviceDeci = anotherService3();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       mainMenu();
					       return;
					       case 2:    
					       exit();
					       return;
					       case 3:
					       System.out.println("Invalid input enter valid input");
					       continue L2;
					       }
					   }
				  default:
				  }
			 }
		   
	    //////////////Update status////////////////
        public static void updateStatus(int customerId,String orderId,int orIndex){
			Scanner input = new Scanner(System.in);
			System.out.println("Status Update");
		    System.out.println("===============");
		    System.out.println();
			System.out.println("OrderId -"+orderId);
			for (int i = 0; i < cusId.length; i++){
				 if(cusId[i]==customerId){
				   System.out.println("CustomerId -"+"0"+cusId[i]);
		           System.out.println("Name -"+cusName[i]);
				}
		    
			}
			System.out.println();
			System.out.println("\t(0)Cancel");
			System.out.println("\t(1)Preparing");
			System.out.println("\t(2)Delivered\n");
			System.out.print("Enter new order status - ");
			int value = input.nextInt();
			if(value==0){
				status[orIndex]=2;
				quantity[orIndex]=quantity[orIndex]-orderQty[orIndex];  //remove quantity if order cancelled
				}else if(value==1){
					status[orIndex]=0;
					}else{
						status[orIndex]=1;
						}
			System.out.println();
			System.out.println("\tUpdate order quantity success fully...\n");
			System.out.println(status[orIndex]==0?"OrderStatus - Preparing"
	        :status[orIndex]==1?"OrderStatus - Delivered":"OrderStatus - Canceled");
			System.out.println();
			L2:while(true){
						   int serviceDeci = anotherService2();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       updateOrderDetails();
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
			
		    
		 
	   //////////////Update quantity////////////////
        public static void updateQuantity(int customerId,String orderId,int orIndex){
			Scanner input = new Scanner(System.in);
			System.out.println("Quantity Update");
		    System.out.println("===============");
		    System.out.println();
			System.out.println("OrderId -"+orderId);
			for (int i = 0; i < cusId.length; i++){
				 if(cusId[i]==customerId){
				   System.out.println("CustomerId -"+"0"+cusId[i]);
		           System.out.println("Name -"+cusName[i]);
				}
		    
			}
			System.out.println();
			System.out.print("Enter your quantity update value - ");
			int value = input.nextInt();
			orderQty[orIndex]=value;
			System.out.println("\tUpdate order quantity success fully...");
			System.out.println("New order quantity - "+orderQty[orIndex]);
			System.out.println("New order value - "+orderQty[orIndex]*UNIT_PRICE);
			System.out.println();
			L2:while(true){
						   int serviceDeci = anotherService2();
					       switch(serviceDeci){
					       case 1:
					       clearConsole();
					       updateOrderDetails();
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
	   //////////////Find cusid of order////////////////
        public static int findOrIdOfCus(int id){
			for (int i = 0; i < orIdOfCus.length; i++){
				if(i==id){
					return orIdOfCus[i];
					}
			}
			return -1;
			} 
	  //////////////Find index of order id////////////////
        public static int findIndexOfOrId(String id){
			for (int i = 0; i < orderId.length; i++){
				if(orderId[i].equals(id)){
					return i;
					}
			}
			return -1;
			}
        //////////////validate order id////////////////
        public static boolean isValidateOrId(String id){
			for (int i = 0; i < orderId.length; i++){
				if(orderId[i].equals(id)){
					return true;
					}
			}
			return false;
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
	   //////////////Another Service1////////////////
      public static int anotherService1(){
		Scanner input = new Scanner(System.in);
		System.out.print("Do you want to search another order details (Y/N) - ");
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
	  //////////////Another Service2////////////////
    public static int anotherService2(){
		  Scanner input = new Scanner(System.in);
		  System.out.print("Do you want to update another order details (Y/N) - ");
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
	 //////////////Another Service3////////////////
      public static int anotherService3(){
		Scanner input = new Scanner(System.in);
		System.out.print("Do you want to go to home page (Y/N) - ");
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
	 //////////////Another Service4////////////////
      public static int anotherService4(){
		Scanner input = new Scanner(System.in);
		System.out.print("\tDo you want to go to main menu (Y/N) - ");
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
		//////////////Another Service5////////////////
      public static int anotherService5(){
		Scanner input = new Scanner(System.in);
		System.out.print("\tDo you want to add another customer details (Y/N) - ");
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
	  ///////////////Add qty////////////////
     public static void addOrIdAndCusIdRelation(int phoneNo){
		  int[] tempArray = new int[orIdOfCus.length+1];
		  for (int i = 0; i < orIdOfCus.length; i++){
			  tempArray[i]=orIdOfCus[i];
		  }
		  tempArray[tempArray.length-1]=phoneNo;
		   orIdOfCus=tempArray;
		 }
	  ///////////////Add status////////////////
     public static void addNewStatus(){
		  int[] tempArray = new int[status.length+1];
		  for (int i = 0; i < status.length; i++){
			  tempArray[i]=status[i];
		  }
		  tempArray[tempArray.length-1]=PREPARING;
		  status=tempArray;
		 }
	   ///////////////Add new orderqty/////////////////
     public static void addOrderQty(int qty){
		  int[] tempArray = new int[orderQty.length+1];
		  for (int i = 0; i < orderQty.length; i++){
			  tempArray[i]=orderQty[i];
		  }
		  tempArray[tempArray.length-1]=qty;
		  orderQty=tempArray;
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
