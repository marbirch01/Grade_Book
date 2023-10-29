import java.util.*;
import java.util.stream.Collectors;

public class Class {

    String groupName;
    List<Student> studentList;
    int maxNumberOfStudents;

    Class(String groupName, List<Student> studentList, int maxNumberOfStudents) {
        this.groupName = groupName;
        this.studentList = studentList;
        this.maxNumberOfStudents = maxNumberOfStudents;
    }

    public void addStudent(Student student) {
        if (studentList.size() < maxNumberOfStudents) {
            if (!studentList.contains(student)) {
                studentList.add(student);
                System.out.println("Dodano studenta");
            } else {
                System.out.println("Student jest już na liście");
            }
        } else {
            System.err.println("Error przekroczona ilosć studentów w Grupie");
        }
    }
    public void addPoints(Student student, double points){
        student.points += points;
    }
    public void getStudent(Student student) {
        studentList.removeIf(s -> s == student && s.points == 0);
//        for (Student s : studentList) {
//            if (s == student && s.points == 0) {
//                studentList.remove(s);
//            }
//        }
    }
    public void changeCondition(Student student, StudentCondition studentCondition){
        for (Student s : studentList){
            if (s == student){
                s.studentStatus = studentCondition;
            }
        }
    }
    public void removePoints(Student student, double points){
       student.points -= points;
    }

    public Student search(String lastname) throws Exception {
        Student student = new Student(lastname);
        for (Student s : studentList){
            if (s.compare(student)){
                return s;
            }
        }
        throw new Exception("Nie znaleziono studenta");
    }

    public List<Student> searchPartial (String partial){
        List<Student> students = new ArrayList<>();
        for (Student s : studentList){
            if (s.lastName.contains(partial)) {
                students.add(s);
                System.out.println(s.lastName);
            }
        }
        return students;
    }

    public List<Student> searchPartialStreamApi (String partial){
         return studentList
                 .stream()
                 .filter(s -> s.lastName.contains(partial))
                 .collect(Collectors.toList());
    }

    public List<Student> countByCondition (StudentCondition studentCondition){
        List<Student> students = new ArrayList<>();
        for (Student s : studentList){
            if (s.studentStatus == studentCondition)
                students.add(s);
        }
        return students;
    }

    public void summary(){
        for (Student s : studentList){
            s.print();
        }
    }

    public  List<Student> sortByName(){
        studentList.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        });
        return studentList;
    }
    public List<Student> sortByPoints(){
        studentList.sort(new Komparator());
        Collections.reverse(studentList);
        return studentList;
    }
    void max (){
        System.out.println(Collections.max(studentList, new Komparator()));
    }
    public static class Komparator implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            if (o1.points > o2.points) return 1;
            else return -1;
        }
    }


}
