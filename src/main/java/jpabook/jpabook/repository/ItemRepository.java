package jpabook.jpabook.repository;

import jpabook.jpabook.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item){
        if(item.getId() == null){
            em.persist(item); // 새로 생성
        }
        em.merge(item); // 업데이트
    }

    public Item save(Long id){
        return em.find(Item.class, id);
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }


    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }
}
