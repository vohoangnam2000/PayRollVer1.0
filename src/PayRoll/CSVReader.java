/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PayRoll;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ArtStyle
 */
public class CSVReader {
    private final int MENULINE = 1;
    private final String BREAK_COLUMN = ",";
    private final String PATTERN_DATE = "yyyyMMdd";
    private final static int NAMECOLUMN = 0;
    private final static int DOBCOLUMN = 1;
    private final static int ROLECOLUMN = 2;
    private final static int STRARTDATECOLUMN = 3;
    private final static int SALARYCOLUMN = 4;
    private final float MEANYEAR = 365.2425f;
    private int rowCSV = 1; 
    public List<Employee> readEmployeesFromCSV (String fileName){
        List<Employee> employees = new ArrayList();
        try {
            FileInputStream fis = new FileInputStream(new File(fileName));
            BufferedReader stdin = new BufferedReader(new InputStreamReader(fis));
            while (stdin.ready()) {//đọc theo dòng
                    String line = stdin.readLine();
                    if(rowCSV != MENULINE){//Khong doc menu
                        //System.out.println(line);
                        String[] attributes = line.split(BREAK_COLUMN);
                        Employee employee = createEmployee(attributes);
                        employees.add(employee);
                    }
                    rowCSV++;
                }
        } catch (IOException ex) {
            System.out.println("File Errors");
        }
        return employees;
    }
    public static Employee createEmployee(String[] metaData){
        String name = metaData[NAMECOLUMN]; //Name 
        String dob = metaData[DOBCOLUMN];   //dob
        String role = metaData[ROLECOLUMN];  //role
        String startDate = metaData[STRARTDATECOLUMN];//startDate
        int startSalary = Integer.valueOf(metaData[SALARYCOLUMN]);
        return new Employee(name,dob,role,startDate,startSalary);
    }
    public LocalDate convertLocalDate(String strDate){
        DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern(PATTERN_DATE);
        LocalDate localDate = LocalDate.parse(strDate, DATEFORMATTER);
        return localDate;
    }
    public int dateDiff(LocalDate firstDate,LocalDate lastDate){
        return (int) ((int) firstDate.until(LocalDate.now(), ChronoUnit.DAYS) / MEANYEAR);
    }
}
