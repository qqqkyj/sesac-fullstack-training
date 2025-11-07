package c.oop2;
// 공유 리소스
public class Singleton {
    // 1. private static instance
    private static Singleton instance = null;

    // 2. private 생성자 (외부에서 new 불가)
    private Singleton() {}

    // 3. public static getInstance 메서드
    public static Singleton getInstance() {
        if(instance == null){
            synchronized (Singleton.class) {
                if(instance == null){
                    // instance가 없으면 생성
                    instance = new Singleton();
                }
            }
        }
        // 있으면 반환
        return instance;
    }
}
