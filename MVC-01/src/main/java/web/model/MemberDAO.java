package web.model;

// JDBC -> MyBatis, JPA
/*
VO에 담아져있는 데이터를 DB나 File, Network을 이용해서 처리하는 부분을 담당하는 클래스를 DAO클래스라고 부른다.
여기서는 DB에 연결하고 CRUD로직을 처리하는 클래스이다.
 */

import java.sql.*;

public class MemberDAO {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

}
