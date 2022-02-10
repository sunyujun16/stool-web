package com.sunyujun.stool.controller;

import com.sunyujun.stool.javabean.UpdateBean;
import com.sunyujun.stool.pojo.Item;
import com.sunyujun.stool.pojo.ItemList;
import com.sunyujun.stool.service.impl.ItemServiceImpl;
import com.sunyujun.stool.service.impl.TodoListServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/11 19:51
 */
@CrossOrigin(origins = {"${spring.consts.front-end-host}"}, allowCredentials = "true")
@RestController
public class ItemController {
    private static final Logger logger = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemServiceImpl itemService;

    /**
     * 1/17测试通过，获取itemList成功。
     *
     * @param response 响应
     * @param request  请求
     * @param userId   你猜
     * @return java.util.List<com.sunyujun.stool.pojo.Item>
     * @author sunyujun
     * @date 1/17
     */
    @RequestMapping("/list-item")
    public List<Item> getItemList(HttpServletResponse response, HttpServletRequest request,
                                  @RequestParam(value = "userId", defaultValue = "1") Integer userId) {
        logger.info("handler正在处理list-item请求 ......");
        return itemService.getItemsByUserId(userId);
    }

    /**
     * 更新该用户的所有items，前端每10分钟或手动访问一次。
     *
     * @return boolean
     * @author sunyujun
     * @date 2/8
     */
    @PostMapping("/update_all")
    public boolean updateAll(
            @RequestBody UpdateBean updateBean
    ) {
        logger.info("handler正在处理updateAll请求 ......");
        boolean b = itemService.updateAll(updateBean.getItemList(), updateBean.getUserId());
        logger.info("updateAll 处理完毕");
        for (Item item : updateBean.getItemList()) {
            System.out.println(item.getCreateTime());
        }
        return b;
    }

}













