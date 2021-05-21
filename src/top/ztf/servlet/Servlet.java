package top.ztf.servlet;

import top.ztf.http.Request;
import top.ztf.http.Response;

public interface Servlet {
    // 初始化方法
    void init() throws Exception;
    // 真正访问的方法
    void service(Request request, Response response) throws Exception;
    // 销毁
    void destroy();
}
