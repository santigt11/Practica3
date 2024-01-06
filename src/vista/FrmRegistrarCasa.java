/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import controlador.Archivos.CasaArchivos;
import controlador.CasaControl;
import controlador.TDA.listas.Exception.EmptyException;
import enumeraciones.TipoCasa;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import modelo.Area;
import vista.listas.tablas.ModeloTablaCasa;
import vista.listas.util.Utilvista;

/**
 *
 * @author santi
 */
public class FrmRegistrarCasa extends javax.swing.JFrame {

    private CasaControl casaControl = new CasaControl();
    private ModeloTablaCasa mtp = new ModeloTablaCasa();
    private Integer tipoCasa;
    private CasaArchivos ca = new CasaArchivos();

    private void cargarVista() {
        int fila = tbCasa.getSelectedRow();
        if (fila < 0) {
            JOptionPane.showMessageDialog(null, "Escoja un registro de la tabla", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            try {
                casaControl.setCasa(mtp.getCasas().getInfo(fila));
                txtAnchoC.setText(String.valueOf(casaControl.getCasa().getArea().getAnchoConstruccion()));
                txtAnchoT.setText(String.valueOf(casaControl.getCasa().getArea().getAnchoTerreno()));
                txtLargoC.setText(String.valueOf(casaControl.getCasa().getArea().getLargoConstruccion()));
                txtLargoT.setText(String.valueOf(casaControl.getCasa().getArea().getLargoTerreno()));
                txtDireccion.setText(casaControl.getCasa().getDireccion());
                if (casaControl.getCasa().getTipoCasa().equals(TipoCasa.LADRILLO)) {
                    tipoCasa = 0;
                } else if (casaControl.getCasa().getTipoCasa().equals(TipoCasa.CONCRETO)) {
                    tipoCasa = 1;
                } else {
                    tipoCasa = 2;
                }
                cbxTipoCasa.setSelectedIndex(tipoCasa);
            } catch (Exception ex) {
                ex.toString();
            }
        }
    }

    public Boolean verificar() {
        return (!txtAnchoC.getText().trim().isEmpty()
                && !txtAnchoT.getText().trim().isEmpty()
                && !txtDireccion.getText().trim().isEmpty()
                && !txtLargoC.getText().trim().isEmpty()
                && !txtLargoT.getText().trim().isEmpty());
    }

    private void cargarTabla() {
        mtp.setCasas(ca.all());
        casaControl.setCasas(ca.all());
        tbCasa.setModel(mtp);
        tbCasa.updateUI();
    }

    private void ordenar() {
        String criterio = cbxCriterio.getSelectedItem().toString();
        Integer tipo = 0;
        Integer tipoOrden = 0;
        if (btn_tipo.isSelected()) {
            tipo = 1;
        }
        if (btn_tipoOrdenar.isSelected()) {
            tipoOrden = 1;
        }
        try {
            ca.setCasas(ca.ordenar(ca.all(), criterio, tipo, tipoOrden));
            mtp.setCasas(ca.getCasas());
            tbCasa.setModel(mtp);
            tbCasa.updateUI();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void guardar() throws EmptyException {
        if (verificar()) {
            casaControl.getCasa().setDireccion(txtDireccion.getText());
            casaControl.getCasa().setArea(new Area());
            casaControl.getCasa().getArea().setAnchoConstruccion(Double.parseDouble(txtAnchoC.getText()));
            casaControl.getCasa().getArea().setAnchoTerreno(Double.parseDouble(txtAnchoT.getText()));
            casaControl.getCasa().getArea().setLargoConstruccion(Double.parseDouble(txtLargoC.getText()));
            casaControl.getCasa().getArea().setLargoTerreno(Double.parseDouble(txtLargoT.getText()));
            casaControl.getCasa().setTipoCasa(cbxTipoCasa.getSelectedIndex());
            if (casaControl.guardar()) {
                ca.persist(casaControl.getCasa());
                JOptionPane.showMessageDialog(null, "Datos guardados");
                cargarTabla();
                limpiar();
                casaControl.setCasa(null);
            } else {
                JOptionPane.showMessageDialog(null, "Datos no guardados");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta llenar campos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiar() {
        try {
            Utilvista.cargarcomboTiposCasa(cbxTipoCasa);
        } catch (EmptyException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        tbCasa.clearSelection();
        txtAnchoC.setText("");
        txtAnchoT.setText("");
        txtDireccion.setText("");
        txtLargoC.setText("");
        txtLargoT.setText("");
        cargarTabla();
        casaControl.setCasa(null);
        casaControl.setCasas(ca.all());
        cbxTipoCasa.setSelectedIndex(0);
    }

    /**
     * Creates new form FrmRealizarVenta
     */
    public FrmRegistrarCasa() {
        initComponents();
        this.setLocationRelativeTo(null);
        limpiar();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDireccion = new javax.swing.JTextField();
        txtLargoT = new javax.swing.JTextField();
        txtAnchoT = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCasa = new javax.swing.JTable();
        cbxTipoCasa = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        txtLargoC = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtAnchoC = new javax.swing.JTextField();
        btModificar2 = new javax.swing.JButton();
        btAtras3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbxCriterio = new javax.swing.JComboBox<>();
        btOrdenar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btn_tipo = new javax.swing.JCheckBox();
        btn_tipoOrdenar = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("TIPO DE CASA:");

        jLabel5.setText("ANCHO DEL TERRENO (m):");

        jLabel6.setText("LARGO DEL TERRENO (m):");

        jLabel1.setText("REGISTRAR CASAS");

        jLabel2.setText("DIRECCION:");

        btGuardar.setText("GUARDAR");
        btGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGuardarActionPerformed(evt);
            }
        });

        tbCasa.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCasa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCasaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbCasa);

        cbxTipoCasa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel8.setText("LARGO DE CONTRUCCION (m):");

        jLabel9.setText("ANCHO DE CONTRUCCION (m):");

        btModificar2.setText("MODIFICAR");
        btModificar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btModificar2ActionPerformed(evt);
            }
        });

        btAtras3.setText("ATRAS");
        btAtras3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtras3ActionPerformed(evt);
            }
        });

        jButton1.setText("QUITAR SELECCION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbxCriterio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Direccion", "TipoCasa", "AreaConstruccion", "AreaTerreno" }));

        btOrdenar.setText("ORDENAR");
        btOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOrdenarActionPerformed(evt);
            }
        });

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Criterio");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        jLabel7.setVerifyInputWhenFocusTarget(false);

        btn_tipo.setText("Descendente");
        btn_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tipoActionPerformed(evt);
            }
        });

        btn_tipoOrdenar.setText("QuickSort");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(btGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btModificar2))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(301, 301, 301)
                                .addComponent(jLabel1))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(173, 173, 173)
                                        .addComponent(cbxTipoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel7)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jLabel6))))
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtDireccion, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE)
                                                    .addComponent(txtAnchoT)
                                                    .addComponent(txtLargoT)
                                                    .addComponent(txtLargoC)
                                                    .addComponent(txtAnchoC)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                                .addGap(29, 29, 29)
                                                .addComponent(btn_tipo)
                                                .addGap(18, 18, 18)
                                                .addComponent(btOrdenar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btn_tipoOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addGap(426, 426, 426)
                                .addComponent(btAtras3)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnchoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtLargoT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLargoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnchoC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbxTipoCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxCriterio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btOrdenar)
                    .addComponent(jLabel7)
                    .addComponent(btn_tipo)
                    .addComponent(btn_tipoOrdenar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btGuardar)
                    .addComponent(btModificar2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btAtras3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGuardarActionPerformed
        try {
            guardar();
        } catch (EmptyException ex) {
            System.out.println(ex.getMessage());
        }
    }//GEN-LAST:event_btGuardarActionPerformed

    private void btModificar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btModificar2ActionPerformed
        casaControl.getCasa().setDireccion(txtDireccion.getText());
        casaControl.getCasa().setArea(new Area());
        casaControl.getCasa().getArea().setAnchoConstruccion(Double.parseDouble(txtAnchoC.getText()));
        casaControl.getCasa().getArea().setAnchoTerreno(Double.parseDouble(txtAnchoT.getText()));
        casaControl.getCasa().getArea().setLargoConstruccion(Double.parseDouble(txtLargoC.getText()));
        casaControl.getCasa().getArea().setLargoTerreno(Double.parseDouble(txtLargoT.getText()));
        casaControl.getCasa().setTipoCasa(cbxTipoCasa.getSelectedIndex());
        ca.merge(casaControl.getCasa(), tbCasa.getSelectedRow());
        cargarTabla();
        limpiar();
    }//GEN-LAST:event_btModificar2ActionPerformed

    private void tbCasaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCasaMouseClicked
        cargarVista();
    }//GEN-LAST:event_tbCasaMouseClicked

    private void btAtras3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtras3ActionPerformed
        this.setVisible(false);
        new FrmPrincipal().setVisible(true);
    }//GEN-LAST:event_btAtras3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOrdenarActionPerformed
        ordenar();
    }//GEN-LAST:event_btOrdenarActionPerformed

    private void btn_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_tipoActionPerformed

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
            java.util.logging.Logger.getLogger(FrmRegistrarCasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarCasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarCasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmRegistrarCasa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmRegistrarCasa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtras3;
    private javax.swing.JButton btGuardar;
    private javax.swing.JButton btModificar2;
    private javax.swing.JButton btOrdenar;
    private javax.swing.JCheckBox btn_tipo;
    private javax.swing.JCheckBox btn_tipoOrdenar;
    private javax.swing.JComboBox<String> cbxCriterio;
    private javax.swing.JComboBox<String> cbxTipoCasa;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCasa;
    private javax.swing.JTextField txtAnchoC;
    private javax.swing.JTextField txtAnchoT;
    private javax.swing.JTextField txtDireccion;
    private javax.swing.JTextField txtLargoC;
    private javax.swing.JTextField txtLargoT;
    // End of variables declaration//GEN-END:variables
}
