package by.javaeducation.repository.datajpa;

import by.javaeducation.model.Item;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudRepo extends JpaRepository<Item, Integer> {

    @Transactional
    @Override
    <S extends Item> S save(S entity);

    @Transactional
    @Modifying
    @Query("DELETE FROM Item i WHERE i.id=:id")
    int delete(@Param("id") int id);

    @Override
    Item findOne(Integer integer);

    @Override
    List<Item> findAll();

    @Override
    List<Item> findAll(Sort sort);
}
