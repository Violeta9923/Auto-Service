package Workshop;

import Cars.Car;
import Employees.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

public class Workshop {
    public WorkshopEmp workshopEmp;
    public static ArrayList<Integer> waitingQueue = new ArrayList<>();

    public Workshop(WorkshopEmp workshopEmp) {
        this.workshopEmp = workshopEmp;
    }

    public boolean isOpen() {
        if((workshopEmp.getEmployeeList()).size() < 1){
            return false;
        }
        return true;
    }

    public void printEmp() {
        workshopEmp.printEmployee();
    }

    public void addNewEmp() throws ParseException {
        if(workshopEmp.addEmployee()) {
            System.out.println("Added");
        } else {
            System.out.println("Inccorect dates");
        }
    }

    public void deletEmp() {
        if(workshopEmp.deleteEmployee()) {
            System.out.println("Deleted");
        } else {
            System.out.println("Incorrect Id");
        }
    }

    public void editEmp() throws ParseException {
        if(workshopEmp.editEmployee()) {
            System.out.println("Edited");
        } else {
            System.out.println("Incorrect dates");
        }
    }

    public void getSal() throws ParseException {
        if(!workshopEmp.getSalary()) {
            System.out.println("Incorrect id");
        }
    }

    public boolean addCar(float time, int type) {
        Scanner myScan = new Scanner(System.in);
        String input;

        if(!isOpen()) {
            System.out.println("Add an employee! The workshop is closed!");
            return true;
        }

        System.out.println("Do you want a specific employee? yes/no");
        input = myScan.nextLine();
        if(input.equals("yes")) {
            System.out.println("Enter id:");
            input = myScan.nextLine();
            int id = Integer.parseInt(input);
            Employee emp = (workshopEmp.employeeList).get(id);
            if(!(emp.empQueue).containsKey(type)) {
                ArrayList<Float> arr = new ArrayList<>();
                (emp.empQueue).put(type, arr);
            }
            if(type == 0) {
                if((emp.empQueue.get(type)).size() < 3) {
                    (emp.empQueue.get(type)).add(time);
                } else {
                    return false;
                }
            } else if(type == 1) {
                if((emp.empQueue.get(type)).size() < 1) {
                    (emp.empQueue.get(type)).add(time);
                } else {
                    return false;
                }
            } else if(type == 2){
                if((emp.empQueue.get(type)).size() < 1) {
                    (emp.empQueue.get(type)).add(time);
                } else {
                    return false;
                }
            }
        } else {
            waitingQueue.add(type);
            System.out.println("Added in waiting queue! Wait!");
            return true;
        }
        return true;
    }

    public void printWaitingQueue() {
        System.out.println(waitingQueue);
    }

    public void printEmployeesQueue() {
        for(Map.Entry emp : workshopEmp.employeeList.entrySet()) {
            Employee e = (Employee) emp.getValue();
            System.out.println("Employee with id: " + e.getEmpID() + " has this waiting queue: " +
                    "type = {time}");
            System.out.println(e.empQueue);
        }
    }

    public void checkTime(float currentTime) {
        for(Map.Entry emp : workshopEmp.employeeList.entrySet()) {
            Employee e = (Employee) emp.getValue();
            double time = 0.2;
            // fiecare angajat aloca time = 0.2 pentru o masina basic
            // time = 0.4 pentru bus
            // time = 0.6 pentru truck
            for(int i = 0; i < 3; i++) {
                time += i * 0.2;
                if(e.empQueue.containsKey(i)) {
                    ArrayList<Float> currentList = e.empQueue.get(i);
                    for(int j = 0; j < currentList.size(); j++) {
                        if((double)currentList.get(j) + time <= (double)currentTime) {
                            currentList.remove(j);
                        }
                    }
                    e.empQueue.replace(i, currentList);
                }
            }
        }
    }

    public void checkWaitingQueue(float time) {
        if(!waitingQueue.isEmpty()) {
            int currentType = waitingQueue.get(0);
            waitingQueue.remove(0);
            for(Map.Entry emp : workshopEmp.employeeList.entrySet()) {
                Employee e = (Employee) emp.getValue();
                if(!e.empQueue.containsKey(currentType)) {
                    ArrayList<Float> arr = new ArrayList<>();
                    arr.add(time);
                    (e.empQueue).put(currentType, arr);
                }

            }
        }
    }


}