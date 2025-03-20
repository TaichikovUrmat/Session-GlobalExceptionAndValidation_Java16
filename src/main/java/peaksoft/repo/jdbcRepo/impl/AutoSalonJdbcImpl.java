package peaksoft.repo.jdbcRepo.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;
import peaksoft.dto.response.GetAllAutoSalonResponse;
import peaksoft.repo.jdbcRepo.AutoSalonJdbc;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoSalonJdbcImpl implements AutoSalonJdbc {

    private final JdbcTemplate jdbcTemplate;

    private final JdbcClient jdbcClientl;

    @Override
    public List<GetAllAutoSalonResponse> getAllAutoSalon() {
         String sql = "select id as autoSalonId, name, address  from auto_salon";

        return jdbcClientl.
                sql(sql)
                .query(GetAllAutoSalonResponse.class)
                .list();
    }

    @Override
    public List<GetAllAutoSalonResponse> getAutoSalonById(Long id, int pageNumber, int pageSize) {

        String sql = "select  id as autoSalonId, name, address  from auto_salon where id = :autoSalonId LIMIT :pageSize offset :offset";

        return jdbcClientl
                .sql(sql)
                .param("autoSalonId", id)
                .param("pageSize", pageSize)
                .param("offset", (pageNumber - 1 ) * pageSize )
                .query(GetAllAutoSalonResponse.class)
                .list();
    }



//    @Override
//    public List<GetAllAutoSalonResponse> getAllAutoSalon() {
//        String sql = """
//                select  id, name, address from auto_salon;
//
//                """;
//
//        NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
//        return namedParameterJdbcTemplate.query(sql, (rs, rowNum) ->
//                GetAllAutoSalonResponse
//                        .builder()
//                        .autoSalonId(rs.getLong("id"))
//                        .name(rs.getString("name"))
//                        .address(rs.getString("address"))
//                        .build()) ;
//    }
//
//    @Override
//    public List<GetAllAutoSalonResponse> getAutoSalonById(Long id, int pageNumber, int pageSize) {
//     String sql  = """
//             select
//             a.id as autoId,
//             a.name,
//             a.address ,
//             c.id,
//             c.marke,
//             c.price,
//             c.date_of_made,
//             c.driver,
//             c.typ
//             from auto_salon a
//             join car c  on a.id = c.auto_salon_id
//             where a.id = :autoId
//             limit :pageSize offset :offsett ;
//             """;
//
//        MapSqlParameterSource params = new MapSqlParameterSource();
//        params.addValue("autoId", id);
//        params.addValue("pageSize", pageSize);
//        params.addValue("offsett", (pageNumber -1) * pageSize  );
//
//
//     NamedParameterJdbcTemplate namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate);
//
//     return  namedParameterJdbcTemplate.query(sql, params, (rs, rowNum) -> GetAllAutoSalonResponse
//                     .builder()
//                     .autoSalonId(rs.getLong("autoId"))
//                     .name(rs.getString("name"))
//                     .address(rs.getString("address"))
//                     .carId(rs.getLong("id"))
//                     .marka(rs.getString("marke"))
//                     .price(rs.getInt("price"))
//                     .dateOfMade(rs.getDate("date_of_made").toLocalDate())
//                     .driver(rs.getString("driver"))
//                     .typ(rs.getString("typ"))
//                     .build()
//             );
//    }







}
