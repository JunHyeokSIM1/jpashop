package japbook.jpashop.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Category extends BaseEntity{
    @Id @GeneratedValue
    private Long id;

    private String name;

    //상위 카테고리
    @ManyToOne
    @JoinColumn(name = "PARENT_ID")
    private Category parent;


    //셀프로 잡힌자식객체
    @OneToMany(mappedBy = "parent")
    private List<Category> child = new ArrayList<>();

    //한 아이템도 여러 카테고리 소속될수 있다는 가능성
    @ManyToMany
    @JoinTable(name = "CATEGORY_ITEM",
            joinColumns =  @JoinColumn(name = "CATEGORY_ID"),
            inverseJoinColumns = @JoinColumn(name = "ITEM_ID")
    )
    //반대쪽조인 하는걸 정해줌
    private List<Item> items = new ArrayList<>();
}
