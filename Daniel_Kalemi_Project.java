/*
 *                                               ~ This PROGRAM is part of the final project in CS 105 ~
 * SUBJECT: CS-105: Introduction to Programming I
 * TITLE: FINAL PROJECT- 7 MENU OPTION
 * AUTHOR: DANIEL KALEMI
 * DATE: 27/11/2017   (ACADEMIC YEAR 2017-2018- FALL SEMESTER)
 * 
 * DESCRIPTION: This program displays to the user 7 menu options, each of them calculating & presenting different exercieses
 * Menu Option 1:  This option Calculates and displays the Sum, Product, Variability and Standard Deviation from 6 integers that the user has inputed.
 * Menu Option 2:  This option Calculates and displays the factorial of the integer closest to the group's average of the 5 user-input numbers.
 * Menu Option 3:  This option Calculates the Sum, Product, Variability and Standard Deviation of all the prime numbers between 0 and 30.
 * Menu Option 4:  This option Asks the user to guess a random number between 0 and 100.
 * Menu Option 5:  This option Displays 7 unique Pythagorean Triples from within the limit of 120.
 * Menu Option 6:  This option Calculates all betrothed number integer pairs between 0 and 10000.
 * Menu Option 7:  Exit the program.
 * 
 * THIS CODE USES A DO-WHILE LOOP TO REPEAT THE PROGRAMS UNTIL USERS PRESS 7 FOR EXIT
 * ALSO IN THIS CODE YOU CAN SEE THAT THE MENU OPTION IS BUILT BASED ON IF-ELSE STATEMENTS
 * THE EXCERCIESES HAD DIFFERENT WAYS TO SOLVE THEM, BUT I TRIED TO COMBINE THEM, FROM THE LONGEST WAYS, TO ARRAYS AND ALSO A METHOD IMPLEMENTED IN THE SIXTH OPTION.
 * 
 * @author Daniel Kalemi kalemi.daniel@gmail.com
 *  Licensed under the GNU public license open source agreement.
 * 
 */

import java.io.*;         // Importing all the commands of the io Java package
import java.util.Random;  //Importing the Random command from the util Java package in order to generate random numbers (option 4).

public class Daniel_Kalemi_Project 
{
    public static void main(String[] args) throws IOException // Declares that an error (exception) may occur
    {
        // Prepare for input
        InputStreamReader isr = new InputStreamReader(System.in); // Variable (object) reading the keystrokes
        BufferedReader br = new BufferedReader(isr);              // Variable (object) transalting the input stream
        String inData;                                            // Text variable to receive the user's input

        // Declare Variables (FOR THE ELSE-IF STATEMENTS THAT BUILD THE MENU OPTION).
        int choice=-1;     

        // PROGRAM STARTS HERE!
        // Before starting let's CREATE blank lines to "clear" the console window.
        System.out.print("\n");

        // Now let's display a MENU OPTION to the user
        do {
            System.out.println("\t\t\t\t\t\tThank you for trying out my newest program. I bet you will love it!");    
            System.out.println("\t\t\t\t\t\t\t\t ~ Enter one of the following commands: ~");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("*Menu Option 1 - Playing with numbers*");
            System.out.println("*Menu Option 2 - Factorial of the integer*");
            System.out.println("*Menu Option 3 - Prime numbers*");
            System.out.println("*Menu Option 4 - Random Integer*");
            System.out.println("*Menu Option 5 - Pythagorean triples*");
            System.out.println("*Menu Option 6 - Betrothed Number*");
            System.out.println("*Menu Option 7 - Exit the program*");
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println();
            System.out.println("~ Enter \"1\", \"2\", \"3\", \"4\", \"5\", \"6\" or \"7\" ~");
            inData = br.readLine(); // Reads the user's input and stores it in variable 'inData'                
            choice = Integer.parseInt(inData);

            if (choice < 1 || choice > 7) {
                System.out.println();
                System.out.println("** Invalid entry. Please enter \"1\", \"2\", \"3\", \"4\", \"5\", \"6\" or \"7\" **");
                inData = br.readLine(); // Reads the user's input and stores it in variable 'inData'                
                choice = Integer.parseInt(inData);
            }
            // CALCULATIONS WITH THE SIX USER-INPUT INTEGERS 
            else if(choice == 1) 
            {
                System.out.print("\n");
                System.out.print("\t\t\t\t\t\tThank you for choosing to stay with the program! You have chosen option 1!\n");
                System.out.print("\t\t\t\t\t\t\t\t ~ PLAYING WITH NUMBERS ~\n");
                System.out.print("The rules are simple! You just enter 6 numbers and the rest it's up to this program. ENJOY!\n");

                //Declaring Variables               
                int [] userNum= new int [6];  //Since we are asked to have 6 input user numbers
                int times=0;
                int total=0;
                double average=0;
                int product=1;  //Starting from 1 and not 0 just to not stuck multiplying with 0
                double variability=0;
                double standard_deviation=0;
                // FOR-LOOP FOR GENERATING CALCULATIONS OF SUM, PRODUCT TO BE USED FURTHER IN THE CODE
                for (int i = 0; i < 6; i++)
                {
                    times++;                //Counter that is used at the System.out to show which number to display to the user
                    System.out.print("--> Please enter number " + times + "\n");
                    inData = br.readLine(); // Reads the user's input and stores it in variable 'inData'        
                    userNum[i] = Integer.parseInt(inData);
                    total += userNum[i]; //Calculate the sum
                    product*=userNum[i];  //Calculate the product
                }
                // Calculate the average
                average = total / 6.0;    // INTEGER DIVIDED BY A DOUBLE --> STORED AS DOUBLE
                for (int i = 0; i < 6; i++)
                {// VARIABILITY
                    variability+= ( userNum[i] - average )*( userNum[i] - average ); //This piece code calculates the nominator of the variability equation
                }
                variability = variability /(userNum.length-1) ;             //The result that we got from the for-loop append to the denominator calculation
                // STANDARD DEVIATION
                standard_deviation = Math.sqrt(variability);            //The standard deviation it's nothing, but the square root of the variance (variability)

                System.out.println("The total sum of your 6 inputed numbers is: "+total);          // THIS IS THE OUTPUT SECTION
                System.out.println("The product of those 6 numbers is: "+product);               //WHERE THE USER ACTUALLY SEES THE CALCULATION RESULTS
                System.out.println("The variability of 6 numbers is: "+variability);
                System.out.println("The standard deviation of 6 numbers is: "+standard_deviation);
                System.out.println("*************************** FINISHED WITH THE 1st OPTION*************************");
            }    // END OF OPTION 1

            //LET'S START WITH OPTION 2
            else if(choice == 2) 
            {   
                System.out.print("\n");
                System.out.print("Good choice! You have chosen option 2!\n\n");
                System.out.print("\t\t\t\t\t\t\t~ FACTORIAL OF THE INTEGER (group's average) ~\n");
                System.out.print("You have to enter 5 numbers from 0-20 and then the program displays the factorial of the integer nearest to the group's average\n");
                System.out.println("Factorial is a mathematical concept that calculates recursively (from smaller to bigger and vice versa)a value of a number."); 
                //Declare and initialize at the same time the variables
                int number=0;
                double factorial=0;
                int sum=0;
                int count=0;
                double average=0;

                //Program starts here
                while(count<5)
                { 
                    System.out.println("--> Please 5 numbers between 0 and 20: ");
                    inData = br.readLine(); // Reads the user's input and stores it in variable 'inData'
                    number = Integer.parseInt(inData);
                    // ERROR TRAPPING
                    if(number<0 || number>20) 
                        System.out.println("Oh come on I know you can do better! Just stick with the rule's game\n.");
                    else
                    {
                        sum=sum+number;
                        average=sum/5.0;  //HERE WE DON'T NEED TO WORRY ABOUT ANY ERROR TRAPPING IN AVERAGE SINCE IT WOULD BE ALWAYS >0.
                        count++; 
                    }
                    average=Math.round(average);  //APPLYING THE ROUNDING COMMAND TO THE AVERAGE
                    factorial=(int)average;       //CASTING THE AVERAGE INTO AN INTEGER (AS ASKED IN THE EXERCIESE)
                    for(double i =(average - 1); i >1; i--)                     
                        factorial = factorial * i;            //ALL THE NUMBERS KEEP MULTIPLY BY DECREASING UP TO 1                                                              
                }                                             // GIVES US THE RECURSIVE FEELING
                System.out.println("The factorial (x!) of that integer closest to the group's average is: " + (int)factorial);
                System.out.println("*************************** FINISHED WITH THE 2nd OPTION*************************");
            }// END OF OPTION 2

            // LET'S START WITH OPTION 3
            else if(choice == 3) 
            {
                //Initializing and declaring Variables
                int primeArray[]= new int[30];   //Initializing an array where the primes will be saved

                double productPrime=1;
                double sumPrime=0;
                double average_of_prime=0;
                double variabilityPrime=0;
                double standard_dev=0;
                int filter=0;         //variable that keep track on the number of the integers that "pass" the modulus division testing
                int position=0;
                System.out.print("ALL THE PRIMES FROM 1-30 ARE: \n");
                //PROGRAM STARTS HERE!!
                for(int prime=2;prime<30;prime++)      //starting from 2 counting since 0,1 satisfy the upcoming conditions but they aren't primes
                {
                    for(int divisors= prime;divisors>1;divisors--) // if using nested loops, for-loops are the best option since are more compact and have all the components at the header
                    {
                        if(prime%divisors==0)       //Modulus divide of all the numbers up to 30 (presented by variable 'prime')   
                            filter++;   //Increases each time we find a divisor of the number we take in consideration
                    
                    }
                    if(filter<2)      //THIS TIME THE FILTER NEEDS TO BE LESS THAN 2 BECAUSE WE START COUNTING FROM 2 (AND NOT 1)
                    {
                        System.out.println(prime);
                        primeArray[position]=prime;
                        position++;
                    }      
                   filter=0;  // we refresh it's value every time the process of checking ends
                }
                
                for(int i=0;i<30;i++)
                {
                    if(primeArray[i]!=0)
                    { 
                        sumPrime+=primeArray[i];
                        productPrime*=primeArray[i];
                                                    //counting shows the max size of the array (how many primes)
                    }
                }
                average_of_prime=sumPrime/10.0;
                for(int i=0;i<30;i++){
                    if(primeArray[i]!=0)   
                        variabilityPrime+=(primeArray[i]-average_of_prime)*(primeArray[i]-average_of_prime);
                }
                variabilityPrime=variabilityPrime/9.0;  
                standard_dev = Math.sqrt(variabilityPrime); // standard  deviation is variability in square root

                System.out.println(" The sum of the prime numbers(0-30) is : " +sumPrime); 
                System.out.println(" The product of the prime numbers (0-30) is : " +productPrime); 
                System.out.println(" The average of the prime numbers (0-30) is : " +average_of_prime);  
                System.out.println(" The variability of the prime numbers (0-30) is : " +variabilityPrime); 
                System.out.println(" The standard deviation of the prime numbers (0-30) is : " +standard_dev);
                System.out.println("*************************** FINISHED WITH THE 3rd OPTION*************************"); 
            } //END OF OPTION 3!

            //LET'S START WITH OPTION 4
            else if(choice == 4) 
            {
                //..do something else
                System.out.print("\n");
                System.out.print("You have chosen option 4! (GUESSING NUMBER GAME)\n\n");
                System.out.print("In this program you need to find the special guessing number from 0-100 \n\n");
                System.out.print("If you manage to do so, the program will show hom you many attempts you had\n\n");
                System.out.print("GOOD LUCK!!!\n\n");            

                // Declare Variables
                int randomNum, lowLimit, upLimit, range,times, user;
                // Initialize all numerical variables to 0 & coresponding limits
                randomNum=range=times=0;
                lowLimit=0;upLimit=100; user=0;

                // Declare our random number generator (new object called "random")
                Random random = new Random();

                // PROGRAM STARTS HERE!
                System.out.println();

                range = (int)(upLimit - lowLimit + 1);                            // CASTING SINCE RANDOMS ARE FROM 0-99.99...
                randomNum =  ((int)(range * random.nextDouble()) + lowLimit);  //GENERATING RANDOMS FROM THE HIGHEST TO THE LOWEST LIMITS ASKED

                while(user != randomNum)
                {
                    System.out.print("Please enter a guessing number (from 0-100): ");
                    inData = br.readLine();                                 //USER INPUT
                    user = Integer.parseInt(inData);	
                    if (user<lowLimit || user>upLimit)
                    {
                        System.out.println("You don't like rules I guess!Please put numbers from 0-100: ");        //USER HINT! (FEEDBACK)
                        times++;
                    }
                    else if (user> randomNum)
                    {
                        System.out.println("\n Your guess is higher than the actual value, plese try again:\t" );  //USER HINT! (FEEDBACK)
                        times++;
                    }
                    else
                    {
                        System.out.println("\n Your guess is lower than the actual value, plese try again:\t" );   //USER HINT! (FEEDBACK)
                        times++;
                    }    
                }
                times++;  //All the attempts that the user has done to find the number are accumulated in the variable "times".
                System.out.println("You definitely found it!");
                System.out.println("Number of times you guessed is: "+times);    //THE OUTPUT SECTION
                System.out.println("*************************** FINISHED WITH THE 4th OPTION*************************");             
            } //END OF OPTION 4

            // LET'S START WITH OPTION 5
            else if(choice == 5) 
            {   
                System.out.print("\n");
                System.out.print("HI AGAIN!!! You have chosen option 5!\n\n");
                System.out.print("\t\t\t\t\t\t\t\t\t ~ PYTHAGOREAN TRIPLES ~ \n");
                System.out.print("I bet this will be a new academic information for you!\n\n");
                System.out.println("These 7 combinations of numbers are Pythagorean triples less than 120: ");
                //ALL THE VARIABLES ARE INITIALIZED AND DECLARED WITHIN THE FOR NESTED LOOPS
                for (int cathetusA = 1; cathetusA <= 120; cathetusA++) // searches for all the values up to 120 for the smallest cathetus in the right triangle 'a'
                {
                    for (int cathetusB = 1; cathetusB <=120; cathetusB++) //searches for all the values up to 120 for the biggest cathetus in the right triangle 'b'
                    {
                        for (int c = 1; c <=120; c++) //searches for all the values up to 120 for the hypothenuse in the right triangle 'c'
                        {
                            if ((cathetusA * cathetusA) + (cathetusB * cathetusB) == (c * c))  // Pythagorean Theorem as an if statement
                            {
                                if(cathetusB + 1 == c)                 //To find those pairs a needs to be an odd number
                                    System.out.print("\t\t" + cathetusA + ", " + cathetusB + ", " + c); // b needs to be as (a-1)^2/2 ~ oyu get it from the theorem statement

                                if(cathetusB + 1 == c)                                          // c needs to be one more than b
                                    System.out.println("   The dublicate of that triple is: ("+ cathetusB + ", " + cathetusA + ", " + c + ")"); // Here since we find the dublicates

                            }     //WE SWIPE THE VALUES OF 'a' WITH 'b' AND WE KEEP 'c' AS IT IS. --> to find the duplicates
                        }
                    }
                } System.out.println("*************************** FINISHED WITH THE 5th OPTION*************************");
            }// END OF OPTION 5

            // LET'S START WITH OPTION 6
            else if(choice == 6) 
            {              
                System.out.print("\n");
                System.out.print("You have chosen option 6!\n\n");
                System.out.println("\t\t\t\t\t\t\t\t ~ Betrothed numbers (Quasi-Amicable pairs) ~ ");
                System.out.println("The list of all the 6 unique calculated betrothed integer pairs are: ");
                for(int i=1;i<=10000;i++)         //The option loops for all the values within the range 0-10000
                {
                    int y = sum(i);               //Using the sum of divisors method for each of the integers in the range
                    if((i+1==sum(y-1))&& (y-1)>i && (y-1)<10000)   //Each time it satisfies the conditions for both values in the pair
                        System.out.println(i+","+(y-1));          // They are displayed in the output section
                } System.out.println("*************************** FINISHED WITH THE 6th OPTION*************************");
            } //END OF OPTION 6

            // LET'S START WITH OPTION 7 (EXITING THE MENU OPTION).
            else if(choice == 7) 
            {               
                System.out.print("\n");
                System.out.print("You have chosen option 7.\n\n");                    //THE VERY LAST OUTPUT OFFERED TO THE USER WHEN CLICKING OPTION 7               
                System.out.print("OH NO! WITHOUT ACKNOWLEDGING it, WE HAVE REACHED AT THE VERY END! :-( ");
                System.out.println("\t\t\t\t ***Thank you so much for your time and willingness for giving it a shot!***\n");
                System.out.print("For any questions feel free to contact me at the credentials attached at the header...BYE BYE!!!\n");
            }   // END OF THE OPTION 7
        }      // END OF DO-WHILE LOOP. INDEED THE WHOLE MENU OPTION
        while (choice != 7);
    }        //END OF MAIN METHOD

    // METHOD FOR FINDING THE SUM OF ALL THE DIVIVIORS OF A NUMBER (AT CASE 6)
    public static int sum(int num)
    {
        int sum_of_Div=0;
        for(int divisors6=1; divisors6<num; divisors6++)    //RUNS FROM 1-THE NUMBER THAT WE INPUT
        {
            if(num%divisors6==0)          //CHECKS IF ALL THE NUMBERS FROM THE RANGE 1 TO N ARE DIVISORS OF num
                sum_of_Div+=divisors6;           // IF SO THEY ARE ADDED TO THE SUM OF DIVISORS VARIABLE
        }
        return sum_of_Div;             // IN A METHOD WE AND WITH RETURNING A VALUE
    }      // END OF THE MAIN METHOD
}         // END OF THE WHOLE CLASS