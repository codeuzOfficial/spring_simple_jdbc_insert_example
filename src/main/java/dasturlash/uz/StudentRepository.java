package dasturlash.uz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    public void save(StudentDTO dto) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", dto.getName());
        params.put("surname", dto.getSurname());
        params.put("createdDate", dto.getCreatedDate());

        // student table bilan ishlash
        simpleJdbcInsert.withTableName("student");
        // table da id auto-generated primary key ekanligini ko'rsatish
        simpleJdbcInsert.usingGeneratedKeyColumns("id");
        // query-ni ishga tushurish
        simpleJdbcInsert.execute(params);
    }

    public List<StudentDTO> getStudentList() {
        String sql = "select * from Student";
        List<StudentDTO> studentList = jdbcTemplate.query(sql, new BeanPropertyRowMapper(StudentDTO.class));
        return studentList;
    }

}
