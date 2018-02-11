import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "/score")
public class ScoreServlet extends HttpServlet {
    String path =new File("").getAbsolutePath();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String stream="";
        String []streamsplit1;
        String[]streamsplit2;
        String[]streamsplit3;
        String show="";
        try(FileReader reader=new FileReader(path+"/Results.txt")){
            int c;
            while((c=reader.read())!=-1)
            {
                stream=stream+(char)c;
            }
            reader.close();

        }catch (IOException ex){System.out.println(ex.getMessage());}
        streamsplit1=stream.split("_");
        String[] users=new String[streamsplit1.length];
        int[]scores=new int[streamsplit1.length];
        for (int i=0;i<streamsplit1.length;i++)
        {
            streamsplit2=streamsplit1[i].split("!");
            users[i]=streamsplit2[0];
            streamsplit3=streamsplit2[1].split("and");
            int sum=0;
            for(int k=0;k<streamsplit3.length;k++)
            {
                sum=sum+Integer.parseInt(streamsplit3[k]);
            }
            scores[i]=sum/streamsplit3.length;
            System.out.println("Пользователь = "+users[i]+" Score = "+scores[i]);
        }
        for (int j=scores.length-1;j>=0;j--) {
            for (int i = 0; i < j; i++) {
                if (scores[i] > scores[i + 1]) {
                    int temp = scores[i];
                    String tempstr = users[i];
                    scores[i] = scores[i + 1];
                    scores[i + 1] = temp;
                    users[i] = users[i + 1];
                    users[i + 1] = tempstr;
                }
            }
        }
        System.out.println("Soreted ");
        for(int i=0;i<users.length;i++){
            System.out.println("User "+users[i]);
            System.out.println("Score " + scores[i]);
            int k=i+1;
            show=show+" Место : "+k+" Игрок : "+users[i]+" Результат : "+scores[i]+"<br>";
        }
        request.setAttribute("scoreboard",show);
        request.getRequestDispatcher("/score1.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
