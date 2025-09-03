package com.learn.chatbot.config;

public class Messages {

	// ==================== Email Messages ====================
    public static final String RESET_PASSWORD = "Reset your password";
    public static final String RESEND_CODE = "A new code was sent";
    public static final String FAILED_EMAIL = "Failed to send email. Please try again later";
	
	// ==================== Auth Messages ==================== 
    public static final String LOGIN_SUCCESS = "Login successfully";
    public static final String CREATE_NEW_USER = "New user created successfully";
    public static final String LOGOUT_SUCCESS = "Logged out successfully";
    public static final String ALREADY_LOGGED_OUT = "You are already logged out";
    public static final String INVALID_CONFIRM_EMAIL = "Invalid confirmation code";
    public static final String CONFIRM_EMAIL_SUCCESS = "Email confirmed successfully";
    public static final String INVALID_PASSWORD = "Current password is incorrect";
    public static final String CHANGE_PASSWORD = "Password changed successfully";
    public static final String CODE_SENT = "Code sent successfully";
    public static final String INVALID_RESET_CODE = "Invalid reset code";
    public static final String EMAIL_ALREADY_EXISTS = "Email already exists";
    public static final String USERNAME_ALREADY_EXISTS = "Username already exists";
    public static final String BAD_CREDENTIALS = "Invalid username or password";
    public static final String AUTH_FAILED = "Authentication failed";
    public static final String REQUEST_NOT_SUPPORTED = "Request method not supported";
    public static final String NOT_SALES_EMPLOYEE = "User does not have SALES_EMPLOYEE role.";
    public static final String NOT_PURCHASES_EMPLOYEE = "User does not have PURCHASING_OFFICER role.";
    
	// ==================== Token Messages ====================
    public static final String INVALID_REFRESH_TOKEN = "Invalid or missing refresh token";
    public static final String NEW_TOKEN_GENERATED = "New token generated successfully";
    public static final String COULD_NOT_EXTRACT_USER = "Unable to extract username from token";
    public static final String TOKEN_NOT_FOUND = "Token not found or invalid";
    public static final String TOKEN_EXPIRED_OR_REVOKED = "Token expired or revoked";
    public static final String SESSION_EXPIRED = "Your session has expired. Please login again";
    public static final String ACCESS_DENIED = "You do not have permission to access this resource";
    public static final String MISSING_TOKEN = "JWT token is missing";
    
	// ==================== User Messages ==================== 
    public static final String USER_NOT_FOUND = "User not found";
    public static final String USERNAME_NOT_FOUND = "User not found with username or email: ";
    public static final String USER_NOT_AUTHENTICATED = "User not authenticated";
    public static final String CHANGE_ROLES_ERROR = "Invalid role. Please provide one of: ADMIN, CUSTOMER, etc.";
    public static final String USER_UPDATE_PROFILE = "User role updated successfully";
    public static final String USER_UPDATE_IMAGE = "User image updated successfully";
    public static final String DELETE_USER = "User deleted successfully";
    public static final String UPDATE_USER = "User updated successfully";
    
	// ==================== Department Messages ====================
    public static final String DEPARTMENT_NOT_FOUND = "Department not found";
    public static final String DEPARTMENT_ALREADY_EXISTS = "Department with this name already exist";
    public static final String DEPARTMENT_UPDATE= "Department updated successfully";
    public static final String DELETE_DEPARTMENT = "Department deleted successfully";
    public static final String ADD_DEPARTMENT = "Department added successfully";
    public static final String CANNOT_DELETE_DEPARTMENT = "Cannot delete department with assigned users.";
	
	// ==================== Error Messages ====================
    public static final String FORMAT_ERROR = "Malformed JSON request";
    public static final String INVALID_DATA = "Invalid data. Please check your request body";
    
	// ==================== Category Messages ==================== 
    public static final String CATEGORY_NOT_FOUND = "Category not found";
    public static final String PARENT_CATEGORY_NOT_FOUND = "Parent category not found";
    public static final String CATEGORY_ALREADY_EXISTS = "Category with this name already exists";
    public static final String DELETE_CATEGORY = "Category deleted successfully";
    public static final String ADD_CATEGORY = "Category added successfully";
    public static final String UPDATE_CATEGORY = "Category updated successfully";
    
	// ==================== Product Messages ==================== 
    public static final String PRODUCT_NOT_FOUND = "Product not found";
    public static final String DELETE_PRODUCT = "Product deleted successfully";
    public static final String ADD_PRODUCT = "Product added successfully";
    public static final String UPDATE_PRODUCT = "Product updated successfully";
    public static final String NOT_ENOUGH_STOCK ="Not enough stock for product: ";
    
	// ==================== Image Messages ====================
    public static final String EMPTY_IMAGE = "Image file is empty or null";
    public static final String UPLOAD_IMAGE_FAILED = "Error occurred while uploading image";
    
	// ==================== Employee Messages ====================   
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found";
    public static final String DELETE_EMPLOYEE = "Employee deleted successfully";
    public static final String UPDATE_EMPLOYEE = "Employee updated successfully";
    public static final String ADD_EMPLOYEE = "Employee added successfully";
    public static final String EMPLOYEE_ALREADY_EXISTS = "Employee details already exist for this user.";
    
    // ==================== Attendance Messages ==================== 
    public static final String USER_ALREADY_CHECKIN = "User already checked in today";
    public static final String USER_ALREADY_CHECK_OUT = "User already checked out today";
    public static final String MUST_CHECKIN = "You must check in before checking out";
    public static final String CHECK_IN = "Check-in successful";
    public static final String CHECK_OUT = "Check-out successful";
    
    // ==================== Leave Request Messages ====================  
    public static final String REQUEST_NOT_FOUND = "Leave request not found";
    public static final String LEAVE_REQUEST_SUBMITTED = "Leave request submitted successfully.";
    public static final String LEAVE_REQUEST_STATUS_UPDATED = "Leave request status updated.";
    public static final String LEAVE_REQUEST_STATUS_ALREADY_UPDATED = "Leave request status already updated.";
    public static final String USER_HAVE_PEMDING_REQUEST = "You already have a pending leave request in this period.";
    public static final String ERROR_DATE = "Start date must be before or equal to end date.";
    
    // ==================== Inventory Messages ==================== 
    public static final String STOCK_UPDATED = "Stock updated";
    public static final String CREATE_PRODUCT = "Initial product creation";
    
	// ==================== Salary Messages ==================== 
    public static final String SALARY_NOT_FOUND = "Salary not found";
    public static final String ADD_SALARY = "Salary added successfully";
    public static final String UPDATE_SALARY = "Salary updated successfully";
    public static final String SALARY_ALREADY_EXISTS = "This user already has a salary record.";
    
	// ==================== Bonus Messages ====================  
    public static final String BONUS_NOT_FOUND = "Bonus not found";
    public static final String ADD_BONUS = "Bonus added successfully";
    public static final String DELETE_BONUS = "Bonus deleted successfully";
    
    // ==================== Payroll Messages ====================
    public static final String PAYROLL_ALREADY_EXISTS = "Payroll already exists for user: ";
    public static final String PAYROLL_NOT_FOUND = "No payroll found for this user at the given month/year";
    public static final String GENERATE_PAYROLL = "Payroll generated successfully";
    
	// ==================== Customer Messages ====================
    public static final String CUSTOMER_NOT_FOUND = "Customer not found";
    public static final String ADD_CUSTOMER = "Customer Added successfully";
    public static final String DELETE_CUSTOMER = "Customer deleted successfully";
    public static final String UPDATE_CUSTOMER = "Customer updated successfully";
    public static final String CUSTOMER_ALREADY_EXISTS = "Customer with this email already exists.";
    
	// ==================== Supplier Messages ==================== 
    public static final String SUPPLIER_NOT_FOUND = "Supplier not found";
    public static final String ADD_SUPPLIER = "Supplier Added successfully";
    public static final String DELETE_SUPPLIER = "Supplier deleted successfully";
    public static final String UPDATE_SUPPLIER = "Supplier updated successfully";
    public static final String SUPPLIER_ALREADY_EXISTS = "Supplier with this email already exists.";

	// ==================== Sale Messages ====================  
    public static final String SALE_NOT_FOUND = "Sale not found";
    public static final String ADD_SALE = "Sale Added successfully";
    
	// ==================== Purchase Messages ====================  
    public static final String PURCHASE_NOT_FOUND = "Purchase not found";
    public static final String ADD_PURCHASE = "Purchase Added successfully";
    
    // ==================== Conversation Messages ====================  
    public static final String CONVERSATION_ALREADY_EXISTS = "Conversation with this name already exists";
    public static final String CONVERSATION_NOT_FOUND = "Conversation not found";
    public static final String DELETE_CONVERSATION = "Conversation deleted successfully";
    public static final String ADD_CONVERSATION = "Conversation Added successfully";
    public static final String CONVERSATION_NOT_BELONG_TO_USER = "Conversation does not belong to this user";
    public static final String CONVERSATIONS_FETCHED = "Conversations fetched successfully";
    public static final String CONVERSATION_HISTORY_FETCHED = "Conversation history fetched successfully";


}