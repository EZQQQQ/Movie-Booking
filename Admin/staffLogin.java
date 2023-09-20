package Admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import Customer.Price.PriceApp;
import Customer.SeatA.PlanSeat;

/**
 * Admin Login Application
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class staffLogin {

	//add a counter in main for max of 5 attempts 
	private String user = "admin";
	private String password = "admin";
	private int numtry=0;

	private ArrayList<MovieDetail> Mlist;
	/**
	 * Retrieve Movie List
	 * @return Mlist
	 * - List of Movie
	 */
	public ArrayList<MovieDetail> getMlist(){return this.Mlist;}

	private Calendar c ;
	/**
	 * Retrieve Date and time 
	 * @return c
	 * - Date and time 
	 */
	public Calendar getc(){return this.c;}
	
	private ArrayList<PlanSeat> Room ;     // Room Seat 
    private ArrayList<String> Room_Movie ; // Each Room Movie
	private PriceApp pa;

	/**
	 * Initialize StaffLogin Application
	 * @param temp
	 *  - Movie List
	 * @param tempc
	 *  - Application Date and time
	 * @param R
	 *  - Room Seat
	 * @param RM
	 *  - Room name
	 * @param pa
	 *  - Item Price
	 */

	public staffLogin(ArrayList<MovieDetail> temp,Calendar tempc,ArrayList<PlanSeat> R,ArrayList<String> RM,PriceApp pa)
	{
		this.Mlist = temp;
		this.c = tempc;
		this.Room = R;
		this.Room_Movie = RM;
		this.pa =pa;

	}
	/**
	 * Check User input for Correct Login Verification
	 * @param user
	 * 	- Username
	 * @param password
	 *  - Password
	 * @return 
	 *  - True or False
	 */
	public boolean checkAdmin(String user, String password) {
		
		if(user.equals(this.user) && password.equals(this.password)) {
			System.out.println("Welcome Admin");
			return true;
		}
		
		else {
			System.out.println("Invalid login, please try again.");
			return false;
		}
	}
	/**
	 * Record number of Verification Attempt 
	 * @param attempt
	 * - Number of try
	 */
	
	public void verify(Boolean attempt)
	{
		if(attempt == false)
		{
			this.numtry ++;
			System.out.println("Number of try : "+this.numtry);
		}
		else
		{
			this.numtry =0;
		}
	}
	/**
	 * Login Interface for User
	 */
	public void InLogin()
	{		
			if(this.numtry == 5)
			{
				System.out.println("Max Attempt, Please try Again Next time");
				return;
			}
			System.out.println("|=======================================================|");
			String username="",pw="";
			Scanner UsIn = new Scanner(System.in);
			do
			{	
				System.out.printf("Enter Username : ");
				username = UsIn.nextLine().trim();
			}while(username == "");	
			do
			{	
				System.out.printf("Enter Password : ");
				pw = UsIn.nextLine().trim();
			}while(pw == "");
			System.out.println("|=======================================================|");

			verify(checkAdmin(username, pw));
			if(this.numtry != 0)
				InLogin();
			else
			{
				AdminApp AApp = new AdminApp(this.Mlist,this.c,this.Room,this.Room_Movie,this.pa);
				this.Mlist=AApp.AA();	// retirve Movie data
				this.c = AApp.getc();	// retirve date and time 
				return;
			}
			
	}
}