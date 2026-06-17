package com.tss.test;

import com.tss.model.Employee;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {
    public static void main(String[] args) throws Exception {
        List<Employee> employees=new ArrayList<>();
        employees.add(new Employee(1,"abc",123456));
        employees.add(new Employee(2,"abc",123456));
        employees.add(new Employee(3,"abc",123456));
        employees.add(new Employee(4,"abc",123456));
        employees.add(new Employee(5,"abc",123456));

        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("employee.ser"));
        //oos.writeObject(employees);
        oos.close();

        ObjectInputStream ois =
                new ObjectInputStream(
                        new FileInputStream(
                                "employee.ser"
                        )
                );

       List<Employee> employees1 =
                (ArrayList<Employee>) ois.readObject();

        System.out.println(employees1);

        ois.close();
    }
}
