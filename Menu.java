import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
	static Scanner scan = new Scanner(System.in);
	static Integer entryInt;
	static Double entryDouble;
	static String entryString;
	
	static Integer quit = 10;
	//chris to complete
	public static void premiumMenu(PremiumClient user, ArrayList<Stock> stock) throws MustBePositiveException, InsufficientFundsException {
		do {
			System.out.println();
			System.out.println();			
			System.out.println("Enter an integer that matches the below options:");
			//trade
				//buy
					//unsuccessful trade notification
				//sell
					//unsuccessful trade notification
			System.out.println("1. Trade");
			//view own current queue			
			System.out.println("2. View your Trade Queue");
			//view stock price			
			System.out.println("3. View current stock prices");
			//withdraw funds
			System.out.println("4. Withdraw Funds");
			//owned stocks
			System.out.println("5. View stocks you own");
			//graphing tool
			System.out.println("6. View 30 min price graph");
			
			
			//Exit Stock Market
			System.out.println("10. Quit");
			
			entryInt = intScanner();
			
			if (entryInt == 1) {
				//go to trade menu
				tradeMenu(user);
			}
			else if (entryInt == 2) {
				//go to tradeQueue menu
				getTradeQueue(user);
			}
			else if (entryInt == 3) {
				//go to stock price menu
				getStockPrices(stock);
			}
			else if (entryInt == 4) {
				//go to withdraw menu
				withdrawMenu(user);
			}
			else if (entryInt == 5) {
				//go to withdraw menu
				ownedStocksMenu(user);
			}
			else if (entryInt == 6) {
				//go to withdraw menu
				graphingTool(user);
			}				
			
			else if (entryInt == quit) {
				
			}
			else {
				//unrecognised value
				System.out.println("Select a number from the menu");				
			}
			
			
		}
		while (entryInt != quit);
		System.out.println("Logging Out");
		System.out.println();
		System.out.println();
		System.out.println();		
	}

	
	//chris to complete
	public static void clientMenu(Client user, ArrayList<Stock> stock) throws MustBePositiveException, InsufficientFundsException {
		do {

			System.out.println("Enter an integer that matches the below options:");
			//trade
				//buy
					//unsuccessful trade notification
				//sell
					//unsuccessful trade notification
			System.out.println("1. Trade");
			//view own current queue			
			System.out.println("2. View your Trade Queue");
			//view stock price			
			System.out.println("3. View current stock prices");
			//withdraw funds
			System.out.println("4. Withdraw Funds");
			//owned stocks
			System.out.println("5. View stocks you own");
			
			//Exit Stock Market
			System.out.println("10. Quit");
			
			entryInt = intScanner();
			
			if (entryInt == 1) {
				//go to trade menu
				tradeMenu(user);
			}
			else if (entryInt == 2) {
				//go to tradeQueue menu
				getTradeQueue(user);
			}
			else if (entryInt == 3) {
				//go to stock price menu
				getStockPrices(stock);
			}
			else if (entryInt == 4) {
				//go to withdraw menu
				withdrawMenu(user);
			}
			else if (entryInt == 5) {
				//go to withdraw menu
				ownedStocksMenu(user);
			}			
			
			else if (entryInt == quit) {
				
			}
			else {
				//unrecognised value
				System.out.println("Select a number from the menu");				
			}
			
			
		}
		while (entryInt != quit);
		System.out.println("Logging Out");
		System.out.println();
		System.out.println();
		System.out.println();		
	}

	
	private static void ownedStocksMenu(Client user) {
		System.out.println("The stocks you own are:");
		user.printAllStocks();
		
	}
	private static void graphingTool(Client user) {
		System.out.println("The graphing tool functionality is not live yet, you will not be charged for premium membership.");
	}	
	
	
	
	

	public static void getStockPrices(ArrayList<Stock> stock) {
		//Loop through all the stocks and return the prices
		int i;
		//check the userName against all userNames
		for (i = 0; i <  stock.size(); i++) {
			String code;
			Integer price;
			code = stock.get(i).getStockCode();			
			price = stock.get(i).getStockPrice();
			System.out.println("Stock: " + code + " has a price of " + price + " cents.");
			
			}
		
		
	}	


	private static void getTradeQueue(Client user) {		
		System.out.println("Unfortunately the trade queue functionality is not available yet.");
		System.out.println("Returning to main menu.");
	}


	
	
	private static void tradeMenu(Client user) {
		System.out.println("Enter an integer that matches the below options:");

		System.out.println("1. Buy");
		System.out.println("2. Sell");
		System.out.println("10. Return to main menu");
		entryInt = intScanner();
		
		if (entryInt == 1) {
			//buy
			buyStockMenu(user);
				//unsuccessful trade notification			
		}
		
		else if (entryInt == 2) {
			//sell
			sellStockMenu(user);
				//unsuccessful trade notification			
		}
		
		else {
			//return to main menu
			
		}
		
	}

	private static void buyStockMenu(Client user) {
	//show all stock codes
		// 	You have this much in your account to buy with
		System.out.println("Unfortunately the buy functionality is not available yet.");
		System.out.println("Returning to main menu.");
	}
	
	private static void sellStockMenu(Client user) {
		//	Unfortunately sell functionality is not yet available		
		System.out.println("Unfortunately sell buy functionality is not available yet.");
		System.out.println("Returning to main menu.");		
	}	
	
	
	//surya to complete
	public static void auditorMenu(Auditor user) {
		//query transactions
		//list clients
		System.out.println("Auditor Menu - functionality not available yet");			
		System.out.println("Logging out");			
	}	
	
	
	//surya to complete
	public static void managerMenu(Manager user) {
		//list clients
		//premium clients
			//list premium clients
			//make premium
			//revoke premium
		//add funds to client
		//registration
			//register client
			//register premium client
			//register manager
			//register auditor
			//Deregister client
			//Deregister premium client
			//Deregister manager
			//Deregister auditor
		
		//[later]review unusual trading notifications - have to be real time notifications too
		//Set Activity Logic thresholds
		//Set Threshold Logic
		System.out.println("Manager Menu - functionality not available yet");			
		System.out.println("Logging out");	
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private static void withdrawMenu(Client client) throws MustBePositiveException, InsufficientFundsException {
		
			System.out.println("Your current funds are " + client.getFunds() + " cents.");
			System.out.println();			
			System.out.println("Enter an integer that matches the below options:");

			//view stock price			
			System.out.println("1. Withdraw Funds");

			//Main Menu
			System.out.println("Any Value. Return to main menu");			
			
			entryInt = intScanner();
			
			if (entryInt == 1) {
				System.out.println("How much would you like to withdraw?");				
				entryInt = intScanner();
				client.withdrawFunds(entryInt);
				System.out.println(entryInt + " cents withdrawn");
				System.out.println(client.getFunds() + " cents remains in account");				
				
			}
			else {
				System.out.println("Returning to main menu");	
			}
		
			
		
	}
	
	
	
	
	
	
	//if (entryInt == 1) {
		//go to trade menu
	//}
	//else if (entryInt == 2) {
		//go to tradeQueue menu
	//}
	//else if (entryInt == 3) {
		//go to stock price menu
	//}
	//else if (entryInt == 4) {
		//go to withdraw menu
	//}
	//else {
		//unrecognised value
	//	System.out.println("Select a number from the menu");				
	//}
	
	
	
	
	
	
	
	
	
	
	
	
	// method for getting Int from keyboard, error check if error is made
	
	public static int intScanner() {
		while (true) {
			try {
				return scan.nextInt();
			} catch (InputMismatchException e) {
				scan.next();
				System.out.print("That’s not an integer. Try again: ");
			}
		}
	}

	// method for getting String from keyboard, error check if error is made
	public String stringScanner() {
		while (true) {
			try {
				return scan.next();
			} catch (InputMismatchException e) {
				scan.next();
				System.out.print("That’s not a string. Try again: ");
			}
		}
	}

	// method for getting Double from keyboard, error check if error is made
	public Double doubleScanner() {
		while (true) {
			try {
				return scan.nextDouble();
			} catch (InputMismatchException e) {
				scan.next();
				System.out.print("That’s not a double. Try again: ");
			}
		}
	}
	
	
	
}
