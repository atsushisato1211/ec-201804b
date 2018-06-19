package jp.co.rakus.ec201804b.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ec201804b.domain.Item;
import jp.co.rakus.ec201804b.repository.ItemRepository;

@Controller
@RequestMapping("/menu")
public class AdminMenuController {
	@Autowired
	private ItemRepository repository;


	@RequestMapping("/")
	public String index() {
		
		return "administer/menu";
	}
	
	@RequestMapping("/regist")
	public String regist() {
		return "administer/regist";
	}
	
	@RequestMapping("/viewList")
	public String listview(Model model) {
		List<Item>list = repository.findAll();
		model.addAttribute("itemList", list);
		return "administer/viewList";
	}
	
	@RequestMapping(value = "/findByName")
	public String findByName(@RequestParam String adminitem, Model model) {
		if(adminitem.isEmpty()) {
			return "redirect:/menu/viewList";
		}
		List<Item>list = repository.findByName(adminitem);
		model.addAttribute("itemList", list);
		
		return "administer/viewList";
	}
	/**
	 * 削除フラグの変更を行うメソッド.
	 * @param id 商品id
	 * @param deleted 削除フラグ
	 * @param model 検索結果
	 * @return 全件検索画面
	 */
	@RequestMapping(value = "/changeByDeleted")
	public String changeByDeleted(@RequestParam Integer id,@RequestParam Boolean deleted, Model model) {
		if(deleted) {
			deleted=false;
		}else {
			deleted=true;
		}
		System.out.println(id);
		System.out.println(deleted);
		
		repository.changeByDeleted(id,deleted);
		return listview(model);
	}
	
}
