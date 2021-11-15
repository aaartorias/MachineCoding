package main.Persistence;

import main.Model.Size;
import main.Model.Vehicle;
import main.interfaces.repository.IVehicleRepository;
import main.interfaces.repository.Store;

public class VehicleRepository extends Store<String, Vehicle> implements IVehicleRepository {
    @Override
    public Vehicle addVehicle(Size size, String license, String color) {
        Vehicle vehicle = get(license);
        if (vehicle == null) {
            vehicle = new Vehicle(size, license, color);
            add(license,vehicle);
        }
        return vehicle;
    }

    @Override
    public Vehicle getVehicle(String license) {
        return get(license);
    }
}
