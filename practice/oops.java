package practice;

class Inneroops {


    String name;
    int[] value;
    
    void print(int length){
        for(int i=0;i<length;i++)
            System.out.println(value[i]);
    }
}

public class oops {

    public static void main(String[] args) {
        Inneroops i = new Inneroops();
        i.name = "darshan";
        int[] num = {12,15,45};
        i.value =num;

        i.print(num.length);

    }    
    
}
