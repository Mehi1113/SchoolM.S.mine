package users;

import java.time.LocalDate;

public abstract class Employee extends Person {
    protected double salary;

    public Employee(String name, String surname, LocalDate birthDate, double salary) {
        super(name,surname,birthDate);
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
