/*
File Handling Project
by Lakshmi Shaji

This project utilizes the FileReader and FileWriter classes in Java to tackle file handling tasks.
The program takes in a text file, in this case a text file containing the lyrics to Dua Lupa's lyrics for her song 
"New Rules", and carries out various tasks that allow a user to do the following tasks: 

1. Read the contents of the file. 
2. Create a new file and write some contents into the file. 
3. Get some property or aspect of the file using java method. (In this project, the number of lines in the file). 
4. Copy the contents of the original file to another file. 
5. Manipulate the data in the file to overwirte the content and create new "corrected file". 


In this project, the corrected file includes the removal of dialectal variations and chosen contractions and replacing them with words shown below. Finally, the corrected lyrics are sent to a newly created file. 

Corrections to look for based on changes made in the manipulateFile method: 

talkin' --> talking 
makin' --> making 
hopin' --> hoping 
pushin' --> pushing 
pullin' --> pulling
ain't --> are not 
One --> 1
Two --> 2
Three --> 3
'em --> them  
I've --> I have 
Don't --> Do not


 */
package read_write;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lakshmishaji
 */
public class Read_write {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    
    //This method simply read the contents of the file and display them on the console.
    public static void readFile(String fileName) throws IOException {
        String lyric;
        try {
            FileReader getLyrics = new FileReader(fileName);
            BufferedReader buffGetLyrics = new BufferedReader(getLyrics);
            while ((lyric = buffGetLyrics.readLine()) != null) {
                System.out.println(lyric);

            }
            buffGetLyrics.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File was not found. Please verify the file exists.");
        }
    }

    //This method will write a pre-defined string into a newly created file. 
    public static void writeFile(String fileContent, String createFileName) {
        try {

            FileWriter intoFile = new FileWriter(createFileName);
            BufferedWriter buffIntoFile = new BufferedWriter(intoFile);

            buffIntoFile.write(fileContent);
            System.out.println(" New file has been written. "
                    + "\n Name: myWords.txt"
                    + "\n Please find it in the project folder.");
            buffIntoFile.flush();
            buffIntoFile.close();
        } catch (IOException e) {
            System.out.println("Cannot write to file at the moment.");
        }
    }

    /*This method will count the number of lines that are in the file based on the filename passed in as a parameter. 
    NOTE: This method does count spaces between lines as lines. 
    */
    public static void countLinesInFile(String filename) {
        try {
            File songLyrics = new File(filename);
            Scanner getLines = new Scanner(songLyrics);
            int count = 0;

            while (getLines.hasNext()) {
                getLines.nextLine();
                count++;
            }
            getLines.close();

            System.out.println(count);

        } catch (FileNotFoundException ex) {
            System.out.println("File was not found. Please verify the file exists.");
        }

    }
    
// This method will copy the contents of a file that is passed in to a newly created text file. 
    public static void copyFile(String fileName, String copyFileName) throws IOException {

        try {
            File originalLyrics = new File(fileName);
            Scanner getLyrics = new Scanner(originalLyrics);
            String lyricLine = "";
            while (getLyrics.hasNext()) {
                lyricLine += "\n" + getLyrics.nextLine();
                FileWriter copyMyFile = new FileWriter(copyFileName);
                copyMyFile.write(lyricLine);
                copyMyFile.flush();
                copyMyFile.close();
            }

            System.out.println(" Copy file has been written. \n"
                    + " Name: NewRules_lyrics_copy.txt \n"
                    + " Please find it in the project folder.");
                    getLyrics.close();

        } catch (FileNotFoundException ex) {
            System.out.println("File was not found. Please verify the file exists.");
        }
    }

//This method will manipulate the original file contnets based on the implemented rules and write the new data into a newly created file. 
    public static void manipulateFile(String fileName, String correctedFile) throws FileNotFoundException, IOException {

            File originalLyrics = new File(fileName); 
            Scanner getContent = new Scanner(originalLyrics);
            String lyrics =""; 
            String correctedLyrics =""; 
            List <String> contents = new ArrayList <String>(); 
            
            while(getContent.hasNext()){
                lyrics = getContent.next(); 
                contents.add(lyrics); 
            }
            getContent.close();
            
            String [] lyricArray = contents.toArray(new String[0]); 
            
            for(String s: lyricArray){
               if(s.equalsIgnoreCase("one,")){
                   s="1,"; 
               }else if(s.equalsIgnoreCase("one")){
                   s="1"; 
               }else if(s.equalsIgnoreCase("two,")){
                   s="2,"; 
               }else if (s.equalsIgnoreCase("three,")){
                   s="3,"; 
               }else if(s.equalsIgnoreCase("talkin\'")){
                   s="Talking";
               }else if(s.equalsIgnoreCase("makin\'")){
                   s= "Making";
               }else if(s.equalsIgnoreCase("hopin\'")){
                   s="Hoping"; 
               }else if(s.equalsIgnoreCase("pushin\'")){
                   s="Pushing";
               }else if(s.equalsIgnoreCase("pullin\'")){
                   s="Pulling";
               }else if(s.equalsIgnoreCase("ain\'t")){
                   s="are not";
               }else if(s.equalsIgnoreCase("\'em")){
                   s="them";
               }else if (s.equalsIgnoreCase("\'em)")){
                   s="them)";
               }else if(s.equalsIgnoreCase("I\'ve")){
                   s="I have"; 
               }else if(s.equalsIgnoreCase("don\'t")){
                   s="Do not";
               }                                                                                                                                                                                                                                                                                                                                                                     
                   correctedLyrics += " " + s; 
                   
            }
            FileWriter correcter = new FileWriter(correctedFile);
                correcter.write(correctedLyrics);
                correcter.flush();
                correcter.close();
            System.out.println(" Corrected file has been written. \n"
                    + " Name: NewRules_lyrics_corrected.txt \n"
                    + " Please find it in the project folder.");
            
    }
  

    public static void main(String[] args) throws IOException {
        String fileName = "NewRules_lyrics.txt";
        String fileContent = " These are my words and I want them in this document."
                + "\n This is my attempt to create a file through Java code. "
                + "\n -Lakshmi Shaji";
        String createFileName = "myWords.txt"; 
        String copyFileName = "NewRules_lyrics_copy.txt";
        String correctedFile = "NewRules_lyrics_corrected.txt";
        
        //readFile(fileName); 
        //writeFile(fileContent,createFileName); 
        //System.out.println("Number of lines in the original lyrics text file: ");
        //countLinesInFile(fileName);
        //copyFile(fileName, copyFileName);
        //System.out.println("Number of lines in the copy of lyrics text file: ");
        //countLinesInFile(copyFileName); 
        //manipulateFile(fileName, correctedFile); 
    }
}
