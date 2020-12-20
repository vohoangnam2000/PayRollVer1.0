/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayRoll;

import java.time.LocalDate;

/**
 *
 * @author ArtStyle
 */
public class Employee {    
    private String name;
    private String dob;
    private String role;
    private String startDate;
    private int startSalary;
    private int age;
    private int currentSalary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getStartSalary() {
        return startSalary;
    }

    public void setStartSalary(int startSalary) {
        this.startSalary = startSalary;
    }

    public int getAge() {
        CSVReader CSVReader = new CSVReader();
        LocalDate birthDay = CSVReader.convertLocalDate(this.dob);
        return CSVReader.dateDiff(birthDay, LocalDate.now());
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCurrentSalary() {
        return currentSalary;
    }

    public void setCurrentSalary(int currentSalary) {
        this.currentSalary = currentSalary;
    }
    public Employee(String name, String dob, String role,String startDate,int startSalary) {
        this.name =  name;
        this.dob = dob;
        this.role = role;
        this.startDate = startDate;
        this.startSalary =  startSalary;
    }

    @Override
    public String toString() {
        return "Employee{" + "name=" + name + ", dob=" + dob + ", role=" + role + ", startDate=" + startDate + ", startSalary=" + startSalary + ", age=" + this.getAge() + ", currentSalary=" + currentSalary + '}';
    }    
}
