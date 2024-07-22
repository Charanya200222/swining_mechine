package com.edubridge.SwingingMachineApp;

import java.util.List;
import java.util.Scanner;

import com.edubridge.swingingMchine.dao.SwingingDaoimp1;
import com.edubridge.swingingMchine.model.SwingingMachine;

public class App 
{
    public static void main( String[] args ){
    	 SwingingDaoimp1 dao = new SwingingDaoimp1();
    Scanner in = new Scanner(System.in);
    while (true) {
        System.out.println("-----------------------");
        System.out.println("MY SWINGING MACHINE APP");
        System.out.println("-----------------------");
        System.out.println(" 1. ADD SWINGING MACHINE");
        System.out.println(" 2. VIEW ALL SWINGING MACHINES");
        System.out.println(" 3. SEARCH SWINGING MACHINE");
        System.out.println(" 4. UPDATE SWINGING MACHINE");
        System.out.println(" 5. DELETE SWINGING MACHINE");
        System.out.println(" 6. DELETE ALL SWINGING MACHINES");
        System.out.println(" 0. EXIT");
        System.out.println("----------------------");
        System.out.println("PLEASE CHOOSE OPTION :");
        System.out.println("----------------------");

        int option = in.nextInt();
        switch (option) {
        case 1:
            System.out.println("Please enter swinging machine id:");
            int id = in.nextInt();
            System.out.println("Please enter swinging machine name:");
            String name = in.next();
            System.out.println("Please enter swinging machine description:");
            String descrption = in.next();
            System.out.println("Please enter swinging machine price:");
            float price= in.nextFloat();
            System.out.println("Please enter swinging machine quality:");
            String quality = in.next();
            System.out.println("Please enter swinging machine brand:");
            String brand = in.next();
            System.out.println("Please enter swinging machine color:");
            String color = in.next();
            System.out.println("Please enter swinging machine model_number:");
            String model_number = in.next();
            
            
            SwingingMachine newMachine = new SwingingMachine();
            newMachine.setId(id);
            newMachine.setName(name);
            newMachine.setDescription(descrption);
            newMachine.setPrice(price);
            newMachine.setQuality(quality);
            newMachine.setBrand(brand);
            newMachine.setQuality(quality);
            newMachine.setColor(color);
            newMachine.setModel_number(model_number);

            int status = dao.addSwingingMachine(newMachine);
            if (status >= 1) {
                System.out.println("New Swinging Machine Saved...!!");
            } else {
                System.out.println("Something went wrong...!!");
            }
            break;
        case 2:
            List<SwingingMachine> machines = dao.getAllSwingingMachines();
            if (machines.size() != 0) {
                for (SwingingMachine machine : machines) {
                    System.out.println("-----------------------------------------------");
                    System.out.println(machine.getId() + "\t" + machine.getName() + "\t" + machine.getDescription() + "\t" + machine.getPrice()  + "\t" + machine.getQuality() + "\t" + machine.getBrand()
                    + "\t" + machine.getColor() + "\t" + machine.getModel_number());
                }
            } else {
                System.out.println("No swinging machines found.");
            }
            break;
        case 3:
            System.out.println("Please enter the name to search:");
            String searchName = in.next();
            SwingingMachine machine = dao.getSwingingMachine(searchName);
            if (machine != null) {
                System.out.println("Swinging Machine found: ");
                System.out.println(machine.getId() + "\t" + machine.getName() + "\t" + machine.getDescription() + "\t" + machine.getPrice()  + "\t" + machine.getQuality() + "\t" + machine.getBrand()
                + "\t" + machine.getColor() + "\t" + machine.getModel_number());
            } else {
                System.out.println("Swinging Machine not found.");
            }
            break;
        case 4:
            System.out.println("Please enter the name of the swinging machine to update:");
            String updateName = in.next();
            
            // Retrieve the existing swinging machine based on the entered name
            SwingingMachine existingMachine = dao.getSwingingMachine(updateName);
            
            if (existingMachine != null) {
                // Prompt user for old and new names
                System.out.println("Enter old name:");
                String oldName = in.next(); // Read old name (though not used directly)
                
                System.out.println("Enter new name:");
                String newName = in.next(); // Read new name
                
                // Set the new name to the existing machine object
                existingMachine.setName(newName);
                
                // Attempt to update the swinging machine in the database
                int updateStatus = dao.updateSwingingMachine(existingMachine);
                
                if (updateStatus >= 1) {
                    System.out.println("Swinging Machine updated successfully!");
                } else {
                    System.out.println("Update failed.");
                }
            } else {
                System.out.println("Swinging Machine not found.");
            }
            break;
        case 5:
            System.out.println("Please enter the name of the swinging machine to delete:");
            String deleteName = in.next();
            int deleteStatus = dao.deleteSwingingMachine(deleteName);
            if (deleteStatus >= 1) {
                System.out.println("Swinging Machine deleted successfully!");
            } else {
                System.out.println("Delete failed.");
            }
            break;
        case 6:
            System.out.println("Are you sure you want to delete all swinging machines? (yes/no)");
            String confirmation = in.next();
            if (confirmation.equalsIgnoreCase("yes")) {
                dao.deleteAllSwingingMachines();
                System.out.println("All swinging machines deleted successfully!");
            } else {
                System.out.println("Delete all swinging machines operation cancelled.");
            }
            break;
        case 0:
            System.out.println("Bye..!!");
            System.exit(0);

        default:
            System.out.println("Please enter a valid option.");
            break;


            
            
       
            
            
            
            
    
    
       
    }   
}
    }
}
