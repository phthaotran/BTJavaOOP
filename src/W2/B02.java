package W2;

import java.util.Scanner;

public class B02 {
    public static void main(String[] args){

        //nhap thong tin sinh vien 1 va 2 theo constructor du thong so
        SV s1= new SV(20193121, "Tran Thi Phuong Thao", 9.75f, 9.5f);
        SV s2= new SV(20192062, "Nguyen Thi Phuong Lien", 9.5f, 9.0f);

        //nhap thong tin sinh vien 3 tu ban phim
        Scanner sc= new Scanner(System.in);
        SV s3= new SV();
        s3.setMssv(sc.nextInt());
        sc.nextLine();
        s3.setName(sc.nextLine());
        s3.setLt(sc.nextFloat());
        s3.setTh(sc.nextFloat());

        //in theo dinh dang
        System.out.printf("%7s %15s %20s %10s %10s \n", "MSSV", "Ho ten", "Diem LT", "Diem TH","Diem TB" );
        s1.inSv();
        s2.inSv();
        s3.inSv();
    }
}

class SV{
    private int mssv;
    private String name;
    private float lt, th;

    public SV(){
    }

    public SV(int mssv, String name, float lt, float th){
        this.mssv= mssv;
        this.name=name;
        this.lt= lt;
        this.th= th;
    }

    public void setMssv(int mssv){
        this.mssv= mssv;
    }

    public void setName(String name){
        this.name= name;
    }

    public void setLt(float lt){
        this.lt= lt;
    }

    public void setTh(float th){
        this.th= th;
    }

    public int getMssv(){
        return mssv;
    }

    public String getName(){
        return name;
    }

    public float getLt(){
        return lt;
    }

    public float getTh(){
        return th;
    }

    public float diemTB(){
        return (lt + th)/2;
    }

    public String toString(){
        return "MSSV: " + mssv + ", " + "Hoten: "+ name + ", " +
                "DiemLT: " + lt + ", "+ "DiemTH: "  + th +", " + "DiemTB: " + diemTB();
    }

    public void inSv(){
        System.out.printf("%9d %-25s %8.2f %10.2f %10.2f \n",mssv,name, lt, th, diemTB());
    }

}
