package Customer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.Scanner;

import Customer.Price.PriceApp;

/**
 * File I/O for Customer 
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class CustFileIO 
{   
    private String currentdir = System.getProperty("user.dir");
    private String filepath = "";
    private int count=0;
    
    /**
     * Ensure that Receipt Folder is Created
     */
    public void CreateFolder()
    {
        this.filepath = this.currentdir + "\\Receipt";
         File f = new File(this.filepath);
         if(f.mkdir()==true);
    }
    /**
     * 
     * Read File Base on FileRecepit name given in Booking 
     * @param name
     * - File Recepit name
     */
    public void ReadFile(String name)
    {   
        try 
        {
            File f = new File(this.filepath+"\\"+name);
            Scanner myreader = new Scanner(f);
            while(myreader.hasNextLine())
            {
                System.out.println(myreader.nextLine());
            }
            myreader.close();
        } catch (FileNotFoundException e) 
        {
            System.out.println("File does not exists");
        }
    }
    /**
     * Save Customer Booking Detail to a no type file at Recepit Folder
     * @param custname
     * 	- Customer name
     * @param moviename
     *  - Movie Name
     * @param seatid
     *  - Seat Number
     * @param pa
     *  - Item Price
     * @param emil
     *  - Email Address
     * @param phonen
     *  - Phone Number
     * @param roomnum
     *  - Room Number
     * @param c
     *  - Data and Time 
     */
    public void SaveFile(String custname,String moviename,String seatid,PriceApp pa,String emil,String phonen,int roomnum,Calendar c) 
    {   
        File f = new File(this.filepath+"\\"+custname);
        if(f.exists())
        {
            this.count++;
            SaveFile(custname+this.count, moviename, seatid, pa,emil,phonen,roomnum,c);
        }
        else
        {   
            try 
            {
                FileWriter myWriter = new FileWriter(this.currentdir+"\\Receipt\\"+custname);
                myWriter.write("Customer Name   : "+custname+"\n");
                myWriter.write("Email Address   : "+emil+"\n");
                myWriter.write("Phone Number    : "+phonen+"\n");
                myWriter.write("Room Number     : "+roomnum+"\n");
                myWriter.write("Moive Name      : "+moviename+"\n");
                myWriter.write("Seat Number     : "+seatid+"\n");
                myWriter.write(pa.PrintListOfItem(false));
                myWriter.write(c.getTime().toString());
                myWriter.close();
            } catch (IOException e) {
                return;
            }
            System.out.println("FileReceipt : "+custname);          
         }
        }

}

