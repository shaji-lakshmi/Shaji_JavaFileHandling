/*
 This program takes in a text file, in this case a text file containing the lyrics to 
Dua Lupa's lyrics for her song "New Rules", and reads the file, copies the file and counts the lines 
of lyrics in the file. The file also has methods that show how to write into or create new files. The end goal is 
to produce a method that will be able to manipulate the original file contents so that some lyrics are replaced and written 
to a new file with "corrected" lyrics.z  

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
