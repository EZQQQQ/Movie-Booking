package Customer.Price;

/**
 * Date Detail
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class PDate 
{
    private int Day;
    private int Month;
    private int Year;
    /**
     * Retrieve Day
     * @return Day
     *  - Day Number
     */
    public int getDay(){return this.Day;}
    /**
     * Retrieve Month
     * @return Month
     *  - Month Number
     */
    public int getMonth(){return this.Month;}
    /**
     * Retrieve Year
     * @return Year
     * - Year Number
     */
    public int getYear(){return this.Year;}
    /**
     * Initialize Date
     * @param D 
     *  - Day
     * @param m
     *  - Month
     * @param y
     *  - Year
     */
    public PDate(int D,int m,int y)
    {
        this.Day = D;
        this.Month = m;
        this.Year = y;
    }

}
