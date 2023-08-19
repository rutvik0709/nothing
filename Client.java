import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private BufferedReader bufferedreader;
    private BufferedWriter bufferedwriter;
    private String clientUsername;

    public Client(Socket socket, String username) {
        try {
            this.socket = socket;
            this.bufferedwriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedreader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.clientUsername = username;
        } catch (IOException e) {
            closeEverything(socket, bufferedreader, bufferedwriter);
        }
    }

    public void sendMessage() {
        try {
            // bufferedwriter.write("You have connected successfully"); //new line added
            bufferedwriter.newLine();
            bufferedwriter.write(clientUsername);
            bufferedwriter.newLine();
            bufferedwriter.flush();

            Scanner scanner = new Scanner(System.in);
            while (socket.isConnected()) {
                String messagetoSend = scanner.nextLine();
                bufferedwriter.write(clientUsername + ": " + messagetoSend);
                bufferedwriter.newLine();
                bufferedwriter.flush();
            }
        } catch (IOException e) {
            closeEverything(socket,bufferedreader,bufferedwriter); 
        }
    }
    public void listenForMessage(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroupChat;
                // if(socket.isConnected()) {
                //     System.out.println("COnnected successfully!");
                // }
                while(socket.isConnected()){
                    try{
                        msgFromGroupChat = bufferedreader.readLine();
                        System.out.println(msgFromGroupChat);
                    }catch (IOException e){
                        closeEverything(socket,bufferedreader,bufferedwriter);
                    }
                }
            }
        }).start();
    }
    public void closeEverything(Socket socket, BufferedReader bufferedreader, BufferedWriter bufferedwriter){
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
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name for the group chat: ");
        String clientUsername = scanner.nextLine();
        Socket socket = new Socket("localhost", 1234);
        if(socket != null){
            System.out.println("Connected successfully...");
        }else{
            System.out.println("Connection Unsuccessfull ...");
        }
        Client client = new Client(socket,clientUsername);

        client.listenForMessage();
        client.sendMessage();
    }
}
