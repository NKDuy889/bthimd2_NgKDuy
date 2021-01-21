import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class PhoneManager {
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    List<Phonebook> list = new ArrayList<>();

    public void addList(Scanner sc) {
        Phonebook phonebook = new Phonebook();
        System.out.println("Enter phone number: ");
        String b = sc.next();
        phonebook.setPhoneNumber(checkPN(b, sc));
        System.out.println("Enter group contacts: ");
        phonebook.setGroupContacts(sc.next());
        System.out.println("Enter a name: ");
        phonebook.setName(sc.next());
        System.out.println("Enter gender: ");
        phonebook.setGender(sc.next());
        System.out.println("Enter address");
        phonebook.setAddress(sc.next());
        System.out.println("Enter date f birth: ");
        phonebook.setDateOfBirth(sc.next());
        System.out.println("Enter email: ");
        phonebook.setEmail(sc.next());
        list.add(phonebook);
        writeToFile();
    }

    public String checkPN(String a, Scanner sc) {

        for (Phonebook p : list) {
            if (a.equals(p.getPhoneNumber())) {
                System.out.println("Phone number exist.Try another phone number: ");
                a = sc.next();
                return checkPN(a, sc);
            }
        }
        return a;
    }

    public void showList() {
        for (Phonebook p : list) {
            if (list.isEmpty()) {
                System.out.println("List empty");
            } else {
                System.out.println(p);
            }
        }
    }

    public Phonebook phonebook() {
        if (list.isEmpty()) {
            System.out.println("LIST IS EMPTY. PLEASE ADD");
            return null;
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter phone number: ");
        String a = sc.next();
        sc.nextLine();
        for (Phonebook p : list) {
            if (a.equals(p.getPhoneNumber())) {
                return p;
            } else {
                System.out.println("Don't have this phone number. Try again");
            }
        }
        return phonebook();
    }

    public void changeGroup(Scanner sc) {
        Phonebook phonebook = phonebook();
        if (!Objects.isNull(phonebook)) {
            System.out.println("Enter group you want change: ");
            phonebook.setGroupContacts(sc.next());

        }
    }

    public void changeName(Scanner sc) {
        Phonebook phonebook = phonebook();
        if (!Objects.isNull(phonebook)) {
            System.out.println("Enter name you want change: ");
            phonebook.setName(sc.next());
        }
    }

    public void changeGender(Scanner sc) {
        Phonebook phonebook = phonebook();
        if (!Objects.isNull(phonebook)) {
            System.out.println("Enter gender you want change: ");
            phonebook.setGender(sc.next());
        }
    }

    public void changeAddress(Scanner sc) {
        Phonebook phonebook = phonebook();
        if (!Objects.isNull(phonebook)) {
            System.out.println("Enter group you want change: ");
            phonebook.setAddress(sc.next());
        }
    }

    public void changeDate(Scanner sc) {
        Phonebook phonebook = phonebook();
        if (!Objects.isNull(phonebook)) {
            System.out.println("Enter date you want change: ");
            phonebook.setDateOfBirth(sc.next());
        }
    }

    public void changeEmail(Scanner sc) {
        Phonebook phonebook = phonebook();
        if (!Objects.isNull(phonebook)) {
            System.out.println("Enter group you want change: ");
            phonebook.setEmail(sc.next());
        }
    }

    public void delete(Scanner sc) {
        Phonebook phonebook = phonebook();
        if (!Objects.isNull(phonebook)) {
            list.remove(phonebook);
            writeToFile();
        }
    }

    public void display() {
        Phonebook phonebook = phonebook();
        if (!Objects.isNull(phonebook)) {
            System.out.println(phonebook);
        }
    }

    public void writeToFile() {
        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter("src/file.csv");
            for (Phonebook phonebook : list) {
                fileWriter.append(phonebook.getPhoneNumber());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phonebook.getGroupContacts());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phonebook.getName());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phonebook.getAddress());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phonebook.getGender());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phonebook.getDateOfBirth());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(phonebook.getEmail());
                fileWriter.append(NEW_LINE_SEPARATOR);
            }
            System.out.println("CSV file was created successfully !!!");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }
        }
    }

    public void readFile() {
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/file.csv"));
            while ((line = br.readLine()) != null) {
                Phonebook pb = new Phonebook();
                String[] phonebook = line.split(splitBy);
                System.out.println("Phonebook: " + phonebook[0] + ", " + phonebook[1] + ", " + phonebook[2] + ", " + phonebook[3] + ", " + phonebook[4] + ", " + phonebook[5] + ", " + phonebook[6]);
                pb.setPhoneNumber(phonebook[0]);
                pb.setGroupContacts(phonebook[1]);
                pb.setName(phonebook[2]);
                pb.setGender(phonebook[3]);
                pb.setAddress(phonebook[4]);
                pb.setDateOfBirth(phonebook[5]);
                pb.setEmail(phonebook[6]);
                list.add(pb);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
