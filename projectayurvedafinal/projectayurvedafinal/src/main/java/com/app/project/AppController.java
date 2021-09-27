package com.app.project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {

	@Autowired
	private UserRepository repo;

	@Autowired
	private UserRepository repodoc;

	@Autowired
	private UserDoctorRepository repo1;

	@Autowired
	private appointmentService service;

	@Autowired
	private LoginAdminService adminService;
	
	@Autowired
	private LoginAdminRepository repodoc1;
	
	@Autowired
	private appointmentRepository repoapp;

	@GetMapping("")
	public String viewHomePage() {
		return "index";
	}

//	@GetMapping("/logindoctor_success")
//	public String showDoctorLogin(Model model) {
//		model.addAttribute("doctor", new UserDoctor());
//		return "doctor_success";
//	}

	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}

	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		repo.save(user);
		return "register_success";
	}

//	@GetMapping("/registerdoctor")
//	public String showRegistrationDoctor(Model model) {
//		model.addAttribute("user", new UserDoctor());
//
//		return "signup_form_doctor";
//	}
//	
//	
//	@PostMapping("/process_registerdoctor")
//	public String processRegistrationDoctor(User user) {
//		repo.save(user);
//		return "doctor_success";
//	}
//	

	@GetMapping("/telecenter")
	public String showRegistrationFormTelecenter(Model model) {
		model.addAttribute("telecenter", new Usertelecenter());

		return "telecenter_form";
	}

	@GetMapping("/telecentermed")
	public String showRegistrationFormTelecenterMed(Model model) {

		return "telecentermed";
	}

	@GetMapping("/payment")
	public String payment(Model model) {

		return "payment";
	}

	@GetMapping("/confirmpay")
	public String confirmpay(Model model, RedirectAttributes redirectAttributes) {

		String message = "Your payment is successfully done !!";
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/add";
	}

	@GetMapping("/order")
	public String order(Model model, RedirectAttributes redirectAttributes) {

		String message = "Your payment is successfully done !!";
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "confirm_order";
	}

	@GetMapping("/registerdoctor")
	public String showRegistrationFormDoctor1(Model model) {
		model.addAttribute("doctor", new UserDoctor());

		return "signup_form_doctor";
	}

	@PostMapping("/process_telecenter")
	public String processRegistrationTelecenter(Usertelecenter telecenter) {
		repo.save(telecenter);
		return "telecenter_success";
	}

	@PostMapping("/process_registerdoctor")
	public String processRegistrationDoctor(UserDoctor doctor) {
		repo.save(doctor);
		return "doctorlogin";
	}

//	@PostMapping("/logindoctor_success")
//	public String processRegistrationlogindoctor(UserDoctor user) {
//		repodoc.save(user);
//		return "shubham";
//	}

//	@PostMapping("/process_doctor")
//	public String processRegistrationDoctor(UserDoctor doctor) {
//		repo.save(doctor);
//		return "abc";
//	}

	@GetMapping("/list_users")
	public String viewUsersList(Model model) {

		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);

		return "patients";
	}

	@GetMapping("/add")
	public String newAppointment(Model model) {
		appointment appointment = new appointment();
		appointment.setConfirmed("Not yet confirmed");
		model.addAttribute("appointment", appointment);
		return "add.html";
	}

	@GetMapping("/save")
	public String saveProduct(@ModelAttribute("appointment") appointment appointment, BindingResult result,
			ModelMap model, RedirectAttributes redirectAttributes) {
		appointment.setConfirmed("Not yet confirmed");
		service.save(appointment);
		String appointmentId = appointment.getAppointment_id().toString();
		String patientName = appointment.getPatientName().toString();
		String doctorName = appointment.getDoctorName().toString();
		String date = appointment.getDate().toString();
		String time = appointment.getTime().toString();
		String message = "Appointment was successfully booked, your id is: " + appointmentId + " Patient Name : "
				+ patientName + " Doctor Name :" + doctorName + " Date :" + date + " Time :" + time;
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		redirectAttributes.addFlashAttribute("appointmentId", appointmentId);
		redirectAttributes.addFlashAttribute("patientName", patientName);
		redirectAttributes.addFlashAttribute("doctorName", doctorName);
		redirectAttributes.addFlashAttribute("date", date);
		redirectAttributes.addFlashAttribute("time", time);
		return "redirect:/list_users";

	}

	@GetMapping("/cancel")
	public String cancel(@ModelAttribute("appointment") appointment appointment, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {
		Integer id = appointment.getAppointment_id();
		service.delete(id);
		String message = "Appointment was successfully canceled!";
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/list_users";

	}

	/*
	 * @GetMapping("/getPatientadmin") public String cancel(@ModelAttribute("User")
	 * User user, BindingResult result, ModelMap model, RedirectAttributes
	 * redirectAttributes ) { Long id = user.getId(); repodoc.delete(id); String
	 * message = "Appointment was successfully canceled!";
	 * redirectAttributes.addFlashAttribute("message", message);
	 * redirectAttributes.addFlashAttribute("alertClass", "alert-success"); return
	 * "showPatientAdmin";
	 * 
	 * 
	 * }
	 */

	@RequestMapping("/confirm")
	public String confirm(@ModelAttribute("appointment") appointment appointment, BindingResult result, ModelMap model,
			RedirectAttributes redirectAttributes) {
		System.out.println(appointment);
		String confirmation = "confirmed";
		Integer id = appointment.getAppointment_id();
		service.setConfirmation(confirmation, id);
		System.out.println(id);
		String message = "Appointment was successfully confirmed!";
		redirectAttributes.addFlashAttribute("message", message);
		redirectAttributes.addFlashAttribute("alertClass", "alert-success");
		return "redirect:/receptionist/receptionistAppointments";

	}

	@GetMapping("/confirmm")
	public String showConfirmm(Model model) {
		appointment confirmation = new appointment();
		model.addAttribute("confirmation", confirmation);
		return "confirm";
	}

	@Autowired
	private LoginService userService;

//	    @GetMapping("/login")
//	           
//	    public ModelAndView login() {
//	    	ModelAndView mav = new ModelAndView("login");
//	        mav.addObject("user", new UserDoctor());
//	        return mav;
//	    }

	@GetMapping("/logindoctor")
	public String showRegistrationFormDoctor(Model model) {
		model.addAttribute("doctor", new UserDoctor());

		return "doctorlogin";
	}

	@PostMapping("/abcd")
	public String login(@ModelAttribute("doctor") UserDoctor doctor) {

		UserDoctor oauthUser = userService.login(doctor.getEmail(), doctor.getPassword());

		System.out.print(doctor.getEmail());
		System.out.print(doctor.getPassword());
		if (Objects.nonNull(oauthUser)) {

			return "logindoctor_success";

		} else {
			return "redirect:/";

		}

	}

	@RequestMapping(value = { "/logout" }, method = RequestMethod.POST)
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/login";
	}

	@GetMapping("/doctors")
	public String showDoctors(Model model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		model.addAttribute("username", username);
		return "logindoctor_success";
	}

	@GetMapping("/findbystart")
	public String showBydate(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String doctorName = auth.getName();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyy/MM/dd");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now).toString());
		List<appointment> appointments = service.findByDate(dtf.format(now).toString(), doctorName);
		model.addAttribute("appointments", appointments);
		return "findbystart";
	}

	@GetMapping("/doctorAppointments")
	public String showRegistrationFormDoctorAppointments(Model model) {

		return "doctorAppointments";
	}

	@GetMapping("/jsoncalendar")
	public String showRegistrationFormJSON(Model model) {

		return "jsoncalendar";
	}

	@GetMapping("/getDoctor")
	public String getUserDoctor(Model m) {
		List<UserDoctor> doctor = new ArrayList<UserDoctor>();
		repo1.findAll().forEach(doctor1 -> doctor.add(doctor1));
		m.addAttribute("doctor", doctor);
		return "showDoctor";
	}

	@GetMapping("/getPatient")
	public String getUser(Model m) {
		List<User> user = new ArrayList<User>();
		repo.findAll().forEach(user1 -> user.add(user1));
		m.addAttribute("user", user);
		return "showPatient";
	}
	
	@GetMapping("/getappointment")
	public String getAppointment(Model m) {
		List<appointment> app = new ArrayList<appointment>();
		repoapp.findAll().forEach(app1 -> app.add(app1));
		m.addAttribute("app", app);
		return "showAppointment";
	}


	@GetMapping("/homepage")
	public String showRegistrationFormHomepage(Model model) {

		return "loginadmin_success";
	}

	/*
	 * @GetMapping("/getDoctoradmin") public String getUserDoctorAdmin(Model m) {
	 * List<UserDoctor> doctor = new ArrayList<UserDoctor>();
	 * repo1.findAll().forEach(doctor1 -> doctor.add(doctor1));
	 * m.addAttribute("doctor", doctor); return "showDoctorAdmin"; }
	 */

	/*
	 * @GetMapping("/getPatientAdmin") public String getUserPatientAdmin(Model m) {
	 * List<UserDoctor> doctor = new ArrayList<UserDoctor>();
	 * repo1.findAll().forEach(doctor1 -> doctor.add(doctor1));
	 * m.addAttribute("doctor", doctor); return "showPatientAdmin"; }
	 */

	@GetMapping("/adminlogin")
	public String showRegistrationFormAdmin(Model model) {
		model.addAttribute("admin", new Admin());

		return "adminlogin";
	}

	@PostMapping("/abcd1")
	public String login(@ModelAttribute("admin") Admin admin) {

		Admin adm = adminService.login(admin.getEmail(), admin.getPassword());

		System.out.print(admin.getEmail());
		System.out.print(admin.getPassword());
		if (Objects.nonNull(adm)) {

			return "loginadmin_success";

		} else {
			return "redirect:/";

		}

	}

	@Autowired
    private UserService service1;
	
	@RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
	public String deletePatient(@PathVariable String id) {
		System.out.println(id);
		Long id1 = Long.parseLong(id);
		service1.delete(id1);
	    return "redirect:/getPatient";       
	}		
	
	@Autowired
    private UserDoctorService service2;
	
	@RequestMapping(value="/deletedoc/{id}",method = RequestMethod.GET)
	public String deleteDoctor(@PathVariable String id) {
		System.out.println(id);
		Long id2 = Long.parseLong(id);
		service2.delete(id2);
	    return "redirect:/getDoctor";       
	}

	
	@GetMapping("/getDoctorAdmin")
	public String getDoctorAdmin(Model m) {
		List<UserDoctor> doctor = new ArrayList<UserDoctor>();
		repo1.findAll().forEach(doctor1 -> doctor.add(doctor1));
		m.addAttribute("doctor", doctor);
		return "showDoctorAdmin";
	}
	
	@GetMapping("/getPatientAdmin")
	public String getPatientAdmin(Model m) {
		List<User> user = new ArrayList<User>();
		repo.findAll().forEach(user1 -> user.add(user1));
		m.addAttribute("user", user);
		return "showPatientAdmin";
	}
	
	@RequestMapping(value="/delete1/{id}",method = RequestMethod.GET)
	public String deletePatientadmin(@PathVariable String id) {
		System.out.println(id);
		Long id1 = Long.parseLong(id);
		service1.delete(id1);
	    return "redirect:/getPatientAdmin";       
	}	
	
	
	@RequestMapping(value="/deletedoc1/{id}",method = RequestMethod.GET)
	public String deleteDoctoradmin(@PathVariable String id) {
		System.out.println(id);
		Long id2 = Long.parseLong(id);
		service2.delete(id2);
	    return "redirect:/getDoctorAdmin";       
	}
	
	@Autowired
    private appointmentService service3;
	
	
	@RequestMapping(value="/deletedoc2/{appointment_id}",method = RequestMethod.GET)
	public String deleteDoctorapp(@PathVariable String appointment_id) {
		System.out.println(appointment_id);
		int id3 = (int) Long.parseLong(appointment_id);
		service3.delete(id3);
	    return "redirect:/getappointment";       
	}
	

	


}
