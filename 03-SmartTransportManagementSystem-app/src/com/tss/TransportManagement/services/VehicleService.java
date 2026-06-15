package com.tss.TransportManagement.services;

import com.tss.TransportManagement.Interface.Maintainable;
import com.tss.TransportManagement.Validation.InputValidation;
import com.tss.TransportManagement.exception.InvalidMenuSelectionException;
import com.tss.TransportManagement.exception.VehicleNotFoundException;
import com.tss.TransportManagement.models.Bus;
import com.tss.TransportManagement.models.Metro;
import com.tss.TransportManagement.models.Taxi;
import com.tss.TransportManagement.models.Vehicle;
import com.tss.TransportManagement.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;

public class VehicleService {
    private VehicleRepository vehicleRepository=new VehicleRepository();
    public void addBus()
    {
        String vehicleNumber= InputValidation.readString("Enter Vehicle number : ",5,15,"Vehicle number must be length of 5 to 15");
        String driverName=InputValidation.readName("Enter Driver Name : ");
        double farePerKmBus=InputValidation.readDouble("Enter Fare per KM : ",1);
        int capacityBus=InputValidation.readInt("Enter Capacity : ",1,Bus.getMaxCapacity());
        Vehicle vehicle=vehicleRepository.addVehicle(new Bus(vehicleNumber,driverName,capacityBus,farePerKmBus));
        System.out.println("Bus added with VehicleID : "+vehicle.getVehicleID());

    }

    public void addMetro()
    {
        String vehicleNumber= InputValidation.readString("Enter Vehicle number : ",5,15,"Vehicle number must be length of 5 to 15");
        String driverName=InputValidation.readName("Enter Driver Name : ");
        double farePerKmMetro=InputValidation.readDouble("Enter Fare per KM : ",1);
        int capacityMetro=InputValidation.readInt("Enter Capacity : ",1,Metro.getMaxCapacity());
        Vehicle vehicle=vehicleRepository.addVehicle(new Metro(vehicleNumber,driverName,capacityMetro,farePerKmMetro));
        System.out.println("Metro added with VehicleID : "+vehicle.getVehicleID());
    }

    public void addTaxi()
    {
        String vehicleNumber= InputValidation.readString("Enter Vehicle number : ",5,15,"Vehicle number must be length of 5 to 15");
        String driverName=InputValidation.readName("Enter Driver Name : ");
        double farePerKmTaxi=InputValidation.readDouble("Enter Fare per KM : ",1);
        double baseFareTaxi=InputValidation.readDouble("Base Fare : ",1);
        int capacityTaxi=InputValidation.readInt("Enter Capacity : ",1, Taxi.getMaxCapacity());
        Vehicle vehicle=vehicleRepository.addVehicle(new Taxi(vehicleNumber,driverName,capacityTaxi,baseFareTaxi,farePerKmTaxi));
        System.out.println("Taxi added with VehicleID : "+vehicle.getVehicleID());
    }

    public void showAllVehicles()
    {
        ArrayList<Vehicle> vehicles=vehicleRepository.getAllVehicle();
        if (vehicles.isEmpty())
        {
            System.out.println("No Vehicle found");
            return;
        }
        System.out.printf("%-10s %-16s %-15s %-15s %-10s %-15s %-15s%n","Vehicle ID","Vehicle Number","Driver Name","Vehicle Type","Capacity","Fare Per KM","Base Fare");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (Vehicle vehicle:vehicles)
            vehicle.displayVehicle();
    }

    public void displayVehicleByID(int vehicleId)
    {
        Vehicle vehicle=vehicleRepository.searchVehicleByID(vehicleId);
        if (vehicle==null)
        {
            System.out.println("Vehicle not found. Check your vehicle id.");
            return;
        }
        System.out.println(vehicle);
    }

    public void displayRevenue(int vehicleId)
    {
        Vehicle vehicle=vehicleRepository.searchVehicleByID(vehicleId);
        try {
            if (vehicle == null)
                throw new VehicleNotFoundException(vehicleId);
            System.out.println("Total revenue : "+vehicle.getTotalRevenue());
        } catch (VehicleNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void displayVehicleWithHighestRevenue()
    {
        Vehicle vehicle=vehicleRepository.getVehicleWithHighestRevenue();
        if (vehicle==null)
            System.out.println("No Vehicle Found");
        System.out.println(vehicle);
    }

    public void displayVehicleWithMaximumOccupancy()
    {
        Vehicle vehicle=vehicleRepository.getVehicleWithMaximumOccupancy();
        if (vehicle==null)
            System.out.println("No Vehicle Found");
        System.out.println(vehicle);
    }

    public void markVehicleUnderMaintenance(int vehicleId)
    {
        Vehicle vehicle=vehicleRepository.searchVehicleByID(vehicleId);
        if (vehicle instanceof Maintainable)
        {
            Maintainable maintainable=(Maintainable) vehicle;
            maintainable.setVehicleUnderMaintenance();
            System.out.println("Vehicle is now Under Maintenance.");
            return;
        }
        System.out.println("This vehicle can not mark as Under Maintenance.");
    }

    public void markVehicleCompleteMaintenance(int vehicleId)
    {
        Vehicle vehicle=vehicleRepository.searchVehicleByID(vehicleId);
        if (vehicle instanceof Maintainable)
        {
            Maintainable maintainable=(Maintainable) vehicle;
            maintainable.completeMaintenance();
            System.out.println("Vehicle is now mark as Complete Maintenance.");
            return;
        }
        System.out.println("This vehicle can not mark as Complete Maintenance.");
    }
    public void displayVehicleStatus(int vehicleId)
    {
        Vehicle vehicle=vehicleRepository.searchVehicleByID(vehicleId);
        if (vehicle instanceof Maintainable)
        {
            Maintainable maintainable=(Maintainable) vehicle;
            System.out.println("Vehicle Maintenance Status : "+(maintainable.chackMaintenanceStatus()?"Under Maintenance":"Not in Maintenance"));
            return;
        }
        System.out.println("This vehicle can not support Maintenance System.");
    }
    public void displayAllUnderMaintenanceVehicle()
    {
        List<Vehicle> VehicleList=vehicleRepository.getAllUnderMaintenanceVehicle();
        if (VehicleList.isEmpty())
        {
            System.out.println("No Vehicle in Under Maintenance");
            return;
        }
        System.out.printf("%-10s %-16s %-15s %-15s %-10s %-15s %-15s%n","Vehicle ID","Vehicle Number","Driver Name","Vehicle Type","Capacity","Fare Per KM","Base Fare");
        System.out.println("-------------------------------------------------------------------------------------------------------");
        for (Vehicle vehicle:VehicleList)
        {
            vehicle.displayVehicle();
        }
    }
}
