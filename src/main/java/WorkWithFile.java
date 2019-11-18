import org.joda.time.LocalDate;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class WorkWithFile {

    public WorkWithFile() {
    }

    /**
     * The method reads information from a user file and then adds it to ListForPerson
     * @return list with persons
     * @throws IOException
     */
    public ListForPerson readFromFile() throws IOException {
        int count=0;
        DateTimeFormatter fmt = DateTimeFormat.forPattern("DD.MM.YYYY");
        ListForPerson newList = new ListForPerson();
        BufferedReader reader = new BufferedReader(new FileReader("persons.csv"));
        try {
            String readLine = reader.readLine();
            while ((readLine = reader.readLine()) != null) {
                count++;
                String[] r = readLine.split(";");
                Person person = new Person();
                int i = 0;
                person.setId(Integer.parseInt(r[i++]));
                person.setName(r[i++]);
                person.setSex(r[i++]);
                person.setDateOfBirth(LocalDate.parse(r[i++], fmt));
                person.setDivision(r[i++]);
                person.setSalary(Integer.parseInt(r[i++]));
                newList.add(person);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error!");
            e.printStackTrace();
        } finally {
            reader.close();
        }
        System.out.println("Count = "+count);
        return newList;
    }

}

