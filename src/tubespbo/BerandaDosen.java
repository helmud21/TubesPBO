/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sipendataanmahasiswakp;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class BerandaDosen extends javax.swing.JFrame {

    /**
     * Creates new form BerandaDosen
     */
    String kolom[] = new String[] {""};
    private DefaultTableModel model;
    
    public BerandaDosen() {
        initComponents();
        
        // Memberi penamaan pada judul kolom DaftarKP
        setTitle("Daftar Mahasiswa KP");
        model = new DefaultTableModel();
        daftarKP.setModel(model);
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Alamat");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Angkatan");
        model.addColumn("Nama Instansi");
        model.addColumn("Alamat Instansi");
        model.addColumn("Waktu KP");
        model.addColumn("Dosen Pembimbing");
        model.addColumn("Status KP");
        getData();
    }
    
    public void InserFormulirKP(){
        try {
            String sql = "INSERT INTO formulir VALUES ('" + nim.getText() + "','"+ nama.getText()+ "','" + alamat.getText() + "','" + jk.getText()
                    + "','" + angkatan.getText() + "','" + nama_instansi.getText() + "','" + alamat_instansi.getText() + "','" 
                    + waktu.getText() + "','" + status.getText() + "','" + dosen_pembimbing.getText() + "')";
            java.sql.Connection conn = (Connection) Koneksi.getKoneksi();
            java.sql.Statement stm = (java.sql.Statement) Koneksi.getKoneksi().createStatement();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dikirim");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Isian Data Tidak Valid, Mohon Periksa Kembali");
        }
    }
    
    public void getData(){
        
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        
        try{
            // membuat statemen pemanggilan data pada table Formulir dari database
            Statement stat = (Statement) Koneksi.getKoneksi().createStatement();
            String sql = "SELECT * from formulir";
            ResultSet res = stat.executeQuery(sql);
            
            // penelusuran baris pada tabel Formulir dari database
            while(res.next()){
                Object[] obj = new Object[10];
                obj[0] = res.getString("NIM");
                obj[1] = res.getString("Nama");
                obj[2] = res.getString("Alamat");
                obj[3] = res.getString("Jenis_Kelamin");
                obj[4] = res.getString("Angkatan");
                obj[5] = res.getString("Nama_Instansi");
                obj[6] = res.getString("Alamat_Instansi");
                obj[7] = res.getString("Waktu_KP");
                obj[8] = res.getString("Dosen_Pembimbing");
                obj[9] = res.getString("Status_KP");
                
                model.addRow(obj);
            }
        }catch(SQLException err){
            JOptionPane.showMessageDialog(null, err.getMessage());
        }
    }
    
    public void updateData() {
        int ok=JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Untuk Mengubah Data Ini?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        try {
            String sql = "UPDATE formulir SET NIM=?,Nama=?,Alamat=?,Jenis_Kelamin=?,Angkatan=?,Nama_Instansi=?,Alamat_Instansi=?,Waktu_KP=?,Status_KP=?,Dosen_Pembimbing=? WHERE NIM='" + nim.getText() + "'";

            java.sql.Connection conn = (Connection) Koneksi.getKoneksi();
            java.sql.Statement stm = (java.sql.Statement) Koneksi.getKoneksi().createStatement();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            if(ok==0){
                try{
                    pst.setString(1,nim.getText());
                    pst.setString(2,nama.getText());
                    pst.setString(3,alamat.getText());
                    pst.setString(4,jk.getText());
                    pst.setString(5,angkatan.getText());
                    pst.setString(6,nama_instansi.getText());
                    pst.setString(7,alamat_instansi.getText());
                    pst.setString(8,waktu.getText());
                    pst.setString(9,status.getText());
                    pst.setString(10,dosen_pembimbing.getText());
                    pst.executeUpdate();
                    
                    JOptionPane.showMessageDialog(null, "Memperbarui Data Berhasil");
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Memperbarui Data Gagal");
                }
            }
        } catch (Exception e) {
        }
    }
    
    
    public void deleteData() {
        int ok=JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin Untuk Menghapus Data Ini?","Konfirmasi",JOptionPane.YES_NO_OPTION);
        if (ok==0){
            try {
                String sql = "DELETE FROM formulir WHERE NIM = '" + nim.getText() + "'";
                java.sql.Connection conn = (Connection) Koneksi.getKoneksi();
                java.sql.Statement stm = (java.sql.Statement) Koneksi.getKoneksi().createStatement();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Hapus Data Berhasil");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Hapus Data Gagal");
        }
        getData();
        hilang();
        }
    }
    
    public void hilang(){
        nim.setText("");
        nama.setText("");
        alamat.setText("");
        jk.setText("");
        angkatan.setText("");
        nama_instansi.setText("");
        alamat_instansi.setText("");
        waktu.setText("");
        status.setText("");
        dosen_pembimbing.setText("");
    }
                                     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        daftarKP = new javax.swing.JTable();
        ubah = new javax.swing.JButton();
        hapus = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        nim = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        alamat = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        angkatan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        nama_instansi = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        alamat_instansi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        waktu = new javax.swing.JTextField();
        simpan = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        dosen_pembimbing = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        keluar = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        jk = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        daftarKP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        daftarKP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                daftarKPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(daftarKP);

        ubah.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        ubah.setText("Perbarui");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Nama");

        nama.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Nim");

        nim.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nimActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Alamat");

        alamat.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        alamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamatActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Jenis Kelamin");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Angkatan");

        angkatan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        angkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                angkatanActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Nama Instansi");

        nama_instansi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nama_instansi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_instansiActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Alamat Instansi");

        alamat_instansi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        alamat_instansi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamat_instansiActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Waktu KP");

        waktu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        waktu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                waktuActionPerformed(evt);
            }
        });

        simpan.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        reset.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        dosen_pembimbing.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        dosen_pembimbing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dosen_pembimbingActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Dosen Pembimbing");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel25.setText("Sistem Pendataan Mahasiswa KP Prodi Informatika");

        jLabel26.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel26.setText("\"Institut Teknologi Sumatera\"");

        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/itera.png"))); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel24))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(jLabel27)
                        .addGap(52, 52, 52)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel26)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(102, 51, 255));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Daftar Mahasiswa KP");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(443, 443, 443)
                .addComponent(jLabel23)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(51, 102, 255));

        keluar.setBackground(new java.awt.Color(51, 102, 255));
        keluar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        keluar.setForeground(new java.awt.Color(255, 255, 255));
        keluar.setText("Keluar");
        keluar.setToolTipText("");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(keluar, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel28.setText("Status KP");

        status.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        status.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statusActionPerformed(evt);
            }
        });

        jk.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14)
                            .addComponent(jLabel11)
                            .addComponent(jLabel28))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nama_instansi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(alamat_instansi, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dosen_pembimbing, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(simpan)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ubah))
                                .addGap(18, 18, 18)
                                .addComponent(hapus))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel13))
                                    .addGap(44, 44, 44)
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jk, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 777, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(370, 370, 370)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(dosen_pembimbing, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nim, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jk, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(nama_instansi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(alamat_instansi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 357, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(simpan)
                            .addComponent(ubah)
                            .addComponent(hapus))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(reset)
                        .addGap(30, 30, 30))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        nama.setText("");
        nim.setText("");
        alamat.setText("");
        jk.setText("");
        angkatan.setText("");
        nama_instansi.setText("");
        alamat_instansi.setText("");
        waktu.setText("");
        status.setText("");
        dosen_pembimbing.setText("");
        
    }//GEN-LAST:event_resetActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        deleteData();
    }//GEN-LAST:event_hapusActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
        updateData();
        getData();
    }//GEN-LAST:event_ubahActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        InserFormulirKP();
        getData();
    }//GEN-LAST:event_simpanActionPerformed

    private void daftarKPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daftarKPMouseClicked
        // TODO add your handling code here:
        try {
            int row = daftarKP.getSelectedRow();
            String tabel_klik = (daftarKP.getModel().getValueAt(row, 0).toString());
            java.sql.Connection conn = (java.sql.Connection) Koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT * FROM formulir WHERE NIM ='" + tabel_klik + "'");
            if (sql.next()) {
                String NIM = sql.getString("NIM");
                nim.setText(NIM);
                String nm = sql.getString("Nama");
                nama.setText(nm);
                String al = sql.getString("Alamat");
                alamat.setText(al);
                String j_k = sql.getString("Jenis_Kelamin");
                jk.setText(j_k);
                String ang = sql.getString("Angkatan");
                angkatan.setText(ang);
                String ni = sql.getString("Nama_Instansi");
                nama_instansi.setText(ni);
                String ai = sql.getString("Alamat_Instansi");
                alamat_instansi.setText(ai);
                String wkt = sql.getString("Waktu_KP");
                waktu.setText(wkt);
                String sts = sql.getString("Status_KP");
                status.setText(sts);
                String dp = sql.getString("Dosen_Pembimbing");
                dosen_pembimbing.setText(dp);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_daftarKPMouseClicked

    private void waktuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_waktuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_waktuActionPerformed

    private void alamat_instansiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamat_instansiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamat_instansiActionPerformed

    private void nama_instansiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_instansiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_instansiActionPerformed

    private void alamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamatActionPerformed

    private void dosen_pembimbingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosen_pembimbingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dosen_pembimbingActionPerformed

    private void nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nimActionPerformed

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        new LoginDosen().setVisible(true);
        dispose();
    }//GEN-LAST:event_keluarActionPerformed

    private void statusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_statusActionPerformed

    private void angkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_angkatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_angkatanActionPerformed

    private void jkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jkActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(BerandaDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BerandaDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BerandaDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BerandaDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BerandaDosen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField alamat;
    private javax.swing.JTextField alamat_instansi;
    private javax.swing.JTextField angkatan;
    private javax.swing.JTable daftarKP;
    private javax.swing.JTextField dosen_pembimbing;
    private javax.swing.JButton hapus;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jk;
    private javax.swing.JButton keluar;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nama_instansi;
    private javax.swing.JTextField nim;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    private javax.swing.JTextField status;
    private javax.swing.JButton ubah;
    private javax.swing.JTextField waktu;
    // End of variables declaration//GEN-END:variables
}
