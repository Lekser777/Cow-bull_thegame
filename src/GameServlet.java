import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@WebServlet(name = "/game")
public class GameServlet extends HttpServlet {

    Game newGame=new Game();
    String tries="";
    int trynum=1;
    String path =new File("").getAbsolutePath();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Число введенное пользователем
        String answer=request.getParameter("number");
        //Результаты прошлых игр
        String pastresults;
        //Пользователь существует в файле
        boolean isexist=false;
        //Строка для отображения результатов прошлых игр
        String resultsshown="";
        //Результат данной игры
        int score=0;

        char[]answchar= answer.toCharArray();
        if(answchar.length>4||answchar.length<4){

            request.getSession().setAttribute("cows",0);
            request.getSession().setAttribute("bulls",0);
            request.getSession().setAttribute("trystring","");
            request.getRequestDispatcher("/game1.jsp").forward(request,response);

        }else {
            int[]answint={Integer.parseInt(String.valueOf(answchar[0])),Integer.parseInt(String.valueOf(answchar[1])),Integer.parseInt(String.valueOf(answchar[2])),Integer.parseInt(String.valueOf(answchar[3]))};
            //proverka
            int[] qst = newGame.getQuestion();
            System.out.println("Строка введенная пользователем " + answint.length + answint[0] + answint[1] + answint[2] + answint[3] + "   " + qst[0] + qst[1] + qst[2] + qst[3]);

            int cown = newGame.calcCows(answint);
            int bulln = newGame.calcBulls(answint);

            tries = tries + " Ваш вариант : " + answint[0] + answint[1] + answint[2] + answint[3] + " K" + cown + "Б" + bulln + " Попытка номер : " + trynum;
            request.getSession().setAttribute("trystring", tries);
            request.getSession().setAttribute("cows", cown);
            request.getSession().setAttribute("bulls", bulln);
            request.getSession().setAttribute("trynumber", trynum);


            if (bulln == 4) {
                //Вся информациия из Results.txt
                String file = "";
                //Информация связанная с данным пользователем
                String currentuserinfo = "";
                //Строка содержащая информацию связанную с данным пользователем, включая данную попытку
                String change = "";

                String login = request.getSession().getAttribute("username").toString();
                try (FileReader reader = new FileReader(path + "/Results.txt")) {
                    int c;
                    String filestream = "";
                    String[] stringfilestream;
                    String[] userresults;
                    while ((c = reader.read()) != -1) {
                        filestream = filestream + (char) c;
                    }
                    file = filestream;
                    reader.close();
                    stringfilestream = filestream.split("_");
                    for (int i = 0; i < stringfilestream.length; i++) {
                        userresults = stringfilestream[i].split("!");
                        //Проверка есть ли данный пользователь в файле
                        if (userresults[0].equals(login)) {
                            currentuserinfo = stringfilestream[i];
                            isexist = true;
                            pastresults = userresults[1];
                            String[] pastresultsmas = pastresults.split("and");
                            int sum = 0;
                            int k1;
                            for (int k = 0; k < pastresultsmas.length; k++) {
                                k1 = k + 1;
                                resultsshown = resultsshown + "Вы разгадали число за " + pastresultsmas[k] + " в свой " + k1 + " раз ";
                                sum = sum + Integer.parseInt(pastresultsmas[k]);
                            }
                            System.out.println("До попытки " + sum);
                            sum = sum + trynum;
                            System.out.println("После попытки " + sum);
                            //Подсчет среднего результата пользователя
                            score = sum / (pastresultsmas.length + 1);
                            System.out.println("Score " + score);

                        }
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка " + e.getMessage());
                }
                //
                if (isexist == false) {
                    score = trynum;
                    resultsshown = "Вы выиграли в первый раз";
                    file = file + login + "!" + trynum + "_";

                } else {
                    change = currentuserinfo + "and" + trynum;
                    file = file.replace(currentuserinfo, change);
                    System.out.println(change);
                    System.out.println(currentuserinfo);
                }
                try (FileWriter writer = new FileWriter(path + "/Results.txt", false)) {
                    System.out.println("Что записать " + file);
                    writer.write(file);
                    writer.close();

                } catch (IOException exc) {
                    System.out.println("Ошибка " + exc.getMessage());
                }

                request.getSession().setAttribute("score", score);
                request.getSession().setAttribute("resultsshown", resultsshown);
                request.getSession().setAttribute("cows",0);
                request.getSession().setAttribute("bulls",0);
                request.getSession().setAttribute("trystring","");

                request.getRequestDispatcher("/results1.jsp").forward(request, response);
                //Создание новой игры
                newGame = new Game();
                tries = "";
                trynum = 1;
                score = 0;

            } else {
                request.getRequestDispatcher("/game1.jsp").forward(request, response);
                trynum++;
            }
        }
  }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



       // int []answer =Integer.parseInt(request.getParameter("number"));


    }
}
