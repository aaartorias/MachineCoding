package main.persistence;

import main.factory.VehicleFactory;
import main.models.vehicles.Vehicle;
import main.interfaces.repository.IVehicleRepository;
import main.interfaces.repository.Store;
import main.models.VehicleType;

public class VehicleRepository extends Store<String, Vehicle> implements IVehicleRepository {
    VehicleFactory vehicleFactory;

    public VehicleRepository(VehicleFactory vehicleFactory) {
        this.vehicleFactory = vehicleFactory;
    }

    @Override
    public Vehicle addVehicle(VehicleType vehicleType, String license, String color) {
        Vehicle vehicle = get(license);
        if (vehicle == null) {
            vehicle = vehicleFactory.createVehicle(vehicleType, license, color);//new Vehicle(vehicleType, license, color);
            add(license,vehicle);
        }
        return vehicle;
    }

    @Override
    public Vehicle getVehicle(String license) {
        return get(license);
    }
}
