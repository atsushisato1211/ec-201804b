package jp.co.rakus.ec201804b.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jp.co.rakus.ec201804b.domain.Order;
import jp.co.rakus.ec201804b.form.OrderDetailForm;
import jp.co.rakus.ec201804b.repository.OrderRepository;

@Controller
@RequestMapping("/admin")
public class OrderItemDetailController {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	HttpSession session;

	@ModelAttribute
	public OrderDetailForm setUpForm() {
		return new OrderDetailForm();
	}
	
	
	public Map<Integer, String> mapCreate(){
		Map<Integer, String> map = new LinkedHashMap<>();
		map.put(1, "未入金");
		map.put(2, "入金済み");
		map.put(3, "発送済み");
		map.put(4, "キャンセル");
		return map;
	}

	@RequestMapping("/orderDetail")
	public String orderDetail(@RequestParam long id, Model model) {
		Order order = orderRepository.load(id);

		
		Map<Integer, String> statusMap = mapCreate();
		String value = statusMap.get(order.getStatus());
		
		session.setAttribute("value", value);
		session.setAttribute("order", order);
		return "administer/viewOrderDetail";
	}

	@RequestMapping(value="/updateStatus")
	public String viewOrderDetail(@RequestParam Long id,OrderDetailForm form,RedirectAttributes redirect,Model model) {
		int status=Integer.parseInt(form.getStatus());
		orderRepository.update(status,id);
		String str = "更新されました。";
		redirect.addFlashAttribute("update", str);
		return "redirect:/admin/orderDetail?id="+id;
	}

}
