
/*
Author: Aayush Pyakurel
Course: CSC260L lab section
Date: 02/23/2023
Assignment #5
 */
import java.util.Scanner;
public class Lab5 {
    public static void main(String[] args) {
        //Initialising variables
        char type, bonus;
        int time;
        double price = 0.00;
        Scanner scan = new Scanner(System.in);
        //Solutions
        System.out.println("Enter the type that fits you:\nr. residential\nc. commercial\ne. educational\np. preferred");
        type = scan.next().toLowerCase().charAt(0);
        if(type != 'r' && type != 'c' && type != 'e' && type != 'p' ){
            System.out.println("Invalid Client Type.");
        }else{
            System.out.println("Enter the minutes that you used the phone:");
            time = scan.nextInt();
            if(0>time || time>10080){
                System.out.println("Invalid Number of Minutes.");
            }else{
                if(type == 'r'){
                    if(time<=60){
                        price += 5;
                    }else{
                        price += (5+(double)(time-60)*10/100);
                    }
                }else if(type == 'e'){
                    price += (double)time*18/100;
                }else if(type == 'p'){
                    if(time <= 500){
                        price += 10 + ((double)time*6/100);
                    }else{
                        price += 10 + 30 + (((double)time-500)*4/100);
                    }
                }else{
                    if(time<=300){
                        price += (double) time*20/100;
                    }else{
                        System.out.println("Are you a bonus costumer? \nY. Yes\nN. No");
                        price += (60+((double)time-300)*15/100);
                        bonus = scan.next().toLowerCase().charAt(0);
                        if(bonus == 'y'){
                            price -= price*30/100;
                        }
                    }
                }
                System.out.printf("Total Minutes = %d minutes \nTotal Price = $%.2f", time, price);
            }
        }
    }
}
/*
Enter the type that fits you:
r. residential
c. commercial
e. educational
p. preferred
-> 1st input

Enter the minutes that you used the phone:
-> 2nd input

C
Enter the minutes that you used the phone:
150
Total Minutes = 150 minutes
Total Price = $30.00

e
Enter the minutes that you used the phone:
271
Total Minutes = 271 minutes
Total Price = $48.78

e
Enter the minutes that you used the phone:
0
Total Minutes = 0 minutes
Total Price = $0.00

p
Enter the minutes that you used the phone:
-10
Invalid Number of Minutes.

P
Enter the minutes that you used the phone:
315
Total Minutes = 315 minutes
Total Price = $28.90

R
Enter the minutes that you used the phone:
28
Total Minutes = 28 minutes
Total Price = $5.00

r
Enter the minutes that you used the phone:
423
Total Minutes = 423 minutes
Total Price = $41.30

C
Enter the minutes that you used the phone:
301
Are you a bonus costumer?
Y. Yes
N. No
Y
Total Minutes = 301 minutes
Total Price = $42.11

T
Invalid Client Type.

c
Enter the minutes that you used the phone:
205
Total Minutes = 205 minutes
Total Price = $41.00

c
Enter the minutes that you used the phone:
551
Are you a bonus costumer?
Y. Yes
N. No
No
Total Minutes = 551 minutes
Total Price = $97.65

p
Enter the minutes that you used the phone:
626
Total Minutes = 626 minutes
Total Price = $45.04

e
Enter the minutes that you used the phone:
10583
Invalid Number of Minutes.

p
Enter the minutes that you used the phone:
45
Total Minutes = 45 minutes
Total Price = $12.70

R
Enter the minutes that you used the phone:
8301
Total Minutes = 8301 minutes
Total Price = $829.10

Enter the minutes that you used the phone:
881
Are you a bonus costumer?
Y. Yes
N. No
No
Total Minutes = 881 minutes
Total Price = $147.15

a
Invalid Client Type.

C
Enter the minutes that you used the phone:
343
Are you a bonus costumer?
Y. Yes
N. No
Yes
Total Minutes = 343 minutes
Total Price = $46.52
 */
