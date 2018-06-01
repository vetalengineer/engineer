package Javalern;

import java.util.Scanner;
import java.util.Stack;


public class Main {

    public static void main(String[] args) {                //    15*(3+12*2)+(12*4+3+5)              15+(3+12*2)*(12*4+3+5)          5*3+12        15/3*2+2

        int singinstak = 0;
        char lastsing = 0;
        String polend = "";
        Stack mathop = new Stack();
        Scanner in = new Scanner(System.in);
        String inputtext = in.nextLine();
        char[] bufer = inputtext.toCharArray();
        char[] transbufer = new char[1000];

        for (int i = 0; i < bufer.length; i++) {

            if (Character.isDigit(bufer[i])) {
                polend += bufer[i];
            } else {
                polend += " ";
                try {
                    lastsing = (char) mathop.pop();
                    if ((lastsing == '*' || lastsing == '/') && (bufer[i] == '+' || bufer[i] == '-')) {
                        polend += lastsing;
                        --singinstak;
                        polend += " ";
                    } else if ((lastsing == '*' || lastsing == '/') && (bufer[i] == '*' || bufer[i] == '/')) {
                        polend += lastsing;
                        --singinstak;
                        polend += " ";
                    } else {
                        mathop.push(lastsing);
                    }
                } catch (Exception ex){
                    lastsing = bufer[i];
                }


                if (bufer[i] == ')') {
                    char bracket = 0;

                    while (bracket != '('){
                        bracket = (char)mathop.pop();
                        if(bracket == '('){
                            --singinstak;
                            break;
                        }
                        polend += " " + bracket;
                        --singinstak;
                    }
                } else {
                mathop.push(bufer[i]);
                ++singinstak;
                }
            }


        }
            for (int n = 0; n < singinstak; n++) {
                polend += " " + mathop.pop();
            }

            System.out.print(polend);

    }
}
