import java.util.ArrayList;
abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    public Patient(String patientId,String name,int age){this.patientId=patientId;this.name=name;this.age=age;}
    public String getPatientId(){return patientId;}
    public String getName(){return name;}
    public int getAge(){return age;}
    public String getPatientDetails(){ return patientId+" "+name+" "+age; }
    public abstract double calculateBill();
}
interface MedicalRecord { void addRecord(String r); String viewRecords(); }
class InPatient extends Patient implements MedicalRecord {
    private double roomCharge;
    private String records="";
    public InPatient(String id,String name,int age,double roomCharge){ super(id,name,age); this.roomCharge=roomCharge; }
    public double calculateBill(){ return roomCharge + 2000; }
    public void addRecord(String r){ records += r+";"; }
    public String viewRecords(){ return records; }
}
class OutPatient extends Patient implements MedicalRecord {
    private String records="";
    public OutPatient(String id,String name,int age){ super(id,name,age); }
    public double calculateBill(){ return 500; }
    public void addRecord(String r){ records += r+";"; }
    public String viewRecords(){ return records; }
}
public class HospitalManagement {
    public static void main(String[] args){
        ArrayList<Patient> pts=new ArrayList<>();
        InPatient ip=new InPatient("P1","Sita",30,3000);
        OutPatient op=new OutPatient("P2","Ram",25);
        ip.addRecord("Surgery");
        op.addRecord("Checkup");
        pts.add(ip); pts.add(op);
        for(Patient p:pts) System.out.println(p.getPatientDetails()+" bill:"+p.calculateBill());
    }
}
