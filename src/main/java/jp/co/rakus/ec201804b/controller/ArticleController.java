package jp.co.rakus.ec201804b.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.rakus.ec201804b.form.ArticleForm;
import jp.co.rakus.ec201804b.repository.ArticleRepository;

@Controller
@RequestMapping("/user")
public class ArticleController {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@ModelAttribute
	public ArticleForm setArticle() {
		return new ArticleForm();
	}
	
	@RequestMapping("/")
	public String findAll() {
		return "";
	}

}
