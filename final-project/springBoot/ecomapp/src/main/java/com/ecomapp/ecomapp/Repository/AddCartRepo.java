package com.ecomapp.ecomapp.Repository;

import com.ecomapp.ecomapp.Request.ProductModelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
@Repository
public class AddCartRepo {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;
    private String getCartSql = "SELECT p.id,p.name,cart.qty,p.price,p.description,cart.cart_id,cart.created_date FROM  add_cart as cart join products as p on cart.product_id = p.id where cart.user_id=:userId";
    public List<ProductModelDto> getCartProductDetails(Integer userId){
        List<ProductModelDto> productModelDtoList = new ArrayList<>();
        //bind the mysql param to the query
        MapSqlParameterSource mysqlParams = new MapSqlParameterSource()
                .addValue("userId", userId);

            this.jdbcTemplate.query(getCartSql, mysqlParams,new RowMapper<ProductModelDto>() {
                @Override
                public ProductModelDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                    ProductModelDto productModelDto = new ProductModelDto();
                    productModelDto.setProduct_id(rs.getInt("id"));
                    productModelDto.setName(rs.getString("name"));
                    productModelDto.setQty(rs.getInt("qty"));
                    productModelDto.setPrice(rs.getDouble("price"));
                    productModelDto.setDescription(rs.getString("description"));
                    productModelDto.setCart_id(rs.getInt("cart_id"));
                    productModelDto.setCreated_date(rs.getDate("created_date").toLocalDate());
                    productModelDtoList.add(productModelDto);

                    return productModelDto;
                }
            });
        return productModelDtoList;
    }


}
