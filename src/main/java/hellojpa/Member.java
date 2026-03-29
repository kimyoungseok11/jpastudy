package hellojpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Member {

    @Id
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "varchar(100) default 'EMPTY'")
    private String username;

    private BigDecimal age;

    //enum을 사용할 경우
    //EnumType.STRING으로 무조건 사용
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    //varchar보다 긴 경우
    @Lob
    private String description;

    public Member() {

    }
}
