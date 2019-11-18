import org.joda.time.LocalDate;

import java.io.IOException;

public class MainList {
    public static void main(String[] args) throws IOException {
//        Person firstPerson = new Person(23,"Irina", "Chulkova", new LocalDate(1999,8, 20) , "Female",67899,"F");
//        Person secondPerson = new Person(45,"Olga", "Bezrukova", new LocalDate(1999,5, 30), "Female",90555,"I");
//        Person thirdPerson = new Person(16,"Ivan", "Ivanov", new LocalDate(1999,5, 17),  "Male",34567,"H");
//        Person fourPerson = new Person(56,"Peter", "Parker", new LocalDate(1997,4, 19),  "Male",78555,"Y");
//        Person fivePerson = new Person(11,"Jack", "Maven", new LocalDate(2005,10, 29),  "Male",12345,"U");
//        Person sixPerson = new Person(45,"Jack", "Maven", new LocalDate(2006,11, 30),  "Male",45678,"N");
//        ListForPerson list = new ListForPerson();
//        list.add(firstPerson);
//        list.add(thirdPerson);
//        list.add(fivePerson);
//        list.add(fourPerson);
//        list.add(sixPerson);
//        list.add(thirdPerson);
//        ListForPerson list1 =new ListForPerson();
//        list1.add(firstPerson);
//        list1.add(thirdPerson);
//        list1.add(fivePerson);
//        list1.add(fourPerson);
//        list1.add(sixPerson);
//        list1.add(thirdPerson);
//        list.print();
//        System.out.println("--------------------------------------------");
//        list1.print();
//        System.out.println("--------------------------------------------");
//        list.set(1,sixPerson);
//        System.out.println(list.equals(list1));
//        list.print();
//        System.out.println(list.size());
//        list.remove(1);
//        System.out.println("--------------------------------------------");
//        list.print();
//        list.add(secondPerson);
//        System.out.println("--------------------------------------------");
//        list.print();
//        ListForPerson foundPerson = list.found("Jack");
//        System.out.println("--------------------------------------------");
//        foundPerson.print();
//        ListForPerson foundPerson1 = list.found(22);
//        System.out.println("--------------------------------------------");
//        foundPerson1.print();
//        list.sort(new SortedByName());
//        System.out.println("--------------------------------------------");
//        list.print();
//        list.found(new LocalDate(1999,5,30)).print();
        WorkWithFile file = new WorkWithFile();
        ListForPerson list = new ListForPerson();
        list = file.readFromFile();
        list.print();
    }

}

