package com.nFactorial.backend.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemberDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public boolean isAdminMember(String email) {
        String sql = "SELECT COUNT(*) FROM tbl_admin_member WHERE email = ?";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, email);
        return result > 0;
    }

    public int insertAdminAccount(MemberVo memberVo) {
        List<Object> args = new ArrayList<Object>();

        String sql = "INSERT INTO tbl_admin_member VALUES(?, ?)";

        args.add(memberVo.getName());
        args.add(memberVo.getEmail());

        int result = -1;

        try {
            result = jdbcTemplate.update(sql, args.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<MemberVo> loadMember(String email) {
		List<MemberVo> memberVos = new ArrayList<MemberVo>();
		String sql = "SELECT * FROM tbl_admin_member WHERE email = ?";
		try {
			memberVos = jdbcTemplate.query(sql, new RowMapper<MemberVo>() {
				@Override
				public MemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
					MemberVo memberVo = new MemberVo();
					memberVo.setName(rs.getString("name"));
					memberVo.setEmail(rs.getString("email"));
					return memberVo;
				}
			}, email);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return memberVos;
	}
}
