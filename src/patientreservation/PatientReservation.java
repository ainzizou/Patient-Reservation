package patientreservation;

import java.util.Scanner;

public class PatientReservation {

    //Declare and assign the final value so that wont get change by another method
    public static final String[] name = new String[3];
    public static final String[] ic = new String[3];
    public static final String[] phone = new String[3];
    public static int i = 0;
    public static int sum = 0;

    public static void main(String[] args) {

        int x, index, id;

        Scanner in = new Scanner(System.in);
        do {
            System.out.print("\n\nWelcome to the Automated Reservation Machine!\n");
            System.out.println("Select from the following menu options below:\n");
            System.out.println("========================");
            System.out.println("| [1]  Add Patient   |");
            System.out.println("| [2]  Print Patient |");
            System.out.println("| [3]  Search Patient|");
            System.out.println("| [4]  Edit Patient  |");
            System.out.println("| [5]  Sum / Average |");
            System.out.println("| [6]  Delete        |");
            System.out.println("========================");
            System.out.print("Please select your option now: ");
            x = in.nextInt();

            if (x == 1) {
                addPatient();
            } else if (x == 2) {
                printPatient();
            } else if (x == 3) {
                System.out.print("Search patient by Id: ");
                id = in.nextInt();
                System.out.println("-----------------");
                index = getIndex(id);
                searchPatient(index);
            } else if (x == 4) {
                System.out.println("Edit refers to Id!");
                System.out.print("Please enter Id: ");
                id = in.nextInt();
                System.out.println("-----------------");
                index = getIndex(id);
                searchPatient(index);
                if (index != -1) {
                    editData(index);
                }
            } else if (x == 5) {
                int r = 0;
                if (name[r] == null) {
                    System.out.println("Today we have no patient :)");
                } else {
                    System.out.println("Average per day is RM " + averagePatient(sum));
                }
                System.out.println("Sum = RM " + sum);
            } else if (x == 6) {
                if (name[0] == null) {
                    System.out.println("Sorry no data available");
                } else {
                    System.out.print("Search patient by Id: ");
                    id = in.nextInt();
                    System.out.println("-----------------");
                    index = getIndex(id);
                    searchPatient(index);

                    if (index != -1) {
                        deletePatient(index);
                    }

                }
            } else {
                System.out.println("Please choose the option correctly");
            }
        } while (x != 0);
    }//end main method      

    public static void deletePatient(int a) {
        name[a] = "-";
        phone[a] = "-";
        ic[a] = "-";
        i--;
    }

    public static void addPatient() {

        Scanner input = new Scanner(System.in);

        if (name[name.length - 1] == "-") {
            System.out.print("\nPlease enter the name: ");
            name[i] = input.nextLine();
            System.out.print("Please enter the phone number: ");
            phone[i] = input.nextLine();
            System.out.print("Please enter the Id: ");
            ic[i] = input.nextLine();
        } else if (name[name.length - 1] != null) {
            System.out.println("SORRY DATA IS FULL !!!"); //it will appear when data is full
        } else {
            System.out.print("\nPlease enter the name: ");
            name[i] = input.nextLine();
            System.out.print("Please enter the phone number: ");
            phone[i] = input.nextLine();
            System.out.print("Please enter the Id: ");
            ic[i] = input.nextLine();

        }
        sum += 5;
        i++;
    }//end addPatient method

    public static void printPatient() {

        System.out.println("______________________________________________________________");
        System.out.println("No.\t\tName\t\tPhone Number\t\tIC");
        System.out.println("--------------------------------------------------------------");

        int a = 0;
        if (name[a] == null) {
            System.out.println("SORRY NO DATA AVAILABLE !!!"); //when data is not available
        } else {
            for (int j = 0; j < ic.length; j++) {

                if ((name[j] == null) && (phone[j] == null) && (ic[j] == null)) {
                    name[j] = "-";
                    phone[j] = "-";
                    ic[j] = "-";
                }
                System.out.println(j + 1 + "\t\t" + name[j] + "\t\t" + phone[j] + "\t\t\t" + ic[j]);
            }
        }
    }//end PrintPatient method

    public static double averagePatient(int d) {

        return d / i;

    }//end averagePatient method

    public static void editData(int z) {
        Scanner in = new Scanner(System.in);
        System.out.print("Please enter new name: ");
        name[z] = in.nextLine();
        System.out.print("Please enter new phone: ");
        phone[z] = in.nextLine();
        System.out.print("Please enter new Ic: ");
        ic[z] = in.nextLine();

    }//end editData method

    public static int getIndex(int a) {

        String s;
        s = Integer.toString(a);

        for (int i = 0; i < ic.length; i++) {
            if (ic[i].equals(s)) {
                return i;  //We found it!!!
            }
        }
        return -1;
    }//end getIndex method

    public static void searchPatient(int a) {

        if (a == -1) { //Condition when return value from index not found -1
            System.out.println("\nThe  customer information is not found!!!");
            System.out.println("__________________________________");
        } else {
            System.out.println(a + 1 + "\t\t" + name[a] + "\t\t" + phone[a] + "\t\t" + ic[a]);
        }
    }//end searchPatient method
}//endclass
