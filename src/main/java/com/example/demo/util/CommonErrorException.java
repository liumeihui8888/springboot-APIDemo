package com.example.demo.util;

public class CommonErrorException  extends RuntimeException{
    private static final long serialVersionUID=1L;
    protected  String errorCode;
    protected  String errorMessage;

    public CommonErrorException(){
        super();
    }
    public CommonErrorException(BaseErrorInfoInterface errorInfoInterface){
        super(errorInfoInterface.getResultCode());
        this.errorCode=errorInfoInterface.getResultCode();
        this.errorMessage=errorInfoInterface.getResultMessage();
    }
    public CommonErrorException(BaseErrorInfoInterface errorInfoInterface,Throwable cause){
        super(errorInfoInterface.getResultCode(),cause);
        this.errorCode=errorInfoInterface.getResultCode();
        this.errorMessage=errorInfoInterface.getResultMessage();
    }
    public CommonErrorException(String errorCode,String errorMessage){
        super(errorCode);
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;

    }
    public CommonErrorException(String errorCode,String errorMessage,Throwable cause){
        super(errorCode,cause);
        this.errorCode=errorCode;
        this.errorMessage=errorMessage;
    }
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getMessage() {
        return errorMessage;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }


}
