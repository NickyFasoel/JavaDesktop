package PL;

// <editor-fold defaultstate="collapsed" desc="Imports">

import BLL.FetchFavicon;
import BLL.FetchImages;
import CONSTANTS.IntConstants;
import CONSTANTS.StringConstants;
import CONSTANTS.FloatConstants;
import Dal.Film;
import Dal.Helpers.FetchFilmData;
import Interfaces.IGetData;
import Interfaces.ISetFavicon;
import Interfaces.ISetFoto;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

// </editor-fold>

public class MainScreen extends javax.swing.JFrame {

    // <editor-fold defaultstate="collapsed" desc="Private Member Variables">

    // TODO: JFRAME startscreen nodig om na de verkoop van ticketten mss?
    private final JFrame _startScreen;
    private ISetFoto _iSF;
    private ISetFavicon _iF;
    private IGetData _iGD;
    private ArrayList<Film> _allFilms;
    private DefaultListModel _dlm;
    private ImageIcon _icon;
            
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Private Methods">
    
    /**
     *  Event adden tot list en de data tonen van de film
     */
    private void addListenerToList(){
        ui_lstFilms.addListSelectionListener((ListSelectionEvent e) -> {
            if (e.getValueIsAdjusting())
            {   
                if (ui_lstFilms.getSelectedIndex() > IntConstants.MINUS_ONE.getValue()) {
                    Film film = (Film) ui_lstFilms.getSelectedValue();
                    
                    ui_lblFoto.setIcon(_iSF.setFoto(film.getFoto()));
                    ui_txtDescription.setText(film.getDescription());
                }
            }
        });
    }

    /**
     *  Event adden tot combobox en filmlijst vullen afhankelijk van keuzen
     */
    private void addListenerToDDL() {
        ui_ddlGenres.addItemListener((ItemEvent e) -> {
            String selectedGenre = ui_ddlGenres.getSelectedItem().toString();
        _dlm.clear();
        for (Film film : _allFilms) {
            if ((StringConstants.ALL.getValue()).equals(selectedGenre)) {
                _dlm.addElement(film);
            }
            if (film.getGenre().equals(selectedGenre)) {
                _dlm.addElement(film);
            }
        }
        ui_lstFilms.setModel(_dlm); 
        });
    }
    
    /**
     *  om de constructor een beetje kleiner te houden
     */
    private void prepareMainScreen() {
        initializeObjects();
        _icon = _iF.setFavicon();
        this.setIconImage(_icon.getImage());
        ui_lblFoto.setToolTipText(null);
        ui_lblFoto.setIcon(_iSF.setFoto(StringConstants.STARTFOTO_PATH.getValue()));
        /**
         *  Algemene catch om programma niet te laten crashen indien probleem hoogst waarschijnlijk DB niet online
         */
        try {
            fillListGenres();
            fillListFilms();
        } catch (Exception e){
            Object[] options = { StringConstants.JOPTION_RETRY.getValue(), StringConstants.JOPTION_EXIT.getValue() };
            int response = JOptionPane.showOptionDialog(null, StringConstants.DB_ERRORMSG.getValue(), StringConstants.DB_ERRORMSG_TITLE.getValue(),
                           JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, _icon, options, options[IntConstants.ZERO.getValue()]);
            if (response == JOptionPane.YES_OPTION) {
                /* opnieuw proberen */
                prepareMainScreen();
            } else {
                System.exit(IntConstants.ZERO.getValue());
            }
        }
        addListenerToList();
        addListenerToDDL();
        try {
            setTimeFont();
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
        /* De klok starten */
        startClock();
    }

    /**
     *  Om de lengte van prepairescreen een beetje in te korten
     */
    private void initializeObjects() {
        _iGD = new FetchFilmData();
        _iF = new FetchFavicon();
        _iSF = new FetchImages();
        _dlm = new DefaultListModel();
    }
    
    /**
     *  Haalt alle genres uit de databank tabel film
     */
    private void fillListGenres() {
        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();
        List<String> allGenres = _iGD.getAllGenres();
        dcbm.addElement(StringConstants.ALL.getValue());
        for (String item : allGenres) {
            dcbm.addElement(item);
        }
        ui_ddlGenres.setModel(dcbm);
    }
    
    /**
     *  Vult de lijst met de mogelijke films
     */
    private void fillListFilms() {
        _allFilms = _iGD.getAllFilms();
        for (Film allFilm : _allFilms) {
            _dlm.addElement(allFilm);
        }
        ui_lstFilms.setModel(_dlm);
    }
    
    /**
     *  start de klok rechtsboven en refreshed elke 60seconden
     */
    private void startClock() {
        ui_lblTime.setText(new SimpleDateFormat(StringConstants.TIME_FORMAT_HHMM.getValue()).format(new Date()));
        Timer timeClock = new Timer(IntConstants.SIXTY_THOUSAND.getValue(), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ui_lblTime.setText(new SimpleDateFormat(StringConstants.TIME_FORMAT_HHMM.getValue()).format(new Date()));
            }
        });
        timeClock.start();
    }
    
    /**
     *  Haalt de specifieke timer font en indien niet lukt zet een algemene font
     */
    private void setTimeFont() throws FontFormatException, IOException {
        try {
            InputStream is = MainScreen.class.getResourceAsStream(StringConstants.FONT_TIMER_PATH.getValue());
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            Font sizedFont = font.deriveFont(FloatConstants.TWENTYSEVENF.getValue());
            ui_lblTime.setFont(sizedFont.deriveFont(sizedFont.getStyle() | Font.BOLD));
        } catch (FontFormatException | IOException ex) {
            ui_lblTime.setFont(new Font(StringConstants.FONT_SANSSERIF.getValue(), Font.BOLD, IntConstants.TWENTY_TWO.getValue()));
            ui_lblTime.setForeground(Color.WHITE);
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    
    /**
     * JFrame om deze te kunnen hiden, tonen en blokkeren
     * 
     * @param startScreen
     * @throws FontFormatException
     * @throws IOException 
     */
    public MainScreen(JFrame startScreen) throws FontFormatException, IOException {
        initComponents();
        this._startScreen = startScreen;
        prepareMainScreen();
    }

    // </editor-fold>
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ui_scrollPaneDescr = new javax.swing.JScrollPane();
        ui_txtDescription = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        ui_scrollPane = new javax.swing.JScrollPane();
        ui_lstFilms = new javax.swing.JList();
        ui_ddlGenres = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        ui_btnShowInfo = new javax.swing.JButton();
        ui_lblFoto = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        ui_lblTime = new javax.swing.JLabel();

        jScrollPane4.setBackground(new java.awt.Color(102, 255, 255));
        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("sansserif", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane4.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1024, 768));
        setResizable(false);
        setSize(new java.awt.Dimension(1024, 768));

        jLayeredPane1.setMaximumSize(new java.awt.Dimension(1024, 768));
        jLayeredPane1.setMinimumSize(new java.awt.Dimension(1024, 768));
        jLayeredPane1.setPreferredSize(new java.awt.Dimension(1036, 780));

        jPanel1.setBackground(new java.awt.Color(17, 56, 87));
        jPanel1.setMaximumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setMinimumSize(new java.awt.Dimension(1024, 768));
        jPanel1.setPreferredSize(new java.awt.Dimension(1024, 768));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/CinemaBackground2.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(0, 0, 0))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(1024, 768));
        jPanel2.setMinimumSize(new java.awt.Dimension(1024, 768));
        jPanel2.setOpaque(false);
        jPanel2.setPreferredSize(new java.awt.Dimension(1024, 768));

        ui_scrollPaneDescr.setBackground(new java.awt.Color(102, 255, 255));
        ui_scrollPaneDescr.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.BELOW_TOP, new java.awt.Font("sansserif", 1, 18), new java.awt.Color(255, 255, 255))); // NOI18N

        ui_txtDescription.setEditable(false);
        ui_txtDescription.setBackground(new java.awt.Color(255, 255, 255));
        ui_txtDescription.setColumns(20);
        ui_txtDescription.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        ui_txtDescription.setLineWrap(true);
        ui_txtDescription.setRows(5);
        ui_txtDescription.setWrapStyleWord(true);
        ui_txtDescription.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        ui_txtDescription.setMaximumSize(new java.awt.Dimension(747, 28));
        ui_scrollPaneDescr.setViewportView(ui_txtDescription);

        jPanel3.setBackground(new java.awt.Color(102, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 18))); // NOI18N
        jPanel3.setOpaque(false);

        ui_lstFilms.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        ui_lstFilms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_lstFilms.setVisibleRowCount(10);
        ui_scrollPane.setViewportView(ui_lstFilms);

        ui_ddlGenres.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logoKlein.png"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ui_scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(ui_ddlGenres, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ui_ddlGenres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ui_scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.setBackground(new java.awt.Color(102, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 18))); // NOI18N
        jPanel4.setOpaque(false);

        ui_btnShowInfo.setText("Show Information");
        ui_btnShowInfo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ui_btnShowInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ui_btnShowInfoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(ui_btnShowInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(ui_btnShowInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        ui_lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ui_lblFoto.setToolTipText("");
        ui_lblFoto.setFocusable(false);

        jPanel5.setBackground(new java.awt.Color(102, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 12), new java.awt.Color(51, 255, 255))); // NOI18N
        jPanel5.setAlignmentX(0.0F);
        jPanel5.setAlignmentY(0.0F);
        jPanel5.setOpaque(false);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/clock.png"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel3)
                .addGap(0, 3, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(444, Short.MAX_VALUE)
                        .addComponent(ui_scrollPaneDescr, javax.swing.GroupLayout.PREFERRED_SIZE, 568, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(ui_lblFoto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(12, 12, 12))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ui_lblFoto)
                        .addGap(48, 48, 48)))
                .addComponent(ui_scrollPaneDescr, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setMaximumSize(new java.awt.Dimension(89, 24));
        jPanel6.setMinimumSize(new java.awt.Dimension(89, 24));
        jPanel6.setOpaque(false);
        jPanel6.setPreferredSize(new java.awt.Dimension(89, 24));

        ui_lblTime.setFont(new java.awt.Font("DS-Digital", 1, 27)); // NOI18N
        ui_lblTime.setForeground(new java.awt.Color(255, 255, 255));
        ui_lblTime.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ui_lblTime.setText("23:45");
        ui_lblTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ui_lblTime, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(ui_lblTime))
        );

        jLayeredPane1.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jPanel2, javax.swing.JLayeredPane.PALETTE_LAYER);
        jLayeredPane1.setLayer(jPanel6, javax.swing.JLayeredPane.DRAG_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(912, 912, 912)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
            .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jLayeredPane1Layout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, 0)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    // <editor-fold defaultstate="collapsed" desc="Events">
    
    private void ui_btnShowInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ui_btnShowInfoActionPerformed
        if (ui_lstFilms.getSelectedValue() != null) {
            Film selectedFilm = (Film) ui_lstFilms.getSelectedValue();
            ShowInfoScreen sis = new ShowInfoScreen(selectedFilm, this);
            
            /* Blocked het huidige JFrame tot het nieuwe JFrame gesloten wordt */
            this.setEnabled(false);
            setupShowInfoScreen(selectedFilm, sis);
        } else {
            JOptionPane.showMessageDialog(null, StringConstants.SHOW_INFO_ERRORMSG.getValue(), StringConstants.ATTENTION.getValue(), JOptionPane.INFORMATION_MESSAGE, _icon);
        }
    }//GEN-LAST:event_ui_btnShowInfoActionPerformed

    /**
     * Kan ik de positie bepalen van de nieuwe frame
     * @param selectedFilm
     * @param sis
     * @throws HeadlessException 
     */
    private void setupShowInfoScreen(Film selectedFilm, ShowInfoScreen sis) throws HeadlessException {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        sis.setLocation(dim.width / IntConstants.TWO.getValue() - sis.getSize().width / IntConstants.TWO.getValue() - IntConstants.ONE.getValue(), dim.height / IntConstants.TWO.getValue() - sis.getSize().height / IntConstants.TWO.getValue() - selectedFilm.getImgCorr()); // 4 pix verschil laptop thuis
        sis.setVisible(true);
    }

    // </editor-fold>
    
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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JButton ui_btnShowInfo;
    private javax.swing.JComboBox ui_ddlGenres;
    private javax.swing.JLabel ui_lblFoto;
    private javax.swing.JLabel ui_lblTime;
    private javax.swing.JList ui_lstFilms;
    private javax.swing.JScrollPane ui_scrollPane;
    private javax.swing.JScrollPane ui_scrollPaneDescr;
    private javax.swing.JTextArea ui_txtDescription;
    // End of variables declaration//GEN-END:variables

    //</editor-fold>
    
}
