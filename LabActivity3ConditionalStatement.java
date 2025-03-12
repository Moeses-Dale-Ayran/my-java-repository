import java.util.Scanner; //Import Scanner class

class LabActivity3ConditionalStatement {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        //Inputs
        System.out.print("Enter your first name: ");
        String firstname = myObj.nextLine();
        
        System.out.print("Enter your last name: ");
        String lastname = myObj.nextLine();
        
        System.out.print("Enter your age: ");
        int age = myObj.nextInt();        
        
        System.out.print("Enter hours worked: ");
        double hoursworked = myObj.nextDouble();       
        
        System.out.print("Enter hourly wage: ");
        float hourlywage = myObj.nextFloat();     
        
        System.out.print("Enter your role code (1-Manager, 2-Supervisor, 3-Staff, 4-Intern): ");
        int role = myObj.nextInt();

        //Computations for salaries
        float dailysalary = (float) (hoursworked * hourlywage); //typecast to convert double into float
        float roundeddaily = Math.round(dailysalary);
        float weeklysalary = (roundeddaily * 5);
        float monthlysalary = (weeklysalary * 4);
        float grossyearlysalary = (monthlysalary * 12);
        
        //Ternary Operators
        
        //Minors and Senior Citizens
        System.out.println((age < 18) ? "Minors are not allowed" : (age >= 65) ? "Senior Citizens are not allowed" : "");
        if (age < 18 || age >= 65) System.exit(0);
        
        //Hours worked
        System.out.println((hoursworked > 24) ? "Number of hours worked cannot exceed 24 hours" : (hoursworked == 0) ? "Wrong input on daily work hours" : "");
        if (hoursworked > 24 || hoursworked == 0) System.exit(0);
        
        //Yearly salary tax
        float netyearlysalary;
        if (grossyearlysalary > 250000) {
            float gys32 = (float) (grossyearlysalary * 0.32); //typecast to allow multiplication of decimal
            float gystaxed = (grossyearlysalary - gys32);
            netyearlysalary = (gystaxed - 1500);
        } else {
            netyearlysalary = (grossyearlysalary - 1500);
        }
        
        
        //Switch case for Roles
        String position = switch (role) {
            case 1 -> "Manager";
            case 2 -> "Supervisor";
            case 3 -> "Staff";
            case 4 -> "Intern";
            default -> "Undefined";
        };
                
        //Output Input by User
        System.out.println(" ");
        System.out.println("Employee Information");
        System.out.println("---------------------");
        System.out.println("Full Name: " + firstname.toUpperCase() + " " + lastname.toUpperCase());
        System.out.println("Age: " + age + " " + "years old");
        System.out.println("Position: " + position);
        System.out.println("Years to Retirement: " + (Math.abs(age-65)) + " " + "years");
        System.out.printf("Daily Salary: " + "PHP" + " " + "%.2f%n", roundeddaily);
        System.out.printf("Weekly Salary: " + "PHP" + " " + "%.2f%n", weeklysalary);         
        System.out.printf("Monthly Salary: " + "PHP" + " " + "%.2f%n", monthlysalary); 
        System.out.printf("Gross Yearly Salary: " + "PHP" + " " + "%.2f%n", grossyearlysalary); 
        System.out.printf("Net Yearly Salary: " + "PHP" + " " + "%.2f%n", netyearlysalary); 
    }
}
