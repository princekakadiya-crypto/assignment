package com.tss.TransportManagement.menu;

import com.tss.TransportManagement.Validation.InputValidation;
import com.tss.TransportManagement.exception.InvalidMenuSelectionException;
import com.tss.TransportManagement.services.BookingService;
import com.tss.TransportManagement.services.PassengerService;
import com.tss.TransportManagement.services.VehicleService;

public class Menu {
    VehicleService vehicleService=new VehicleService();
    PassengerService passengerService=new PassengerService();
    BookingService bookingService=new BookingService();

    public void Start()
    {
        int choice;
        do {
            System.out.println("1. Manage Vehicle");
            System.out.println("2. Manage Passenger");
            System.out.println("3. Manage Booking");
            System.out.println("4. Exit");
            choice= InputValidation.readInt("Enter Choice : ");

            try{
                if (choice<1 || choice>4)
                    throw new InvalidMenuSelectionException(choice);
            }
            catch (InvalidMenuSelectionException e)
            {
                System.out.println(e.getMessage());
            }

            switch (choice)
            {
                case 1:
                    vehicleMenu();
                    break;
                case 2:
                    passengerMenu();
                    break;
                case 3:
                    bookingMenu();
                    break;
                case 4:
                    System.out.println("Exited.");
                    break;
            }
        }while (choice!=4);
    }
    private void vehicleMenu() {
        int choice;
        do {
            System.out.println("1. Add vehicle");
            System.out.println("2. Display All Vehicle");
            System.out.println("3. Search Vehicle by id");
            System.out.println("4. Display Total Revenue of Vehicle");
            System.out.println("5. Vehicle with highest revenue");
            System.out.println("6. Vehicle with maximum occupancy");
            System.out.println("7. Vehicle Maintenance Menu");
            System.out.println("8. Back");
            choice = InputValidation.readInt("Enter Choice : ");

            try {
                if (choice < 1 || choice > 8)
                    throw new InvalidMenuSelectionException(choice);
            } catch (InvalidMenuSelectionException e) {
                System.out.println(e.getMessage());
            }

            switch (choice) {
                case 1:
                    addVehicleMenu();
                    break;
                case 2:
                    vehicleService.showAllVehicles();
                    break;
                case 3:
                    int vehicleIDForDisplay=InputValidation.readInt("Enter Vehicle Id to search : ");
                    vehicleService.displayVehicleByID(vehicleIDForDisplay);
                    break;
                case 4:
                    int vehicleIDForRevenue=InputValidation.readInt("Enter Vehicle Id to search : ");
                    vehicleService.displayRevenue(vehicleIDForRevenue);
                    break;
                case 5:
                    vehicleService.displayVehicleWithHighestRevenue();
                    break;
                case 6:
                    vehicleService.displayVehicleWithMaximumOccupancy();
                    break;
                case 7:
                    vehicleMaintenance();
                    break;
                case 8:
                    System.out.println("Back from Vehicle menu.\n");
                    break;
            }
        }while (choice!=8);
    }
    private void addVehicleMenu()
    {
        System.out.println("Vehicle Type");
        System.out.println("1. Add Bus");
        System.out.println("2. Add Metro");
        System.out.println("3. Add Taxi");
        System.out.println("4. Back");
        int choice;
        do {
            choice =InputValidation.readInt("Enter Vehicle Type : ") ;
            try {
                if (choice < 1 || choice > 4)
                    throw new InvalidMenuSelectionException(choice);
                break;
            } catch (InvalidMenuSelectionException e) {
                System.out.println(e.getMessage());
            }
        }while (true);
        switch (choice)
        {
            case 1:
                vehicleService.addBus();
                break;
            case 2:
                vehicleService.addMetro();
                break;
            case 3:
                vehicleService.addTaxi();
                break;
            case 4:
                System.out.println("Back from Vehicle Type menu");
                break;
        }
    }
    private void vehicleMaintenance()
    {
        int choice;
        int vehicleID;
        do {
            System.out.println("1. Mark Vehicle Under Maintenance");
            System.out.println("2. Complete Maintenance");
            System.out.println("3. Check Vehicle Maintenance Status");
            System.out.println("4. Display Vehicles Under Maintenance");
            System.out.println("5. Back");
            choice =InputValidation.readInt("Enter choice : ") ;
            try {
                if (choice < 1 || choice > 4)
                    throw new InvalidMenuSelectionException(choice);
            } catch (InvalidMenuSelectionException e) {
                System.out.println(e.getMessage());
            }

            switch (choice)
            {
                case 1:
                    vehicleID=InputValidation.readInt("Enter Vehicle Id : ");
                    vehicleService.markVehicleUnderMaintenance(vehicleID);
                    break;
                case 2:
                    vehicleID=InputValidation.readInt("Enter Vehicle Id : ");
                    vehicleService.markVehicleCompleteMaintenance(vehicleID);
                    break;
                case 3:
                    vehicleID=InputValidation.readInt("Enter Vehicle ID : ");
                    vehicleService.displayVehicleStatus(vehicleID);
                    break;
                case 4:
                    vehicleService.displayAllUnderMaintenanceVehicle();
                    break;
                case 5:
                    System.out.println("Back from Vehicle Maintenance");
            }
        }while (choice!=5);
    }
    private void passengerMenu()
    {
        int choice;
        do {
            System.out.println("1. Register Passenger");
            System.out.println("2. Display All Passengers");
            System.out.println("3. Search Passenger by id");
            System.out.println("4. Back");
            choice = InputValidation.readInt("Enter Choice : ");

            try {
                if (choice < 1 || choice > 4)
                    throw new InvalidMenuSelectionException(choice);
            } catch (InvalidMenuSelectionException e) {
                System.out.println(e.getMessage());
            }

            switch (choice) {
                case 1:
                    passengerService.addPassenger();
                    break;
                case 2:
                    passengerService.displayAllPassenger();
                    break;
                case 3:
                    int passengerIDForDisplay =InputValidation.readInt("Enter Passenger Id to search : ");
                    passengerService.displayPassengerByID(passengerIDForDisplay);
                    break;
                case 4:
                    System.out.println("Back from Vehicle menu.\n");
                    break;
            }
        }while (choice!=4);
    }
    private void bookingMenu()
    {
        int choice;
        do {
            System.out.println("1. Book a Vehicle for passenger");
            System.out.println("2. Display All Bookings of Vehicle");
            System.out.println("3. Available sets on vehicle");
            System.out.println("4. Back");
            choice = InputValidation.readInt("Enter Choice : ");

            try {
                if (choice < 1 || choice > 4)
                    throw new InvalidMenuSelectionException(choice);
            } catch (InvalidMenuSelectionException e) {
                System.out.println(e.getMessage());
            }

            switch (choice) {
                case 1:
                    bookingService.addBooking();
                    break;
                case 2:
                    int vehicleId=InputValidation.readInt("Enter Vehicle ID :");
                    bookingService.displayBookingOfVehicle(vehicleId);
                    break;
                case 3:
                    int vehicleIdForAvailableSet=InputValidation.readInt("Enter Vehicle Id : ");
                    bookingService.displayAvailableSeatOfVehicle(vehicleIdForAvailableSet);
                    break;
                case 4:
                    System.out.println("Back from Booking menu.\n");
                    break;
            }
        }while (choice!=4);
    }
}
