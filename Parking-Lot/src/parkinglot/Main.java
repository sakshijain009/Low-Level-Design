package parkinglot;

import parkinglot.vehicle.Bike;
import parkinglot.vehicle.Bus;
import parkinglot.vehicle.Car;
import parkinglot.vehicle.Vehicle;

public class Main {
    public static void main(String[] args) {

        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 3));
        parkingLot.addLevel(new Level(2, 5));

        Vehicle car = new Car("ABC123");
        Vehicle bike = new Bike("XYZ789");
        Vehicle bus = new Bus("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(bike);
        parkingLot.parkVehicle(bus);

        // Display availability
        System.out.println();
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unparkVehicle(car);

        // Display updated availability
        System.out.println();
        parkingLot.displayAvailability();

    }
}