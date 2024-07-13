class Question{
    int i;
}
class Test extends Question{
    int j;
    void display()
    {
        super.i=j+1;
        System.out.println(j+" "+i);
    }
}
public class Main{
    public static void main(String[] args) {
        Test obj=new Test();
        obj.i=1;
        obj.j=2;
        obj.display();
}
}