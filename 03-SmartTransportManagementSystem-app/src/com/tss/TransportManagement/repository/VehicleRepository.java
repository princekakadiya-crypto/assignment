package com.tss.TransportManagement.repository;

import com.tss.TransportManagement.Interface.Maintainable;
import com.tss.TransportManagement.models.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleRepository {
    private static ArrayList<Vehicle> vehicles=new ArrayList<>();

    public Vehicle addVehicle(Vehicle vehicle)
    {
        vehicles.add(vehicle);
        return vehicle;
    }

    public ArrayList<Vehicle> getAllVehicle()
    {
        return vehicles;
    }

    public Vehicle searchVehicleByID(int vehicleId)
    {
        for (Vehicle vehicle:vehicles)
        {
            if (vehicle.getVehicleID()==vehicleId)
            {
                return vehicle;
            }
        }
        return null;
    }

    public Vehicle getVehicleWithHighestRevenue()
    {
        if (vehicles.isEmpty())
            return null;
        Vehicle maxRevenue=vehicles.get(0);
        for (Vehicle vehicle:vehicles)
        {
            if (maxRevenue.getTotalRevenue()<vehicle.getTotalRevenue())
                maxRevenue=vehicle;
        }
        return maxRevenue;
    }

    public Vehicle getVehicleWithMaximumOccupancy()
    {
        if (vehicles.isEmpty())
            return null;
        Vehicle maxOccupancy=vehicles.get(0);
        for (Vehicle vehicle:vehicles)
        {
            if (maxOccupancy.getOccupancy()<vehicle.getOccupancy())
                maxOccupancy=vehicle;
        }
        return maxOccupancy;
    }

    public List<Vehicle> getAllUnderMaintenanceVehicle()
    {
        List<Vehicle> VehicleList=new ArrayList<>();
        for (Vehicle vehicle:vehicles)
        {
            if (vehicle instanceof Maintainable) {
                Maintainable maintainable = (Maintainable) vehicle;
                if (maintainable.chackMaintenanceStatus())
                    VehicleList.add(vehicle);
            }
        }
        return VehicleList;
    }

    public int getVehicleAvailableSeat(int vehicleId)
    {
        for (Vehicle vehicle:vehicles)
        {
            if (vehicle.getVehicleID()==vehicleId)
                return vehicle.getAvailableSet();
        }
        return -1;
    }
}
