class Faculty{
    private String name;
    private float basicSalary;
    private float bonusPercentage;
    private float carAllowancePercentage;

    public Faculty(String name, float basicSalary) {
        this.name = name;
        this.basicSalary = basicSalary;
        this.bonusPercentage = 0.04f;
        this.carAllowancePercentage = 0.025f;
    }
    public double calculateSalary() {
        return basicSalary + basicSalary *bonusPercentage + basicSalary * carAllowancePercentage;
    }

    public String getName() {
        return name;
    }

    public float getBasicSalary() {
        return basicSalary;
    }

    public float getBonusPercentage() {
        return bonusPercentage;
    }

    public float getCarAllowancePercentage() {
        return carAllowancePercentage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBasicSalary(float basicSalary) {
        this.basicSalary = basicSalary;
    }

    public void setBonusPercentage(float bonusPercentage) {
        this.bonusPercentage = bonusPercentage;
    }

    public void setCarAllowancePercentage(float carAllowancePercentage) {
        this.carAllowancePercentage = carAllowancePercentage;
    }
}

class OfficeStaff extends Faculty{
    private String designation;

    public OfficeStaff(String name, float basicSalary, String designation) {
        super(name, basicSalary);
        this.designation = designation;
    }
    public double calculateSalary(){
        double salary = super.calculateSalary();
        return switch (designation) {
            case "Accountant"-> salary + 10000;
            case "Clerk"-> salary + 7000;
            case "Peon"-> salary + 4500;
            default -> salary;
        };
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}

class Teacher extends Faculty{
    private String qualification;

    public Teacher(String name, float basicSalary, String qualification) {
        super(name, basicSalary);
        this.qualification = qualification;
    }
    @Override
    public double calculateSalary() {
        double salary = super.calculateSalary();
        return switch (qualification) {
            case "Doctoral"-> salary + 20000;
            case "Masters"-> salary + 18000;
            case "Bachelors"-> salary + 15500;
            case "Associate"-> salary + 1000;
            default -> salary;
        };
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}


class Tester {
    public static void main(String[] args) {

        Teacher teacher = new Teacher("Caroline", 30500f, "Masters");
        OfficeStaff officeStaff = new OfficeStaff("James", 24000f, "Accountant");

        System.out.println("Teacher Details\n***************");
        System.out.println("Name: "+teacher.getName());
        System.out.println("Qualification: "+teacher.getQualification());
        System.out.println("Total salary: $" + Math.round(teacher.calculateSalary()*100)/100.0);
        System.out.println();

        System.out.println("Office Staff Details\n***************");
        System.out.println("Name: "+officeStaff.getName());
        System.out.println("Designation: "+officeStaff.getDesignation());
        System.out.println("Total salary: $" + Math.round(officeStaff.calculateSalary()*100)/100.0);

        //Create more objects for testing your code

    }
}
