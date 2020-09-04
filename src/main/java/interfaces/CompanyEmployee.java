package interfaces;

public class CompanyEmployee implements Company, Employee {
    private String first;
    private String last;

    public CompanyEmployee(String first, String last) {
        this.first = first;
        this.last = last;
    }

    @Override
    public String getName() {
        return Employee.super.getName() + " works for " +
                Company.super.getName();
    }

    @Override
    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Override
    public String getLast() {
        return last;
    }

    @Override
    public void doWork() {
        System.out.println("Transforming caffeine into code for money...");
    }

    public void setLast(String last) {
        this.last = last;
    }
}
