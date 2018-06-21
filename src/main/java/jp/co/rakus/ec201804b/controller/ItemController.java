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
@RequestMapping(value="/user")
public class ItemController {
	@Autowired
	private ItemRepository repository;
	
	/**
	 * 商品一覧画面を表示させるメソッド.
	 * @param model
	 * @return userフォルダーのitemList.jsp(商品一覧画面)
	 */
	@RequestMapping(value = "/item")
	public String index(Model model) {
		List<Item>list = repository.findAllByNotDeleted();
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
//		if(useritem.isEmpty()) {
//			return "redirect:/item/";
//		}
		if(useritem==null || useritem.isEmpty()) {
			return "redirect:user/item";
		}
		List<Item>list = repository.findByNameAndNotDeleted(useritem);
		model.addAttribute("itemList", list);
		model.addAttribute("itemName",useritem);
		
		return "user/itemList";
		
	}
	@RequestMapping(value = "/findByNameAndSort")
	public String findByNameAndSort(@RequestParam String useritem,@RequestParam String itemSort, Model model) {
		if(useritem==null || useritem.isEmpty()) {
			System.out.println("00000000000000"+useritem);
			System.out.println(itemSort);
			return findBySort(itemSort,model);
		}
		List<Item>list = repository.findByNameAndSortNotDeleted(useritem, itemSort);
		model.addAttribute("itemList", list);
		
		return "user/itemList";
		
	}
	@RequestMapping(value = "/findBySort")
	public String findBySort(String itemSort, Model model) {
		System.out.println("aaaaaaaaaaaaaaaaaaaa"+itemSort);
		List<Item>list = repository.findAllBySortAndNotDeleted(itemSort);
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
	public String itemdetail(@RequestParam Long id,Model model) {
		Item item = repository.load(id);
		model.addAttribute("item",item);
		
		return "user/itemDetail";
		
	}

}

