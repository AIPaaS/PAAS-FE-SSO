package com.aic.paas.csso.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aic.paas.csso.svc.ExternalOperationSvc;
import com.binary.core.io.support.ByteArrayResource;
import com.binary.framework.util.ControllerUtils;
import com.binary.sso.server.Constant;
import com.binary.sso.server.SsoServerConfiguration;
import com.binary.sso.server.exception.SsoException;
import com.binary.tools.captcha.Captcha;
import com.binary.tools.captcha.CaptchaImage;
import com.binary.tools.captcha.ImageType;


@Controller
@RequestMapping("/external/operation")
public class ExternalOperationMvc {

	private String EO_REGISTER_CAPTCHA = "SK_EO_REGISTER_CAPTCHA";
	private String EO_FORGETPWD_CAPTCHA = "SK_EO_FORGETPWD_CAPTCHA";
	
	
	@Autowired
	Captcha captcha;
	
	@Autowired
	ExternalOperationSvc eoSvc;
	
	
	@Autowired
	SsoServerConfiguration configuration;
	
	
	
	@RequestMapping("/getRegCaptchaImage")
	public void getRegCaptchaImage(HttpServletRequest request, HttpServletResponse response) {
		if(this.captcha == null) throw new SsoException(" the captcha build tool is not setting! ");
		
		CaptchaImage image = this.captcha.drawImage();
		
		String code = image.getCode();
		byte[] data = image.getData();
		ImageType type = image.getType();
		
		HttpSession session = request.getSession(true);
		session.setAttribute(EO_REGISTER_CAPTCHA, code);
		
		String imageType = type.getContentType();
		ControllerUtils.returnResource(request, response, new ByteArrayResource(data, null), imageType);
	}
	
	
	@RequestMapping("/getForgetpwdCaptchaImage")
	public void getForgetpwdCaptchaImage(HttpServletRequest request, HttpServletResponse response) {
		if(this.captcha == null) throw new SsoException(" the captcha build tool is not setting! ");
		
		CaptchaImage image = this.captcha.drawImage();
		
		String code = image.getCode();
		byte[] data = image.getData();
		ImageType type = image.getType();
		
		HttpSession session = request.getSession(true);
		session.setAttribute(EO_FORGETPWD_CAPTCHA, code);
		
		String imageType = type.getContentType();
		ControllerUtils.returnResource(request, response, new ByteArrayResource(data, null), imageType);
	}
	
	
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute(Constant.SSO_NOCLIENT_URL_KEY, this.configuration.getNoClientUrl());
		return "forward:/login.jsp";
	}
	
	
	
	
	
	
}





