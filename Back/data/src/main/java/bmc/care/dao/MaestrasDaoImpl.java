package bmc.care.dao;

import bmc.care.dto.maestras.Maestras;
import bmc.care.exception.DaoException;
import bmc.care.util.UtilDate;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class MaestrasDaoImpl implements MaestrasDao{

    private static final class MaestraMapper implements RowMapper<Maestras>{

        @Override
        public Maestras mapRow(ResultSet rs, int rowNum) throws SQLException {

            Maestras d=new Maestras();
            d.setNmmaestro(rs.getInt("nmmaestro"));
            d.setCdmaestro(rs.getString("cdmaestro"));
            d.setDsmaestro(rs.getString("dsmaestro"));
            return d;
        }
    }
    JdbcTemplate jdbcTemplate;
    public MaestrasDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    private static final String INSERT="INSERT INTO maestras (cdmaestro,dsmaestro,feregistro,febaja) VALUE(?,?,?,?)";
    private static final String UPDATE="UPDATE maestras SET cdmaestro=?,dsmaestro=? WHERE nmmaestro=?";
    private static final String DELETE="DELETE FROM maestras WHERE nmmaestro=?";
    private static final String CONSULTBYID="SELECT * FROM maestras WHERE nmmaestro=?";
    private static final String GETALL="SELECT m.nmmaestro, m.cdmaestro, m.dsmaestro FROM maestras m";
    private static final String COUNT="SELECT COUNT(1) FROM maestras m WHERE m.nmmaestro=?";

    @Override
    public Maestras save(Maestras m) throws DaoException {
        try {
            jdbcTemplate.update(INSERT,m.getCdmaestro(),
                                        m.getDsmaestro(),
                                        UtilDate.toDate(new Date(),"yyyy-MM-dd"),
                                        UtilDate.toDate("3000-12-31","yyyy-MM-dd"));
        } catch (Exception e) {
            throw  new DaoException(e);
        }
        return m;
    }

    @Override
    public Maestras update(Maestras maestras) throws DaoException {
        try {
            jdbcTemplate.update(UPDATE, maestras.getCdmaestro(), maestras.getDsmaestro(), maestras.getNmmaestro());
        } catch (Exception e) {
            throw  new DaoException(e);
        }
        return maestras;
    }
    @Override
    public void delete(int id) throws DaoException{
        try {
            jdbcTemplate.update(DELETE,id);
        } catch (Exception e) {
            throw  new DaoException(e);
        }
    }
    @Override
    public Maestras GetById(int id) throws DaoException{
        try {
            RowMapper<Maestras> rowMapper= new BeanPropertyRowMapper<>(Maestras.class);

            Maestras maestras=jdbcTemplate.queryForObject(CONSULTBYID,rowMapper,id);
            return maestras;
        } catch (Exception e) {
            throw  new DaoException(e);
        }

    }
    @Override
    public List<Maestras> GetAll() throws DaoException{
        try {
            return jdbcTemplate.query(GETALL, new MaestraMapper());
        } catch (Exception e) {
            throw  new DaoException(e);
        }
    }

    @Override
    public int exist(Maestras maestras)  throws DaoException{
        try {
            return jdbcTemplate.queryForObject(COUNT,new Object[]{maestras.getNmmaestro()},Integer.class);
        } catch (Exception e) {
            throw  new DaoException(e);
        }
    }
}












