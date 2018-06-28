package jp.co.rakus.ec201804b.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 500エラーを出すクラス.
 * 
 * @author Nanami.Sasaki
 *
 */
@Controller
public class Error500Controller implements HandlerExceptionResolver{
	
	private static final Logger logger = LoggerFactory.getLogger(Error500Controller.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object obj, Exception e) {
		logger.error("Has Error",e);
		return new ModelAndView("user/error500");
	}

}
