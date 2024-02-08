package jp.co.internous.easylogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.easylogin.model.domain.MstUser;
import jp.co.internous.easylogin.model.mapper.MstUserMapper;

@Controller
@RequestMapping("/easylogin")
public class LoginController {
	
	/*@Autowiredを付与して宣言したオブジェクトはSpringBootによって自動的にインスタンス化される。*/
	@Autowired
	private MstUserMapper userMapper;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("login")
	public String login(String userName, String password, Model model) {
		
		//mapperを使ってデータベースにアクセスするという意味。
		MstUser user = userMapper.findByUserNameAndPassword(userName, password);
		
		if (user == null) {
			model.addAttribute("message", "ゲストさん、ようこそ！");
		} else {
			model.addAttribute("message", user.getFullName() + "さん、ようこそ！");
		}
		
		//login.htmlに遷移させる。
		return "login";
	}
}
