import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
abstract class VRPTW_properties//提供了顾客集合与距离矩阵等属性的抽象类
{
    public static int CUSTOMER_NUMBER;//顾客数
    public static double CAPACITY;//容量
    public static double[][] cost_mariax;
    public static Customer[] customers;//顾客集合
}
class Customer//顾客类，
{
    int c_id;//id
    int cx;
    int cy;//顾客位置
    int demand;//需求量
    int ready_time;//时间窗
    private int due_time;
    public void setCustomer(int x,int y,int id,int goods_need,int ready_time,int due_time)//初始化方法
    {
        this.cx = x;
        this.cy = y;
        this.c_id = id;
        this.demand = goods_need;
        this.ready_time = ready_time;
        this.due_time = due_time;
    }

}
class Route
{
    ArrayList<Customer> route = new ArrayList<>();//用列表存放车辆路径
    double route_weight = 0; //车辆路径的当前容量
    double route_length = 0; //长度
    double CAPACITY = 0;//容量约束
    public void update_all()
    {
        update_length();
        update_weight();
    }
    public void update_weight() {//更新路径的载重
        this.route_weight = 0;
        for(Customer c : this.route)
        {
            this.route_weight += c.demand;
        }
    }
    public void update_length()//更新当前路径的长度
    {
        this.route_length = 0;
        int cur_id =this.route.get(0).c_id;
        int next_id = this.route.get(1).c_id;//两个指针，一个当前，一个下一个
        int i = 2;
        while(true)
        {

            this.route_length += VRPTW_properties.cost_mariax[cur_id][next_id];
            if(next_id==0)break;//指向了0就退出循环
                i++;
            cur_id = next_id;
            next_id = this.route.get(i).c_id;
        }
    }
}
class Solution
{
    ArrayList<Route> solution_Vehicle = new ArrayList<>();//用列表存放车辆路径
    int route_number = 0;//车辆数量
    double solution_length = 0 ;//路径总长
    int solution_weight = 0;

    public void setSolution_length()//获取总路径长度
    {
        this.solution_length = 0;
        for(Route r:solution_Vehicle) this.solution_length += r.route_length;
    }
    public void setSolution_weight_weight()

    {
        this.solution_weight = 0;
        for(Route r:solution_Vehicle) this.solution_weight += r.route_weight;
    }

}
class modelFunction//提供了输入和初始化的函数
{
    public static void input(String inputdata)
    {
        File input_data = new File(inputdata);

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(input_data));//开始读入
            String line = " ";
            int i = 1;
            System.out.println("————————————————————输入中——————————————————");
            while(true)
            {
                line = br.readLine();
                if(line == "END")
                {
                    break;
                }
                if()
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
}
