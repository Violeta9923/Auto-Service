package Cars;

import java.util.Calendar;
import java.util.Scanner;

public class Bus extends Car {
    private int numSeats;

    public Bus(int idCar, int kmCar, int manYear, boolean diesel, int numSeats) {
        super(idCar, kmCar, manYear, diesel);
        this.numSeats = numSeats;
    }

    public int getNumSeats() {
        return numSeats;
    }

    public void setNumSeats(int numSeats) {
        this.numSeats = numSeats;
    }

    @Override
    public int getPolicy() {
        int result = 0;
        System.out.println("Do you have discount? yes/no");
        Scanner myScan = new Scanner(System.in);
        String input = myScan.nextLine();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        result = (currentYear - this.getManYear());
        result *= 200;
        if(this.getDiesel()) {
            result += 1000;
        }
        if(this.getKmCar() > 200000) {
            result += 1000;
        } else if(this.getKmCar() > 100000) {
            result += 500;
        }
        if(input.equals("yes")){
            result -= (int) (10 / 100 * result);
        }

        return result;
    }
}


