package Customer;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

import Admin.MovieDetail;
import Customer.Price.PriceApp;
import Customer.SeatA.PlanSeat;

/**
 * Customer Application Background Task 
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class CustomerBG 
{
    private ArrayList<MovieDetail> Mlist;
    private Calendar c; // Current Date
    private PlanSeat PS;
    private CustFileIO cio;

    private ArrayList<PlanSeat> Room ;     // Room Seat 
    private ArrayList<String> Room_Movie ; // Each Room Movie
    private PriceApp pa;                    // Price 

    /**
     * Initialize  Customer Application Background Task
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
    public CustomerBG(ArrayList<MovieDetail> temp,Calendar tempc,ArrayList<PlanSeat> R,ArrayList<String> RM,PriceApp pa)
    {   
        this.Mlist = temp;
         this.c = tempc;
         this.Room = R;
         this.Room_Movie = RM;
         cio = new CustFileIO();
         cio.CreateFolder();
         this.pa = pa;
         
    }
     /**
     * Execute the method base on User input 
     * @param choice
     *  - User input choice number
     * @return choice
     *  - Choice number
     */
    public int Coption(int choice)
    {
        switch(choice)
        {
            case 1 : SearchMoive();break;
            case 2 : SearchMovieinfo(); break;
            case 3 : CheckSeatOfEachRoom();break;
            case 4 : Booking();break;
            case 5 : CheckBookHistory();break;
            case 6 : break;
            case 7 : break;
            default :choice =0;
        }
        return choice;
    }
    /**
     * Display the List of Movie that set on Admin Side
     */
    public void ListOfMoive()
    {   
        Boolean Flag=false;
        if(Mlist.size()==0)
        {
            System.out.println("No Movie List");
            return;
        }
        for(int k =0;k<Mlist.size();k++)    // Detect item to shown 
        {
            if(Mlist.get(k).isDisplay()==true)
            {
                Flag = false;
                break;
            }
            Flag = true;
        }
        if(Flag == true)
        {
            System.out.println("No Movie List");
            return;
        }   

        System.out.println("| ============================ Display Movie List ================================= |");

        System.out.println("  Index                      Title                     Runtime   Date Release        ");
        for(int i =0;i<Mlist.size();i++)
        {
            if(Mlist.get(i).isDisplay() == true)
                System.out.printf("%4d\t %40s\t%4d\t %12s%n\n",i+1,Mlist.get(i).getTitle(),Mlist.get(i).getRuntime(),Mlist.get(i).getDateRelease());
        }
        System.out.println("| ================================================================================= |");

    }
    /**
     * Display a Movie Information
     * @param index
     * - Index of the Movie
     */
    public void ViewMovieDetail(int index)
    {
        System.out.println("|=======================================================================|");
        System.out.printf(" Index           : %d\n",index+1);
        System.out.printf(" Title           : %s\n",Mlist.get(index).getTitle());
        System.out.printf(" Runtime         : %d\n",Mlist.get(index).getRuntime());
        System.out.printf(" Genre           : %s\n",Mlist.get(index).getGenre());
        System.out.printf(" Language        : %s\n",Mlist.get(index).getLanguage());
        System.out.printf(" Date Release    : %s\n",Mlist.get(index).getDateRelease());
        System.out.printf(" Director        : %s\n",Mlist.get(index).getDirector());
        System.out.printf(" Cast            : %s\n",Mlist.get(index).getCast());
        System.out.printf(" Movie Rating     : %s\n",Mlist.get(index).getMovRType());
        System.out.printf(" Overall Rating  : %s\n",Mlist.get(index).getOrating());

        System.out.printf(" Synopsis        : %s\n",Mlist.get(index).getSynopsis());
        if(Mlist.get(index).isDisplay())
            System.out.println(" Movie Status    : Now Showing");
        else
            System.out.println(" Movie Status    : Not available");
        System.out.println("|=======================================================================|");
    }
    /**
     * User Input of Searching Movie Information 
     */
    public void SearchMovieinfo()
    {   if(Mlist.size() ==0)
        {
            System.out.println("|=======================================================================|");
            System.out.println(" No Such Movie");
            System.out.println("|=======================================================================|");
            return;
        }
        System.out.println("|=======================================================================|");
        System.out.printf(" Enter Movie Title :");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine().trim().toUpperCase();
        System.out.println(title);
        for(int i =0;i<Mlist.size();i++)
        {
            if(title.equals(Mlist.get(i).getTitle().toUpperCase()))
            {
                ViewMovieDetail(i);
                return;
            }
        }
        
        System.out.println(" No Such Movie");
        System.out.println("|=======================================================================|");
    }
    /**
     * Booking Interface for Customer to buy a ticket 
     */
    public void Booking()
    {    
        if(this.Mlist.size() ==0)
            return;
         boolean flag =false;
         int mid;
         int roomnum =0;
         ListOfMoive();
         while(true)
         {
            try 
            {
                Scanner minpt = new Scanner(System.in);
                System.out.printf("Please choose a Movie [Index] : ");
                mid = minpt.nextInt();
                if(this.Mlist.get(mid-1).isDisplay()== false)
                    continue;
                break;
            } catch (InputMismatchException e) {
                continue;
            }
         }
         for(int f =0;f<Room_Movie.size();f++)
         {
            if(Room_Movie.get(f).equals(this.Mlist.get(mid-1).getTitle()))
            {   
                roomnum= f;
                this.Room.get(f).ShowSeat();
                break;
            }
         }
         
         
         String sid;
         while(true)
         {
            try 
            { 
                System.out.printf("Please choose the Seat Number :");
                Scanner sn = new Scanner(System.in);
                int sidi = sn.nextInt();
                sn.nextLine();
                sid = String.valueOf(sidi);
                if(sidi<10)
                    sid = "0"+sid;
                
                break;
            } catch (InputMismatchException e) {
                continue;
            }
         }
         if(this.Room.get(roomnum).checkseat(sid) == false)
            return;
         Scanner sc = new Scanner(System.in);
         System.out.printf("Please enter your Name : ");
         String cid = sc.nextLine();
         System.out.printf("Please enter your Email : ");
         String email = sc.nextLine();
         System.out.printf("Please enter your PhoneNumber : ");
         String ph = sc.nextLine();

         flag =this.Room.get(roomnum).assignseat(sid, cid);

         if(flag == true)
         {  
            pa.setticketprice(10);
            pa.Alldate(c);
            pa.CalculateTP();
            System.out.println("");
            pa.PrintListOfItem(true);
            cio.SaveFile(cid,Mlist.get(mid-1).getTitle(), sid, pa,email,ph,roomnum,this.c); 
         }
    }
    /**
     * Check Booking History base on File Recepit name
     */
    public void CheckBookHistory()
    {   
        System.out.printf("Please Enter the Receiptname :");
        Scanner uin = new Scanner(System.in);
        String Luname = uin.nextLine();
        System.out.println("|=======================================================================|");
        cio.ReadFile(Luname);
        System.out.println("|=======================================================================|");
    }
    /**
     *  Interface on Searching Movie base on Category 
     */
    public void SearchMoive()
    {   
        if(this.Mlist.size()==0)
            return;
        int choice =0;
        ArrayList<MovieDetail> temp = new ArrayList<>(this.Mlist);
        do
        {   
            
            System.out.println("|================== Category ==================|");
            System.out.println("| 1. Runtime                                   |");
            System.out.println("| 2. Overall Rating                            |");
            System.out.println("| 3. Exit                                      |");
            System.out.println("|==============================================|");
            try 
            {   
                Scanner in = new Scanner(System.in);
                System.out.printf("Enter Choice : ");
                choice = in.nextInt();
                in.nextLine();
                switch (choice) 
                {
                    case 1: Collections.sort(temp, new Comparator<MovieDetail>() {
                            @Override
                            public int compare(MovieDetail o1, MovieDetail o2) {
                                
                                return Integer.valueOf(o1.getRuntime()).compareTo(Integer.valueOf(o2.getRuntime()));
                            }

                            }
                            );
                            Collections.reverse(temp); 
                            System.out.println("| ============================ Display Movie List ================================= |");
                            System.out.println("  Index                      Title                     Runtime   Date Release        ");
                            for(int j =0;j<temp.size();j++)
                            {   if(temp.get(j).isDisplay())
                                {   
                                    for(int k =0;k<Mlist.size();k++)
                                    {   
                                       if( temp.get(j).getTitle().equals(Mlist.get(k).getTitle()) )
                                        {
                                            System.out.printf("%4d\t %40s\t%4d\t %12s%n\n",k+1,temp.get(j).getTitle(),temp.get(j).getRuntime(),temp.get(j).getDateRelease());
                                            break;
                                        }
                                    }
                                }
                            }
                            System.out.println("| ================================================================================= |");
                            break;
                    case 2: Collections.sort(temp, new Comparator<MovieDetail>() {
                            @Override
                            public int compare(MovieDetail o1, MovieDetail o2) {
                                
                                return Float.valueOf(o1.getOrating()).compareTo(Float.valueOf(o2.getOrating()));
                            }

                            }
                            );
                            Collections.reverse(temp); 
                            System.out.println("| ============================ Display Movie List ================================= |");
                            System.out.println("  Index                      Title                   Overall Rating                  ");
                            for(int j =0;j<temp.size();j++)
                            {   if(temp.get(j).isDisplay())
                                {   
                                    for(int k =0;k<Mlist.size();k++)
                                    {   
                                        if( temp.get(j).getTitle().equals(Mlist.get(k).getTitle()) )
                                            {
                                                System.out.printf("%4d\t %40s\t%4s\t \n\n",k+1,temp.get(j).getTitle(),temp.get(j).getOrating());
                                                break;
                                            }
                                    }
                                }
                            }
                            System.out.println("| ================================================================================= |");
                            break;
                    default:break;
                }
            } catch (InputMismatchException e) {
                continue;
            }
        }while(choice != 3);



    }

    /**
     * Display Seat Availability on Each Room 
     */
    public void CheckSeatOfEachRoom()
    {
        if(this.Mlist.size() ==0)
            {
                System.out.println("No Room ");
                return;
            }

            System.out.println("| ============================================================ |");
        for(int i =0;i<this.Room.size();i++)
            System.out.printf("Room %d  Movie: %s  Avaliable seat : %d  \n",i,this.Room_Movie.get(i),this.Room.get(i).getemptyseat());
            System.out.println("| ============================================================ |");

    }
}
