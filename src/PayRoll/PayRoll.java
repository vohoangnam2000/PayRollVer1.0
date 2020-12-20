/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayRoll;

import java.util.List;


/**
 *
 * @author ArtStyle
 */
public class PayRoll {
    public final static String FILENAME = "employee.csv";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CSVReader csvReaderInJava = new CSVReader();
        Company company = new Company();
        List<Employee> employees = csvReaderInJava.readEmployeesFromCSV(FILENAME);
        company.caculateSalary(employees);
        company.printEmployees(employees);
    }
}
