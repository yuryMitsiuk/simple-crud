package by.javaeducation.repository;

import by.javaeducation.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class ItemRepoImpl implements ItemRepo {

    private static final BeanPropertyRowMapper<Item> ROW_MAPPER = BeanPropertyRowMapper.newInstance(Item.class);

    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;

    @Autowired
    public ItemRepoImpl(DataSource dataSource, JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource).withTableName("items").usingGeneratedKeyColumns("id");
        this.jdbcTemplate = jdbcTemplate;
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public Item save(Item item) {
        MapSqlParameterSource source = new MapSqlParameterSource()
                .addValue("id", item.getId())
                .addValue("title", item.getTitle())
                .addValue("delivery", item.getDelivery())
                .addValue("quantity", item.getQuantity())
                .addValue("enabled", item.isEnable());
        if (item.isNew()) {
            Number newKey = simpleJdbcInsert.executeAndReturnKey(source);
            item.setId(newKey.intValue());
        } else {
            return namedParameterJdbcTemplate.update("UPDATE items SET title=:title," +
                    "delivery=:delivery, quantity=:quantity WHERE id=:id", source) > 0 ?
                    item : null;
        }
        return item;
    }

    @Override
    public boolean delete(int id) {
        return jdbcTemplate.update("DELETE FROM items WHERE id=?", id) > 0;
    }

    @Override
    public Item get(int id) {
        return DataAccessUtils.singleResult(jdbcTemplate.query("SELECT * FROM items WHERE id=?", ROW_MAPPER, id));
    }

    @Override
    public List<Item> getAll() {
        return jdbcTemplate.query("SELECT * FROM items WHERE id=? ORDER BY delivery DESC", ROW_MAPPER);
    }
}
