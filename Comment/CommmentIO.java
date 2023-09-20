package Comment;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * File I/O for Comment Section
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */

public class CommmentIO
{   
    private String SEPARTOR = ";";
    private String currentdir = System.getProperty("user.dir");
    private String filepath = "";
    /**
     * Ensure that MovieComment Folder is Created
     */
    public void CreateFolder()
    {
         this.filepath = this.currentdir + "\\MovieComment";
         File f = new File(this.filepath);
         if(f.mkdir()==true);
    }
    /**
     * This method is to read File from MovieComment Folder
     * @param Moviename 
     * - Input the MovieName for the file to be selected
     * @return All Person Detail regarding the movie
     */
    public ArrayList<PersonComment> ReadFile(String Moviename)
    {   
        ArrayList<PersonComment> temp = new ArrayList<>();
        try 
        {
            File f = new File(this.filepath+"\\"+Moviename+".txt");
            Scanner myreader = new Scanner(f);
            myreader.useDelimiter(SEPARTOR);
            while(myreader.hasNextLine())
            {
                String data = myreader.nextLine();
                if(data =="")
                    continue;
                String token[] = data.split(this.SEPARTOR);
                temp.add(new PersonComment(token[0], token[1], token[2]));
            }
            myreader.close();
        } catch (FileNotFoundException e) 
        {
            System.out.println("File does not exists");
        }
        return temp;
    }
    
    /**
     * Save Comment to respective File base on Movie name
     * @param name
     *  - Customer name
     * @param Moviename
     *  - Movie Name
     * @param comword
     *  - Comment
     * @param Moiverate
     *  - Movie Rating Number
     */
    public void SaveFile(String name,String Moviename,String comword,double Moiverate) 
    {   
        String fname = this.filepath+"\\"+Moviename+".txt";
        File f = new File(fname);
        if(f.exists())
        {
            try
            {
                FileWriter myWriter = new FileWriter(fname,true);
                myWriter.write(name +";"+ Moiverate +";"+ comword+";\n" );
                myWriter.close();
            } 
            catch (IOException e) {
                return;
            }
        }
        else
        {
            try 
            {
                FileWriter myWriter = new FileWriter(fname);
                myWriter.write(name +";"+ Moiverate +";"+ comword+";\n");
                myWriter.close();
            } catch (IOException e) {
                return;
            }
        }
    }

}

