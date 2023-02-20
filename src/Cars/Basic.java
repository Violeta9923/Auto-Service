package Cars;

import java.util.Calendar;
import java.util.Scanner;

public class Basic extends Car {
    private String transmisionMode;

    public Basic(int idCar, int kmCar, int manYear, boolean diesel, String transmisionMode) {
        super(idCar, kmCar, manYear, diesel);
        this.transmisionMode = transmisionMode;
    }

    public String getTransmisionMode() {
        return transmisionMode;
    }

    public void setTransmisionMode(String transmisionMode) {
        this.transmisionMode = transmisionMode;
    }

    @Override
    public int getPolicy() {
        int result = 0;
        System.out.println("Do you have discount? yes/no");
        Scanner myScan = new Scanner(System.in);
        String input = myScan.nextLine();
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        result = (currentYear - this.getManYear());
        result *= 100;
        if(this.getDiesel()) {
            result += 500;
        }
        if(this.getKmCar() > 200000) {
            result += 500;
        }
        if(input.equals("yes")){
            result -= (int) (5 / 100 * result);
        }

        return result;
    }
}

