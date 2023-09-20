package Admin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

import Customer.Price.PriceApp;
import Customer.SeatA.PlanSeat;

/**
 * Admin Application Background Task 
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class AdminBG 
{   
    private String CurrentFilepath ="";
    private ArrayList<MovieDetail> Mlist;
    /**
     * Retrieve Movie List
     * @return Mlist
     *  - Movie List
     */
    public ArrayList<MovieDetail> getMList(){return this.Mlist;}

    private ArrayList<PlanSeat> Room ;     // Room Seat 
    private ArrayList<String> Room_Movie ; // Each Room Movie
    private PriceApp pa;

    private Calendar c;
    /**
     * Initialize Admin Application Background Task
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
    public AdminBG(ArrayList<MovieDetail> temp,Calendar tempc,ArrayList<PlanSeat> R,ArrayList<String> RM,PriceApp pa)
    {   
         this.Mlist = temp;
         this.c = tempc;
         this.Room = R;
         this.Room_Movie = RM;
         this.pa = pa;
    }
    /**
     * Execute the method base on User input 
     * @param choice
     *  - User input choice number
     * @return choice
     *  - Choice number
     */
    public int optionChoice(int choice)
    {
        switch(choice)
        {
            case 1: showMoList(this.Mlist);         break;
            case 2: AddMolist(this.Mlist);          break;
            case 3: UpdateMovie(this.Mlist);         break;
            case 4: deleteMoList(this.Mlist);       break;
            case 5: showMLToDisplay(this.Mlist);    break;
            case 6: selectMToD(this.Mlist);         break;
            case 7: removeMToD(this.Mlist);         break;
            case 8: ConfigInLocation();             break;
            case 9: saveFile(this.Mlist);           break;
            case 10: ChangeDatetime();              break;
            case 11: ChangePrice();                 break;
            case 12:                                 break;

            default: return 0;
        }
        return choice;
    }
    /**
     * Display Movie List in Database of this program
     * @param Mlist
     * - Movie list
     */
    public void showMoList(ArrayList<MovieDetail> Mlist)
    {
        if(Mlist.size()==0)
        {
            System.out.println("No Movie List ");
            return;
        }
        System.out.println("| ==================================== Movie List ================================= |");
        System.out.println("  Index                      Title                     Runtime   Date Release        ");
        for(int i =0;i<Mlist.size();i++)
        {
        System.out.printf("%4d\t %40s\t%4d\t %12s%n\n",i+1,Mlist.get(i).getTitle(),Mlist.get(i).getRuntime(),Mlist.get(i).getDateRelease());
        }
        System.out.println("| ==================================================================================|");
    }
  /**
   * Add Movie to the Movie List in the Database of this program
   * @param Mlist
   *  - Movie List
   */
    public  void AddMolist(ArrayList<MovieDetail> Mlist)
    {
        String TT, Gen, Lan, moiveR, Date, Dirtor,cast, sis;
        float Orating;
        int RT;
        Scanner inU = new Scanner(System.in);
        System.out.println("|=========================== Add Movie Detail to List ==============================|");
        
        System.out.printf("| Title\t: ");
        TT = inU.nextLine();
        while(true)
        {
            try 
            {   
                System.out.printf( "| Runtime\t: ");
                RT = inU.nextInt();
                inU.nextLine();
                break;
            } catch (InputMismatchException e) 
            {   inU.nextLine();
                continue;
            }
        }
        System.out.printf("| Genre\t: ");
        Gen = inU.nextLine();

        System.out.printf("| Language\t:");
        Lan = inU.nextLine();
        
        System.out.printf("| Movie Rating [G,PG,PG13,NC16,M18,R21,NAN]:");
        moiveR = inU.nextLine().toUpperCase();
        if(moiveR != "G" || moiveR != "PG13"||moiveR != "NC16"||moiveR != "M18"||moiveR != "R21")
        moiveR = "NAN";
        
        System.out.printf("| Date of Release\t: ");
        Date = inU.nextLine();

        System.out.printf("| Director\t: ");
        Dirtor = inU.nextLine();

        System.out.printf("| Cast\t: ");
        cast = inU.nextLine();

        System.out.printf("| Synosis\t: ");
        sis = inU.nextLine();

        while(true)
        {
            try 
            {
                System.out.printf("| Overall Rating\t: ");
                Orating = inU.nextFloat();
                inU.nextLine();
                if(Orating<0 || Orating>5)
                {
                    System.out.println("Invalid range pls Try Again");
                    continue;
                }
                break;
            } catch (InputMismatchException e) {
                inU.nextLine();
                continue;
            }
        }


        Mlist.add(new MovieDetail(TT,Integer.toString(RT), Gen, Lan, moiveR, Date, Dirtor, cast, sis,Float.toString(Orating)));  
        System.out.println("| ==================================================================================|");
        this.Mlist = Mlist;
    }
    /**
     * Remove a Movie from the Movie list in the Database of this program
     * @param Mlist
     * - Movie list
     */
    public void deleteMoList(ArrayList<MovieDetail> Mlist)
    {
        if(Mlist.size()==0)
        {
            System.out.println("No Movie to Delete");
            return;
        }
        showMoList(Mlist);
        while(true)
        {
            try 
            {
                Scanner inU = new Scanner(System.in);
                System.out.printf("Select Which to delete [Based on Index] :");
                int choice = inU.nextInt();
                if(choice>Mlist.size() || choice<1)
                {
                    System.out.println("Invalid Range Pleas try again!!!!");
                    continue;
                }
                Mlist.remove(choice-1);
                break;
            } catch (InputMismatchException e) {
                continue;
            }
        }
        this.Mlist = Mlist;        
    }
    /**
     * Display Movie List that is going to Display on Customer side
     * @param Mlist
     * - Movie List
     */
    public void showMLToDisplay(ArrayList<MovieDetail>Mlist)
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
        System.out.println("  Index                      Title                     Runtime   Date Release                ");

        for(int i =0;i<Mlist.size();i++)
        {
            if(Mlist.get(i).isDisplay() == true)
                System.out.printf("%4d\t %40s\t%4d\t %12s%n\n",i+1,Mlist.get(i).getTitle(),Mlist.get(i).getRuntime(),Mlist.get(i).getDateRelease());
        }
        System.out.println("| ==================================================================================|");
    }
    /**
     * Select Movie to Display in Customer side
     * @param Mlist
     * - Movie List
     */
    public void selectMToD(ArrayList<MovieDetail> Mlist)
    {
        int index;
        if(Mlist.size()==0)
        {
            System.out.println("No Movie List to Select on");
            return;
        }
        showMoList(Mlist);
        while(true)
        {
            try 
            {
                System.out.printf(" Select Movie to Display on [Index]:");
                Scanner sc = new Scanner(System.in);
                index = sc.nextInt();
                sc.nextLine();
                if(index<1 ||index>Mlist.size())
                    continue;
                break;
            } catch (InputMismatchException e) {
                continue;
            }
        }
        if(Mlist.get(index-1).isDisplay()==false)
        {
            Mlist.get(index-1).onDisplay(true);
            System.out.println(" Done");
            this.Room.add(new PlanSeat());
            this.Room_Movie.add(Mlist.get(index-1).getTitle());
        }
    }
    /**
     * Remove Movie to Display on Customer side
     * @param Mlist
     * - Movie List
     */
    public void removeMToD(ArrayList<MovieDetail> Mlist)
    {
        int index;
        if(Mlist.size()==0)
        {
            System.out.println("No Movie List to remove on");
            return;
        }
        showMLToDisplay(Mlist);
        while(true)
        {
            try 
            {
                System.out.printf(" Select Movie to remove from Display [Index]:");
                Scanner sc = new Scanner(System.in);
                index = sc.nextInt();
                sc.nextLine();
                if(index<1 ||index>Mlist.size())
                    continue;
                break;
            } catch (InputMismatchException e) {
                continue;
            }
        }
        if(Mlist.get(index-1).isDisplay() == true)
        {

            Mlist.get(index-1).onDisplay(false); 
            System.out.println(" Done");
            for(int f =0;f<this.Room_Movie.size();f++)
            {
                if(Mlist.get(index-1).getTitle().equals(Room_Movie.get(f)))
                {
                    Room.remove(f);
                    Room_Movie.remove(f);
                    break;
                }
            }
        }
        
    }
    /**
     * Import Movie Text or CSV file to this program Movie List Database
     */
    public void ConfigInLocation()
    {
        System.out.println("Current File Path : "+this.CurrentFilepath);
        FileIO IO = new FileIO();
       
        IO.selectFile();
        System.out.println("Selected File Path : "+ IO.getFLocation());
        if(IO.getFLocation() != null)
            this.CurrentFilepath = IO.getFLocation();
        System.out.println("Upload to Movie List?[Y/N]");
        Scanner Uin = new Scanner(System.in);
        char choice = Uin.next().charAt(0);
        if(Character.toUpperCase(choice)!= 'Y')
        {
            System.out.println("Moive from file will not be upload to Movie List");
            return;
        }
        this.Mlist.addAll(IO.readFile(this.CurrentFilepath));
        System.out.println("Moive from file has been successfully Upload to Movie List");
        showMoList(this.Mlist);
    }
    /**
     * Save a Text File for Movie List that has been in this Program Database 
     * @param MList
     * - Movie list
     */
    public void saveFile(ArrayList<MovieDetail> MList)
    {
        FileIO IO = new FileIO();
        int status = IO.saveFile(Mlist);
        if(status == 0)
        {
            System.out.println("File not been Save");
        }
        else
            System.out.println("File has been successfully save to the location");
    }
  /**
   * Interface to Change Movie Detail
   * @param MList
   * - Movie List
   */
    public void UpdateMovie(ArrayList<MovieDetail> MList)
    {  
        if(Mlist.size() ==0)
        {
            System.out.println("No Movie to Change");
            return;
        }
        int i=0;
        int k=0;

        showMoList(MList);
        System.out.println("| ==================================================================================|");
        while(true)
        {
            try 
            {
                Scanner uin = new Scanner(System.in);
                System.out.printf("Enter the Index for the Movie :");
                i = uin.nextInt();
                uin.nextLine();
                if(i ==0)
                    continue;
                break;
            } catch (InputMismatchException e) {
                continue;
            }
        }
        do
        {
            try 
            {
                System.out.println("| 1) Title");
                System.out.println("| 2) Runtime");
                System.out.println("| 3) Genre");
                System.out.println("| 4) Language");
                System.out.println("| 5) Movie Rating");
                System.out.println("| 6) Release Date");
                System.out.println("| 7) Director");
                System.out.println("| 8) Cast");
                System.out.println("| 9) Synopsis");
                System.out.println("| 10) Overall rating");
                System.out.println("| 11) Exit");
                System.out.printf("Select choice:");
                Scanner uin2 = new Scanner(System.in);
                k = uin2.nextInt();
                uin2.nextLine();
                Scanner word = new Scanner(System.in);
                String store;
                switch(k)
                {   
                    case 1 :    System.out.println("Previous Title : "+MList.get(i-1).getTitle());
                                System.out.printf("Current Title : ");
                                store = word.nextLine();
                                Mlist.get(i-1).setTitle(store);
                                break;

                    case 2 :    System.out.println("Previous Runtime : "+MList.get(i-1).getTitle());
                                System.out.printf("Current Runtime : ");
                                try 
                                {
                                    store = String.valueOf(word.nextInt());
                                } catch (Exception e) {
                                    store = "0";
                                }
                                Mlist.get(i-1).SetRuntime(store);
                                break;
                                
                    case 3 :    System.out.println("Previous Genre : "+MList.get(i-1).getGenre());
                                System.out.printf("Current Genre : ");
                                store = word.nextLine();
                                Mlist.get(i-1).setGenre(store);
                                break;

                    case 4 :    System.out.println("Previous Language : "+MList.get(i-1).getLanguage());
                                System.out.printf("Current Language : ");
                                store = word.nextLine();
                                Mlist.get(i-1).setLanguage(store);
                                break;

                    case 5 :    System.out.println("Previous MovieRating : "+MList.get(i-1).getMovRType());
                                System.out.printf("Current MovieRating : ");
                                store = word.nextLine();
                                if(store.equalsIgnoreCase("g")||store.equalsIgnoreCase("pg")||store.equalsIgnoreCase("pg13")||store.equalsIgnoreCase("nc17")||store.equalsIgnoreCase("m18")|| store.equalsIgnoreCase("r21") )
                                    Mlist.get(i-1).setMovRtype(store);
                                else
                                    Mlist.get(i-1).setMovRtype("nan");
                                break;

                    case 6 :    System.out.println("Previous Release Date : "+MList.get(i-1).getDateRelease());
                                System.out.printf("Current Release Date : ");
                                store = word.nextLine();
                                Mlist.get(i-1).setDateRelease(store);
                                break;

                    case 7 :    System.out.println("Previous Director : "+MList.get(i-1).getDirector());
                                System.out.printf("Current Director : ");
                                store = word.nextLine();
                                Mlist.get(i-1).setDirector(store);;
                                break;

                    case 8 :    System.out.println("Previous Cast : "+MList.get(i-1).getCast());
                                System.out.printf("Current Cast : ");
                                store = word.nextLine();
                                Mlist.get(i-1).setCast(store);
                                break;

                    case 9 :    System.out.println("Previous Synopsis : "+MList.get(i-1).getSynopsis());
                                System.out.printf("Current Synopsis : ");
                                store = word.nextLine();
                                Mlist.get(i-1).setSynopsis(store);
                                break;

                    case 10:    System.out.println("Previous Overall Rating : "+MList.get(i-1).getOrating());
                                System.out.printf("Current Overall Rating : ");
                                try {
                                    store = String.valueOf(word.nextLine());
                                    if(Float.valueOf(store)<0 || Float.valueOf(store)>5)
                                        store = "0.0";
                                } catch (InputMismatchException e) {
                                    store = "0.0";
                                }
                                Mlist.get(i-1).setOrating(store);
                                break;
                    default :
                }
                break;
            } catch (InputMismatchException e) {
                continue;
            }
        }while(k != 11);
        
        System.out.println("| ==================================================================================|");
    }
    
    /**
     * Interface to Change Date and time 
     */
    public void ChangeDatetime()
    {    
        int choice=0;
        do
        {   
            System.out.println("| =================== Change Date and time =================== |");
            System.out.println("| 1. Change Year                                               |");
            System.out.println("| 2. Change Month                                              |");
            System.out.println("| 3. Change Day                                                |");
            System.out.println("| 4. Change Time                                               |");
            System.out.println("| 5. Exit                                                      |");
            System.out.println("| ============================================================ |");
            while(true)
            {
                try 
                {
                    System.out.printf("Enter Choice :");
                    Scanner scdt = new Scanner(System.in);
                    choice = scdt.nextInt();
                    scdt.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    continue;
                }
            }
            switch(choice)
            {
                case 1 :    System.out.println("Previous Year : "+ c.get(Calendar.YEAR));
                            int year=0;
                            while(true)
                            {
                                try 
                                {
                                    Scanner inyear = new Scanner(System.in);
                                    System.out.printf("Current Year : ");
                                    year = inyear.nextInt();
                                    inyear.nextLine();
                                    if(year>1400 && year<3000)
                                        break;
                                } catch (InputMismatchException e) {
                                    continue;
                                }
                            }
                            this.c.set(Calendar.YEAR,year);
                            break;
                case 2 :    System.out.println("Previous Month : "+ (c.get(Calendar.MONTH)+1));
                            int Month=0;
                            while(true)
                            {
                                try 
                                {
                                    Scanner inmonth = new Scanner(System.in);
                                    System.out.printf("Current Month : ");
                                    Month = inmonth.nextInt();
                                    inmonth.nextLine();
                                    Month --;
                                    if(Month>=0 && Month<12)
                                        break;
                                } catch (InputMismatchException e) {
                                    continue;
                                }
                            }
                            this.c.set(Calendar.MONTH,Month);
                            break;

                case 3 :    System.out.println("Previous Day : "+ c.get(Calendar.DAY_OF_MONTH));
                            int Day =0;
                            while(true)
                            {
                                try 
                                {
                                    Scanner inday = new Scanner(System.in);
                                    System.out.printf("Current Day : ");
                                    Day = inday.nextInt();
                                    inday.nextLine();
                                    if(Day>0 && Day<32)
                                        break;
                                } catch (InputMismatchException e) {
                                    continue;
                                }
                            }
                            this.c.set(Calendar.DAY_OF_MONTH,Day);
                            break;
                case 4 :    System.out.println("Previous Time H:M:S : "+ c.get(Calendar.HOUR_OF_DAY)+":"+ c.get(Calendar.MINUTE)+":"+ c.get(Calendar.SECOND));
                            int hour=0,min=0,sec=0;
                            while(true)
                            {
                                try 
                                {
                                    Scanner intime = new Scanner(System.in);
                                    System.out.printf("Current Time H:M:S: ");
                                    hour = intime.nextInt();
                                    min = intime.nextInt();
                                    sec = intime.nextInt();
                                    intime.nextLine();
                                    if(hour>=0 && hour<24)
                                        if(min>=0 && min<60)
                                            if(sec>=0 && sec<60)
                                                break;
                                } catch (InputMismatchException e) {
                                    continue;
                                }
                            }
                            this.c.set(Calendar.HOUR_OF_DAY,hour);
                            this.c.set(Calendar.MINUTE,hour);
                            this.c.set(Calendar.SECOND,hour);
                            break;
            }

        }while(choice != 5);
    }
 /**
  * Interface to Change the Item Price
  */
    public void ChangePrice()
    {
        int choice=0;
        do
        {   
            System.out.println("| =================== Change Price =========================== |");
            System.out.println("| 1. Ticket Price                                              |");
            System.out.println("| 2. Drinks                                                    |");
            System.out.println("| 3. Snacks                                                    |");
            System.out.println("| 4. Combomeal                                                 |");
            System.out.println("| 5. Sweets                                                    |");
            System.out.println("| 6. Jacket                                                    |");
            System.out.println("| 7. setLtdtoy                                                 |");
            System.out.println("| 8. Exit                                                      |");
            System.out.println("| ============================================================ |");
            while(true)
            {
                try 
                {
                    System.out.printf("Enter Choice :");
                    Scanner scpa = new Scanner(System.in);
                    choice = scpa.nextInt();
                    scpa.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    continue;
                }
            }
            switch(choice)
            {
                case 1 :  System.out.printf("Previous Ticket Price : $%.2f\n",this.pa.getticketprice());
                          double tp=0;
                          while(true)
                          {
                            try {    
                            System.out.printf("Current Ticket Price : $");
                            Scanner scp = new Scanner(System.in);
                            tp = scp.nextDouble();
                            scp.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                continue;
                            }
                          }
                          pa.setticketprice(tp);
                          break;
                case 2 :  System.out.printf("Previous Drinks Price : $%.2f\n",this.pa.getDrinks());
                          double d=0;
                          while(true)
                          {
                            try {    
                            System.out.printf("Current Drinks Price : $");
                            Scanner scd = new Scanner(System.in);
                            d = scd.nextDouble();
                            scd.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                continue;
                            }
                          }
                          pa.setDrinks(d);
                          break;
                case 3 :  System.out.printf("Previous Snacks Price : $%.2f\n",this.pa.getSnacks());
                          double s=0;
                          while(true)
                          {
                            try {    
                            System.out.printf("Current Snacks Price : $");
                            Scanner scs = new Scanner(System.in);
                            s = scs.nextDouble();
                            scs.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                continue;
                            }
                          }
                          pa.setSnacks(s);
                          break;
                 case 4 :  System.out.printf("Previous Combo meal Price : $%.2f\n",this.pa.getcombomeal());
                           double cm=0;
                           while(true)
                           {
                            try {    
                            System.out.printf("Current Combo meal Price : $");
                            Scanner sccm = new Scanner(System.in);
                            cm = sccm.nextDouble();
                            sccm.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                continue;
                            }
                           }
                          pa.setcombomeal(cm);
                          break;
                 case 5 :  System.out.printf("Previous Sweets Price : $%.2f\n",this.pa.getSweets());
                          double sw=0;
                          while(true)
                          {
                           try {    
                           System.out.printf("Current Sweets Price : $");
                           Scanner scsw = new Scanner(System.in);
                           sw = scsw.nextDouble();
                           scsw.nextLine();
                               break;
                           } catch (InputMismatchException e) {
                               continue;
                           }
                          }
                         pa.setSweets(sw);
                         break;
                 case 6 :  System.out.printf("Previous Jacket Price : $%.2f\n",this.pa.getJacket());
                           double Jkt=0;
                            while(true)
                            {
                            try {    
                            System.out.printf("Current Jacket Price : $");
                            Scanner scjkt = new Scanner(System.in);
                            Jkt = scjkt.nextDouble();
                            scjkt.nextLine();
                                break;
                            } catch (InputMismatchException e) {
                                continue;
                            }
                            }
                            pa.setJacket(Jkt);
                            break;
                 case 7 :  System.out.printf("Previous Limited Edition Toy Price : $%.2f\n",this.pa.getLtdtoy());
                            double ltd=0;
                             while(true)
                             {
                             try {    
                             System.out.printf("Current Limited Edition Toy Price : $");
                             Scanner scltd = new Scanner(System.in);
                             ltd = scltd.nextDouble();
                             scltd.nextLine();
                                 break;
                             } catch (InputMismatchException e) {
                                 continue;
                             }
                             }
                             pa.setLtdtoy(ltd);;
                             break;                                                         
            }
        }while(choice != 8);
    }
   
    
}


