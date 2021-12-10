package W2;

import java.util.Scanner;

public class B08 {
    static Scanner sc= new Scanner(System.in);

//    phuong thuc them 1 CD
    public static void nhapCD(CD cd){
            System.out.print("Nhap ma CD: ");
            cd.setMaCD(sc.nextInt()); sc.nextLine();
            System.out.print("\nNhap tua CD: ");
            cd.setTuaCD(sc.nextLine());
            System.out.print("\nNhap ca sy: ");
            cd.setCaSy(sc.nextLine());
            System.out.print("\nNhap so bai hat: ");
            cd.setSoBH(sc.nextInt());
            System.out.print("\nNhap gia thanh: ");
            cd.setGia(sc.nextDouble());
    }

    public static void main(String[] args) {
        CD[] cd= null;
        int a, n=0;
        boolean b= true;

//        tao menu lua chon chuc nang
        do{
            System.out.println("Ban muon?");
            System.out.println("1.Nhap thong tin CD" +
                    "\n2.Tinh so luong CD trong danh sach"+
                    "\n3.Tinh tong gia thanh cua cac CD"+
                    "\n4.Sap xep danh sach giam dan theo gia thanh"+
                    "\n5.Sap xep danh sach tang dan theo gia thanh"+
                    "\n6.Xuat toan bo danh sach"+
                    "\n7.Thoat");
            a= sc.nextInt();
            switch (a){
                case 1://Nhap thong tin CD
                    System.out.print("Nhap so luong CD: ");
                    n= sc.nextInt();
                    cd= new CD[n];
                    for (int i=0; i<n; i++){
                        System.out.println("Nhap CD thu " + (i+1));
                        cd[i]= new CD();
                        nhapCD(cd[i]);
                    }
                    break;
                case 2: //Tinh so luong CD trong danh sach
                    System.out.println("Danh sach co " + n +" CD");
                    break;
                case 3: //Tinh tong gia thanh cac CD
                    double sum= 0;
                    for (int i=0; i<n; i++){
                        sum+= cd[i].getGia();
                    }
                    System.out.println("Tong gia thanh cac CD la " + sum);
                    break;
                case 4: //Sap xep danh sach giam dan theo gia thanh
                    for (int i=0; i<n-1; i++)
                        for (int j= i+1; j<n; j++){
                            if (cd[i].getGia()<cd[j].getGia()){
                                CD temp= cd[i];
                                cd[i]= cd[j];
                                cd[j]= temp;
                            }
                        }
                    System.out.println("Da sap xep. Nhap so 6 de kiem tra");
                        break;
                case 5: //Sap xep danh sach tang dan theo gia thanh
                    for (int i=0; i<n-1; i++)
                        for (int j= i+1; j<n; j++){
                            if (cd[i].getGia()>cd[j].getGia()){
                                CD temp= cd[i];
                                cd[i]= cd[j];
                                cd[j]= temp;
                            }
                        }
                    System.out.println("Da sap xep. Nhap so 6 de kiem tra");
                    break;
                case 6: //Xuat danh sach ra man hinh
                    System.out.printf("%10s %20s %20s %15s %15s\n", "Ma CD","Tua CD","Ca sy","So bai hat","Gia thanh");
                    for (int i=0; i<n; i++){
                        cd[i].hiemThiCD();
                    }
                    break;
                case 7: //Thoat
                    System.out.println("Ban da thoat khoi chuong trinh!");
                    b= false;
            }
        } while (b);
    }
}

class CD{
    private int maCD;
    private String tuaCD;
    private String caSy;
    private int soBH;
    private double gia;

//    cac constructor
    public CD(){}

    public CD(int maCD, String tuaCD, String caSy, int soBH, double gia){
        this.maCD= maCD;
        this.tuaCD= tuaCD;
        this.caSy= caSy;
        this.soBH= soBH;
        this.gia= gia;
    }

//    cac setter, getter
    public void setMaCD(int maCD){
        this.maCD= maCD;
    }

    public int getMaCD(){
        return maCD;
    }

    public void setTuaCD(String tuaCD){
        this.tuaCD= tuaCD;
    }

    public String getTuaCD(){
        return  tuaCD;
    }

    public void setCaSy(String caSy){
        this.caSy= caSy;
    }

    public String getCaSy(){
        return caSy;
    }

    public void setSoBH(int soBH){
        this.soBH= soBH;
    }

    public int getSoBH(){
        return soBH;
    }

    public void setGia(double gia){
        this.gia= gia;
    }

    public double getGia(){
        return gia;
    }

//    ghi de phuong thuc toString
    @Override
    public String toString(){
        return "Ma CD: " + maCD+
                "\nTua CD: " + tuaCD+
                "\nCa sy: "+ caSy+
                "\nSo bai hat: " + soBH +
                "\nGia thanh: " + gia;
    }

//    phuong thuc them hien thi CD theo dinh dang
    public void hiemThiCD(){
        System.out.printf("%10d %20s %20s %15d %15f\n ", maCD, tuaCD, caSy,soBH,gia);
    }
}