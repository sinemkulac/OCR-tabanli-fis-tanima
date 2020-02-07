package yazlab;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.core.MatOfPoint;
import java.util.List;


public class Goruntu_Sec extends javax.swing.JFrame {
    private int id;
    private String isletme_adi;
    private String tarih;
    private int fis_no;
    private float urunler_kdv;
    private float toplam_fiyat;
    private static String dosya_yolu; 
    DefaultTableModel model;
    Islemler islemler;
    BufferedReader reader = null;
    public String getIsletme_adi() {
        return isletme_adi;
    }

    public int getFis_no() {
        return fis_no;
    }

    public String getTarih() {
        return  tarih;
    }

    public void setTarih(String tarih) {
        this.tarih = tarih;
    }

    public float getUrunler_kdv() {
        return urunler_kdv;
    }

    public float getToplam_fiyat() {
        return toplam_fiyat;
    }
   
    public int getId() {
        return id;
    }
   
    public Goruntu_Sec() {
        initComponents();
        this.islemler = new Islemler();
        model=(DefaultTableModel)fis_tablosu.getModel();
        fis_goruntule();
        
    }
    public Goruntu_Sec(int id,String isletme_adi,String tarih,int fis_no,float urunler_kdv,float toplam_fiyat) {
        this.id=id;
        this.isletme_adi = isletme_adi;
        this.fis_no = fis_no;
        this.tarih = tarih;
        this.urunler_kdv =urunler_kdv;
        this.toplam_fiyat =toplam_fiyat;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Goruntu_Sec = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        show_image = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fis_tablosu = new javax.swing.JTable();
        isletme_ara = new javax.swing.JTextField();
        tarih_ara = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        parse_alani = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Goruntu_Sec.setText("Goruntu Sec");
        Goruntu_Sec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Goruntu_SecActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(show_image, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(show_image, javax.swing.GroupLayout.DEFAULT_SIZE, 365, Short.MAX_VALUE)
                .addContainerGap())
        );

        fis_tablosu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "işletme adı", "tarih", "fiş no", "ürünler KDV'ler fiyatlar", "toplam fiyat"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(fis_tablosu);
        if (fis_tablosu.getColumnModel().getColumnCount() > 0) {
            fis_tablosu.getColumnModel().getColumn(0).setResizable(false);
            fis_tablosu.getColumnModel().getColumn(1).setResizable(false);
            fis_tablosu.getColumnModel().getColumn(2).setResizable(false);
            fis_tablosu.getColumnModel().getColumn(3).setResizable(false);
            fis_tablosu.getColumnModel().getColumn(4).setResizable(false);
            fis_tablosu.getColumnModel().getColumn(5).setResizable(false);
        }

        isletme_ara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                isletme_araKeyReleased(evt);
            }
        });

        tarih_ara.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tarih_araKeyReleased(evt);
            }
        });

        jLabel1.setText("İşletme Adı");

        jLabel2.setText("Tarih");

        jLabel3.setText("            Arama");

        parse_alani.setColumns(20);
        parse_alani.setRows(5);
        jScrollPane2.setViewportView(parse_alani);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Goruntu_Sec, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                            .addComponent(isletme_ara)
                            .addComponent(tarih_ara)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Goruntu_Sec)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(isletme_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tarih_ara, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Goruntu_SecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Goruntu_SecActionPerformed
        JFileChooser fc=new JFileChooser();
        int i=fc.showOpenDialog(this);
       
        if(i==JFileChooser.APPROVE_OPTION){
            this.dosya_yolu= fc.getSelectedFile().getPath();
            System.load("C:\\opencv\\build\\java\\x64\\opencv_java411.dll");
            
            List<MatOfPoint> contours = new ArrayList<MatOfPoint>();
            Mat dilate=new Mat();
            Mat source = Imgcodecs.imread(dosya_yolu,Imgproc.COLOR_BGR2GRAY); 
            Mat imageThresh1 = new Mat(source.size(), CvType.CV_8UC4);
            Mat imageThresh = new Mat(source.size(), CvType.CV_8UC4);
            Mat imageBlurr = new Mat(source.size(),CvType.CV_8UC4);
            Mat imageA = new Mat(source.rows(),source.cols(),source.type());
            Mat morp=new Mat(); 
            Mat erode=new Mat(source.size(), CvType.CV_8UC4);
            Mat cnts=new Mat(source.size(), CvType.CV_8UC4);
           
            /*
            Imgproc.cvtColor(source,imageA, Imgproc.COLOR_BGR2GRAY);
            
            Imgproc.GaussianBlur(imageA, imageBlurr, new Size(9,9),0);
            //Imgproc.adaptiveThreshold(imageBlurr, imageThresh1,255,Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY,11,12);
            
           
            Mat kernel =Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(3, 3));
            
            Imgproc.morphologyEx(imageBlurr, morp,Imgproc.MORPH_OPEN,kernel);
            Imgproc.threshold(morp,imageThresh,0,255,Imgproc.THRESH_OTSU);
            //Imgproc.erode(morp,erode, kernel);
            Imgproc.dilate(imageThresh, dilate, kernel);
            Imgproc.threshold(dilate,imageThresh1,0,255,Imgproc.THRESH_BINARY_INV);
            Imgcodecs.imwrite("C:\\Users\\user\\Documents\\NetBeansProjects\\Yazlab\\src\\fis_son.png",imageThresh1); 
            */
            Imgproc.cvtColor(source,imageA, Imgproc.COLOR_BGR2GRAY);
            Imgproc.threshold(imageA,imageThresh,127,255,Imgproc.THRESH_BINARY_INV+Imgproc.THRESH_OTSU);
            Imgproc.GaussianBlur(imageThresh, imageBlurr, new Size(9,9),0);
            //Imgproc.adaptiveThreshold(imageBlurr, imageThresh1,255,Imgproc.ADAPTIVE_THRESH_GAUSSIAN_C, Imgproc.THRESH_BINARY,11,12);
            
           
            Mat kernel =Imgproc.getStructuringElement(Imgproc.MORPH_CROSS, new Size(3, 3));
            
            Imgproc.morphologyEx(imageBlurr, morp,Imgproc.MORPH_OPEN,kernel);
            //Imgproc.erode(morp,erode, kernel);
            Imgproc.dilate(morp, dilate, kernel);
             
            //Imgproc.findContours(dilate, contours, new Mat(), Imgproc.RETR_LIST,Imgproc.CHAIN_APPROX_SIMPLE);            
            Imgcodecs.imwrite("C:\\Users\\user\\Documents\\NetBeansProjects\\Yazlab\\src\\fis_son.png",dilate); 
            
   
            File imageFile = new File("C:\\Users\\user\\Documents\\NetBeansProjects\\Yazlab\\src\\fis_son.png");
            Tesseract tessInst = new Tesseract();
            tessInst.setDatapath("C:\\Users\\user\\Documents\\NetBeansProjects\\Yazlab\\tessdata");
            tessInst.setLanguage("tur");
            
            
        try { 
           String result = tessInst.doOCR(imageFile);
          
           result = result.toUpperCase();
           System.out.println(result);
            
           int isletme_indis=result.indexOf("\n");
           String srkt = result.substring(0,isletme_indis);
          
           
         
           
           int trh=result.indexOf("TARİH");
           String date = result.substring(trh+8,trh+19);
           /*int len = trh1.length();
           String trh2 = "00/00/0000 00:00:00";
           int ind = 0;
           for(int a=0; a < len; a++){
               if ((Character.isDigit(trh1.charAt(a)) == true) || (trh1.charAt(a) == '/')) {
                   char c = trh1.charAt(a);
                   trh2 = replaceChar(trh2,c,ind);
                   ind++;
            }
           }
           int saat=result.indexOf("SAAT");
           String saat1 = result.substring(saat+7,saat+16);
           len = saat1.length();
           ind++;
           for(int a=0; a < len; a++){
               if ((Character.isDigit(saat1.charAt(a)) == true) || (saat1.charAt(a) == ':')) {
                   char c = saat1.charAt(a);
                   trh2 = replaceChar(trh2,c,ind);
                   ind++;
            }
           }
           SimpleDateFormat formatter1=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            Date date = null;
                try {
                    date = (Date) formatter1.parse(trh2);
                } catch (ParseException ex) {
                    Logger.getLogger(Goruntu_Sec.class.getName()).log(Level.SEVERE, null, ex);
                }
           //System.out.println(trh1);
           //System.out.println(trh2);
           System.out.println(date);
           
           
           */
           int len  = result.length();
           int no = 0;
           for(int a=0; a < len; a++){
               if(result.charAt(a) == 'F'){
                   if(result.charAt(a+2) == 'Ş'){
                       no = a;
                       break;
                   }
               }
           }
           String no1 = result.substring(no+8,no+13);
           String no2 = "00000";
           len = no1.length();
           int ind = 4;
           for(int a=len-1; -1 < a; a--){
               if ((Character.isDigit(no1.charAt(a)) == true)) {
                   char c = no1.charAt(a);
                   no2 = replaceChar(no2,c,ind);
                   ind--;
            }
           }
           int fisNo = Integer.parseInt(no2);
           //System.out.println(no1);
           //System.out.println(no2);

            
          
           
           
           int kdv=result.indexOf("TOPKDV");
           String kdv1 = result.substring(kdv+8, kdv+14);
           String kdv2 = "00000";
           len = kdv1.length();
           ind = 4;
           char v =',';
           char n = '.';
           for(int a=len-1; -1 < a; a--){
               if ((Character.isDigit(kdv1.charAt(a)) == true)) {
                   char c = kdv1.charAt(a);
                   kdv2 = replaceChar(kdv2,c,ind);
                   ind--;
            }
               if (v == kdv1.charAt(a) || n == kdv1.charAt(a)) {
                   kdv2 = replaceChar(kdv2,n,ind);
                   ind--;
            }
           }
           float topKdv = Float.parseFloat(kdv2);
           
           
           
           int lam=result.indexOf("TOPLAM");
           String lam1= result.substring(lam+8,lam+12);
           String lam2 = "000000";
           len = lam1.length();
           ind = 5;
           for(int a=len-1; -1 < a; a--){
               if ((Character.isDigit(lam1.charAt(a)) == true)) {
                   char c = lam1.charAt(a);
                   lam2 = replaceChar(lam2,c,ind);
                   ind--;
            }
               if (v == lam1.charAt(a) || n == lam1.charAt(a)) {
                   lam2 = replaceChar(lam2,n,ind);
                   ind--;
            }
           }
           float toplam = Float.parseFloat(lam2);
           
           //System.out.println(lam1);
           //System.out.println(lam2);

           islemler.FisEkle(srkt,date,fisNo,topKdv, toplam );
           fis_goruntule();
           parse_alani.append("PARSE"+"\n\n"+srkt + "\n" + date + "\n" + fisNo+ "\n" + "\n" +topKdv+ "\n" + toplam );
         
        } catch (TesseractException e) {
            System.err.println(e.getMessage());
        }
      
        
    }//GEN-LAST:event_Goruntu_SecActionPerformed
        ImageIcon ii=new ImageIcon(dosya_yolu);
        Image image=ii.getImage().getScaledInstance(show_image.getWidth(), show_image.getHeight(),Image.SCALE_SMOOTH);
        show_image.setIcon(new ImageIcon(image));
    } 
    public void dinamik_ara_isletme(String isletme_ara){
        TableRowSorter <DefaultTableModel> tr =new TableRowSorter<DefaultTableModel>(model);
        fis_tablosu.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(isletme_ara,1));
    }
     public void dinamik_ara_tarih(String isletme_ara){
        TableRowSorter <DefaultTableModel> tr =new TableRowSorter<DefaultTableModel>(model);
        fis_tablosu.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(isletme_ara,2));
    }
    private void isletme_araKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isletme_araKeyReleased
        String ara=isletme_ara.getText();
        dinamik_ara_isletme(ara);
    }//GEN-LAST:event_isletme_araKeyReleased

    private void tarih_araKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tarih_araKeyReleased
        String ara=tarih_ara.getText();
        dinamik_ara_tarih(ara);
    }//GEN-LAST:event_tarih_araKeyReleased
        
    public void fis_goruntule(){
        model.setRowCount(0);
        ArrayList <Goruntu_Sec> fis=new ArrayList <Goruntu_Sec>();
        fis=islemler.fisgetir();
        if(fis!=null){
            for(Goruntu_Sec m:fis){
                    Object[] ekle ={m.getId(),m.getIsletme_adi(),m.getTarih(),m.getFis_no(), m.getUrunler_kdv(),m.getToplam_fiyat()};
                    
                    model.addRow(ekle);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* S et the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Goruntu_Sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Goruntu_Sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Goruntu_Sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Goruntu_Sec.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Goruntu_Sec().setVisible(true);
            }
            
        });
        /////BURADAN İTİBAREN
        
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Goruntu_Sec;
    private javax.swing.JTable fis_tablosu;
    private javax.swing.JTextField isletme_ara;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Panel panel1;
    private javax.swing.JTextArea parse_alani;
    private javax.swing.JLabel show_image;
    private javax.swing.JTextField tarih_ara;
    // End of variables declaration//GEN-END:variables

   public String replaceChar(String str, char ch, int index) {
    StringBuilder myString = new StringBuilder(str);
    myString.setCharAt(index, ch);
    return myString.toString();
}
}