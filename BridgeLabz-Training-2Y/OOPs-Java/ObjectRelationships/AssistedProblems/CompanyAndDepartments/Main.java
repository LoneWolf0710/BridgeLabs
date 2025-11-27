public class Main {
    public static void main(String[] args) {
        Company company = new Company("TechCorp");

        Department devDept = new Department("Development");
        devDept.addEmployee(new Employee("Alice"));
        devDept.addEmployee(new Employee("Bob"));

        Department hrDept = new Department("HR");
        hrDept.addEmployee(new Employee("Charlie"));

        company.addDepartment(devDept);
        company.addDepartment(hrDept);

        company.showCompany();
    }
}