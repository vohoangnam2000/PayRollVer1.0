/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayRoll;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author ArtStyle
 */
public class Company {
    public final double rateIncSalary = 0.06;
    public void caculateSalary(List<Employee> employees){
        CSVReader csvReader = new CSVReader();
        employees.forEach((e) -> {
            int seniority = csvReader.dateDiff(csvReader.convertLocalDate(e.getStartDate()), LocalDate.now());
            int currentSalary = e.getStartSalary();
            while(seniority > 0){
                currentSalary += currentSalary * rateIncSalary;
                seniority--;
            }
            e.setCurrentSalary(currentSalary);
        });
    }
    public void printEmployees(List<Employee> employees){
        CSVReader csvReader = new CSVReader();
        employees.forEach((e) -> {
            System.out.println("Employee: " + e.getName()
                               + " - BirthDay: "+ csvReader.convertLocalDate(e.getDob())
                               + " - Age: " + e.getAge()
                               + " - CurrentSalary: " + e.getCurrentSalary()); 
        });
    }
}
