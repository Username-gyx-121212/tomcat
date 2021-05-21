package top.ztf.servlet;

import top.ztf.http.Request;
import top.ztf.http.Response;

/**
 * 使用模板方法 访问 service方法
 */
public abstract class HttpTemplateServlet implements Servlet{

    @Override
    public void init() throws Exception {

    }

    @Override
    public void service(Request request, Response response) throws Exception {
        String method = request.getMethod();
        if ("GET".equals(method)){
            doGet(request, response);
        }else if ("POST".equals(method)){
            doPost(request, response);
        }
    }

    @Override
    public void destroy() {

    }

    abstract void doGet(Request request, Response response);
    abstract void doPost(Request request, Response response);


}
