package main.interfaces.repository;

import main.Model.Size;
import main.Model.Vehicle;

public interface IVehicleRepository {
    Vehicle addVehicle(Size Size, String license, String color);
    Vehicle getVehicle(String license);
}
