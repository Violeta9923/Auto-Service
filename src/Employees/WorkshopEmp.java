package Employees;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class WorkshopEmp {
    public static HashMap<Integer, Employee> employeeList = new HashMap<Integer, Employee>();

    public HashMap getEmployeeList() {
        return employeeList;
    }

    public void printEmployee() {
        System.out.println("PRINT");
        for(Map.Entry currentEmp : employeeList.entrySet()) {
            Employee emp = (Employee) currentEmp.getValue();
            System.out.println("Name: " + emp.getEmpName());
            System.out.println("Last name: " + emp.getEmpMidName());
            System.out.println("Id: " + emp.getEmpID());
            System.out.println("Birthday: " + emp.getBirthday());
            System.out.println("Hiredate: " + emp.getHireday());
            System.out.println("\n");
        }
    }

    public boolean addEmployee() throws ParseException {
        System.out.println("ADD");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter employee name:");
        String empName = myObj.nextLine();
        if(empName.length() > 30 || empName == null) {
            System.out.println("Incorrect name");
            return false;
        }
        System.out.println("Enter employee last name:");
        String empMidName;
        empMidName = myObj.nextLine();
        if(empMidName.length() > 30 || empMidName == null) {
            System.out.println("Incorrect last name");
            return false;
        }
        System.out.println("Enter birthday: dd/MM/yyyy");
        String birthday;
        birthday = myObj.nextLine();
        Date dateBirthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
        System.out.println("Enter hiredate: dd/MM/yyyy");
        String hireday;
        hireday = myObj.nextLine();
        Date dateHireday = new SimpleDateFormat("dd/MM/yyyy").parse(hireday);

        long diffInMillies = Math.abs(dateHireday.getTime() - dateBirthday.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        if((int)diff < 18 * 365 + 4) {
            System.out.println("Incorrect birthday");
            return false;
        }
        Date currentDate = new Date();
        if(dateHireday.after(currentDate)) {
            System.out.println("Incorrect hiredate");
            return false;
        }
        System.out.println("Type: Director / Mechanic / Assistant");
        String type = myObj.nextLine();
        if(type.equals("Director")) {
            Director director = new Director(empName, empMidName, birthday, hireday);
            employeeList.put(director.getEmpID(), director);
        }
        if(type.equals("Mechanic")) {
            Mechanic mechanic = new Mechanic(empName, empMidName, birthday, hireday);
            employeeList.put(mechanic.getEmpID(), mechanic);
        }
        if(type.equals("Assistant")) {
            Assistant assistant = new Assistant(empName, empMidName, birthday, hireday);
            employeeList.put(assistant.getEmpID(), assistant);
        }
    return true;
    }

    public boolean deleteEmployee() {
        System.out.println("DELETE");
        System.out.println("Enter id:");
        Scanner myObj = new Scanner(System.in);
        String id = myObj.nextLine();
        int empId = Integer.parseInt(id);
        if(!employeeList.containsKey(empId)) {
            System.out.println("Incorrect ID!");
            return false;
        }
        employeeList.remove(empId);
        return true;
    }

    public boolean editEmployee() throws ParseException {
        System.out.println("EDIT");
        System.out.println("Enter id:");
        Scanner myObj = new Scanner(System.in);
        String id = myObj.nextLine();
        int empId = Integer.parseInt(id);
        if(!employeeList.containsKey(empId)) {
            System.out.println("Incorrect ID!");
            return false;
        }
        Employee emp = employeeList.get(empId);
        System.out.println("Select: name / last_name / birthday / hiredate");
        String command = myObj.nextLine();
        if(command.equals("name")) {
            System.out.println("Enter name:");
            String name = myObj.nextLine();
            if(name.length() > 30 || name == null) {
                System.out.println("Incorrect name");
                return false;
            }
            emp.setEmpName(name);
        } else if(command.equals("last_name")) {
            System.out.println("Enter middle name:");
            String empMidName;
            empMidName = myObj.nextLine();
            if(empMidName.length() > 30 || empMidName == null) {
                System.out.println("Incorrect last name");
                return false;
            }
            emp.setEmpMidName(empMidName);
        } else if(command.equals("birthday")) {
            System.out.println("Enter new birthday: dd/MM/yyyy");
            String birthday;
            birthday = myObj.nextLine();
            Date dateBirthday = new SimpleDateFormat("dd/MM/yyyy").parse(birthday);
            Date dateHireday = new SimpleDateFormat("dd/MM/yyyy").parse(emp.getHireday());

            long diffInMillies = Math.abs(dateHireday.getTime() - dateBirthday.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            if((int)diff < 18 * 365 + 4) {
                System.out.println("Incorrect birthday");
                return false;
            }
            emp.setBirthday(birthday);
        } else if(command.equals("hiredate")) {
            System.out.println("Enter new hireday: dd/MM/yyyy");
            String hireday;
            hireday = myObj.nextLine();
            Date dateHireday = new SimpleDateFormat("dd/MM/yyyy").parse(hireday);
            Date currentDate = new Date();
            if(dateHireday.after(currentDate)) {
                System.out.println("Incorrect hiredate");
                return false;
            }
            emp.setHireday(hireday);
        }
        return true;
    }

    public boolean getSalary() throws ParseException {
        System.out.println("SALARY");
        System.out.println("Enter id:");
        Scanner myObj = new Scanner(System.in);
        String id = myObj.nextLine();
        int empId = Integer.parseInt(id);
        if(!employeeList.containsKey(empId)) {
            System.out.println("Incorrect ID!");
            return false;
        }
        Employee emp = employeeList.get(empId);
        Date dateHireday = new SimpleDateFormat("dd/MM/yyyy").parse(emp.getHireday());
        Date currentDate = new Date();
        long diffInMillies = Math.abs(currentDate.getTime() - dateHireday.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        double salary = (double) diff / 365;
        salary *= emp.getSalaryCoeff() * 1000;

        System.out.println("Salary for employee with id " + emp.getEmpID() + " is " + salary);

        return true;
    }




}
