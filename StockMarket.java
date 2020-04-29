import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StockMarket {
	private ArrayList<Stock> stock = new ArrayList<Stock>();
	private ArrayList<User> user = new ArrayList<User>();	
	static Integer entryInt;
	static Double entryDouble;
	static String entryString;
	static Integer quit = 10;
	static Scanner scan = new Scanner(System.in);
	
	
	
	public StockMarket() {

	}
	
	public void addStock(Stock stocks) {
		
		
		this.stock.add(stocks);
	
	}
	

	public void registerUser(User user) {
		this.user.add(user);
	}
	public void registerUser(Manager manger) {
		this.user.add(manger);
	}
	public void registerUser(Client client) {
		this.user.add(client);
	}	
	public void registerUser(PremiumClient premiumClient) {
		this.user.add(premiumClient);
	}	
	public void registerUser(Auditor auditor) {
		this.user.add(auditor);
	}
	
	
	
	public void entryScreen() throws IncorrectPasswordException, IncorrectUserTypeException, MustBePositiveException, InsufficientFundsException, UserDoesNotExistException {
		do {
			String userName;
			String password;
			

			System.out.println("Enter username: ");
			userName = stringScanner();			
			System.out.println("Enter password: ");			
			password = stringScanner();
			login(userName,password);
			System.out.println("Do you want to login again? 1 = Login 10 = Quit");
			entryInt = intScanner();			
		}
		while (entryInt != quit);
	}
	
	
	public void login(String userName, String password) throws IncorrectPasswordException, IncorrectUserTypeException, MustBePositiveException, InsufficientFundsException, UserDoesNotExistException {
		int i;
		Boolean correctPath = false;
		//check the userName against all userNames
		for (i = 0; i < user.size(); i++) {
			if ((user.get(i).getUserName()).equals(userName)) {
				
				checkPassword(password,i);
				
				System.out.println ("Logging In");				
				//return the native class type
				proceedToCorrectMenu(i);
				correctPath = true;
				}

			}
		if(correctPath) {
		
		}
		else {
			throw new UserDoesNotExistException();	
		}
	}
	

	
	
	private void checkPassword(String password, Integer userId) throws IncorrectPasswordException {
		
		if(user.get(userId).getPassword().equals(password)) {
			
		}
		else {
			throw new IncorrectPasswordException();
		}
		
	}
	
	
	private void proceedToCorrectMenu(Integer userId) throws IncorrectUserTypeException, MustBePositiveException, InsufficientFundsException {
		if (user.get(userId) instanceof PremiumClient) {
			Menu.premiumMenu((PremiumClient) user.get(userId),stock);
		}
		else if (user.get(userId) instanceof Client) {
			Menu.clientMenu((Client) user.get(userId),stock);			
		}
		else if (user.get(userId) instanceof Manager) {
			Menu.managerMenu((Manager) user.get(userId));			
		}				
		else if (user.get(userId) instanceof Auditor) {
			Menu.auditorMenu((Auditor) user.get(userId));			
		}				
		else {
			throw new IncorrectUserTypeException();
		}		
	}
	
	
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



	 
			
	
	
	
}
