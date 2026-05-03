package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category {

    @Id
    @GeneratedValue
    @Column(name = "CATEGORY_ID")
    private long categoryId;

    @Column(name = "NAME")
    private String name;

    @ManyToOne
    @Column(name = "PARENT_ID")
    @JoinColumn(name = "PARENT_ID")
    private Category parent;

    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    @ManyToMany
    private List<Item> items = new ArrayList<>();
}
