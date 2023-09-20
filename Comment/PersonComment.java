package Comment;
/**
 * Detail on the Comment
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class PersonComment 
{
    private String Username="";
    private String Comment="";
    private double rate = 0.0f;

    /**
     * Method to Retrieving Person name
     * @return Person name
     * 
     */
    public String getUsername(){return this.Username;}
    /**
     * Method to Retrieving Person Comment
     * @return Person Comment
     * 
     */
    public String getComment(){return this.Comment;}
    /**
     * Method to Retrieving the Person rating for this movie
     * @return Person rating for this movie
     * 
     */
    public double getrate(){return this.rate;}
    
    /**
     * Initialize a Person Detail for the comment 
     * @param name
     * 	- Person name 
     * @param rate
     * - Person Overall Rating for the movie
     * @param Com
     * - Person Comment on the movie
     */
    public PersonComment(String name,String rate,String Com)
    {
        this.Username = name;
        this.Comment = Com;
        this.rate = Double.valueOf(rate);
    }

}
