package com.rdfgroup.example.admin.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.rdfgroup.example.admin.service.AdminService;
import com.rdfgroup.example.common.domain.LogEntry;
import com.rdfgroup.example.common.domain.Setting;
import com.rdfgroup.example.common.model.SettingModel;
import com.rdfgroup.example.common.service.AuditService;
import com.stack.controller.BaseMVCController;
import com.stack.domain.Role;
import com.stack.domain.User;
import com.stack.services.service.UserService;

/**
 * Handles requests for the users page.
 */
@Controller
@Secured("ROLE_Admin")
public class AdminController extends BaseMVCController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AuditService auditService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	DozerBeanMapper mapper;
	
	public void setMapper(DozerBeanMapper mapper) {
		this.mapper = mapper;
	}

	public void setAdminService(AdminService adminService) {
		this.adminService = adminService;
	}
	
	public void setAuditService(AuditService auditService) {  
		this.auditService = auditService;
	}
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	// ############ Editing Settings ##################

	@RequestMapping(value="/admin/settings", method = RequestMethod.GET)
	public String settings(Model model) {
		List<Setting> settings = adminService.getSettings();
		model.addAttribute("settings", settings);
		return "admin/settings"; 
	}
	
	@RequestMapping(value="/admin/editSetting", method = RequestMethod.GET)
	public String editSetting(@RequestParam String id, Model model) {
		Setting setting = adminService.getSetting(id);
		SettingModel s = mapper.map(setting, SettingModel.class);
		model.addAttribute("setting", s);
		return "admin/setting";
	}
	
	@RequestMapping(value="/admin/deleteSetting", method = RequestMethod.GET)
	public String deleteSetting(@RequestParam String id, Model model) {
		Setting setting = adminService.getSetting(id);
		adminService.deleteSetting(id);
		auditService.info(String.format("SettingModel %s deleted", setting.getName()));
		return "redirect:settings";
	}
	
	@RequestMapping(value = "/newSetting", method = RequestMethod.GET)
	public String newSettings(Model model) {
		model.addAttribute("setting", new Setting());
		return "admin/setting";
	}

	@RequestMapping(value="/admin/saveSetting", method = RequestMethod.POST)
	public String saveSetting(  @ModelAttribute("setting") SettingModel setting, BindingResult result) {
		if (StringUtils.isBlank(setting.getId())) {
			// If coming from a new setting the id is set as a hidden field and should remain null.
			setting.setId(null);
		}
		Setting s = mapper.map(setting, Setting.class);
		adminService.saveSetting(s);
		auditService.info(String.format("SettingModel %s saved with value <%s>", setting.getName(), setting.getValue())); 
		return "redirect:settings";
	}
	
	// ############ Viewing logs ##################
	@RequestMapping(value="/admin/logs", method = RequestMethod.GET)
	public String getJobStatus(Model model) {
		List<LogEntry> logs = auditService.getLogs(); 
		model.addAttribute("logs", logs);
		return "admin/logs";
	}


	@RequestMapping(value="/admin/clearLogs", method = RequestMethod.GET)
	public String clearTaskStatus(Model model) {
		auditService.clearLogs();
		auditService.info("Logs have been cleared");
		return "redirect:logs";
	}
	
	// ############ User Management ##################
	@RequestMapping(value="/admin/users", method = RequestMethod.GET)
	public String getUsers(Model model) {
		model.addAttribute("users", userService.getUsers());
		return "admin/users";
	}
	
	@RequestMapping(value="/admin/user", method = RequestMethod.GET)
	public String getUser(@RequestParam String id, Model model) {
		User user = userService.getUser(id);
		user.setPassword("");
		model.addAttribute("user", user);
		return "admin/user";
	}

	@RequestMapping(value="/admin/saveUser", method = RequestMethod.POST)
	public String saveUser(  @ModelAttribute("user") User user,	BindingResult result) {
		userService.updateUser(user);
		auditService.info(String.format("User %s saved/updated with roles %s", user.getEmail(), user.getRoles()));
		return "redirect:users";
	}
	
	@RequestMapping(value="/admin/deleteUser", method = RequestMethod.GET)
	public String deleteUser(@RequestParam String id) {
		User user = userService.getUser(id);
		userService.deleteUser(id);
		auditService.info(String.format("User %s deleted", user.getEmail()));
		return "redirect:users";
	}
	
	@RequestMapping(value="/admin/newUser", method = RequestMethod.GET)
	public String newUser(Model model) {
		User user = new User();
		user.getRoles().add(Role.User);
		model.addAttribute("user", user);
		auditService.info("Creating a new user");
		return "admin/user";
	}
	

	
	@ModelAttribute("roles")
	public Map<String,String> populateRoles() {
		
		//Data referencing for java skills list box
		Map<String,String> types = new LinkedHashMap<String,String>();
		Role[] values = Role.values();
		for (Role role : values) {
			types.put(role.name(), role.name());
		}
		return types;
	}
	
}
