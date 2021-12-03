package W2;

import java.util.Scanner;

public class B01 {
    public static void main(String[] args){
        HCN p1= new HCN();
        Scanner sc= new Scanner(System.in);
        p1.setLength(sc.nextDouble());
        p1.setWidth(sc.nextDouble());
        System.out.println(p1);
        p1.setLength(5);
        System.out.println(p1);

    }
}

class HCN{
    private double l;
    private double w;

    public HCN(){
    }

    public HCN(double l, double w){
        this.l=l;
        this.w=w;
    }

    public void setLength(double l){
        this.l=l;
    }

    public void setWidth(double w){
        this.w=w;
    }

    public double getLength(){
        return l;
    }

    public double getWidth(){
        return w;
    }

    public double getArea(){
        return l*w;
    }

    public double getPerimeter(){
        return 2*(l+w);
    }

    public String toString(){
        return "Length: " + l + ", " + "Width: " + w +", " +
                "Area: " + getArea() + ", " + "Perimeter: " + getPerimeter();
    }
}
