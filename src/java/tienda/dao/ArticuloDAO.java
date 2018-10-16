package tienda.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import tienda.bean.Articulo;
import tienda.conexion.Conexion;

public class ArticuloDAO extends Conexion  {

    public ArrayList<Articulo> list() {
        //arreglo de objetos tipo articulo
        ArrayList<Articulo> lista = new ArrayList<Articulo>();
        Articulo ar;
        //instruccion sql para extraer todos los articulos de la BD
        String sql = "select*from articulo";

        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            //ejecutar objeto PreparedStatement
            rs = stm.executeQuery();
            while (rs.next()) {
                //crear objeto ar
                ar = new Articulo();
                //encastmular datos en obejto ar
                ar.setIdarticulo(rs.getInt(1));
                ar.setIdcategoria(rs.getInt(2));
                ar.setNombre(rs.getString(3));
                ar.setDescripcion(rs.getString(4));
                ar.setPrecio(rs.getDouble(5));
                ar.setFoto(rs.getString(6));
                //asignar objeto ar arreglo de objeto lista
                lista.add(ar);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
        return lista;

    }

    public Articulo get(Articulo t) {
        Articulo ar = null;
        //instruccion sql para extraer todos los articulos de la BD
        String sql = "select*from articulo where idarticulo=?";
        //objeto preparastamet para ejecutar instrucion sql a traves de  su metodo
        //executequery y la conexion cn
        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            stm.setInt(1, t.getIdarticulo());
            //ejecutar  objeto preparedstament 
            rs = stm.executeQuery();
            //leer resulset
            if (rs.next()) {
                //crear objeto ar
                ar = new Articulo();
                //encapsular datos en obejto ar
                ar.setIdarticulo(rs.getInt(1));
                ar.setIdcategoria(rs.getInt(2));
                ar.setNombre(rs.getString(3));
                ar.setDescripcion(rs.getString(4));
                ar.setPrecio(rs.getDouble(5));
                ar.setFoto(rs.getString(6));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
        return ar;
    }

    public  void save(Articulo t) {
        String sql = "insert into articulo(nombre,idcategoria,descripcion,precio,foto)values(?,?,?,?,?)";
        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            stm.setString(1, t.getNombre());
            stm.setInt(2, t.getIdcategoria());
            stm.setString(3, t.getDescripcion());
            stm.setDouble(4, t.getPrecio());
            stm.setString(5, t.getFoto());
            //ejecutar sentencia sql
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }

    public void update(Articulo t) {
        String sql = "update articulo set nombre=?,idcategoria=?,descripcion=?,precio=? where idarticulo=?";

        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            stm.setString(1, t.getNombre());
            stm.setInt(2, t.getIdcategoria());
            stm.setString(3, t.getDescripcion());
            stm.setDouble(4, t.getPrecio());
            stm.setInt(5, t.getIdarticulo());
            //ejecutar sentencia sql
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }

    }

    public void delete(Articulo t) {
        String sql = "delete from  articulo where idarticulo=?";
        try {
            //abrir al conexion a  la base de datos tienda
            cn = abrirConexion();
            //creamos un objeto PreparedStatement con la conexion  a la base de datos
            stm = cn.prepareStatement(sql);
            stm.setInt(1, t.getIdarticulo());
            //ejecutar sentencia sql
            stm.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            cerrar(cn);
            cerrar(stm);
            cerrar(rs);
        }
    }
}
