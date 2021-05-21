package top.ztf;

import java.io.*;
import java.net.Socket;

public class SocketDemo2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 80);
        new Thread(() -> {
            while (true) {
                InputStream inputStream = null;
                BufferedReader bf = null;
                try {
                    inputStream = socket.getInputStream();
                    bf = new BufferedReader(new InputStreamReader(inputStream));
                    String len = null;
                    while ((len=bf.readLine())!=null) {
                        System.out.println(len);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (bf != null) {
                        try {
                            bf.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }

        });
    }
}
