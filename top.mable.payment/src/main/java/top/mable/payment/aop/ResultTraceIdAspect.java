package top.mable.payment.aop;

import cn.hutool.core.util.StrUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import top.mable.payment.tool.Constant;
import top.mable.payment.tool.Result;


@RestControllerAdvice
@ConditionalOnClass(ResponseBodyAdvice.class)
public class ResultTraceIdAspect implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return returnType.getMethod().getReturnType().equals(Result.class);
    }

    /**
     * 再返回出参的body中设置traceid ，前提是在请求的时候，先截取后塞入 HttpServletRequest 中
     * @param body
     * @param returnType
     * @param selectedContentType
     * @param selectedConverterType
     * @param request
     * @param response
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType,
                                  ServerHttpRequest request, ServerHttpResponse response) {
        if (body instanceof Result && StrUtil.isBlank(((Result<?>) body).getReqId())){
            String reqId = (String) ((ServletServerHttpRequest) request).getServletRequest().getAttribute(Constant.TRACE_ID);
            ((Result) body).setReqId(reqId);
        }
        return body;
    }
}
