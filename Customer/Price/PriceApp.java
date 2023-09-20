package Customer.Price;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Price Application
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class PriceApp 
{
    private double totalsum=0;
    /**
     * Retrieve Total Price
     * @return totalsum
     *  - Total Price
     */
    public double gettotalsum(){return this.totalsum;}

    // Default price
    private double tickeprice = 10.0f;
    private double Drinks = 3.0f;
    private double Snacks = 5.0f;
    private double combomeal = 7.20f;   
    private double Sweets = 2.50f;
    private double Jacket = 25.00f;
    private double Ltdtoy = 50.00f;
    /**
     * Set Ticket Price Value
     * @param value
     * - Ticket Price Value
     */
    public void setticketprice(double value){this.tickeprice =value ;}
    /**
     * Set Drinks Price Value
     * @param value
     * - Drinks Price Value
     */
    public void setDrinks(double value){this.Drinks =value ;}
    /**
     * Set Snacks Price Value
     * @param value
     * - Snacks Price Value
     */
    public void setSnacks(double value){this.Snacks =value ;}
    /**
     * Set Combo Meal Price Value
     * @param value
     *  - Combo Meal Price Value
     */
    public void setcombomeal(double value){this.combomeal =value ;}
    /**
     * Set Sweets Price Value
     * @param value
     * - Sweets Price Value
     */
    public void setSweets(double value){this.Sweets =value ;}
    /**
     * Set Jacket Price value
     * @param value
     *  - Jacket Price Value
     */
    public void setJacket(double value){this.Jacket =value ;}
    /**
     * Set Limited Edition Toy Price Value
     * @param value
     * - Limited Edition Toy Price Value
     */
    public void setLtdtoy(double value){this.Ltdtoy =value ;}
    /**
     * Retrieve Ticket Price Value
     * @return ticketprice
     * - Ticket Price Value
     */
    public double getticketprice(){return this.tickeprice;}
    /**
     * Retrieve Drinks Price Value
     * @return Drinks
     * - Drinks Price Value
     */
    public double getDrinks(){return this.Drinks ;}
    /**
     * Retrieve Snacks Price Value
     * @return Snacks
     * - Snacks Price Value
     */
    public double getSnacks(){return this.Snacks;}
    /**
     * Retrieve Combo Meal Price Value
     * @return combomeal
     * - Combo Meal Price Value
     */
    public double getcombomeal(){return this.combomeal;}
    /**
     * Retrieve Sweets Price Value
     * @return Sweets
     * - Sweets Price Value
     */
    public double getSweets(){return this.Sweets ;}
    /**
     * Retrieve Jacket Price Value
     * @return Jacket
     * - Jacket Price Value
     */
    public double getJacket(){return this.Jacket;}
    /**
     * Retrieve Limited Edition Toy Price Value
     * @return Ltdtoy
     * - Limited Edition Toy Price Value
     */
    public double getLtdtoy(){return this.Ltdtoy;}

    private int numDrinks =0;
    private int numSnacks =0;
    private int numcombomeal =0;
    private int numSweets =0;;
    private int numJacket =0;
    private int numLtdtoy =0;

    private double GST =0;

    /**
     * Checking Date Whether it on Weekday/Weekend/Public Holiday 
     * @param c
     * - Date and time
     */
    public void Alldate(Calendar c)
    {
        ArrayList<PDate> PHlist = new ArrayList<>();
        PHlist.add(new PDate(1, 1, 2022));
        PHlist.add(new PDate(1, 2, 2022));
        PHlist.add(new PDate(2, 2, 2022));
        PHlist.add(new PDate(15, 4, 2022));
        PHlist.add(new PDate(1, 5, 2022));
        PHlist.add(new PDate(15, 5, 2022));
        PHlist.add(new PDate(10, 7, 2022));
        PHlist.add(new PDate(9, 8, 2022));
        PHlist.add(new PDate(24, 10, 2022));
        PHlist.add(new PDate(25, 12, 2022));
       for(int i =0;i<PHlist.size();i++)
       {
            if(c.get(Calendar.YEAR)==PHlist.get(i).getYear())
                if(c.get(Calendar.MONTH)== (PHlist.get(i).getMonth()-1))
                    if(c.get(Calendar.DAY_OF_MONTH)== PHlist.get(i).getDay())
                    {
                        this.tickeprice = 20.00;
                        return;
                    }
        }
        if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY || c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY)
        { 
            this.tickeprice = 1.3 *10;
            this.Drinks =1.3*3;
            this.Snacks =1.3*5;
            this.combomeal =1.3*7.2;
            this.Sweets =1.3*2.5;
            this.Jacket =1.3*25;
            this.Ltdtoy = 1.3*50;
        }
        
    }
	/**
	 * Print out Total Amount of Item being Purchase by the Customer
	 * @param Printall
	 *  - True or False 
	 * @return Text
	 * 	- Detail of the item purchase
	 */
    public String PrintListOfItem(Boolean Printall)
    {
        String All ="";
        String Stp =String.format(" 1x Ticket price : $%.2f\n",this.tickeprice);
        String Std =String.format(" %dx Drinks price : $%.2f\n",this.numDrinks,this.Drinks*this.numDrinks);
        String Sts =String.format(" %dx Snacks price : $%.2f\n",this.numSnacks,this.numSnacks*this.Snacks);
        String Stcm =String.format(" %dx Combo Meal price : $%.2f\n",this.numcombomeal,this.numcombomeal*this.combomeal);
        String stsw =String.format(" %dx Sweets price : $%.2f\n",this.numSweets,this.numSweets*this.Sweets);
        String Stj =String.format(" %dx Jacket price : $%.2f\n",this.numJacket,this.numJacket*this.Jacket);
        String Stltd =String.format(" %dx Limited Edition toy price : $%.2f\n",this.numLtdtoy,this.numLtdtoy*this.Ltdtoy);
        String Stgst =String.format(" GST : $%.2f\n",this.GST);
        String sttp = String.format(" After GST : $%.2f\n",this.totalsum);
        if(Printall == true)
        {
            System.out.println("|===============Total=======================|");
            System.out.printf(Stp);
            if(numDrinks != 0)
            System.out.printf(Std);
            if(numSnacks != 0)
            System.out.printf(Sts);
            if(numcombomeal != 0)
            System.out.printf(Stcm);
            if(numSweets != 0)
            System.out.printf(stsw);
            if(numJacket!= 0)
            System.out.printf(Stj);
            if(numLtdtoy!= 0)
            System.out.printf(Stltd);
            System.out.printf(Stgst);
            System.out.printf(sttp);
            System.out.println("|===========================================|");
        }
        All = Stp + Std + Sts + Stcm+ stsw+Stj+Stltd+Stgst+sttp;
        return All;
    }
    
    /**
     * Interface for Customer to Choose Item to Purchase
     */
    public void CalculateTP()
    {   
        
        int choice=0;
        System.out.printf("Price of the Seat : $%.2f\n",this.tickeprice);
        System.out.println("|=====================Add on================|");
        System.out.printf("| 1. Drink [$%.2f]                          |\n",this.Drinks);
        System.out.printf("| 2. Snacks [$%.2f]                         |\n",this.Snacks);
        System.out.printf("| 3. Combo meal [$%.2f]                     |\n",this.combomeal);
        System.out.printf("| 4. Sweets [$%.2f]                         |\n",this.Sweets);
        System.out.printf("| 5. Jacket [$%.2f]                        |\n",this.Jacket);
        System.out.printf("| 6. Limited Edition Toy [$%.2f]           |\n",this.Ltdtoy);
        System.out.println("| 7. Checkout                               |");
        System.out.println("|===========================================|");
        do
        {
            try 
            {
                System.out.printf("Select choice :");
                Scanner sc = new Scanner(System.in);
                choice = sc.nextInt();
                sc.nextLine();
                if(choice ==0)
                    continue;
                switch(choice)
                {
                    case 1 : this.numDrinks++;      break;
                    case 2 : this.numSnacks++;      break;
                    case 3 : this.numcombomeal++;   break;
                    case 4 : this.numSweets++;      break;
                    case 5 : this.numJacket++;      break;
                    case 6 : this.numLtdtoy++;      break;
                }
            } catch (InputMismatchException e) {
                continue;
            }
            this.totalsum = this.tickeprice + (this.numDrinks*this.Drinks) +(this.numSnacks*this.Snacks)+(this.numcombomeal*this.combomeal)+(this.numSweets*this.Sweets)+(this.numJacket*this.Jacket)+(this.numLtdtoy*this.Ltdtoy);
            System.out.printf("Total Price : $%.2f\n",this.totalsum);
        }while(choice != 7);
        this.GST = (this.totalsum * 7)/100;
        this.totalsum += this.GST;
    }
}
