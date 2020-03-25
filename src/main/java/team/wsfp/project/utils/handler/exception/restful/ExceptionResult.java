package team.wsfp.project.utils.handler.exception.restful;

import lombok.Data;
import team.wsfp.project.utils.handler.enums.ExceptionEnum;

@Data
public class ExceptionResult {
    private int status;
    private String message;
    private Long timestamp;

    public ExceptionResult(ExceptionEnum exceptionEnum) {
        this.status = exceptionEnum.getCode();
        this.message = exceptionEnum.getMsg();
        this.timestamp = System.currentTimeMillis();
    }
}
