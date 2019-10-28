package P1;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connect {
	static String sql, url = "jdbc:sqlite:D:\\AMS2\\M6\\UF2\\p1\\sqlite\\java";
	public static void connect() {
		Connection conn = null;
		try {
			// db parameters
			// create a connection to the database
			conn = DriverManager.getConnection(url);

			System.out.println("Connection to SQLite has been established.");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println(ex.getMessage());
			}
		}
		
	}
	public static void CrearDB() {
		url = url + "\\FHonor"; 
		try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	public static void Faccion() {
		String Facciones = "CREATE TABLE IF NOT EXISTS Faccion (\n"
                + "    faccion_id integer PRIMARY KEY,\n"
                + "    nombre_faccion VARCHAR(15) NOT NULL,\n"
                + "    lore  VARCHAR(200)\n"
                + ");";
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(Facciones);
            System.out.println("Se ha creado la tabla de facciones");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
		
	}
	public static void Personaje() {

		String Personajes = "CREATE TABLE IF NOT EXISTS Personaje (\n"
                + "    personaje_id integer PRIMARY KEY,\n"
                + "    nombre_personaje VARCHAR(15) NOT NULL,\n"
                + "    ataque number(25),\n"
                + "    defensa number(25),\n"
                + "    faccion_id integer,\n"
                + "    FOREIGN KEY(faccion_id) REFERENCES Faccion(faccion_id)\n"
                + ");";
		
		try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(Personajes);
            System.out.println("Se ha creado la tabla de personajes");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
	}
	public static void insert (int personaje_id, String nombre_persoanje, int ataque, int defensa, int faccion_id) {
		String personaje1 = "INSERT INTO Personaje(personaje_id,nombre_personaje,ataque,defensa,faccion_id) VALUES(?,?,?,?,?)";
		try (Connection conn = DriverManager.getConnection(url))
	}
	public static void main(String[] args) {
		connect();
		CrearDB();
		Faccion();
		Personaje();
		
		
		
	}
}
