package com.dejing.miniprogram.service;

import com.dejing.miniprogram.config.exception.CustomException;
import com.dejing.miniprogram.config.exception.CustomExceptionType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExceptionService {
    public void systemBizError(){
        try{
            Class.forName("com.mysql.jdbc.jdbc.Driver");
        }catch (ClassNotFoundException e){
            throw new CustomException(CustomExceptionType.SYSTEM_ERROR, "在XXX业务，myBiz()方法内，出现ClassNotFoundException");
        }
    }
    public List<String> userBizError(int input){
        if (input<0){
            throw new CustomException(CustomExceptionType.USER_INPUT_ERROR, "您输入的数据不符合业务逻辑，请确认后重新输入！");
        }else{
            List<String>list = new ArrayList<>();
            list.add("科比");
            list.add("詹姆斯");
            list.add("库里");
            return list;
        }
    }
}
