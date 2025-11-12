package e.generic;

class Box{
    private Object item;

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }
}

class StringBox{
    private String item;

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}

public class WithoutGeneric {
    public static void main(String[] args) {
        Box box = new Box();
        box.setItem("hello");
        System.out.println(box.getItem());
        // Object의 경우 항상 형변환이 필요
        String str = box.getItem().toString();

        box.setItem(123);
        System.out.println(box.getItem());
        int num = (int) box.getItem();

        StringBox strBox = new StringBox();
        strBox.setItem("hello");
        System.out.println(strBox.getItem());
    }
}
