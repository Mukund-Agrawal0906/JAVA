import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

public class Server {
    private static final int SERVER_PORT = 1234;
    private static Map<String, List<String>> courses = new HashMap<>();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started on port " + SERVER_PORT);

            ExecutorService executorService = Executors.newCachedThreadPool();

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress() + ":" + clientSocket.getPort());

                // Add client to list of connected clients
                executorService.submit(new ThreadHandler(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addCourse(String course, List<String> instructors) {
        courses.put(course, instructors);
    }

    public static List<String> getInstructors(String course) {
        return courses.get(course);
    }

    public static Socket[] getClients() {
        return ThreadHandler.getClients();
    }
}
