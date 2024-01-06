/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import javax.swing.JFrame;

/**
 *
 * @author santi
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btFrmRealizarVenta = new javax.swing.JButton();
        btFrmCasas = new javax.swing.JButton();
        btFrmVendedor = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("VENTA DE CASAS");

        btFrmRealizarVenta.setText("VENTAS");
        btFrmRealizarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFrmRealizarVentaActionPerformed(evt);
            }
        });

        btFrmCasas.setText("CASAS");
        btFrmCasas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFrmCasasActionPerformed(evt);
            }
        });

        btFrmVendedor.setText("VENDEDOR");
        btFrmVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btFrmVendedorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(183, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(181, 181, 181))
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btFrmRealizarVenta)
                    .addComponent(btFrmVendedor)
                    .addComponent(btFrmCasas))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(btFrmCasas)
                .addGap(18, 18, 18)
                .addComponent(btFrmRealizarVenta)
                .addGap(18, 18, 18)
                .addComponent(btFrmVendedor)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btFrmVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFrmVendedorActionPerformed
        new FrmRegistrarVendedor().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btFrmVendedorActionPerformed

    private void btFrmCasasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFrmCasasActionPerformed
        new FrmRegistrarCasa().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btFrmCasasActionPerformed

    private void btFrmRealizarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btFrmRealizarVentaActionPerformed
        new FrmRegistrarVenta().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btFrmRealizarVentaActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btFrmCasas;
    private javax.swing.JButton btFrmRealizarVenta;
    private javax.swing.JButton btFrmVendedor;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}