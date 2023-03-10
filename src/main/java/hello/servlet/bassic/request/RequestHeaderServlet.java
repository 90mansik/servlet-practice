package hello.servlet.bassic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        printStartLine(request, response);
        printHeaders(request);
        printHeaderEtc(request);

    }

    private static void printStartLine(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("====== REQEUST-LINE - start ======");
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request);
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello " + username);
        System.out.println("====== REQEUST-LINE - end ======");
    }

    private void printHeaders(HttpServletRequest request) {
        System.out.println("==== Headers - start ========");

        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            System.out.println(headerName + ": " + headerName);
        }

        System.out.println("======= Headers - end ========");
        System.out.println();

    }

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("==== Headers ํธ์์กฐํ start ========");
        System.out.println("==== [Host ํธ์ ์กฐํ] ========");
        System.out.println("request.getServerName() = "  + request.getServerName());        // Host ํค๋
        System.out.println("request.getServerPort() = " + request.getServerPort());         // Host ํค๋
        System.out.println();

        System.out.println("[Accept-Language ํธ์ ์กฐํ");

        System.out.println("[cookie ํธ์ ์กฐํ]");
        if( request.getCookies() == null){
            for (Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content ํธ์ ์กฐํ]");
        System.out.println(" request.getContentType() = " + request.getContentType());
        System.out.println(" request.getContentLength() = " + request.getContentLength());
        System.out.println(" request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("======== Header ํธ์ ์กฐํ end ========");
        System.out.println();
    }

    private void printHeaderEtc(HttpServletRequest request) {
        System.out.println("==== Headers ๊ธฐํ์?๋ณด start ========");
        System.out.println("==== [Remote ์?๋ณด ์กฐํ] ========");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request..getRemotePort() = " + request.getRemotePort());

        System.out.println("[Local ์?๋ณด]");
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());

        System.out.println("==== Headers ๊ธฐํ์?๋ณด end ========");
    }

}
