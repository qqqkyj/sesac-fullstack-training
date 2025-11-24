package com.example.board.repository;

import com.example.board.dto.PostDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor //final과 같은 필수 인자를 갖는 생성자
public class PostRepository{
    private final JdbcTemplate jdbcTemplate;

//    @RequiredArgsConstructor를 통해 자동생성
//    public PostRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }

    //데이터베이스의 각 행을 한 줄씩 가져와서 return
    private final RowMapper<PostDTO> rowMapper = (rs, rowNum) -> {
        return new PostDTO(
                rs.getLong("id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    };

    //전체 조회
    public List<PostDTO> findAll(){
        String sql = "SELECT * FROM post";
        return jdbcTemplate.query(sql, rowMapper);
    }
}
