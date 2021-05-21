package top.ztf.http;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class Response {
    private OutputStream outputStream;

    public Response(OutputStream out) {
        this.outputStream = out;
    }

    public OutputStream getOutputStream() {
        return outputStream;
    }


    public void writer(String content){
        StringBuffer sb = new StringBuffer();
        byte[] bytes = sb.append("HTTP/1.1 200 ok\n")
                .append("Content-Type:text/html;charset:utf-8\n")
                .append("\n")
                .append(content).toString().getBytes(StandardCharsets.UTF_8);
        try {
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
