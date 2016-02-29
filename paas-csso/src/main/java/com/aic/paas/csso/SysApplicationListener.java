package com.aic.paas.csso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.binary.framework.ApplicationListener;
import com.binary.sso.server.SsoServerInitialization;
import com.binary.tools.captcha.support.patchca.PatchcaCaptcha;
import com.binary.tools.captcha.support.patchca.PatchcaWordFactory;

public class SysApplicationListener implements ApplicationListener {

	
	@Autowired
	PatchcaCaptcha captcha;
	
	
	
	@Override
	public void afterInitialization(ApplicationContext context) {
		SsoServerInitialization init = context.getBean(SsoServerInitialization.class);
		init.initialize(context);
		
		PatchcaWordFactory wordFactory = (PatchcaWordFactory)this.captcha.getConfigurable().getWordFactory();
		wordFactory.setMaxLength(4);
		wordFactory.setMinLength(4);
	}

}
