//import scanner to be used
import java.util.Scanner;
import java.io.FilterOutputStream;

import java.io.*;
import java.util.*;

/**
 * User interface for BMR calculator
 *
 * @author (Nikki, Aiden, Omar, and Hari)
 * @version (2022-11-16)
 */

public class Interface implements java.io.Serializable
{
    public static void main(String[] args)
    {
        //new user object, values will automatically be set as default
        User x = new User();

        //choice stores user choice, unit is for printlns and will either have "Imperial" or "metric"
        String choice = null;

        //loop condition for code
        boolean loop;

        //welcome page
        System.out.println("Welcome to the BMR calculator!");

        //ask user for their choice of units to be used
        System.out.println("Please begin by choosing your choice of units:");
        System.out.println("Do you wish to  use metric or imperial units? Enter the letter that corresponds to your choice.");
        System.out.println("A. Imperial");
        System.out.println("B. Metric");

        //force loop condition
        loop = true;
        do
        {
            //if user enters something that breaks a string, then try catch will stop program from crashing
            try
            {
                //set user choice
                choice = new Scanner(System.in).nextLine();

                //executes if program does not crash and user enters a string compatible value
                //checks if whatever user entered corresponds to the choices listed, if it does, exit loop, if it doesnt, loop again
                if (choice.equalsIgnoreCase("A") || choice.equalsIgnoreCase("B")) loop = false;
                else System.out.println("Please enter a proper choice. (A or B)");
            }
            //catch error
            catch (Exception e)
            {
                //tell user to enter a proper value
                System.out.println("Please enter a proper choice. (A or B)");
            }
        }
        while (loop);

        //switch statement assigns users choice of units to instance variable
        //to upper case so i dont need to write 2 more cases for lowercase
        //sets unit string to corresponding unit that the user chose
        switch(choice.toUpperCase())
        {
            case "A": x.metric = false; break;
            case "B": x.metric = true; break;
        }

        //forces loop condition
        loop = true;

        //ask user for weight in either kg or pounds depending on what user chose as their unit
        //if user chose metric, output message for kilograms
        if (x.metric) System.out.println("Please enter your weight in kilograms:");

        //if user chose imperial, output message for pounds
        else System.out.println("Please enter your weight in pounds:");

        do
        {
            //if user enters something that breaks, then try catch will stop program from crashing
            try
            {
                //assign user weight to instance variable
                if (x.metric)
                    x.weight = new Scanner(System.in).nextFloat();
                else
                {
                    x.weight = User.lbsToKg(new Scanner(System.in).nextFloat());
                }

                //if program does not crash, then check if weight is above 0, else, loop again
                if (x.weight > 0) loop = false;
                else System.out.println("Please enter a value greater than 0");
            }

            //catch error if program will crash
            catch (Exception e)
            {
                //tell user to enter a proper weight if program crashes
                System.out.println("Please enter a proper weight.");
            }
        }
        while (loop);

        //forces loop condition
        loop = true;

        //ask user for target weight
        //ask user for weight in either kg or pounds depending on what user chose as their unit
        //if user chose metric, output message for kilograms
        if (x.metric) System.out.println("Please enter your target weight in kilograms:");

        //if user chose imperial, output message for pounds
        else System.out.println("Please enter your target weight in pounds:");

        do
        {
            //if user enters something that breaks, then try catch will stop program from crashing
            try
            {
                //assign user target weight to instance variable
                if (x.metric)
                    x.target = new Scanner(System.in).nextFloat();
                else
                {
                    x.target = User.lbsToKg(new Scanner(System.in).nextFloat());
                }

                //if program does not crash, then check if weight is above 0, else, loop again
                if (x.target > 0) loop = false;
                else System.out.println("Please enter a value greater than 0");
            }

            //stop program from crashing
            catch (Exception e)
            {
                //tell user to enter a proper weight
                System.out.println("Please enter a proper weight.");
            }
        }
        while (loop);

        //forces loop
        loop = true;
        //ask user for target amount of days
        System.out.println("Please enter your target amount of days:");
        do
        {
            try
            {
                //assign user value to instance variable
                x.days = new Scanner(System.in).nextInt();

                //if program does not crash, then check if day is greater than 0, else, loop again
                if (x.days > 0) loop = false;
                else System.out.println("Please enter a value greater than 0");
            }

            //catch error
            catch (Exception e)
            {
                //tell user to enter proper value
                System.out.println("Please enter a proper target amount of days.");
            }
        }
        while (loop);

        //force loop
        loop = true;

        //ask user for height
        //ask user for height in either inches or cm depending on what user chose as their unit
        //if user chose metric, output message for cm
        if (x.metric) System.out.println("Please enter your height in centimeters:");

        //if user chose imperial, output message for inches
        else System.out.println("Please enter your height in inches:");

        do
        {
            try
            {
                //assign user value to instance variable
                if (x.metric)
                    x.height = new Scanner(System.in).nextFloat();
                else
                {
                    x.height = User.inchToCm(new Scanner(System.in).nextFloat());
                }

                //if program does not crash, then check if day is greater than 0, else, loop again
                if (x.height > 0) loop = false;
                else System.out.println("Please enter a value greater than 0");
            }
            //catch error
            catch (Exception e)
            {
                //tell user to enter proper value
                System.out.println("Please enter a proper height.");
            }
        }
        while (loop);

        //force loop
        loop = true;
        //ask for age
        System.out.println("Please enter your age:");
        do
        {
            try
            {
                //assign user value to instance varialbe
                x.age = new Scanner(System.in).nextInt();

                //if program does not crash, then check if day is greater than 0, else, loop again
                if (x.age > 0) loop = false;
                else System.out.println("Please enter a value greater than 0");
            }
            catch (Exception e)
            {
                //tell user to enter proper value
                System.out.println("Please enter a proper age.");
            }
        }
        while (loop);

        //force loop
        loop = true;
        //ask for sex from user
        System.out.println("Please enter your sex:");
        System.out.println("A. Male");
        System.out.println("B. Female");
        do
        {
            try
            {
                //assign user choice
                choice = new Scanner(System.in).nextLine();

                //executes if program does not crash and user enters a string compatible value
                //checks if whatever user entered corresponds to the choices listed, if it does, exit loop, if it doesnt, loop again
                if (choice.equalsIgnoreCase("A") || choice.equalsIgnoreCase("B")) loop = false;
                else System.out.println("Please enter a proper choice. (A or B)");
            }
            catch (Exception e)
            {
                //tell user to enter a proper choice
                System.out.println("Please enter a proper sex. (A or B)");
            }
        }
        while (loop);

        //switch statement assigns users choice of units to instance variable
        //to upper case so i dont need to write 2 more cases for lowercase
        switch(choice.toUpperCase())
        {
            case "A": x.male = true; break;
            case "B": x.male = false; break;
        }

        //force loop
        loop = true;
        //ask for sex from user
        System.out.println("Please enter your goal:");
        System.out.println("A. Lose Weight");
        System.out.println("B. Gain Weight");
        System.out.println("C. Maintain Current Weight");
        do
        {
            try
            {
                //assign user choice
                choice = new Scanner(System.in).nextLine();

                //executes if program does not crash and user enters a string compatible value
                //checks if whatever user entered corresponds to the choices listed, if it does, exit loop, if it doesnt, loop again
                if (choice.equalsIgnoreCase("A") || choice.equalsIgnoreCase("B") || choice.equalsIgnoreCase("C")) loop = false;
                else System.out.println("Please enter a proper choice. (A, B, or C)");
            }
            catch (Exception e)
            {
                //tell user to enter a proper choice
                System.out.println("Please enter a proper sex. (A, B, or C");
            }
        }
        while (loop);

        //switch statement assigns users choice of units to instance variable
        //to upper case so i dont need to write 2 more cases for lowercase
        switch(choice.toUpperCase())
        {
            case "A": x.goal = "lose"; break;
            case "B": x.goal = "gain"; break;
            case "C": x.goal = "maintain"; break;
        }

        //setting leftover instance variables 
        x.calcBMR();
        x.eat();

        System.out.println(x + "\n\nLook for a file called \"MyGoal.txt\" on your pc for a copy of this");

        try {
            ObjectOutputStream out;
            
            out = new ObjectOutputStream(new FileOutputStream("myGoal.txt"));
            out.writeObject(x);
            out.close();
        }
        catch (FileNotFoundException e) 
        {
            System.out.println("Error: Cannot open file for writing");
        }
        catch (IOException e) 
        {
            System.out.println("Error: Cannot write to file");
        }

    }
}