package Employees;

public class Mechanic extends Employee{
    public static final double mechanicCoeff = 1.5;

    public Mechanic(String empName, String empMidName,
                    String birthday, String hireday) {
        super(empName, empMidName, birthday, hireday, mechanicCoeff);
    }
}
