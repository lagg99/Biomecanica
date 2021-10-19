package bmc.care.dao;

import bmc.care.dto.Persona;
import bmc.care.exception.DaoException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class PersonaDaoImpl implements PersonasDao{

    JdbcTemplate jdbcTemplate;
    public PersonaDaoImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static final String INSERT="insert into personas (nmid, cddocumento, dsnombres, dsapellidos, fenacimiento,cdtipo,cdgenero,feregistro,febaja,cdusuario,dsdireccion,dsphoto,cdtelfono_fijo,cdtelefono_movil,dsemail) value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    @Override
    public Persona save(Persona p) throws DaoException {
        try{
        jdbcTemplate.update(INSERT,p.getNmid(), p.getCddocumento(),p.getDsnombres(),p.getDsapellidos(),
                p.getFenacimiento(),p.getCdtipo(),p.getCdgenero(),p.getFeregistro(),p.getFebaja(),p.getCdusuario(),
                p.getDsdireccion(),p.getDsphoto(),p.getCdtelfono_fijo(),p.getCdtelefono_movil(),p.getDsemail());
        } catch (Exception e) {
            throw  new DaoException(e);
        }
        return p;
    }
}
