package top.ztf.myServlet;

import top.ztf.http.Request;
import top.ztf.http.Response;
import top.ztf.servlet.HttpServlet;

public class UserServlet extends HttpServlet {

    @Override
    public void doGet(Request request, Response response) {

    }

    @Override
    public void doPost(Request request, Response response) {
        doGet(request,response);
    }
}
