package jp.co.rakus.ec201804b.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jp.co.rakus.ec201804b.domain.Item;
import jp.co.rakus.ec201804b.form.ItemForm;
import jp.co.rakus.ec201804b.repository.ItemRepository;

@Controller
@RequestMapping("/menu")
public class AdminMenuController {
	@Autowired
	private ItemRepository repository;
	
	@Autowired
	private ServletContext application;
	
	@ModelAttribute
	public ItemForm setUpFrom() {
		return new ItemForm();
	}

	@RequestMapping("/")
	public String index() {
		return "administer/menu";
	}
	
	@RequestMapping("/regist")
	public String regist() {
		return "administer/itemRegist";
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
	
	@RequestMapping(value = "/itemContent")
	public String itemeContent(@RequestParam Long id,Model model) {
		Item itemContent = repository.load(id);
		model.addAttribute("itemContent", itemContent);
		return "administer/itemeEdit";
	}
	
	@RequestMapping(value = "/itemeEdit")
	public String itemeEdit(@Validated ItemForm form, BindingResult result, Model model) {
		
//		if (result.hasErrors()) {
//			System.out.println("00000000000000000000");
//			return itemeContent(form.getId(),model);
//		}
		Item item = new Item();
		System.out.println(form.getDeleted());
		BeanUtils.copyProperties(form, item);
		System.out.println(item.getDeleted());
		/** 画像の処理を行う */
		MultipartFile imageFile = form.getImagePath();
		if(imageFile.isEmpty()){
			model.addAttribute("imageError","画像は必須です");
			return  itemeContent(form.getId(),model);
		}
		// ファイルの名前を取得
		String filename = imageFile.getOriginalFilename();
		// 画像を保存する
		try {
			String destPath = application.getRealPath("/img/" + filename);
			File destFile = new File(destPath);
			imageFile.transferTo(destFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return itemeContent(form.getId(),model);
		} catch (IOException e) {
			e.printStackTrace();
			return  itemeContent(form.getId(),model);
		}
		// 画像のパスをセットする
		item.setImagePath(filename);
		repository.itemupdate(item);
		return  listview(model);
//		return itemeContent(form.getId(),model);
//		return "administer/itemContent";
	}
	
	@RequestMapping(value = "/viewItemInsert")
	public String itemeContent() {
		return "administer/itemRegist";
	}
	@RequestMapping(value = "/itemInsert")
	public String itemInsert(@Validated ItemForm form, BindingResult result, Model model) {
		
//		if (result.hasErrors()) {
//			System.out.println("00000000000000000000");
//			return itemeContent(form.getId(),model);
//		}
		Item item = new Item();
		BeanUtils.copyProperties(form, item);
		/** 画像の処理を行う */
		MultipartFile imageFile = form.getImagePath();
		if(imageFile.isEmpty()){
			model.addAttribute("imageError","画像は必須です");
			return  itemeContent(form.getId(),model);
		}
		// ファイルの名前を取得
		String filename = imageFile.getOriginalFilename();
		// 画像を保存する
		try {
			String destPath = application.getRealPath("/img/" + filename);
			File destFile = new File(destPath);
			imageFile.transferTo(destFile);
		} catch (IllegalStateException e) {
			e.printStackTrace();
			return itemeContent(form.getId(),model);
		} catch (IOException e) {
			e.printStackTrace();
			return  itemeContent(form.getId(),model);
		}
		// 画像のパスをセットする
		item.setImagePath(filename);
		repository.itemInsert(item);
		return  listview(model);
//		return itemeContent(form.getId(),model);
//		return "administer/itemContent";
	}
	
}
