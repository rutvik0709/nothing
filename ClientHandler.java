import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedreader;
    private BufferedWriter bufferedwriter;
    private String clientUsername;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedwriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = bufferedreader.readLine();
            clientHandlers.add(this);
            // broadcastMessage("Connected successfully");
            broadcastMessage("SERVER: " + clientUsername + " has joined the chat.");

        } catch (IOException e) {
            closeEverything(socket, bufferedreader, bufferedwriter);
        }
    }

    @Override
    public void run() {
        String messageFromClient;
        while (socket.isConnected()) {
            try {
                messageFromClient = bufferedreader.readLine();
                // broadcastMessage("Your message is sent successfully!");//new added
                broadcastMessage(messageFromClient);
            } catch (IOException e) {
                closeEverything(socket, bufferedreader, bufferedwriter);
                break;
            }
        }
    }
    public void broadcastMessage(String messageToSend){
        for(ClientHandler clientHandler : clientHandlers){
            try{
                if(!clientHandler.clientUsername.equals(clientUsername)){
                    clientHandler.bufferedwriter.write(messageToSend);
                    clientHandler.bufferedwriter.newLine();
                    clientHandler.bufferedwriter.flush();
                }
            }catch(IOException e){
                closeEverything(socket, bufferedreader, bufferedwriter);
            }
        }
    }

    public void removeClientHandler(){
        clientHandlers.remove(this);
        broadcastMessage("SERVER: "+clientUsername+" has left the chat.");
    }
    public void closeEverything(Socket socket, BufferedReader bufferedreader, BufferedWriter bufferedwriter){
        removeClientHandler();
        try{
            if(bufferedreader !=null){
                bufferedreader.close();
            }
            if(bufferedwriter !=null){
                bufferedwriter.close();
            }
            if(socket !=null){
                socket.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}