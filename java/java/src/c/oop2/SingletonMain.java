package c.oop2;

public class SingletonMain {
    public static void main(String[] args) {
        //instance가 없으면 생성, 있으면 반환
        //외부에서 Singleton을 instance화 불가능
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();
        System.out.println(s1 == s2); //true(같은 인스턴스)
    }
}
