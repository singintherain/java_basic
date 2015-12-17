package com.lvsong.error;

import org.springframework.web.bind.annotation.ResponseBody;
		import org.springframework.web.servlet.ModelAndView;
		import org.springframework.web.bind.annotation.ControllerAdvice;
		import org.springframework.web.bind.annotation.ExceptionHandler;
		import org.springframework.web.servlet.ModelAndView;

		import javax.servlet.http.HttpServletRequest;
		import java.util.HashMap;
		import java.util.Map;

/**
 * Created by wangyong on 2015/9/14.
 */
@ControllerAdvice
public class ExceptionControllerAdvice {

	@org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
	@ResponseBody
	public Object exception(Exception e,HttpServletRequest request){
		boolean isAjaxRequest = "XMLHttpRequest".equals( request.getHeader("X-Requested-With") );
		if(isAjaxRequest){
			return handAjaxException(e);
		}else {
			return handHttpExcEption(e);
		}

	}

	/**
	 * 处理普通Http请求的异常
	 * @param e
	 * @return
	 */
	public ModelAndView handHttpExcEption(Exception e) {
		ModelAndView mav = new ModelAndView("error/general");
		mav.addObject("message", e.getMessage());
		return mav;
	}

	/**
	 * 处理Ajax请求的异常
	 * @param e
	 * @return
	 */
	public Object handAjaxException(Exception e){
		Map map = new HashMap();
		map.put("result", "发生了异常：" + e.getMessage());
		return map;
	}

}