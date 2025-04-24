package login_app.models;

public class Profile {
    private String fullName;
    private String nickName;
    private int age;
    private String hobby;
    private String gender;

    public Profile() {}//digunakan saat ingin membuat objeck Profile tanpa memberi nilai

    public Profile(String fullName, int age, String hobby) {
        this.fullName = fullName;
        this.age = age;
        this.hobby = hobby;
    }

    // Getter dan Setter
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }   

    public String getGender() {
        return gender;
    }

    public void setGender(String gender){
        this.gender = gender;
    }
}