package jp.co.rakus.ec201804b.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ec201804b.domain.Item;
import jp.co.rakus.ec201804b.repository.ItemRepository;


/**
 * 商品コントローラー
 * @author kohei.takahashi
 *
 */
@Controller
@RequestMapping(value="/item")
public class ItemController {
	@Autowired
	private ItemRepository repository;
	
	/**
	 * 商品一覧画面を表示させるメソッド.
	 * @param model
	 * @return userフォルダーのitemList.jsp(商品一覧画面)
	 */
	@RequestMapping(value = "/")
	public String index(Model model) {
		List<Item>list = repository.findAll();
		model.addAttribute("itemList", list);
		
		return "user/itemList";
		
	}

	/**
	 * 	商品名検索を行うメソッド.
	 * @param useritem 商品名
	 * @param model 
	 * @return userフォルダーのitemList.jsp(商品一覧画面)
	 */
	@RequestMapping(value = "/findByName")
	public String findByName(@RequestParam String useritem, Model model) {
		if(useritem.isEmpty()) {
			return "redirect:/item/";
		}
		List<Item>list = repository.findByName(useritem);
		model.addAttribute("itemList", list);
		
		return "user/itemList";
		
	}
	
	/**
	 * 商品詳細を表示させるメソッド.
	 * @param id 商品id
	 * @param model
	 * @return userフォルダーのitemDetail.jsp(商品詳細画面)
	 */
	@RequestMapping(value="/itemdetail")
	public String itemdetail(@RequestParam Integer id,Model model) {
		Item item = repository.load(id);
		model.addAttribute("item",item);
		
		return "user/itemDetail";
		
	}

}

