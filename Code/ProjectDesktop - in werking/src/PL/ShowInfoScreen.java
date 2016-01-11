package PL;

import BLL.ServiceLayer;
import CONSTANTS.IntConstants;
import CONSTANTS.StringConstants;
import Dal.Film;
import Dal.Vertoning;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class ShowInfoScreen extends javax.swing.JFrame {

    private Film _film;
    private String _selectedTime;
    private JFrame _mainScreen;
    private ServiceLayer _sl;
    private ArrayList<Vertoning> _lstVertoningen;
    
    public ShowInfoScreen() {
        initComponents();
    }
    
    public ShowInfoScreen(Film film, JFrame mainScreen) {
        initComponents();
        this._film = film;
        this._mainScreen = mainScreen;
        this._sl = new ServiceLayer();
        // TODO: in helpermethode zsteken
        this.setIconImage(_sl.setFavicon().getImage());
        this._lstVertoningen = _sl.createShows();
        setupShowInfoScreen(film, _sl);
        _selectedTime = StringConstants.EMPTY.getValue();
    }

    private void setupShowInfoScreen(Film film, ServiceLayer sl) {
        ui_btnStartTime1.setVisible(false);
        ui_lblStartTime1.setVisible(false);
        ui_btnStartTime2.setVisible(false);
        ui_lblStartTime2.setVisible(false);
        ui_btnStartTime3.setVisible(false);
        ui_lblStartTime3.setVisible(false);
        
        String[] speelUren = film.getSpeelUren().split(" ");
        for (String item : speelUren) {
            String temp = item.replace(',', ' ').trim();
            if (temp.equals("16:00")) {
                ui_btnStartTime1.setVisible(true);
                ui_lblStartTime1.setVisible(true);
            }
            if (temp.equals("19:00")) {
                ui_btnStartTime2.setVisible(true);
                ui_lblStartTime2.setVisible(true);
            }
            if (temp.equals("22:00")) {
                ui_btnStartTime3.setVisible(true);
                ui_lblStartTime3.setVisible(true);
            }
        }
        
        ui_lblCurrentVertoning.setText(_film.getNaam());

        ui_lblShowInfoBG.setIcon(sl.setFoto(_film.getInfoBG()));    
    
        String[] speelDagen = film.getSpeelDagen().split(" ");
        for (String item : speelDagen) {
            String replace = item.replace(',', ' ').trim();
            ui_ddlDays.addItem(replace);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        ui_lblShowInfoBG = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ui_lblCurrentVertoning = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ui_ddlDays = new javax.swing.JComboBox<>();
        ui_btnBuyTickets = new javax.swing.JButton();
        ui_btnBackToMainScreen = new javax.swing.JButton();
        ui_btnStartTime1 = new javax.swing.JToggleButton();
        ui_btnStartTime2 = new javax.swing.JToggleButton();
        ui_btnStartTime3 = new javax.swing.JToggleButton();
        ui_lblStartTime1 = new javax.swing.JLabel();
        ui_lblStartTime2 = new javax.swing.JLabel();
        ui_lblStartTime3 = new javax.swing.JLabel();
        ui_lblFilmName = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 204, 204));
        setMaximumSize(new java.awt.Dimension(506, 324));
        setMinimumSize(new java.awt.Dimension(506, 324));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(506, 324));
        setResizable(false);

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(506, 324));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(506, 324));

        jPanel3.setMaximumSize(new java.awt.Dimension(506, 324));
        jPanel3.setMinimumSize(new java.awt.Dimension(506, 324));
        jPanel3.setOpaque(false);

        ui_lblShowInfoBG.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        ui_lblShowInfoBG.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        ui_lblShowInfoBG.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 506, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(ui_lblShowInfoBG)
                    .addGap(0, 0, 0)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(ui_lblShowInfoBG)
                    .addGap(0, 0, 0)))
        );

        jPanel1.setBackground(new java.awt.Color(0, 0, 85));
        jPanel1.setMaximumSize(new java.awt.Dimension(436, 311));
        jPanel1.setMinimumSize(new java.awt.Dimension(436, 311));
        jPanel1.setOpaque(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bgShowInfoScreen.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jLabel3)
                    .addContainerGap(7, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(0, 0, 0)
                    .addComponent(jLabel3)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(506, 324));
        jPanel2.setMinimumSize(new java.awt.Dimension(506, 324));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(506, 324));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ui_lblCurrentVertoning.setFont(new java.awt.Font("sansserif", 0, 28)); // NOI18N
        ui_lblCurrentVertoning.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ui_lblCurrentVertoning.setText("Star Wars: Episode VII");
        ui_lblCurrentVertoning.setToolTipText("");
        ui_lblCurrentVertoning.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        ui_lblCurrentVertoning.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(ui_lblCurrentVertoning, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 202, 330, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/banner.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 195, -1, -1));

        ui_ddlDays.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(ui_ddlDays, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 77, 130, -1));

        ui_btnBuyTickets.setText("Buy Tickets");
        ui_btnBuyTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnBuyTickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnBuyTicketsActionPerformed(evt);
            }
        });
        jPanel2.add(ui_btnBuyTickets, new org.netbeans.lib.awtextra.AbsoluteConstraints(322, 157, -1, -1));

        ui_btnBackToMainScreen.setText("Cancel");
        ui_btnBackToMainScreen.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnBackToMainScreen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnBackToMainScreenActionPerformed(evt);
            }
        });
        jPanel2.add(ui_btnBackToMainScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 76, -1, -1));

        ui_btnStartTime1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/4uurNotSelected.png"))); // NOI18N
        ui_btnStartTime1.setContentAreaFilled(false);
        ui_btnStartTime1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnStartTime1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        ui_btnStartTime1.setRolloverEnabled(false);
        ui_btnStartTime1.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/4uurSelected.png"))); // NOI18N
        ui_btnStartTime1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnStartTime1ActionPerformed(evt);
            }
        });
        jPanel2.add(ui_btnStartTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 132, 65, -1));

        ui_btnStartTime2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/7uurNotSelected.png"))); // NOI18N
        ui_btnStartTime2.setContentAreaFilled(false);
        ui_btnStartTime2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnStartTime2.setRolloverEnabled(false);
        ui_btnStartTime2.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/7uurSelected.png"))); // NOI18N
        ui_btnStartTime2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnStartTime2ActionPerformed(evt);
            }
        });
        jPanel2.add(ui_btnStartTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(158, 132, 65, -1));

        ui_btnStartTime3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/10uurNotSelected.png"))); // NOI18N
        ui_btnStartTime3.setContentAreaFilled(false);
        ui_btnStartTime3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnStartTime3.setRolloverEnabled(false);
        ui_btnStartTime3.setSelectedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/10uurSelected.png"))); // NOI18N
        ui_btnStartTime3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnStartTime3ActionPerformed(evt);
            }
        });
        jPanel2.add(ui_btnStartTime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(229, 132, 65, -1));

        ui_lblStartTime1.setForeground(new java.awt.Color(255, 255, 255));
        ui_lblStartTime1.setText("16:00");
        jPanel2.add(ui_lblStartTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 110, -1, -1));

        ui_lblStartTime2.setForeground(new java.awt.Color(255, 255, 255));
        ui_lblStartTime2.setText("19:00");
        jPanel2.add(ui_lblStartTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(174, 110, -1, -1));

        ui_lblStartTime3.setForeground(new java.awt.Color(255, 255, 255));
        ui_lblStartTime3.setText("22:00");
        jPanel2.add(ui_lblStartTime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 110, -1, -1));

        ui_lblFilmName.setFont(new java.awt.Font("sansserif", 0, 27)); // NOI18N
        ui_lblFilmName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ui_lblFilmName.setText("Star Wars: Episode VII");
        ui_lblFilmName.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel2.add(ui_lblFilmName, new org.netbeans.lib.awtextra.AbsoluteConstraints(87, 202, 325, 38));

        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 507, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 144, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 324, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 331, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 165, Short.MAX_VALUE)))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ui_btnStartTime1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnStartTime1ActionPerformed
        if (ui_btnStartTime1.isSelected()) {
            ui_btnStartTime2.setSelected(false);
            ui_btnStartTime3.setSelected(false);
            _selectedTime = "16:00";
        }
    }//GEN-LAST:event_ui_btnStartTime1ActionPerformed

    private void ui_btnStartTime2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnStartTime2ActionPerformed
        if (ui_btnStartTime2.isSelected()) {
            ui_btnStartTime1.setSelected(false);
            ui_btnStartTime3.setSelected(false);
            _selectedTime = "19:00";
        }
    }//GEN-LAST:event_ui_btnStartTime2ActionPerformed

    private void ui_btnStartTime3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnStartTime3ActionPerformed
        if (ui_btnStartTime3.isSelected()) {
            ui_btnStartTime1.setSelected(false);
            ui_btnStartTime2.setSelected(false);
            _selectedTime = "22:00";
        }
    }//GEN-LAST:event_ui_btnStartTime3ActionPerformed

    private void ui_btnBackToMainScreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnBackToMainScreenActionPerformed
        this.dispose();
        _mainScreen.setEnabled(true);
        _mainScreen.setVisible(true);
    }//GEN-LAST:event_ui_btnBackToMainScreenActionPerformed

    private void ui_btnBuyTicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnBuyTicketsActionPerformed
        try {
            if (!_selectedTime.equals(StringConstants.EMPTY.getValue())) {
                if (ui_ddlDays.getSelectedItem().equals(new SimpleDateFormat("EEEE", Locale.UK).format(new Date()))) {
                    if (_sl.compareTime(_selectedTime) > -1) {
                        helperBuyTicket();
                    } else {
                        JOptionPane.showMessageDialog(null, "This movie has already begun.", StringConstants.BUY_ERRORMSG_TITLE.getValue(), JOptionPane.INFORMATION_MESSAGE, _sl.setFavicon());
                    }
                } else if (!ui_ddlDays.getSelectedItem().equals(new SimpleDateFormat("EEEE", Locale.UK).format(new Date()))) {
                    helperBuyTicket();
                }
            } else {
                JOptionPane.showMessageDialog(null, "You have no time specified for the movie.", StringConstants.BUY_ERRORMSG_TITLE.getValue(), JOptionPane.INFORMATION_MESSAGE, _sl.setFavicon());
            }
        } catch (ParseException ex) {
            Logger.getLogger(ShowInfoScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_ui_btnBuyTicketsActionPerformed

    private void helperBuyTicket() throws HeadlessException {
        if (ui_btnStartTime2.isSelected()
                || ui_btnStartTime1.isSelected()
                || ui_btnStartTime3.isSelected()) {
            Vertoning selectedVertoning = null;
            for (Vertoning vertoning : _lstVertoningen) {
                if (vertoning.getSpeelDag().equals(ui_ddlDays.getSelectedItem().toString())
                        && vertoning.getFilmNaam().equals(ui_lblCurrentVertoning.getText())
                        && vertoning.getSpeelUur().equals(_selectedTime)) {
                    selectedVertoning = new Vertoning(vertoning.getId(), vertoning.getFilmNaam(), vertoning.getSpeelDag(), _selectedTime, vertoning.getPrijs(), vertoning.getZaalNummer(), vertoning.getPlaatsen());
                }
            }
            if (selectedVertoning != null) {
                TicketScreen ts = new TicketScreen(selectedVertoning, _mainScreen, this);
                this.setVisible(false);
                this.setEnabled(false);
                _mainScreen.setVisible(true);
                Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
                ts.setLocation(dim.width / IntConstants.TWO.getValue() - ts.getSize().width / IntConstants.TWO.getValue(), dim.height / IntConstants.TWO.getValue() - ts.getSize().height / IntConstants.TWO.getValue() - 50);
                ts.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(null, "You must select the time of the movie.", "Forgot to select a time", JOptionPane.INFORMATION_MESSAGE, _sl.setFavicon());
        }
    }

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
            java.util.logging.Logger.getLogger(ShowInfoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShowInfoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShowInfoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShowInfoScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ShowInfoScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton ui_btnBackToMainScreen;
    private javax.swing.JButton ui_btnBuyTickets;
    private javax.swing.JToggleButton ui_btnStartTime1;
    private javax.swing.JToggleButton ui_btnStartTime2;
    private javax.swing.JToggleButton ui_btnStartTime3;
    private javax.swing.JComboBox<String> ui_ddlDays;
    private javax.swing.JLabel ui_lblCurrentVertoning;
    private javax.swing.JLabel ui_lblFilmName;
    private javax.swing.JLabel ui_lblShowInfoBG;
    private javax.swing.JLabel ui_lblStartTime1;
    private javax.swing.JLabel ui_lblStartTime2;
    private javax.swing.JLabel ui_lblStartTime3;
    // End of variables declaration//GEN-END:variables
}
