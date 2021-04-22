package top.mable.payment.common.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import top.mable.payment.tool.Result;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;

@RestControllerAdvice
@Slf4j
public class ExceptionHandle {


    @ExceptionHandler
    @ResponseBody
    public Result handler(BusinessException businessException){

        log.error("业务异常处理",businessException);
        Enum enums  = businessException.getEnums();
        if (enums == null){
            return Result.fail(businessException.getMessage());
        }

        Class clazz = enums.getClass();
        try {
            String code = (String) clazz.getDeclaredMethod("getCode").invoke(enums);
            String msg = (String) clazz.getDeclaredMethod("getMsg").invoke(enums);
            if (businessException.getBindArgs() != null){
                msg = MessageFormat.format(msg,businessException.getBindArgs());
            }
            return Result.fail(code,msg);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }catch (Exception e){
            log.error(e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
        return null;
    }
}
