package Management_Exc;

import java.util.List;
import java.util.NoSuchElementException;

public class Main {

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param manager the manager to give the salary
     * @param employee the employee to receive the raise
     * @param salary the salary increase to be given
     * @throws ClassCastException when manager or employee is not a manager or employee
     * @throws IllegalArgumentException when salary is invalid
     * @throws NoSuchElementException when given manager or employee does not exist in the list of persons
     */
    public static void giveRaise(List<Person> persons, String manager, String employee, double salary)  {
        Employee Eemployee = null;

        for(Person p : persons) {
            if(p.getName().equals(employee)) {
                if(!(p instanceof Employee)) {
                    throw new ClassCastException(p.getName() + " is not an employee");
                } else {
                    Eemployee = (Employee) p;
                    break;
                }
            }
        }
        if(Eemployee == null) {
            throw new NoSuchElementException(employee + " does not exist");
        }
        for(Person p: persons) {
            if(p.getName().equals(manager)) {
                if(!(p instanceof Manager)) {
                    throw new ClassCastException(p.getName() + " is not a manager");
                }
                ((Manager) p).giveRaise(Eemployee, salary);
                return;
            }
        }

        throw new NoSuchElementException(manager + " does not exist");
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param developer the developer to be assigned
     * @param manager the manager assigned to the dev
     * @throws ClassCastException when manager or developer is not a manager or employee
     * @throws NoSuchElementException when given manager or developer does not exist in the list of persons
     * @throws IllegalStateException when developer already has a manager
     */
    public static void assignPM(List<Person> persons, String developer, String manager) {
        Developer Ddeveloper = null;

        for(Person p : persons) {
            if(p.getName().equals(developer)) {
                if(!(p instanceof Developer)) {
                    throw new ClassCastException(p.getName() + " is not an developer");
                } else {
                    Ddeveloper = (Developer) p;
                    break;
                }
            }
        }
        if(Ddeveloper == null) {
            throw new NoSuchElementException(developer + " does not exist");
        }
        for(Person p: persons) {
            if(p.getName().equals(manager)) {
                if(!(p instanceof Manager)) {
                    throw new ClassCastException(p.getName() + " is not a manager");
                }
                Ddeveloper.setProjectManager((Manager) p);
                return;
            }
        }

        throw new NoSuchElementException(manager + " does not exist");
    }

    /**
     * TODO this implementation
     * @param persons the list of persons
     * @param customer the customer to speak to the employee
     * @param employee the employee to be spoken to
     * @return the dialogue of the customer to the employee
     * @throws ClassCastException when given customer or employee is not what they are
     * @throws NoSuchElementException when given customer or employee is not in the list of persons
     */
    public static String customerSpeak(List<Person> persons, String customer, String employee) {
        Customer Ccustomer = null;

        for(Person p : persons) {
            if(p.getName().equals(customer)) {
                if(!(p instanceof Customer)) {
                    throw new ClassCastException(p.getName() + " is not a customer");
                } else {
                    Ccustomer = (Customer) p;
                    break;
                }
            }
        }
        if(Ccustomer == null) {
            throw new NoSuchElementException(customer + " does not exist");
        }
        for(Person p: persons) {
            if(p.getName().equals(employee)) {
                if(!(p instanceof Employee)) {
                    throw new ClassCastException(p.getName() + " is not an employee");
                }
                return Ccustomer.speak((Employee) p);
            }
        }

        throw new NoSuchElementException(employee + " does not exist");
    }
}
