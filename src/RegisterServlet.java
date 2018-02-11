import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet(name = "/reg")
public class RegisterServlet extends HttpServlet {
    String path =new File("").getAbsolutePath();
    protected void doPost (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Reg works");
        String next="";
        String login=request.getParameter("reglogin");//if string contains *!
        String password=request.getParameter("regpswrd");
        if(login.contains("!")||login.contains("&")) {
            next="/registrate1.jsp";
        }else{
            try (FileWriter writer = new FileWriter(path + "/Users.txt", true)) {

                String stream = "";
                String[] stringstream;
                String[] username = {""};
                boolean isexist = false;

                try (FileReader reader = new FileReader(path + "/Users.txt")) {
                    int c;
                    while ((c = reader.read()) != -1) {
                        stream = stream + (char) c;
                    }
                    reader.close();
                    stringstream = stream.split("!");// check
                    for (int i = 0; i < stringstream.length; i++) {
                        username = stringstream[i].split("%");
                        if (username[0].equals(login)) {
                            System.out.println("Пользователь уже существует");
                            isexist = true;
                        }

                    }
                    request.getSession().setAttribute("username", login);
                    request.getSession().setAttribute("cows", 0);
                    request.getSession().setAttribute("bulls", 0);
                    request.getSession().setAttribute("trystring", "");
                } catch (IOException e) {
                    System.out.println("Ошибка в чтении " + e.getMessage());
                }

                if (isexist) {
                    next = "/registrate1.jsp";

                } else {
                    String record = login + "%" + password + "!";
                    writer.write(record);
                    next = "/game1.jsp";
                    System.out.println("Executed" + record);
                }
                writer.close();


            } catch (IOException ex) {
                System.out.println(ex.getMessage());
                System.out.println("Not executed");
            }
        }
        request.getRequestDispatcher(next).forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
