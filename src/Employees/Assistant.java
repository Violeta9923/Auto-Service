package Employees;

public class Assistant extends Employee{
    public static final double assistantCoeff = 2.0;

    public Assistant(String empName, String empMidName,
                    String birthday, String hireday) {
        super(empName, empMidName, birthday, hireday, assistantCoeff);
    }
}
