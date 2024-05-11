import java.io.*;
import java.net.*;
import java.util.List;

public class ThreadHandler implements Runnable {
    private Socket clientSocket;

    public ThreadHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public static Socket[] getClients() {
        return new Socket[0];
    }

    @Override
    public void run() {
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Receive client ID from client
            String clientId = in.readLine();
            System.out.println("Client ID: " + clientId);

            // Send response to client
            String response = "Response from server: " + clientId;
            out.println(response);

            // Receive request from client
            String request = in.readLine();
            System.out.println("Request from client: " + request);

            // Parse request
            String[] parts = request.split(" ");
            String course = parts[1];
            String type = parts[2];

            // Handle request based on type
            if (type.equals("faculty")) {
                // Get list of instructors for course
                List<String> instructors = Server.getInstructors(course);

                // Send response to client
                if (instructors!= null) {
                    response = "Number of faculty members: " + ((List<?>) instructors).size();
                    for (String instructor : instructors) {
                        response += "\n" + instructor;
                    }
                } else {
                    response = "No information available for course " + course;
                }
                out.println(response);
            } else if (type.equals("number")) {
                // Get number of faculty members for course
                List<String> instructors = Server.getInstructors(course);

                // Send response to client
                if (instructors!= null) {
                    response = "Number of faculty members: " + instructors.size();
                } else {
                    response = "No information available for course " + course;
                }
                out.println(response);
            } else {
                // Send error response to client
                response = "Invalid request type: " + type;
                out.println(response);
            }

            // Close socket
            clientSocket.close();
            System.out.println("Client disconnected: " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
