# 1. Introduction

## 1.1 Purpose
The purpose of the NITCONF website is to facilitate the submission, evaluation, and selection of papers for the conference. This includes providing a platform for speakers to submit abstracts, a review system for a team of reviewers, and a Program Committee to make final decisions.

## 1.2 Scope
The website will focus on handling the submission and evaluation process for papers related to the NITCONF conference. It will provide a user-friendly interface for speakers, reviewers, and the Program Committee to interact with the system.

# 2. System Architecture
   
## 2.1 Overview
The system will be designed as a web-based application, featuring a front-end for users to interact with, a back-end for data storage and processing, and a secure authentication system for user management.

## 2.2 User Roles
Speaker: Any individual interested in presenting a paper at the conference.
Reviewer: Members of the review team responsible for evaluating submitted papers.
Program Committee: A group of individuals responsible for making the final decision on accepted papers.

# 3. Functional Requirements
   
## 3.1 Call for Papers (CFP)

### 3.1.1 The website will feature a prominent "Call for Papers" (CFP) button on the homepage.

### 3.1.2 Clicking the CFP button will redirect the user to a login page.

## 3.2 User Authentication

### 3.2.1 Users must authenticate themselves to access the submission system.

### 3.2.2 Any user can create an account to become a speaker.

## 3.3 Speaker Submission

### 3.3.1 Authenticated speakers can submit abstracts through a form.

### 3.3.2 The form will include fields for title, abstract, author information, and keywords.

### 3.3.3 Speakers can upload supporting documents, such as research papers or presentations.

## 3.4 Review Process

### 3.4.1 Submitted papers will be assigned to a team of reviewers.

### 3.4.2 Reviewers can evaluate papers based on predefined criteria.

### 3.4.3 Reviewers can provide comments and recommendations.

### 3.4.4 Reviewers can recommend acceptance or rejection of the paper.

## 3.5 Program Committee Decision

### 3.5.1 The Program Committee will have access to reviewed papers.

### 3.5.2 The Committee will make final decisions based on reviewer recommendations.

### 3.5.3 Notifications will be sent to speakers regarding the acceptance or rejection of their papers.

# 4. Non-functional Requirements
   
## 4.1 Security

### 4.1.1 User authentication must be secure and protect user data.

### 4.1.2 The system should have role-based access control to ensure data privacy.

## 4.2 Performance

### 4.2.1 The system should handle simultaneous submissions and reviews efficiently.

### 4.2.2 Response times for user interactions should be minimal.




# 5. Diagrams

5.1 Use Case Diagram

Actors:- 
1. Guest(Doesnt login)
         
2. Speaker
         
3. Reviewer
         
4. Programme Committee/Organizer

   




6. Conclusion
   
The NITCONF website aims to streamline the paper submission and review process for the conference. By implementing the outlined requirements, the system will provide a user-friendly experience for speakers, reviewers, and the Program Committee.
