package com.Cyanurzz.SupremeOtter.resource;

import java.text.MessageFormat;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import com.Cyanurzz.SupremeOtter.entity.Language;
import com.Cyanurzz.SupremeOtter.repository.LanguageRepository;

@Component("messageSource")
public class DBMessageSource extends AbstractMessageSource {

	@Autowired
	private LanguageRepository languageRepository;
	
	private static final String DEFAULT_LOCALE_CODE = "fr";

	@Override
	protected MessageFormat resolveCode(String key, Locale locale) {
		Language message = languageRepository.findByKeyAndLocale(key,locale.getLanguage());
		if (message == null) {
			message = languageRepository.findByKeyAndLocale(key,DEFAULT_LOCALE_CODE);
		}
		return new MessageFormat(message.getContent(), locale);
	}

}