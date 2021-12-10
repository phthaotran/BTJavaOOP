package W2;

import java.util.Scanner;

import java.util.Scanner;

public class B07 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        SinhVien[] sv= null;
        int a, n=0;
        boolean b= true;
        do{
//            tao menu lua chon cong viec
            System.out.println("Ban muon?");
            System.out.println("1.Nhap thong tin sinh vien\n" +
                    "2.Xuat danh sach sinh vien\n" +
                    "3.Thoat");
            a= sc.nextInt();

            switch (a){
                case 1: //Nhap thong tin sinh vien
                    System.out.print("Nhap so luong sinh vien: " );
                    n= sc.nextInt();
                    sv= new SinhVien[n];
                    //nhap thong tin sinh vien dung mang
                    for (int i=0; i<n; i++ ){
                        sv[i]= new SinhVien();
                        System.out.print("Nhap ma so sinh vien: ");
                        sv[i].setMs(sc.nextInt());
                        sc.nextLine();
                        System.out.print("Nhap ho ten sinh vien: ");
                        sv[i].setHoTen(sc.nextLine());
                        System.out.print("Nhap dia chi sinh vien: ");
                        sv[i].setDc(sc.nextLine());
                        do {
                            System.out.print("Nhap so dien thoai sinh vien: ");
                            sv[i].setSdt(sc.nextLine());
                        } while (sv[i].getSdt().length()!=7);
                    }
                    break;

                case 2: //Xuat danh sach sinh vien ra man hinh theo thu tu tang dan cua mssv
                    for (int i=0; i<n-1; i++)
                        for (int j= i+1; j<n; j++){
                            if (sv[i].getMs() > sv[j].getMs()) {
                                SinhVien temp = sv[i];
                                sv[i]= sv[j];
                                sv[j]= temp;
                            }
                        }
                    System.out.printf("%10s %25s %20s %15s\n", "MSSV", "Ho & ten","Dia chi","SDT");
                    for (int i=0; i<n; i++){
                        sv[i].hienThiSV();
                    }
                    break;

                case 3: //Thoat khoi chuong trinh
                    System.out.println("Ban da thoat khoi chuong trinh!");
                    b= false;
            }
        } while (b);
    }
}

class SinhVien{
    private int ms;
    private String hoTen;
    private String dc;
    private String sdt;

//    constructor khong tham so
    public SinhVien(){}

//    constuctor day du tham so
    public SinhVien(int ms, String hoTen, String dc, String sdt){
        this.ms= ms;
        this.hoTen= hoTen;
        this.dc= dc;
        this.sdt=sdt;
    }

//    phuong thuc setter, getter cho tung thuoc tinh
    public void setMs(int ms){
        this.ms= ms;
    }

    public int getMs(){
        return ms;
    }

    public void setHoTen(String hoTen){
        this.hoTen= hoTen;
    }

    public String getHoTen(){
        return hoTen;
    }

    public void setDc(String dc){
        this.dc= dc;
    }

    public String getDc(){
        return dc;
    }

    public void setSdt(String  sdt){
        this.sdt= sdt;
    }

    public String getSdt(){
        return sdt;
    }

//    ghi de phuong thuc toString cua lop Object
    @Override
    public String toString(){
        return "MSSV: " + ms +
                "\nHo & ten: " + hoTen+
                "\nDia chi: " + dc+
                "\nSDT: " + sdt;
    }


//    phuong thuc hien thi sinh vien
    public void hienThiSV(){
        System.out.printf("%10d %25s %20s %15s\n", ms, hoTen,dc,sdt);
    }

}