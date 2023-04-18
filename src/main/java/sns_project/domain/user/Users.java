package sns_project.domain.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.persistence.Id;
import java.util.ArrayList;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String user_id;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    @Column(nullable = false)
    private String user_name;

    // @ElementCollection
    // @CollectionTable(name = "friend_list", joinColumns = @JoinColumn(name = "user_id"))
    // @Column(name = "friend")
    // private List<String> friend;

    @Column(nullable = true)
    private String profile_img;

    @Column(nullable = true)
    private String background_img;

    @Column(nullable = true)
    private String bio;

    // @ElementCollection
    // @CollectionTable(name = "like_list", joinColumns = @JoinColumn(name = "user_id"))
    // @Column(name = "post_id")
    // private List<String> post_id;

    @Builder
    public Users(String user_id, String password, String nickname, String user_name ) {
        this.user_id = user_id;
        this.password = password;
        this.nickname = nickname;
        this.user_name = user_name;
    }
}
