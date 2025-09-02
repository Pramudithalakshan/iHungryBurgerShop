import java.util.*;
class Example{
	public static int[] cusId=new int[100];
    public static String[] cusName=new String[100]; 
    public static String[] OrderIds=new String[100]; 
    public static int[] tempOrIds={0};
    public static int count=0;
	public static void main(String args[]){
    mainMenu();     
}
//////////////Main Menu////////////////
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
 	 String orId = generateOrderID();
 	 System.out.println();
 	 
 	 System.out.println("ORDER ID - "+orId);
 	 System.out.println("=================");
 	 L1:while(true){
 	 System.out.print("Enter Customer ID (phone no.): ");
 	 String phoneNo = input.next();
 	 if(validatePhoneNo(phoneNo)){
		          if(isCustomer(count,phoneNo)){
				  int index =searchIndex(phoneNo);
		          System.out.print("Customer Name :"+cusName[index]);
		          System.out.print("Enter Burger Quantity - :");
		          int qty = input.nextInt();
		          System.out.println("Total value - "+(qty*500));
		          int decision = confirmOrder();
		          switch(decision){
					  case 1:
					  OrderIds[count]=orId;
					  count++;
					  System.out.println("Your order is entered to the system successfully");
					   L2:while(true){
						   int serviceDeci = anotherService();
					       switch(serviceDeci){
					       case 1:
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
					  System.out.println("Not founded");
					  cusId[count]=Integer.parseInt(phoneNo);
					  System.out.print("Customer Name :");
					  cusName[count]=input.next();
		              System.out.print("Enter Burger Quantity - :");
		              int qty = input.nextInt();
		              System.out.println("Total value - "+(qty*500));
		              
 		              int decision = confirmOrder();
		              switch(decision){
					  case 1:
					  OrderIds[count]=orId;
					  count++;
					  System.out.println("Your order is entered to the system successfully");
					   L2:while(true){
						   int serviceDeci = anotherService();
					       switch(serviceDeci){
					       case 1:
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
//////////////Confirm order////////////////
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
//////////////Search Index Number////////////////	
    public static int searchIndex(String phoneNo){
	    	int ph=Integer.parseInt(phoneNo);
		 for (int i = 0; i <cusId.length ; i++){
			 if(cusId[i]==ph){
				 return i;
				 }
		 }
		 return -1;
		}
//////////////Validate Phone Number////////////////	
    public static boolean validatePhoneNo(String phoneNo){
		 int ch = phoneNo.charAt(0); 	 
		 return ch!=48||phoneNo.length()!=10?false:true;
		}
//////////////Search Customer////////////////
    public static boolean isCustomer(int count,String phoneNo){
		int ph=Integer.parseInt(phoneNo);
		for (int i = 0; i <=count; i++){
			if(cusId[i]==ph){
			 return true;
			 }		
		  }
		  System.out.print(cusId[0]);
		   return false;
	}
//////////////Generate orderId////////////////
    public static String generateOrderID(){
 	 tempOrIds[0]=tempOrIds[0]+1;
 	 String[] orIds=new String[1];
 	 orIds[0]=""+tempOrIds[0];// 
 	 while(orIds[0].length()<4){
		 orIds[0]="0"+ orIds[0];
		 }
	 orIds[0]="B"+ orIds[0];
	return orIds[0];
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
