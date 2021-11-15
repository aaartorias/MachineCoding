package main;

import main.Model.*;
import main.Persistence.*;

import java.util.ArrayList;
import java.util.Collection;

public class ParkingService {
    private FloorRepository floorRepository;
    private SpotRepository spotRepository;
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private VehicleRepository vehicleRepository;

    public ParkingService() {
        floorRepository = new FloorRepository();
        spotRepository = new SpotRepository();
        ticketRepository = new TicketRepository();
        parkingLotRepository = new ParkingLotRepository();
        vehicleRepository = new VehicleRepository();
    }

    public void createParkingLot(Integer id) {
        ParkingLot parkingLot = new ParkingLot(id);
        parkingLotRepository.add(parkingLot.getId(),parkingLot);
    }

    public void createParkingLot(Integer parkingLotId, Integer totalFloors, Integer slotsPerFloor) {
        ParkingLot parkingLot = new ParkingLot(parkingLotId);
        parkingLotRepository.addParkingLot(parkingLotId, parkingLot);
        addMultipleFloors(parkingLot, totalFloors);
        addMultipleSpotsPerFloor(parkingLot, slotsPerFloor);
    }

    private void addMultipleSpotsPerFloor(ParkingLot parkingLot, Integer slotsPerFloor) {
        Collection<Floor> floors = floorRepository.list();
        for(Floor floor: floors) {
            for (int i = 0; i < slotsPerFloor; i++) {
                Spot spot = spotRepository.addSpot();
                floor.addSpots(spot);
            }
        }
    }

    public void addMultipleFloors(ParkingLot parkingLot, Integer floorCount) {
        for ( int i = 0; i < floorCount; i++) {
            floorRepository.addFloor(i+1);
            parkingLot.addFloor(floorRepository.getFloor(i+1));
        }
    }

    public Integer parkVehicle(Size size, String license, String color) {
        Vehicle vehicle = vehicleRepository.addVehicle(size, license, color);
        Spot spot = spotRepository.getFreeSpot();
        if (spot == null) {
            System.out.println("No spots available");
            return -1;
        } else {
            Ticket ticket = ticketRepository.addTicket();
            ticket.setVehicle(vehicle);
            spot.vehicleAssigned();
            ticket.setSpot(spot);
            ticket.assign();
            System.out.println("Assigned Ticket ID " + ticket.getId() + " against Vehicle Id " + ticket.getVehicle().getLicense());
            return ticket.getId();
        }
    }


    public void unparkVehicle(Integer ticketId) {
        Ticket ticket = ticketRepository.get(ticketId);
        if (ticket == null) {
            System.out.println("");
            // throw  new IllegalOperation() for IllegalParkingTicketId
        } else {
            Spot spot = ticket.getSpot();
            spot.vehicleUnassigned(); // isEmpty before assigning or handle the exception
            ticket.collect();
        }
    }

    public void display() {

        System.out.println("display");
    }
}
