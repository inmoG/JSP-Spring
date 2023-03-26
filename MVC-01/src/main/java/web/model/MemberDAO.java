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

    // 데이터베이스 연결 객체 생성 (Connection)
    public void getConnect() {
//        데이터베이스 접속 URL
        String URL = "jdbc:mysql://localhost:3306/mvcdb?serverTimezone=UTC&characterEncoding=UTF-8";
        String user = "root";
        String password = "inmo";
        // MySQL Driver Loading

        try {
//            동적로딩 (실행지점에서 객체를 생성하는 방법)
            Class.forName("com.mysql.cj.jdbc.Driver"); // 동적로딩 방법 -> 드라이버 클래스를 메모리에 로딩한다.
            conn = DriverManager.getConnection(URL, user, password); // 커넥션 연결
            /*
            1. 빌드 후 실행하면 com.mysql.jdbc.Driver class를 찾아 메모리에 클래스를 로딩한다.
            2. DriverManager와 mysql.jdbc.Driver가 내부적으로 연결된다.
            3. getConnection() 실행하여 DB에 접속을 시도한다.
            4. 접속이 완료되면 Connection 객체를 conn (Connection Type) 변수에 담는다.
             */
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //    회원저장 동작 (Insert)
    public int memberInsert(MemberVO vo) {
//                                                                     ?-> (파라메터)1  2  3  4  5  6
        String SQL = "insert into member(id, pass, name, age, email, phone) values(?, ?, ?, ?, ?, ?)";
        getConnect(); // Connecrtion 객체 생성
        int cnt = -1;

        try {
            ps = conn.prepareStatement(SQL); // 불완전한 SQL문을 전송해 미리 컴파일을 시킨다. (미리 컴파일을 시켰기에 속도가 빠르다)
            ps.setString(1, vo.getId());
            ps.setString(2, vo.getPass());
            ps.setString(3, vo.getName());
            ps.setInt(4, vo.getAge());
            ps.setString(5, vo.getEmail());
            ps.setString(6, vo.getPhone());

            cnt = ps.executeUpdate();// 전송(SQL 실행) -> SQL이 성공적으로 실행되면 1을 리턴하고 실패하면 0을 리턴한다.

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cnt; // 1 or 0
    }
}
