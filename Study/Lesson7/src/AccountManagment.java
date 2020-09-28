import java.io.IOException;
import java.util.Scanner;

public class AccountManagment {

    AccountCreator startCreator = new AccountCreator();
    Scanner in = new Scanner(System.in);
    FileCreator fileController = new FileCreator();

    public void startAccountManagment() throws UnknownAccountException, NotEnoughMoneyException, IOException {

        fileController.isFileExistChecker();
        //fileController.getFileName();
        System.out.println("Введите команду");
        String s = in.nextLine();
        String words[] = s.split(" ");

        switch (words[0]) {
            case "balance":
                startCreator.balance(Integer.parseInt(words[1]));
                break;
            case "withdraw":
                startCreator.withdraw(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
                break;
            case "deposit":
                startCreator.deposit(Integer.parseInt(words[1]), Integer.parseInt(words[2]));
                break;
            case "transfer":
                startCreator.transfer(Integer.parseInt(words[1]), Integer.parseInt(words[3]), Integer.parseInt(words[2]));
                break;
            default:
                System.out.println("Команда не найдена");
                startAccountManagment();
        }

    }
}
