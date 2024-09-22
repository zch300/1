package top.soft.class02;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;

/**
 * @author YourName
 * @date 2023/8/16 15:08
 * @description This is a description of the class.
 */
public class RequestDemo04 extends HelloServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 根据参数名获取参数值
        String username = request.getParameter("username");
        System.out.println(username);

        // 根据参数名获取参数值的数组
        String[] hobbies = request.getParameterValues("hobby");
        if (hobbies != null) {
            for (String hobby : hobbies) {
                System.out.println(hobby);
            }
        }

        // 获取所有参数的参数名称
        System.out.println("===========");
        System.out.println("获取所有参数的参数名称");
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            System.out.println("参数名：" + name);
            String value = request.getParameter(name);
            System.out.println(value);
        }

        // 获取所有的参数的map集合
        System.out.println("=================");
        System.out.println("获取所有的参数的map集合");
        Map<String, String[]> parameterMap = request.getParameterMap();
        // 遍历获取
        Set<String> keySet = parameterMap.keySet();
        for (String key : keySet) {
            System.out.println("参数名称：" + key);
            String[] values = parameterMap.get(key);
            for (String value : values) {
                System.out.println(value);
            }
        }
    }
}

