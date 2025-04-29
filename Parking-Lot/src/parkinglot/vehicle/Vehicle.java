package parkinglot.vehicle;

public abstract class Vehicle {
    protected String lisencePlate;

    protected VehicleType vehicleType;

    public Vehicle(String lisencePlate, VehicleType vehicleType) {
        this.lisencePlate = lisencePlate;
        this.vehicleType = vehicleType;
    }

    public String getLisencePlate() {
        return lisencePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
