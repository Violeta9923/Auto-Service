package Cars;

public abstract class Car {
    private int idCar;
    private int kmCar;
    private int manYear;
    private boolean diesel;

    public Car(int idCar, int kmCar, int manYear, boolean diesel) {
        this.idCar = idCar;
        this.kmCar = kmCar;
        this.manYear = manYear;
        this.diesel = diesel;
    }

    public abstract int getPolicy();

    public int getIdCar() {
        return idCar;
    }

    public void set(int idCar) {
        this.idCar = idCar;
    }

    public int getKmCar() {
        return kmCar;
    }

    public void setKmCar(int kmCar) {
        this.kmCar = kmCar;
    }

    public int getManYear() {
        return manYear;
    }

    public void setManYear(int manYear) {
        this.manYear = manYear;
    }

    public boolean getDiesel() {
        return diesel;
    }

    public void setDiesel(boolean diesel) {
        this.diesel = diesel;
    }
}
