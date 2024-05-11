import java.io.*;
import java.net.*;

public class Clients {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 1234;

    public static void main(String[] args) {
        try {
            Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
            System.out.println("Connected to server.");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send client ID to server
            String clientId = "Client " + socket.getLocalPort();
            out.println(clientId);

            // Receive response from server
            String response = in.readLine();
            System.out.println("Response from server: " + response);

            // Send request for number of faculties in CS202 course to server
            out.println("CS202");
            response = in.readLine();
            System.out.println("Response from server: " + response);

            // Send request for names of faculty members in CS202 course to server
            out.println("faculty");
            response = in.readLine();
            System.out.println("Response from server: " + response);

            // Send request for number of faculties in MA203 course to server
            out.println("MA203");
            response = in.readLine();
            System.out.println("Response from server: " + response);

            // Send request for names of faculty members in MA203 course to server
            out.println("faculty");
            response = in.readLine();
            System.out.println("Response from server: " + response);

            // Send request for number of faculties in CS201 course to server
            out.println("CS201");
            response = in.readLine();
            System.out.println("Response from server: " + response);

            // Send request for names of faculty members in CS201 course to server
            out.println("faculty");
            response = in.readLine();
            System.out.println("Response from server: " + response);

            // Close socket
            socket.close();
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
