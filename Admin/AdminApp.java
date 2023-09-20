package Admin;
import java.util.Scanner;

import Customer.Price.PriceApp;
import Customer.SeatA.PlanSeat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
/**
 * Admin Application 
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class AdminApp  
{   
    private ArrayList<MovieDetail> Mlist;
    private Calendar c;
    /**
     * Retrieve Data and Time 
     * @return c
     *  - Date and time
     */
    public Calendar getc(){return this.c;}

    private ArrayList<PlanSeat> Room ;     // Room Seat 
    private ArrayList<String> Room_Movie ; // Each Room Movie
    private PriceApp pa;
    /**
     * Initialize Admin Application 
     * @param temp
     * 	- Movie List
     * @param tempc
     *  - Date and time
     * @param R
     *  - Room seat
     * @param RM
     *  - Room name
     * @param pa
     *  - Item Price
     */
    public AdminApp(ArrayList<MovieDetail> temp,Calendar tempc,ArrayList<PlanSeat> R,ArrayList<String> RM,PriceApp pa)
    {
        this.Mlist = temp;
        this.c = tempc;
        this.Room = R;
        this.Room_Movie = RM;
        this.pa = pa;
    }
    /**
     * Run Admin Application Interface
     * @return Mlist
     *  - Movie List
     */
    public ArrayList<MovieDetail> AA()
    {
        AdminBG ABG = new AdminBG(this.Mlist,this.c,this.Room,this.Room_Movie,this.pa);
        int choice =0,status =0;
        do
        {   
            try 
            {   System.out.println("\t\t"+c.getTime());
                System.out.println("| ====================== ADMIN OPTION ========================= |");
                System.out.println("| 1)  Show Movie List in Database                               |");
                System.out.println("| 2)  Add Movie List to Database                                |");
                System.out.println("| 3)  Update Movie                                              |");
                System.out.println("| 4)  Delete Movie List Database [Base on Index]                |");
                System.out.println("| 5)  Display Movie List to Shown                               |");
                System.out.println("| 6)  Select Movie to shown                                     |");
                System.out.println("| 7)  Remove Movie List to shown                                |");  
                System.out.println("| 8)  Import File                                               |");
                System.out.println("| 9)  Save File                                                 |");
                System.out.println("| 10) Configure Date & Time                                     |");
                System.out.println("| 11) Configure Price                                           |");
                System.out.println("| 12) Exit                                                      |");
                System.out.println("| ============================================================= |");
                Scanner Userinput = new Scanner(System.in); 
                System.out.printf("Please Select your choice : ");
                choice = Userinput.nextInt();
            } 
            catch (InputMismatchException e) {
                continue;
            }
            status = ABG.optionChoice(choice);
        } while (status!=12);
        this.Mlist = ABG.getMList();
        return Mlist;
    }
}
