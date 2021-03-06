package com.proyecto2.UI;

import com.proyecto2.UI.CreandoTablero.CrearTablero;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Luis
 */
public class Menuu extends javax.swing.JFrame {

    private final String NOMBRE_MENU = "MONOPOLY";
    public static final ImageIcon FONDO = new ImageIcon("imagenes/monopoly.jpg");
    private CrearTablero crearTablero;
    private AcercaDe informacionJuego;

    private JuegoPrincipal jugando;

    /**
     * Creates new form Menuu
     */
    public Menuu() {
        initComponents();
        setTitle(NOMBRE_MENU);
        agregarIcono();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        jugando = new JuegoPrincipal();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelMenu = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        crearJuego = new javax.swing.JButton();
        editarJuego = new javax.swing.JButton();
        jugar = new javax.swing.JButton();
        ranking = new javax.swing.JButton();
        infoJuego = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("MONOPOLY");

        crearJuego.setText("Crear Juego");
        crearJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearJuegoActionPerformed(evt);
            }
        });

        editarJuego.setText("Editar Juego");
        editarJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarJuegoActionPerformed(evt);
            }
        });

        jugar.setText("Jugar");
        jugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jugarActionPerformed(evt);
            }
        });

        ranking.setText("Ranking");
        ranking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rankingActionPerformed(evt);
            }
        });

        infoJuego.setText("Acerda de...");
        infoJuego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                infoJuegoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(editarJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(jugar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(ranking, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(infoJuego, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(crearJuego)))
                .addGap(59, 59, 59))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(editarJuego)
                        .addGap(6, 6, 6)
                        .addComponent(jugar)
                        .addGap(18, 18, 18)
                        .addComponent(ranking)
                        .addGap(12, 12, 12)
                        .addComponent(infoJuego))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(crearJuego)))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearJuegoActionPerformed

        crearTablero = new CrearTablero();
        crearTablero.setVisible(true);
    }//GEN-LAST:event_crearJuegoActionPerformed

    private void editarJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarJuegoActionPerformed

    }//GEN-LAST:event_editarJuegoActionPerformed

    private void jugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jugarActionPerformed

        jugando.setVisible(true);
    }//GEN-LAST:event_jugarActionPerformed

    private void rankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rankingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rankingActionPerformed

    private void infoJuegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_infoJuegoActionPerformed
        informacionJuego = new AcercaDe();
        informacionJuego.setVisible(true);
    }//GEN-LAST:event_infoJuegoActionPerformed

//agragamos el fondo al menu
    public void agregarIcono() {

        JLabel fondo = new JLabel();
        fondo.setSize(32767, 32767);
        fondo.setLocation(0, 0);
        fondo.setIcon(FONDO);
        this.add(fondo);
        fondo.setVisible(true);

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton crearJuego;
    private javax.swing.JButton editarJuego;
    private javax.swing.JButton infoJuego;
    private javax.swing.JButton jugar;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JButton ranking;
    // End of variables declaration//GEN-END:variables
}
