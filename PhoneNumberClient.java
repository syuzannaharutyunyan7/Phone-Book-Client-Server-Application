import java.io.*;
import java.net.*;
import java.util.Scanner;

public class PhoneNumberClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.out.println("Usage: java PhoneNumberClient <server-ip>");
            return;
        }

        Socket socket = new Socket(args[0], 9999);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu: 1-add, 2-search, 0-quit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                System.out.print("Enter number: ");
                String number = scanner.nextLine();
                out.println("add " + name + " " + number);
                System.out.println("Server: " + in.readLine());
            } else if (choice == 2) {
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                out.println("search " + name);
                System.out.println("Server: " + in.readLine());
            } else if (choice == 0) {
                out.println("quit");
                break;
            }
        }
        socket.close();
    }
}

