package com.holley.servicezuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Holley
 * @Description 请输入一句话进行描述
 * @create 2019-09-17 16:55
 **/
@Component
public class MyFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(MyFilter.class);

    /** filterType:返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型
     * pre:路由之前
     * routing:路由之时
     * post:路由之后
     * error:发送错误调用
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤的顺序
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 这里可写逻辑判断，判断是否过滤，true表示过滤，false表示不过滤
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        if(request.getMethod().equalsIgnoreCase("GET"))
            return false;
        return true;
    }
    /**
      * 过滤器的具体逻辑。可用很复杂，包括查sql,nosql去判断该请求到底有没有权限访问
      */
    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s",request.getMethod(),request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null){
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try{
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){
                e.printStackTrace();
            }
            return null;
        }
        log.info("ok");
        return null;
    }
}
