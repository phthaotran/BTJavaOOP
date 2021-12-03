package W2;

import java.util.Scanner;

public class B03 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        Vehicle[] x= null;
        int a, n=0;
        boolean b= true;

        do{
        //tao menu lua chon cong viec
        System.out.println("Ban muon? ");
        System.out.println("1. Nhap thong tin cua xe \n" + "2. Xuat bang ke khai tien thue truoc ba cua xe\n" + "3. Thoat");
        a= sc.nextInt();

        switch(a) {
                case 1:
                    //nhap thong tin xe
                    System.out.print("Nhap so luong xe ban muon nhap thong tin: ");
                    n= sc.nextInt();
                    //nhap thong tin cua xe bang mang
                    x= new Vehicle[n];
                    for (int i=0; i<n; i++) {
                        x[i]= new Vehicle();
                        sc.nextLine();
                        System.out.print("Nhap ten chu xe: ");
                        x[i].setTenchuxe(sc.nextLine());
                        System.out.print("Nhap loai xe: ");
                        x[i].setLoaixe(sc.nextLine());
                        System.out.print("Nhap dung tich xe: ");
                        x[i].setDungtich(sc.nextInt());
                        System.out.print("Nhap gia xe: ");
                        x[i].setGiaxe(sc.nextDouble());
                    }
                    break;
                case 2:
                    //xuat bang ke khai tien thue truoc ba cua xe
                    System.out.printf("%25s %15s %20s %20s %20s \n", "Ten chu xe", "Loai xe", "Dung tich", "Tri gia", "Thue phai nop");
                    System.out.println("======================================================================================================================");
                    for (int i=0; i<n; i++){
                        x[i].ketXuat();
                    }
                    break;
                case 3:
                    //thoat
                    System.out.println("Ban da thoat khoi chuong trinh!");
                    b= false;
                    break;
            }
        } while(b);

    }
}

class Vehicle{
    private String tenchuxe;
    private String loaixe;
    private int dungtich;
    private double giaxe;

    public Vehicle(){
    }

    public Vehicle(String tenchuxe, String loaixe, int dungtich,double giaxe){
        this.tenchuxe= tenchuxe;
        this.loaixe= loaixe;
        this.dungtich= dungtich;
        this.giaxe= giaxe;
    }

    public void setTenchuxe(String tenchuxe){
        this.tenchuxe= tenchuxe;
    }

    public void setLoaixe(String loaixe){
        this.loaixe= loaixe;
    }

    public void setDungtich(int dungtich){
        this.dungtich= dungtich;
    }

    public void setGiaxe(double giaxe){
        this.giaxe= giaxe;
    }

    public String getTenchuxe(){
        return tenchuxe;
    }

    public String getLoaixe(){
        return loaixe;
    }

    public int getDungtich(){
        return dungtich;
    }

    public double getGiaxe(){
        return giaxe;
    }

    public double tinhThue(){
        double thue;
        if (dungtich < 100) thue= giaxe*0.01;
        else if ( dungtich <= 200) thue= giaxe*0.03;
        else thue= giaxe*0.05;
        return thue;
    }

    public void ketXuat(){
        System.out.printf("%25s %15s %20d %20f %20f \n", tenchuxe, loaixe, dungtich, giaxe, tinhThue());
    }



}