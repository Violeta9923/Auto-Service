import Employees.*;
import Workshop.*;

import javax.swing.text.Style;
import java.text.ParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        WorkshopEmp workshopEmp = new WorkshopEmp();
        Workshop workshop = new Workshop(workshopEmp);
        String commmand;
        float time = 0;
        String input;

        while(time >= 0) {
            System.out.println("Select a command: PRINT_EMP / ADD_EMP / DEL_EMP / EDIT_EMP / " +
                    "SAL_EMP / ADD_CAR");
            workshop.checkTime(time);
            Scanner myScan = new Scanner(System.in);
            commmand = myScan.nextLine();
            if(commmand.equals("ADD_CAR")) {
                int type;
                System.out.println("Enter the type of car: basic / bus / truck");
                input = myScan.nextLine();
                if(input.equals("basic")) {
                    type = 0;
                } else if(input.equals("bus")) {
                    type = 1;
                } else if(input.equals("truck")){
                    type = 2;
                } else {
                    type = -1;
                    System.out.println("Incorrect data!");
                }
                if(!workshop.addCar(time, type) && type >= 0){
                    System.out.println("Queue full! Do you want another employee? yes/no");
                    input = myScan.nextLine();
                    if(input.equals("yes")) {
                        if(!workshop.addCar(time, type)){
                            System.out.println("Do you want to leave? yes/no");
                            input = myScan.nextLine();
                            if(input.equals("yes")) {
                                System.out.println("Bye-bye!");
                            } else {
                                System.out.println("Then wait!");
                                workshop.waitingQueue.add(type);
                            }
                        }
                    } else {
                        System.out.println("Do you want to leave? yes/no");
                        input = myScan.nextLine();
                        if(input.equals("yes")) {
                            System.out.println("Bye-bye!");
                        } else {
                            System.out.println("Then wait!");
                            workshop.waitingQueue.add(type);
                        }
                    }
                }
                System.out.println("Types of car in the waiting queue: " +
                        "0 = basic / 1 = bus / 2 = truck");
                workshop.printWaitingQueue();
                workshop.printEmployeesQueue();
            }
            if(commmand.equals("PRINT_EMP")) {
                workshop.printEmp();
            }
            if(commmand.equals("ADD_EMP")) {
                workshop.addNewEmp();
            }
            if(commmand.equals("DEL_EMP")) {
                workshop.deletEmp();
            }
            if(commmand.equals("EDIT_EMP")) {
                workshop.editEmp();
            }
            if(commmand.equals("SAL_EMP")) {
                workshop.getSal();
            }
            workshop.checkWaitingQueue(time);
            workshop.checkTime(time);
            time += 0.1;
            workshop.checkTime(time);
        }
    }
}
