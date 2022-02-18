package com.sunyujun.stool;

import com.sunyujun.stool.mapper.ItemsMapper;
import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.service.impl.TodoListServiceImpl;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class StoolBackendApplicationTests {

    @Autowired
    private TodoListServiceImpl todoListService;

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private SqlSession sqlSession;

    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void testGetItemsService(){
        List<Item> itemListByUserId = todoListService.getItemListByUserId("001");
        assert itemListByUserId.size() > 0;
    }

    @Test
    public void testItemsMapper(){
        ItemsMapper mapper = sqlSession.getMapper(ItemsMapper.class);
        List<Item> itemList = mapper.getItemsByUserId(1);
        System.out.println(itemList);
//        List<Item> items = itemsMapper.getItemsByUserId("001");
//        System.out.println(items);
    }

    @Test
    void testDruid() throws SQLException {
        Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from items where userId='001'");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String title = resultSet.getString("title");
            System.out.println("--------------" + title);
        }
    }




}
