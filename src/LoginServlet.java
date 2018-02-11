import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

@WebServlet(name = "/login")
public class LoginServlet extends HttpServlet {
    String path =new File("").getAbsolutePath();
    String next="";
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Login works");
        String login =request.getParameter("login");
        String password =request.getParameter("password");
        String stream="";
        String[] stringstream;
        String[] user={""};
        boolean canplay=false;
        try(FileReader reader=new FileReader(path+"/Users.txt"))
        {
            int c;
            while((c=reader.read())!=-1)
            {
                stream=stream+(char)c;
            }
            reader.close();
            stringstream= stream.toString().split("!");
            for (int i=0;i<stringstream.length;i++)
            {
                user =stringstream[i].split("%");
                if(user[0].equals(login)&&user[1].equals(password))
                {
                    System.out.println("Пользователь существует,выполнить вход");
                    canplay=true;
                }

            }
            request.setAttribute("username",login);
        }
        catch (IOException e){
            System.out.println("Ошибка в чтении "+e.getMessage());
        }
        if (canplay==true)
        {
            next="/game1.jsp";
            request.getSession().setAttribute("username",login);
            request.getSession().setAttribute("cows",0);
            request.getSession().setAttribute("bulls",0);
            request.getSession().setAttribute("trystring","");
        }
        else {next="/index.jsp";}//index.jsp
        request.getRequestDispatcher(next).forward(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
