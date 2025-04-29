package parkinglot;

import parkinglot.vehicle.Vehicle;
import parkinglot.vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private final int floor;

    private final List<ParkingSpot> parkingSpots;

    public Level(int floor, int numberOfSpots) {
        this.floor = floor;

        parkingSpots = new ArrayList<>(numberOfSpots);

        double spotsForBikes = 0.50;
        double spotsForCars = 0.40;

        int totalBikes = (int) (numberOfSpots * spotsForBikes);
        int totalCars = (int) (numberOfSpots * spotsForCars);

        for (int i = 1; i <= totalBikes; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.BIKE));
        }
        for (int i = totalBikes + 1; i <= totalBikes + totalCars; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }
        for (int i = totalBikes + totalCars + 1; i <= numberOfSpots; i++) {
            parkingSpots.add(new ParkingSpot(i, VehicleType.BUS));
        }
    }

    public synchronized boolean parkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if (parkingSpot.isAvailable() && parkingSpot.getVehicleType()==vehicle.getVehicleType()) {
                parkingSpot.parkVehicle(vehicle);
                return true;
            }
        }
        return false;
    }

    public synchronized boolean unparkVehicle(Vehicle vehicle) {
        for(ParkingSpot parkingSpot: parkingSpots) {
            if (!parkingSpot.isAvailable() && parkingSpot.getParkedVehicle().equals(vehicle)) {
                parkingSpot.unparkVehicle();
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        System.out.println("Level: " + floor);
        System.out.println("Availability: ");

        for(ParkingSpot parkingSpot: parkingSpots) {
            System.out.println("Spot " + parkingSpot.getSpotNumber() + " is " +
                    (parkingSpot.isAvailable() ? "Available for " : "Not Available for ") + parkingSpot.getVehicleType());
        }
    }
}
