package W2;

import java.util.Scanner;

public class B04 {
    public static void main(String[] args) {
        Acount a1= new Acount(97047262444442l, "Tran Kien An");
        System.out.println(a1);
        System.out.println();
        a1.napTien();
        a1.rutTien();
        a1.chuyenTien();
        System.out.println("So du tai khoan sau dao han: " + a1.daoHan());
    }
}

class Acount{
    private final double hslai= 0.035;
    private long stk;
    private String ten;
    private double tien;

    Scanner sc= new Scanner(System.in);

    public Acount(){
    }

    public Acount(long stk, String ten, double tien){
        this.stk= stk;
        this.ten= ten;
        this.tien= tien;
    }

    public Acount(long stk, String ten){
        this.stk= stk;
        this.ten= ten;
        tien= 50;
    }

    public void setStk(long stk){
        this.stk= stk;
    }

    public void setTen(String ten){
        this.ten= ten;
    }

    public void setTien(double tien){
        this.tien= tien;
    }

    public long getStk(){
        return stk;
    }

    public String getTen(){
        return ten;
    }

    public double getTien(){
        return tien;
    }

    public String toString(){
        return stk + " - " + ten + " - " + tien;
    }


    public void napTien(){
        double tiennap;
        do{
            System.out.print("Nhap so tien nap: ");
            tiennap= sc.nextDouble();
            if (tiennap<=0) System.out.println("So tien nap khong hop le. Moi ban nhap lai!");
            else break;
        } while (tiennap<=0);
        System.out.println("Ban da nap thanh cong so tien " + tiennap);
        tien = tien + tiennap;
        System.out.println("So du tai khoan: " + tien);
        System.out.println();
    }

    public void rutTien(){
        double tienrut;
        double phi= 3;
        do {
            System.out.print("Nhap so tien rut: ");
            tienrut= sc.nextDouble();
            if (tienrut<=0 || tienrut>=(tien-50- phi)) {
                System.out.println("So tien rut khong hop le. Moi ban nhap lai!");
                continue;
            }
            else break;

        }while (tienrut<=0 || tienrut>=(tien-50- phi));
        System.out.println("Ban da rut thanh cong so tien " + tienrut);
        tien= tien - tienrut- phi;
        System.out.println("So du tai khoan: " + tien);
        System.out.println();
    }

    public double daoHan(){
        return tien + tien*hslai;
    }

    public void chuyenTien(){
        double tienck;
        double phi=3;
        System.out.print("Nhap ngan hang ban muon chuyen tien den: ");
        String nhck= sc.nextLine(); sc.nextLine();
        System.out.print("Nhap so tai khoan ban muon chuyen tien den: ");
        long stkck= sc.nextLong();
        System.out.print("Nhap so tien ban muon chuyen: ");
        do{
            tienck= sc.nextDouble();
            if ( tienck<=0 || tienck>=(tien-50-phi)) System.out.println("So tien chuyen khong hop le. Moi ban nhap lai !");
            else break;
        }while (tienck<=0 || tienck>=(tien-50-phi));
        System.out.println("Ban da chuyen khoan thanh cong!");
        tien= tien - tienck - phi;
        System.out.println("So du tai khoan: " + tien);
        System.out.println();
    }

}