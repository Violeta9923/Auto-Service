package Employees;

import Cars.Car;

import java.util.ArrayList;
import java.util.HashMap;

public class Employee {
    private static int idCounter = 0;
    private int empID;
    private String empName;
    private String empMidName;
    private String birthday;
    private String hireday;
    private double salaryCoeff;

    public HashMap<Integer, ArrayList <Float>> empQueue = new HashMap<Integer, ArrayList<Float>>();

    public Employee(String empName, String empMidName,
                    String birthday, String hireday,
                    double salaryCoeff) {
        idCounter++;
        this.empID = idCounter;
        this.empName = empName;
        this.empMidName = empMidName;
        this.birthday = birthday;
        this.hireday = hireday;
        this.salaryCoeff = salaryCoeff;
    }

    public HashMap getEmpQueue() {
        return empQueue;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpMidName() {
        return empMidName;
    }

    public void setEmpMidName(String empMidName) {
        this.empName = empMidName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHireday() {
        return hireday;
    }

    public void setHireday(String hireday) {
        this.hireday = hireday;
    }

    public double getSalaryCoeff() {
        return salaryCoeff;
    }

    public static int getCounter() {
        return idCounter;
    }

}
