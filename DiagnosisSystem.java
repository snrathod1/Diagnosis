import java.util.*;
/** 
 * Project 2, Diagnosis
 * class asks users for name, date, and symptoms (temp, congestion, aches, rashes)
 * will output name and date, and either uncertain, healthy, measles, flu, or cold
 * March 6, 2015
 * @author Shraddha Rathod
 */
public class DiagnosisSystem {
    /**
     * sets constant for month numbers
     */
    public static final int JAN = 1;
    public static final int FEB = 2;
    public static final int MAR = 3;
    public static final int APR = 4;
    public static final int MAY = 5;
    public static final int JUNE = 6;
    public static final int JULY = 7;
    public static final int AUG = 8;
    public static final int SEPT= 9;
    public static final int OCT = 10;
    public static final int NOV = 11;
    public static final int DEC = 12;
    /**
     * sets constant for common dates used in the program
     */
    public static final int ONE = 1;
    public static final int THREE = 3; 
    public static final int TONE = 31;
    public static final int THIR = 30;
    public static final int TWEN = 28;
    /**
     * sets constant for end of date
     */
    public static final String YEAR = "/2015";
    /**
     * main method
     * prints introduction and instructions
     * asks for user input for name, month, date, and symptoms
     * calls isValidDate and ends program if date is not valid
     * verifies if valid entry to symptoms
     * calls Patient, prints date, and calls diagnosis
     * calls return date 3 days later if diagnosed with Measles or Uncertain
     * @param args arguments
     */
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        System.out.println("Welcome to the Diagnosis Decision Support System.");
        System.out.println("When prompted, please enter today's month and day ");
        System.out.println("(e.g., 3 14),the patient's full name, temperature, and ");
        System.out.println("whether the patient is experiencing congestion, aches, ");
        System.out.println("and/or a rash. A diagnosis of Healthy, Cold, Flu, Measles, "); 
        System.out.println("or Uncertain will be output as well as a return date, if ");
        System.out.println("the diagnosis is Measles or Uncertain.");
        
        System.out.println(" ");
        
        System.out.print("Patient: ");
        String name = console.nextline();
        
        System.out.print("Month Day (e.g., 3 14):") ;
        int m = console.nextInt();
        int d = console.nextInt();
        
        if (isValidDate(m,d) != true) {
            System.out.println("Invalid date");
            System.exit(1);
        }
        
        System.out.print("Temperature: ");
        double t = console.nextDouble();
        
        System.out.print("Congestion (y,n): ");
        String c = console.next();
        c.toLowerCase();
        boolean x = true;
        if (c.equals("y")) {
            x = true;
        } else if (c.equals("n")) {
            x = false;
        } else {
            System.out.println("Invalid response");
            System.exit(1);
        }
            
        System.out.print("Aches (y,n): ");
        String a = console.next();
        a.toLowerCase();
        boolean y = true;
        if ( a.equals("y")) {
            y = true;
        } else if (a.equals("n")) {
            y = false;
        } else {
            System.out.println("Invalid response");
            System.exit(1);
        }
        
        System.out.print("Rash (y,n): ");
        String r = console.next();
        r.toLowerCase();
        boolean z = true;
        if ( r.equals("y")) {
            z = true;
        } else if (r.equals("n")) {
            z = false;
        } else {
            System.out.println("Invalid response");
            System.exit(1);      
        }
        
        System.out.println(" ");
        
        Patient(name);
        System.out.println("Date: " + m + "/" + d + YEAR);
        System.out.println("Diagnosis: " + getDiagnosis(t, x, y, z));
        if (getDiagnosis(t, x, y, z) == "Measles" || getDiagnosis(t, x, y, z) 
        == "Uncertain") {
            System.out.println("Return Date: " + getReturnDate(m,d));
        } else {
            System.out.println("Return Date: None");
        }
    }
    /**
     * Prints out Patient name
     * @param patient name
     * @return true if valid date, false if invalid
     */
    public static void Patient(String patient) {
        System.out.println("Patient: " + patient);
        
    }
    /**
     * verifies if the date is valid (reasonable month and date)
     * @param month and date number
     * @return true if date is valid and false if invalid
     */
    public static boolean isValidDate(int month, int date) {
        if(month == JAN) {
            if(date >= ONE && date <= TONE) {
                return true;
            } else { 
                return false; 
            }
        } else if(month == FEB) {
            if(date >= ONE && date <= TWEN) {
                return true;
            } else {
                return false; 
            }
        } else if(month == MAR) {
            if(date >= ONE && date <= TONE) {
                return true;
            } else {
                return false; 
            }
        } else if(month == APR) {
            if(date >= ONE && date <= THIR) {
                return true;
            } else {
                return false; 
            }
        } else if(month == MAY) {
            if(date >= ONE && date <= TONE) {
                return true;
            } else {
                return false; 
            }
        } else if(month == JUNE) {
            if(date >= ONE && date <= THIR) {
                return true;
            } else {
                return false; 
            }
        } else if(month == JULY) {
            if(date >= ONE && date <= TONE) {
                return true;
            } else {
                return false; 
            }
        } else if(month == AUG) {
            if(date >= ONE && date <= TONE) {
                return true;
            } else {
                return false; 
            }
        } else if(month == SEPT) {
            if(date >= ONE && date <= THIR) {
                return true;
            } else {
                return false; 
            }
        } else if(month == OCT) {
            if(date >= ONE && date <= TONE) {
                return true;
            } else {
                return false; 
            }
        } else if(month == NOV) {
            if(date >= ONE && date <= THIR) {
                return true;
            } else {
                return false; 
            }
        } else if(month == DEC) {
            if(date >= ONE && date <= TONE) {
                return true;
            } else {
                return false; 
            }
        } else {
            return false;
        } 
    }
    /**
     * Outputs Diagnosis based on symptoms
     * @param temperature, congestion, aches, rash
     * @return cold, healthy, flue, measles, uncertain
     */
    public static String getDiagnosis(double temperature, boolean congestion, boolean 
    aches, boolean rash) {
        String cold = "Cold";
        String healthy = "Healthy";
        String flu = "Flu";
        String measles = "Measles";
        String uncertain = "Uncertain";
        
        if (congestion == true && temperature < 100.0 && aches == false && rash == false) 
        {
            return cold;
        } else if (congestion == false && temperature < 99.0 && aches == false && rash == 
        false) {
            return healthy;
        } else if (congestion == false && temperature >= 100.0 && aches == false && 
        rash == true) {
            return measles;
        } else if (congestion == false && temperature >= 100.0 && aches == true && 
        rash == false) {
            return flu;
        } else {
            return uncertain;
        }
    }
    /**
     * Outputs return date based on diagnosis
     * @param month and date number
     * @throws IllegalArgumentException if invalid date(from previous method)
     * @return 3 days later date- called in main method with conditions
     */
    public static String getReturnDate(int month, int date) {
        if (!isValidDate(month,date)) {
            throw new IllegalArgumentException("Invalid date");
        }
        if(month == JAN) {
            if(date >= 29 && date <= TONE) {
                month += ONE;
                date = (date - TONE) + THREE; 
                return month + "/" + date + YEAR;
            } else { 
                date += THREE;
                return month + "/" + date + YEAR; 
            }
        } else if(month == FEB) {
            if(date >= 26 && date <= TWEN) {
                month += ONE;
                date = (date - TWEN) + THREE; 
                return month + "/" + date + YEAR;
            } else {
                date += THREE;
                return month + "/" + date + YEAR; 
            }
        } else if(month == MAR) {
            if(date >= 29 && date <= TONE) {
                month += ONE;
                date = (date - TONE) + THREE; 
                return month + "/" + date + YEAR;
            } else { 
                date += THREE;
                return month + "/" + date + YEAR;
            }
        } else if(month == APR) {
            if(date >= 28 && date <= THIR) {
                month += ONE;
                date = (date - THIR) + THREE; 
                return month + "/" + date + YEAR;
            } else { 
                date += THREE; 
                return month + "/" + date + YEAR;
            }
        } else if(month == MAY) {
            if(date >= 29 && date <= TONE) {
                month += ONE;
                date = (date - TONE) + THREE; 
                return month + "/" + date + YEAR;
            } else { 
                date += THREE; 
                return month + "/" + date + YEAR;
            }
        } else if(month == JUNE) {
            if(date >= 28 && date <= THIR) {
                month += ONE;
                date = (date - THIR) + THREE; 
                return month + "/" + date + YEAR;
            } else {
                date += THREE; 
                return month + "/" + date + YEAR; 
            }
        } else if(month == JULY) {
            if(date >= 29 && date <= TONE) {
                month += ONE;
                date = (date - TONE) + THREE; 
                return month + "/" + date + YEAR;
            } else {
                date += THREE; 
                return month + "/" + date + YEAR; 
            }
        } else if(month == AUG) {
            if(date >= 29 && date <= TONE) {
                month += ONE;
                date = (date - TONE) + THREE; 
                return month + "/" + date + YEAR;
            } else {
                date += THREE; 
                return month + "/" + date + YEAR;  
            }
        } else if(month == SEPT) {
            if(date >= 28 && date <= THIR) {
                month += ONE;
                date = (date - THIR) + THREE; 
                return month + "/" + date + YEAR;
            } else {
                date += THREE; 
                return month + "/" + date + YEAR;
            }
        } else if(month == OCT) {
            if(date >= 29 && date <= TONE) {
                month += ONE;
                date = (date - TONE) + THREE; 
                return month + "/" + date + YEAR;
            } else {
                date += THREE; 
                return month + "/" + date + YEAR;
            }
        } else if(month == NOV) {
            if(date >= 28 && date <= THIR) {
                month += ONE;
                date = (date - THIR) + THREE; 
                return month + "/" + date + YEAR;
            } else {
                date += THREE; 
                return month + "/" + date + YEAR;
            }
        } else {
            if(date >= 28 && date <= TONE) {
                month -= 11;
                date = (date - TONE) + THREE; 
                return month + "/" + date + "/2016";
            } else {
                date += THREE; 
                return month + "/" + date + YEAR;
            }
        }
    }
}
