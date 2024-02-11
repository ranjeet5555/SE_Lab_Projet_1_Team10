# DocumentController API Documentation

## Get My Uploads

### Endpoint

- **GET** `/myUploads`

### Description

Retrieves a list of uploaded documents.

### Response

- **Status Code:** 200 OK
- **Body:** List of documents

## Upload Document

### Endpoint

- **POST** `/upload`

### Description

Handles file uploads, saves the document to the database, and adds a flash attribute for a success message.

### Request

- **Parameter:** `document` (MultipartFile) - The uploaded file.

### Response

- **Status Code:** 302 Found (redirect to home)
- **Flash Attribute:** "message" - "The file has been uploaded successfully"

## Download Document

### Endpoint

- **GET** `/download/{id}`

### Description

Downloads a specific document by ID.

### Request

- **Path Variable:** `id` (Long) - Document ID.

### Response

- **Status Code:** 200 OK
- **Body:** Document file as an attachment





# UserController API Documentation

## Home Page

### Endpoint

- *GET* /

### Description

Redirects to the home page.

## Edit User

### Endpoint

- *GET* /edituser/{id}

### Description

Displays the form to edit user details.

### Request

- *Path Variable:* id (int) - User ID to be edited.

### Response

- *Status Code:* 200 OK
- *Body:* Edit user form

## Update User Details

### Endpoint

- *GET* /updateuserDetails

### Description

Updates user details based on the provided form data.

### Request

- *ModelAttribute:* user (User) - User details to be updated.

### Response

- *Status Code:* 302 Found (redirect to home)
- *Session Attribute:* "msg" - "Update successfully" or "something wrong on server"

## Register User

### Endpoint

- *GET* /signup

### Description

Displays the registration form.

### Request

None

### Response

- *Status Code:* 200 OK
- *Body:* Registration form

## Register New User

### Endpoint

- *POST* /registerUser

### Description

Registers a new user.

### Request

- *ModelAttribute:* user (User) - User details to be registered.

### Response

- *Status Code:* 302 Found (redirect to login)

## Login

### Endpoint

- *GET* /login

### Description

Displays the login form.

### Request

None

### Response

- *Status Code:* 200 OK
- *Body:* Login form

## Authenticate User

### Endpoint

- *POST* /signing

### Description

Authenticates the user based on the provided credentials.

### Request

- *ModelAttribute:* user (User) - User credentials for authentication.

### Response

- *Status Code:* 302 Found
  - Redirect to "speaker_Dashboard" if authentication is successful.
  - Redirect to "register" if authentication fails.
