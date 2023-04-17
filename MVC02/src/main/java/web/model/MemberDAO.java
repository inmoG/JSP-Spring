package web.model;

// JDBC -> MyBatis, JPA
/*
VO에 담아져있는 데이터를 DB나 File, Network을 이용해서 처리하는 부분을 담당하는 클래스를 DAO클래스라고 부른다.
여기서는 DB에 연결하고 CRUD로직을 처리하는 클래스이다.
 */

import java.sql.*;
import java.util.ArrayList;

public class MemberDAO {
    private Connection conn; // DB Connection 객체
    private PreparedStatement ps; // SQL문 질의 객체
    private ResultSet rs; // DB에서 리턴받는 데이터 객체

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
    } // getConnect()

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

            cnt = ps.executeUpdate();// 전송(SQL 실행) -> // 정상적으로 Insert 되었다면 성공한 행은 1개이므로 1이 리턴된다. Insert 실패하면 0을 리턴한다.

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt; // 1 or 0
    } // memberInsert()

    public ArrayList<MemberVO> memberList() {
        String SQL = "select * from member";
        getConnect(); // Connection 객체 생성
        ArrayList<MemberVO> list = new ArrayList<MemberVO>();

        try {
            ps = conn.prepareStatement(SQL);
            rs = ps.executeQuery(); // rs -> 커서
//            rs.next() -> boolean type 따라서 rs.next()가 true를 가지고 있으면 반복문이 실행된다.
//            이후 테이블 컬럼의 데이터를 get, memberVO 객체에 묶고 ArrayList에 VO 객체를 차례대로 담는다.
            while (rs.next()) {
                int num = rs.getInt("num");
                String id = rs.getString("id");
                String pass = rs.getString("pass");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
//                현재 컬럼에서 가져온 데이터는 개별적이므로 VO객체에 묶는다.
                MemberVO vo = new MemberVO(num, id, pass, name, age, email, phone);
                list.add(vo); // 묶은 VO를 ArrayList에 담는다.
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return list;
    } // memberList()

    public int memberDelete(int num) {
        String SQL = "delete from member where num=?";
        getConnect();
        int cnt = -1;
        try {
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, num);
            cnt = ps.executeUpdate();// 정상적으로 삭제가 되었다면 삭제한 행은 1개이므로 1이 리턴된다. 삭제가 실패하면 0을 리턴한다.
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    } // memberDelete

    public MemberVO memberContent(int num) {
        // 1. SQL query
        String SQL = "select * from member where num=?";
        // 2. DB Conn
        getConnect();
        MemberVO vo = null;
        try {
            ps = conn.prepareStatement(SQL); // 불완전한 SQL문을 전송해 미리 컴파일을 시킨다. (미리 컴파일을 시켰기에 속도가 빠르다)
//            conn.prepareStatement(SQL); -> 왜 ps에 객체를 리턴해야 할까?
            ps.setInt(1, num);
            rs = ps.executeQuery();
            if (rs.next()) {
                num = rs.getInt("num");
                String id = rs.getString("id");
                String pass = rs.getString("pass");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                vo = new MemberVO(num, id, pass, name, age, email, phone);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return vo;
    } // memberContent

    public int memberUpdate(MemberVO vo) {
        String SQL = "update member set age=?, email=?, phone=? where num=?";
        int cnt = -1;
        getConnect();
        try{
            ps = conn.prepareStatement(SQL);
            ps.setInt(1, vo.getAge());
            ps.setString(2, vo.getEmail());
            ps.setString(3, vo.getPhone());
            ps.setInt(4, vo.getNum());
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbClose();
        }
        return cnt;
    }

    public void dbClose() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // dbClose()
}

