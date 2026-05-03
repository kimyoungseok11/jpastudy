package hellojpa;

import javax.persistence.*;

@Entity
public class CategoryItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "CATEGORY_ID")
    private long categoryId;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID")
    private long itemId;
}
