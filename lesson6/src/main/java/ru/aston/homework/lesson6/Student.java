package ru.aston.homework.lesson6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Student {

    private String name;            // имя
    private String group;           // группа
    private int course;             // курс
    private List<Integer> grades;   // оценки по предметам

    public Student(String name, String group, int course, List<Integer> grades) {
        this.name = name;
        this.group = group;
        this.course = course;
        this.grades = new ArrayList<>(grades); // копирование списка, чтобы снаружи его нельзя было случайно изменить
    }

    public String getName() {

        return name;
    }

    public String getGroup() {

        return group;
    }

    public int getCourse() {

        return course;
    }

    public void setCourse(int course) {

        this.course = course;
    }

    public List<Integer> getGrades() {

        return grades;
    }

    // Метод для вычисления среднего балла студента
    public double getAverageGrade() {
        if (grades.isEmpty()) {
            return 0.0; // если оценок нет, средний балл 0
        }
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    //Статические методы для работы с коллекциями.
    // Удаление всех студентов, у которых средний балл < 3.
    public static void removeLowGradeStudents(Set<Student> students) {
        students.removeIf(student -> student.getAverageGrade() < 3.0);
    }

    // Перевод студентов на следующий курс, если средний балл >= 3.
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverageGrade() >= 3.0) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    // Вывод имен студентов, которые учатся на указанном курсе.
    public static void printStudents(Set<Student> students, int course) {
        System.out.println("Студенты на курсе " + course + ":");
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }

    public static void main(String[] args) {
        // Создание коллекции
        Set<Student> students = new HashSet<>();

        // Добавление студентов
        students.add(new Student("Сергей", "305", 1, List.of(4, 5, 3)));
        students.add(new Student("Мария", "305", 1, List.of(2, 2, 3)));  // средний < 3
        students.add(new Student("Пётр", "406", 2, List.of(3, 4, 3)));
        students.add(new Student("Виктория", "406", 2, List.of(5, 5, 4)));

        // Вывод студентов по курсам до изменений
        System.out.println("До удаления и перевода:");
        printStudents(students, 1);
        printStudents(students, 2);
        System.out.println("---------------");

        // Удаление студентов со средним баллом < 3
        removeLowGradeStudents(students);

        // Перевод оставшихся студентов на следующий курс
        promoteStudents(students);

        // Вывод студентов по курсам после изменений
        System.out.println("После удаления (avg < 3) и перевода (avg >= 3):");
        printStudents(students, 1);
        printStudents(students, 2);
        printStudents(students, 3);
    }
}


