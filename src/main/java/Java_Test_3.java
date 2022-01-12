import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Scanner;

public class Java_Test_3 {
    public static void main(String[] args) throws IOException, SQLException {
        Location city1 = CityTool.getLocation("101010100");
        Sqloperation.addCity(city1);//北京
        Location city2 = CityTool.getLocation("101020100");
        Sqloperation.addCity(city2);//上海
        Location city3 = CityTool.getLocation("101230101");
        Sqloperation.addCity(city3);//福州
        CityTool.addThreeDaysWeather("101010100");//北京
        CityTool.addThreeDaysWeather("101020100");//上海
        CityTool.addThreeDaysWeather("101230101");//福州
        Scanner scanner = new Scanner(System.in);
        String in = null;
        do {
            Function.printHomepage();//输出功能菜单
            do {
                System.out.print("请按格式输入想要的指令（#号键退出)!!!:");
                in = scanner.nextLine();
            }while(!in.equals("1")&&!in.equals("2")&&!in.equals("#"));
            if (in.equals("#")) break;
            else if(in.equals("1")){
                Function.printFunction1();
                do {
                    System.out.print("请按格式输入想要的指令（*号键返回上一菜单，#号键退出)!!!:");
                    in = scanner.nextLine();
                }while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("#")&&!in.equals("*"));
                if (in.equals("#")) break;
                else if (in.equals("*")) continue;
                else{
                    String re = Function.function1(in);
                    if (re.equals("*")) continue;
                    else if (re.equals("#")) break;
                }
            }else if (in.equals("2")){
                String re = null;
                String re2 = null;
                MyDate dateTime = new MyDate();
                do {
                    String res = Function.printFunction2();
                    if (res.equals("#")) {
                        re = res;
                        break;
                    }
                    else if (res.equals("*")) {
                        re = res;
                        break;
                    }
                    else if (res.equals("1")){
                        re2 = Function.chooseDate("北京", dateTime);
                        if (re2.equals("#")){
                            re = re2;
                            break;
                        } else if (re2.equals("*"))continue;
                        else{
                            re = Function.function2("北京", dateTime.getDate());
                            break;
                        }
                    }else if (res.equals("2")){
                        re2 = Function.chooseDate("上海", dateTime);
                        if (re2.equals("#")){
                            re = re2;
                            break;
                        } else if (re2.equals("*"))continue;
                        else{
                            re = Function.function2("上海", dateTime.getDate());
                            break;
                        }
                    }else if (res.equals("3")){
                        re2 = Function.chooseDate("福州", dateTime);
                        if (re2.equals("#")){
                            re = re2;
                            break;
                        } else if (re2.equals("*"))continue;
                        else{
                            re = Function.function2("福州", dateTime.getDate());
                            break;
                        }
                    }
                }while(true);
                if (re.equals("#"))break;
                else if (re.equals("*"))continue;
            }
        }while (true);
    }
}
