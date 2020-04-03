package ru.vsu;

import org.apache.log4j.Logger;
import ru.vsu.lab.entities.enums.Gender;

import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

@XmlRootElement
public class WorkWithFile {
    private final static Logger logger = Logger.getLogger(WorkWithFile.class.toString());
    List<Division> divisions = new ArrayList<Division>();

    public WorkWithFile() {
    }

    public List<Division> getDivisions() {
        return divisions;
    }

    /**
     * The method reads information from a user file and then adds it to Repository
     *
     * @return list with persons
     * @throws IOException
     */
    public Repository<Person> readFromFile() throws IOException {
        int count = 0;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        Repository newList = new Repository();
        BufferedReader reader = new BufferedReader(new FileReader("persons.csv"));
        try {
            logger.trace("Read from file person.csv was started");
            String readLine = reader.readLine();
            while ((readLine = reader.readLine()) != null) {
                count++;
                String[] r = readLine.split(";");
                Person person = new Person();
                int i = 0;
                person.setId(Integer.parseInt(r[i++]));
                person.setFirstName(r[i++]);
                person.setGender(Gender.valueOf(r[i++].toUpperCase()));
                person.setBirthdate(LocalDate.parse(r[i++], formatter));
                person.setDivision(checkDivision(r[i++]));
                person.setSalary(new BigDecimal(r[i++]));
                newList.add(person);
            }
            reader.close();
        } catch (IOException e) {
            logger.fatal("IOException! ",e);
            e.printStackTrace();
        } finally {
            reader.close();
            logger.info("Read from file person.csv was end");
        }
        System.out.println("Count = " + count);
        return newList;
    }

    private Division checkDivision(String name) {
        Division division = new Division(Math.abs(new Random().nextInt()), name);
        boolean flag = true;
        Division check = null;
        Iterator<Division> it = divisions.iterator();
        while (it.hasNext() && flag) {
            check = it.next();

            if (name.compareTo(check.getName()) == 0) {
                division = check;
                flag = false;
            }
        }
        if (flag) {
            divisions.add(division);
            return new Division(Math.abs(new Random().nextInt()), name);
        } else {
            return check;
        }
    }

    public Map<String, String> toMap() {
        String[] array = new String[2];
        Map<String, String> map = new HashMap<>();

        try {
            String c;
            BufferedReader reader = new BufferedReader(new FileReader("Annotation.txt"));
            while ((c = reader.readLine()) != null) {
                array = c.split(" = ");
                map.put(array[1], array[0]);
            }
            reader.close();
        } catch (IOException e) {
           //reader.close();
            e.printStackTrace();
        }
        return map;
    }

    @Override
    public String toString() {
        return "WorkWithFile{" +
                "divisions=" + divisions +
                '}';
    }
}

