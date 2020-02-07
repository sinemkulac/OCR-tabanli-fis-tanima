package yazlab;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author USER
 */

public class Islemler {
private Connection con=null;
private Statement statement=null;
private PreparedStatement preparedstatement=null;
  
public Islemler() {
   
    String url="jdbc:mysql://"+ Baglanti.host + ":" +  Baglanti.port + "/" +  Baglanti.db_ismi;
    try {
        Class.forName("com.mysql.jdbc.Driver");     }
    catch(ClassNotFoundException ex) {
        System.out.println("driver bulunamadı...");     }
    try {
         con = DriverManager.getConnection(url, Baglanti.kullanici_adi, Baglanti.parola);
	 //System.out.println("Bağlantı başarılı");   
    } 
    catch (SQLException ex) {
	//ex.printStackTrace();
	System.out.println("Bağlantı başarısız...");    }

}
public ArrayList <Goruntu_Sec> fisgetir(){
        ArrayList <Goruntu_Sec> cikti=new ArrayList <Goruntu_Sec>();
    try {
        statement=con.createStatement();
        String sorgu="Select * From fis";
        ResultSet rs=statement.executeQuery(sorgu);
        while(rs.next()){
         int id=rs.getInt("id");   
         String isletme_adi=rs.getString("isletme_adi");;
         String tarih=rs.getString("tarih");
         int  fis_no=rs.getInt("fis_no");
         float  urunler_kdv=rs.getFloat("urunler_kdv");
         float  toplam_fiyat=rs.getFloat("toplam_fiyat");
         cikti.add(new Goruntu_Sec(id,isletme_adi,tarih,fis_no,urunler_kdv,toplam_fiyat));
        
        }
        return cikti;
    } catch (SQLException ex) {
        Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
        return null;
    }
}
public void FisEkle(String isletme_adi,String tarih,int fis_no,float urunler_kdv,float toplam_fiyat){
    String sorgu="Insert Into fis(isletme_adi,tarih,fis_no,urunler_kdv,toplam_fiyat) VALUES (?,?,?,?,?)";
    try {
        preparedstatement=con.prepareStatement(sorgu);
        preparedstatement.setString(1, isletme_adi);
        preparedstatement.setString(2,tarih);
        preparedstatement.setInt(3,fis_no);
        preparedstatement.setFloat(4,urunler_kdv);
        preparedstatement.setFloat(5,toplam_fiyat);
        preparedstatement.executeUpdate();
        
         
    } catch (SQLException ex) {
        Logger.getLogger(Islemler.class.getName()).log(Level.SEVERE, null, ex);
    }
}
    
}
    