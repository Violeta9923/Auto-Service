package Cars;

import java.util.Calendar;
import java.util.Scanner;

public class Truck extends Car {
private int tonnage;

public Truck(int idCar, int kmCar, int manYear, boolean diesel, int tonnage) {
        super(idCar, kmCar, manYear, diesel);
        this.tonnage = tonnage;
        }

public int getTonnage() {
        return tonnage;
        }

public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
        }

@Override
public int getPolicy() {
        int result = 0;
        System.out.println("Do you have discount? yes/no");
        Scanner myScan = new Scanner(System.in);
        String input = myScan.nextLine();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        result = (currentYear - this.getManYear());
        result *= 300;
        if(this.getKmCar() > 800000) {
        result += 700;
        }
        if(input.equals("yes")){
        result -= (int) (15 / 100 * result);
        }

        return result;
    }
}

