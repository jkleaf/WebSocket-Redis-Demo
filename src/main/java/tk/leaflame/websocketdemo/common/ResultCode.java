package tk.leaflame.websocketdemo.common;

import javax.servlet.http.HttpServletResponse;

public enum ResultCode {

    SUCCESS(HttpServletResponse.SC_OK),
    FAILED(HttpServletResponse.SC_BAD_REQUEST),
    FORBIDDEN(HttpServletResponse.SC_FORBIDDEN),
    UNAUTHORIZED(HttpServletResponse.SC_UNAUTHORIZED),//未认证（签名错误）
    NOT_FOUND(HttpServletResponse.SC_NOT_FOUND),//接口不存在
    INTERNAL_SERVER_ERROR(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);//服务器内部错误

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
