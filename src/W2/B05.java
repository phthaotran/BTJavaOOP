package W2;

public class B05 {
    public static void main(String[] args){
        PhanSo ps1= new PhanSo(3, 7);
        PhanSo ps2= new PhanSo(4, 12);
        ps1.nghichDao();
        System.out.println("Phan so thu nhat sau nghich dao la: " + ps1.getTu() +"/" + ps1.getMau());
        ps2.toiGian();
        System.out.println("Phan so thu hai sau toi gian la: " + ps2.getTu() + "/" + ps2.getMau());
        ps1.congPhanSo(ps2);
        ps1.truPhanSo(ps2);
        ps1.nhanPhanSo(ps2);
        ps1.chiaPhanSo(ps2);
        System.out.println("Phan so thu nhat la: " + ps1.getTu() + "/" + ps1.getMau());
        System.out.println("Phan so thu hai la: "+ ps2.getTu() + "/" + ps2.getMau());
        ps1.soSanhPhanSo(ps2);
    }

}

class PhanSo{
    private int tu;
    private int mau;

    public PhanSo(){
    }

    public PhanSo(int tu, int mau){
        this.tu= tu;
        this.mau= mau;
    }

    public void setTu(int tu){
        this.tu= tu;
    }

    public void setMau(int mau){
        this.mau= mau;
    }

    public int getTu(){
        return tu;
    }

    public int getMau(){
        return mau;
    }


    //tim UCLN cua tu va mau, su dung phep tru cho den khi tu= mau
    public int UCLN(int x, int y){
        while (x!=y){
            if (x>y){
                x-=y;
            }
            else {
                y-=x;
            }
        }
        return x;
    }

    //phep toi gian phan so
    public void toiGian(){
        int i= UCLN(tu, mau);
        this.setTu(this.getTu()/i);
        this.setMau(this.getMau()/i);
    }

    //phep nghich dao phan so
    public void nghichDao(){
        int mscu= mau;
        this.setMau(this.getTu());
        this.setTu(mscu);
    }

    //phep cong 2 phan so, voi tham so truyen vao la phan so thu hai
    public void congPhanSo(PhanSo ps){
        int ts= this.getTu()*ps.getMau() + ps.getTu()*this.getMau();
        int ms= this.getMau()*ps.getMau();
        PhanSo ps1= new PhanSo(ts,ms);
        ps1.toiGian();
        System.out.println("Tong 2 phan so la: " + ps1.getTu() +"/"+ ps1.getMau());
    }

    //phep tru 2 phan so, voi tham so truyen vao la phan so thu hai
    public void truPhanSo(PhanSo ps){
        int ts= this.getTu()* ps.getMau() - ps.getTu()*this.getMau();
        int ms= ps.getMau()*this.getMau();
        PhanSo ps2= new PhanSo(ts, ms);
        ps2.toiGian();
        System.out.println("Hieu 2 phan so la: " + ps2.getTu()+ "/" + ps2.getMau());
    }

    //phep nhan 2 phan so, voi tham so truyen vao la phan so thu hai
    public void nhanPhanSo(PhanSo ps){
        int ts= this.getTu()*ps.getTu();
        int ms= this.getMau()*ps.getMau();
        PhanSo ps3= new PhanSo(ts,ms);
        ps3.toiGian();
        System.out.println("Tich hai phan so la: " + ps3.getTu() + "/" + ps3.getMau());
    }

    //phep chia 2 phan so, voi tham so truyen vao la phan so thu hai
    public void chiaPhanSo(PhanSo ps){
        ps.nghichDao();
        int ts= this.getTu()*ps.getTu();
        int ms= this.getMau()*ps.getMau();
        PhanSo ps4= new PhanSo(ts,ms);
        ps4.toiGian();
        System.out.println("Thuong hai phan so la: " + ps4.getTu() + "/" + ps4.getMau());
    }

    //tim BCNN cua hai mau
    public int BCNN(int a, int b){
        int i= UCLN(a,b);
        return  (a*b)/i;
    }

    //so sanh 2 phan so, voi tham so truyen vao la phan so thu hai
    public void soSanhPhanSo(PhanSo ps){
        if (this.getMau()== ps.getMau() && this.getTu()==ps.getTu()) {
            System.out.println("Hai phan so da cho bang nhau");
        }
        else {
            int bcnn = BCNN(this.getMau(), ps.getMau());
            //quy dong mau hai phan so, chi xet tu so cua hai phan so
            int ts1 = this.getTu() * bcnn / this.getMau();
            int ts2 = ps.getTu() * bcnn / ps.getMau();
            if (ts1 > ts2) System.out.println("Phan so thu nhat lon hon phan so thu hai");
            else System.out.println("Phan so thu hai lon hon phan so thu nhat");
        }
    }
}
