package W2;

import java.util.Locale;
import java.text.NumberFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;


public class B06 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
//        khai bao mot doi tuong cua lop Hang thuc pham
        HangThucPham htp= new HangThucPham();
        boolean k= true;
        boolean t= true;
        boolean p= true;

//        nhap thong tin hang thuc pham
        do {
            System.out.println("Nhap ma hang: ");
            htp.setMa(sc.nextInt());
            sc.nextLine();
        } while (htp.kiemTraMa(k));
        do{
            System.out.println("Nhap ten hang: ");
            htp.setTen(sc.nextLine());
        } while (htp.kiemTraTen(t));
        System.out.println("Nhap don gia: ");
        htp.setGia(sc.nextDouble());
        do {
            System.out.println("Nhap ngay san xuat: ");
            htp.setNSX(sc.nextInt(), sc.nextInt(), sc.nextInt());
            System.out.println("Nhap ngay het han: ");
            htp.setHSD(sc.nextInt(),sc.nextInt(), sc.nextInt());
        } while (htp.kiemTraNgay(p));
//        hien thi thong tin hang thuc pham ra man hinh va kiem tra xem con han hay khong
        System.out.println(htp);
        htp.kiemTraConHan();
    }
}

class HangThucPham{
    private int ma;
    private String ten;
    private double gia;
    private Date nSX,hSD;

//    constructor khong tham so
    public HangThucPham(){}

//    constructor co day du tham so
    public HangThucPham(int ma, String ten, double gia, Date nSX, Date hSD){
        this.ma= ma;
        this.ten= ten;
        this.gia= gia;
        this.nSX= nSX;
        this.hSD= hSD;
    }
//    constructor 1 tham so
    public HangThucPham(int ma){
        this.ma= ma;
    }

//    cac phuong thuc setter, getter
    public void setMa(int ma){
        this.ma= ma;
    }

    public int getMa(){
        return ma;
    }

    public void setTen(String ten){
        this.ten= ten;
    }

    public String getTen(){
        return ten;
    }

    public void setGia(double gia){
        this.gia= gia;
    }

    public double getGia(){
        return gia;
    }

    public void setnSX(Date nSX){
        this.nSX= nSX;
    }

    public Date getnSX(){
        return nSX;
    }

    public void sethSD(Date hSD){
        this.hSD= hSD;
    }

    public Date gethSD(){
        return hSD;
    }

//    phuong thuc toString tra ve thong tin cua hang thuc pham
    public String toString(){
//        dinh dang tien te
        Locale localeVN= new Locale("vi","VN");
        NumberFormat vn= NumberFormat.getCurrencyInstance(localeVN);
        String str1= vn.format(gia);
//        dinh dang ngay thang nam
        Calendar cal= Calendar.getInstance();
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        String str2= sdf.format(nSX);
        String str3= sdf.format(hSD);
//        tra ve thong tin hang thuc pham
        return "Thong tin hang thuc pham: \n" +
                "Ma hang: " + ma +
                "\nTen hang: " + ten +
                "\nDon gia: " + str1+
                "\nNgay san xuat: " + str2+
                "\nNgay het han: " + str3;

    }

//    phuong thuc nhap ngay san xuat
    public void setNSX(int day, int month, int year){
        Calendar cal= Calendar.getInstance();
        cal.set(year,month-1,day);
        this.nSX= cal.getTime();
    }

//    phuong thuc nhap ngay het han
    public void setHSD(int day, int month, int year){
        Calendar cal= Calendar.getInstance();
        cal.set(year,month-1,day);
        this.hSD= cal.getTime();
    }

//    phuong thuc kiem tra ma hang co trong hay khong
    public boolean kiemTraMa(boolean k){
        String m= ma +"";
        if (m==""){
            System.out.println("Ma hang khong duoc de trong!");
        }
        else {
            k=false;
        }
        return k;
    }

//    phuong thuc kiem tra ten hang co rong hay khong
    public boolean kiemTraTen(boolean t){
        if(ten==""){
            System.out.println("Ten hang khong duoc de trong!");
        }
        else {
            t= false;
        }
        return t;
    }

//    phuong thuc kiem tra ngay san xuat co truoc ngay het han hay khong
    public boolean kiemTraNgay(boolean p){
        int result= this.getnSX().compareTo(this.gethSD());
        if (result<0){
            p=false;
        }
        else {
            System.out.println("Ngay het han khong duoc nho hon ngay san xuat!");
        }
        return p;
    }

//    phuong thuc kiem tra o thoi diem hien tai hang thuc pham con han hay khong
    public void kiemTraConHan(){
        Calendar cal= Calendar.getInstance();
        Date hn= cal.getTime();
        SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
        String str1= sdf.format(hn);
        if (hn.compareTo(hSD)<0){
            System.out.println("Hom nay (" + str1 +") san pham con han");
        }
        else {
            System.out.println("Hom nay (" + str1 + ") san pham da het han");
        }
    }
}
