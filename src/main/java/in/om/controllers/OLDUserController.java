package in.om.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.om.utility.ApplicationConstants;

import io.swagger.annotations.Api;

@RestController
@RequestMapping(ApplicationConstants.USER_API_PRIFIX +"/olduser")
@Api(tags = "User", value = "/olduser")
public class OLDUserController {

//	private final OLDUserServprivate final UserNotificationService userNotificationService;ice userService;
//	private final PasswordEncoder passwordEncoder;
//
//
//	@Autowired
//	public OLDUserController(OLDUserService userService, PasswordEncoder passwordEncoder, UserNotificationService userNotificationService) {
//		this.userService = userService;
//		this.passwordEncoder = passwordEncoder;
//		this.userNotificationService = userNotificationService;
//	}
//
//	@ApiOperation(value = "Save or Update User", response = OLDUser.class)
//    @PostMapping("/save")
//    public ResponseEntity<?> saveUser(@Valid @RequestBody OLDUser user) {
//		Optional<OLDUser> optional = userService.findADByUserName(user.getUsername(), user.getPhone());
//		if(optional.isPresent() && user.getUserId() == 0) {
//			return ResponseEntity.ok(new ApiResponse(false, ApplicationConstants.EXIST_KEY, Translator.toLocale("user.name.exist"), HttpStatus.FOUND.value(), null));
//		} else {
//			String password = null;
//			Long userId = user.getUserId();
//			if(user.getUserId() <= 0) {
//				if(user.getIsAdmin()) {
//					password = passwordEncoder.encode("admin");
//					user.setActive(Boolean.TRUE);
//				} else {
//					password = passwordEncoder.encode("test");
//					user.setActive(Boolean.TRUE);
//				}
//			} else {
//				if(optional.isPresent())
//					password = optional.get().getPassword();
//				else
//					password = user.getPhone();
//			}
//			user.setPassword(password);
//			OLDUser result = userService.update(user);
//			if(userId == 0) {
//				userNotificationService.sendNewRegistrationMail(user.getUsername(), result.getFullName());
//			}
//			String msg = user.getUserId() <= 0 ? ApplicationConstants.ADDED_KEY : ApplicationConstants.UPDATED_KEY;
//			String description = user.getUserId() <= 0 ? Translator.toLocale("user.added.success") : Translator.toLocale("user.updated.success");
//
//			DataFilter dataFilter = new DataFilter();
//			dataFilter.setFirstResult(0);
//			dataFilter.setMaxResults(10);
//			ResultFilterResponce resultFilterResponce = userService.findAll(dataFilter, ApplicationConstants.STATUS_ALL, user.getIsAdmin());
//			return ResponseEntity.ok(new ApiResponse(true, msg, description  , HttpStatus.CREATED.value(), resultFilterResponce));
//		}
//    }
//
//	@ApiOperation(value = "Update profile", response = OLDUser.class)
//    @PostMapping("/profile")
//    public ResponseEntity<?> updateUserProfile(@Valid @RequestBody OLDUser user) {
//		Optional<OLDUser> optional = userService.findADById(user.getUserId());
//		if(optional.isPresent()) {
//			OLDUser userObj = optional.get();
//			userObj.setFirstName(user.getFirstName());
//			userObj.setLastName(user.getLastName());
//			userObj.setUsername(user.getUsername());
//			userObj = userService.update(userObj);
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.UPDATED_KEY, Translator.toLocale("user.profile.update.success"), HttpStatus.CREATED.value(), userObj));
//		} else {
//			return ResponseEntity.ok(new ApiResponse(false, ApplicationConstants.NOT_FOUND_KEY, Translator.toLocale("user.not.exist"), HttpStatus.NOT_FOUND.value(), null));
//		}
//    }
//
//	@ApiOperation(value = "Get All User", response = OLDUser.class, responseContainer="List")
//	@GetMapping("/users/list/{status}")
//	public ResponseEntity<?> getAllUser(@ApiParam(name = "status", value = "A = Active, I = InActive, AL = All", required = true) @PathVariable String status) {
//		if(status.equals(ApplicationConstants.STATUS_ACTIVE) || status.equals(ApplicationConstants.STATUS_INACTIVE) || status.equals(ApplicationConstants.STATUS_ALL)){
//			List<OLDUser> userList  = userService.findAll(status);
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.GET_KEY, Translator.toLocale("user.get.all"), HttpStatus.OK.value(), userList));
//		} else {
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.NOT_FOUND_KEY, Translator.toLocale("user.status.not.found"), HttpStatus.NOT_FOUND.value(), null));
//		}
//	}
//
//	@ApiOperation(value = "Get Login User By Token", response = OLDUser.class, responseContainer = "List")
//	@GetMapping("/login/details")
//	public ResponseEntity<?> getLoginUserByToken() {
//		Optional<OLDUser> user = userService.getLoginUser();
//		if (user.isPresent()) {
//			Map<String, Object> userMap = new HashMap<String,Object>();
//			userMap.put("user", user.get());
//			userMap.put("prilePic", userService.getProfilePicture(user.get().getUserId()));
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.GET_KEY, Translator.toLocale("user.login.user"), HttpStatus.OK.value(), userMap));
//		} else {
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.NOT_FOUND_KEY, Translator.toLocale("user.not.found"), HttpStatus.NOT_FOUND.value(), null));
//		}
//	}
//
//	@ApiOperation(value = "Upload user profile", response = FileResponse.class)
//	@PostMapping("/upload/profile")
//    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
//        OLDUser user = userService.getLoginUser().get();
//        FileResponse fileResponse;
//		try {
//			fileResponse = userService.updateProfilePicture(file, user.getUserId());
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.ADDED_KEY, Translator.toLocale("user.profile.upload.success"), HttpStatus.OK.value(), fileResponse));
//		} catch (FileNotFoundException e) {
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.NOT_FOUND_KEY, Translator.toLocale("user.profile.upload.fail"), HttpStatus.NOT_FOUND.value(), e.getMessage()));
//		} catch (IOException e) {
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.NOT_FOUND_KEY, Translator.toLocale("user.profile.upload.fail"), HttpStatus.NOT_FOUND.value(), e.getMessage()));
//		}
//    }
//
//	@ApiOperation(value = "Remove user profile", response = ApiResponse.class)
//	@DeleteMapping("/remove/profile")
//    public ResponseEntity<?> removeProfile() {
//        OLDUser user = userService.getLoginUser().get();
//        Boolean status = userService.removeProfilePicture(user.getUserId());
//        if(status){
//        	return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.DELETED_KEY, Translator.toLocale("user.profile.remove.success"), HttpStatus.OK.value(), status));
//        } else {
//        	return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.NOT_FOUND_KEY, Translator.toLocale("user.profile.remove.fail"), HttpStatus.NOT_FOUND.value(), status));
//        }
//    }
//
//	@ApiOperation(value = "Get User", response = OLDUser.class)
//	@GetMapping("/{userId}")
//	public ResponseEntity<?> get(@PathVariable Long userId) {
//		Optional<OLDUser> userObj = userService.findADById(userId);
//		if(userObj.isPresent()){
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.GET_KEY, Translator.toLocale("user.view"), HttpStatus.OK.value(), userObj.get()));
//		}else{
//			return ResponseEntity.ok(new ApiResponse(false, ApplicationConstants.NOT_FOUND_KEY, Translator.toLocale("user.not.exist"), HttpStatus.NOT_FOUND.value(), null));
//		}
//	}
//
//	@ApiOperation(value = "Check User Exist Or Not", response = ApiResponse.class)
//	@PostMapping("/check")
//	public ResponseEntity<?> checkByEmail(@RequestParam("email") String userName){
//		Optional<OLDUser> optional = userService.findByEmail(userName);
//		Map<String, Boolean> map = new HashMap<String, Boolean>();
//		if(optional.isPresent()){
//			map.put(ApplicationConstants.IS_EXIST, Boolean.TRUE);
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.EXIST_KEY, Translator.toLocale("user.email.exist"), HttpStatus.FOUND.value(), map));
//		} else {
//			map.put(ApplicationConstants.IS_EXIST, Boolean.FALSE);
//			return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.NOT_FOUND_KEY, Translator.toLocale("user.not.found"), HttpStatus.NOT_FOUND.value(), map));
//		}
//	}
//
//	@ApiOperation(value = "Get All Admin Users", response = ResultFilterResponce.class)
//	@PostMapping("/admin/filter/{status}")
//	public ResponseEntity<?> getAllAdmin(@ApiParam(name = "status", value = "A = Active, I = InActive, AL = All", required = true) @PathVariable String status, @RequestBody DataFilter resultFilter) {
//		ResultFilterResponce resultFilterResponce = userService.findAll(resultFilter, status, Boolean.TRUE);
//		return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.GET_KEY, Translator.toLocale("user.get.all"), HttpStatus.OK.value(), resultFilterResponce));
//	}
//
//	@ApiOperation(value = "Get All Customer Users", response = ResultFilterResponce.class)
//	@PostMapping("/customer/filter/{status}")
//	public ResponseEntity<?> getAllCustomer(@ApiParam(name = "status", value = "A = Active, I = InActive, AL = All", required = true) @PathVariable String status, @RequestBody DataFilter resultFilter) {
//		ResultFilterResponce resultFilterResponce = userService.findAll(resultFilter, status, Boolean.FALSE);
//		return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.GET_KEY, Translator.toLocale("user.get.all"), HttpStatus.OK.value(), resultFilterResponce));
//	}
//
//	@ApiOperation(value = "Get All Customer Users", response = OLDUser.class)
//	@GetMapping("/all/customer")
//	public ResponseEntity<?> getAllCustomers() {
//		DataFilter resultFilter = new DataFilter();
//		resultFilter.setFirstResult(0);
//		resultFilter.setMaxResults(Integer.MAX_VALUE);
//		ResultFilterResponce resultFilterResponce = userService.findAll(resultFilter, ApplicationConstants.STATUS_ACTIVE, Boolean.FALSE);
//		return ResponseEntity.ok(new ApiResponse(true, ApplicationConstants.GET_KEY, Translator.toLocale("user.get.all"), HttpStatus.OK.value(), resultFilterResponce.getResult()));
//	}
//
//	@ApiOperation(value = "Reset Password", response = ApiResponse.class)
//	@GetMapping("/reset/{userId}/{password}")
//	public ResponseEntity<?> resetPassword(@PathVariable Long userId, @PathVariable String password) {
//		Optional<OLDUser> userObj = userService.findADById(userId);
//		if(userObj.isPresent()) {
//			OLDUser user = userObj.get();
//			user.setPassword(passwordEncoder.encode(password));
//			userService.update(user);
//			return ResponseEntity.ok(new ApiResponse(true,ApplicationConstants.UPDATED_KEY,Translator.toLocale("user.password.changed.success"), HttpStatus.OK.value(), null));
//		} else {
//			return ResponseEntity.ok(new ApiResponse(true,ApplicationConstants.NOT_FOUND_KEY,Translator.toLocale("user.not.found"), HttpStatus.NOT_FOUND.value(), null));
//		}
//	}
	
}
