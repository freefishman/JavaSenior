/**
 * @author q2Lin
 * @create 2020-09-11-20:10
 */
public class test {
    public static void main(String[] args) {
        User u = new User("关羽");
        u.show();
    }
}
class User{
    private String name = "张飞";
    User(String name){
        this.name = name;
    }
    public void show(){
        System.out.println(name);
    }
}
