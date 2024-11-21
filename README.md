# E_Voting_Application

## Overview

The **E_Voting_Application** is a backend project designed to facilitate electronic voting management. This project is built using **Spring Boot** and **Spring Data JPA** and incorporates advanced concepts like derived queries and native queries for efficient database operations. The application uses **MySQL** as its database to store and manage voting-related data.

## Features

- **Voter Management**: Add, update, retrieve, and delete voter information.
- **Candidate and Election Management**: Manage elections, candidates, and voting choices.
- **Vote and Results Processing**: Register votes, count votes, and determine election winners.
- **Query Optimization**: Use native queries and derived queries for optimized database interactions.

## Tech Stack

- **Backend**: Java, Spring Boot
- **Database**: MySQL
- **ORM Framework**: Spring Data JPA
- **Build Tool**: Maven

## Learning Outcomes

- Mastered **Spring Data JPA** for database management.
- Gained experience with **native queries** and **derived queries**.
- Strengthened understanding of **Spring Boot** concepts.
- Hands-on experience with **MySQL** integration.

## Endpoints

### Election Endpoints

- `GET /get/elections`: Retrieve the list of all elections.
- `POST /add/election`: Create a new election.  
  **Request Body**: `Election`

### ElectionChoice Endpoints

- `POST /add/electionChoice`: Add a new election choice.  
  **Request Body**: `ElectionChoice`
- `GET /get/electionChoices`: Fetch the list of all election choices.
- `POST /count/election/choices`: Retrieve the list of all choices for a specific election.  
  **Request Body**: `Election`

### User Endpoints

- `POST /add/user`: Create a new user.  
  **Request Body**: `User`
- `GET /get/users`: Fetch the list of all users.

### Vote Endpoints

- `GET /get/votes`: Fetch the list of all votes.
- `POST /add/vote`: Register a new vote.  
  **Request Body**: `Vote`
- `GET /count/votes`: Fetch the total count of votes.
- `POST /count/election/votes`: Fetch the count of total votes for a specific election.  
  **Request Body**: `Election`

### Results Endpoints

- `POST /winner/election`: Retrieve the winning election choice for a specific election.  
  **Request Body**: `Election`

## Contribution

Feel free to fork this repository and submit pull requests to contribute to the project.

## Contact

For any queries or suggestions, reach out to me at:  
**Email**: [vijaygunjalkara54@gmail.com](mailto:vijaygunjalkara54@gmail.com)  
**LinkedIn**: [Vijay Gunjalkar](https://www.linkedin.com/in/vijay-gunjalkar-6870a11a9/)
