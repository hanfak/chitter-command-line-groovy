# List of things to do

- Use mocks and spies in test, especially for Chitter class
- User helper functions to reduce the amount of duplication in tests

- Create a printer class, to allow for visuals when calling on methods in Chitter class, instead of returning arrays or objects

- Refactor method for Posts#findAUsersFollowersPosts(user), Looks too complicated???
  - Try deleting messages which do not match the users in followers


- Deal with following edge cases
  - If not logged in canot follow a user
  - If not logged in, cannot log out
  - If logged in, cannot login with a different user
  - If user does not exist, no one can follow said user
  - If user does not exist, then cannot view their time line
  - If user does not exist, then cannot view posts by said user
  - If user already exists, then cannot log in
    - Use of password for users
  - Cannot follow themselves
