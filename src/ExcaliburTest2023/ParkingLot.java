package ExcaliburTest2023;

import java.time.Instant;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class ParkingLot {
    private HashMap<String, Long> cars;
    private HashMap<String, Integer> paidCars;

    private final int MAX_CAPACITY = 5;
    private double pricePerHour;

    private final AtomicInteger earnings = new AtomicInteger(0);

    public ParkingLot(){
        cars = new HashMap<>();
        paidCars = new HashMap<>();
    }

    public boolean hasAvailableSpots(){
        return cars.size() < MAX_CAPACITY;
    }

    public void enterCar(String licencePlate){
        cars.put(licencePlate, getTime());
    }

    public int getParkingPrice(String licencePlate){
        return (int) (this.pricePerHour * (getTime() - cars.get(licencePlate)) / 3600);
    }

    public void setCarPayed(String licencePlate, int payment){
        paidCars.put(licencePlate, payment);
    }

    public boolean hasCarPayed(String licencePlate){
        return paidCars.containsKey(licencePlate);
    }

    public void exitCar(String licencePlate){
        cars.remove(licencePlate);
        earnings.addAndGet(paidCars.get(licencePlate));
        paidCars.remove(licencePlate);
    }

    public int getParkingLotEarnings(){
        paidCars.forEach((licence, payment) -> earnings.addAndGet(payment));
        return earnings.get();
    }

    public void setHourlyPrice(double price){
        this.pricePerHour = price;
    }

    public void openBarrier(){
        System.out.println("The barrier is open");
    }

    private long getTime(){return Instant.now().getEpochSecond();}
}
