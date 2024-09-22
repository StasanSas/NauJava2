package org.example.Tasks;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class Employee{
    String fullName;
    int age;
    String department;
    double salary;
}

public class StreamAPI {
    public static void printResult() {
        var listEmployees = new ArrayList<Employee>(5);
        Employee employee1 = new Employee("Симонов Иван Евгеньевич", 30,
                "Кафедра матанализа", 50_000);
        Employee employee2 = new Employee("Косолобов Дмитрий Александрович", 35,
                "Кафедра линейной алгебры", 45_000);
        Employee employee3 = new Employee("Домашних Иван Алексеевич", 24,
                "Отдел проектной деятельности", 1_000_000);
        Employee employee4 = new Employee("Шур Арсений Михайлович", 45,
                "Кафедра дискретной математики", 60_000);
        Employee employee5 = new Employee("Хлопин Дмитрий Валерьевич", 1_000,
                "Кафедра теории вероятности", 98_765);
        listEmployees.add(employee1);
        listEmployees.add(employee2);
        listEmployees.add(employee3);
        listEmployees.add(employee4);
        listEmployees.add(employee5);
        var sumSalary = listEmployees.stream().map(e -> e.salary)
                                     .reduce((sum, el)->sum+el)
                                     .get();
        System.out.println(sumSalary / listEmployees.size());
    }
};



