package top.ztf.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Request {

    private String method;
    private String url;
    private InputStream inputStream;


    public Request(InputStream in) {
        this.inputStream = in;
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = null;
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            while ((line=reader.readLine())!=null){
                arrayList.add(line);
            }

        }catch (Exception e){

        }
        String[] split = arrayList.get(0).split(" ");
        // 方法的方式
        String s1 = split[0];

        // 访问路径以及参数
        String s2=split[1];
        if (split[1].contains("?")){
            s2 = split[1].split("[?]")[0];
        }

        method = s1;
        url = s2;

    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public String getMethod() {
        return method;
    }

    public String getUrl() {
        return url;
    }
}
