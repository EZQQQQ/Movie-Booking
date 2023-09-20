package Comment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Sub program file to run Comment Section
 * @author LOWCHINPOH
 * @author NICHOLAS
 * @author LIMCHENGPING
 * @author EZEKIEL
 * @version 1.5
 */
public class ComApp 
{

    private CommmentIO COIO;
    private ArrayList<PersonComment> PClist;

    /**
     *  Initialize  Comment Application
     */
    public ComApp()
    {
        
        COIO = new CommmentIO();
        COIO.CreateFolder();
    }
    
    /**
     *  Display option for User to Select whether to Add Comment or See Comment
     *
     */
    public void ComApp()
    {
        int choice=0;
        do
        {
            System.out.println("|================== Review/Comment ==========================|");
            System.out.println("|  1.Comment on Movie                                        |");
            System.out.println("|  2.See Movie Review                                        |");
            System.out.println("|  3.Exit                                                    |");
            System.out.println("|============================================================|");
            try 
            {
                
                    System.out.printf(" Enter choice : ");
                    Scanner uin = new Scanner(System.in);
                    choice = uin.nextInt();
                    uin.nextLine();

            } catch (InputMismatchException e) {
                continue;
            }
            
            switch(choice)
            {
                case 1: CommentMovie(); break;
                case 2: ReadComment();break;
            }

        }while(choice!=3);
        
    }
    /**
     *  This method is to get user input to comment on a movie
     */

    public void CommentMovie()
    {
        System.out.println("|============================================================|");
        System.out.printf("Enter your name :");
        Scanner sc =new Scanner(System.in);
        String name = sc.nextLine();
        System.out.printf("Enter Movie name :");
        String mname = sc.nextLine();
        double mr;
        while(true)
        {
            try 
            {
                System.out.printf("Enter Rating 0.0->5.0 :");
                Scanner scmr = new Scanner(System.in);
                mr = scmr.nextDouble();
                scmr.nextLine();
                if(mr>=0 && mr<=5)
                    break;
            } catch (InputMismatchException e)
            {
                continue;
            }
        }
        System.out.printf("Enter Comment :");
        String word = sc.nextLine();

        COIO.SaveFile(name, mname,word,mr);
        System.out.println("Thank you for the Comment ");

        System.out.println("|============================================================|");
    }
    /**
     *  This method is to get user input to select view  particular movie comment and review
     */
    public void ReadComment()
    {
        System.out.println("|======================See Comment===========================|");
        System.out.printf("Please Enter the Movie Name:");
        Scanner scrc = new Scanner(System.in);
        String Mname = scrc.nextLine();
        this.PClist = new ArrayList<>();
        this.PClist=COIO.ReadFile(Mname);
        System.out.println("|============================================================|");
        if(this.PClist.size() == 0)
        {
            System.out.println("Empty file");
            return;
        }
        

        Collections.sort(this.PClist, new Comparator<PersonComment>() {

            @Override
            public int compare(PersonComment o1, PersonComment o2) {
                
                return Double.valueOf(o1.getrate()).compareTo(Double.valueOf(o2.getrate()));
            }
            
        });
        Collections.reverse(this.PClist);
        System.out.println("|============================================================|");
        for(int i =0;i<this.PClist.size();i++)
        {
            System.out.println("");
            System.out.println("Name : "+ this.PClist.get(i).getUsername());
            System.out.println("Rate :"+ this.PClist.get(i).getrate());
            System.out.println("Comment :"+ this.PClist.get(i).getComment());
            System.out.println("");
        }
        System.out.println("|============================================================|");


    }   
}
