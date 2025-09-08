package com.cabral._12hr;

import javax.sound.sampled.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        String filepath = "src\\Not Like Us.wav";
        File file = new File(filepath);

        try (Scanner scanner = new Scanner(System.in);
             AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);


            String response = "";

            while(!response.equals("Q")){

                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.println("Enter your choice: ");

                response = scanner.next().toUpperCase();

                switch(response){
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid choice");
                }
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Could not locate file");
        }
        catch (UnsupportedAudioFileException e){
            System.out.println("Audio File Not supported");
        }
        catch(IOException e) {
            System.out.println("Something went wrong");
        }
        catch(LineUnavailableException e){
            System.out.println("Line not available");
        }


    }
}