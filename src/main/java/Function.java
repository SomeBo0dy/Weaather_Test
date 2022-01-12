import java.text.SimpleDateFormat;
import java.util.*;

public class Function {
    //输出功能菜单
    public static void printHomepage(){
        System.out.println();
        System.out.println("=======================================");
        System.out.println("|欢迎来到城市天气查询系统!!");
        System.out.println("|1.查询城市ID和经纬度位置");
        System.out.println("|2.查询城市天气");
        System.out.println("=======================================");
    }
    //输出功能1菜单
    public static void printFunction1(){
        System.out.println();
        System.out.println("=======================================");
        System.out.println("|城市：");
        System.out.println("|1.北京");
        System.out.println("|2.上海");
        System.out.println("|3.福州");
        System.out.println("|其余城市查询功能正在开发中.......");
        System.out.println("=======================================");
    }
    //输出功能2菜单
    public static String printFunction2(){
        printFunction1();
        Scanner scanner = new Scanner(System.in);
        String in = null;
        do {
            System.out.print("请按格式输入想要的指令（*号键返回上一菜单，#号键退出)!!!:");
            in = scanner.nextLine();
        }while(!in.equals("1")&&!in.equals("2")&&!in.equals("3")&&!in.equals("#")&&!in.equals("*"));
        return in;
    }
    //输出城市数据库中存有的日期的天气选择菜单
    public static String chooseDate(String name, MyDate date){
        List<Integer> lis = new ArrayList<>();
        List<Date> list = Sqloperation.getCityDate(name);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println("=======================================");
        System.out.println("日期：");
        for (int i = 1; i <= list.size(); i++){
            System.out.print(i+".");
            lis.add(i);
            System.out.println(simpleDateFormat.format(list.get(i-1)));
        }
        System.out.println("其余日期暂未记录......");
        System.out.println("=======================================");
        Scanner scanner = new Scanner(System.in);
        String in = null;
        int m = 1;
        do {
            System.out.print("请按格式输入想要的指令（*号键返回上一菜单，#号键退出)!!!:");
            in = scanner.nextLine();
            if (in.equals("#")||in.equals("*"))
                break;
            m = Integer.parseInt(in);
        }while(!lis.contains(m));
        if (!in.equals("#")&&!in.equals("*")){
            date.setDate(list.get(m - 1));
        }
        return in;
    }
    //功能1：查询城市Location
    public static String function1(String in){
        Location city = null;
        if (in.equals("1")){
            city = Sqloperation.getLocation("北京");
        }else if (in.equals("2")){
            city = Sqloperation.getLocation("上海");
        }else if (in.equals("3")){
            city = Sqloperation.getLocation("福州");
        }
        System.out.println("=======================================");
        System.out.println(city);
        System.out.println("=======================================");
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("请按格式输入想要的指令（*号键继续查询，#号键退出)!!!:");
            in = scanner.nextLine();
        }while(!in.equals("#")&&!in.equals("*"));
        return in;
    }
    //功能2：查询城市指定日期的天气
    public static String function2(String name,Date date){
        DailyWeather weather = null;
        weather = Sqloperation.getWeather(name,new java.sql.Date(date.getTime()));
        System.out.println("=======================================");
        System.out.println(weather);
        System.out.println("=======================================");
        Scanner scanner = new Scanner(System.in);
        String in = null;
        do {
            System.out.print("请按格式输入想要的指令（*号键继续查询，#号键退出)!!!:");
            in = scanner.nextLine();
        }while(!in.equals("#")&&!in.equals("*"));
        return in;
    }
}
