package Customer.SeatA;
/**
 * Seat Detail
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class Seat 
{
    private String seatID;
    private String customerID;
    private boolean assigned = false;
    /**
     * Set Assign Seat
     * @param t
     * - True or False
     */
    public  void setassign(boolean t){this.assigned = t;}
    /**
     * Initialize Seat Detail
     * @param seatid
     * 	- Seat Number
     * @param customername
     *  - Customer name
     */
    public Seat(String seatid,String customername)
    {
        this.seatID = seatid;
        this.customerID = customername;
    }
    /**
     * Retrieve Customer Name
     * @return customerID
     *  - Customer Name
     */
    public String getCustID(){return this.customerID;}
    /**
     * Retrieve Seat Number
     * @return  seatID
     * - Seat Number
     */
    public String getSeatID(){return this.seatID;}
    /**
     * Check Whether Seat Taken
     * @return Assigned
     *  - True or False
     */
    public boolean isOccupied(){return this.assigned;}

    /**
     * Assign seat base on Customer Name
     * @param custID
     * - Customer Name
     */
    public void assign(String custID)
    {
       this.customerID = custID;
       this.assigned = true;
    }



}
