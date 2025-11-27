import java.util.ArrayList;
abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;
    public Employee(String employeeId,String name,double baseSalary){this.employeeId=employeeId;this.name=name;this.baseSalary=baseSalary;}
    public String getEmployeeId(){return employeeId;}
    public String getName(){return name;}
    public double getBaseSalary(){return baseSalary;}
    public void setBaseSalary(double s){ if(s>=0) baseSalary=s; }
    public abstract double calculateSalary();
    public void displayDetails(){ System.out.println(getEmployeeId()+" "+getName()+" "+calculateSalary()); }
}
interface Department { void assignDepartment(String dept); String getDepartmentDetails(); }
class FullTimeEmployee extends Employee implements Department {
    private String dept;
    public FullTimeEmployee(String id,String name,double salary){ super(id,name,salary); }
    public double calculateSalary(){ return getBaseSalary(); }
    public void assignDepartment(String dept){ this.dept=dept; }
    public String getDepartmentDetails(){ return dept; }
}
class PartTimeEmployee extends Employee implements Department {
    private int hours;
    private String dept;
    public PartTimeEmployee(String id,String name,double rate,int hours){ super(id,name,rate); this.hours=hours; }
    public double calculateSalary(){ return getBaseSalary()*hours; }
    public void assignDepartment(String dept){ this.dept=dept; }
    public String getDepartmentDetails(){ return dept; }
}
public class EmployeeManagement {
    public static void main(String[] args){
        ArrayList<Employee> list=new ArrayList<>();
        FullTimeEmployee f=new FullTimeEmployee("FT01","Aarav",50000);
        PartTimeEmployee p=new PartTimeEmployee("PT01","Maya",250,20);
        f.assignDepartment("IT");
        p.assignDepartment("Support");
        list.add(f); list.add(p);
        for(Employee e:list) e.displayDetails();
    }
}
