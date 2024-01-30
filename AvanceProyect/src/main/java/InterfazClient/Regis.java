
package InterfazClient;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import com.mongodb.client.MongoCollection;
import org.bson.Document;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCursor;
import javax.swing.JOptionPane;
import org.bson.Document;
import javax.swing.table.DefaultTableModel;

public class Regis extends javax.swing.JFrame {
    
    public Regis() {
        initComponents();
        this.setLocationRelativeTo(null);

        actualizarTabla(); 
 
    }
   private void actualizarTabla() {
    try (MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017")) {
        MongoDatabase database = mongoClient.getDatabase("PaintBoll");
        MongoCollection<Document> collection = database.getCollection("ClienteRegistro");
        DefaultTableModel model = (DefaultTableModel) jTable2.getModel();
        model.setRowCount(0);
        FindIterable<Document> result = collection.find();
        MongoCursor<Document> cursor = result.iterator();
        while (cursor.hasNext()) {
            Document doc = cursor.next();
            String nombre = doc.getString("Nombres");
            String cedula = doc.getString("Cedula");
            String telefono = doc.getString("Telefono");
            String correo = doc.getString("Correo");
            String nacimiento = doc.getString("Nacimiento");
            String equipo = doc.getString("Equipo");
            String pago = doc.getString("Pago");
            model.addRow(new Object[]{nombre, cedula, telefono, correo, nacimiento, equipo, pago});
        }
        model.fireTableDataChanged();
        JOptionPane.showMessageDialog(this, "Datos Cargados", "Éxito", JOptionPane.INFORMATION_MESSAGE);
    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error al conectar a la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BuscarPorNombre = new javax.swing.JToggleButton();
        BuscarPorCedula = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BuscarPorNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPorNombreActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarPorNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 10, 130, 20));

        BuscarPorCedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarPorCedulaActionPerformed(evt);
            }
        });
        getContentPane().add(BuscarPorCedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 40, 130, 20));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombres", "Cedula", "Telefono", "Correo", "Nacimiento", "Equipo", "Pago"
            }
        ));
        jScrollPane1.setViewportView(jTable2);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 730, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BuscarPorCedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPorCedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarPorCedulaActionPerformed

    private void BuscarPorNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarPorNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BuscarPorNombreActionPerformed


    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Regis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BuscarPorCedula;
    private javax.swing.JToggleButton BuscarPorNombre;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
