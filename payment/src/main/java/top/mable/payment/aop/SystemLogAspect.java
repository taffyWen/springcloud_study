package top.mable.payment.aop;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import top.mable.payment.tool.Constant;
import top.mable.payment.tool.RequestData;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

@Aspect
@Component
@Slf4j
public class SystemLogAspect {

    /**
     * Controller层切点
     */
    @Pointcut("businessControllerAspect() || apiControllerAspect()")
    public void controllerAspect() {
    }

    @Pointcut("within(top.mable.payment.controller.*)")
    private void businessControllerAspect() {
    }

    @Pointcut("within(top.mable.payment.*.controller.*)")
    private void apiControllerAspect() {
    }

    /**
     * Service层切点
     */
    @Pointcut("@annotation(top.mable.payment.annotation.SystemServiceLog)")
    public void serviceAspect() {
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     *
     * @param joinPoint 切点
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint joinPoint) {
        log.info("=========================请求开始=========================");
        try {
            ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = attributes.getRequest();

            // 收到请求记录内容
            String url = request.getRequestURL().toString();
            String method = request.getMethod();
            String id = request.getRemoteAddr();

            log.info("url: {}, method: {}, id: {}", url, method, id);
            Enumeration<String> enums = request.getParameterNames();
            while (enums.hasMoreElements()) {
                String name = enums.nextElement();
                log.info("name:{},value:{}", name, request.getParameter(name));
            }
            log.info("body: {}", JSONUtil.parse(joinPoint.getArgs()));

            if (joinPoint.getArgs().length > 0 && joinPoint.getArgs()[0] instanceof RequestData) {
                request.setAttribute(Constant.TRACE_ID, ((RequestData) joinPoint.getArgs()[0]).getReqId());
            }
        } catch (Exception e) {
            //记录本地异常日志
            // log.error("==前置通知异常==");
            //log.error("异常信息:{}", e.getMessage());
        }

    }
}
