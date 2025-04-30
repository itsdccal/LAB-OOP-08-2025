package login_app.models;

public class Profile {

    String fullName;
    String nickName;
    int age;
    String hobby;
    String status;

    public Profile(String fullName, String nickName, int age, String hobby, String status) {
        this.fullName = fullName;
        this.age = age;
        this.hobby = hobby;
        this.nickName = nickName;
        this.status = status;
    }

    
    public void setfullName(String fullName) {
        this.fullName = fullName;
    }

    public String getfullName() {
        return fullName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void sethobby(String hobby) {
        this.hobby = hobby;
    }

    public String gethobby() {
        return hobby;
    }

    public void setnickName(String nickName) {
        this.nickName = nickName;
    }

    public String getnickName() {
        return nickName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

}
