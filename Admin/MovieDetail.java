package Admin;
/**
 * Detail on the Movie
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class MovieDetail
{
    private String Title; 
    /**
     * Retrieve Movie Title
     * @return Title
     * 
     */
    public String getTitle(){return this.Title;}
    
    /**
     * Setting Movie Title 
     * @param TT
     * - Title name
     */
    public void setTitle(String TT){this.Title = TT;}
   
    private int Runtime;
    /**
     * Retrieve Timing for a Movie
     * @return Runtime
     */
    public int getRuntime(){return this.Runtime;}
    /**
     * Setting Movie Timing 
     * @param RT
     * - Runtime Number
     */
    public void SetRuntime(String RT)
    {   
        if(RT =="")
        this.Runtime = 0;
        else
        this.Runtime = Integer.valueOf(RT);
    }


    private String Genre;
    /**
     * Retrieve Movie Genre
     * @return Genre
     */
    public String getGenre(){return this.Genre;}
    /**
     * Setting Movie Genre
     * @param Gen
     * - Genre
     */
    public void setGenre(String Gen){this.Genre = Gen;}

    private String Language;
    /**
     * Retrieve Movie Language
     * @return Language
     */
    public String getLanguage(){return this.Language;}
    /**
     * Setting Movie Language
     * @param Lan
     * - Language
     */
    public void setLanguage(String Lan){this.Language = Lan;}
    /**
     * 
     * Type of Movie Rating 
     */
    protected enum MovieRating {/** {@link #G} - General */G, 
    							/** {@link #PG} - Parental Guidance */PG,
    							/** {@link #PG13} - Parental Guidance 13 */PG13,
    							/** {@link #NC17} - No Children under 17 */NC17,
    							/** {@link #M18} - Mature 18 */M18,
    							/** {@link #R21} - Restricted 21 */R21,
    							/** {@link #NAN} - No type */NAN};
    private MovieRating MovRtype;
    /**
     * Retrieve Movie Rating Type
     * @return MovRtype
     */
    public MovieRating getMovRType(){return this.MovRtype;}
    /**
     * Setting Movie Rating Type
     * @param moiveR
     * - Movie Rating Type
     */
    public void setMovRtype(String moiveR)
    {
        switch(moiveR.trim().toLowerCase())
        {
            case "g"        : this.MovRtype = MovieRating.G;  break;
            case "pg"       : this.MovRtype = MovieRating.PG; break;
            case "pg13"     : this.MovRtype = MovieRating.PG13; break;
            case "nc17"     : this.MovRtype = MovieRating.NC17; break;
            case "m18"      : this.MovRtype = MovieRating.M18; break;
            case "r21"      : this.MovRtype = MovieRating.R21; break;
            default         : this.MovRtype = MovieRating.NAN; 
        }
    }
    
    private String Daterelease;
    /**
     * Retrieve Movie Date of Release
     * @return Date release
     */
    public String getDateRelease(){return this.Daterelease;}
    /**
     * Setting Movie Date of Release
     * @param Date
     * - Movie Date
     */
    public void setDateRelease(String Date){this.Daterelease = Date;}

    private String Director;
    /**
     * Retrieve Movie Director
     * @return Director
     */
    public String getDirector(){return this.Director;}
    /**
     * Setting Movie Director
     * @param Dirtor
     * - Movie Director name
     */
    public void setDirector(String Dirtor){this.Director = Dirtor;}

    private String Synopsis;
    /**
     * Retrieve Movie Synopsis
     * @return Synopsis
     */
    public String getSynopsis(){return this.Synopsis;}
    /**
     * Setting Movie Synopsis
     * @param sis
     * - Synopsis
     */
    public void setSynopsis(String sis){ this.Synopsis = sis;}

    private String Cast;
    /**
     * Retrieve Movie Cast
     * @return Cast
     * 
     */
    public String getCast(){return this.Cast;}
    /**
     * Setting Movie Cast
     * @param C
     * - Cast Name
     */
    public void setCast(String C){this.Cast = C;}

    private float Orating;
    /**
     * Retrieve Movie Overall Rating
     * @return Orating
     */
    public String getOrating(){return Float.toString(this.Orating);}
    /**
     * Setting Movie Overall Rating
     * @param OR
     * - Overall Rating
     */
    public void setOrating(String OR)
    {   if(OR =="")
            this.Orating = 0;
        else
            this.Orating = Float.valueOf(OR);
    }

    private boolean Display = false;
    /**
     * Check Whether The Movie is On Display
     * @return Display
     * True - False
     */
    public boolean isDisplay(){return this.Display;}
    /**
     * Setting Movie Display ON OR OFF
     * @param D
     * - True - False
     */
    public void onDisplay(Boolean D){this.Display = D;} 

    /**
     * Initialize a Movie Detail for the Movie List 
     * @param TT
     * - Movie Title
     * @param RT
     * - Movie Runtime
     * @param Gen
     * - Movie Genre
     * @param Lan
     * - Movie Language
     * @param moiveR
     * - Movie Rating Type
     * @param Date
     * - Movie Date of Release
     * @param Dirtor
     * - Movie Director
     * @param C
     * - Movie Cast
     * @param sis
     * - Movie Synopsis
     * @param OR
     * - Movie Overall Rating
     */
    public MovieDetail(String TT,String RT,String Gen,String Lan,String moiveR,String Date,String Dirtor,String C, String sis,String OR)
    {   
        this.Title = TT;                    
        this.Runtime = Integer.valueOf(RT);
        this.Genre = Gen;
        this.Language = Lan;
        setMovRtype(moiveR);
        this.Daterelease = Date;
        this.Director = Dirtor;
        this.Cast = C;
        this.Synopsis = sis;
        setOrating(OR);
        //0->8
    }

}
