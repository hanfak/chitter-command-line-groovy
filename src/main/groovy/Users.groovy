class Users {
  private def activeUser
  private def listOfUsers
  private def userKlass

  def Users(Class userClass = User) {
    this.activeUser = null
    this.listOfUsers = []
    this.userKlass = userClass
  }

  def getLoggedInUser() {
    this.activeUser
  }

  def getListofUsers() {
    this.listOfUsers
  }

  def loginUser(name) {
    def aUser = this.userKlass.newInstance(name)

    if(findUser(aUser)) {
      this.activeUser = findUser(aUser)
    } else {
      this.activeUser = aUser
      this.listOfUsers.push(aUser)
    }
  }

  def logOutUser() {
    this.activeUser = null
  }

  def followAUser(name) {
    def userToFollow = this.lookForUser(name)
    if(!userToFollow) {
      throw new UserDoesNotExistException('User not follower: User must exist first')
    }
    getLoggedInUser().addFollower(userToFollow)
  } 

  private def lookForUser(name) {
    this.listOfUsers.find {it.getName() == name}
  }

  private def findUser(user) {
    this.listOfUsers.find { it.getName() == user.getName()}
  }
}

class UserDoesNotExistException extends Exception {
  UserDoesNotExistException(String message) {
    super(message)
  }
}
