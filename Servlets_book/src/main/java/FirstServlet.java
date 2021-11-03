import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/*
Я понял так, что тут можно реализовать сервлет в виде RMI клиента и формировать запросы к RMI серверу, где будут содержаться
основная бизнес логика... тут может вступить в силу технология EJB (JavaBeans) -- прокси сервака (там где скелет), примет
запрос на исполнение метода от Сервлета, далее запрос уйдет на EJB-объект который перехватит запрос и произведет полную
проверку прав доступа...
bean(зерно) - компонент описывающий бизнес логику !

Т.е мы можем реализовать распределенную структуру, тем самым снизить нагрузку на компоненты за счёт RMI, а с EJB при этом обеспечить еще
и безопасность !
EJB - это RMI на стеройдах :)


Принцип взаимодействия клиент-сервера:
1) От клиента в сторону сервака Томкэт поступает запрос (GET, POST...)
2) Серва смотрит к какому URL происходит обращение, т.е. проверяет свою маппу в файле web.xml
    2.1) через xml файл Томкэт создает экземпляры сервлетов и выстраивает соответствие сервлета конкретной ссылке(МАППИНГ) !
3) Если Томкэт находит актуальный сервлет (URL) , то происходит вызов соответствующего переопределенного метода

Есть специальный JSP формат, в нем мы можем совмещать код Java с форматом html -> интеграция, выстраивание динамических данных.
 */
public class FirstServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter(); //сюда мы будем записывать то, что предназначено клиенту

        resp.setContentType("text/html"); //говорим серверу и клиенту какой тип ответа будет возвращен сервером (рузультирующее значение)

        String title = "Generate a phrase";

//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/MyJSP.jsp");
//        requestDispatcher.forward(req, resp);

        pw.println("<HTML>");
            pw.println("<HEAD>");
                pw.println("<TITLE>");
                    pw.println("RandomPhrase");
                pw.println("</TITLE>");
            pw.println("</HEAD>");
            pw.println("<BODY>");
                pw.println("<H1>" + "Generated phrase:" + "</H1>");
                    pw.println("<P>" + RandomPhrase.getRandomPhrase());
                pw.println("<H1>" + title + "</H1>");
                pw.println("<P><a href=\"servlet_2\">Create new phrase</a></P>");
            pw.println("<P><a href=\"MyJSP.jsp\">TestJSP</a></P>");
            pw.println("</BODY>");
        pw.println("</HTML>");

        pw.close();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
