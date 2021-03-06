package jp.co.rakus.ec201804b.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jp.co.rakus.ec201804b.domain.Item;
import jp.co.rakus.ec201804b.form.OrderItemForm;
import jp.co.rakus.ec201804b.repository.ItemRepository;

/**
 * 商品コントローラー
 * 
 * @author kohei.takahashi
 *
 */
@Controller
@RequestMapping(value = "/user")
public class ItemController {
	@Autowired
	private ItemRepository repository;
	
	@ModelAttribute
	public OrderItemForm setUpForm() {
		return new OrderItemForm();
	}

	/**
	 * 商品一覧画面を表示させるメソッド.
	 * 
	 * @param model
	 * @return userフォルダーのitemList.jsp(商品一覧画面)
	 */
	@RequestMapping(value = "/item")
	public String aindex(Model model) {
		List<Item> list = repository.findAllByNotDeleted();
		model.addAttribute("itemList", list);
		model.addAttribute("pageNum", 1);
		model.addAttribute("pagett", 1);
		model.addAttribute("maxPageNum", pagingNum(repository.MaxId()));
		System.out.println(list.size());

		// return "user/itemList";
		return index(model);
	}

	@RequestMapping(value = "/itema")
	public String index(Model model) {
		List<Item> list = repository.findByNewItem();
		model.addAttribute("newitem", list);
		LocalDate Manth = LocalDate.now();
		Manth.getMonth();
		System.out.println(Manth.getDayOfMonth());
		System.out.println(season(String.valueOf(Manth.getMonth())));
		return "user/itemList";
	}

	@RequestMapping(value = "/page")
	public String page(@RequestParam Integer pageNum, Model model) {
		List<Item> list = repository.findAllBypageNumNotDeleted(pageNum);
		if (repository.MaxId() % 15 == 0) {
			Long maxPageNum = repository.MaxId() / 15;
			model.addAttribute("maxPageNum", maxPageNum);
		} else {
			Long maxPageNum = repository.MaxId() / 15 + 1;
			model.addAttribute("maxPageNum", maxPageNum);
		}
		model.addAttribute("itemList", list);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("pagett", 1);

		// return "user/itemList";
		return index(model);
	}
	
	@RequestMapping(value = "/pageAll")
	public String pageAll(@RequestParam Integer pageNum,@RequestParam String itemSort,@RequestParam String sortOption, Model model) {
		List<Item> list = repository.findAllBypageNumNotDeletedSort(pageNum, itemSort, sortOption);
		if (repository.MaxId() % 15 == 0) {
			Long maxPageNum = repository.MaxId() / 15;
			model.addAttribute("maxPageNum", maxPageNum);
		} else {
			Long maxPageNum = repository.MaxId() / 15 + 1;
			model.addAttribute("maxPageNum", maxPageNum);
		}
		model.addAttribute("itemList", list);
		model.addAttribute("pageNum", pageNum);
		model.addAttribute("itemSort", itemSort);
		model.addAttribute("sortOptin", sortOption);
		
		// return "user/itemList";
		return index(model);
	}
	

	/**
	 * 商品名検索を行うメソッド.
	 * 
	 * @param useritem
	 *            商品名
	 * @param model
	 * @return userフォルダーのitemList.jsp(商品一覧画面)
	 */
	@RequestMapping(value = "/findByName")
	public String findByName(@RequestParam String useritem, Model model) {

		if (useritem == null || useritem.isEmpty()) {
			return "redirect:/user/item";
		}
		List<Item> list = repository.findByNameAndNotDeleted(useritem);

		if (list.isEmpty()) {
			model.addAttribute("erroritemName", useritem);
			useritem = null;
		}
		model.addAttribute("pageNum", 1);
		model.addAttribute("maxPageNum", pagingNum((long) list.size()));
		model.addAttribute("itemList", list);
		model.addAttribute("itemName", useritem);

		// return "user/itemList";
		return index(model);
	}

	@RequestMapping(value = "/findBySeason")
	public String findByName(Model model) {

		LocalDate Manth = LocalDate.now();
		Manth.getMonth();
		System.out.println(season(String.valueOf(Manth.getMonth())));
		List<Item> list = repository.findBySeasonAndNotDeleted(season(String.valueOf(Manth.getMonth())));

		model.addAttribute("pageNum", 1);
		model.addAttribute("maxPageNum", pagingNum((long) list.size()));
		model.addAttribute("itemList", list);
		/*
		 * model.addAttribute("maxPageNum", pagingNum((long) list.size()));
		 * model.addAttribute("itemList", list);
		 * model.addAttribute("itemName",useritem);
		 */

		// return "user/itemList";
		return index(model);
	}

	public String season(String month) {
		switch (month) {
		case "MARCH":
		case "APRIL":
		case "MAY":
			return "春";
		case "JUNE":
		case "JULY":
		case "AUGUST":
			return "夏";
		case "SEPTEMBER":
		case "OCTOBER":
		case "NOVEMBER":
			return "秋";
		case "DECEMBER":
		case "JANUARY":
		case "FEBRUARU":
			return "冬";

		default:
			break;
		}
		return null;
	}

	/**
	 * 名前検索+ソートを行うメソッド. sortOptionの値が「ASC」でないなら「DESC」に変更する。
	 * 
	 * @param useritem
	 *            商品名
	 * @param itemSort
	 *            ソートの種類
	 * @param sortOption
	 *            昇順か降順
	 * @param model
	 *            全件検索情報
	 * @return 全件検索画面
	 */
	@RequestMapping(value = "/findByNameAndSort")
	public String findByNameAndSort(@RequestParam String useritem, @RequestParam String itemSort,
			@RequestParam String sortOption, Model model) {
		if (sortOption.equals("ASC")) {
			sortOption = "ASC";
		} else {
			sortOption = "DESC";
		}
		if (useritem == null || useritem.isEmpty()) {
			return findBySort(itemSort, sortOption, model);
		}
		List<Item> list = repository.findByNameAndSortNotDeleted(useritem, itemSort, sortOption);
		System.out.println(useritem);
		if (list.isEmpty()) {
			model.addAttribute("erroritemName", useritem);
			useritem = "";
		}
		model.addAttribute("itemList", list);
		model.addAttribute("itemName", useritem);
		model.addAttribute("sortOption", sortOption);
		model.addAttribute("pageNum", 1);
		System.out.println(list.size());
		model.addAttribute("maxPageNum", pagingNum((long) list.size()));

		// return "user/itemList";
		return index(model);
	}

	/**
	 * 全件検索+ソートを行うメソッド.
	 * 
	 * @param itemSort
	 * @param sortOption
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/findBySort")
	public String findBySort(String itemSort, String sortOption, Model model) {
		List<Item> list = repository.findAllBySortAndNotDeleted(itemSort, sortOption);
		model.addAttribute("itemList", list);
		model.addAttribute("sortOption", sortOption);
		model.addAttribute("itemSort", itemSort);
		model.addAttribute("pageNum", 1);
		System.out.println(list.size());
		/*model.addAttribute("maxPageNum", pagingNum((long) list.size()));*/
		//model.addAttribute("maxPageNum", (Long)repository.findByMaxIdAndInitialsAndNotDeleted(itemSort, sortOption));
		model.addAttribute("pageNum", 1);
		model.addAttribute("maxPageNum", pagingNum(repository.MaxId()));
		
		
		// return "user/itemList";
		return index(model);

	}

	/**
	 * 商品詳細を表示させるメソッド. 名前検索+ソートを行うメソッドで商品名がない場合にこのメソッドに遷移する。
	 * 
	 * @param id
	 *            商品id
	 * @param model
	 * @return userフォルダーのitemDetail.jsp(商品詳細画面)
	 */
	@RequestMapping(value = "/itemdetail")
	public String itemdetail(@RequestParam Long id, Model model) {
		Item item = repository.load(id);
		model.addAttribute("item", item);

		return "user/itemDetail";
	}

	@RequestMapping(value = "/itemInitials")
	public String itemInitials(@RequestParam String initials, Model model) {
		List<Item> list = repository.findByInitialsAndNotDeleted(initials);

		if (list.isEmpty()) {
			model.addAttribute("erroritemName", "「" + initials + "」から始まる野菜はありません");
			initials = "";
		}
		model.addAttribute("itemList", list);
		model.addAttribute("pageNum", 1);
		model.addAttribute("maxPageNum", pagingNum((long) list.size()));

		// return "user/itemList";
		return index(model);
	}

	public Long pagingNum(Long long1) {
		if (long1 < 15) {
			return (long) 1;
		}
		if (long1 % 15 == 0) {
			return (long) (long1 / 15);
		} else {
			return (long) (long1 / 15 + 1);
		}
	}

	public Long paging() {
		Long maxPageNum;
		if (repository.MaxId() % 15 == 0) {
			maxPageNum = repository.MaxId() / 15;
		} else {
			maxPageNum = repository.MaxId() / 15 + 1;
		}
		return maxPageNum;
	}

}
