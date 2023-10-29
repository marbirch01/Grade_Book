import java.util.*;

public class ClassContainer {

    String className;

    HashMap<String, Class> classMap = new HashMap<>();

    public void addClass (String name, Class studentClass){
        if(classMap.containsKey(name)){
            System.out.println("Grupa znajduję się już w klasie.");
        }else {
            classMap.put(name, studentClass);
            System.out.println("Dodano grupę " + name + " do klasy");
        }
    }
    public void removeClass(String name){
        if (classMap.containsKey(name)) classMap.remove(name);
        System.out.println("Usunięto grupe z klasy.");
    }
    public List<String> findEmpty(){
        List<String> empty = new ArrayList<>();
        for (Map.Entry<String, Class> entry : classMap.entrySet()) {
            if (entry.getValue().studentList.isEmpty()){
                empty.add(entry.getKey());
            }
        }
        return empty;
    }
    public void summary(){
        for (Map.Entry<String, Class> entry : classMap.entrySet()) {
            System.out.println("Key: " + entry.getKey());
            int max = entry.getValue().maxNumberOfStudents;
            int i = entry.getValue().studentList.size();
            int x = (100 * i)/max;
            System.out.println(x + "%");
        }
    }

}
