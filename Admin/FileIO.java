package Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

/**
 * File I/O for Admin
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class FileIO 
{
    private String inputfilelocation;
    private String outputfilelocation;
    /**
     * Retrieve File Path name
     * @return inputfilelocation
     * - File Path name
     */
    public String getFLocation(){return this.inputfilelocation;}
    private String SEPARTOR = ";";
    private JFileChooser filechoose;
    
    /**
     * Interface for User to Select File Location 
     */
    public void selectFile()
    {
        this.filechoose = new JFileChooser();
        filechoose.setDialogTitle("Open File");
        filechoose.setFileFilter(new FileFilter() 
        {

            @Override
            public boolean accept(File f) 
            {
                if(f.isDirectory())
                    return true;
                else
                {
                    String filename = f.getName().toLowerCase();
                    return filename.endsWith(".csv") || filename.endsWith(".txt") ;
                }
            }
            @Override
            public String getDescription() {
               return "Text File (*.csv,*.txt)";
            }
        }
        );
        int status = filechoose.showOpenDialog(null); // Select file to open
        if(status ==0) // 0: Really selected a file     1: Not selected a file
        {
            this.inputfilelocation = filechoose.getSelectedFile().getAbsolutePath();
        }
    }
    /**
     * Read File to get all Movie Detail to the List
     * @param filelocation
     *  - File Path name
     * @return MList
     * - Movie List
     */
    public ArrayList<MovieDetail> readFile(String filelocation)
    {   
        int count = 1;
        try 
        {
            File fileread = new File(filelocation);
            Scanner reader = new Scanner(fileread);
            ArrayList<MovieDetail> temp = new ArrayList<>();
            reader.useDelimiter(SEPARTOR);
            while(reader.hasNextLine())
            {   
                String data = reader.nextLine();
                if(data =="")
                    continue;
                if(count != 1)
                {
                    String[] token = data.split(this.SEPARTOR);
                   
                    temp.add(new MovieDetail(token[0].trim(), token[1].trim(), token[2].trim(), token[3].trim(), token[4].trim(), token[5].trim(), token[6].trim(), token[7].trim(), token[8].trim(),token[9].trim()));
               }
               count++;
            }
            reader.close();
            return temp;
        } 
        catch (FileNotFoundException e) 
        {
            System.out.println("Error occured");
        }
        return null;
    }
  /**
   * Save Movie List to A File
   * @param Mlist
   *  - Movie List
   * @return - Success or Failure
   * 
   */
    public int saveFile(ArrayList<MovieDetail> Mlist)
    {   
        if(Mlist.size()==0)
        {
            System.out.println("No Movie on the list to be save ");
            return 0;
        }
        this.filechoose = new JFileChooser();
        filechoose.setDialogTitle("Save File");
        filechoose.setFileFilter(new FileFilter() 
        {
            @Override
            public boolean accept(File f) 
            {
                if(f.isDirectory())
                    return true;
                else
                {
                    String filename = f.getName().toLowerCase();
                    return filename.endsWith(".txt") ;
                }
            }
            @Override
            public String getDescription() {
               return "Save in Text File(*.txt)";
            }
        }
        );
        
        int status = filechoose.showSaveDialog(null); // Select file to open
        if(status == 0 ) // 0: Really selected a file     1: Not selected a file
        {
            this.outputfilelocation = filechoose.getSelectedFile().getAbsolutePath() + ".txt";
           try 
           {
                FileWriter myWriter = new FileWriter(this.outputfilelocation);
                myWriter.write("Title;Runtime;Genre;Language;MovieRating;ReleaseDate;Director;Cast;Synopsis;OverallRating;\n");
                for(int i=0;i<Mlist.size();i++)
                {
                    myWriter.write(Mlist.get(i).getTitle()+";");
                    myWriter.write(Mlist.get(i).getRuntime()+";");
                    myWriter.write(Mlist.get(i).getGenre()+";");
                    myWriter.write(Mlist.get(i).getLanguage()+";");
                    myWriter.write(Mlist.get(i).getMovRType()+";");
                    myWriter.write(Mlist.get(i).getDateRelease()+";");
                    myWriter.write(Mlist.get(i).getDirector()+";");
                    myWriter.write(Mlist.get(i).getCast()+";");
                    myWriter.write(Mlist.get(i).getSynopsis()+";");
                    myWriter.write(Mlist.get(i).getOrating()+";\n");
                }
                myWriter.close();
           } catch (IOException e) {
            System.out.println("An error occurred.");
            return 0;
            }
        }
        return 1;
        }
    }

