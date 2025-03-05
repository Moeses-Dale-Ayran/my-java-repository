import java.util.Scanner; //Import Scanner class

class LabActivity2EmployeeInformationSystemPart2 {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
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

        float dailysalary = (float) (hoursworked * hourlywage);
        float roundeddaily = Math.round(dailysalary);
        float weeklysalary = (roundeddaily * 5);
        float monthlysalary = (weeklysalary * 4);
        float grossyearlysalary = (monthlysalary * 12);
        float gys32 = (float) (grossyearlysalary * 0.32);
        float gystaxed = (grossyearlysalary - gys32);
        float netyearlysalary = (gystaxed - 1500);
                
        //Output Input by User
        System.out.println(" ");
        System.out.println("Employee Information");
        System.out.println("---------------------");
        System.out.println("Full Name: " + firstname.toUpperCase() + " " + lastname.toUpperCase());
        System.out.println("Age: " + age + " " + "years old");
        System.out.println("Years to Retirement: " + (Math.abs(age-65)) + " " + "years");
        System.out.printf("Daily Salary: " + "PHP" + " " + "%.2f%n", roundeddaily);
        System.out.printf("Weekly Salary: " + "PHP" + " " + "%.2f%n", weeklysalary);         
        System.out.printf("Monthly Salary: " + "PHP" + " " + "%.2f%n", monthlysalary); 
        System.out.printf("Gross Yearly Salary: " + "PHP" + " " + "%.2f%n", grossyearlysalary); 
        System.out.printf("Net Yearly Salary: " + "PHP" + " " + "%.2f%n", netyearlysalary); 
    }
}
