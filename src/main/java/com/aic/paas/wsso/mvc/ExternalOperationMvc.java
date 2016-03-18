package com.aic.paas.wsso.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aic.paas.comm.util.ExceptionUtil;
import com.aic.paas.frame.util.SysFrameUtil;
import com.aic.paas.wsso.bean.WsMerchent;
import com.aic.paas.wsso.svc.ExternalOperationSvc;
import com.binary.core.io.support.ByteArrayResource;
import com.binary.core.util.BinaryUtils;
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
	
	
	@RequestMapping("/register")
	public void register(HttpServletRequest request, HttpServletResponse response, WsMerchent mnt, String captchaCode) {
		String msg = doRegister(request, response, mnt, captchaCode);
		ControllerUtils.returnJson(request, response, msg);
	}
	
	
	
	protected String doRegister(HttpServletRequest request, HttpServletResponse response, WsMerchent mnt, String captchaCode) {		
		try {
			BinaryUtils.checkEmpty(mnt, "mnt");
			
			if(BinaryUtils.isEmpty(mnt.getMntCode())) {
				return "租户代码为空";
			}
			if(BinaryUtils.isEmpty(mnt.getMntName())) {
				return "租户名称为空";
			}
			if(BinaryUtils.isEmpty(mnt.getMntPwd())) {
				return "登录密码为空";
			}
			
			/*if(captchaCode==null || (captchaCode=captchaCode.trim()).length()==0) {
				return "验证码为空";
			}*/
			
			if(BinaryUtils.isEmpty(mnt.getContactEmail())) {
				return "邮箱地址为空";
			}
			if(BinaryUtils.isEmpty(mnt.getCcCode())) {
				return "成本中心为空";
			}
			if(BinaryUtils.isEmpty(mnt.getContactName())) {
				return "联系人员为空";
			}
			if(BinaryUtils.isEmpty(mnt.getContactPhone())) {
				return "联系电话为空";
			}
			
			/*HttpSession session = request.getSession();
			String sessioncode = (String)session.getAttribute(EO_REGISTER_CAPTCHA);
			if(sessioncode==null || (sessioncode=sessioncode.trim()).length()==0) {
				return "验证码图片为空";
			}
			
			session.removeAttribute(EO_REGISTER_CAPTCHA);
			if(!captchaCode.equalsIgnoreCase(sessioncode)) {
				return "验证码输入错误";
			}*/
			
			String s = eoSvc.register(mnt);
			if(!BinaryUtils.isEmpty(s)) {
				return s;
			}
		}catch(Throwable t) {
			t = ExceptionUtil.getRealThrowable(t);
			return "注册出错: "+t.getMessage();
		}
		
		return "";
	}
	
	
	/**
	 * 验证用户是否具有指定模块的权限
	 * @param opId : 用户ID
	 * @param moduId : 被验证的模块Code
	 * @return
	 */
	@RequestMapping("/verifyModuCode")
	public @ResponseBody String verifyModeCode(HttpServletRequest request, HttpServletResponse response,
			 Long opId, String moduCode) {	
		
		boolean verifyResult=  SysFrameUtil.verifyModuCode(opId, moduCode);	
		
		return String.valueOf(verifyResult);
	}
	
	/**
	 * 验证用户是否具有指定模块的权限
	 * @param opId : 用户ID
	 * @param moduId : 被验证的模块Id
	 * @return
	 */
	@RequestMapping("/verifyModuId")
	public @ResponseBody String verifyModuId(HttpServletRequest request, HttpServletResponse response,
			 Long opId, Long moduId) {	
		
		boolean verifyResult=  SysFrameUtil.verifyModuId(opId, moduId);	
		
		return String.valueOf(verifyResult);
	}
	
}





