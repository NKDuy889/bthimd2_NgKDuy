import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PhoneManager pm = new PhoneManager();

        pm.writeFileToList();
        int choice;
        do {
            System.out.println("1. Add phonebook");
            System.out.println("2. Show phonebook");
            System.out.println("3. Change phonebook");
            System.out.println("4. Delete phonebook");
            System.out.println("5. Find phonebook");
            System.out.println("6. Write to file csv");
            System.out.println("7. Read file csv");
            System.out.println("Your choice");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    pm.addList(sc);
                    break;
                case 2:
                    pm.showList();
                    break;
                case 3:
                    System.out.println("1. Change group");
                    System.out.println("2. Change name");
                    System.out.println("3. Change gender");
                    System.out.println("4. Change address");
                    System.out.println("5. Change date");
                    System.out.println("6. Change email");
                    System.out.println("Your chose:  ");
                    int b = sc.nextInt();
                    sc.nextLine();
                    switch (b) {
                        case 1:
                            pm.changeGroup(sc);
                            break;
                        case 2:
                            pm.changeName(sc);
                            break;
                        case 3:
                            pm.changeGender(sc);
                            break;
                        case 4:
                            pm.changeAddress(sc);
                            break;
                        case 5:
                            pm.changeDate(sc);
                            break;
                        case 6:
                            pm.changeEmail(sc);
                            break;
                    }
                    break;
                case 4:
                    pm.delete(sc);
                    break;
                case 5:
                    pm.display();
                    break;
                case 6:
                    pm.writeToFile();
                    break;
                case 7:
                    pm.readFile();
            }
        } while (choice != 0);
    }
}
