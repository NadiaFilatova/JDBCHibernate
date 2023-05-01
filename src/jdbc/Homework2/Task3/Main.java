package src.jdbc.Homework2.Task3;

import java.util.Scanner;

/** Description Main Class
 *  This class stored console menu and input methods for application launching
 * @author Filatova Nadia
 * @version 1.0  April 28, 2023.
 */
public class Main {
    /** Stored an instance of HomeControlUnit */
    private static HomeControlUnit hcu;

    /** Stored menu list as String array */
    private static final String[] OPERATIONS = {
            "1. Add Room",
            "2. Add an unit",
            "3. Delete unit",
            "4. Power ON unit",
            "5. Power OFF unit",
            "6. Show all units",
            "7. Show sorted powered units (power decrement)",
            "8. Show total actual power",
            "9. Find unit",
            "0. Exit"};

    /** This is the program entry point
     *  This method creates an instance of HomeControlUnit
     *  and launch console menu
     */
    public static void main(String[] args) {
        hcu = new HomeControlUnit();
        System.out.println("Hello in the house. You haven't rooms and electrical appliances. You should add them.");
        menu();
    }

    /** This private method prints console menu
     */
    private static void printOperations() {
        for (String operation : OPERATIONS)
            System.out.println(operation);
        System.out.println("Choose the operation you want to perform");
    }

    /**This private method launches the method, based on user's choice
    */
    private static void menu() {
        boolean runWhile = true;
        while (runWhile) {

            printOperations();
            int k = inputInt(" operation number");
            switch (k) {
                case 1 -> // Add New Room
                        hcu.addNewRoom(inputString("Room Name"));
                case 2 -> // Add New Unit
                        hcu.addNewUnit(inputString("Unit Name (str)"), inputInt("Unit power (int)"), inputString("Existing Room Name (str)"));
                case 3 -> // Delete Unit
                        hcu.deleteUnit(inputInt("Existing Unit ID (int)"));
                case 4 -> // Power ON Unit
                        hcu.powerOnUnit(inputInt("Existing Unit ID (int)"));
                case 5 -> // Power OFF Unit
                        hcu.powerOffUnit(inputInt("Existing Unit ID(int)"));
                case 6 -> // Show ALL UNITS
                        hcu.printAllUnits();
                case 7 -> // Show Sorted UNITS
                        hcu.printAllSortedUnits();
                case 8 -> // Show total actual power
                        hcu.showActualPower();
                case 9 -> // Find Unit
                        hcu.findUnit(inputString("Please input unit Name or part of Name"));
                case 0 -> // Exit from Application
                        runWhile = false;
            }
            System.out.println();
        }
    }

    /**
     * This private method asks for Integer from console
     * @param str - this String will be print before request parametr from console
     * @return - Int - inputed parametr by user in console
     */
    private static int inputInt(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Input " + str);
        return scan.nextInt();
    }

    /**
     * This private method asks for String from console
     * @param str - this String will be print before request parametr from console
     * @return - String - inputed parametr by user in console
     */
    private static String inputString(String str) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please Input " + str);
        return scan.nextLine();
    }


}
