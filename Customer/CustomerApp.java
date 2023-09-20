package Customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import Admin.MovieDetail;
import Customer.Price.PriceApp;
import Customer.SeatA.PlanSeat;
/**
 * Customer Application 
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class CustomerApp 
{
    private ArrayList<MovieDetail> Mlist;
    private Calendar c;

    private ArrayList<PlanSeat> Room;      // Room Seat 
    private ArrayList<String> Room_Movie ; // Each Room Movie
    private PriceApp pa;

    private int Status = 0;
    /**
     * Initialize  Customer Application
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
    public CustomerApp(ArrayList<MovieDetail> temp,Calendar tempc,ArrayList<PlanSeat> R,ArrayList<String> RM,PriceApp pa)
    { 
        this.Mlist = temp; 
        this.c = tempc;
        this.Room =R;
        this.Room_Movie = RM;
        this.pa = pa;
    }
    /**
     * Interface for Customer
     * @return MList
     * - Movie List
     */
    
    public ArrayList<MovieDetail> CA()
    {   
        CustomerBG CBG = new CustomerBG(Mlist,c,Room,Room_Movie,pa);
        int choice =0;
        do
        {   
            try 
            {   
                System.out.println("\t\t"+c.getTime());
                System.out.println("| =================== CUSTOMER OPTION ======================== |");
                System.out.println("| 1) Search Movie                                              |");
                System.out.println("| 2) View movie details                                        |");
                System.out.println("| 3) Check Seat availability                                   |");
                System.out.println("| 4) Book and purchase ticket                                  |");
                System.out.println("| 5) View booking history                                      |");
                System.out.println("| 6) Exit                                                      |");
                System.out.println("| ============================================================ |");
                Scanner Userinput = new Scanner(System.in); 
                System.out.printf("Please Select your choice : ");
                choice = Userinput.nextInt();
            } 
            catch (InputMismatchException e) {
                continue;
            }
        this.Status = CBG.Coption(choice);
        }while(Status != 6);
        return this.Mlist;
    }
}
