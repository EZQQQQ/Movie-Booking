package Customer.SeatA;
/**
 * Plan Seat Application
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class PlanSeat 
{
   private Seat[][] s;
   private int emptyseat;
   /**
    * Retrieve Number of Empty Seat in the Room
    * @return emptyseat
    * - Number of Empty Seat
    */
   public int getemptyseat(){return this.emptyseat;}
   /**
    * Initialize 80 Seat for a Room
    */
   public PlanSeat()
   {
        s = new Seat[10][8];
        for(int r =0;r<10;r++)
            for(int c=0;c<8;c++)
                s[r][c]= new Seat(r+""+c, "");
        this.emptyseat = 80;
   }
   /**
    * Display Seat Arrangement 
    */
   public void ShowSeat()
   {   
        for(int r=0;r<10;r++)
        {
            System.out.println("|====|====|====|====|====|====|====|====|");
            for(int c=0;c<8;c++)
            {
                if(s[r][c].isOccupied() == true)
                    System.out.printf("| XX ");
                else
                    System.out.printf("| %d%d ",r,c);
            }
            System.out.println("|");
            System.out.println("|====|====|====|====|====|====|====|====|");
        }
        System.out.println("|                                      E|");
        System.out.println("|         |====   Screen  ====|         |");
        System.out.println("|====|====|====|====|====|====|====|====|");
   }
   /**
    * Assign Seat
    * @param seatid
    *  - Seat Number
    * @param custname
    *  - Customer Name
    * @return Available
    *  - True or False
    */
   public boolean assignseat(String seatid,String custname)
   {    
        int r = Integer.parseInt(String.valueOf(seatid.charAt(0)));
        int c = Integer.parseInt(String.valueOf(seatid.charAt(1)));
        if(r<10)
            if(c<8)
                if(s[r][c].isOccupied() == false)
                {
                    s[r][c].assign(custname);
                    this.emptyseat--;
                    return true;
                }
                else
                    System.out.println("Seat already assigned");
            else
                System.out.println("Invalid seat");
        else
           System.out.println("Invalid seat");
        return false;
   }
   /**
    * Check Seat Taken
    * @param seatid
    * - Seat Number
    * @return Available
    *  - True or False
    */
   public boolean checkseat(String seatid)
   {    
        int r = Integer.parseInt(String.valueOf(seatid.charAt(0)));
        int c = Integer.parseInt(String.valueOf(seatid.charAt(1)));
        if(r<10)
            if(c<8)
                if(s[r][c].isOccupied() == false)
                {
                    return true;
                }
                else
                    System.out.println("Seat already assigned");
            else
                System.out.println("Invalid seat");
        else
           System.out.println("Invalid seat");
        return false;
   }
   
}