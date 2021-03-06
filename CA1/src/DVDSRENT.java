/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author farley_reis
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DVDSRENT {


	private int idDVD        = 0;
	private String mName        = null;
	private String mGenero         = null;
	private String mDescription	     = null;
	private String mImage        = null;

	private boolean reservado_locado = false;
    

	public void setReservadoLocado(boolean reservado_locado) {
		this.reservado_locado = reservado_locado;
	}

	public boolean getReservadoLocado() {
		return this.reservado_locado;
	}

	
	public void setidDVD(int idDVD) {
		this.idDVD = idDVD;
	}

	public void setmName(String nName) {
		this.mName = nName;
	}

	public void setmDescription(String mDescription) {
		this.mDescription = mDescription;
	}



	public void setmImage(String mImage) {
		this.mImage = mImage;
	}
        
	public void setmGenero(String mGenero) {
		this.mGenero = mGenero;
	}


	
	/**
	 * 
	 * @return
	 */
	public int getidDVD() {
		return idDVD;
	}
	
	public String getmName() {
		return mName;
	}

	public String getmGenero() {
		return mGenero;
	}

	public String getmDescription() {
		return mDescription;
	}

	public String getmImage() {
		return mImage;
	}


	
	public boolean excluir() {
				
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {			
			String sqlDelete = "DELETE FROM Movies WHERE id = ?";

			DBASE bd = new DBASE();
            conn = bd.obtemConexao();
			
			stm = conn.prepareStatement(sqlDelete);
			stm.setInt(1, getidDVD());
			stm.execute();
			
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return false;
		} 
		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	public boolean editar() {
						
		Connection conn = null;
		PreparedStatement stm = null;
		
		try {
                    
		
			String sqlUpdate = "UPDATE Movies SET "
	    			+ "idMovies = ?, movieName = ?, categ = ?, descr = ?, imgM = ?, "
	    			+ "WHERE id = ?";
			
			DBASE bd = new DBASE();
            conn = bd.obtemConexao();
			
			stm = conn.prepareStatement(sqlUpdate);
                        stm.setInt(  13, getidDVD());	
                        stm.setString(1, getmName());
			stm.setString(2, getmGenero());
			stm.setString(3, getmDescription());
			stm.setString(4, getmImage());

					
			stm.execute();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				System.out.print(e1.getStackTrace());
			}
			return false;			
		} 
		finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
	}
	
	
	
	public boolean inserir() {

        PreparedStatement stm = null;
        Connection conn = null;
        
        try { 
         

        	String sqlInsert = "INSERT INTO Movies "
        			+ "(idMovies, movieName, categ, descr, imgM, "

        			+ "VALUES (?, ?, ?, ?, ?)";

            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
           
    		stm = conn.prepareStatement(sqlInsert);
    		

                
                        stm.setInt(  13, getidDVD());	
                        stm.setString(1, getmName());
			stm.setString(2, getmGenero());
			stm.setString(3, getmDescription());
			stm.setString(4, getmImage());



    		stm.setBoolean(13, getReservadoLocado());
    		stm.execute();
            
    		return true;
            
            
        } catch (SQLException e) {
    
            System.out.print(e.getMessage());
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }
            return false;
        }
        finally{
            if (stm != null) {
                try {
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }
	}
	
	
	public static ArrayList<DVDSRENT> buscar(String busca) {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<DVDSRENT> dvds = new ArrayList<DVDSRENT>();
    
        try {
            
        	String sql = "SELECT * FROM Movies WHERE ano LIKE ? ORDER BY id DESC";
            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%"+busca+"%");
            
            rs = stm.executeQuery();
       
            while (rs.next()) {    
            	DVDSRENT filme = new DVDSRENT();
            	filme.setidDVD(rs.getInt("idMovies"));
        		filme.setmName(rs.getString("movieName"));
        		filme.setmGenero(rs.getString("categ"));
        		filme.setmDescription(rs.getString("descr"));
        		filme.setmImage(rs.getString("imgM"));
      
        		            	
            	dvds.add(filme);
            }            

            rs.close();            
            return dvds;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return dvds;
        }
        finally{
            if (stm != null) {
                try {
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }
	}
	
	
	public static ArrayList<DVDSRENT> getArrayObjects() {
		
		PreparedStatement stm = null;
        Connection conn = null;
        ResultSet rs = null;
        
        ArrayList<DVDSRENT> veiculos = new ArrayList<DVDSRENT>();
    
        try {
            
        	String sql = "SELECT * FROM Movies ORDER BY id DESC";
            DBASE bd = new DBASE();
            conn = bd.obtemConexao();
            
            stm = conn.prepareStatement(sql);            
            rs = stm.executeQuery();
            
            while (rs.next()) {    
            	DVDSRENT veiculo = new DVDSRENT();
            	veiculo.setidDVD(rs.getInt("idMovies"));
        		veiculo.setmName(rs.getString("movieName"));
        		veiculo.setmGenero(rs.getString("categ"));
        		veiculo.setmDescription(rs.getString("descr"));
        		veiculo.setmImage(rs.getString("imgM"));

        		veiculo.setReservadoLocado(false);
        		
            	veiculos.add(veiculo);
            }            

            rs.close();            
            return veiculos;
            
            
        } catch (SQLException e) {
            
            e.printStackTrace();
            try {
                conn.rollback();
                
            } catch (SQLException e1) {
                System.out.print(e1.getStackTrace());
            }	            
            return veiculos;
        }
        finally{
            if (stm != null) {
                try {
                    stm.close();
                }
                catch (SQLException e1) {
                    System.out.print(e1.getStackTrace());
                }
            }
        }		
	}

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}