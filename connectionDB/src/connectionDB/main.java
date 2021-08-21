package connectionDB;

public class main {

	public static void main(String[] args) {
		 JDBCMySQLConnection conn = JDBCMySQLConnection.getConnection();
	        
	        try {
	            //Statement statement = conn.createStatement();
	            Usuarios nuevoUsuario = new Usuarios();
	            nuevoUsuario.setNombre("Alejandra");
	            nuevoUsuario.setApellido("Rodriguez");
	            nuevoUsuario.setEdad(30);
	            PreparedStatement ps = conn.prepareStatement(prepareInsertUsuario(nuevoUsuario ), Statement.RETURN_GENERATED_KEYS);
	            ps.executeUpdate();
	            ResultSet rs = ps.getGeneratedKeys();
	            if(rs.next()){
	                nuevoUsuario.setNumeroIdentificacion(rs.getInt(1));
	            }
	            System.out.println(nuevoUsuario.toString());
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	    }
	    
	    public static String prepareInsertUsuario(Usuarios usuario) {
	        StringBuilder insertQuery = new StringBuilder();
	        insertQuery.append("INSERT INTO usuarios (nombre, apellido, edad) VALUES (");

	}

}
