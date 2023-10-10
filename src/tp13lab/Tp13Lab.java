/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tp13lab;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.*;
import java.sql.Statement;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class Tp13Lab {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //Cargo Driver de conexión
            Class.forName("org.mariadb.jdbc.Driver");

            //Establecer conexión
            String URL = "jdbc:mariadb://localhost:3306/tp13lab";
            String usuario = "root";
            String password = "";
            Connection con = DriverManager.getConnection(URL, usuario, password);

            /* //Insert.
            String sql = "INSERT INTO `inscripcion`(`idInscripto`, `nota`, `idAlumno`, `idMateria`)"
                    + "VALUES (101,4,1,11),(102,6,1,12),(103,4,2,11),(104,9,2,13),(105,10,3,14),(106,8,3,12)";
            PreparedStatement ps = con.prepareStatement(sql);
            int filas = ps.executeUpdate();
            if (filas > 0) {

                JOptionPane.showMessageDialog(null, "Agregado");
            }*/
            // Dar de baja
            String sql = "DELETE FROM `inscripcion` WHERE inscripcion.idMateria=11 && inscripcion.idAlumno=1";
            PreparedStatement ps = con.prepareStatement(sql);
            int filas = ps.executeUpdate();
            if (filas > 0) {

                JOptionPane.showMessageDialog(null, "Eliminado");
            }
            //Obtener los datos de los alumnos activos.
          /*  String sql = "SELECT DISTINCT * FROM `alumno`a JOIN `inscripcion` i ON (a.idAlumno = i.idAlumno) WHERE i.nota>8;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id = rs.getInt("idAlumno");
                int dni = rs.getInt("dni");
                String apellido = rs.getString("apellido");
                String nombre = rs.getString("nombre");
                LocalDate fechN = rs.getDate("fechaDeNacimiento").toLocalDate();
                boolean estado = rs.getBoolean("estado");
                int insc = rs.getInt("idInscripto");
                int nt = rs.getInt("nota");
                int idmat = rs.getInt("idMateria");

                System.out.println("-----------------------------");
                System.out.println("Dni: " + dni);
                System.out.println("Nombre: " + nombre + " " + apellido);
                System.out.println("Fecha: " + fechN.toString());
                System.out.println("Nota: " + nt);
                System.out.println("Materia: " + idmat);

            }
            con.close();*/
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar Driver");

        } catch (SQLException ex) {
            int error = ex.getErrorCode();
            if (error == 1146) {
                JOptionPane.showMessageDialog(null, "Tabla inexistente");
            } else if (error == 1062) {

                JOptionPane.showMessageDialog(null, "Dni duplicado");
            } else if (error == 1049) {

                JOptionPane.showMessageDialog(null, "BD inexistente");
            } else {

                JOptionPane.showMessageDialog(null, "Error SQL");

            }
        }
    }

}
