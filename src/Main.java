import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println(">>>>>>>>>>>>>>>Wypisanie danych studenta<<<<<<<<<<<<<<<\n");
        Student s1 = new Student("Marcin","Brzózka",StudentCondition.Nieobecny,2001,4.0);
        s1.print();

        System.out.println(">>>>>>>>>>>>>>>Compare:<<<<<<<<<<<<<<<\n");
        Student s2 = new Student("Piotr","Nowak",StudentCondition.Chory,2000,8.0);
        Student s3 = new Student("Tomek","Nowak",StudentCondition.Odrabiajacy,1999,3.0);
        if (s1.compare(s2)){
            System.out.println("Studenci mają takie samo nazwisko");
        }else System.out.println("Studenci mają inne nazwisko");
        if (s2.compare(s3)){
            System.out.println("Studenci mają takie samo nazwisko");
        }else System.out.println("Studenci mają inne nazwisko");

        System.out.println(">>>>>>>>>>>>>>>Dodawanie do grupy:<<<<<<<<<<<<<<<\n");
        List student = new ArrayList<>();
        student.add(s1);
        student.add(s2);
        student.add(s3);
        Class c1 = new Class("3a",student,6);
        Student s4 = new Student("Jacek","Kowalski",StudentCondition.Odrabiajacy,2002,2.0);
        c1.addStudent(s4);

        System.out.println(">>>>>>>>>>>>>>>Dodawanie punktów studentowi:<<<<<<<<<<<<<<<\n");
        c1.addPoints(s1,3.5);
        s1.print();

        System.out.println(">>>>>>>>>>>>>>>getStudent:<<<<<<<<<<<<<<<\n");
        Student s5 = new Student("Rafał","Stefański",StudentCondition.Odrabiajacy,2001,0.0);
        c1.addStudent(s5);
        c1.getStudent(s5);
        for (Student s : c1.studentList) System.out.println(s.name + " " + s.studentStatus);

        System.out.println(">>>>>>>>>>>>>>>Zmiana statusu:<<<<<<<<<<<<<<<\n");
        c1.changeCondition(s1, StudentCondition.Odrabiajacy);
        for (Student s : c1.studentList) System.out.println(s.name + " " + s.studentStatus);

        System.out.println(">>>>>>>>>>>>>>>Usuwanie punktów:<<<<<<<<<<<<<<<\n");
        c1.removePoints(s2,2.0);
        s2.print();

        System.out.println(">>>>>>>>>>>>>>>Szukanie po fragmencie:<<<<<<<<<<<<<<<\n");
        List<Student> f1 = c1.searchPartial("No");

        System.out.println(">>>>>>>>>>>>>>>Summary grupy:<<<<<<<<<<<<<<<\n");
        c1.summary();

        System.out.println(">>>>>>>>>>>>>>>Sortowanie grupy po nazwiskach:<<<<<<<<<<<<<<<\n");
        c1.sortByName();
        c1.summary();

        System.out.println(">>>>>>>>>>>>>>>Sortownie grupy po punktach:<<<<<<<<<<<<<<<\n");
        c1.sortByPoints();
        c1.summary();

        System.out.println(">>>>>>>>>>>>>>>Max:<<<<<<<<<<<<<<<\n");
        c1.max();

        System.out.println(">>>>>>>>>>>>>>>Dodawanie grupy do klasy:<<<<<<<<<<<<<<<\n");
        ClassContainer con1 = new ClassContainer();
        con1.addClass(c1.groupName,c1);

        System.out.println(">>>>>>>>>>>>>>>Usuwanie grupy z klasy:<<<<<<<<<<<<<<<\n");
        con1.removeClass("3a");

        System.out.println(">>>>>>>>>>>>>>>Szukanie pustych grup:<<<<<<<<<<<<<<<\n");
        con1.addClass(c1.groupName,c1);
        List<Student> student2 = new ArrayList<>();
        Class c2 = new Class("3b",student2,8);
        con1.addClass(c2.groupName,c2);
        List<String> empty = con1.findEmpty();
        for (String s : empty) {
            System.out.println("Nazwa pustej grupy: " + s);
        }

        System.out.println(">>>>>>>>>>>>>>>Podsumowanie klasy:<<<<<<<<<<<<<<<\n");
        con1.summary();
    }
}