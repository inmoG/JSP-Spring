package web.model;

// 회원 (Object) -> MemberVO
// 여러 자료형을 담기위해 class 사용
/*
MemberVO는 바구니이다.
데이터를 |____|____|____|____| 이런식으로 담기위해서 VO라는 구조가 필요하다.
MemberVO는 DB에 저장되어 있는 컬럼 값들을 MemberVO에
통째로 하나씩 담아서 가져오기 위해서 or 자바에서 CRUD를 통해
DB에 새 데이터를 등록하기 위해서 만든다.
 */
public class MemberVO {
    private int num;
    private String id;
    private String pass;
    private String name;
    private int age;
    private String email;
    private String phone;

    public MemberVO() {

    }

    // 회원가입 생성자
    public MemberVO(String id, String pass, String name, int age, String email, String phone) {
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    // DB 조회 생성자
    public MemberVO(int num, String id, String pass, String name, int age, String email, String phone) {
        this.num = num;
        this.id = id;
        this.pass = pass;
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // 디버깅 용
    @Override
    public String toString() {
        return "MemberVO{" +
                "num=" + num +
                ", id='" + id + '\'' +
                ", pass='" + pass + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
