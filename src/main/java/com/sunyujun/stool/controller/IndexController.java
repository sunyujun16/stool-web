package com.sunyujun.stool.controller;

import com.sunyujun.stool.pojo.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author sunyujun
 * @version 0.0.0
 * @date 1/3 20:11
 */
@Controller
public class IndexController {

    @ResponseBody
    @RequestMapping("/")
    public Item indexHandler(Model model,
                             HttpServletRequest request,
                             HttpServletResponse response) throws IOException {
        System.out.println("fucking runnning");
        // 不能跳转到其他端口
//        response.sendRedirect("localhost:8081");
        /*
        研究session，先记录一下，现在探索出来的如下：
        1 session是在这句代码中自动创建的，而且会自动返回给浏览器，浏览器也非常自觉的带着它。
        2 这不是保证登录，而是保证我们在使用session的时候，能够和浏览器有一一对应的关系，
        毕竟我们没有在代码中指定使用哪个session，是系统根据ID自动为我们找到了正确的session。
        3 这样形成一一对应关系之后，我们就能放心大胆地往session里面存东西，而不用担心张冠李戴，存错了地方。
        4 本质上，它和哪个user登录是没有关系的，它只和浏览器有关，登谁的账号或者不登录账号，都他妈是一样的session。
        之所以实际应用当中发生不同。是因为我们往往在session当中，有意地存储了用户的信息用于校验。
        5. 那么如何保证我们在浏览器不关闭时，同一个用户的session的一致性以及不同用户的session的区别捏
        6 sessionID的一致性好说，只要请求头携带SessionID过来，就能获取到正确的session，就能保持sessionID不变化
        7 那么当切换用户后，我们在“控制登录的handler”（在登录界面做这个是因为表单携带了用户数据）中就需要进行一些验证——先拿到session，、
        密码验证通过后，就往session里面放一些用户信息，比如用户名，存着备用。那么当下一次请求过来时，会先经过拦截器，在拦截器当中，我们就可以
        利用request携带的cookies中的jsessionID（如果浏览器窗口没变，那就仍然是上个用户相同的JSessionID，也就是共享一个session）来获取
        session，然后拿到sesion，如果发现这个session里面已经存储了用户名，就说明这个请求之前已经做过登录了，也就放行即可。
         */
        HttpSession session = request.getSession();
        System.out.println(session.getId());
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH : mm : ss");
        System.out.println(dateFormat.format(session.getCreationTime()));

        Item item = new Item();
        item.setId("001");
        item.setTitle("eat shit");
        item.setDone(true);
        return item;
    }


}
