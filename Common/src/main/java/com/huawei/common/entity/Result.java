package com.huawei.common.entity;

import com.huawei.common.util.Constant;

import lombok.Data;

/**
 * <前后端交互的结果对象>
 *
 * @author chenjie
 * @since 2021-03-06
 */
@Data
public class Result<T> {	 
   private Integer code;
   
   private String msg;
   	
   private T data;
   
   public static<T> Result<T> ok() { 
	   return Result.ok(null);
   }
   
   public static<T> Result<T> ok(T data) {
	   Result<T> res = new Result<T>();
	   res.code = Constant.SUC_CODE;
	   res.data = data;
	   return res;
   }
   
   public static<T> Result<T> empty() {
	   Result<T> res = new Result<T>();
	   res.code = Constant.EMPTY_CODE; 
	   return res;
   }
   
   public static<T> Result<T> error(String msg) {
	   Result<T> res = new Result<T>();
	   res.code = Constant.ERROR_CODE; 
	   res.msg = msg;
	   return res;
   }
}
