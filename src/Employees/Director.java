package Employees;

public class Director extends Employee {
    public static final double directorCoeff = 2.0;

    public Director(String empName, String empMidName,
                    String birthday, String hireday) {
        super(empName, empMidName, birthday, hireday, directorCoeff);
    }
}
