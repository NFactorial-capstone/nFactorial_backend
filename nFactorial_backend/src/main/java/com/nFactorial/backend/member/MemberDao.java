package com.nFactorial.backend.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

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
}
