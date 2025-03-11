import java.util.Scanner; //Import Scanner class

class LabActivity1EmployeeInformationSystem {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        
        System.out.print("Enter your first name:");
        String firstname = myObj.nextLine();
        
        System.out.print("Enter your last name:");
        String lastname = myObj.nextLine();
        
        System.out.print("Enter your age:");
        int age = myObj.nextInt();        
        
        System.out.print("Enter hours worked:");
         double hoursworked = myObj.nextDouble();       
        
        System.out.print("Enter hourly wage:");
        float hourlywage = myObj.nextFloat();        

        float dailysalary = (float) (hoursworked * hourlywage);
                
        //Output Input by User
        System.out.println(" ");
        System.out.println("Employee Information");
        System.out.println("---------------------");
        System.out.println("Full Name: " + firstname + " " + lastname);
        System.out.println("Age: " + age + " " + "years old");
        System.out.printf("Daily Salary: " + "PHP" + " " + dailysalary); 
    }
}
