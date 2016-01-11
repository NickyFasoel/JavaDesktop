package PL;

// <editor-fold defaultstate="collapsed" desc="Imports">

import BLL.CountTickets;
import BLL.CreateAKlant;
import BLL.ServiceLayer;
import CONSTANTS.IntConstants;
import CONSTANTS.StringConstants;
import Dal.Film;
import Dal.Vertoning;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;

// </editor-fold>

public class TicketScreen extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="Private Member Variables">

    private final JFrame _jframeMainScreen;
    private final JFrame _jframeShowInfoScreen;
    private final Vertoning _vertoning;
    private final ServiceLayer _sl;
    private final ImageIcon _icon;
    private int _aantalTickets;
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    
    /* Haalt de data van de geselecteerde film */
    private void prepareTicketScreen() {
        _sl.setFavicon();
        _aantalTickets = IntConstants.ONE.getValue();
        ui_lblDatum.setText(_vertoning.getSpeelDag());
        ui_lblFilmNaam.setText(_vertoning.getFilmNaam());
        DecimalFormat df = new DecimalFormat(StringConstants.DECIMAL_FORMAT.getValue());
        String euroPrijs = StringConstants.EURO_SYMBOL.getValue() + String.valueOf(df.format(_vertoning.getPrijs()));
        ui_lblPrijs.setText(euroPrijs);
        ui_lblStartingTime.setText(_vertoning.getSpeelUur());
        ui_lblZaal.setText(String.valueOf(_vertoning.getZaalNummer()));
    }

    private String calculatePrijs(int aantalTickets) {
        DecimalFormat df = new DecimalFormat(StringConstants.DECIMAL_FORMAT.getValue());
        double totaal = aantalTickets * _vertoning.getPrijs();
        String euroPrijs = StringConstants.EURO_SYMBOL.getValue() + String.valueOf(df.format(totaal));
        return euroPrijs;
    }
    
    private void checkFreeTickets() {
        ui_txtRemainingTickets.setText(String.valueOf(_vertoning.getPlaatsen()));
        Timer timeClock = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui_txtRemainingTickets.setText(String.valueOf(_vertoning.getPlaatsen() - _sl.countTickets(_vertoning)));
            }
        });
        timeClock.start();
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    
    public TicketScreen(Vertoning vertoning, JFrame jframe, JFrame jframe2) {
        initComponents();
        /* Gebruikt de instantie van mainscreen om deze te beheren (zoals te tonen) */
        this._jframeMainScreen = jframe;
        this._jframeShowInfoScreen = jframe2;
        this._vertoning = vertoning;
        _sl = new ServiceLayer();
        _icon = _sl.setFavicon();
        prepareTicketScreen();
        ui_txtRemainingTickets.setText(String.valueOf(vertoning.getPlaatsen()));
        checkFreeTickets();
    }

    // </editor-fold>
    
@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ui_lblFilmNaam = new javax.swing.JLabel();
        ui_lblZaal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ui_lblDatum = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ui_txtAantalTickets = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        ui_btnSubtract = new javax.swing.JButton();
        ui_btnAdd = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        ui_lblPrijs = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ui_lblStartingTime = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ui_btnCancel = new javax.swing.JButton();
        ui_btnProceed = new javax.swing.JButton();
        ui_txtRemainingTickets = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setUndecorated(true);
        setSize(new java.awt.Dimension(600, 294));

        jLayeredPane1.setBackground(new java.awt.Color(0, 0, 0));
        jLayeredPane1.setMaximumSize(new java.awt.Dimension(600, 294));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(600, 294));
        jLayeredPane1.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(null);
        jPanel1.setMaximumSize(new java.awt.Dimension(600, 294));
        jPanel1.setMinimumSize(new java.awt.Dimension(600, 294));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 294));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ticketScaled.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(15, 15, 15))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(600, 294));
        jPanel2.setMinimumSize(new java.awt.Dimension(600, 294));
        jPanel2.setOpaque(false);

        ui_lblFilmNaam.setFont(new java.awt.Font("sansserif", 0, 36)); // NOI18N
        ui_lblFilmNaam.setForeground(new java.awt.Color(255, 255, 255));
        ui_lblFilmNaam.setText("Star Wars: Episode VII");
        ui_lblFilmNaam.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        ui_lblZaal.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        ui_lblZaal.setForeground(new java.awt.Color(255, 255, 255));
        ui_lblZaal.setText("10");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Screen:");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Day:");

        ui_lblDatum.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        ui_lblDatum.setForeground(new java.awt.Color(255, 255, 255));
        ui_lblDatum.setText("Monday");

        jLabel5.setBackground(new java.awt.Color(230, 229, 234));
        jLabel5.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("__________________________________________________________");
        jLabel5.setToolTipText("");
        jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);

        ui_txtAantalTickets.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        ui_txtAantalTickets.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ui_txtAantalTickets.setText("1");
        ui_txtAantalTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ui_txtAantalTickets.setFocusable(false);
        ui_txtAantalTickets.setMaximumSize(new java.awt.Dimension(47, 47));
        ui_txtAantalTickets.setMinimumSize(new java.awt.Dimension(47, 47));
        ui_txtAantalTickets.setPreferredSize(new java.awt.Dimension(47, 47));

        jLabel6.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("How many tickets would you like?");

        ui_btnSubtract.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/-.png"))); // NOI18N
        ui_btnSubtract.setContentAreaFilled(false);
        ui_btnSubtract.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnSubtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnSubtractActionPerformed(evt);
            }
        });

        ui_btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/+.png"))); // NOI18N
        ui_btnAdd.setContentAreaFilled(false);
        ui_btnAdd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnAddActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(230, 229, 234));
        jLabel7.setFont(new java.awt.Font("sansserif", 1, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("_______________________________________");
        jLabel7.setToolTipText("");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel7.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        ui_lblPrijs.setFont(new java.awt.Font("sansserif", 0, 28)); // NOI18N
        ui_lblPrijs.setForeground(new java.awt.Color(255, 255, 255));
        ui_lblPrijs.setText("€120,46");
        ui_lblPrijs.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setFont(new java.awt.Font("sansserif", 0, 28)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total:");

        ui_lblStartingTime.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        ui_lblStartingTime.setForeground(new java.awt.Color(255, 255, 255));
        ui_lblStartingTime.setText("21.30");

        jLabel8.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("at");

        ui_btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/x.png"))); // NOI18N
        ui_btnCancel.setContentAreaFilled(false);
        ui_btnCancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnCancel.setMaximumSize(new java.awt.Dimension(47, 47));
        ui_btnCancel.setMinimumSize(new java.awt.Dimension(47, 47));
        ui_btnCancel.setPreferredSize(new java.awt.Dimension(47, 47));
        ui_btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnCancelActionPerformed(evt);
            }
        });

        ui_btnProceed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/v.png"))); // NOI18N
        ui_btnProceed.setContentAreaFilled(false);
        ui_btnProceed.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnProceed.setMaximumSize(new java.awt.Dimension(47, 47));
        ui_btnProceed.setMinimumSize(new java.awt.Dimension(47, 47));
        ui_btnProceed.setPreferredSize(new java.awt.Dimension(47, 47));
        ui_btnProceed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnProceedActionPerformed(evt);
            }
        });

        ui_txtRemainingTickets.setFont(new java.awt.Font("sansserif", 0, 20)); // NOI18N
        ui_txtRemainingTickets.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ui_txtRemainingTickets.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ui_txtRemainingTickets.setFocusable(false);
        ui_txtRemainingTickets.setMaximumSize(new java.awt.Dimension(55, 47));
        ui_txtRemainingTickets.setMinimumSize(new java.awt.Dimension(55, 47));
        ui_txtRemainingTickets.setPreferredSize(new java.awt.Dimension(55, 47));

        jLabel9.setFont(new java.awt.Font("sansserif", 0, 22)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("out of");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(ui_btnSubtract, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ui_txtAantalTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ui_btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ui_lblPrijs)
                                .addGap(55, 55, 55))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jLabel5))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(ui_lblFilmNaam)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ui_btnProceed, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(1, 1, 1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ui_lblDatum))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ui_lblZaal)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ui_lblStartingTime))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel6)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ui_btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, 0))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(245, 245, 245)
                    .addComponent(ui_txtRemainingTickets, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 4, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ui_lblDatum)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ui_lblZaal)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8)
                            .addComponent(ui_lblStartingTime))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ui_btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 5, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ui_lblPrijs)
                            .addComponent(jLabel4))
                        .addComponent(ui_txtAantalTickets, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ui_btnSubtract, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(ui_btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(10, 10, 10)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ui_lblFilmNaam, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 30, Short.MAX_VALUE))
                    .addComponent(ui_btnProceed, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(147, 147, 147)
                    .addComponent(ui_txtRemainingTickets, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.MODAL_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(9, 9, 9)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(14, Short.MAX_VALUE)))
        );

        jPanel2.getAccessibleContext().setAccessibleParent(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Events">

    /* Code achter de plus knop voor ticketaantal */
    private void ui_btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnAddActionPerformed
        if (_aantalTickets < IntConstants.NINE.getValue()) {
            _aantalTickets++;
            ui_txtAantalTickets.setText(String.valueOf(_aantalTickets));
            ui_lblPrijs.setText(calculatePrijs(_aantalTickets));
        } else {
            JOptionPane.showMessageDialog(null, StringConstants.MAX_TICKET_AMOUNTMSG.getValue(), StringConstants.BUY_ERRORMSG_TITLE.getValue(), JOptionPane.INFORMATION_MESSAGE, _icon);
        }
    }//GEN-LAST:event_ui_btnAddActionPerformed

    /* Code achter de min knop voor ticketaantal */
    private void ui_btnSubtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnSubtractActionPerformed
        if (_aantalTickets > IntConstants.ONE.getValue()) {
            _aantalTickets--;
            ui_txtAantalTickets.setText(String.valueOf(_aantalTickets));
            ui_lblPrijs.setText(calculatePrijs(_aantalTickets));
        }
    }//GEN-LAST:event_ui_btnSubtractActionPerformed

    private void ui_btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnCancelActionPerformed
        /* Exit current TicketScreen instantie */
        this.dispose();
        
        _jframeMainScreen.setVisible(true);
        _jframeShowInfoScreen.setEnabled(true);
        _jframeShowInfoScreen.setVisible(true);
    }//GEN-LAST:event_ui_btnCancelActionPerformed

    private void ui_btnProceedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnProceedActionPerformed
        if (Integer.parseInt(ui_txtRemainingTickets.getText()) > Integer.parseInt(ui_txtAantalTickets.getText())) {
            
        }
    }//GEN-LAST:event_ui_btnProceedActionPerformed

    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code 2">

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TicketScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton ui_btnAdd;
    private javax.swing.JButton ui_btnCancel;
    private javax.swing.JButton ui_btnProceed;
    private javax.swing.JButton ui_btnSubtract;
    private javax.swing.JLabel ui_lblDatum;
    private javax.swing.JLabel ui_lblFilmNaam;
    private javax.swing.JLabel ui_lblPrijs;
    private javax.swing.JLabel ui_lblStartingTime;
    private javax.swing.JLabel ui_lblZaal;
    private javax.swing.JTextField ui_txtAantalTickets;
    private javax.swing.JTextField ui_txtRemainingTickets;
    // End of variables declaration//GEN-END:variables
    
    // </editor-fold>
    
}