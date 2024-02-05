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
