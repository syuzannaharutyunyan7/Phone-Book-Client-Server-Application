import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class PhoneNumberServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        Map<String, String> phoneBook = new HashMap<>();

        while (true) {
            Socket clientSocket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String line;
            while ((line = in.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts[0].equals("add") && parts.length == 3) {
                    phoneBook.put(parts[1], parts[2]);
                    out.println("ok");
                } else if (parts[0].equals("search") && parts.length == 2) {
                    String number = phoneBook.get(parts[1]);
                    if (number != null) {
                        out.println(number);
                    } else {
                        out.println("not found");
                    }
                } else if (parts[0].equals("quit")) {
                    break;
                } else {
                    out.println("error");
                }
            }
            clientSocket.close();
        }
    }
}

