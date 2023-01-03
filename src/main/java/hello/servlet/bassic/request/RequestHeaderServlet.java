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
        System.out.println("==== Headers 편의조회 start ========");
        System.out.println("==== [Host 편의 조회] ========");
        System.out.println("request.getServerName() = "  + request.getServerName());        // Host 헤더
        System.out.println("request.getServerPort() = " + request.getServerPort());         // Host 헤더
        System.out.println();

        System.out.println("[Accept-Language 편의 조회");

        System.out.println("[cookie 편의 조회]");
        if( request.getCookies() == null){
            for (Cookie cookie : request.getCookies()){
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조회]");
        System.out.println(" request.getContentType() = " + request.getContentType());
        System.out.println(" request.getContentLength() = " + request.getContentLength());
        System.out.println(" request.getCharacterEncoding() = " + request.getCharacterEncoding());

        System.out.println("======== Header 편의 조회 end ========");
        System.out.println();
    }

    private void printHeaderEtc(HttpServletRequest request) {
        System.out.println("==== Headers 기타정보 start ========");
        System.out.println("==== [Remote 정보 조회] ========");
        System.out.println("request.getRemoteHost() = " + request.getRemoteHost());
        System.out.println("request.getRemoteAddr() = " + request.getRemoteAddr());
        System.out.println("request..getRemotePort() = " + request.getRemotePort());

        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " + request.getLocalName());
        System.out.println("request.getLocalAddr() = " + request.getLocalAddr());
        System.out.println("request.getLocalPort() = " + request.getLocalPort());

        System.out.println("==== Headers 기타정보 end ========");
    }

}
