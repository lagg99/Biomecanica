package bmc.care.dao;

import bmc.care.dto.dataMaestra.DataMaestra;
import bmc.care.exception.DaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import bmc.care.util.UtilDate;
import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class DataMaestraDaoImpl implements DataMaestraDao {

    //Clase mapeadora
    private static final class dataMaestraMapper implements RowMapper<DataMaestra>{

        @Override
        public DataMaestra mapRow(ResultSet rs, int rowNum) throws SQLException {

            DataMaestra d=new DataMaestra();
            d.setNmdato(rs.getInt("nmdato"));
            d.setCddato(rs.getString("cddato"));
            d.setDsdato(rs.getString("dsdato"));
            d.setCddato1(rs.getString("cddato1"));
            d.setCddato2(rs.getString("cddato2"));
            d.setCddato3(rs.getString("cddato3"));

            return d;
        }
    }

    private static final String DELETEDATAMAESTRA= "DELETE FROM datamaestra WHERE(nmdato=?)";
    private static final String DELETEHIJOSMAESTRA="DELETE FROM datamaestra d WHERE EXISTS ( SELECT  m.nmmaestro FROM maestras m WHERE m.nmmaestro = d.nmmaestro AND m.nmmaestro=?)";
    private  static final String CONSULTDATAMAESTRA="SELECT d.nmdato, d.cddato, d.dsdato, d.cddato1, d.cddato2, d.cddato3 FROM datamaestra d WHERE d.nmmaestro=?";
    private static final String UPDATEDATAMAESTRA="UPDATE datamaestra SET cddato=?,dsdato=?,cddato1=?,cddato2=?,cddato3=? WHERE nmdato=?";
    private static final String INSERTDATAMAESTRA="INSERT INTO datamaestra(nmmaestro,cddato,dsdato,cddato1,cddato2,cddato3,feregitro) VALUE(?,?,?,?,?,?,?)";
    private static final String COUNT="SELECT COUNT(1) FROM datamaestra d WHERE d.nmdato=?";
    private static final String CONSULTA_PORTIPO = "SELECT B.nmdato,\n" +
                                                    "          B.cddato,\n" +
                                                    "          B.dsdato,\n" +
                                                    "          B.cddato1,\n" +
                                                    "          B.cddato2,\n" +
                                                    "          B.cddato3,\n" +
                                                    "          A.nmmaestro" +
                                                    "   FROM maestras A \n" +
                                                    "        INNER JOIN\n" +
                                                    "        datamaestra B  ON A.nmmaestro=B.nmmaestro\n" +
                                                    "   WHERE A.cdmaestro=?  ";
    JdbcTemplate jdbcTemplate;

    public DataMaestraDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void deleteByIdDataMaestra(int id) throws DaoException {
        jdbcTemplate.update(DELETEDATAMAESTRA,id);
    }

    @Override
    public List<DataMaestra> consultDataMaestraById(int id) throws DaoException{
        return jdbcTemplate.query(CONSULTDATAMAESTRA,new dataMaestraMapper(),id);

    }
    @Override
    public List<DataMaestra> consultDataMaestraByTipo(String codigo) throws DaoException{
        return jdbcTemplate.query(CONSULTA_PORTIPO,new dataMaestraMapper(),codigo);

    }
    @Override
    public DataMaestra saveDataMaestra(DataMaestra dataMaestra) throws DaoException  {
        try{
        jdbcTemplate.update(INSERTDATAMAESTRA,dataMaestra.getNmmaestro(), dataMaestra.getCddato(),
                            dataMaestra.getDsdato(),dataMaestra.getCddato1(),dataMaestra.getCddato2(),
                            dataMaestra.getCddato3(),UtilDate.toDate(new Date(),"yyyy-MM-dd"));
        }catch (Exception e) {
            throw new DaoException(e);
        }
        return dataMaestra;
    }

    @Override
    public DataMaestra update(DataMaestra dm) throws DaoException {
        try{
        jdbcTemplate.update(UPDATEDATAMAESTRA,dm.getCddato(), dm.getDsdato(),dm.getCddato1(),dm.getCddato2(),dm.getCddato3(), dm.getNmdato());
        }catch (Exception e) {
            throw new DaoException(e);
        }
        return dm;
    }

    @Override
    public int exist(DataMaestra dm) throws DaoException {
        try{
        return jdbcTemplate.queryForObject(COUNT,new Object[]{dm.getNmdato()},Integer.class);
        }catch (Exception e) {
            throw new DaoException(e);
        }
    }
}
