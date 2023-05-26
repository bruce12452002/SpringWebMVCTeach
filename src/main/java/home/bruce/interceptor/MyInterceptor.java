package home.bruce.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * filter 是 servlet 技術；interceptor 是 spring mvc 技術
 * 請求會先經過 filter，如果路徑是 mvc 的路徑可以接受的，才會經過 interceptor
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle=" + handler);
        return true; // 回傳 true 才會繼續執行 @RequestMapping 的方法
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle"); // @RequestMapping 方法執行完才會執行
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion"); // 全部完成才會執行
    }
}
