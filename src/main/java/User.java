/**
 * Created by Matthew on 2017-01-20.
 */
public class User {
    public String nickName;
    public User(String nickName){
        this.nickName = nickName;
    }

    @Override
    public String toString(){
        return this.nickName;
    }
}
