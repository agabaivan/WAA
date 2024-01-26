package com.agaba.waacourse.repo;

import com.agaba.waacourse.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
@RequiredArgsConstructor

public class criteriaBuilder {
    private final EntityManager em;
    public List<User> findByCriteriaUsers(String name, int age){
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        List<Predicate> predicates = new ArrayList<>();

        Root<User>root = criteriaQuery.from(User.class);

        if(name!= null){
            Predicate namePredicate = criteriaBuilder.like(root.get("name"), "%" + name + "%");
            predicates.add(namePredicate);
        }
        if(age>0){
            Predicate agePredicate = criteriaBuilder.greaterThanOrEqualTo(root.get("age"), age );
            predicates.add(agePredicate);
        }

        criteriaQuery.where(
                criteriaBuilder.and(predicates.toArray(new Predicate[0]))
        );
        TypedQuery<User> query = em.createQuery(criteriaQuery);
        return query.getResultList();

    }
}

